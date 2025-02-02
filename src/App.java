import javax.swing.SwingUtilities;

import UserInterface.Form.MainForm;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainForm mainForm = new MainForm(); // Crear instancia
            mainForm.setVisible(true);
        });
    }
}
