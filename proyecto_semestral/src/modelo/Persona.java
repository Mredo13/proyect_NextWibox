package modelo;

public abstract class Persona {
    private String rut;
    private String nombre;
    private String direccion;
    private String correo;
    
        
    public Persona() {
        this.rut = "";
        this.nombre = "";
        this.direccion = "";
        this.correo = "";
    }

    
    public Persona(String rut, String nombre, String direccion, String correo) {
        this.rut = rut;
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
    }
    
    
    public String getRut() {
        return rut.toLowerCase();
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
    @Override
    public String toString() {
        return "Persona{" + "rut=" + rut + ", nombre=" + nombre + ", direccion=" + direccion + ", correo=" + correo + '}';
    }
    
    
}
