
package modelo;

import java.util.Date;

public class Fecha {

    public Fecha(){
    }
    public Date verificarFecha(String fecha){
        int dia, mes, año;
        String [] datos = new String [0];
        boolean formato_reconocido = false;
        String formato = "";
        if(fecha.contains("/")){
            formato = "/";
            datos =fecha.split("/");
            formato_reconocido=true;

            
        }else if(fecha.contains("-")){
            formato ="-";
            datos =fecha.split("-");
            formato_reconocido=true;
        }
        if(formato_reconocido){
            if(datos.length == 3){
                try{
                    dia = Integer.parseInt(datos[0]);
                    mes = Integer.parseInt(datos[1]);
                    año = Integer.parseInt(datos[2]);
                }catch(NumberFormatException e){
                    throw new NullPointerException("Error en el formato de la fecha. (tipo_de_datos)"); 
                }
            }else{
                throw new NullPointerException("Error en el formato de la fecha. (dd"+formato+"mm"+formato+"yy)");
            }
            
            if(año<0 || año>99){
                throw new NullPointerException("Año no valido");
            }
            if(mes<1 || mes>12){
                throw new NullPointerException("Mes no valido");
            }
            if(dia<1 || dia>31){
                throw new NullPointerException("Dia no valido");
            }
            if(mes==2 && dia>28){//sin tomar en cuenta bisiestos
                throw new NullPointerException("Este mes solo tiene 28 dias (no hemos implementado bisiestos)");
            }
            /*if((mes==1 || mes==3 || mes ==7 || mes ==8 || mes ==10 || mes ==12) && dia >31){
                throw new NullPointerException("Este mes solo tiene 31 dias");
            }*/
            if((mes==4 || mes ==6 || mes ==9 || mes ==11 ) && dia >30){
                throw new NullPointerException("Este mes solo tiene 30 dias");
            }
            Date date = new Date(año, mes, dia);
            return date;
        }
        throw new NullPointerException("Formato de la fecha desconocido");
    }       
}
