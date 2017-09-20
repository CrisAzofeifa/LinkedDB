/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkeddb;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.datos1.linkedDB.lógica.Metadata;
import org.datos1.linkedDB.lógica.Objeto;

/**
 *
 * @author cris
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private TextField Nombre;
    
    @FXML
    private TextField NOmbreObjeto;


    
    @FXML
    private void handleButtonAction(ActionEvent event) {

        String Texto = Nombre.getText();
        String nombre = NOmbreObjeto.getText();
        Objeto fur = Objeto.getInstance();
        fur.crearObjeto(Texto, nombre);

        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
