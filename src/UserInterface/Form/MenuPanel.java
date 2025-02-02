package UserInterface.Form;

import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import UserInterface.CustomerControl.PoliButton;
import UserInterface.CustomerControl.PoliLabel;
import UserInterface.PoliCursoStyle;

public class MenuPanel extends JPanel {
    public PoliButton 
        btnInicio   = new PoliButton("Inicio"),
        btnJuego    = new PoliButton("Juego"),
        btnPerfil   = new PoliButton("Perfil"),
        btnSalir    = new PoliButton("Salir");
        
    public MenuPanel(MainForm mainForm) {
        customizeComponent(mainForm);
    }

    private void customizeComponent(MainForm mainForm) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(250, getHeight()));
        setBackground(PoliCursoStyle.COLOR_SECONDARY_BG);
        
        // Logo
        addLogo();
        
        // Botones del menú
        addMenuButtons(mainForm);
        
        // Derechos de autor
        add(new PoliLabel("\n© PoliCurso 2024"));
    }

    private void addLogo() {
        try {
            Image logo = ImageIO.read(new File("/resources/logo5.webp"));
            logo = logo.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            JLabel lblLogo = new JLabel(new ImageIcon(logo));
            lblLogo.setAlignmentX(CENTER_ALIGNMENT);
            add(lblLogo);
        } catch(IOException e) {
            System.out.println("Error cargando logo: " + e.getMessage());
        }
    }

    private void addMenuButtons(MainForm mainForm) {
        configureButton(btnInicio,  "inicio",  mainForm);
        configureButton(btnJuego,   "juego",   mainForm);
        configureButton(btnPerfil,  "perfil",  mainForm);
        configureButton(btnSalir,   "login",   mainForm);
        
        add(btnInicio);
        add(btnJuego);
        add(btnPerfil);
        add(btnSalir);
    }

    private void configureButton(PoliButton button, String panelName, MainForm mainForm) {
        button.setHorizontalAlignment(PoliCursoStyle.ALIGNMENT_LEFT);
        button.setBorder(PoliCursoStyle.createBorderRect());
        button.setBackground(PoliCursoStyle.COLOR_BACKGROUND);
        
        button.addActionListener(e -> {
            if(panelName.equals("login")) {
                mainForm.dispose();
                new MainForm().setVisible(true);
            } else {
                mainForm.mostrarPanel(panelName);
            }
        });
    }
}