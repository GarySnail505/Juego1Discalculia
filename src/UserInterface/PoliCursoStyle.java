package UserInterface;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public abstract class PoliCursoStyle {
    
    // ================== COLORES ==================
    public static final Color COLOR_FONT = new Color(0, 0, 0);
    public static final Color COLOR_FONT_LIGHT = new Color(100, 100, 100);
    public static final Color COLOR_BACKGROUND = Color.WHITE;
    public static final Color COLOR_SECONDARY_BG = new Color(240, 240, 240);
    public static final Color COLOR_BORDER = Color.LIGHT_GRAY;
    public static final Color COLOR_CURSOR = Color.BLACK;
    public static final Color COLOR_SUCCESS = new Color(0, 150, 0);
    public static final Color COLOR_ERROR = new Color(200, 0, 0);

    // ================== FUENTES ==================
    public static final Font FONT = new Font("Arial", Font.PLAIN, 14);
    public static final Font FONT_BOLD = new Font("Arial", Font.BOLD, 14);
    public static final Font FONT_SMALL = new Font("Arial", Font.PLAIN, 12);
    public static final Font FONT_TITLE = new Font("Arial", Font.BOLD, 24);

    // ================== CURSOres ==================
    public static final Cursor CURSOR_HAND = new Cursor(Cursor.HAND_CURSOR);
    public static final Cursor CURSOR_DEFAULT = new Cursor(Cursor.DEFAULT_CURSOR);

    // ================== IMÁGENES ==================
    public static final URL URL_LOGO = PoliCursoStyle.class.getResource("/UserInterface/Resource/Img/Logo.png");
    public static final URL URL_MAIN = PoliCursoStyle.class.getResource("/UserInterface/Resource/Img/Main.png");
    public static final URL URL_SPLASH = PoliCursoStyle.class.getResource("/UserInterface/Resource/Img/Splash.jpg");

    // ================== ALINEACIÓN ==================
    public static final int ALIGNMENT_LEFT = SwingConstants.LEFT;
    public static final int ALIGNMENT_CENTER = SwingConstants.CENTER;
    public static final int ALIGNMENT_RIGHT = SwingConstants.RIGHT;

    // ================== BORDES ==================
    public static final CompoundBorder createBorderRect() {
        return BorderFactory.createCompoundBorder(
            new LineBorder(COLOR_BORDER), 
            new EmptyBorder(5, 5, 5, 5)
        );
    }

    public static final CompoundBorder createBorderHighlight() {
        return BorderFactory.createCompoundBorder(
            new LineBorder(COLOR_SUCCESS, 2),
            new EmptyBorder(3, 3, 3, 3)
        );
    }
}