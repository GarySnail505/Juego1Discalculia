package UserInterface.Form;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import BusinessLogic.BLFactory;
import BusinessLogic.JuegoBL;
import DataAccess.DAO.UsuarioDAO;
import DataAccess.DTO.UsuarioDTO;
import UserInterface.CustomerControl.PoliButton;
import UserInterface.CustomerControl.PoliLabel;
import UserInterface.CustomerControl.PoliTextBox;

public class LoginPanel extends JPanel {
    private PoliTextBox txtUsuario = new PoliTextBox();
    private PoliTextBox txtContraseña = new PoliTextBox();
    private PoliButton btnLogin = new PoliButton("Iniciar Sesión");
    private JuegoBL juegoBL = new JuegoBL();
    private BLFactory<UsuarioDTO> usuarioBL; // Declarar usuarioBL


    public LoginPanel(MainForm mainForm) {
        this.usuarioBL = new BLFactory<>(UsuarioDAO::new); // Inicializar usuarioBL
        setLayout(new GridLayout(3, 2, 10, 10));
        
        add(new PoliLabel("Usuario:"));
        add(txtUsuario);
        add(new PoliLabel("Contraseña:"));
        add(txtContraseña);
        add(new PoliLabel());
        add(btnLogin);
        
        btnLogin.addActionListener(e -> {
            String usuario = txtUsuario.getText();
            String contrasena = txtContraseña.getText();
            
            try {
                if (juegoBL.iniciarSesion(usuario, contrasena)) {
                    // Obtener el usuario autenticado
                    UsuarioDTO usuarioAutenticado = obtenerUsuario(usuario);
                    if (usuarioAutenticado != null) {
                        mainForm.setUsuarioActual(usuarioAutenticado); // Asignar usuario
                        mainForm.mostrarPanel("menu");
                    } else {
                        JOptionPane.showMessageDialog(this, 
                            "Error al obtener datos del usuario", 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, 
                        "Usuario o contraseña incorrectos", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, 
                    "Error al conectar con la base de datos", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        });
    }
    private UsuarioDTO obtenerUsuario(String nombreUsuario) {
        try {
            List<UsuarioDTO> usuarios = usuarioBL.getAll();
            return usuarios.stream()
                          .filter(u -> u.getNombreUsuario().equals(nombreUsuario))
                          .findFirst()
                          .orElse(null);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}