package UI.view.ventana_principal;

import UI.listeners.c_listnersBotons;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class BarraLateral extends JPanel {
    private static final Dimension SIZE = new Dimension(200, 0);
    private static final Color BACKGROUND_COLOR = new Color(76, 76, 76);

    private static final Color COLOR_BOTON = new Color(60, 0, 110);
    private static final Color COLOR_TEXTO_BOTON = new Color(255, 255, 255);


    public BarraLateral(c_listnersBotons c) {
        setBackground(BACKGROUND_COLOR);
        setPreferredSize(SIZE);
        setLayout(new BorderLayout());

        JPanel menuBotones = crearMenu();
        add(menuBotones, BorderLayout.CENTER);

    }

    private JPanel crearMenu(){
        JPanel menu = new JPanel(new GridLayout(0,1,10,10));
        menu.setBackground(BACKGROUND_COLOR);
        menu.add(crearBoton("INICIO"));
        menu.add(crearBoton("BIBLIOTECA"));
        menu.add(crearBoton("TRACKER"));
        return menu;
    }

    private JButton crearBoton(){
        JButton boton = new JButton();
        
        boton.setBackground(COLOR_BOTON);
        boton.setFocusable(false);
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        return boton;
    }

    private JLabel crearTextoBoton(String texto){
        JLabel etiqueta = new JLabel(texto);
        etiqueta.setForeground(COLOR_TEXTO_BOTON);
        etiqueta.setFont(new Font("SansSerif", Font.BOLD, 30));
    }
}
