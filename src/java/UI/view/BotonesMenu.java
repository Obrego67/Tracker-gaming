package UI.view;

import UI.listeners.listener_botones_menu;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BotonesMenu {

    private static final Dimension MENU_BUTTON_SIZE = new Dimension(48, 50);
    private JButton boton_1;
    private JButton boton_2;
    private JButton boton_3;

    // Constructor por defecto
    public BotonesMenu() {
        // Asignamos a los atributos de clase (sin poner 'JButton' delante)
        boton_1 = new JButton();
        boton_2 = new JButton();
        boton_3 = new JButton();

        boton_1.setPreferredSize(MENU_BUTTON_SIZE);
        boton_2.setPreferredSize(MENU_BUTTON_SIZE);
        boton_3.setPreferredSize(MENU_BUTTON_SIZE);

        boton_1.setBorderPainted(false);
        boton_2.setBorderPainted(false);
        boton_3.setBorderPainted(false);

        Color fondo = new Color(38, 38, 38);
        boton_1.setBackground(fondo);
        boton_2.setBackground(fondo);
        boton_3.setBackground(fondo);
    }

    // Constructor completo con parámetros
    public BotonesMenu(String c1, String c2, String c3,
            String img1, String img2, String img3,
            listener_botones_menu listener) {
        // Reutilizamos el constructor por defecto para crear los botones y estilos base
        this();

        // Asignamos comandos, iconos y listener pasados por parámetro
        setCommand(c1, c2, c3);
        setIcon(img1, img2, img3);
        setListener(listener);
    }

    // Setters
    public void setCommand(String c1, String c2, String c3) {
        boton_1.setActionCommand(c1);
        boton_2.setActionCommand(c2);
        boton_3.setActionCommand(c3);
    }

    public void setSize(Dimension d) {
        boton_1.setPreferredSize(d);
        boton_2.setPreferredSize(d);
        boton_3.setPreferredSize(d);
    }

    public void setIcon(String img1, String img2, String img3) {
        boton_1.setIcon(new ImageIcon(img1));
        boton_2.setIcon(new ImageIcon(img2));
        boton_3.setIcon(new ImageIcon(img3));
    }

    public void setListener(listener_botones_menu l) {
        boton_1.addActionListener(l);
        boton_2.addActionListener(l);
        boton_3.addActionListener(l);
    }

    public void setColorFondo(Color color) {
        boton_1.setBackground(color);
        boton_2.setBackground(color);
        boton_3.setBackground(color);
    }

    // Getters
    public JButton getButton_1() {
        return boton_1;
    }

    public JButton getButton_2() {
        return boton_2;
    }

    public JButton getButton_3() {
        return boton_3;
    }
}