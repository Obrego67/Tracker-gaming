package UI.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.Container;

import UI.listeners.listener_botones_menu;

public class MainFrame extends JFrame {
    /* ----- SECCION DE VARIABLES GLOBAS REUTILIZADAS ----- */
    private static final Color BACKGROUND_COLOR = new Color(55, 55, 56);
    private static final Color TOP_BAR_COLOR = new Color(38, 38, 38);
    private static final Dimension TOP_BAR_SIZE = new Dimension(0, 50);
    private static final Dimension MENU_BUTTON_SIZE = new Dimension(48, 50);
    // variable que nos sirve para acceder al contenido de la ventana nos hcae falta
    // para modificar lso elementos
    private final Container ventana_de_contenido = getContentPane();

    /*----- Elementos de la ventana ----- */
    private JButton boton_cerrar;
    private JButton boton_minimizar;
    private JButton boton_maximizar;

    private JPanel barra_superior; // delimita la zona de la barra superior (borderlayout)
    // dividiremos la barra superior en 3, al ser un borderlayout la superior, se
    // repartiran el tamaño
    // seran flowlayout
    private JPanel barra_superior_centro;
    private JPanel barra_superior_izquierda;
    private JPanel barra_superior_derecha;

    /* ----- CONSTRUCTOR VENTANA ----- */
    public MainFrame() {
        inicializacion();
        inicializarBarraSuperior();
        inicializarBotonesMenu();
    }

    private void inicializacion() {
        setTitle("Tracker Gaming v1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true); // quita la barra de windows
        setSize(500, 500);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        ventana_de_contenido.setBackground(BACKGROUND_COLOR);
        ventana_de_contenido.setLayout(new BorderLayout());
    }
    private void inicializarBarraSuperior() {
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
        barra_superior.setPreferredSize(TOP_BAR_SIZE);
        // barra_superior.setMaximumSize(tamaño_barra_superior);

        barra_superior.setBackground(TOP_BAR_COLOR);
        ventana_de_contenido.add(barra_superior, BorderLayout.NORTH);

    }
    private void inicializarBotonesMenu() {
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

        //cambias el color del fondo al de la barra superior
        boton_cerrar.setBackground(TOP_BAR_COLOR);
        boton_minimizar.setBackground(TOP_BAR_COLOR);
        boton_maximizar.setBackground(TOP_BAR_COLOR);

        //quitas el borde del boton
        boton_cerrar.setBorderPainted(false);
        boton_minimizar.setBorderPainted(false);
        boton_maximizar.setBorderPainted(false);

        //añadir iconos a los botones
        boton_cerrar.setIcon(new ImageIcon("recursos/icons/close.png"));
        boton_minimizar.setIcon(new ImageIcon("recursos/icons/minimize.png"));
        boton_maximizar.setIcon(new ImageIcon("recursos/icons/maximize.png"));

        //tamaño
        boton_cerrar.setPreferredSize(MENU_BUTTON_SIZE);
        boton_minimizar.setPreferredSize(MENU_BUTTON_SIZE);
        boton_maximizar.setPreferredSize(MENU_BUTTON_SIZE);

        barra_superior_derecha.add(boton_minimizar);
        barra_superior_derecha.add(boton_maximizar);
        barra_superior_derecha.add(boton_cerrar);
    }

    public static void main(String[] args) {
        //esto sirve para ejecutar la interfaz en un thread dedicado que tiene swing
        //asi evitas possibles problemas visuales i glitches
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame ventana = new MainFrame();
                ventana.setVisible(true);
            }
        });
    }
}
