package UI.view.barra_superior;

import UI.components.Boton;
import java.awt.Dimension;

public class BotonPerfil extends Boton {
    // Constants per al botó de Perfil de la Barra Superior
    private static final Dimension MIDA_BOTON_PERFIL = new Dimension(50, 50);
    private static final String RUTA_ICONO_PERFIL = "recursos/icons/iconGuest.png";
    private static final boolean TE_BORDE_PERFIL = false;
    private static final boolean ES_TRANSPARENT_PERFIL = false;
    private static final boolean TE_FOCUS_PERFIL = false;
    private static final String COMANDO_PERFIL = "OBRIR_PERFIL";
    private static final TipoBoton TIPO_PERFIL = TipoBoton.PERFIL; // Suposant el teu enum TipoBoton

    public BotonPerfil(){
        super(MIDA_BOTON_PERFIL, RUTA_ICONO_PERFIL, TE_BORDE_PERFIL, ES_TRANSPARENT_PERFIL, TE_FOCUS_PERFIL, COMANDO_PERFIL, TIPO_PERFIL);
    }
}
