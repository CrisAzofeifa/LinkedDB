/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkeddb;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.datos1.linkedDB.listas.ListaCircular;
import org.datos1.linkedDB.lógica.AccesoDatos;
import org.datos1.linkedDB.lógica.Metadata;
import org.datos1.linkedDB.lógica.Objeto;
import org.json.simple.parser.ParseException;

/**
 *
 * @author cris
 */
public class LinkedDB extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
        Objeto meta = Objeto.getInstance();
        meta.crearObjeto("Estudiantes", "Pepe");
        meta.insertarAtributos("Estudiantes", "Pepe", "edad");
        
        
        
        
    }


}
