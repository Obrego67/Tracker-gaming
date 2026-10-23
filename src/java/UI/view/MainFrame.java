package UI.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.awt.CardLayout;
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
    // variable que nos sirve para acceder al contenido de la ventana nos hcae falta
    // para modificar lso elementos
    Container ventana_de_contenido = getContentPane();

    /*----- Elementos de la ventana ----- */
    JButton boton_cerrar;
    JButton boton_minimizar;
    JButton boton_maximizar;

    /* ----- CONSTRUCTOR VENTANA ----- */
    public MainFrame() {
        inicializacion();
        inicializarBarraSuperior();
    }

    public void inicializacion() {
        setTitle("Tracker Gaming v1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true); // quita la barra de windows
        ventana_de_contenido.setBackground(background_color);
        ventana_de_contenido.setLayout(new BorderLayout());
    }
    public void inicializarBarraSuperior() {
        JPanel barra_superior = new JPanel();
        barra_superior.setLayout(new FlowLayout());
        // le indica al layout el tamaño que desea tener el objeto
        barra_superior.setPreferredSize(tamaño_barra_superior);
        // barra_superior.setMaximumSize(tamaño_barra_superior);

        barra_superior.setBackground(color_barra_superior);
        ventana_de_contenido.add(barra_superior, BorderLayout.NORTH);

    }

    public void inicializarBotonesCierre() {
        boton_cerrar = new JButton();
        boton_minimizar = new JButton();
        boton_maximizar = new JButton();

        //le pones nombre a la accion del boton para diferenciar en el listener
        boton_cerrar.setActionCommand("cerrar");
        boton_minimizar.setActionCommand("minimizar");
        boton_maximizar.setActionCommand("maximizar");

        listener_botones_menu listener_menu = new listener_botones_menu(this);

        boton_cerrar.addActionListener(listener_menu);
        boton_minimizar.addActionListener(listener_menu);
        boton_maximizar.addActionListener(listener_menu);
    }

    public static void main(String[] args) {
        new MainFrame().setVisible(true);
    }
}
