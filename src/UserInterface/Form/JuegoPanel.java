package UserInterface.Form;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import BusinessLogic.JuegoBL;
import DataAccess.DTO.PuntajeDTO;
import UserInterface.CustomerControl.PoliButton;
import UserInterface.CustomerControl.PoliLabel;
import UserInterface.PoliCursoStyle;

public class JuegoPanel extends JPanel {
    private PoliButton btnNum1, btnNum2;
    private PoliLabel lblAciertos, lblErrores;
    private PoliLabel lblMensaje, lblRonda;
    private MainForm mainForm;
    private int num1, num2;
    private int aciertos = 0;
    private int errores = 0;
    private int rondaActual = 1;
    private final int TOTAL_RONDAS = 10;
    private JuegoBL juegoBL = new JuegoBL();

    public JuegoPanel(MainForm mainForm) {
        this.mainForm = mainForm; // Inicializar la referencia
        customizeComponent(mainForm);
    }


    private void customizeComponent(MainForm mainForm) {
        this.mainForm = mainForm;
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        
        // Panel Superior
        JPanel panelSuperior = new JPanel(new GridLayout(1, 2));
        PoliLabel lblTitulo = new PoliLabel("¿Cuál es Mayor?");
        lblTitulo.setFont(PoliCursoStyle.FONT_BOLD.deriveFont(24f));
        lblRonda = new PoliLabel("Ronda: 1/" + TOTAL_RONDAS);
        lblRonda.setFont(PoliCursoStyle.FONT_BOLD.deriveFont(18f));
        panelSuperior.add(lblTitulo);
        panelSuperior.add(lblRonda);
        add(panelSuperior, BorderLayout.NORTH);
        
        // Panel Central
        JPanel panelNumeros = new JPanel(new GridLayout(1, 2, 20, 20));
        panelNumeros.setBackground(Color.WHITE);
        
        btnNum1 = crearBotonNumero();
        btnNum2 = crearBotonNumero();
        
        panelNumeros.add(btnNum1);
        panelNumeros.add(btnNum2);
        add(panelNumeros, BorderLayout.CENTER);
        
        // Panel Inferior
        JPanel panelContadores = new JPanel(new GridLayout(1, 2));
    
        lblAciertos = new PoliLabel("Aciertos: 0");
        lblAciertos.setForeground(Color.GREEN); // Color verde
        
        lblErrores = new PoliLabel("Errores: 0");
        lblErrores.setForeground(Color.RED); // Color rojo
        
        panelContadores.add(lblAciertos);
        panelContadores.add(lblErrores);
        
        add(panelContadores, BorderLayout.SOUTH); // Reemplazar el panelInfo
        
        // Panel Inferior (Mensajes)
        JPanel panelMensajes = new JPanel();
        lblMensaje = new PoliLabel("Selecciona el número mayor"); // Inicializa aquí
        lblMensaje.setFont(PoliCursoStyle.FONT_BOLD.deriveFont(16f));
        panelMensajes.add(lblMensaje);
        add(panelMensajes, BorderLayout.SOUTH);
    
        nuevoJuego();
    }

    private PoliButton crearBotonNumero() {
        PoliButton btn = new PoliButton("nada");
        btn.setPreferredSize(new Dimension(150, 150));
        btn.setFont(PoliCursoStyle.FONT_BOLD.deriveFont(48f));
        btn.setCursor(PoliCursoStyle.CURSOR_HAND);
        btn.addActionListener(this::verificarRespuesta);
        return btn;
    }

    private void nuevoJuego() {
        num1 = generarNumeroAleatorio();
        num2 = generarNumeroAleatorio();
        while(num1 == num2) num2 = generarNumeroAleatorio();
        
        btnNum1.setText(String.valueOf(num1));
        btnNum2.setText(String.valueOf(num2));
        lblMensaje.setText("Selecciona el número mayor");
        lblMensaje.setForeground(PoliCursoStyle.COLOR_FONT);
    }

    private void verificarRespuesta(ActionEvent e) {
        PoliButton btnSeleccionado = (PoliButton) e.getSource();
        int seleccion = Integer.parseInt(btnSeleccionado.getText());
        int otroNumero = (btnSeleccionado == btnNum1) ? num2 : num1;
        
        if(seleccion > otroNumero) {
            aciertos++;
            lblAciertos.setText("Aciertos: " + aciertos);
            lblMensaje.setText("¡Correcto!");
            lblMensaje.setForeground(Color.GREEN);
        } else {
            errores++;
            lblErrores.setText("Errores: " + errores);
            lblMensaje.setText("Incorrecto. Intenta de nuevo");
            lblMensaje.setForeground(Color.RED);
        }
    
        rondaActual++; // Incrementar la ronda aquí
        
        if (rondaActual <= TOTAL_RONDAS) {
            lblRonda.setText("Ronda: " + rondaActual + "/" + TOTAL_RONDAS);
            nuevoJuego();
        } else {
            guardarPartida();
            mostrarResultados();
            mainForm.mostrarPanel("menu");
        }
    }

    private void guardarPartida() {
        try {
            
            if (mainForm.getUsuarioActual() == null) {
                throw new Exception("Usuario no autenticado");
            }
            
            PuntajeDTO puntaje = new PuntajeDTO(
                mainForm.getUsuarioActual().getIdUsuario(),
                "",
                aciertos,
                errores
            );
            
            if (!juegoBL.guardarPuntaje(puntaje)) {
                throw new Exception("Error al guardar puntaje");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, 
                "Error: " + ex.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mostrarResultados() {
        JOptionPane.showMessageDialog(this,
            "Resultados:\n" +
            "✅ Aciertos: " + aciertos + "\n" +
            "❌ Errores: " + errores,
            "Fin de la Partida",
            JOptionPane.INFORMATION_MESSAGE);
    }

    // private void reiniciarJuego() {
    //     aciertos = 0;
    //     errores = 0;
    //     rondaActual = 1;
    //     lblPuntaje.setText("Puntaje: 0");
    //     lblRonda.setText("Ronda: 1/" + TOTAL_RONDAS);
    //     nuevoJuego();
    // }

    private int generarNumeroAleatorio() {
        return (int) (Math.random() * 50) + 1;
    }
}