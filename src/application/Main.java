
package application;
	
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.util.ArrayList;

import org.apache.ibatis.jdbc.ScriptRunner;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
    public void start(Stage stage) throws Exception {
		
		
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.initStyle(StageStyle.DECORATED);
        stage.show();
		
		//String query="ALTER TABLE remarque ADD COLUMN x_axis DOUBLE  NULL , ADD COLUMN y_axis DOUBLE  NULL ";
	//	database.executeQuery(query);
		
				
        
		
	        
	       // Connection con = database.getConnection();
	      //System.out.println("Connection established......");
	     // Initialize the script runner
	    // ScriptRunner sr = new ScriptRunner(con);
	     // Creating a reader object
	    //  Reader reader = new BufferedReader(new FileReader("data_files/dental_remarque.sql"));
	   //   sr.runScript(reader);
	     // Reader reader = new BufferedReader(new FileReader("data_files/dental_acte_medical.sql"));
	      //Running the script
	    //  sr.runScript(reader);
	      
	     
	     // Reader reader = new BufferedReader(new FileReader("data_files/dental_categorie_intervention.sql"));
	     // sr.runScript(reader);
	     // Reader reader = new BufferedReader(new FileReader("data_files/dental_couverture_medicale.sql"));
	     // sr.runScript(reader);
	      
	      //Reader reader = new BufferedReader(new FileReader("data_files/dental_type_radio.sql"));
	      //sr.runScript(reader);
	     
	     // Reader reader = new BufferedReader(new FileReader("data_files/dental_radio.sql"));
	    //  sr.runScript(reader);
	     // Reader reader = new BufferedReader(new FileReader("data_files/dental_rem_generale.sql"));
	    //  sr.runScript(reader);
	     //Reader reader = new BufferedReader(new FileReader("data_files/dental_rem_negative.sql"));
	    //  sr.runScript(reader);
	      //Reader reader = new BufferedReader(new FileReader("data_files/dental_rem_positive.sql"));
	   //   sr.runScript(reader);
	      
	    // Reader reader = new BufferedReader(new FileReader("data_files/dental_assistant.sql"));
	    //  sr.runScript(reader);
	   //  Reader reader = new BufferedReader(new FileReader("data_files/dental_dentiste.sql"));
	   //   sr.runScript(reader);
	      //Reader reader = new BufferedReader(new FileReader("data_files/dental_intervention.sql"));
		  //    sr.runScript(reader);
      // con.close();
    }
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
