package UI.view;

import UI.listeners.c_listnersBotons;
import UI.view.main_frame.BarraLateral;
import UI.view.main_frame.BarraSuperior;
import UI.view.main_frame.Perfil;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainFrame extends JFrame {
    /* ----- SECCION DE VARIABLES GLOBAS REUTILIZADAS ----- */
    private static final Color BACKGROUND_COLOR = new Color(55, 55, 55);
    private final Container ventana_de_contenido = getContentPane();

    /* ----- ELEMENTOS DE LA VENTANA ----- */
    BarraSuperior barraSuperior;
    BarraLateral barraLateral;
    Perfil perfilUsuari;
    c_listnersBotons gestorBotones;

    /* ----- CONSTRUCTOR VENTANA ----- */
    public MainFrame() {
        // creas el gestor de botones par aañadir listeners
        gestorBotones = new c_listnersBotons(this);

        inicializacion();

        barraSuperior = crearBarraSuperior();
        ventana_de_contenido.add(barraSuperior, BorderLayout.NORTH);

        barraLateral = crearBarraLateral();
        ventana_de_contenido.add(barraLateral, BorderLayout.WEST);

        perfilUsuari = crearPerfilUsuari();
    }

    /* ----- FUNCIONES DEDICADAS A LA INICIALIZACION DE ELEMENTOS ----- */
    private void inicializacion() {
        setTitle("Tracker Gaming v1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true); // quita la barra de windows
        setSize(500, 500);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        ventana_de_contenido.setBackground(BACKGROUND_COLOR);
        ventana_de_contenido.setLayout(new BorderLayout());
    }

    private BarraSuperior crearBarraSuperior() {
        return new BarraSuperior(gestorBotones);
    }

    private Perfil crearPerfilUsuari() {
        return new Perfil(this);
    }

    private BarraLateral crearBarraLateral(){
        return new BarraLateral(gestorBotones);
    }

    public static void main(String[] args) {
        // esto sirve para ejecutar la interfaz en un thread dedicado que tiene swing
        // asi evitas possibles problemas visuales i glitches
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame ventana = new MainFrame();
                ventana.setVisible(true);
            }
        });

    }
}
