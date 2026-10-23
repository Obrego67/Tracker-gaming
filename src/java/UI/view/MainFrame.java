package UI.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.Container;

import UI.listeners.*;

public class MainFrame extends JFrame {
    /* ----- SECCION DE VARIABLES GLOBAS REUTILIZADAS ----- */
    private static final Color background_color = new Color(55, 55, 56);
    private static final Color color_barra_superior = new Color(38, 38, 38);
    // guardamos la dimensiones de la pantalal donde se ejecuta el codigo
    Dimension tamaño_pantalla = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension tamaño_barra_superior = new Dimension(tamaño_pantalla.width, 50);
    Dimension tamaño_boton_menu = new Dimension(48, 50);
    // variable que nos sirve para acceder al contenido de la ventana nos hcae falta
    // para modificar lso elementos
    Container ventana_de_contenido = getContentPane();

    /*----- Elementos de la ventana ----- */
    JButton boton_cerrar;
    JButton boton_minimizar;
    JButton boton_maximizar;

    JPanel barra_superior; // delimita la zona de la barra superior (borderlayout)
    // dividiremos la barra superior en 3, al ser un borderlayout la superior, se
    // repartiran el tamaño
    // seran flowlayout
    JPanel barra_superior_centro;
    JPanel barra_superior_izquierda;
    JPanel barra_superior_derecha;

    /* ----- CONSTRUCTOR VENTANA ----- */
    public MainFrame() {
        inicializacion();
        inicializarBarraSuperior();
        inicializarBotonesMenu();
    }

    public void inicializacion() {
        setTitle("Tracker Gaming v1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true); // quita la barra de windows
        setSize(500, 500);

        ventana_de_contenido.setBackground(background_color);
        ventana_de_contenido.setLayout(new BorderLayout());
    }

    public void inicializarBarraSuperior() {
        barra_superior = new JPanel();
        barra_superior.setLayout(new BorderLayout());

        // creamos las 3 divisiones de la barra superior
        barra_superior_centro = new JPanel();
        barra_superior_izquierda = new JPanel();
        barra_superior_derecha = new JPanel();

        // les ponemos el layout
        barra_superior_centro.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        barra_superior_derecha.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        barra_superior_izquierda.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        // las añadimos a la barra superior
        barra_superior.add(barra_superior_izquierda, BorderLayout.WEST);
        barra_superior.add(barra_superior_centro, BorderLayout.CENTER);
        barra_superior.add(barra_superior_derecha, BorderLayout.EAST);

        // hacemos las 3 divisiones invisibles asi vemos el color de la barra superior i
        // ya
        barra_superior_izquierda.setOpaque(false);
        barra_superior_centro.setOpaque(false);
        barra_superior_derecha.setOpaque(false);

        // le indica al layout el tamaño que desea tener el objeto
        barra_superior.setPreferredSize(tamaño_barra_superior);
        // barra_superior.setMaximumSize(tamaño_barra_superior);

        barra_superior.setBackground(color_barra_superior);
        ventana_de_contenido.add(barra_superior, BorderLayout.NORTH);

    }

    public void inicializarBotonesMenu() {
        boton_cerrar = new JButton();
        boton_minimizar = new JButton();
        boton_maximizar = new JButton();

        // le pones nombre a la accion del boton para diferenciar en el listener
        boton_cerrar.setActionCommand("cerrar");
        boton_minimizar.setActionCommand("minimizar");
        boton_maximizar.setActionCommand("maximizar");

        listener_botones_menu listener_menu = new listener_botones_menu(this);

        boton_cerrar.addActionListener(listener_menu);
        boton_minimizar.addActionListener(listener_menu);
        boton_maximizar.addActionListener(listener_menu);

        boton_cerrar.setBackground(color_barra_superior);
        boton_minimizar.setBackground(color_barra_superior);
        boton_maximizar.setBackground(color_barra_superior);

        boton_cerrar.setBorderPainted(false);
        boton_minimizar.setBorderPainted(false);
        boton_maximizar.setBorderPainted(false);

        boton_cerrar.setIcon(new ImageIcon("recursos/icons/close.png"));
        boton_minimizar.setIcon(new ImageIcon("recursos/icons/minimize.png"));
        boton_maximizar.setIcon(new ImageIcon("recursos/icons/maximize.png"));

        boton_cerrar.setPreferredSize(tamaño_boton_menu);
        boton_minimizar.setPreferredSize(tamaño_boton_menu);
        boton_maximizar.setPreferredSize(tamaño_boton_menu);

        barra_superior_derecha.add(boton_minimizar);
        barra_superior_derecha.add(boton_maximizar);
        barra_superior_derecha.add(boton_cerrar);
    }

    public static void main(String[] args) {
        new MainFrame().setVisible(true);
    }
}
