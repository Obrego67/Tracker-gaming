package UI.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainFrame extends JFrame {
    /* ----- SECCION DE VARIABLES GLOBAS REUTILIZADAS ----- */
    private static final Color BACKGROUND_COLOR = new Color(55, 55, 56);
    // variable que nos sirve para acceder al contenido de la ventana nos hcae falta
    // para modificar lso elementos
    private final Container ventana_de_contenido = getContentPane();

    /* ----- ELEMENTOS DE LA VENTANA  ----- */
    BarraSuperior barra_superior;

    /* ----- CONSTRUCTOR VENTANA ----- */
    public MainFrame() {
        inicializacion();
        añadirBarraSuperior();
    }

    /* ----- FUNCIONES DEDICADAS A LA INICIALIZACION DE ELEMENTOS  ----- */
    private void inicializacion() {
        setTitle("Tracker Gaming v1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true); // quita la barra de windows
        setSize(500, 500);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        ventana_de_contenido.setBackground(BACKGROUND_COLOR);
        ventana_de_contenido.setLayout(new BorderLayout());
    }
    private void añadirBarraSuperior(){
        barra_superior = new BarraSuperior();
        barra_superior.añadirBotonesMenu(this);
        ventana_de_contenido.add(barra_superior, BorderLayout.NORTH);
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
