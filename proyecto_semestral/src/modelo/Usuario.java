package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Usuario extends Persona {
    
    Date fecha_de_nacimiento;
    private String comuna;
    private String telefono;
    

    public Usuario() {
        super();
        this.fecha_de_nacimiento = null; 
        this.comuna = "";
        this.telefono = "";
        
    }   

    public Usuario(String rut, String nombre, String direccion, String correo, Date fecha_de_nacimiento, String comuna, String telefono) {
        super(rut, nombre, direccion, correo);
        this.fecha_de_nacimiento = fecha_de_nacimiento;
        this.comuna = comuna;
        this.telefono = telefono;
          
    } 

    public Date getFecha_de_nacimiento() {
        return fecha_de_nacimiento;
    }

    public void setFecha_de_nacimiento(Date fecha_de_nacimiento) {
        this.fecha_de_nacimiento = fecha_de_nacimiento;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        SimpleDateFormat a = new SimpleDateFormat("dd-MM-yy");
        return super.toString()+"\tUsuario{" + "fechaN=" + a.format(fecha_de_nacimiento) + ", comuna=" + comuna + ", telefono=" + telefono + '}';
    }
    
    
}
