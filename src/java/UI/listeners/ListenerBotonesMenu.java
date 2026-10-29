package UI.listeners;

import UI.view.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class ListenerBotonesMenu implements ActionListener {
    MainFrame ventana;
    public ListenerBotonesMenu(MainFrame ventana) {
        this.ventana = ventana;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String boton_pulsado = e.getActionCommand();

        switch(boton_pulsado){
            case "cerrar":
                ventana.dispose();
                break;
            case "minimizar":
                ventana.setExtendedState(JFrame.ICONIFIED); //minimiza la ventana
                break;
            case "maximizar":
                if (ventana.getExtendedState() == JFrame.MAXIMIZED_BOTH)
                    ventana.setExtendedState(JFrame.NORMAL);
                else
                    ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
                break;
        }


    }
}
