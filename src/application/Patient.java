package application;


import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import application.database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Patient implements Serializable{
	
	private static int nombrePatients;
	private int idPatient;
	private LocalDate dateNaissance;
	private String cin;
	private String nom;
	private String prenom;
	private String sexe;
	private int couverture;
	private LocalDate dateInscription;
	
	

	/**
	 * @param idPatient
	 * @param dateNaissance
	 * @param cin
	 * @param nom
	 * @param prenom
	 * @param sexe
	 * @param acteMedical
	 * @param couvertureMedicale
	 */
	
	public Patient(LocalDate dateNaissance, String cin, String nom, String prenom, String sexe, int couverture) {
		int N= lastId() +1;
		String query="insert into patient values ("+ N +", '"+dateNaissance.toString()+"', '"+ cin+"', '"+nom+"', '"+prenom+"' , '"+ sexe +"', curdate(), "+couverture +" )"; 
		if(database.executeQuery(query)==1) {
			
			this.idPatient = N;
			this.dateNaissance = dateNaissance;
			this.cin = cin;
			this.nom = nom;
			this.prenom = prenom;
			this.sexe = sexe;
			this.couverture=couverture;
			
			nombrePatients ++;
		}
		
	}
	public Patient(int id, LocalDate dateNaissance, String cin, String nom, String prenom, String sexe, int couverture) {
		
		this.idPatient = id;
		this.dateNaissance = dateNaissance;
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.couverture=couverture;
		
	}
	public Patient() {
		
	}
	
	public static int getNombrePatients() {
		return nombrePatients;
	}
	public static void setNombrePatients(int nombrePatients) {
		Patient.nombrePatients = nombrePatients;
	}
	public int getIdPatient() {
		return idPatient;
	}
	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	
	public int getCouverture() {
		return couverture;
	}
	public void setCouverture(int couvertureMedicale) {
		this.couverture = couvertureMedicale;
	}
	 public static ObservableList<Patient> getPatientsList(){
	        ObservableList<Patient> patientsList = FXCollections.observableArrayList();
	        Connection conn = database.getConnection();
	        String query = "select * from patient  ";
	        Statement st;
	        ResultSet rs;
	        
	        try{
	            st = conn.createStatement();
	            rs = st.executeQuery(query);
	            Patient patient;
	            while(rs.next()){
	                patient = new Patient(rs.getInt("id"), rs.getDate("naissance").toLocalDate(),rs.getString("cin"), rs.getString("nom"),rs.getString("prenom"),rs.getString("sexe"), rs.getInt("couverture_medicale"));
	                patientsList.add(patient);
	              
	            }
	                
	        }catch(Exception ex){
	            ex.printStackTrace();
	        }
	        return patientsList;
	    }
	 public static boolean supprimerPatient(int idPatient) {
		 String query="delete from patient where id="+ idPatient+"";
		if( database.executeQuery(query)==1) {
			return true;
		}
		else return false;
	 }
	 public static int lastId(){
	        
	        Connection conn = database.getConnection();
	        String query="select max(id) as max from patient";
	        Statement st;
	        ResultSet rs;
	        int max=1;
	        try{
	            st = conn.createStatement();
	            rs = st.executeQuery(query);
	            
	            if(rs.next()){
	                max=rs.getInt("max");	              
	            }
	                
	        }catch(Exception ex){
	            ex.printStackTrace();
	        }
	        return max;
	    }
	 public static int totalPatients(String genre) {
		 Connection conn = database.getConnection();
		 String query;
		 if (genre.toLowerCase().matches("m"))  {query="select count(*) as total from patient where sexe like 'Masculin' ";}
		 else if (genre.toLowerCase().matches("f")) { query="select count(*) as total from patient where sexe not like 'Masculin'";}
		 else { query="select count(*) as total from patient";}
		 
	        Statement st;
	        ResultSet rs;
	        int total=1;
	        try{
	            st = conn.createStatement();
	            rs = st.executeQuery(query);
	            
	            if(rs.next()){
	                total=rs.getInt("total");	              
	            }
	                
	        }catch(Exception ex){
	            ex.printStackTrace();
	        }
	        return total;
		 
	 }
	public static boolean modifierPatient(int id, String nom, String prenom, String cin, LocalDate dNaissance, String sexe, String couverture) {
		Integer idCouv;
		if (couverture==null) {
			idCouv=0;
		}
		else {
			idCouv=CouvertureMedicale.getIdCouverture(couverture);
			
		}
		String query="update patient set  naissance='"+ dNaissance+"', cin= '"+ cin +"',nom= '"+nom +"',prenom= '"+prenom +"',sexe= '"+sexe +"', couverture_medicale = "+ idCouv+" WHERE id= "+ id+"";                  
		if (database.executeQuery(query)==1) {
			return true;
		}
		else return false;
		
	}
	public static Patient getInfoPatient(int idPatient) {
		
		 Connection conn = database.getConnection();
	        String query="select * from patient where id="+idPatient +"";
	        Statement st;
	        ResultSet rs;
	        Patient patient = null;
	        try{
	            st = conn.createStatement();
	            rs = st.executeQuery(query);
	            
	            if(rs.next()){
	            	
	            	patient = new Patient(rs.getInt("id"), rs.getDate("naissance").toLocalDate(),rs.getString("cin"), rs.getString("nom"),rs.getString("prenom"),rs.getString("sexe"), rs.getInt("couverture_medicale"));
	            	
	            }
	                
	        }catch(Exception ex){
	            ex.printStackTrace();
	        }
			return patient;
	}
	
}