package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TypeRadio {
	private int idTypeRadio;
	private String description;
	/**
	 * @param idTypeRadio
	 * @param description
	 */
	public TypeRadio(int idTypeRadio, String description) {
		super();
		this.idTypeRadio = idTypeRadio;
		this.description = description;
	}
	public int getIdTypeRadio() {
		return idTypeRadio;
	}
	public void setIdTypeRadio(int idTypeRadio) {
		this.idTypeRadio = idTypeRadio;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public static ObservableList<TypeRadio> getTypeList() {


        ObservableList<TypeRadio> typeList = FXCollections.observableArrayList();
        Connection conn = database.getConnection();
        String query = "select * from type_radio";
        Statement st;
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            TypeRadio type ;
            while(rs.next()){
                type = new TypeRadio(rs.getInt("id"),  rs.getString("description"));
               typeList.add(type);
              
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return typeList;
    
		
	
		
	}
	public static int getTypeId(String description) {
		int id=-1;
		 Connection conn = database.getConnection();
	        String query = "select id from type_radio where description like '"+ description+"'";
	        Statement st;
	        ResultSet rs;
	        
	        try{
	            st = conn.createStatement();
	            rs = st.executeQuery(query);
	            
	            if(rs.next()){
	                id = rs.getInt("id");
	              
	              
	            }
	                
	        }catch(Exception ex){
	            ex.printStackTrace();
	        }
	        return id;
		
	}
	public static boolean ajouterTypeRadio(int id, String type) {
		String query="insert into type_radio values ("+ id +", '"+type+"')"; 
		if(database.executeQuery(query)==1) {
			return true;
		}
		else return false;
	}
	public static boolean majTypeRadio(int id, String type) {
		String query="update type_radio set  description='"+type+"' WHERE id= "+ id+"";                  
		if (database.executeQuery(query)==1) {
			return true;
		}
		else return false;
		
	}
	public static boolean supprimerTypeRadio(int id) {

		 String query="delete from type_radio where id="+ id+"";
		if( database.executeQuery(query)==1) {
			return true;
		}
		else return false;
	 
	}
	
}
