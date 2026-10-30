package UI.view.main_frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import UI.components.Boton;
import UI.listeners.c_listnersBotons;
import UI.view.MainFrame;

public class Perfil extends javax.swing.JDialog {
    private static final String TITOL = "Perfil de usuario";
    private static final boolean MODAL = true;
    private static final Color FONDO = new Color(38, 38, 38);
    private static final Color FONDO_TARJETA = new Color(37, 42, 52);
    private static final Color TEXTO = new Color(238, 240, 245);
    private static final Color TEXTO_SUAVE = new Color(165, 174, 190);
    private static final Color ACENTO = new Color(120, 190, 160);
    private static final Dimension TAMANO = new Dimension(900, 700);
    private static final Dimension TAMANO_BOTON_CERRAR = new Dimension(42, 42);
    private static final String ICONO_CERRAR = "recursos/icons/close.png";

    public Perfil(MainFrame mainFrame) {
        super(mainFrame, TITOL, MODAL);
        setUndecorated(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        Container contenidoVentana = getContentPane();
        contenidoVentana.setLayout(new BorderLayout(0, 0));
        contenidoVentana.setBackground(FONDO);

        JPanel barraSuperior = crearBarraSuperior(mainFrame);
        contenidoVentana.add(barraSuperior, BorderLayout.NORTH);
        contenidoVentana.add(crearContenidoDesplazable(), BorderLayout.CENTER);

        setSize(TAMANO);
        setLocationRelativeTo(mainFrame);
    }

    private JPanel crearBarraSuperior(MainFrame mainFrame) {
        JPanel barra = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 8));
        barra.setBackground(FONDO);

        Boton botonCerrar = new Boton(TAMANO_BOTON_CERRAR, ICONO_CERRAR,
                false, false, FONDO);
        c_listnersBotons controlador = new c_listnersBotons(mainFrame);
        controlador.añadirListenerCerrarPerfil(botonCerrar, this);
        barra.add(botonCerrar);
        return barra;
    }

    private JScrollPane crearContenidoDesplazable() {
        JPanel contenido = new JPanel(new BorderLayout(0, 18));
        contenido.setBackground(FONDO);
        contenido.setBorder(new EmptyBorder(10, 28, 28, 28));

        contenido.add(crearPresentacion(), BorderLayout.NORTH);

        JPanel tarjetas = new JPanel(new GridLayout(0, 2, 14, 14));
        tarjetas.setBackground(FONDO);
        tarjetas.add(crearTarjeta("🎮  AHORA JUGANDO", "Hollow Knight",
                "Partida en curso · 27 h 14 min"));
        tarjetas.add(crearTarjeta("✨  PROGRESO", "68% completado",
                "34 de 50 logros desbloqueados"));
        tarjetas.add(crearTarjeta("⏱  MEJOR TIEMPO", "Celeste · Any%",
                "Récord personal: 42 min 18 s"));
        tarjetas.add(crearTarjeta("🏆  LOGROS", "127 conseguidos",
                "12 logros esta semana"));
        tarjetas.add(crearTarjeta("📚  BIBLIOTECA", "18 juegos seguidos",
                "5 completados · 3 en pausa"));
        tarjetas.add(crearTarjeta("💬  SOBRE MÍ", "Jugador tranquilo",
                "Exploración, indies y una buena historia."));
        tarjetas.add(crearTarjeta("⭐  FAVORITOS", "Hades · Celeste · Portal 2",
                "Tus juegos más rejugados."));
        tarjetas.add(crearTarjeta("🎯  OBJETIVO ACTUAL", "Terminar Hollow Knight",
                "Siguiente paso: explorar Ciudad de Lágrimas."));
        tarjetas.add(crearTarjeta("📅  ACTIVIDAD RECIENTE", "4 sesiones esta semana",
                "Última sesión: ayer por la noche."));
        tarjetas.add(crearTarjeta("🔥  RACHA", "3 días jugando",
                "Un ratito cada día, sin prisa."));
        tarjetas.add(crearTarjeta("🕹  PRÓXIMO EN LA LISTA", "Ori and the Will of the Wisps",
                "Marcado como siguiente aventura."));
        tarjetas.add(crearTarjeta("🌿  ESTILO DE JUEGO", "Explorador",
                "Te gusta mirar cada rincón del mapa."));
        contenido.add(tarjetas, BorderLayout.CENTER);

        JScrollPane scroll = new JScrollPane(contenido);
        scroll.setBorder(BorderFactory.createEmptyBorder());
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.getVerticalScrollBar().setUnitIncrement(18);
        scroll.getViewport().setBackground(FONDO);
        return scroll;
    }

    private JPanel crearPresentacion() {
        JPanel presentacion = new JPanel(new BorderLayout(18, 8));
        presentacion.setBackground(FONDO_TARJETA);
        presentacion.setBorder(new EmptyBorder(22, 24, 22, 24));

        JLabel avatar = new JLabel("O", SwingConstants.CENTER);
        avatar.setOpaque(true);
        avatar.setBackground(ACENTO);
        avatar.setForeground(new Color(25, 35, 32));
        avatar.setFont(new Font("SansSerif", Font.BOLD, 30));
        avatar.setPreferredSize(new Dimension(72, 72));
        presentacion.add(avatar, BorderLayout.WEST);

        JPanel textos = new JPanel(new GridLayout(0, 1, 0, 5));
        textos.setOpaque(false);
        textos.add(etiqueta("Obrego", 27, TEXTO, Font.BOLD));
        textos.add(etiqueta("En Tracker Gaming desde octubre de 2026", 14, TEXTO_SUAVE, Font.PLAIN));
        textos.add(etiqueta("246 horas registradas   ·   Granollers", 14, ACENTO, Font.PLAIN));
        presentacion.add(textos, BorderLayout.CENTER);
        return presentacion;
    }

    private JPanel crearTarjeta(String titulo, String dato, String detalle) {
        JPanel tarjeta = new JPanel(new GridLayout(0, 1, 0, 9));
        tarjeta.setBackground(FONDO_TARJETA);
        tarjeta.setBorder(new EmptyBorder(18, 20, 18, 20));
        tarjeta.add(etiqueta(titulo, 12, ACENTO, Font.BOLD));
        tarjeta.add(etiqueta(dato, 19, TEXTO, Font.BOLD));
        tarjeta.add(etiqueta(detalle, 13, TEXTO_SUAVE, Font.PLAIN));
        return tarjeta;
    }

    private JLabel etiqueta(String texto, int tamano, Color color, int estilo) {
        JLabel etiqueta = new JLabel(texto);
        etiqueta.setForeground(color);
        etiqueta.setFont(new Font("SansSerif", estilo, tamano));
        return etiqueta;
    }
}



