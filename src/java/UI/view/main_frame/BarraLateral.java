package UI.view.main_frame;

import UI.listeners.c_listnersBotons;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class BarraLateral extends JPanel {
    private static final Dimension SIZE = new Dimension(200, 0);
    private static final Color BACKGROUND_COLOR = new Color(55, 55, 55);

    private static final Color COLOR_BOTON = new Color(45, 45, 45);
    private static final Color COLOR_TEXTO_BOTON = new Color(255, 255, 255);
    private static final Dimension TAMANO_BOTON = new Dimension(200, 100);

    public BarraLateral(c_listnersBotons c) {
        setBackground(BACKGROUND_COLOR);
        setPreferredSize(SIZE);
        setLayout(new BorderLayout());

        JPanel menuBotones = crearMenu();
        add(menuBotones, BorderLayout.NORTH);
    }

    private JPanel crearMenu() {
        JPanel menu = new JPanel();
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
        menu.setBackground(BACKGROUND_COLOR);

        menu.add(Box.createVerticalGlue());
        menu.add(crearBoton("INICIO", "inicio"));
        menu.add(Box.createVerticalStrut(10));
        menu.add(crearBoton("BIBLIOTECA", "biblioteca"));
        menu.add(Box.createVerticalStrut(10));
        menu.add(crearBoton("TRACKER", "tracker"));
        menu.add(Box.createVerticalGlue());

        return menu;
    }

    private JButton crearBoton(String texto, String command) {
        JButton boton = new JButton();
        boton.setLayout(new BorderLayout());
        boton.add(crearTextoBoton(texto));
        boton.setBackground(COLOR_BOTON);
        boton.setFocusable(false);
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setPreferredSize(TAMANO_BOTON);
        boton.setMaximumSize(new Dimension(Integer.MAX_VALUE, TAMANO_BOTON.height));
        boton.setActionCommand(command);

        return boton;
    }

    private JLabel crearTextoBoton(String texto) {
        JLabel etiqueta = new JLabel(texto);
        etiqueta.setForeground(COLOR_TEXTO_BOTON);
        etiqueta.setFont(new Font("SansSerif", Font.BOLD, 20));

        return etiqueta;
    }
}
