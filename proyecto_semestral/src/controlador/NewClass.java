/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import bd.Conexion;
import java.text.SimpleDateFormat;
import java.util.Date;
import modelo.Fecha;
import modelo.Usuario;


public class NewClass {
    public static void main(String[]args){
        
        Fecha f = new Fecha();
        Date d = null;
        try{
            d = f.verificarFecha("12-12-10");
            SimpleDateFormat a = new SimpleDateFormat("dd-MM-yy");
            System.out.println("hoy es: "+a.format(d));
            //System.out.println(verificarFecha("20/10/20"));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        Conexion conexion = new Conexion();
        conexion.conectar();
        conexion.crear_tablas();
        conexion.borrar_tablas();
        //Usuario u = new Usuario("20.574.150-K", "Thomas Quiroga", "Direccion", "correo@gmail.com", d, "comuna", "+56 9 8888 8888");
        //conexion.agregar_usuario_BD(u);
    }
    
}
