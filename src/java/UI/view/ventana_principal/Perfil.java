package UI.view.ventana_principal;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import UI.view.MainFrame;
import UI.listeners.c_listnersBotons;
import UI.components.Boton;

public class Perfil extends JDialog {
    private static final String TITOL = "Perfil Usuari";
    private static final boolean MODAL = true;
    private static final Color BACKGROUND_COLOR = new Color(38, 38, 38);
    private static final Dimension SIZE = new Dimension(1200, 900);

    //constantes boton
    private static final Dimension SIZE_BOTON_MENU = new Dimension(50, 50);
    private static final String icon = new String("recursos/icons/close.png");
    private static final Color BACKGROUND_BUTTON = new Color(38, 38, 38);

    private Container ventana_perfil = this.getContentPane();
    private Boton cerrar;
    private c_listnersBotons controlador_menu;

    public Perfil(MainFrame mainFrame) {
        super(mainFrame, TITOL, MODAL);
        ventana_perfil.setLayout(new BorderLayout());
        JPanel botones_menu_ubicacion = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        botones_menu_ubicacion.setBackground(BACKGROUND_COLOR);
        ventana_perfil.add(botones_menu_ubicacion, BorderLayout.NORTH);

        ventana_perfil.setBackground(BACKGROUND_COLOR);
        setSize(SIZE);
        setUndecorated(true);

        cerrar = new Boton(SIZE_BOTON_MENU, icon, false , false, BACKGROUND_BUTTON);
        botones_menu_ubicacion.add(cerrar, BorderLayout.NORTH);

        controlador_menu = new c_listnersBotons(mainFrame);
        controlador_menu.añadirListenerCerrarPerfil(cerrar, this);

        setLocationRelativeTo(mainFrame); // teien que ser lo ultimo sino queda mal
    }

    public void crearLayout() {
        ventana_perfil.setLayout(new GridLayout(2, 3));

    }
}
