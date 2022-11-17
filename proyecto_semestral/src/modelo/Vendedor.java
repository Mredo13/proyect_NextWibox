package modelo;

public class Vendedor extends Persona {
    String fono;
    String clave;

  
    public Vendedor() {
        super("", "", "", "");
        this.fono = "";
        this.clave = this.generarClave();//comprobar error
    }

    public Vendedor(String rut, String nombre, String direccion, String correo, String fono) {
        super(rut, nombre, direccion, correo);
        this.fono = fono;
        this.clave = this.generarClave();
    }
    
    public String getFono() {
        return fono;
    }

    public void setFono(String fono) {
        this.fono = fono;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public String generarClave() {
        String contraseña = super.getRut().replace(".", "");
        contraseña = contraseña.replace("-","");
        return contraseña;
    }

    @Override
    public String toString() {
        return super.toString()+"\tVendedor{" + "fono=" + fono + ", clave=" + clave + '}';
    }
    
}
