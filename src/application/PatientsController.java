package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;

import java.awt.Desktop;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.SocketTimeoutException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import application.Patient;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TableColumn;

public class PatientsController {
	
	@FXML
    private Button btnActeMedic;
	@FXML
    private Button btnClose;
	@FXML
    private Button btnUsers;
	@FXML
    private Button btnPatients;
	@FXML
    private Button btnOrdonnance;
	@FXML
    private Button btnManage;
	@FXML
    private Button btnEvolution;
	@FXML
    private Button btnRetour;
	@FXML
    private Button btnAjouter;
	@FXML
    private Button btnAccueil;
	@FXML
	private PieChart piePatients;
	@FXML
	private PieChart pieInterventions;

    @FXML
    private Button btnModifier;

    @FXML
    private Button btnSupprimer;
    @FXML
    private Button btnAjouterCat;
    @FXML
    private Button btnModifierCat;
    @FXML
    private Button btnSupprimerCat;
    @FXML
    private Button btnAjouterTypeRadio;
    @FXML
    private Button btnModifierTypeRadio;
    @FXML
    private Button btnSupprimerTypeRadio;
    @FXML
    private Button btnConfig;
    @FXML
    private Button btnAjouterCouv;
    @FXML
    private Button btnModifierCouv;
    @FXML
    private Button btnSupprimerCouv;

	@FXML
    private ComboBox<String> cbSex1;
	@FXML
    private ComboBox<String> cbFonction;

    @FXML
    private ComboBox<String> cbSex2;
    @FXML
    private ComboBox<String> cbCouv;
    @FXML
    private ComboBox<String> cbCouv2;

    @FXML
    private PieChart chart;
    @FXML
    private LineChart lineChart;
    @FXML
    private LineChart lineChart2;

    

    @FXML
    private DatePicker dpNaissance1;

    @FXML
    private DatePicker dpNaissance2;

    @FXML
    private Label labelFeminin;
    @FXML
    private Label labelFemininP;


    @FXML
    private Label labelMasculin;
    @FXML
    private Label labelMasculinP;

    @FXML
    private Label labelTotal;
    @FXML
    private Label labelIDO;
    @FXML
    private Label labelNomO;
    @FXML
    private Label labelPrenomO;
    @FXML
    private TextArea taOrdonnance;
    
    
    
    

    @FXML
    private Pane pnAjouter;
    @FXML
    private Pane pnConfig;
    @FXML
    private Pane pnOrdonnance;

    @FXML
    private Pane pnChart;
    @FXML
    private Pane pnUser;
    @FXML
    private Pane pnEvolutionPatient;
    

    @FXML
    private Pane pnModifier;
    @FXML
    private Pane pnStats;
    
    @FXML
    private TextField tfCin1;

    @FXML
    private TextField tfCin2;

    @FXML
    private TextField tfId1;

    @FXML
    private TextField tfId2;

    @FXML
    private TextField tfNom1;

    @FXML
    private TextField tfNom2;

    @FXML
    private TextField tfNouv;

    @FXML
    private TextField tfPrenom1;

    @FXML
    private TextField tfPrenom2;

    @FXML
    private TextField tfRecherche;
    @FXML
    private TextField tfLogin;
    @FXML
    private TextField tfPassword;
    @FXML
    private TextField tfIdCatInt;
    @FXML
    private TextField tfCatInt;
    @FXML
    private TextField  tfPrixCat;
    @FXML
    private TextField tfIdTypeRadio;
    @FXML
    private TextField tfTypeRadio;
    @FXML
    private TextField tfIdCouv;
    @FXML
    private TextField tfTypeCouv;

	 @FXML
	private ComboBox<String> cbSex;
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
	private TableColumn<Patient, Integer> colCouv;
	@FXML
	private TableView<CategorieIntervention> tableCatInt;
	@FXML
	private TableColumn<CategorieIntervention, Integer> colIdCatInt;
	@FXML
	private TableColumn<CategorieIntervention, String> colCatInt;
	@FXML
	private TableColumn<CategorieIntervention, Float> colPrixCat;
	
	@FXML
	private TableView<TypeRadio> tableTypeRadio;
	@FXML
	private TableColumn<TypeRadio, Integer> colIdTypeRadio;
	@FXML
	private TableColumn<TypeRadio, String> colTypeRadio;
	
	@FXML
	private TableView<CouvertureMedicale> tableCouverture;
	@FXML
	private TableColumn<CouvertureMedicale, Integer> colIdCouverture;
	@FXML
	private TableColumn<CouvertureMedicale, String> colTypeCouverture;
	
	
	@FXML
	private TableView<User> tableUsers;
	@FXML
	private TableColumn<User, String> colLogin;
	@FXML
	private TableColumn<User, String> colPassword;
	@FXML
	private TableColumn<User, String> colFonction;
	 @FXML
	    private Button btnConfirmAdd;

	    @FXML
	    private Button btnConfirmEdit;
	    @FXML
	    private Button btnExportPDF;
	    @FXML
	    private Button btnConfirmAddUser;
	    @FXML
	    private Button btnSupprimerUser;
	    
//*******Initialisation**********************************************
	    @FXML
	    public void initialize() {
			statistics();
			pnUser.setVisible(false);
			pnConfig.setVisible(false);
			
			ObservableList<String> sexList = FXCollections.observableArrayList();
			sexList.add("Masculin");
			sexList.add("Feminin");
		cbSex1.setItems(sexList);
		cbSex2.setItems(sexList);
		
		ObservableList<String> fonctionList = FXCollections.observableArrayList();
		fonctionList.add("Dentiste");
		fonctionList.add("Assistant");
		cbFonction.setItems(fonctionList);
		ObservableList<String> couvList= CouvertureMedicale.getListCouvertures();
		cbCouv.setItems(couvList);
		cbCouv2.setItems(couvList);
		
		 afficherPatients();
		 }
		
		
	
	
//*******Fonction qui gère le clic sur les boutons**********************************************	
	
	@FXML
	public void handleButtonAction(ActionEvent event) throws Exception {
		if (event.getSource() == btnManage){
		 afficherPatients();
        }
					//*************gestion des patients ***********
		else if(event.getSource() == btnAjouter){
	        	
			 pnChart.setVisible(false);
			 pnModifier.setVisible(false);
			 pnAjouter.setVisible(true);
			 pnAjouter.toFront();
	            
	        }
		 else if (event.getSource() == btnModifier){
			 if (tablePatients.getSelectionModel().getSelectedItem()== null) {
	        		Alert alert = new Alert(Alert.AlertType.ERROR);
	        		alert.setTitle("Message d'erreur");
	        		alert.setContentText ("Veuillez sélectionner le patient à modifier");;
	        		alert.showAndWait();
	        	}
			 pnChart.setVisible(false);
			 pnModifier.setVisible(true);
			 pnAjouter.setVisible(false);
			 pnModifier.toFront();
			 showRowDataInTextFields();
			 
	        //supprimer un patient	
	        }else if(event.getSource() == btnSupprimer){
	        	
	        	if (tablePatients.getSelectionModel().getSelectedItem()== null) {
	        		Alert alert = new Alert(Alert.AlertType.ERROR);
	        		alert.setTitle("Message d'erreur");
	        		alert.setContentText ("Veuillez sélectionner le patient à supprimer");;
	        		alert.showAndWait();
	        	}
	        	else {
	        		int id= tablePatients.getSelectionModel().getSelectedItem().getIdPatient();
	        		String nom =tablePatients.getSelectionModel().getSelectedItem().getNom();
	        		String prenom =tablePatients.getSelectionModel().getSelectedItem().getPrenom();
	        		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		    		alert.setTitle("Confiramtion");
		    		alert.setContentText ("Voulez vous vraiment supprimer "+nom+" "+ prenom+" de la liste ? ");
		    		Optional <ButtonType> action = alert.showAndWait();
		    		if (action.get()==ButtonType.OK)
		    		{if (Patient.supprimerPatient(id)) {
		    			Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
		        		alert2.setTitle("Message d'information");
		        		alert2.setContentText ("le patients a bien été supprimé!");;
		        		alert2.showAndWait();
		        		afficherPatients();
		    		};
	        	}
				
	        	}}
		//confirmer l'ajout d'un patient
	        else if (event.getSource() == btnConfirmAdd) {
	        	if ( tfNom1.getText().isEmpty() || tfPrenom1.getText().isEmpty() || tfCin1.getText().isEmpty() || dpNaissance1.getValue()==null || cbSex1.getSelectionModel().getSelectedItem().isEmpty()) {
        		Alert alert = new Alert(Alert.AlertType.ERROR);
        		alert.setTitle("Message d'erreur");
        		alert.setContentText ("Veuillez remplir tous les champs\n ");
        		alert.showAndWait();
        	}
        	else {
        		if (cbCouv.getSelectionModel().getSelectedItem()==null) {
        			Patient patient = new Patient(dpNaissance1.getValue(), tfCin1.getText(), tfNom1.getText(), tfPrenom1.getText(), cbSex1.getSelectionModel().getSelectedItem().toString(),0 );
        		}
        		else {
        			int couv =CouvertureMedicale.getIdCouverture(cbCouv.getSelectionModel().getSelectedItem());
        			Patient patient = new Patient(dpNaissance1.getValue(), tfCin1.getText(), tfNom1.getText(), tfPrenom1.getText(), cbSex1.getSelectionModel().getSelectedItem().toString(),couv );
        		}
        		
        		afficherPatients();
        	}
	        }
		//confirmer la modification d'un patient
	        else if (event.getSource() == btnConfirmEdit) {
	        	if (tfNom2.getText().isEmpty() || tfPrenom2.getText().isEmpty() || tfCin2.getText().isEmpty() || dpNaissance2.getValue()==null || cbSex2.getSelectionModel().getSelectedItem().isEmpty() ) {
        		Alert alert = new Alert(Alert.AlertType.ERROR);
        		alert.setTitle("Message d'erreur");
        		alert.setContentText ("Veuillez remplir tout les champs");;
        		alert.showAndWait();
        	}
        	else {
           if( Patient.modifierPatient(Integer.parseInt(tfId2.getText()) ,tfNom2.getText(), tfPrenom2.getText(), tfCin2.getText(), dpNaissance2.getValue(), cbSex2.getSelectionModel().getSelectedItem(), cbCouv2.getSelectionModel().getSelectedItem())) {
        	   Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
       		alert.setTitle("Message de confirmation");
       		alert.setContentText ("les modifications ont bien été enregistrées!");;
       		alert.showAndWait();
        	   afficherPatients();
           }
           
		 }
	        }
		//*************Afficher l'evolution des patients dans le temps ***********
	        else if (event.getSource() == btnEvolution) {
	        	pnEvolutionPatient.setVisible(true);
	        }
	        else if (event.getSource() == btnRetour) {
	        	pnEvolutionPatient.setVisible(false);
	        }
		//*************Rédiger une ordonnance ***********
	        else if (event.getSource() == btnOrdonnance) {
	        	if (tablePatients.getSelectionModel().getSelectedItem()== null) {
	        		Alert alert = new Alert(Alert.AlertType.ERROR);
	        		alert.setTitle("Message d'erreur");
	        		alert.setContentText ("Veuillez sélectionner le patient concerné de l'ordonnance");;
	        		alert.showAndWait();
	        	}
	        	else {
	        		pnOrdonnance.setVisible(true);
	        	}
	        }
		//exporter l'ordonnance en PDF
	        else if(event.getSource() == btnExportPDF) {
	        	if (taOrdonnance.getText().isEmpty()) {
	        		Alert alert = new Alert(Alert.AlertType.ERROR);
	        		alert.setTitle("Message d'erreur");
	        		alert.setContentText ("le contenu de l'ordonnance est vide");;
	        		alert.showAndWait();
	        	}
	        	else {
	        		Document document = new Document();
	        		boolean done=true;
	        		try {
	        			FileOutputStream fos=new FileOutputStream("Ordonnance" + String.valueOf(tablePatients.getSelectionModel().getSelectedItem().getIdPatient())+".pdf");
	        		PdfWriter writer = PdfWriter.getInstance(document,fos );  
	        	
	        		writer.open();
	        		document.open();
	        		Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
	        		document.setMarginMirroring(true);
	        	
	        		document.add(new Paragraph("\nPatient N°:"+ tablePatients.getSelectionModel().getSelectedItem().getIdPatient())); 
	        		document.add(new Paragraph("Nom: "+ tablePatients.getSelectionModel().getSelectedItem().getNom()));
	        		document.add(new Paragraph("Prénom: " + tablePatients.getSelectionModel().getSelectedItem().getPrenom() ));
	        		document.add(new Paragraph("\n \n\n " + taOrdonnance.getText()));
	        		LocalDate today= LocalDate.now();
	        		document.add(new Paragraph("\n \n \n \t\t Date :  " + today.toString()));
	        		
	        		document.close();
	        		writer.close();
	        		
	        	
	        		}catch (Exception e) {
	        			done=false;
	        			e.printStackTrace();
	        		}
	        		if (done) {
	        			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	               		alert.setTitle("Message de confirmation");
	               		alert.setContentText ("les modifications ont bien été enregistrées!");;
	               		alert.showAndWait();
	               		afficherPatients();
	               		
	               		
	        		}
	        	}
	        }
		
	        
		//*************Gestion des utilisateurs***********
	        else if(event.getSource() == btnUsers) {
	        	users();
	        }
		//ajouter un utilisateur
	        else if(event.getSource() == btnConfirmAddUser) {
	        	if (tfLogin.getText().isEmpty()|| tfPassword.getText().isEmpty()||cbFonction.getSelectionModel().getSelectedItem()==null) {
	        		Alert alert = new Alert(Alert.AlertType.ERROR);
	        		alert.setTitle("Message d'erreur");
	        		alert.setContentText ("Veuillez remplir les trois champs");;
	        		alert.showAndWait();
	        	}
	        	else {
	        		if (User.ajouterUtilisateur(tfLogin.getText(),tfPassword.getText(), cbFonction.getSelectionModel().getSelectedItem() )) {
	        			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	               		alert.setTitle("Message de confirmation");
	               		alert.setContentText ("l'utilisateur a bien été ajouté ");;
	               		alert.showAndWait();
	               		afficherUtilisateurs();	
	        		}
	        	}
	        }
		// supprimer un utilisateur
	        else if(event.getSource() == btnSupprimerUser) {
	        	if(tableUsers.getSelectionModel().getSelectedItem()==null) {
	        		Alert alert = new Alert(Alert.AlertType.ERROR);
	        		alert.setTitle("Message d'erreur");
	        		alert.setContentText ("Veuillez sélectionner l'utilisateur à supprimer");;
	        		alert.showAndWait();
	        	}
	        	else {
	        		if(User.supprimerUtilisateur(tableUsers.getSelectionModel().getSelectedItem())) {
	        			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	               		alert.setTitle("Message de confirmation");
	               		alert.setContentText ("les modifications ont bien été enregistrées!");;
	               		alert.showAndWait();
	               		afficherUtilisateurs();
	        		}
	        	}
	        }
		//*************Changer vers l'interface configuration ***********
	        else if (event.getSource() == btnConfig) {
	        	config();
	        }
		//*************Retourner à l'accueil ***********
	        else if (event.getSource() == btnAccueil) {
	        	Parent Window = FXMLLoader.load(getClass().getResource("Patients.fxml"));
		        
		        Scene scene = new Scene(Window);
		        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		       
		        window.setScene(scene);
		        window.show();
	        }
		//*************GESTION DES CATEGORIES D'INTERVENTION ***********
	        else if (event.getSource() == btnAjouterCat) {
	        	if(tfIdCatInt.getText().isEmpty() || tfCatInt.getText().isEmpty() || tfPrixCat.getText().isEmpty()) {
	        		Alert alert = new Alert(Alert.AlertType.ERROR);
	        		alert.setTitle("Message d'erreur");
	        		alert.setContentText ("Veuillez renseigner tous les champs");;
	        		alert.showAndWait();
	        	}
	        	else if (!isInteger(tfIdCatInt)){
	        		Alert alert = new Alert(Alert.AlertType.ERROR);
	        		alert.setTitle("Message d'erreur");
	        		alert.setContentText ("Le prix de base n'est pas valide");;
	        		alert.showAndWait();
	        	}
	        	else if (!isFloat(tfPrixCat)){
	        		Alert alert = new Alert(Alert.AlertType.ERROR);
	        		alert.setTitle("Message d'erreur");
	        		alert.setContentText ("Le prix de base n'est pas valide");;
	        		alert.showAndWait();
	        	}
	        	else {
	        		if( CategorieIntervention.ajouterCategorieIntervention(Integer.parseInt(tfIdCatInt.getText()) ,tfCatInt.getText(),Float.parseFloat(tfPrixCat.getText())  )) {
	        			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	               		alert.setTitle("Message de confirmation");
	               		alert.setContentText ("la catégorie a bien été ajoutée");;
	               		alert.showAndWait();
	               		afficherCategories();
	        		}
	        	}
	        }
	        else if (event.getSource() == btnModifierCat) {
	        	if(tfIdCatInt.getText().isEmpty() || tfCatInt.getText().isEmpty() || tfPrixCat.getText().isEmpty()) {
	        		Alert alert = new Alert(Alert.AlertType.ERROR);
	        		alert.setTitle("Message d'erreur");
	        		alert.setContentText ("Veuillez renseigner tous les champs");;
	        		alert.showAndWait();
	        	}
	        	else if (!isInteger(tfIdCatInt)){
	        		Alert alert = new Alert(Alert.AlertType.ERROR);
	        		alert.setTitle("Message d'erreur");
	        		alert.setContentText ("Le numéro de la catégorie n'est pas valide");;
	        		alert.showAndWait();
	        	}
	        	else if (!isFloat(tfPrixCat)){
	        		Alert alert = new Alert(Alert.AlertType.ERROR);
	        		alert.setTitle("Message d'erreur");
	        		alert.setContentText ("Le prix de base n'est pas valide");;
	        		alert.showAndWait();
	        	}
	        	else {
	        		if( CategorieIntervention.majCategorieIntervention(Integer.parseInt(tfIdCatInt.getText()) ,tfCatInt.getText(),Float.parseFloat(tfPrixCat.getText())  )) {
	        			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	               		alert.setTitle("Message de confirmation");
	               		alert.setContentText ("la catégorie a bien été modifiée");;
	               		alert.showAndWait();
	               		afficherCategories();
	        		}
	        	
	        	}
	        }
	        else if (event.getSource() == btnSupprimerCat) {
	        	if (tableCatInt.getSelectionModel().getSelectedItem()==null) {
	        		Alert alert = new Alert(Alert.AlertType.ERROR);
	        		alert.setTitle("Message d'erreur");
	        		alert.setContentText ("veuillez selectionner une catégorie du tableau ci-contre");;
	        		alert.showAndWait();
	        	}
	        	else {
	        		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		    		alert.setTitle("Confiramtion");
		    		alert.setContentText ("Voulez vous vraiment supprimer la catégorie numéro "+tableCatInt.getSelectionModel().getSelectedItem().getIdCategorie() +"? ");
		    		Optional <ButtonType> action = alert.showAndWait();
		    		if (action.get()==ButtonType.OK){
		    			if( CategorieIntervention.supprimerCategorie(tableCatInt.getSelectionModel().getSelectedItem().getIdCategorie())) {
		    				Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
			        		alert2.setTitle("Message ");
			        		alert2.setContentText ("La catégorie a bien été supprimée ");
			        		alert2.showAndWait();
			        		afficherCategories();
		    			}
		    		}
	        		
	        	}
	        	
	        }
		//type radios
	        else if (event.getSource() == btnAjouterTypeRadio) {
	        	if(tfIdTypeRadio.getText().isEmpty() || tfTypeRadio.getText().isEmpty() ) {
	        		Alert alert = new Alert(Alert.AlertType.ERROR);
	        		alert.setTitle("Message d'erreur");
	        		alert.setContentText ("Veuillez renseigner tous les champs");;
	        		alert.showAndWait();
	        	}
	        	else if (!isInteger(tfIdTypeRadio)){
	        		Alert alert = new Alert(Alert.AlertType.ERROR);
	        		alert.setTitle("Message d'erreur");
	        		alert.setContentText ("Le numéro du type n'est pas valide");;
	        		alert.showAndWait();
	        	}
	        	
	        	else {
	        		if( TypeRadio.ajouterTypeRadio(Integer.parseInt(tfIdTypeRadio.getText()) ,tfTypeRadio.getText() )) {
	        			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	               		alert.setTitle("Message de confirmation");
	               		alert.setContentText ("le type a bien été ajouté");;
	               		alert.showAndWait();
	               		afficherTypesRadio();
	        		}
	        	}
	        }
	        else if (event.getSource() == btnModifierTypeRadio) {
	        	if(tfIdTypeRadio.getText().isEmpty() || tfTypeRadio.getText().isEmpty() ) {
	        		Alert alert = new Alert(Alert.AlertType.ERROR);
	        		alert.setTitle("Message d'erreur");
	        		alert.setContentText ("Veuillez renseigner tous les champs");;
	        		alert.showAndWait();
	        	}
	        	else if (!isInteger(tfIdTypeRadio)){
	        		Alert alert = new Alert(Alert.AlertType.ERROR);
	        		alert.setTitle("Message d'erreur");
	        		alert.setContentText ("Le numéro du type n'est pas valide");;
	        		alert.showAndWait();
	        	}
	        	else {
	        		if( TypeRadio.majTypeRadio(Integer.parseInt(tfIdTypeRadio.getText()) ,tfTypeRadio.getText() )) {
	        			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	               		alert.setTitle("Message de confirmation");
	               		alert.setContentText ("le type a bien été modifié");;
	               		alert.showAndWait();
	               		afficherTypesRadio();
	        		}
	        	
	        	}
	        }
	        else if (event.getSource() == btnSupprimerTypeRadio) {
	        	if (tableTypeRadio.getSelectionModel().getSelectedItem()==null) {
	        		Alert alert = new Alert(Alert.AlertType.ERROR);
	        		alert.setTitle("Message d'erreur");
	        		alert.setContentText ("veuillez selectionner un type du tableau ci-contre");;
	        		alert.showAndWait();
	        	}
	        	else {
	        		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		    		alert.setTitle("Confiramtion");
		    		alert.setContentText ("Voulez vous vraiment supprimer le type radio numéro "+tableTypeRadio.getSelectionModel().getSelectedItem().getIdTypeRadio() +"? ");
		    		Optional <ButtonType> action = alert.showAndWait();
		    		if (action.get()==ButtonType.OK){
		    			if( TypeRadio.supprimerTypeRadio(tableTypeRadio.getSelectionModel().getSelectedItem().getIdTypeRadio())) {
		    				Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
			        		alert2.setTitle("Message ");
			        		alert2.setContentText ("Le type a bien été supprimé ");
			        		alert2.showAndWait();
			        		afficherTypesRadio();
		    			}
		    		}
	        		
	        	}
	        	
	        }
		// gestion des  couvertures medicales
	        else if (event.getSource() == btnAjouterCouv) {
	        	if(tfIdCouv.getText().isEmpty() || tfTypeCouv.getText().isEmpty() ) {
	        		Alert alert = new Alert(Alert.AlertType.ERROR);
	        		alert.setTitle("Message d'erreur");
	        		alert.setContentText ("Veuillez renseigner tous les champs");;
	        		alert.showAndWait();
	        	}
	        	else if (!isInteger(tfIdCouv)){
	        		Alert alert = new Alert(Alert.AlertType.ERROR);
	        		alert.setTitle("Message d'erreur");
	        		alert.setContentText ("Le numéro de couverture n'est pas valide");;
	        		alert.showAndWait();
	        	}
	        	
	        	else {
	        		if( CouvertureMedicale.ajouterCouverture(Integer.parseInt(tfIdCouv.getText()) ,tfTypeCouv.getText() )) {
	        			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	               		alert.setTitle("Message de confirmation");
	               		alert.setContentText ("la couverture a bien été ajoutée");;
	               		alert.showAndWait();
	               		afficherCouvertures();
	        		}
	        	}
	        }
	        else if (event.getSource() == btnModifierCouv) {
	        	if(tfIdCouv.getText().isEmpty() || tfTypeCouv.getText().isEmpty() ) {
	        		Alert alert = new Alert(Alert.AlertType.ERROR);
	        		alert.setTitle("Message d'erreur");
	        		alert.setContentText ("Veuillez renseigner tous les champs");;
	        		alert.showAndWait();
	        	}
	        	else if (!isInteger(tfIdCouv)){
	        		Alert alert = new Alert(Alert.AlertType.ERROR);
	        		alert.setTitle("Message d'erreur");
	        		alert.setContentText ("Le numéro du type n'est pas valide");;
	        		alert.showAndWait();
	        	}
	        	else {
	        		if( CouvertureMedicale.majCouverture(Integer.parseInt(tfIdCouv.getText()) ,tfTypeCouv.getText() )) {
	        			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	               		alert.setTitle("Message de confirmation");
	               		alert.setContentText ("la couverture a bien été modifiée");;
	               		alert.showAndWait();
	               		afficherCouvertures();
	        		}
	        	
	        	}
	        }
	        else if (event.getSource() == btnSupprimerCouv) {
	        	if (tableCouverture.getSelectionModel().getSelectedItem()==null) {
	        		Alert alert = new Alert(Alert.AlertType.ERROR);
	        		alert.setTitle("Message d'erreur");
	        		alert.setContentText ("veuillez selectionner une couverture du tableau ci-contre");;
	        		alert.showAndWait();
	        	}
	        	else {
	        		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		    		alert.setTitle("Confiramtion");
		    		alert.setContentText ("Voulez vous vraiment supprimer la couverture médicale "+tableCouverture.getSelectionModel().getSelectedItem().getTypeCouverture() +"? ");
		    		Optional <ButtonType> action = alert.showAndWait();
		    		if (action.get()==ButtonType.OK){
		    			if( CouvertureMedicale.supprimerCouverture(tableCouverture.getSelectionModel().getSelectedItem().getIdCouverture())) {
		    				Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
			        		alert2.setTitle("Message ");
			        		alert2.setContentText ("La couverture a bien été supprimée ");
			        		alert2.showAndWait();
			        		afficherCouvertures();
		    			}
		    		}
	        		
	        	}
	        	
	        }
		//*************Changer la scene vers la gestion des actes médicaux ***********
	        else if(event.getSource() == btnActeMedic) {
	        	Parent Window = FXMLLoader.load(getClass().getResource("ActeMedical.fxml"));
		        
		        Scene scene = new Scene(Window);
		        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		       
		        window.setScene(scene);
		        window.show();
		} 
	        else if(event.getSource() == btnPatients) {
	        patients();
	        }
		//*************Se déconnecter ***********
	        else if(event.getSource() == btnClose) {
	        	Parent Window = FXMLLoader.load(getClass().getResource("Login.fxml"));
		        
		        Scene scene = new Scene(Window);
		        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		       
		        window.setScene(scene);
		        window.show();
			}
	}
	
	public void showRowDataInTextFields() {

		
		
	       int  index = tablePatients.getSelectionModel().getSelectedIndex();
	       tfId2.setEditable(true);
	        tfId2.setText(String.valueOf(coliD.getCellData(index)) );
	        tfNom2.setText(String.valueOf(colNom.getCellData(index)) );
	        tfPrenom2.setText(String.valueOf(colPrenom.getCellData(index)) );
	        tfNom2.setText(String.valueOf(colNom.getCellData(index)) );
	        dpNaissance2.setValue(colNaissance.getCellData(index));
	        tfCin2.setText(String.valueOf(colCin.getCellData(index)) );
	        cbSex2.setValue(String.valueOf(colSex.getCellData(index)));
	        tfId2.setEditable(false);
	        labelIDO.setText(String.valueOf(coliD.getCellData(index)) );
	        labelNomO.setText(String.valueOf(colNom.getCellData(index)) );
	        labelPrenomO.setText(String.valueOf(colPrenom.getCellData(index)) );
	        cbCouv2.setValue(String.valueOf(colCouv.getCellData(index)));
	       
	    
	}
	
	private void afficherTypesRadio() {
		ObservableList<TypeRadio> list = TypeRadio.getTypeList() ;
	      
		colIdTypeRadio.setCellValueFactory(new PropertyValueFactory<TypeRadio, Integer>("idTypeRadio"));
		colTypeRadio.setCellValueFactory(new PropertyValueFactory<TypeRadio, String>("description"));
		
       
		tableTypeRadio.setItems(list);
		
		tfIdTypeRadio.clear();
		tfTypeRadio.clear();
		
	}

	private void afficherCategories() {
		

		ObservableList<CategorieIntervention> list = CategorieIntervention.getAllCategorie() ;
      
		colIdCatInt.setCellValueFactory(new PropertyValueFactory<CategorieIntervention, Integer>("idCategorie"));
		colCatInt.setCellValueFactory(new PropertyValueFactory<CategorieIntervention, String>("type"));
		colPrixCat.setCellValueFactory(new PropertyValueFactory<CategorieIntervention, Float>("prixBase"));
       
		tableCatInt.setItems(list);
		
		tfIdCatInt.clear();
		tfCatInt.clear();
		tfPrixCat.clear();
        
		
	
	}

	private void afficherUtilisateurs() throws ClassNotFoundException, IOException, InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		ArrayList<User> list = User.readListFromFile();
		ObservableList list2=FXCollections.observableArrayList();
		for (User bean: list) {
			list2.add(bean);
		}
      
        colLogin.setCellValueFactory(new PropertyValueFactory<User, String>("login"));
        colPassword.setCellValueFactory(new PropertyValueFactory<User, String>("password"));
        colFonction.setCellValueFactory(new PropertyValueFactory<User, String>("fonction"));
       
        tableUsers.setItems(list2);
        tfLogin.clear();
        tfPassword.clear();
		
	}
private void afficherCouvertures() {
		

		ObservableList<CouvertureMedicale> list = CouvertureMedicale.getAllCouvertures() ;
      
		colIdCouverture.setCellValueFactory(new PropertyValueFactory<CouvertureMedicale, Integer>("idCouverture"));
		colTypeCouverture.setCellValueFactory(new PropertyValueFactory<CouvertureMedicale, String>("typeCouverture"));
		
       
		tableCouverture.setItems(list);
		
		tfIdCouv.clear();
		tfTypeCouv.clear();
		
        
		
	
	}
	void users() throws ClassNotFoundException, IOException, InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		afficherUtilisateurs();       
		pnUser.setVisible(true);
		pnConfig.setVisible(false);
		pnStats.setVisible(false);
	}
	public void config() {
		afficherTypesRadio();
		afficherCategories();
		afficherCouvertures();
		pnConfig.setVisible(true);
		pnUser.setVisible(false);
		pnStats.setVisible(false);
		
		
	}
	public void statistics() {
		updateStatistics();
		pnConfig.setVisible(false);
		pnUser.setVisible(false);
		pnStats.setVisible(true);
	}
	public void patients() {
		pnConfig.setVisible(false);
		pnUser.setVisible(false);
		pnStats.setVisible(false);
		afficherPatients();
	}

	
	   
	    public void afficherPatients(){
	    	 labelIDO.setText(null);;
		        labelNomO.setText(null );
		        labelPrenomO.setText(null );
		        taOrdonnance.clear();
	    	pnOrdonnance.setVisible(false);
	    	DecimalFormat df=new DecimalFormat("0.0");
	    	int M=Patient.totalPatients("m");
	    	int F=Patient.totalPatients("f");
	    	int T=Patient.totalPatients("t");
	    	float m= ((float)M/T)*100;
	    	float f=((float)F/T)*100;
	    	labelTotal.setText(String.valueOf(T));
	    	labelMasculin.setText(String.valueOf(M));
	    	labelFeminin.setText(String.valueOf(F));
	    	labelFemininP.setText(""+String.valueOf(df.format(f))+"%");
	    	labelMasculinP.setText(""+String.valueOf(df.format(m))+"%");
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
	        colCouv.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("couverture"));
	      
	       
	        
	       
	        
	        tablePatients.setItems(list);
	       
	     // Wrap the ObservableList in a FilteredList (initially display all data).
	        FilteredList <Patient> filteredData = new FilteredList<>(list, b -> true);
			
			// 2. Set the filter Predicate whenever the filter changes.
	        tfRecherche.textProperty().addListener((observable, oldValue, newValue) -> {
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
			
			
	       // linechart 
			XYChart.Series series = new XYChart.Series();
		    
		     ObservableList<EvolutionPatients> eList=EvolutionPatients.getList();
		     
		    for(EvolutionPatients bean : eList) {
		    	series.getData().add(new XYChart.Data(bean.getDate().toString(), bean.getEffectif()));
		    	
		    }
		    lineChart2.getData().clear();
		    lineChart2.getData().add(series);
	    }
	
	  
	    	 
	    public boolean isFloat(TextField f) 
	    { 
	        try 
	        { 
	            Float.parseFloat(f.getText()); 
	            return true; 
	        } 
	        catch (NumberFormatException e) 
	        { 
	            return false; 
	        } 
	    }
	    public boolean isInteger(TextField f) 
	    { 
	        try 
	        { 
	            Integer.parseInt(f.getText()); 
	            return true; 
	        } 
	        catch (NumberFormatException e) 
	        { 
	            return false; 
	        } 
	    }

		public void updateStatistics() {
			  piePatients.getData().clear();
			 
			  pieInterventions.getData().clear();
			DecimalFormat df=new DecimalFormat("0.0");
	    	int M=Patient.totalPatients("m");
	    	int F=Patient.totalPatients("f");
	    	
			 ObservableList<PieChart.Data> pieChartData =
		                FXCollections.observableArrayList(
		                        new PieChart.Data("Patients masculins", M),
		                        new PieChart.Data("Patients féminins", F) );


		        pieChartData.forEach(data ->
		                data.nameProperty().bind(
		                        Bindings.concat(
		                                data.getName(), ": ", data.pieValueProperty()
		                        )
		                )
		        );

		        piePatients.getData().addAll(pieChartData);
		        
		        int totalsoins =ActeMedical.totalActes("total");
				
				int soinsEnCours=ActeMedical.totalActes("encours");
				int soinsPasses=totalsoins-soinsEnCours;
			
				
				 ObservableList<PieChart.Data> pieChartData2 =
			                FXCollections.observableArrayList(
			                        new PieChart.Data("Soins passés", soinsPasses),
			                        new PieChart.Data("Soins en cours", soinsEnCours) );


			        pieChartData2.forEach(data ->
			                data.nameProperty().bind(
			                        Bindings.concat(
			                                data.getName(), ": ", data.pieValueProperty()
			                        )
			                )
			        );

			        pieInterventions.getData().addAll(pieChartData2);
			        XYChart.Series series = new XYChart.Series();
				    
				     ObservableList<EvolutionPatients> eList=EvolutionPatients.getList();
				     
				    for(EvolutionPatients bean : eList) {
				    	series.getData().add(new XYChart.Data(bean.getDate().toString(), bean.getEffectif()));
				    	
				    }
				    lineChart.getData().clear();
				    lineChart.getData().add(series);
		    }
		
	   
	    
	   
	   
}
