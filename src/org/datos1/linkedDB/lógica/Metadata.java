package org.datos1.linkedDB.lógica;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;


public class Metadata {
    
    private static Metadata metadata;
    
    private Metadata(){
        
    }
    
    public static Metadata getInstance(){
        if (metadata==null){
            metadata = new Metadata();
        }
        
        return metadata;
        
    }
    
    
    public void CrearMetadata(String nombre){

       JSONParser parser = new JSONParser();
       File directorio = new File("META-INF/" + nombre+".json");
       FileReader fr = null;
       File db = new File("DATA-DB/" + nombre);
       db.mkdir(); 
       
       if (directorio.exists()) {
           try {
               fr = new FileReader("META-INF/"+nombre+".json");
           } catch (Exception e) {
               System.err.print("El archivo no se pudo abrir");
           }
       } else {
           JSONObject obj = new JSONObject();
           JSONArray list = new JSONArray();
           
           

           obj.put("Nombre", nombre);
           obj.put("Atributos", list);

           try (FileWriter file = new FileWriter("META-INF/"+nombre+".json")) {
               file.write(obj.toString());
               file.flush();
           } catch (IOException e) {
           }

           System.out.println(obj);
       }

    }
    /***
     * 
     * @param nombre
     * @param atributo 
     * Método encargado de insertar atributos a los JsonStores
     * Valida si el JsonStore existe y si el atributo ya se creó
     */
    public void insertar_atributo(String nombre, String atributo){
        
        if(existe(nombre)){
            JSONParser parser = new JSONParser();
            try {
                Object obj = parser.parse(new FileReader("META-INF/"+nombre+".json"));
                JSONObject jsonObject = (JSONObject) obj;   
                JSONArray atributos = (JSONArray) jsonObject.get("Atributos");
                atributos.add(atributo);
                jsonObject.put("Atributos", atributos);
                eliminar_meta(nombre);          
                FileWriter file = new FileWriter("META-INF/"+nombre+".json");
                file.write(jsonObject.toJSONString());
                file.flush();
                
            } catch (FileNotFoundException e) 
            {
                e.printStackTrace();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            } 
            catch (ParseException e) 
            {
                e.printStackTrace();
            }
        }else{
            System.out.println("la metadata no existe");
        }
    }

    public void eliminar_meta(String nombre){
        
        File meta = new File("f://META-INF/"+nombre+".json");
        meta.delete();
    
    }
    
    
    private boolean existe(String nombre){
        File fichero = new File("META-INF/"+nombre+".json");
        return  fichero.exists();
        
    }
}
   

