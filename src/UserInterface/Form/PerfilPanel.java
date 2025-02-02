package UserInterface.Form;

import java.awt.GridLayout;
import javax.swing.JPanel;
import UserInterface.CustomerControl.PoliLabel;
import UserInterface.CustomerControl.PoliLabelText;
import UserInterface.PoliCursoStyle;

public class PerfilPanel extends JPanel {
    public PerfilPanel() {
        customizeComponent();
    }

    private void customizeComponent() {
        setLayout(new GridLayout(5, 1, 10, 10));
        setBackground(PoliCursoStyle.COLOR_BACKGROUND);
        
        add(new PoliLabel("Mi Perfil", PoliCursoStyle.FONT_BOLD.deriveFont(20f)));
        add(new PoliLabelText("Usuario:"));
        add(new PoliLabelText("Aciertos:"));
        add(new PoliLabelText("Errores:"));
    }
}