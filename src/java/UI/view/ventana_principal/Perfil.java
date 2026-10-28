package UI.view.ventana_principal;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JDialog;
import java.awt.BorderLayout;
//import java.awt.FlowLayout;
import UI.view.MainFrame;

public class Perfil extends JDialog {
    static final String TITOL = "Perfil Usuari";
    static final boolean MODAL = true;
    static final Color BACKGROUND_COLOR = new Color(38, 38, 38);
    static final Dimension SIZE = new Dimension(600, 750);

    public Perfil(MainFrame mainFrame) {
        super(mainFrame, TITOL, MODAL);
        setLayout(new BorderLayout());
        setBackground(BACKGROUND_COLOR);
        setSize(SIZE);
    }

}
