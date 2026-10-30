package UI.view.main_frame;

import java.awt.CardLayout;

import javax.swing.JPanel;

import UI.view.ventanas_principales.*;

public class VentanasPrincipales extends JPanel {

    public VentanasPrincipales() {
        setLayout(new CardLayout());

        Biblioteca biblioteca = new Biblioteca();
        add(biblioteca);
        Inicio inicio = new Inicio();
        add(inicio);
        Tracker tracker = new Tracker();
        add(tracker);

    }
}
