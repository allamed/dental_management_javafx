package application;

import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class imageController {
	
	@FXML
    private Text DentObjetRemarque;

    @FXML
    private Button btnAjouterRemarque;
    @FXML
    private Label labelIdRadio;
    @FXML
    private Button btnSupprimerRemarque;

    @FXML
    private ComboBox<String> cbTypeRemarque;
    @FXML
    private Label labelRemarque;
    @FXML
    private TableColumn<Remarque, Integer> colId;

    @FXML
    private TableColumn<Remarque, String> colRemarque;

    @FXML
    private TableColumn<Remarque, String> colType;

    @FXML
    private ImageView img;

    @FXML
    private TextArea taRemarque;

    @FXML
    private TableView<Remarque> tableRemarques;

    @FXML
    private TextField tfX;

    @FXML
    private TextField tfY;
    @FXML
    private Button btnEffacer;

    @FXML
    void handleButtonAction(ActionEvent event) {
    	if (event.getSource() == btnEffacer) {
    		DentObjetRemarque.setVisible(false);
    		labelRemarque.setVisible(false);
    	}
    	else if (event.getSource() == btnSupprimerRemarque) {
    		if (tableRemarques.getSelectionModel().getSelectedItem()==null) {
        		Alert alert = new Alert(Alert.AlertType.ERROR);
        		alert.setTitle("Message d'erreur");
        		alert.setContentText ("Veuillez sélectionner la remarque à supprimer");
        		alert.showAndWait();
        	}
        	else {
        		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	    		alert.setTitle("Confiramtion");
	    		alert.setContentText ("Voulez vous vraiment supprimerla radio numéro "+tableRemarques.getSelectionModel().getSelectedItem().getIdRemarque() +"? ");
	    		Optional <ButtonType> action = alert.showAndWait();
	    		if (action.get()==ButtonType.OK){
	    			if(Remarque.supprimerRemarque(tableRemarques.getSelectionModel().getSelectedItem().getIdRemarque())) {
	        			Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
		        		alert2.setTitle("Message ");
		        		alert2.setContentText ("La remarque a bien été supprimée ");
		        		alert2.showAndWait();
		        		afficherRemarques();
	        		}
	    		}
	    			
	    		
        	}
    	}
    	else if (event.getSource() == btnAjouterRemarque) {
    		if (cbTypeRemarque.getSelectionModel().getSelectedItem()==null || tfX.getText().isEmpty()|| tfY.getText().isEmpty() ||taRemarque.getText().isEmpty()) {
    			Alert alert = new Alert(Alert.AlertType.ERROR);
        		alert.setTitle("Message d'erreur");
        		alert.setContentText ("Veuillez renseigner tous les champs");
        		alert.showAndWait();
    		}
    		else {
    			if (Remarque.ajouterRemarque(taRemarque.getText(),Integer.parseInt(labelIdRadio.getText()),  Double.parseDouble(tfX.getText()) , Double.parseDouble(tfY.getText()), cbTypeRemarque.getSelectionModel().getSelectedItem())) {
    				afficherRemarques();
    			}
    			else {
    				Alert alert = new Alert(Alert.AlertType.ERROR);
            		alert.setTitle("Message d'erreur");
            		alert.setContentText ("La remarque n'a pas été ajoutée!");
            		alert.showAndWait();
    			}
    		}
    	}
    }
	public void show(String path, int idRadio) {
		Image im=new Image(path);
		   
		   img.setImage(im);
		   labelIdRadio.setText(String.valueOf(idRadio));
		   afficherRemarques();
		   ObservableList<String> typeRemarque=FXCollections.observableArrayList();
			typeRemarque.add("Générale");typeRemarque.add("Positive");typeRemarque.add("Négative");
			cbTypeRemarque.setItems(typeRemarque);
			labelRemarque.setVisible(false);
	}
	@FXML
	public void interact(MouseEvent event) {
		
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Confiramtion");
		alert.setContentText ("Voulez vous marquer ce dent comme objet de remarque? ");
		Optional <ButtonType> action = alert.showAndWait();
		if (action.get()==ButtonType.OK){
			 
		
		
		DentObjetRemarque.setLayoutX(event.getX());
		DentObjetRemarque.setLayoutY(event.getY());
		
		DentObjetRemarque.setVisible(true);
		tfX.setText(String.valueOf(DentObjetRemarque.getLayoutX()));
		tfY.setText(String.valueOf(DentObjetRemarque.getLayoutY()));
		
		}
	}
	public void afficherRemarques() {
		 ObservableList<Remarque> remarqueList=Radio.getRemarques(Integer.parseInt(labelIdRadio.getText()));
		 
		 colId.setCellValueFactory(new PropertyValueFactory<Remarque, Integer>("idRemarque"));
		 colRemarque.setCellValueFactory(new PropertyValueFactory<Remarque, String>("remarque"));
		 colType.setCellValueFactory(new PropertyValueFactory<Remarque, String>("type"));
		 
		 tableRemarques.setItems(remarqueList);
	}
	
	public void localiserRemarque() {
		DentObjetRemarque.setLayoutX(tableRemarques.getSelectionModel().getSelectedItem().getxValue());
		DentObjetRemarque.setLayoutY(tableRemarques.getSelectionModel().getSelectedItem().getyValue());
		DentObjetRemarque.setVisible(true);
		labelRemarque.setLayoutX(DentObjetRemarque.getLayoutX()+50);
		labelRemarque.setLayoutY(DentObjetRemarque.getLayoutY());
		labelRemarque.setText(tableRemarques.getSelectionModel().getSelectedItem().getRemarque());
		labelRemarque.setVisible(true);
		if (tableRemarques.getSelectionModel().getSelectedItem().getType().contains("Positive") ) {
			labelRemarque.setTextFill(Color.GREEN);
		}
		else if (tableRemarques.getSelectionModel().getSelectedItem().getType().contains("Négative")) {
			labelRemarque.setTextFill(Color.RED);
		}
		else {
			labelRemarque.setTextFill(Color.BLUE);
		}
		
	}
}
