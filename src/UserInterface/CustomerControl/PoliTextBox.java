package UserInterface.CustomerControl;

import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import UserInterface.PoliCursoStyle;

public class PoliTextBox extends JTextField{
    public PoliTextBox(){
        customizeComponent();
    }

    private void customizeComponent(){
        setBorderRect();
        setFont(PoliCursoStyle.FONT);
        setForeground(PoliCursoStyle.COLOR_FONT_LIGHT);
        setCaretColor(PoliCursoStyle.COLOR_CURSOR); //Cursor
        setMargin(new Insets(5, 5, 5, 5)); //Margenes
        setOpaque(false); //fondo transparente

    }

    public void setBorderRect(){
        Border lineBorder = BorderFactory.createLineBorder(PoliCursoStyle.COLOR_BORDER);
        Border emptyBorder = new EmptyBorder(5,5,5,5);
        setBorder(new CompoundBorder(lineBorder, emptyBorder));

    }

    public void setBorderLine(){
        int thickness = 1;
        setBorder(
            BorderFactory.createCompoundBorder(
            BorderFactory.createEmptyBorder(0, 0, thickness, 0),
            BorderFactory.createMatteBorder(0, 0, thickness, 0, PoliCursoStyle.COLOR_BORDER)
            ));
    }
}
