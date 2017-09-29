
package org.datos1.linkedDB.lógica;

import java.io.File;
import org.datos1.linkedDB.listas.ListaCircular;
import org.datos1.linkedDB.listas.ListaDoble;
import org.datos1.linkedDB.listas.ListaSimple;




/**
 *
 * @author cris
 * Clase para acceder a los datos ya guardados
 */
public class AccesoDatos {
    
    
    private static AccesoDatos AccesoDatos;

    /**
     * declaración de las listas que se van a usar
     */
    public ListaDoble<String> JsonStores;
    public ListaCircular<String> Documentos;
    public ListaSimple<String> ObjetosJson;
    
    
    /**
     * constructor
     */
    private AccesoDatos() {
        this.JsonStores = new ListaDoble<>();
        this.Documentos = new ListaCircular<>();
        this.ObjetosJson = new  ListaSimple<>();
    }
    
    
     /**
     * Singleton de AccesoDatos
     * Solo se permite un instancia de Acceso a datos
     * retorna la instancia si ya existe, si no la crea
     * @return 
     */
    public static AccesoDatos getInstance(){
        
        if (AccesoDatos==null){
            AccesoDatos = new AccesoDatos();
        }
        
        return AccesoDatos;
    }
    
    /**
     * método que cargar los DocumentosJson a una lista Circular
     */
    public void cargarDatos(){
        
        File DocumentosJson = new File("DATA-DB");
        if(DocumentosJson.exists()){
            File[] Doc = DocumentosJson.listFiles();
            
            
            if(Documentos.esta_vacia()){
                for (int x=1;x<Doc.length;x++){
                    System.out.println(Doc[x].getName());
                    Documentos.insertar_al_final(Doc[x].getName());
                    JsonStores.agregar_final(Doc[x].getName()+".json");
                    System.out.println(Doc[x].getName());
                    
                }
            
            }else{
                
                for (int x=1;x<Doc.length;x++){
                    if(Documentos.existe_elemento(Doc[x].getName())){
  
                    }else{
                        Documentos.insertar_al_final(Doc[x].getName());
                        JsonStores.agregar_final(Doc[x].getName()+".json");
                    }
                }  
            }
        }

    }
        
    /**
     * 
     * @param elemento
     * @return true o false dependiendo de si existe o no el jsonStore
     * revisa si existe el jsonStore
     */
    public boolean existeJsonStore(String elemento){
        return JsonStores.existe(elemento);
    }
    
    /**
     * función que va a cargar los jsonStores a una lista 
     */
    public void cargarObjetosJson(){
        
        File f = new File("DATA-DB");
        
        if (f.exists()){
            
            File[] ficheros = f.listFiles();
            
            if(ObjetosJson.vacia()){
                for (int x=0;x<ficheros.length;x++){
                    System.out.println(ficheros[x].getName());
                    JsonStores.agregar_final(ficheros[x].getName());
                }
            
            }else{
                
                for (int x=0;x<ficheros.length;x++){
                    if(JsonStores.existe(ficheros[x].getName())){
  
                    }else{
                        JsonStores.agregar_final(ficheros[x].getName());
                    }
                }  
            }
        }
    }
        
        
       
    /**
     * imprime los jsonStores ya existentes 
     */
    public void imprimirJsonStores(){
        JsonStores.imprimir();
    }
    /**
     * método para ver los Documentos Json
     */
    public void imprimirDocumentosJson(){
        Documentos.imprimir();
    }

    public static AccesoDatos getAccesoDatos() {
        return AccesoDatos;
    }

    public ListaDoble<String> getJsonStores() {
        return JsonStores;
    }

    public ListaCircular<String> getDocumentos() {
        return Documentos;
    }

    public ListaSimple<String> getObjetosJson() {
        return ObjetosJson;
    }
    
    
}

