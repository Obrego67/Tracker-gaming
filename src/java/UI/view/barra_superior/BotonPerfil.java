package UI.view.barra_superior;

import UI.components.Boton;

import java.awt.Color;
import java.awt.Dimension;

public class BotonPerfil extends Boton {
    // Constants per al botó de Perfil de la Barra Superior
    private static final Dimension MIDA_BOTON_PERFIL = new Dimension(50, 50);
    private static final String RUTA_ICONO_PERFIL = "recursos/icons/iconGuest.png";
    private static final boolean TE_BORDE_PERFIL = false;
    private static final boolean TE_FOCUS_PERFIL = false;
    private static final Color BACKGROUND = new Color(38, 38, 38);

    public BotonPerfil(){
        super(MIDA_BOTON_PERFIL, RUTA_ICONO_PERFIL, TE_BORDE_PERFIL, TE_FOCUS_PERFIL, BACKGROUND);
    }
}
