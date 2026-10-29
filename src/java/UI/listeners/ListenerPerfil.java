package UI.listeners;

import UI.view.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import UI.view.ventana_principal.Perfil;

public class ListenerPerfil implements ActionListener {
    private MainFrame mainFrame;
    public ListenerPerfil(MainFrame m){
        mainFrame = m;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Perfil perfil = new Perfil(mainFrame);
        perfil.setVisible(true);
    }
}
