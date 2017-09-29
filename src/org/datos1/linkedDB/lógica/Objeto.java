package org.datos1.linkedDB.lógica;

/**
 * importa los paquetes y clases para el funcionamiento
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author cris
 */
public class Objeto {

    private static Objeto objeto;

    private Objeto() {

    }

    /**
     * singleton para Objeto
     *
     * @return la instancia o la crea
     */
    public static Objeto getInstance() {

        if (objeto == null) {
            objeto = new Objeto();
        }
        return objeto;

    }

    /**
     * Crea nuevos objetos para las bases de datos
     *
     * @param nombreDB de la base
     * @param name del nuevo objeto
     */
    public void crearObjeto(String nombreDB, String LlavePrimaria) {
        JSONParser parser = new JSONParser();
        File directorio = new File("DATA-DB/" + nombreDB + LlavePrimaria + ".json");
        FileReader fr = null;

        if (!directorio.exists()) {
            JSONObject obj = new JSONObject();
            JSONArray atributos = new JSONArray();
            JSONArray tipos = new JSONArray();
            atributos.add(LlavePrimaria);
            obj.put("LlavePrimaria", LlavePrimaria);
            obj.put("Atributos", atributos);

            try (FileWriter file = new FileWriter("DATA-DB/" + nombreDB + "/" + LlavePrimaria + ".json")) {
                file.write(obj.toString());
                file.flush();
            } catch (IOException e) {
            }

            System.out.println(obj);
        }
    }
        
    
    public void insertarAtributos(String nombreDB, String LlavePrimaria, String atributo) {
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("DATA-DB/" + nombreDB +"/"+ LlavePrimaria + ".json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray atributos = (JSONArray) jsonObject.get("Atributos");
            atributos.add(atributo);
            
            jsonObject.put("Atributos", atributos);
            eliminarObjeto(nombreDB, LlavePrimaria);
            FileWriter file = new FileWriter("DATA-DB/" + nombreDB +"/"+ LlavePrimaria + ".json");
            file.write(jsonObject.toJSONString());
            file.flush();
            
        } catch (IOException ex) {
            Logger.getLogger(Objeto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Objeto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    public void eliminarObjeto(String nombreDB, String Llaveprimaria) {

        File meta = new File("f://META-INF/" + nombreDB + ".json");
        if (meta.exists()) {
            File objeto = new File("f://DATA-DB/" + Llaveprimaria + ".json");
            if (objeto.exists()) {
                objeto.delete();
            }
        }

    }
}
