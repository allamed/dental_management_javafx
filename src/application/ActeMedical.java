package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ActeMedical {
	static int nombreActes;
	private int idSoin;
	private LocalDate debutSoin;
	private float prixComptabilise;
	private String etatActe;
	private LocalDate finSoin;
	private int idPatient;
	//private ArrayList <Intervention> intervention= new ArrayList<> ();
	//public ArrayList<Radio>  radio= new ArrayList<> () ;
	/**
	 * @param idSoin
	 * @param debutSoin
	 * @param prixComptabilise
	 * @param etatActe
	 * @param finSoin
	 * @param intervention
	 */
	public ActeMedical(LocalDate debutSoin, int idPatient) {
		int N= lastId() +1;
		String query="insert into acte_medical (id, debut_soin, prix_comptabilise, etat_acte, id_patient) values ("+ N +", '"+debutSoin.toString()+"', "+ 0 +", 'en cours', "+idPatient +")"; 
		if(database.executeQuery(query)==1) {
		
		this.idSoin = N;
		this.debutSoin = debutSoin;
		this.prixComptabilise = 0;
		this.etatActe = "en cours";
		;}
	}
	
	public ActeMedical(int idSoin, LocalDate debutSoin, float prixComptabilise, String etatActe, LocalDate finSoin,
			int idPatient) {
		super();
		this.idSoin = idSoin;
		this.debutSoin = debutSoin;
		this.prixComptabilise = prixComptabilise;
		this.etatActe = etatActe;
		this.finSoin = finSoin;
		this.idPatient = idPatient;
	}
	
	public static boolean majPrixComptabilise(int idActe, float p) {
		String query="update acte_medical set  prix_comptabilise = prix_comptabilise+"+ p +" WHERE id= "+ idActe+"";
		if (database.executeQuery(query)==1) {
			return true;
		}
		else return false;
	}
	
	public int getIdPatient() {
		return idPatient;
	}
	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}
	public static boolean terminerActe(int id) {
		LocalDate today =LocalDate.now();
		String query="update acte_medical set etat_acte='termine', fin_soin='"+today.toString()+"' WHERE id= "+ id+"";                  
		if (database.executeQuery(query)==1) {
			return true;
		}
		else return false;

	}
	
	
	public int getIdSoin() {
		return idSoin;
	}
	public void setIdSoin(int idSoin) {
		this.idSoin = idSoin;
	}
	public LocalDate getDebutSoin() {
		return debutSoin;
	}
	public void setDebutSoin(LocalDate debutSoin) {
		this.debutSoin = debutSoin;
	}
	public float getPrixComptabilise() {
		return prixComptabilise;
	}
	public void setPrixComptabilise(float prixComptabilise) {
		this.prixComptabilise = prixComptabilise;
	}
	public String isEtatActe() {
		return etatActe;
	}
	public void setEtatActe(String etatActe) {
		this.etatActe = etatActe;
	}
	public LocalDate getFinSoin() {
		return finSoin;
	}
	public void setFinSoin(LocalDate finSoin) {
		this.finSoin = finSoin;
	}
	
	public static ObservableList<ActeMedical> getActesList() {

        ObservableList<ActeMedical> actesList = FXCollections.observableArrayList();
        Connection conn = database.getConnection();
        String query = "select * from acte_medical  ";
        Statement st;
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            ActeMedical acte;
            while(rs.next()){
            	LocalDate debut;
            	LocalDate fin;
            	if(rs.getDate("debut_soin")!=null) { debut=rs.getDate("debut_soin").toLocalDate();}
            	else {debut=null;}
            	if(rs.getDate("fin_soin")!=null) {fin=rs.getDate("fin_soin").toLocalDate();}
            	else
            	 {
            		fin=null;
            	}
            	acte = new ActeMedical(rs.getInt("id"), debut, rs.getFloat("prix_comptabilise"), rs.getString("etat_acte"), fin, rs.getInt("id_patient"));
            	actesList.add(acte);
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return actesList;
    
	}
	 public static int lastId(){
	        
	        Connection conn = database.getConnection();
	        String query="select max(id) as max from acte_medical";
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

	public static ActeMedical getInfoActe(int idActe) {
		
		 Connection conn = database.getConnection();
	        String query="select * from acte_medical where id="+idActe +"";
	        Statement st;
	        ResultSet rs;
	        ActeMedical acte = null;
	        try{
	            st = conn.createStatement();
	            rs = st.executeQuery(query);
	            
	            if(rs.next()){
	            	LocalDate debut;
	            	LocalDate fin;
	            	if(rs.getDate("debut_soin")!=null) { debut=rs.getDate("debut_soin").toLocalDate();}
	            	else {debut=null;}
	            	if(rs.getDate("fin_soin")!=null) {fin=rs.getDate("fin_soin").toLocalDate();}
	            	else
	            	 {
	            		fin=null;
	            	}
	            	acte = new ActeMedical(rs.getInt("id"), debut, rs.getFloat("prix_comptabilise"), rs.getString("etat_acte"), fin, rs.getInt("id_patient"));
	            	
	            }
	                
	        }catch(Exception ex){
	            ex.printStackTrace();
	        }
			return acte;
	}

	public String getEtatActe() {
		return etatActe;
	}
	public static ObservableList<ActeMedical> getActesOfPatient(int idPatient) {

        ObservableList<ActeMedical> actesList = FXCollections.observableArrayList();
        Connection conn = database.getConnection();
        String query = "select * from acte_medical where id_patient="+idPatient+" ";
        Statement st;
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            ActeMedical acte;
            while(rs.next()){
            	LocalDate debut;
            	LocalDate fin;
            	if(rs.getDate("debut_soin")!=null) { debut=rs.getDate("debut_soin").toLocalDate();}
            	else {debut=null;}
            	if(rs.getDate("fin_soin")!=null) {fin=rs.getDate("fin_soin").toLocalDate();}
            	else
            	 {
            		fin=null;
            	}
            	acte = new ActeMedical(rs.getInt("id"), debut, rs.getFloat("prix_comptabilise"), rs.getString("etat_acte"), fin, rs.getInt("id_patient"));
            	actesList.add(acte);
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return actesList;
    
	}
	public static int totalActes(String choix) {
		 Connection conn = database.getConnection();
		 String query;
		 if (choix.toLowerCase().matches("passes"))  {query="select count(*) as total from acte_medical where etat_acte like 'termine' ";}
		 else if (choix.toLowerCase().matches("encours")) { query="select count(*) as total from acte_medical where etat_acte like 'en cours'";}
		 else { query="select count(*) as total from acte_medical";}
		 
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

}
