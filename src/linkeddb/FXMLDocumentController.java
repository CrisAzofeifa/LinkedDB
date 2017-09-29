/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkeddb;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TreeView;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeItem;
import javafx.stage.Stage;
import org.datos1.linkedDB.listas.ListaCircular;
import org.datos1.linkedDB.listas.ListaDoble;
import org.datos1.linkedDB.listas.NodoCircular;
import org.datos1.linkedDB.listas.NodoDoble;
import org.datos1.linkedDB.lógica.AccesoDatos;

/**
 *
 * @author cris
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button CrearDB;
    
    @FXML
    private ContextMenu OperacionesDB;

    @FXML
    private TreeView<String> VistaArbol;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MenuItem item1 = new MenuItem("dele perro");
        OperacionesDB.getItems().addAll(item1);
        RefrescarBases();
        
    }

    @FXML
    void RefrescarBases() {
        AccesoDatos datos = AccesoDatos.getInstance();
        datos.cargarDatos();
        datos.imprimirDocumentosJson();

        ListaDoble jsonStores = datos.getJsonStores();
        ListaCircular doc = datos.getDocumentos();

        NodoDoble pivote = jsonStores.getInicio();
        NodoCircular aux = doc.getPrimerNodo();
        TreeItem<String> root = new TreeItem<String>("Bases de Datos");
        for (int x = 1; x <= jsonStores.getTotal_nodos(); x++) {
            TreeItem<String> nomb = new TreeItem<String>("" + pivote.getDato());
            VistaArbol.setRoot(root);
            root.getChildren().add(nomb);
            TreeItem item = new TreeItem("" + aux.getDato());
            nomb.getChildren().add(item);
            pivote = pivote.getSiguiente();
            aux = aux.getSiguiente();
            jsonStores.imprimir();
            doc.imprimir();
        }

    }

    @FXML
    void CrearNuevaBase(ActionEvent event) throws IOException {
        Parent gui = FXMLLoader.load(getClass().getResource("CrearBase.fxml"));
        Scene creacionDocs = new Scene(gui);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(creacionDocs);
        window.show();
    }
    
    @FXML
    void OperacionesDB(ActionEvent event){
        
    }
}
