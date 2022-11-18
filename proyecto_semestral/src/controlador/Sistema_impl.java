/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.Arriendo;
import modelo.Desarrollador;
import modelo.Fecha;
import modelo.Usuario;
import modelo.Vendedor;
import modelo.VideoJuego;
import vista.Visualizador;

/**
 *
 * @author thoma
 */
public class Sistema_impl {
    private List <Desarrollador> lDesarrollador; 
    private List <Usuario> lUsuario; 
    private List <Vendedor> lVendedor; 
    private List <VideoJuego> lVideojugo; 
    private List <Arriendo> lArriendo; 
    
    public Sistema_impl(){
        lDesarrollador = new ArrayList<>();
        lUsuario = new ArrayList<>();
        lVendedor = new ArrayList<>();
        lVideojugo = new ArrayList<>();
        lArriendo = new ArrayList<>();
        
    }

    

//-------------------------------------EXTRAS-------------------------------------
    public boolean rut_unico(String rut){
        for(Desarrollador d : lDesarrollador){
            if(d.getRut().equalsIgnoreCase(rut)){
                return false;
            }
        }
        for(Vendedor v : lVendedor){
            if(v.getRut().equalsIgnoreCase(rut)){
                return false;
            }
        }
        for(Usuario u : lUsuario){
            if(u.getRut().equalsIgnoreCase(rut)){
                return false;
            }
        }
        return true;
    }
    public boolean correo_unico(String correo){
        for(Desarrollador d : lDesarrollador){
            if(d.getCorreo().equalsIgnoreCase(correo)){
                return false;
            }
        }
        for(Vendedor v : lVendedor){
            if(v.getCorreo().equalsIgnoreCase(correo)){
                return false;
            }
        }
        for(Usuario u : lUsuario){
            if(u.getCorreo().equalsIgnoreCase(correo)){
                return false;
            }
        }
        return true;
    }
    public boolean login(String usuario,String contraseña){
        for(Vendedor v:lVendedor){
            if(v.getCorreo().equals(usuario)){
                if(v.getClave().equals(contraseña)){
                    return true;
                }else{
                    throw new NullPointerException("Contraseña incorrecta.");
                }
            }
        }
        return false;
    }    
    public String como_entrar_menu_vendedor(){
        Vendedor v = lVendedor.get(0);
        String mensaje = "Menu vendedor:\n---> usuario:  "+v.getCorreo()+"\n---> clave:  "+v.getClave();
        return mensaje;
    }
//-------------------------------------INGRESAR-------------------------------------
    public void ingresarDatosPrueba(){
        Fecha f = new Fecha();
        Date date = null;
        try{
            date = f.verificarFecha("12-12-10");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        Usuario u = new Usuario("0", "0", "0", "0", date, "0", "0");
        Vendedor v = new Vendedor("1", "1", "1", "1", "1");
        Desarrollador d = new Desarrollador("2", "2", "2", "2", "2");
        VideoJuego vi = new VideoJuego("3", "3", "3", date, "3", "3", 0, d);
        lUsuario.add(u);
        lVendedor.add(v);
        lDesarrollador.add(d);
        lVideojugo.add(vi);
    }    
//-------------------------------------BUSCAR-------------------------------------

//-------------------------------------ACTUALIZAR-------------------------------------

//-------------------------------------OBTENER-------------------------------------    
    public List<String []> obtenerDatosTodos(){
        List<String[]> matriz = new ArrayList<>();
        for(int i=0;i<lUsuario.size();i++){
            Usuario p = lUsuario.get(i);         
    
            String [] datos = new String[2];
            datos[0] = "Usuario";
            datos[1] = p.getRut();
            matriz.add(datos); 
        }
        for(int i=0;i<lVendedor.size();i++){
            Vendedor p = lVendedor.get(i);         
    
            String [] datos = new String[2];
            datos[0] = "Vendedor";
            datos[1] = p.getRut();
            matriz.add(datos); 
        }
        for(int i=0;i<lDesarrollador.size();i++){
            Desarrollador p = lDesarrollador.get(i);         
    
            String [] datos = new String[2];
            datos[0] = "Desarrollador";
            datos[1] = p.getRut();
            matriz.add(datos); 
        }
        for(int i=0;i<lVideojugo.size();i++){
            VideoJuego p = lVideojugo.get(i);         
    
            String [] datos = new String[2];
            datos[0] = "Videojuego";
            datos[1] = p.getCodigo();
            matriz.add(datos); 
        }
        return matriz;
    }    
//-------------------------------------ELIMINAR-------------------------------------
    public void eliminar_usuario(String rut){
        for(Usuario u : lUsuario){
            if(u.getRut().equalsIgnoreCase(rut)){
                lUsuario.remove(u);
                if(Visualizador.base_de_datos.isConected()){
                    //Visualizador.base_de_datos.eliminarBD(rut);
                }
            }
        }

    }
    public void eliminar_vendedor(String rut){
        for(Vendedor v : lVendedor){
            if(v.getRut().equalsIgnoreCase(rut)){
                lVendedor.remove(v);
                if(Visualizador.base_de_datos.isConected()){
                    //Visualizador.base_de_datos.eliminarBD(rut);
                }
            }
        }
    }
    public void eliminar_desarrollador(String rut){
        for(Desarrollador d : lDesarrollador){
            if(d.getRut().equalsIgnoreCase(rut)){
                lDesarrollador.remove(d);
                if(Visualizador.base_de_datos.isConected()){
                    //Visualizador.base_de_datos.eliminarBD(rut);
                }
            }
        }
    }
    public void eliminar_videojuego(String codigo){
        for(VideoJuego v: lVideojugo){
            if(v.getCodigo().equals(codigo)){
                lVideojugo.remove(v);
                if(Visualizador.base_de_datos.isConected()){
                    //Visualizador.base_de_datos.eliminarBD(codigo);
                }
            }
        }
    }
}
