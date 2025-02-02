package UserInterface.CustomerControl;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import UserInterface.PoliCursoStyle;

public class PoliTextLabel  extends JPanel {
    private PoliLabel lblEtiqueta = new PoliLabel();
    private PoliTextBox txtContenido = new PoliTextBox();

    public PoliTextLabel(String etiqueta) {
        setLayout(new BorderLayout());
        lblEtiqueta.setCustomizeComponent(
            etiqueta, 
            PoliCursoStyle.FONT_SMALL,
            PoliCursoStyle.COLOR_FONT_LIGHT, 
            PoliCursoStyle.ALIGNMENT_LEFT
            );
            txtContenido.setBorderLine();
            add(lblEtiqueta, BorderLayout.NORTH);
            add(txtContenido, BorderLayout.CENTER);
    }

}
