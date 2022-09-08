package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.PasswordField;

public class LoginController {
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	@FXML
	private Button button;
	@FXML
	private Label wrongLogIn;
	 @FXML
	    private Button btnClose;

	    @FXML
	    private Button btnMin;

	    @FXML
		public void handleButtonAction(ActionEvent event) throws Exception{
			if(event.getSource() == btnClose) {
				Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();
				stage.close();
			}
			if (event.getSource() == btnMin) {
				Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();
				stage.setIconified(true);
			}
	    }
	// Event Listener on Button[#button].onAction
	@FXML
	public void userLogIn(ActionEvent event) throws Exception {
		  if(username.getText().isEmpty() ) {
        	 Alert alert = new Alert(Alert.AlertType.ERROR);
	     		alert.setTitle("Message d'erreur");
	     		alert.setContentText ("Le nom d'utilisateur est vide!");
	     		alert.showAndWait();
        }
        else if (password.getText().isEmpty()) {
        	 Alert alert = new Alert(Alert.AlertType.ERROR);
	     		alert.setTitle("Message d'erreur");
	     		alert.setContentText ("Le mot de passe est vide!");
	     		alert.showAndWait();
        }
        else {
        	String nomUtilisateur=username.getText();
        	String MotDePasse=password.getText();
        	if(User.check(nomUtilisateur,MotDePasse)==1) {
        	Parent Window = FXMLLoader.load(getClass().getResource("Patients.fxml"));
	        
	        Scene scene = new Scene(Window);
	        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	        
	        
	        window.setScene(scene);
	        window.show();

           
        }
        	else if (User.check(nomUtilisateur,MotDePasse)==0) {
            	Parent Window = FXMLLoader.load(getClass().getResource("RV.fxml"));
    	        
    	        Scene scene = new Scene(Window);
    	        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	        
    	        
    	        window.setScene(scene);
    	        window.show();

               
            }

       

        else {
        	Alert alert = new Alert(Alert.AlertType.ERROR);
     		alert.setTitle("Message d'erreur");
     		alert.setContentText ("Le nom d'utilisateur ou le mot de passe est incorrect!");
     		alert.showAndWait();
        }
	}}
	
}
