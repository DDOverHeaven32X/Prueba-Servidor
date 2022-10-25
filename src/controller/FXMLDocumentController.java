/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

/**
 *
 * @author 2dam
 */
public class FXMLDocumentController implements Initializable {
    
    String nombre = "Pablo";
    @FXML
    private Label lblTexto;
    @FXML
    private Button btnExit;
    
    @FXML
    private void handleExitButtonAction(ActionEvent event) {
        try{
        
        //El campo de texto está deshabilitado
        lblTexto.setDisable(true);
        
        //El botón está habilitado
        btnExit.setDisable(false);
        //Con esto vamos a crear una ventana de confirmación al pulsar el botón de salir
            Alert ventanita = new Alert(Alert.AlertType.CONFIRMATION);
            ventanita.setHeaderText(null);
            ventanita.setTitle("Advertencia");
            ventanita.setContentText("¿Deseas Salir?");
            Optional<ButtonType> action = ventanita.showAndWait();
            if (action.get() == ButtonType.OK) {
                Platform.exit();
            } else {
                ventanita.close();
            }
        }catch(Exception e){
            new Alert(Alert.AlertType.ERROR, e.getMessage() + ButtonType.OK).showAndWait();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblTexto.setText(nombre + "\n" + lblTexto.getText());
    }    
    
}
