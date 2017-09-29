/**
 * se importan las librerías y clases necesarias para el funcionamiento de la clase metadata 
 */

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
    
    /**
     * Singleton de metadata
     * como la clase Metadata puede crear todas las bases se va a instancear solo una vez y asi se usa
     */
    private static Metadata metadata;
    
    private Metadata(){
        
    }
    /**
     * si no existe la instancia la crea
     * y si existe retorna la instancia existente 
     * @return 
     */
    public static Metadata getInstance(){
        if (metadata==null){
            metadata = new Metadata();
        }
        
        return metadata;
        
    }
    
    /**
     * 
     * @param nombre 
     * Crea una nueva metadata 
     * valida si ya la metadata está creada
     * Crea el documento donde se guardarán todos los objetos de esta nueva base 
     */
    public void CrearMetadata(String nombre) {

        JSONParser parser = new JSONParser();
        File directorio = new File("META-INF/" + nombre + ".json");
        FileReader fr = null;
        File db = new File("DATA-DB/" + nombre);
        db.mkdir();

        if (directorio.exists()) {
            try {
                fr = new FileReader("META-INF/" + nombre + ".json");
            } catch (Exception e) {
                System.err.print("El archivo no se pudo abrir");
            }
        } else {
            JSONObject obj = new JSONObject();
            JSONArray atributos = new JSONArray();
            JSONArray tipos = new JSONArray();

            obj.put("Nombre", nombre);
            obj.put("Atributos", atributos);
            obj.put("Tipos", tipos);

            try (FileWriter file = new FileWriter("META-INF/" + nombre + ".json")) {
                file.write(obj.toString());
                file.flush();
            } catch (IOException e) {
            }

            System.out.println(obj);
        }

    }

    /**
     * *
     *
     * @param nombre
     * @param atributo Método encargado de insertar atributos a los JsonStores
     * Valida si el JsonStore existe y si el atributo ya se creó
     */
    public void insertar_atributo(String nombre, String atributo, String tipo) {

        if (existe(nombre)) {
            JSONParser parser = new JSONParser();
            try {
                Object obj = parser.parse(new FileReader("META-INF/" + nombre + ".json"));
                JSONObject jsonObject = (JSONObject) obj;
                JSONArray atributos = (JSONArray) jsonObject.get("Atributos");
                JSONArray tipos = (JSONArray) jsonObject.get("Tipos");
                if (!atributoexiste(atributos, atributo)) {
                    atributos.add(atributo);
                    jsonObject.put("Atributos", atributos);
                    tipos.add(tipo);
                    jsonObject.put("Tipos", tipos);
                    eliminar_meta(nombre);
                    FileWriter file = new FileWriter("META-INF/" + nombre + ".json");
                    file.write(jsonObject.toJSONString());
                    file.flush();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("la metadata no existe");
        }
    }

    /**
     *
     * @param nombre método que permite borrar metadatas ya creadas
     */
    public void eliminar_meta(String nombre) {

        File meta = new File("f://META-INF/" + nombre + ".json");
        if (meta.exists()) {
            meta.delete();
        }

    }
    
    public boolean atributoexiste(JSONArray atributos, String atributo) {
        if (atributos.isEmpty()) {
            return false;
        } else {
            for (int x = 0; x < atributos.size(); x++) {
                if((atributos.get(x).toString()).equals(atributo)){
                    return true;
                }

            }
            return false;
        }
    }

    /**
     *
     * @param nombre
     * @return si el fichero existe retorna verdadero y si no existe retorna
     * falso permite saber si existe una metadata
     */
    private boolean existe(String nombre) {
        File fichero = new File("META-INF/" + nombre + ".json");
        return fichero.exists();

    }
}
   

