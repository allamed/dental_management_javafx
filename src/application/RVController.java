package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.ComboBox;

import javafx.scene.input.MouseEvent;

import javafx.scene.control.TableView;

import javafx.scene.control.DatePicker;

import javafx.scene.control.TableColumn;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class RVController {
	@FXML
	private Button btnAjouter;
	@FXML
	private Button btnClose;
	@FXML
	private Button btnModifier;
	@FXML
	private Button btnSupprimer;
	@FXML
	private Button btnConfirmer;
	@FXML
	private TableView<Intervention> tableIntervention;
	@FXML
	private TableColumn<Intervention, Integer> coliDIntervention;
	@FXML
	private TableColumn<Intervention, LocalDate> colDatePrevue;
	@FXML
	private TableColumn<Intervention, Integer> colCategorie;
	@FXML
	private TableColumn<Intervention, Integer> colNoActe;
	@FXML
	private TableColumn<Intervention, String> colEtatRV;
	@FXML
	private TableColumn<Intervention, LocalDate> colDateReelle;
	@FXML
	private TextField tfNouv;
	@FXML
	private Pane pnAjouter;
	@FXML
	private Pane pnIntervention;
	@FXML
	private Label labelIDPatient;
	@FXML
	private ComboBox<Integer> cbActeMedical;
	@FXML
	private ComboBox<String> cbCategorie;
	@FXML
	private DatePicker dpDatePrevue;
	@FXML
	private Button btnConfirmAdd;
	@FXML
	private Pane pnModifier;
	@FXML
	private Button btnConfirmEdit;
	@FXML
	private Label labelIDRV;
	@FXML
	private Label labelIDRV2;
	@FXML
	private DatePicker dpDatePrevueN;
	@FXML
	private Label labelTotal;
	@FXML
	private Label labelRV;
	@FXML
	private Label labelPasse;
	@FXML
	private Label labelFeminin;
	@FXML
	private Label labelFemininP;
	@FXML
	private TextField tfRechercheIntervention;
	@FXML
	private Button btnManage;
	@FXML
	private Pane PnTablePatient;
	@FXML
	private Pane pnChart;
	@FXML
	private TableView<Patient> tablePatients;
	@FXML
	private TableColumn<Patient, Integer> coliD;
	@FXML
	private TableColumn<Patient, String> colNom;
	@FXML
	private TableColumn<Patient, String> colPrenom;
	@FXML
	private TableColumn<Patient, LocalDate> colNaissance;
	@FXML
	private TableColumn<Patient, String> colCin;
	@FXML
	private TableColumn<Patient, String> colSex;
	@FXML
	private TextField tfRecherchePatient;

	// Event Listener on Button[#btnConfirmer].onAction
	@FXML
	public void handleButtonAction(ActionEvent event) throws IOException {

		if (event.getSource() == btnManage){
		 afficherInterventions();
        }
		else if(event.getSource() == btnAjouter){
	        	
			 pnChart.setVisible(false);
			 pnModifier.setVisible(false);
			 pnAjouter.setVisible(true);
			 pnAjouter.toFront();
			 PnTablePatient.setVisible(true);
			 pnIntervention.setVisible(false);
			 
			 
	            
	        }
		 else if (event.getSource() == btnModifier){
			 
			 pnChart.setVisible(false);
			 pnModifier.setVisible(true);
			 pnAjouter.setVisible(false);
			 
			 PnTablePatient.setVisible(false);
			 pnIntervention.setVisible(true);
		
	        	
	        }
		 else if(event.getSource() == btnSupprimer){
			 	pnChart.setVisible(true);
			 	 pnModifier.setVisible(false);
				 pnAjouter.setVisible(false);
				 
				 PnTablePatient.setVisible(false);
				 pnIntervention.setVisible(true);
			 	
	        	if (tableIntervention.getSelectionModel().getSelectedItem()== null) {
	        		Alert alert = new Alert(Alert.AlertType.ERROR);
	        		alert.setTitle("Message d'erreur");
	        		alert.setContentText ("Veuillez sélectionner le rendez-vous à annuler");;
	        		alert.showAndWait();
	        	}
	        	else {
	        		if(tableIntervention.getSelectionModel().getSelectedItem().getDateReelle()!=null) {
	        			Alert alert = new Alert(Alert.AlertType.ERROR);
		        		alert.setTitle("Message d'erreur");
		        		alert.setContentText ("L'intervention que vous avez séléctionnée est déjà passée, veuillez cocher un rendez-vous 'prévu'");;
		        		alert.showAndWait();
	        		}
	        		else {
	        		int id= tableIntervention.getSelectionModel().getSelectedItem().getIdIntervention();
	        		
	        		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		    		alert.setTitle("Confiramtion");
		    		alert.setContentText ("Voulez vous vraiment annuler le rendez-vous N° "+id+"  ? ");
		    		Optional <ButtonType> action = alert.showAndWait();
		    		if (action.get()==ButtonType.OK)
		    		{if (Intervention.supprimerIntervention(id)) {
		    			Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
		        		alert2.setTitle("Message d'information");
		        		alert2.setContentText ("le rendez-vous a bien été annulé!");;
		        		alert2.showAndWait();
		        		afficherInterventions();
		    		};
	        	}
				
	        		}}}
	        else if (event.getSource() == btnConfirmAdd) {
	        	if (tablePatients.getSelectionModel().getSelectedItem()== null) {
	        		Alert alert = new Alert(Alert.AlertType.ERROR);
	        		alert.setTitle("Message d'erreur");
	        		alert.setContentText ("Veuillez sélectionner un patient de la table");;
	        		alert.showAndWait();
	        	}
	  
	        	
        	else if (cbActeMedical.getSelectionModel().getSelectedItem()==null ||cbCategorie.getSelectionModel().getSelectedItem()==null ||dpDatePrevue.getValue()==null) {
        		Alert alert = new Alert(Alert.AlertType.ERROR);
        		alert.setTitle("Message d'erreur");
        		alert.setContentText ("Veuillez renseigner tous les champs");;
        		alert.showAndWait();
        	}
        	else {
        		int idCat=CategorieIntervention.getIdCategorie(cbCategorie.getSelectionModel().getSelectedItem()).getIdCategorie();
        		Intervention intervention = new Intervention(dpDatePrevue.getValue(),idCat , cbActeMedical.getSelectionModel().getSelectedItem());
        		afficherInterventions();
        	}
        		
        	
	        }
	        else if (event.getSource() == btnConfirmEdit) {
	        	
	        	if (labelIDRV.getText().contains("ID")) {
	        		Alert alert = new Alert(Alert.AlertType.ERROR);
	        		alert.setTitle("Message d'erreur");
	        		alert.setContentText ("Veuillez sélectionner le rendez-vous à reporter");;
	        		alert.showAndWait();
	        	}
	        	
	        	
	        	else if (dpDatePrevueN.getValue()==null ) {
        		Alert alert = new Alert(Alert.AlertType.ERROR);
        		alert.setTitle("Message d'erreur");
        		alert.setContentText ("Veuillez remplir la nouvelle date prévue");;
        		alert.showAndWait();
        	}
        	else {
           if( Intervention.reporterRV(dpDatePrevueN.getValue(), Integer.parseInt(labelIDRV.getText()) )) {
        	   Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
       		alert.setTitle("Message de confirmation");
       		alert.setContentText ("le rendez-vous numéro "+labelIDRV.getText() +" a bien été reporté");;
       		alert.showAndWait();
       		afficherInterventions();
        	  
           }
           
		 }
	        }
	        else if(event.getSource() == btnClose) {
	        	Parent Window = FXMLLoader.load(getClass().getResource("Login.fxml"));
		        
		        Scene scene = new Scene(Window);
		        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		       
		        window.setScene(scene);
		        window.show();
			}
	
	}
	@FXML
    public void initialize() {
		afficherPatients();
		afficherInterventions();
		ObservableList<CategorieIntervention> catList= CategorieIntervention.getAllCategorie();
		ObservableList<String> typeCatList = FXCollections.observableArrayList();
		for(CategorieIntervention bean : catList) {
			typeCatList.add(bean.getType());
			}
			cbCategorie.setItems(typeCatList);
	 }
	private void afficherInterventions() {
		int total=Intervention.getTotal();
		int rv=Intervention.getNbrRv();
		labelTotal.setText( String.valueOf(total) );
		labelRV.setText(String.valueOf(rv) );
		labelPasse.setText(String.valueOf(total-rv) );
		pnAjouter.setVisible(false);
    	pnModifier.setVisible(false);
    	pnChart.setVisible(true);
    	PnTablePatient.setVisible(false);
		 pnIntervention.setVisible(true);
    	ObservableList<Intervention> list = Intervention.getInterventionsList();
        
        
        
        
		   coliDIntervention.setCellValueFactory(new PropertyValueFactory<Intervention, Integer>("idIntervention"));
		   colDatePrevue.setCellValueFactory(new PropertyValueFactory<Intervention, LocalDate>("datePrevue"));
		   colDateReelle.setCellValueFactory(new PropertyValueFactory<Intervention, LocalDate>("dateReelle"));
		   colCategorie.setCellValueFactory(new PropertyValueFactory<Intervention, Integer>("categorie"));
		   colEtatRV.setCellValueFactory(new PropertyValueFactory<Intervention, String>("etatRV"));
		   colNoActe.setCellValueFactory(new PropertyValueFactory<Intervention, Integer>("acteMedical"));
	      
	       
	        
	       
	        
		   tableIntervention.setItems(list);
       
     // Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList <Intervention> filteredData = new FilteredList<>(list, b -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
        tfRechercheIntervention.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(intervention -> {
				// If filter text is empty, display all patients.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (String.valueOf(intervention.getIdIntervention()).indexOf(lowerCaseFilter) != -1 ) {
					return true; 
				} else if (String.valueOf(intervention.getActeMedical()).indexOf(lowerCaseFilter) != -1 ) {
					return true; 
				}
				
				
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Intervention> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(tableIntervention.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		tableIntervention.setItems(sortedData);
		
		
      
    }
		
	
	// Event Listener on TableView[#tablePatients].onMouseClicked
	@FXML
	public void showRowDataInTextFieldsPatient(MouseEvent event) {
		int idP=tablePatients.getSelectionModel().getSelectedItem().getIdPatient();
		ObservableList<ActeMedical> actesList=ActeMedical.getActesOfPatient(idP);
		ObservableList<Integer> noActeList = FXCollections.observableArrayList();
		for(ActeMedical bean : actesList) {
		noActeList.add(bean.getIdSoin());
		}
		cbActeMedical.setItems(noActeList);
		
		labelIDPatient.setText(String.valueOf(idP) );
		
		
		
	}
	@FXML
	public void showRowDataInTextFieldsIntervention(MouseEvent event) {
		
		labelIDRV.setText(String.valueOf(tableIntervention.getSelectionModel().getSelectedItem().getIdIntervention()) );
		labelIDRV2.setText(String.valueOf(ActeMedical.getInfoActe(tableIntervention.getSelectionModel().getSelectedItem().getActeMedical()).getIdPatient()));
		
	}
	 public void afficherPatients(){
		   
		    	
		    	
		        ObservableList<Patient> list = Patient.getPatientsList();
		        
		        
		        
		        
		        coliD.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("idPatient"));
		        colNom.setCellValueFactory(new PropertyValueFactory<Patient, String>("nom"));
		        colPrenom.setCellValueFactory(new PropertyValueFactory<Patient, String>("prenom"));
		        colNaissance.setCellValueFactory(new PropertyValueFactory<Patient, LocalDate>("dateNaissance"));
		        colCin.setCellValueFactory(new PropertyValueFactory<Patient, String>("cin"));
		        colSex.setCellValueFactory(new PropertyValueFactory<Patient, String>("sexe"));
		      
		       
		        
		       
		        
		        tablePatients.setItems(list);
		       
		     // Wrap the ObservableList in a FilteredList (initially display all data).
		        FilteredList <Patient> filteredData = new FilteredList<>(list, b -> true);
				
				// 2. Set the filter Predicate whenever the filter changes.
		        tfRecherchePatient.textProperty().addListener((observable, oldValue, newValue) -> {
					filteredData.setPredicate(patient -> {
						// If filter text is empty, display all patients.
										
						if (newValue == null || newValue.isEmpty()) {
							return true;
						}
						
						
						String lowerCaseFilter = newValue.toLowerCase();
						
						if (String.valueOf(patient.getIdPatient()).indexOf(lowerCaseFilter) != -1 ) {
							return true; 
						} else if (patient.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1) {
							return true; 
						}
						else if (patient.getPrenom().toLowerCase().indexOf(lowerCaseFilter) != -1) {
							return true; 
						}
						else if (patient.getCin().toLowerCase().indexOf(lowerCaseFilter) != -1) {
							return true; 
						}
						
						     else  
						    	 return false; // Does not match.
					});
				});
				
				// 3. Wrap the FilteredList in a SortedList. 
				SortedList<Patient> sortedData = new SortedList<>(filteredData);
				
				// 4. Bind the SortedList comparator to the TableView comparator.
				// 	  Otherwise, sorting the TableView would have no effect.
				sortedData.comparatorProperty().bind(tablePatients.comparatorProperty());
				
				// 5. Add sorted (and filtered) data to the table.
				tablePatients.setItems(sortedData);
				
				
		        
		    }
	
}
