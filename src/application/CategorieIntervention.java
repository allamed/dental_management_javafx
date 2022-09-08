package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CategorieIntervention {
	static int compteur;
	private int idCategorie;
	private String type;
	private float prixBase;
	
	/**
	 * @param idCategorie
	 * @param type
	 * @param prixBase
	 */
	public CategorieIntervention(int idCategorie, String type, float prixBase) {
		
		this.idCategorie = idCategorie;
		this.type = type;
		this.prixBase = prixBase;
		
	}
	
	public static boolean ajouterCategorieIntervention(int idCategorie, String type, float prixBase) {
		String query="insert into categorie_intervention values ("+ idCategorie +", '"+type+"', "+ prixBase+")"; 
		if(database.executeQuery(query)==1) {
			return true;
		}
		else return false;
	}
	public int getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getPrixBase() {
		return prixBase;
	}
	public void setPrixBase(float prixBase) {
		this.prixBase = prixBase;
	}
	public static CategorieIntervention getInfoCategorie(int idCategorie) {
		 Connection conn = database.getConnection();
	        String query="select * from categorie_intervention where id="+idCategorie +"";
	        Statement st;
	        ResultSet rs;
	        CategorieIntervention categorie = null;
	        try{
	            st = conn.createStatement();
	            rs = st.executeQuery(query);
	            
	            if(rs.next()){
	            	
	            	categorie = new CategorieIntervention(rs.getInt("id"),rs.getString("type"),rs.getFloat("prix"));
	            	
	            }
	                
	        }catch(Exception ex){
	            ex.printStackTrace();
	        }
			return categorie;
	}	
	public static CategorieIntervention getIdCategorie(String type) {
		 Connection conn = database.getConnection();
	        String query="select * from categorie_intervention where type like '"+type +"'";
	        Statement st;
	        ResultSet rs;
	        CategorieIntervention categorie = null;
	        try{
	            st = conn.createStatement();
	            rs = st.executeQuery(query);
	            
	            if(rs.next()){
	            	
	            	categorie = new CategorieIntervention(rs.getInt("id"),rs.getString("type"),rs.getFloat("prix"));
	            	
	            }
	                
	        }catch(Exception ex){
	            ex.printStackTrace();
	        }
			return categorie;
	}	
	public static ObservableList<CategorieIntervention>  getAllCategorie() {
		 Connection conn = database.getConnection();
	        String query="select * from categorie_intervention ";
	        Statement st;
	        ResultSet rs;
	        ObservableList<CategorieIntervention> catList=FXCollections.observableArrayList();
	        try{
	            st = conn.createStatement();
	            rs = st.executeQuery(query);
	            
	            while(rs.next()){
	            	
	            	CategorieIntervention categorie = new CategorieIntervention(rs.getInt("id"),rs.getString("type"),rs.getFloat("prix"));
	            	catList.add(categorie);
	            }
	                
	        }catch(Exception ex){
	            ex.printStackTrace();
	        }
			return catList;
	}

	public static boolean majCategorieIntervention(int id, String type, float prix) {
		String query="update categorie_intervention set  type='"+type+"', prix= "+ prix +" WHERE id= "+ id+"";                  
		if (database.executeQuery(query)==1) {
			return true;
		}
		else return false;
		
	}

	public static boolean supprimerCategorie(int idCategorie) {

		 String query="delete from categorie_intervention where id="+ idCategorie+"";
		if( database.executeQuery(query)==1) {
			return true;
		}
		else return false;
	 
	}	
	}

