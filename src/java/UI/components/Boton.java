package UI.components;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Boton extends JButton {
    public Boton(Dimension dimensiones, String icon, boolean borde,
            boolean focusmode, Color background) {
        setPreferredSize(dimensiones);
        setIcon(new ImageIcon(icon));
        setBorderPainted(borde);
        setFocusPainted(focusmode);
        setBackground(background);
    }

    // getters
    public Boton getBoton() {
        return this;
    }
}
