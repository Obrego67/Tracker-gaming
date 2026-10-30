package UI.view.main_frame;

import java.awt.CardLayout;

import javax.swing.JPanel;

import UI.view.ventanas_principales.*;

public class VentanasPrincipales extends JPanel {
    public VentanasPrincipales() {
        setLayout(new CardLayout());

        Inicio inicio = new Inicio();
        add(inicio, "inicio");

        Biblioteca biblioteca = new Biblioteca();
        add(biblioteca, "biblioteca");

        Tracker tracker = new Tracker();
        add(tracker, "tracker");
    }
}
