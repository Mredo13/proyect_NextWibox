/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;

/**
 *
 * @author thoma
 */
public class Arriendo {
    private int numero_de_arriendo;
    private Date fecha_arriendo;
    private Date fecha_entrega;
    
    private VideoJuego videoJuego;
    private Usuario usuario;

    public Arriendo(int numero_de_arriendo, VideoJuego videoJuego, Usuario usuario, Date fecha_arriendo, Date fecha_entrega) {
        this.numero_de_arriendo = numero_de_arriendo;
        this.videoJuego = videoJuego;
        this.usuario = usuario;
        this.fecha_arriendo = fecha_arriendo;
        this.fecha_entrega = fecha_entrega;
    }

    public Arriendo() {
        this.numero_de_arriendo = 0;
        this.videoJuego = null;
        this.usuario = null;
        this.fecha_arriendo = null;
        this.fecha_entrega = null;
    }

    public int getNumero_de_arriendo() {
        return numero_de_arriendo;
    }

    public void setNumero_de_arriendo(int numero_de_arriendo) {
        this.numero_de_arriendo = numero_de_arriendo;
    }

    public VideoJuego getVideoJuego() {
        return videoJuego;
    }

    public void setVideoJuego(VideoJuego videoJuego) {
        this.videoJuego = videoJuego;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFecha_arriendo() {
        return fecha_arriendo;
    }

    public void setFecha_arriendo(Date fecha_arriendo) {
        this.fecha_arriendo = fecha_arriendo;
    }

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    @Override
    public String toString() {
        return "Arriendo{" + "videoJuego=" + videoJuego + ", usuario=" + usuario + '}';
    }
    
}
