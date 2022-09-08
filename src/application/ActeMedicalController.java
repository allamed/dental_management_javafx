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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Date;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Optional;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.ComboBox;

import javafx.scene.control.DatePicker;

import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;

public class ActeMedicalController {
	@FXML
	private TextField tfNouv;
	
	@FXML
	private Pane pnAjouter;
	@FXML
	private Pane pnImageRadio;
	@FXML
	private Button btnConfirmAdd;
	@FXML
	private Button btnClose;
	@FXML
	private Button btnAccueil;
	@FXML
	private Button btnConfig;
	@FXML
	private Button btnUser;
	@FXML
	private Button btnActesMedic;
	@FXML
	private Button btnPatients;
	@FXML
	private Button btnParcourir;
	@FXML
	private DatePicker dpNaissance1;
	@FXML
	private Label labelPatient;
	@FXML
	private Label labelIDradio;
	
	@FXML
	private Pane pnModifier;
	@FXML
	private TextField tfId2;
	@FXML
	private TextField tfNom2;
	@FXML
	private TextField tfPrenom2;
	@FXML
	private DatePicker dpNaissance2;
	@FXML
	private DatePicker dpDateRadio;
	
	@FXML
	private TextField tfCin2;
	@FXML
	private ComboBox cbSex2;
	
	
	@FXML
	private ComboBox<String> cbTypeRadio;
	@FXML
	private Button btnConfirmEdit;
	
	
	@FXML
	private Pane pnChart;
	@FXML
	private Button btnAjouter;
	
	
	@FXML
	private Button btnClore;
	@FXML
	private Button btnActe;
	@FXML
	private Label labelTotal;
	@FXML
	private Label labelSoinsPasses;
	@FXML
	private Label labelSoinsEnCours;
	@FXML
	private Label labelTauxSoinsPasses;
	@FXML
	private TextField labelChemin;
	@FXML
	private Label labelTauxSoinsEnCours;
	@FXML
	private Button btnManage;
	@FXML
	private Pane PnTableActe;
	@FXML
	private TableView<ActeMedical> tableActes;
	@FXML
	private TableColumn<ActeMedical, Integer> coliDacte;
	@FXML
	private TableColumn<ActeMedical, LocalDate> colDebut;
	@FXML
	private TableColumn<ActeMedical, Float> colPrix;
	@FXML
	private TableColumn<ActeMedical, Boolean> colEtat;
	@FXML
	private TableColumn<ActeMedical, LocalDate> colFin;
	@FXML
	private TableColumn<ActeMedical, Integer> colPatientActe;
	@FXML
	private TextField tfRechercheActe;
	@FXML
	private Pane PnTablePatient;
	
	
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
	@FXML
    private DatePicker dpdebut;
	
	
	
	
	

  

    

  
    @FXML
    private Button btnAjouterRadio;

   


    @FXML
    private Button btnConfirmerIntervention;

    

    @FXML
    private Button btnSupprimerIntervention;

    @FXML
    private Button btnSupprimerRadio;
    @FXML
    private Button btnConfirmAddRadio;
    

   

    @FXML
    private TableColumn<Intervention, Integer> colCategorieIntervention;

    @FXML
    private TableColumn<Radio, String> colChemin;

    

    @FXML
    private TableColumn<Intervention, LocalDate> colDatePrevue;

    @FXML
    private TableColumn<Radio, LocalDate> colDateRadio;

    @FXML
    private TableColumn<Intervention, LocalDate> colDateReelle;

    

    @FXML
    private TableColumn<Intervention, String> colEtatRV;

   

   

    @FXML
    private TableColumn<Radio, Integer> colTypeRadio;

   
    @FXML
    private TableColumn<Intervention, Integer> coliDIntervention;

    @FXML
    private TableColumn<Radio, Integer> coliDRadio;

  

    @FXML
    private Label dateDebutSoin;

    @FXML
    private Label dateFinSoin;

    @FXML
    private DatePicker dpConfirmer;

   

    @FXML
    private Label etatActe;

    @FXML
    private Label idActe;

    @FXML
    private Label idPatient;

    @FXML
    private ImageView imageRadio;

   

    @FXML
    private Label labelIDConfirmer;

    @FXML
    private Label labelIDSupprimer;

    

    @FXML
    private Label nomPatient;

   

    @FXML
    private Pane pnConfirmerIntervention;

    @FXML
    private Pane pnConfirmerIntervention1;

    @FXML
    private Pane pnDetailActe;

   

    @FXML
    private Label prenomPatient;

    @FXML
    private Label prixComptabilise;

    @FXML
    private Label sexe;

    

    

    @FXML
    private TableView<Intervention> tableInterventions;

   

   

   
    @FXML
    private TableView<Radio> tableRadios;

   
	
	
	
	
	
	
	public void showRowDataPatient() {

		
		
	       int  index = tablePatients.getSelectionModel().getSelectedIndex();
	    if (coliD.getCellData(index)!=null)   labelPatient.setText(coliD.getCellData(index).toString());
	       
	    
	}
	
	
	@FXML
	public void handleButtonAction(ActionEvent event) throws IOException, ClassNotFoundException, InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {

		if (event.getSource() == btnManage){
		 afficherActes();
        }
		else if(event.getSource() == btnAjouter){
	        	afficherPatients();
			 pnChart.setVisible(false);
			 pnModifier.setVisible(false);
			 pnAjouter.setVisible(true);
			 pnAjouter.toFront();
			 showRowDataPatient();
	            
	        }
		
		 else if(event.getSource() == btnClore){
	        	
	        	if (tableActes.getSelectionModel().getSelectedItem()== null) {
	        		Alert alert = new Alert(Alert.AlertType.ERROR);
	        		alert.setTitle("Message d'erreur");
	        		alert.setContentText ("Veuillez sélectionner l'acte que vous voulez clore");;
	        		alert.showAndWait();
	        	}
	        	else {
	        		int id= tableActes.getSelectionModel().getSelectedItem().getIdSoin();
	        		
	        		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		    		alert.setTitle("Confiramtion");
		    		alert.setContentText ("Voulez vous vraiment terminer l'acte médical numéro "+id+"? ");
		    		Optional <ButtonType> action = alert.showAndWait();
		    		if (action.get()==ButtonType.OK)
		    			
		    		{if (ActeMedical.terminerActe(id)) {
		    			Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
		        		alert2.setTitle("Message d'information");
		        		alert2.setContentText ("l'acte numéro"+ id+" a bien été clos");
		        		alert2.showAndWait();
		        		afficherActes();
		    		};
	        	}
				
	        	}}
	        else if (event.getSource() == btnConfirmAdd) {
	        	if (  dpdebut.getValue()==null ) {
        		Alert alert = new Alert(Alert.AlertType.ERROR);
        		alert.setTitle("Message d'erreur");
        		alert.setContentText ("Veuillez renseigner la date de début\n ");
        		alert.showAndWait();
        	}else if(labelPatient.getText().contains("Nu") ) {
        		Alert alert = new Alert(Alert.AlertType.ERROR);
        		alert.setTitle("Message d'erreur");
        		alert.setContentText ("Veuillez sélectionner un élement de la table ");
        		alert.showAndWait();
        	}
        	else {
        		ActeMedical acte = new ActeMedical(dpdebut.getValue(),Integer.parseInt(labelPatient.getText()) );
        		
        		afficherActes();
        	}
	        }
	        else if (event.getSource() == btnActe) {
	        	if (tableActes.getSelectionModel().getSelectedItem()== null) {
	        		Alert alert = new Alert(Alert.AlertType.ERROR);
	        		alert.setTitle("Message d'erreur");
	        		alert.setContentText ("Veuillez sélectionner un acte du tableau d'abord");
	        		alert.showAndWait();
	        	}
        	else {
        		int idActe=tableActes.getSelectionModel().getSelectedItem().getIdSoin();
        		int idPatient=tableActes.getSelectionModel().getSelectedItem().getIdPatient();
        		pnDetailActe.setVisible(true);
        		afficherInfoActe(idActe, idPatient);
        		afficherInterventions(idActe);
        		afficherRadios(idActe);
        		
		 }
	        }
	        else if (event.getSource() == btnConfirmerIntervention) {
	        	if (tableInterventions.getSelectionModel().getSelectedItem()==null) {
	        		Alert alert = new Alert(Alert.AlertType.ERROR);
	        		alert.setTitle("Message d'erreur");
	        		alert.setContentText ("Veuillez sélectionner une intervention du tableau d'abord");
	        		alert.showAndWait();

	        	}
	        	else if (tableInterventions.getSelectionModel().getSelectedItem().getEtatRV().equals("passée")) {
	        		Alert alert = new Alert(Alert.AlertType.ERROR);
	        		alert.setTitle("Message d'erreur");
	        		alert.setContentText ("Cette intervention est déja passée");
	        		alert.showAndWait();
	        	}
	        	else if(dpConfirmer.getValue()==null) {
	        		Alert alert = new Alert(Alert.AlertType.ERROR);
	        		alert.setTitle("Message d'erreur");
	        		alert.setContentText ("Veuillez renseigner la date réelle ");
	        		alert.showAndWait();
	        	}
	        	else {
	        		if (Intervention.majIntervention(tableInterventions.getSelectionModel().getSelectedItem().getIdIntervention() , dpConfirmer.getValue())) {
	        			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		        		alert.setTitle("Message ");
		        		alert.setContentText ("L'intervention a bien été confirmée ");
		        		alert.showAndWait();
		        		afficherInterventions(Integer.parseInt(idActe.getText()) );
		        		afficherInfoActe(Integer.parseInt(idActe.getText()) ,Integer.parseInt(idPatient.getText()) );
	        		}
	        	}
	        	
	        }
	        else if (event.getSource() == btnSupprimerIntervention) {
	        	if (tableInterventions.getSelectionModel().getSelectedItem()==null) {
	        		Alert alert = new Alert(Alert.AlertType.ERROR);
	        		alert.setTitle("Message d'erreur");
	        		alert.setContentText ("Veuillez sélectionner une intervention du tableau d'abord");
	        		alert.showAndWait();

	        	}
	        	else {
	        		if(Intervention.supprimerIntervention(tableInterventions.getSelectionModel().getSelectedItem().getIdIntervention())) {
	        			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		        		alert.setTitle("Message ");
		        		alert.setContentText ("L'intervention a bien été supprimée ");
		        		alert.showAndWait();
		        		afficherInterventions(Integer.parseInt(idActe.getText()) );
	        		}
	        	}
	        }
	        else if (event.getSource() == btnAjouterRadio) {
	        	pnImageRadio.setVisible(false);
	        	
	        }
	        
	        else if (event.getSource() == btnConfirmAddRadio) {
	        	
	        	if(cbTypeRadio.getSelectionModel().getSelectedItem()==null ||dpDateRadio.getValue()==null||labelChemin.getText().isEmpty()) {
	        		Alert alert = new Alert(Alert.AlertType.ERROR);
	        		alert.setTitle("Message d'erreur");
	        		alert.setContentText ("Veuillez renseigner tous les champs");
	        		alert.showAndWait();
	        	}
	        	else {
	        		if(Radio.ajouterRadio(TypeRadio.getTypeId(cbTypeRadio.getSelectionModel().getSelectedItem()),dpDateRadio.getValue(),labelChemin.getText(),Integer.parseInt(idActe.getText())  )) {
	        			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		        		alert.setTitle("Message ");
		        		alert.setContentText ("La radio a bien été ajoutée ");
		        		alert.showAndWait();
		        		afficherRadios( Integer.parseInt(idActe.getText()) );
	        		}
	        	}
	        }
		
	        else if(event.getSource() ==btnSupprimerRadio) {
	        	pnImageRadio.setVisible(false);
	        	if (tableRadios.getSelectionModel().getSelectedItem()==null) {
	        		Alert alert = new Alert(Alert.AlertType.ERROR);
	        		alert.setTitle("Message d'erreur");
	        		alert.setContentText ("Veuillez sélectionner la radio à supprimer");
	        		alert.showAndWait();
	        	}
	        	else {
	        		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		    		alert.setTitle("Confiramtion");
		    		alert.setContentText ("Voulez vous vraiment supprimerla radio numéro "+tableRadios.getSelectionModel().getSelectedItem().getIdRadio() +"? ");
		    		Optional <ButtonType> action = alert.showAndWait();
		    		if (action.get()==ButtonType.OK){
		    			if(Radio.supprimerRadio(tableRadios.getSelectionModel().getSelectedItem().getIdRadio())) {
		        			Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
			        		alert2.setTitle("Message ");
			        		alert2.setContentText ("La radio a bien été supprimée ");
			        		alert2.showAndWait();
			        		afficherRadios( Integer.parseInt(idActe.getText()) );
		        		}
		    		}
		    			
		    		
	        	}
	        }
	        
	        else if (event.getSource() == btnAccueil) {
	        	Parent Window = FXMLLoader.load(getClass().getResource("Patients.fxml"));
		        
		        Scene scene = new Scene(Window);
		        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		       
		        window.setScene(scene);
		        window.show();
	        }
	        else if(event.getSource() == btnPatients) {
	        	 FXMLLoader loader = new FXMLLoader(getClass().getResource("Patients.fxml"));
			        Parent Window = loader.load();
			        PatientsController patientController=loader.getController();
					 patientController.patients();;
				        
			        Scene scene = new Scene(Window);
			        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			       
			        window.setScene(scene);
			        window.show();
		}  
	        else if(event.getSource() == btnUser) {
	        	
			        FXMLLoader loader = new FXMLLoader(getClass().getResource("Patients.fxml"));
			        Parent Window = loader.load();
			        PatientsController patientController=loader.getController();
					 patientController.users();
				        
			        Scene scene = new Scene(Window);
			        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			       
			        window.setScene(scene);
			        window.show();
	        }
			 else if(event.getSource() == btnConfig) {
				        	

			        FXMLLoader loader = new FXMLLoader(getClass().getResource("Patients.fxml"));
			        Parent Window = loader.load();
			        PatientsController patientController=loader.getController();
					 patientController.config();
				        
			        Scene scene = new Scene(Window);
			        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			       
			        window.setScene(scene);
			        window.show();						        
				        }
			 else if(event.getSource() == btnActesMedic) {
				 afficherActes();
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
		
		ObservableList<TypeRadio> list = TypeRadio.getTypeList();
		ObservableList<String> list2=FXCollections.observableArrayList();
		for(TypeRadio bean :list ){
			list2.add(bean.getDescription());
		}
		cbTypeRadio.setItems(list2);
		
		afficherActes();
		//types de remarques dans le combobox
				
	 }
	private void afficherActes() {
		// Mettre a jours les statistiques 
		int totalsoins =ActeMedical.totalActes("total");
		
		int soinsEnCours=ActeMedical.totalActes("encours");
		int soinsPasses=totalsoins-soinsEnCours;
		labelTotal.setText(String.valueOf(totalsoins));
		labelSoinsPasses.setText(String.valueOf(soinsPasses));
		labelSoinsEnCours.setText(String.valueOf(soinsEnCours));
		DecimalFormat df=new DecimalFormat("0.0");
		float tauxSoinsPasses=((float)soinsPasses/totalsoins)*100;	
		float tauxSoinsEnCours=((float)soinsEnCours/totalsoins)*100;
		labelTauxSoinsPasses.setText(""+String.valueOf( df.format(tauxSoinsPasses))+"%");
		labelTauxSoinsEnCours.setText(""+String.valueOf(df.format( tauxSoinsEnCours))+"%");
		
		
		pnDetailActe.setVisible(false);
		PnTableActe.setVisible(true);
    	PnTablePatient.setVisible(false);
	   
    	pnAjouter.setVisible(false);
    	pnModifier.setVisible(false);
    	pnChart.setVisible(true);
        ObservableList<ActeMedical> list = ActeMedical.getActesList();
        
        
        
        
        coliDacte.setCellValueFactory(new PropertyValueFactory<ActeMedical, Integer>("idSoin"));
        colDebut.setCellValueFactory(new PropertyValueFactory<ActeMedical, LocalDate>("debutSoin"));
        colPrix.setCellValueFactory(new PropertyValueFactory<ActeMedical, Float>("prixComptabilise"));
        colEtat.setCellValueFactory(new PropertyValueFactory<ActeMedical, Boolean>("etatActe"));
        colFin.setCellValueFactory(new PropertyValueFactory<ActeMedical, LocalDate>("finSoin"));
        colPatientActe.setCellValueFactory(new PropertyValueFactory<ActeMedical, Integer>("idPatient"));
     
        
        tableActes.setItems(list);
        
        tableActes.setRowFactory(tv -> new TableRow<ActeMedical>() {
            @Override
            protected void updateItem(ActeMedical item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null )
                    setStyle("");
                else if (item.getFinSoin()!= null)
                    setStyle("-fx-background-color: #F7EBF3");
               
            }
        });
       
     // Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList <ActeMedical> filteredData = new FilteredList<>(list, b -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
        tfRechercheActe.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(acte -> {
				// If filter text is empty, display all patients.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (String.valueOf(acte.getIdPatient()).indexOf(lowerCaseFilter) != -1 ) {
					return true; 
				} else if (String.valueOf(acte.getIdSoin()).toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; 
				}
				
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<ActeMedical> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(tableActes.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		tableActes.setItems(sortedData);
		
		
       
    
		
		
	}
	public void afficherPatients(){
			PnTableActe.setVisible(false);
	    	PnTablePatient.setVisible(true);
	    	pnAjouter.setVisible(false);
	    	pnModifier.setVisible(false);
	    	pnChart.setVisible(true);
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
	
	   public void afficherInfoActe(int idAct, int idpatient) {
		   ActeMedical acte=ActeMedical.getInfoActe(idAct);
		   idActe.setText(String.valueOf(acte.getIdSoin()) ) ;
		   dateDebutSoin.setText(String.valueOf(acte.getDebutSoin()) );
		   etatActe.setText(acte.getEtatActe());
		   dateFinSoin.setText(String.valueOf(acte.getFinSoin()) );
		   prixComptabilise.setText(String.valueOf(acte.getPrixComptabilise()));
		   
		   Patient patient=Patient.getInfoPatient(idpatient);
		   idPatient.setText(String.valueOf(patient.getIdPatient() ));
		   nomPatient.setText(patient.getNom());
		   prenomPatient.setText(patient.getPrenom());
		   sexe.setText(patient.getSexe());
	   }
	   public void afficherInterventions(int idActe) {
		   ObservableList<Intervention> list = Intervention.getInterventionsList(idActe);
	        
	        
	        
	        
		   coliDIntervention.setCellValueFactory(new PropertyValueFactory<Intervention, Integer>("idIntervention"));
		   colDatePrevue.setCellValueFactory(new PropertyValueFactory<Intervention, LocalDate>("datePrevue"));
		   colDateReelle.setCellValueFactory(new PropertyValueFactory<Intervention, LocalDate>("dateReelle"));
		   colCategorieIntervention.setCellValueFactory(new PropertyValueFactory<Intervention, Integer>("categorie"));
		   colEtatRV.setCellValueFactory(new PropertyValueFactory<Intervention, String>("etatRV"));
	        
	      
	       
	        
	       
	        
		   tableInterventions.setItems(list);
	       
	   }
	   public void afficherRadios(int idActe) {
		   pnImageRadio.setVisible(false);
		  
		   ObservableList<Radio> list = Radio.getRadiosList(idActe);
	        
	        
	        
	        
		   coliDRadio.setCellValueFactory(new PropertyValueFactory<Radio, Integer>("idRadio"));
		   colDateRadio.setCellValueFactory(new PropertyValueFactory<Radio, LocalDate>("dateRadio"));
		   colTypeRadio.setCellValueFactory(new PropertyValueFactory<Radio, Integer>("type"));
		   colChemin.setCellValueFactory(new PropertyValueFactory<Radio, String>("cheminImage"));
		   
	        
	      
	       
	        
	       
	        
		   tableRadios.setItems(list);
	   }
	   
	   @FXML
	    public void showRowDataIntervention() {
		   labelIDConfirmer.setText(String.valueOf(tableInterventions.getSelectionModel().getSelectedItem().getIdIntervention()) );
		   labelIDSupprimer.setText(String.valueOf(tableInterventions.getSelectionModel().getSelectedItem().getIdIntervention()));
	    }
	   @FXML
	    public void showRowDataRadio() {
		   
		   Image im=new Image("file:ressources/"+ tableRadios.getSelectionModel().getSelectedItem().getCheminImage());
		   
		   imageRadio.setImage(im);
		  
		   pnImageRadio.setVisible(true);
		  
		 
	    }
	   final FileChooser fc = new FileChooser();
	   
	   @FXML
	  public void handleFileChooser() throws IOException {
		   
		  fc.setTitle("choisir une image");
		 // fc.setInitialDirectory(new File(System.getProperty("C.Users.said lahbibi.eclipse-workspace.Dental_management.src.application")));
		  fc.getExtensionFilters().clear();
		  fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("image files", "*.jpeg", "*.jpg"));
		  File file=fc.showOpenDialog(null);
		  if (file!=null) {
			  labelChemin.setText(file.getName());
		  }
		  
	  }
	   public void showImage() throws IOException {
		   FXMLLoader loader = new FXMLLoader(getClass().getResource("image.fxml"));
			 Parent root = loader.load();
			 imageController controller=loader.getController();
			 controller.show("file:ressources/"+ tableRadios.getSelectionModel().getSelectedItem().getCheminImage(), tableRadios.getSelectionModel().getSelectedItem().getIdRadio());
		        
		        
		        Stage stage=new Stage();
		        stage.setScene(new Scene(root));
		        
		        stage.show();
		  
	   }
	  
	   
}
