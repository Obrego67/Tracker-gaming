package UI.view.ventana_principal;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JDialog;

import java.awt.BorderLayout;
//import java.awt.FlowLayout;
import UI.view.MainFrame;
import java.awt.GridLayout;

public class Perfil extends JDialog {
    static final String TITOL = "Perfil Usuari";
    static final boolean MODAL = true;
    static final Color BACKGROUND_COLOR = new Color(38, 38, 38);
    static final Dimension SIZE = new Dimension(600, 750);

    private Container ventana_perfil = this.getContentPane();

    public Perfil(MainFrame mainFrame) {
        super(mainFrame, TITOL, MODAL);
        ventana_perfil.setLayout(new BorderLayout());
        ventana_perfil.setBackground(BACKGROUND_COLOR);
        setSize(SIZE);
        setUndecorated(true);

        setLocationRelativeTo(mainFrame); // teien que ser lo ultimo sino queda mal
    }

    public void crearLayout(){
        ventana_perfil.setLayout(new GridLayout(2,3));

    }
}
