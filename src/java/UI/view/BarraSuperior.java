package UI.view;

import UI.listeners.listener_botones_menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

/* CLASSE DEDICADA A LA CREACIÓ D'UNA BARRA DE MENÚ SUPERIOR CON BOTONES DE MENÚ */
public class BarraSuperior extends JPanel {
    private static final Color TOP_BAR_COLOR = new Color(38, 38, 38);
    private static final Dimension TOP_BAR_SIZE = new Dimension(0, 50);

    // Dividim la barra superior (BorderLayout) en 3 FlowLayout
    private JPanel barra_superior_centro;
    private JPanel barra_superior_izquierda;
    private JPanel barra_superior_derecha;

    public BarraSuperior() {
        // Configurem aquest propi JPanel
        setLayout(new BorderLayout());
        setPreferredSize(TOP_BAR_SIZE);
        setBackground(TOP_BAR_COLOR);

        barra_superior_centro = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        barra_superior_izquierda = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        barra_superior_derecha = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));

        barra_superior_izquierda.setOpaque(false);
        barra_superior_centro.setOpaque(false);
        barra_superior_derecha.setOpaque(false);

        add(barra_superior_izquierda, BorderLayout.WEST);
        add(barra_superior_centro, BorderLayout.CENTER);
        add(barra_superior_derecha, BorderLayout.EAST);
    }

    /*
     * Funcion encargada de añadir los botonesMenu a la barra superior/derecha ya
     * que
     * el menu de la ventana siempre estara situado a la derecha+
     * Necessita el MainFrame ya para crear el listener de los botones
     */
    public void añadirBotonesMenu(MainFrame mainFrame) {
        listener_botones_menu listener = new listener_botones_menu(mainFrame);

        BotonesMenu botonesMenu = new BotonesMenu(
                "minimizar", "maximizar", "cerrar",
                "recursos/icons/minimize.png",
                "recursos/icons/maximize.png",
                "recursos/icons/close.png",
                listener);
        barra_superior_derecha.add(botonesMenu.getButton_1());
        barra_superior_derecha.add(botonesMenu.getButton_2());
        barra_superior_derecha.add(botonesMenu.getButton_3());
    }

    // TODO implementar mas metodos para añadir-los en las otras partes
    // TODO poder agregar distinto numero de botones

}