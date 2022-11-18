/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
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
    private int contrador_arriendos;
    
    public Sistema_impl(){
        lDesarrollador = new ArrayList<>();
        lUsuario = new ArrayList<>();
        lVendedor = new ArrayList<>();
        lVideojugo = new ArrayList<>();
        lArriendo = new ArrayList<>();
        contrador_arriendos=0;
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
        Arriendo a = new Arriendo(0, vi, u, date, date);
        Arriendo a1 = new Arriendo(1, vi, u, date, date);
        
        VideoJuego vi1 = new VideoJuego("00001", "3", "3", date, "3", "3", 0, d);
        Usuario u1 = new Usuario("00.000.000-0", "0", "0", "0", date, "0", "0");
        lUsuario.add(u);
        lVendedor.add(v);
        lDesarrollador.add(d);
        lVideojugo.add(vi);
        lArriendo.add(a);
        lArriendo.add(a1);
        
        lVideojugo.add(vi1);
        lUsuario.add(u1);
    }       
    public boolean ingresarArriendo(String codigo, String rutUsuario,String fechaA, String fechaE){
        int posicionV = -1;
        for(int i=0;i<lVideojugo.size();i++){
            VideoJuego v= lVideojugo.get(i);
                if(codigo.equals(v.getCodigo())){
                    posicionV = i;
                    break;
                }
        }
        if(posicionV == -1){
            throw new NullPointerException("No existe un juego con este codigo.");
        }
        int posicionU = -1;
        for(int i=0;i<lUsuario.size();i++){
            Usuario u= lUsuario.get(i);
                if(u.getRut().equalsIgnoreCase(rutUsuario)){
                    posicionU = i;
                    break;
                }
        }
        if(posicionU == -1){
            throw new NullPointerException("No usuario con este rut.");
        }
        
        Fecha f = new Fecha();
        Date fecha_arriendo = null;
        try{
            fecha_arriendo = f.verificarFecha(fechaA);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        Date fecha_entrega = null;
        try{
            fecha_entrega = f.verificarFecha(fechaE);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        VideoJuego videojuego = lVideojugo.get(posicionV);
        Usuario usuario = lUsuario.get(posicionU);
        
        Arriendo a = new Arriendo(contrador_arriendos,videojuego, usuario,fecha_arriendo,fecha_entrega);
        lArriendo.add(a);
        lVideojugo.remove(posicionV);
        contrador_arriendos++;
        return true;
    }
//-------------------------------------BUSCAR-------------------------------------

//-------------------------------------ACTUALIZAR-------------------------------------
    public void actualizarArriendo(String num_arriendo, String fechaA, String  fechaE){
        for(int b=0;b<lArriendo.size();b++){
            Arriendo a = lArriendo.get(b);
            if(num_arriendo.equals(a.getNumero_de_arriendo())){
                Fecha f = new Fecha();
                Date fecha_arriendo = null;
                try{
                    fecha_arriendo = f.verificarFecha(fechaA);
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
                Date fecha_entrega = null;
                try{
                    fecha_entrega = f.verificarFecha(fechaE);
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
                a.setFecha_entrega(fecha_entrega);
                a.setFecha_arriendo(fecha_arriendo);

            }
        }
    }
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
    public List<String []> obtenerUsuarios(){
        List<String[]> matriz = new ArrayList<>();
        for(int i=0;i<lUsuario.size();i++){
            Usuario p = lUsuario.get(i);             
            String [] datos = new String[4];
            
            datos[0] = p.getRut();
            datos[1] = p.getNombre();
            datos[2] = p.getDireccion();
            datos[3] = p.getCorreo();
            matriz.add(datos); 
        }
        return matriz;
    }
    public List<String []> obtenerVendedores(){
        List<String[]> matriz = new ArrayList<>();
        for(int i=0;i<lVendedor.size();i++){
            Vendedor p = lVendedor.get(i);             
            String [] datos = new String[4];
            
            datos[0] = p.getRut();
            datos[1] = p.getNombre();
            datos[2] = p.getDireccion();
            datos[3] = p.getCorreo();
            matriz.add(datos); 
        }
        return matriz;
    }
    public List<String []> obtenerDesarrollador(){
        List<String[]> matriz = new ArrayList<>();
        for(int i=0;i<lDesarrollador.size();i++){
            Desarrollador p = lDesarrollador.get(i);             
            String [] datos = new String[4];
            
            datos[0] = p.getRut();
            datos[1] = p.getNombre();
            datos[2] = p.getDireccion();
            datos[3] = p.getCorreo();
            matriz.add(datos); 
        }
        return matriz;
    }
    public List<String []> obtenerVideojuego(){
        List<String[]> matriz = new ArrayList<>();
        SimpleDateFormat form = new SimpleDateFormat("dd-MM-yy");
        for(int i=0;i<lVideojugo.size();i++){
            VideoJuego v = lVideojugo.get(i);             
            String [] datos = new String[4];
            
            datos[0] = v.getCodigo();
            datos[1] = v.getNombre();
            datos[2] = v.getPrecio()+"";
            datos[3] = v.getDesarrollador().getRut();
            matriz.add(datos); 
        }
        return matriz;
    }
    public List<String []> obtenerArriendos(){
        List<String[]> matriz = new ArrayList<>();
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yy");
        for(int i=0;i<lArriendo.size();i++){
            Arriendo a = lArriendo.get(i);         
            String [] datos = new String[5];
            datos[0] = a.getNumero_de_arriendo()+"";
            datos[1] = a.getUsuario().getRut();
            datos[2] = a.getVideoJuego().getCodigo();
            datos[3] = formato.format(a.getFecha_arriendo());
            datos[4] = formato.format(a.getFecha_entrega());
            matriz.add(datos); 
        }
        return matriz;
    }
    public String [] obtener_arriendo(String nro_arriendo){
        String [] datos = new String[4];
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yy");
        for(int i=0;i<lArriendo.size();i++){
            Arriendo a = lArriendo.get(i);
            if(nro_arriendo.equals(a.getNumero_de_arriendo()+"")){
                datos[0] = a.getUsuario().getRut();
                datos[1] = a.getVideoJuego().getCodigo();
                datos[2] = formato.format(a.getFecha_arriendo());
                datos[3] = formato.format(a.getFecha_entrega());
            }
        }
        return datos;
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
    public void eliminar_arriendo(String num_arriendo){
        for(Arriendo a: lArriendo){
            if(num_arriendo.equals(a.getNumero_de_arriendo())){
                lVideojugo.add(a.getVideoJuego());
                lArriendo.remove(a);
                if(Visualizador.base_de_datos.isConected()){
                    //Visualizador.base_de_datos.eliminarBD(codigo);
                }
            }
        }
    }
}