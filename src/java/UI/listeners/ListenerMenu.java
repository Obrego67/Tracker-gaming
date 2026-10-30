package UI.listeners;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import UI.view.main_frame.VentanasPrincipales;

public class ListenerMenu implements ActionListener {
    VentanasPrincipales vp;
    public ListenerMenu(VentanasPrincipales v){
        vp = v;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String boton = e.getActionCommand();
        CardLayout layoutVP = (CardLayout) vp.getLayout();

        if(boton == "inicio"){layoutVP.show(vp, boton);}
        else if (boton == "biblioteca"){layoutVP.show(vp, boton);}
        else if(boton == "tracker"){layoutVP.show(vp, boton);}

    }
}
