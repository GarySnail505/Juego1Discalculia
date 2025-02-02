package UserInterface.Form;

import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import UserInterface.PoliCursoStyle;
import UserInterface.CustomerControl.PoliButton;
import UserInterface.CustomerControl.PoliLabel;

public class MainMenuPanel extends JPanel {
    public PoliButton btnJugar = new PoliButton("Iniciar Juego");
    public PoliButton btnSalir = new PoliButton("Salir");
    
    public MainMenuPanel(MainForm mainForm) {
        setLayout(new GridLayout(3, 1, 10, 10));
        add(new PoliLabel("Menú Principal", PoliCursoStyle.FONT_TITLE));
        add(btnJugar);
        add(btnSalir);
        
        
        btnJugar.addActionListener(e -> {
        if (mainForm.getUsuarioActual() == null) {
            JOptionPane.showMessageDialog(this, "Debes iniciar sesión primero");
            mainForm.mostrarPanel("login");
        } else {
            mainForm.mostrarPanel("juego");
        }
    });

    }
}