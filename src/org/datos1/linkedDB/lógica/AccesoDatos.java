
package org.datos1.linkedDB.lógica;

import java.io.File;
//import org.datos1.linkedDB.listas.ListaCircular;
import org.datos1.linkedDB.listas.ListaDoble;
import org.datos1.linkedDB.listas.ListaSimple;



/**
 *
 * @author cris
 */
public class AccesoDatos {
    
    private static AccesoDatos AccesoDatos;

   
    public ListaDoble<String> JsonStores;
    //public ListaCircular<String> Documentos;
    public ListaSimple<String> ObjetosJson;
    
    private AccesoDatos() {
        this.JsonStores = new ListaDoble<>();
       // this.Documentos = new ListaCircular<>();
        this.ObjetosJson = new  ListaSimple<>();
    }
    
    public static AccesoDatos getInstance(){
        
        if (AccesoDatos==null){
            AccesoDatos = new AccesoDatos();
        }
        
        return AccesoDatos;
    }
    
    public void CargarJsonStores(){
        
        String Metadatas = ("META-INF/");
        File f = new File(Metadatas);
        
        if (f.exists()){
            
            File[] ficheros = f.listFiles();
            
            if(JsonStores.esta_vacia()){
                for (int x=0;x<ficheros.length-1;x++){
                    System.out.println(ficheros[x].getName());
                    JsonStores.agregar_final(ficheros[x].getName());
                }
            
            }else{
                
                for (int x=0;x<ficheros.length-1;x++){
                    if(JsonStores.existe(ficheros[x].getName())){
  
                    }else{
                        JsonStores.agregar_final(ficheros[x].getName());
                    }
                }  
            }
        }
    }
    
    public boolean existeJsonStore(String elemento){
        return JsonStores.existe(elemento);
    }
    
    public void cargarObjetosJson(){
        
        
        
    }
    
    public void imprimirJsonStores(){
        JsonStores.imprimir();
    }

}

