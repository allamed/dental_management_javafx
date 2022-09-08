package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CouvertureMedicale {
private int idCouverture;
private String typeCouverture;
/**
 * @param idCouverture
 * @param typeCouverture
 */
public CouvertureMedicale(int idCouverture, String typeCouverture) {
	super();
	this.idCouverture = idCouverture;
	this.typeCouverture = typeCouverture;
}
public int getIdCouverture() {
	return idCouverture;
}
public void setIdCouverture(int idCouverture) {
	this.idCouverture = idCouverture;
}
public String getTypeCouverture() {
	return typeCouverture;
}
public void setTypeCouverture(String typeCouverture) {
	this.typeCouverture = typeCouverture;
}
public static int getIdCouverture(String typeCouv) {
	


    int idCouv=0;
    Connection conn = database.getConnection();
    String query = "select id from couverture_medicale where type like '"+typeCouv +"'";
    Statement st;
    ResultSet rs;
    
    try{
        st = conn.createStatement();
        rs = st.executeQuery(query);
        
        if(rs.next()){
        	
          idCouv =rs.getInt("id");
           
          
        }
            
    }catch(Exception ex){
        ex.printStackTrace();
    }
    return idCouv;

	

}
	public static ObservableList<String> getListCouvertures(){
		ObservableList<String> list = FXCollections.observableArrayList();
        Connection conn = database.getConnection();
        String query = "select type from couverture_medicale  ";
        Statement st;
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            
            while(rs.next()){
                
               list.add(rs.getString("type"));
              
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return list;
}
	public static ObservableList<CouvertureMedicale> getAllCouvertures() {

		ObservableList<CouvertureMedicale> list = FXCollections.observableArrayList();
        Connection conn = database.getConnection();
        String query = "select * from couverture_medicale  ";
        Statement st;
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            CouvertureMedicale couv;
            while(rs.next()){
                couv= new CouvertureMedicale(rs.getInt("id"), rs.getString("type"));
               list.add(couv);
              
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return list;

	}
	public static boolean ajouterCouverture(int id, String type) {
		String query="insert into couverture_medicale (id, type) values ("+ id +", '"+type+"')"; 
		if(database.executeQuery(query)==1) {
			return true;
		}
		else return false;
	}
	public static boolean majCouverture(int id, String type) {
		String query="update couverture_medicale set  type='"+type+"' WHERE id= "+ id+"";                  
		if (database.executeQuery(query)==1) {
			return true;
		}
		else return false;
		
	}
	public static boolean supprimerCouverture(int id) {

		 String query="delete from couverture_medicale where id="+ id+"";
		if( database.executeQuery(query)==1) {
			return true;
		}
		else return false;
	 
	}
}
