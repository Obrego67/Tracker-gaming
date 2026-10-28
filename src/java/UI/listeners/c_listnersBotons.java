package UI.listeners;

import UI.components.Boton;
import UI.view.MainFrame;
import UI.view.barra_superior.BotonesMenu;

public final class c_listnersBotons {

   private final MainFrame MainFrame;

    public  c_listnersBotons(MainFrame MainFrame) {
        this.MainFrame = MainFrame;
    }

    public void añadirListenerMenu(BotonesMenu b) {
        ListenerBotonesMenu listener = new ListenerBotonesMenu(MainFrame);

        b.setListener(listener);
    }

    public void añadirListenerBoton(Boton b){

        switch(b.getTipo()){
            case PERFIL:
                b.addActionListener(new ListenerPerfil(MainFrame));
                break;
        }
    }
}
