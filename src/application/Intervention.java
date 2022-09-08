
package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Intervention {
	static int nombreInterventions;
	private int idIntervention;
	private LocalDate datePrevue;
	private LocalDate dateReelle;
	private String etatRV;
	private int categorie;
	private int acteMedical;
	
	
	/**
	 * @param idIntervention
	 * @param datePrevue
	 * @param dateReelle
	 * @param etatRV
	 */
	public Intervention(LocalDate datePrevue, int categorieIntervention, int acteMedical) {
		int N= lastId() +1;
		String query="insert into intervention (id, date_prevue, etat_rv, id_acte, id_categorie) values ("+ N +", '"+datePrevue.toString()+"', 'prevue', "+acteMedical +", "+categorieIntervention +")"; 
		if(database.executeQuery(query)==1) {
		this.idIntervention = N;
		this.setCategorie(categorieIntervention);
		this.datePrevue = datePrevue;
		this.etatRV = "prevue";
		}
	}
	public static boolean majIntervention(int idInterv, LocalDate dateReelle) {
		String query="update intervention set  date_reelle='"+ dateReelle.toString()+"', etat_rv='passee' WHERE id= "+ idInterv+""; 
		int idActe=-1;
		int idCategorie=-1;
		if (database.executeQuery(query)==1) {
			 idActe= getInfoIntervention(idInterv).getActeMedical();
			 idCategorie=getInfoIntervention(idInterv).getCategorie();
		}
			if (idActe!=-1) {ActeMedical.majPrixComptabilise(idActe, CategorieIntervention.getInfoCategorie(idCategorie).getPrixBase());
			return true;
		}
		else return false;
		
		}
	
	public int getIdIntervention() {
		return idIntervention;
	}
	public void setIdIntervention(int idIntervention) {
		this.idIntervention = idIntervention;
	}
	public LocalDate getDatePrevue() {
		return datePrevue;
	}
	public void setDatePrevue(LocalDate datePrevue) {
		this.datePrevue = datePrevue;
	}
	public LocalDate getDateReelle() {
		return dateReelle;
	}
	public void setDateReelle(LocalDate dateReelle) {
		this.dateReelle = dateReelle;
	}
	public String getEtatRV() {
		return etatRV;
	}
	public void setEtatRV(String etatRV) {
		this.etatRV = etatRV;
	}
	
	
	
	
	
	public int getActeMedical() {
		return acteMedical;
	}
	public void setActeMedical(int acteMedical) {
		this.acteMedical = acteMedical;
	}
	public static ObservableList<Intervention> getInterventionsList(int idActe) {

        ObservableList<Intervention> interventionsList = FXCollections.observableArrayList();
        Connection conn = database.getConnection();
        String query = "select * from intervention where id_acte="+idActe +"";
        Statement st;
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Intervention intervention ;
            while(rs.next()){
            	LocalDate prevue;
            	LocalDate reelle;
            	if(rs.getDate("date_prevue")!=null) { prevue=rs.getDate("date_prevue").toLocalDate();}
            	else {prevue=null;}
            	if(rs.getDate("date_reelle")!=null) {reelle=rs.getDate("date_reelle").toLocalDate();}
            	else
            	 {
            		reelle=null;
            	}
                intervention = new Intervention(rs.getInt("id"), prevue, reelle,rs.getString("etat_rv"), rs.getInt("id_categorie"), rs.getInt("id_acte"));
               interventionsList.add(intervention);
              
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return interventionsList;
    
		
	}
	public static Intervention getInfoIntervention(int idInterv) {

        ObservableList<Intervention> interventionsList = FXCollections.observableArrayList();
        Connection conn = database.getConnection();
        String query = "select * from intervention where id="+idInterv +"";
        Statement st;
        ResultSet rs;
        Intervention intervention=null ;
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            
            if(rs.next()){
            	LocalDate prevue;
            	LocalDate reelle;
            	if(rs.getDate("date_prevue")!=null) { prevue=rs.getDate("date_prevue").toLocalDate();}
            	else {prevue=null;}
            	if(rs.getDate("date_reelle")!=null) {reelle=rs.getDate("date_reelle").toLocalDate();}
            	else
            	 {
            		reelle=null;
            	}
                intervention = new Intervention(rs.getInt("id"), prevue, reelle,rs.getString("etat_rv"), rs.getInt("id_categorie"), rs.getInt("id_acte"));
               
              
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return intervention;
    
		
	}
	
	public Intervention(int idIntervention, LocalDate datePrevue, LocalDate dateReelle, String etatRV, int categorie, int acteMedic
			 ) {
		super();
		this.idIntervention = idIntervention;
		this.datePrevue = datePrevue;
		this.dateReelle = dateReelle;
		this.etatRV = etatRV;
		this.categorie=categorie;
		this.acteMedical=acteMedic;
		
	}
	public static int lastId(){
        
        Connection conn = database.getConnection();
        String query="select max(id) as max from intervention";
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
	public static boolean supprimerIntervention(int id) {

		 String query="delete from intervention where id="+ id+"";
		if( database.executeQuery(query)==1) {
			return true;
		}
		else return false;
	}
	public static boolean reporterRV(LocalDate nouvelleDate, int idIntervention) {
		
		 String query="update intervention set date_prevue='"+nouvelleDate.toString() +"' where id="+ idIntervention+"";
		if( database.executeQuery(query)==1) {
			return true;
		}
		else return false;
	}
	public static ObservableList<Intervention> getInterventionsList() {


        ObservableList<Intervention> interventionsList = FXCollections.observableArrayList();
        Connection conn = database.getConnection();
        String query = "select * from intervention ";
        Statement st;
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Intervention intervention ;
            while(rs.next()){
            	LocalDate prevue;
            	LocalDate reelle;
            	if(rs.getDate("date_prevue")!=null) { prevue=rs.getDate("date_prevue").toLocalDate();}
            	else {prevue=null;}
            	if(rs.getDate("date_reelle")!=null) {reelle=rs.getDate("date_reelle").toLocalDate();}
            	else
            	 {
            		reelle=null;
            	}
                intervention = new Intervention(rs.getInt("id"), prevue, reelle,rs.getString("etat_rv"), rs.getInt("id_categorie"), rs.getInt("id_acte"));
               interventionsList.add(intervention);
              
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return interventionsList;
    
		
	
	}
	public int getCategorie() {
		return categorie;
	}
	public void setCategorie(int categorie) {
		this.categorie = categorie;
	}
	public static int getTotal() {

		 Connection conn = database.getConnection();
		 String query="select count(*) as total from intervention";
		 
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
	public static int getNbrRv() {
		 Connection conn = database.getConnection();
		 String query="select count(*) as total from intervention where date_reelle is NULL";
		 
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
