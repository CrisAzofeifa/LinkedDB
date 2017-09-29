/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkeddb;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import org.datos1.linkedDB.listas.ListaSimple;
import org.datos1.linkedDB.listas.NodoSimple;
import org.datos1.linkedDB.lógica.Metadata;

/**
 * FXML Controller class
 *
 * @author cris
 */
public class CrearBaseController implements Initializable {
    
    ObservableList<String> listaTipos = FXCollections.observableArrayList("Texto","Número");
    
    @FXML
    private Button CrearDB;
        
    @FXML
    private ComboBox<String> Tipos;

    @FXML
    private Button Cancelar;

    @FXML
    private TextField NombreAtributo;

    @FXML
    private TextField NombreDB;
    
    @FXML
    private Button Ayuda;
    
    @FXML
    private Button AñadirAtributo;
    
    ListaSimple<String> atributos = new ListaSimple<>();
    ListaSimple<String> tipos = new ListaSimple<>();
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Tipos.setValue("");
        Tipos.setItems(listaTipos);
    }    
    
      
    @FXML
    void crearDB(ActionEvent event) {
        String nombreDB = NombreDB.getText();
        Metadata meta = Metadata.getInstance();
        if (!nombreDB.equals("")) {
            if (!atributos.vacia()) {
                meta.CrearMetadata(nombreDB);
                NodoSimple atributo = atributos.getPrimero();
                NodoSimple tipo = tipos.getPrimero();
                while (atributo != null) {
                    String NombreAtributo = (String) atributo.getValor();
                    String NombreTipo = (String) tipo.getValor();
                    meta.insertar_atributo(nombreDB, NombreAtributo, NombreTipo);
                    atributo = atributo.getSiguiente();
                    tipo = tipo.getSiguiente();

                }
                tipos.vaciarLista();
                atributos.vaciarLista();

            } else {
                Alert FaltaAtributo = new Alert(Alert.AlertType.INFORMATION);
                FaltaAtributo.setContentText("Debe ingresar al menos un atributo");
                FaltaAtributo.show();
            }

        } else {
            Alert FaltaNombre = new Alert(Alert.AlertType.INFORMATION);
            FaltaNombre.setContentText("Debe ingresar el nombre de la base");
            FaltaNombre.show();

        }

    }


    
    @FXML
    void CancelarCreación(ActionEvent event) throws IOException {
                Parent gui = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
		Scene creacionDocs = new Scene(gui);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(creacionDocs);
		window.show();
    }
    
    public void combo(){
        ComboBox tipo = new ComboBox();
        tipo.getItems().addAll("String","int");
        this.Tipos = tipo;
    }
    
    @FXML
    public void DesplegarAyuda(ActionEvent event){
        
        Alert ayuda = new Alert(Alert.AlertType.INFORMATION);
        ayuda.setTitle("Ayuda");
        ayuda.setHeaderText("Ayuda");
        ayuda.getDialogPane().setPrefSize(500, 300);
        ayuda.setContentText("Se debe colocar el nombre de la base y añadir atributos de uno en uno, cuando se hayan añadido todos los atributos deseados haga click en el boton \"CrearBase\". Si no quiere crear la base haga click en \"Cancelar\" ");
        ayuda.show();
    }
    
    @FXML
    public void AñadirAtributo(ActionEvent event){
        String nombreAtributo = NombreAtributo.getText();
        atributos.insertar_al_final(nombreAtributo);
        atributos.print();
        System.out.println();
        String tipo = ValorTipo(Tipos.getValue());
        tipos.insertar_al_final(tipo);
        tipos.print();
        System.out.println("");
        Tipos.setValue("");
        NombreAtributo.setText("");
    }
    
    public String ValorTipo(String tipo){
        if(tipo.equals("Texto")){
            return "String";
        }else{
            return "int";
        }
        
    }
    
}
