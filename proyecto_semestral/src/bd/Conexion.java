
package bd;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Usuario;
import modelo.Vendedor;


        
public class Conexion {
    Connection connection = null;
    boolean conectado = false;
    public boolean isConected(){
        return conectado;
    }
    public void conectar (){
        try {
        //jdbc = es el puerto
        //mysql = motor de base de datos
        // ubicacion del elemento = localhost
        // puerto de coneccion = 3306
        //
        String url = "jdbc:mysql://localhost:3306/libreria"; 
        String user = "root";
        String password = "";    
        connection = DriverManager.getConnection(url, user, password);
        System.out.println("Concxion correcta");
        conectado = true;
            
        } catch (Exception e) {
            System.out.println("No se pudo conectar a la base de datos");
        }
    }
    public void borrar_tablas(){
        try{//todavia no bo jaj j


            String borrar_usuario = "DROP TABLE usuario";
            String borrar_vendedor = "DROP TABLE vendedor";
            PreparedStatement ps = connection.prepareStatement(borrar_usuario);
            ps.execute();
            System.out.println("Tabla usuario borrada");
            

            ps = connection.prepareStatement(borrar_vendedor);
            ps.execute();
            System.out.println("Tabla vendedor borrada");
            ps.close();
            
        }catch(Exception e){
           System.out.println("Error al crear la tabla o ya existia"); 
        }
    }
    public void crear_tablas(){
        crear_tabla_usuario();
        crear_tabla_vendedor();
        crear_tabla_desarrollador();
        crear_tabla_videojuego();
        crear_tabla_arriendo();
    }
    
    private void crear_tabla_usuario(){
        try{
            String SQL = "CREATE TABLE usuario(rut VARCHAR(12) PRIMARY KEY,nombre VARCHAR(60) NOT NULL,direccion VARCHAR(45) NOT NULL,";
            SQL += "correo VARCHAR(45) NOT NULL,fecha_de_nacimiento DATE NOT NULL,comuna VARCHAR(35) NOT NULL,telefono VARCHAR(20) NOT NULL,UNIQUE(correo))";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.execute();
            System.out.println("Tabla usuario creada");
            ps.close();
        }catch(Exception e){
           System.out.println("Error al crear la tabla usuario, o ya existia"); 
        }
    }
    
    private void crear_tabla_vendedor(){
        try{
            String SQL = "CREATE TABLE vendedor(rut VARCHAR(12) PRIMARY KEY,nombre VARCHAR(60) NOT NULL,direccion VARCHAR(45) NOT NULL,correo VARCHAR(45) NOT NULL,";
            SQL+="fono VARCHAR(20) NOT NULL,UNIQUE(correo))";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.execute();
            System.out.println("Tabla vendedor creada");
        }catch(Exception e){
           System.out.println("Error al crear la tabla vendedor, o ya existia"); 
        }
    }
    private void crear_tabla_desarrollador(){
        
    }
    private void crear_tabla_videojuego(){
        
    }
    private void crear_tabla_arriendo(){
        
    }
    public boolean agregar_usuario_BD(Usuario usuario){
        try {
        String SQL = "INSERT INTO usuario (rut, nombre, direccion, correo, fecha_de_nacimiento, comuna, telefono) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(SQL);
        
        ps.setString(1, usuario.getRut());
        ps.setString(2,usuario.getNombre());
        ps.setString(3,usuario.getDireccion());
        ps.setString(4,usuario.getCorreo());
        java.sql.Date sqlDate = new java.sql.Date(usuario.getFecha_de_nacimiento().getTime());
        ps.setDate(5, sqlDate);
        ps.setString(6,usuario.getComuna());
        ps.setString(7,usuario.getTelefono());

        ps.executeUpdate();
        
        ps.close();
            System.out.println("Usuario agregado a la base de datos");
        } catch (Exception e) {
            System.out.println("Error al agregar usuario en la base de datos\n"+e.getMessage());
        }

        return true;
    }
    public boolean agregar_vendedor_BD(Vendedor vendedor){
        try {
        String SQL = "INSERT INTO vendedor (rut, nombre, direccion, correo, fono) VALUES (?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(SQL);
        
        ps.setString(1, vendedor.getRut());
        ps.setString(2,vendedor.getNombre());
        ps.setString(3,vendedor.getDireccion());
        ps.setString(4,vendedor.getCorreo());
        ps.setString(5,vendedor.getFono());

        ps.executeUpdate();
        
        ps.close();
            System.out.println("Agregado a la base de datos");
        } catch (Exception e) {
            System.out.println("Error al agregar vendedor en la base de datos\n"+e.getMessage());
        }

        return true;
    }
    /*
    public boolean eliminarBD(String rut){
        try{
            String SQL = "Delete From paciente WHERE rut = ?";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setString(1, rut);
            
            ps.executeUpdate();        
            ps.close();
            System.out.println("Paciente eliminado de la base de datos.");
        }catch(Exception e ){
            System.out.println("Error al eliminar de la base de datos");
        } 
        return true;
    }
    public List <Paciente> obtenerBD(){//(String rut){
        try {
        String SQL = "SELECT * From paciente"; //WHERE rut = ?";
        PreparedStatement ps = connection.prepareStatement(SQL);
        

        ResultSet rs = ps.executeQuery();
        
        String run, nombre, genero, direccion, ciudad, isapre;
        int edad;
        boolean donante;
        
        List <Paciente> lista = new ArrayList<>();
        while(rs.next()){

            run = rs.getString("rut");
            nombre = nombre = rs.getString("nombre");
            genero = genero = rs.getString("genero");
            edad = rs.getInt("edad");
            direccion = rs.getString("direccion");
            ciudad = rs.getString("ciudad");
            isapre = rs.getString("isapre");
            donante = rs.getBoolean("donante");            
            Paciente paciente = new Paciente(run, nombre, genero, edad, direccion, ciudad, isapre, donante);
            lista.add(paciente);
        }
        
        
        ps.close();
            System.out.println("Datos cargados correctamente");
            return lista;
        } catch (Exception e) {
            System.out.println("Error al cargar los datos\n"+e.getMessage());
        }

        return null;
    }
    public boolean actualizarBD(Paciente paciente){
        try{
            String SQL = "UPDATE paciente SET nombre = ?, genero = ?, edad = ?, direccion = ?, ciudad = ?, isapre = ?, donante = ? WHERE rut = ?";
            PreparedStatement ps = connection.prepareStatement(SQL);
            //ResultSet rs = ps.executeQuery();
            
            ps.setString(1, paciente.getNombre());
            ps.setString(2, paciente.getGenero());
            ps.setInt(3, paciente.getEdad());
            ps.setString(4, paciente.getDireccion());
            ps.setString(5, paciente.getCiudad());
            ps.setString(6, paciente.getIsapre());
  
            ps.setBoolean(7, paciente.isDonante()); 
            
            ps.setString(8, paciente.getRut());
            
            ps.executeUpdate();        
            ps.close();
            System.out.println("Paciente Actualizado en la base de datos.");
        }catch(Exception e ){
            System.out.println("Error al actualizar de la base de datos\n"+e.getMessage());
        } 
        return true;
    }*/
}

