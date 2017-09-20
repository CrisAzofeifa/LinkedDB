package org.datos1.linkedDB.lógica;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author cris
 */
public class Objeto {
    
    private static Objeto objeto;
    
    private Objeto(){
        
    }
    
    public static Objeto getInstance(){
        
        if (objeto==null){
            objeto = new Objeto();
        }
        return objeto;
        
    }
    
    public void crearObjeto(String nombre, String name){
       JSONParser parser = new JSONParser();
       File directorio = new File("DATA-DB/" +nombre+"/"+name+".json");
       FileReader fr = null;
       
       if (directorio.exists()) {
           try {
               fr = new FileReader("DATA-DB/" +nombre+"/"+name+".json");
           } catch (Exception e) {
               System.err.print("El archivo no se pudo abrir");
           }
       } else {
           JSONObject obj = new JSONObject();
           JSONArray list = new JSONArray();
           
           

           obj.put("Nombre", name);
           obj.put("Atributos", list);

           try (FileWriter file = new FileWriter("DATA-DB/" +nombre+"/"+name+".json")) {
               file.write(obj.toString());
               file.flush();
           } catch (IOException e) {
           }

           System.out.println(obj);
       }

    }
}
