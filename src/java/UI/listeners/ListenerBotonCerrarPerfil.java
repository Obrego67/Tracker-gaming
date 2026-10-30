package UI.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import UI.view.main_frame.Perfil;

public class ListenerBotonCerrarPerfil implements ActionListener {
    private final Perfil perfil;

    public ListenerBotonCerrarPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        perfil.dispose();
    }
}
