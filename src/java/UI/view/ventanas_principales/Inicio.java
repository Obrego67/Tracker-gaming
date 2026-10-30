package UI.view.ventanas_principales;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Inicio extends JPanel {
    private static final Color BACKGROUND_COLOR = new Color(55, 55, 55);

    public Inicio() {
        setLayout(new BorderLayout());
        setBackground(BACKGROUND_COLOR);

        JLabel titulo = new JLabel("INICIO", SwingConstants.CENTER);
        titulo.setFont(new Font("Serif", Font.BOLD, 100));
        titulo.setForeground(Color.WHITE);
        add(titulo, BorderLayout.CENTER);
    }
}
