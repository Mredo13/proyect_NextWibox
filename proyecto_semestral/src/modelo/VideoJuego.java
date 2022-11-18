package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class VideoJuego {
    private String codigo;
    private String nombre;
    private String version;    
    private Date fecha_de_desarrollo;
    private String categoria;
    private String genero;
    private int precio;
    private Desarrollador desarrollador;

    public VideoJuego() {
        this.codigo = "";
        this.nombre = "";
        this.version = "";
        this.fecha_de_desarrollo = null;
        this.categoria = "";
        this.genero = "";
        this.precio = 0;
        this.desarrollador = null;
    }

    public VideoJuego(String codigo, String nombre, String version, Date fecha_de_desarrollo, String categoria, String genero, int precio, Desarrollador desarrollador) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.version = version;
        this.fecha_de_desarrollo = fecha_de_desarrollo;
        this.categoria = categoria;
        this.genero = genero;
        this.precio = precio;
        this.desarrollador = desarrollador;
    }

    public Desarrollador getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(Desarrollador desarrollador) {
        this.desarrollador = desarrollador;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Date getFecha_de_desarrollo() {
        return fecha_de_desarrollo;
    }

    public void setFecha_de_desarrollo(Date fecha_de_desarrollo) {
        this.fecha_de_desarrollo = fecha_de_desarrollo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        SimpleDateFormat a = new SimpleDateFormat("dd-MM-yy");
        return "VideoJuego{" + "codigo=" + codigo + ", nombre=" + nombre + ", version=" + version + ", fechaD=" + a.format(fecha_de_desarrollo) + ", categoria=" + categoria + ", genero=" + genero + ", precio=" + precio + ", desarrollador=" + desarrollador.toString() + '}';
    }
    
    
    
}
