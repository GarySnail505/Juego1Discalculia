package UserInterface.Form;

import javax.swing.JPanel;
import UserInterface.CustomerControl.PoliButton;
import UserInterface.CustomerControl.PoliLabel;

public class InicioPanel extends JPanel {
    public InicioPanel(MainForm mainForm) {
        setLayout(new java.awt.BorderLayout());
        
        // Mensaje de bienvenida
        PoliLabel lblBienvenida = new PoliLabel("¡Bienvenido a PoliCurso!");
        lblBienvenida.setHorizontalAlignment(PoliLabel.CENTER);
        add(lblBienvenida, java.awt.BorderLayout.CENTER);
        
        // Botón para ir al menú
        PoliButton btnContinuar = new PoliButton("Continuar al Menú");
        btnContinuar.addActionListener(e -> mainForm.mostrarPanel("menu"));
        add(btnContinuar, java.awt.BorderLayout.SOUTH);
    }
}
