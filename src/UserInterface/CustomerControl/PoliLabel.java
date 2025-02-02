package UserInterface.CustomerControl;

import java.awt.Font;
import javax.swing.JLabel;
import UserInterface.PoliCursoStyle;

public class PoliLabel extends JLabel {

    public PoliLabel() {
        customizeComponent();
    }

    public PoliLabel(String text) {
        super(text);
        customizeComponent();
    }

    public PoliLabel(String text, int horizontalAlignment) {
        super(text, horizontalAlignment);
        customizeComponent();
        setHorizontalAlignment(horizontalAlignment);
    }

    public PoliLabel(String text, Font font) {
        super(text);
        customizeComponent();
        setFont(font);
    }

    private void customizeComponent() {
        setFont(PoliCursoStyle.FONT);
        setForeground(PoliCursoStyle.COLOR_FONT);
        setOpaque(false);
        setBorder(null);
        setBackground(PoliCursoStyle.COLOR_BACKGROUND);
    }

    public void setHighlight(boolean highlight) {
        if (highlight) {
            setBorder(PoliCursoStyle.createBorderHighlight());
            setForeground(PoliCursoStyle.COLOR_SUCCESS);
        } else {
            setBorder(null);
            setForeground(PoliCursoStyle.COLOR_FONT);
        }
    }
}