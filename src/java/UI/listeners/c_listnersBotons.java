package UI.listeners;

import UI.components.Boton;
import UI.view.MainFrame;
import UI.view.barra_superior.BotonesMenu;
import UI.view.main_frame.Perfil;

public final class c_listnersBotons {

   private final MainFrame MainFrame;

    public  c_listnersBotons(MainFrame MainFrame) {
        this.MainFrame = MainFrame;
    }

    public void añadirListenerMenu(BotonesMenu b) {
        ListenerBotonesMenu listener = new ListenerBotonesMenu(MainFrame);

        b.setListener(listener);
    }

    public void añadirListenerPerfil(Boton boton) {
        boton.addActionListener(new ListenerPerfil(MainFrame));
    }

    public void añadirListenerCerrarPerfil(Boton boton, Perfil perfil) {
        boton.addActionListener(new ListenerBotonCerrarPerfil(perfil));
    }
}
