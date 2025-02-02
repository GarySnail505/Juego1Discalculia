package UserInterface.Form;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.formdev.flatlaf.intellijthemes.FlatCyanLightIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatGradiantoMidnightBlueIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatHiberbeeDarkIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneLightIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubDarkIJTheme;

import DataAccess.DTO.UsuarioDTO;

public class MainForm extends JFrame {
    private CardLayout cardLayout = new CardLayout();
    private JPanel mainPanel = new JPanel(cardLayout);
    private UsuarioDTO usuarioActual;
    
    public MainForm() {
        try {
            UIManager.setLookAndFeel(new FlatCyanLightIJTheme());
        } catch (Exception e) {
            // TODO: handle exception
        }
        setTitle("PoliCurso - Juego de Discalculia");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Agregar paneles
        mainPanel.add(new LoginPanel(this), "login");
        mainPanel.add(new MainMenuPanel(this), "menu"); // Nuevo panel
        mainPanel.add(new InicioPanel(this), "inicio");
        mainPanel.add(new JuegoPanel(this), "juego");
        mainPanel.add(new PerfilPanel(), "perfil");

        add(mainPanel);
        mostrarPanel("login");
    }

    public void mostrarPanel(String nombrePanel) {
        cardLayout.show(mainPanel, nombrePanel);
    
        if (nombrePanel.equals("menu")) {
            mainPanel.removeAll();
            mainPanel.add(new LoginPanel(this), "login");
            mainPanel.add(new MainMenuPanel(this), "menu");
            mainPanel.add(new JuegoPanel(this), "juego");
            cardLayout.show(mainPanel, "menu");
        }
    }
    
    public UsuarioDTO getUsuarioActual() {
        return usuarioActual;
    }
    
    public void setUsuarioActual(UsuarioDTO usuarioActual) {
        this.usuarioActual = usuarioActual;
    }
    
    
}