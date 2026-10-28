package UI.components;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Boton extends JButton {
    public enum TipoBoton {
        PERFIL
    }

    private TipoBoton tipo;

    public Boton(Dimension dimensiones, String icon, boolean borde, boolean transparente,
            boolean focusmode, String command, TipoBoton tipo) {
        setPreferredSize(dimensiones);
        setIcon(new ImageIcon(icon));
        setBorderPainted(borde);
        setContentAreaFilled(transparente);
        setFocusPainted(focusmode);
        setActionCommand(command);
        this.tipo = tipo;
    }

    // getters
    public Boton getBoton() {
        return this;
    }

    public TipoBoton getTipo() {
        return this.tipo;
    }
}
