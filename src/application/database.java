package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.scene.control.Alert;

public class database {
	public static int executeQuery(String query) {
        Connection conn = getConnection();
        Statement st;
        int resultat=1;
        try{
            st = conn.createStatement();
            resultat= st.executeUpdate(query);
            conn.close();
           
        }catch(SQLException ex){
            ex.printStackTrace();
            resultat=0;
            Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setTitle("Message d'erreur");
    		alert.setContentText ("il y a eu une erreur pendant l'execution de la requete SQL");
    		alert.showAndWait();
             
        }
        return (resultat);
    }
	 public static Connection getConnection(){
	        Connection conn;
	        try{
	        	  
	           
	        	  conn = DriverManager.getConnection("jdbc:h2:./allam3", "allam", "123");
	            return conn;
	        }catch(Exception ex){
	            System.out.println("Error: " + ex.getMessage());
	            return null;
	            

	        }
	    }
}
