package UserInterface.CustomerControl;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import UserInterface.PoliCursoStyle;

public class PoliLabelText extends JPanel {
    private PoliLabel lblEtiqueta;
    private JTextField txtCampo;

    public PoliLabelText(String textoEtiqueta) {
        lblEtiqueta = new PoliLabel(textoEtiqueta);
        txtCampo = new JTextField();
        customizeComponent();
    }

    private void customizeComponent() {
        // Configurar layout
        setLayout(new BorderLayout(5, 0));
        setBackground(PoliCursoStyle.COLOR_BACKGROUND);
        
        // Personalizar etiqueta
        lblEtiqueta.setFont(PoliCursoStyle.FONT);
        lblEtiqueta.setPreferredSize(new Dimension(100, 25));
        
        // Personalizar campo de texto
        txtCampo.setFont(PoliCursoStyle.FONT);
        txtCampo.setBorder(PoliCursoStyle.createBorderRect());
        txtCampo.setPreferredSize(new Dimension(150, 30));
        
        // Añadir componentes
        add(lblEtiqueta, BorderLayout.WEST);
        add(txtCampo, BorderLayout.CENTER);
    }

    // Métodos para acceso al texto
    public String getText() {
        return txtCampo.getText();
    }

    public void setText(String texto) {
        txtCampo.setText(texto);
    }

    // Método para resaltar errores
    public void setError(boolean error) {
        if (error) {
            txtCampo.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(PoliCursoStyle.COLOR_ERROR, 1),
                new EmptyBorder(2, 5, 2, 5)
            ));
        } else {
            txtCampo.setBorder(PoliCursoStyle.createBorderRect());
        }
    }
}