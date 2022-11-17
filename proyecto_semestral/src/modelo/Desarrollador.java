package modelo;

public class Desarrollador extends Persona {
    private String fono;

  

    public Desarrollador(String fono) {
        super();
        this.fono = "";
    }

    public Desarrollador(String fono, String rut, String nombre, String direccion, String correo) {
        super(rut, nombre, direccion, correo);
        this.fono = fono;
    }

    public String getFono() {
        return fono;
    }

    public void setFono(String fono) {
        this.fono = fono;
    }

    @Override
    public String toString() {
        return super.toString()+"\tDesarrollador{" + "fono=" + fono + super.toString()+'}';
    }
    
}
