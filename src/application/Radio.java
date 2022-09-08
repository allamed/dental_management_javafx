package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Radio {
	private static int compteur;
	private int idRadio;
	private LocalDate dateRadio;
	private String cheminImage;
	private int type;
	private int id_acte;
	
	
	
	public Radio(int idRadio, LocalDate dateRadio, String cheminImage, int type) {
		super();
		this.idRadio = idRadio;
		this.dateRadio = dateRadio;
		this.cheminImage = cheminImage;
		this.type = type;
		
	}

	public Radio(LocalDate dateRadio) {
		super();
		this.idRadio = compteur+1;
		this.dateRadio = dateRadio;
		compteur++;
	}
	
	public static int getCompteur() {
		return compteur;
	}

	public static void setCompteur(int compteur) {
		Radio.compteur = compteur;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getIdRadio() {
		return idRadio;
	}
	public void setIdRadio(int idRadio) {
		this.idRadio = idRadio;
	}
	
	public LocalDate getDateRadio() {
		return dateRadio;
	}
	public void setDateRadio(LocalDate dateRadio) {
		this.dateRadio = dateRadio;
	}
	public String getCheminImage() {
		return cheminImage;
	}
	public void setCheminImage(String cheminImage) {
		this.cheminImage = cheminImage;
	}
	

	public static ObservableList<Radio> getRadiosList(int idActe) {


        ObservableList<Radio> radiosList = FXCollections.observableArrayList();
        Connection conn = database.getConnection();
        String query = "select * from radio where id_acte="+idActe +"";
        Statement st;
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Radio radio ;
            while(rs.next()){
                radio = new Radio(rs.getInt("id"), rs.getDate("date").toLocalDate(), rs.getString("chemin_image"),rs.getInt("id_type"));
               radiosList.add(radio);
              
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return radiosList;
    
		
	
		
	}

	public static boolean ajouterRadio(int typeId, LocalDate date, String chemin, int idAct) {
		
		int N= lastId() +1;
		String query="insert into radio values ("+ N +", '"+date.toString()+"', '"+ chemin +"', "+typeId +", "+idAct +")"; 
		if(database.executeQuery(query)==1) {
		return true;
		}
		else return false;
	}
public static int lastId(){
        
        Connection conn = database.getConnection();
        String query="select max(id) as max from radio";
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

public static boolean supprimerRadio(int idRad) {

	 String query="delete from radio where id="+ idRad+"";
	if( database.executeQuery(query)==1) {
		return true;
	}
	else return false;
	
}

public static boolean ajouterRemarque(int idRadio, String typeRemarque, String contenu) {
	String query;
	if( typeRemarque.equals("Générale")){
		query="insert into rem_generale values ('"+contenu +"', "+idRadio+") ";
	}
	else if( typeRemarque.equals("Positive")){
		query="insert into rem_positive values ('"+contenu +"', "+idRadio+") ";
	}
	else {
		query="insert into rem_negative values ('"+contenu +"', "+idRadio+") ";
	}
	
	if(database.executeQuery(query)==1) {
		return true;
	}
	else return false;
}

public static ObservableList<Remarque> getRemarques(int idRadio) {

    ObservableList<Remarque> list = FXCollections.observableArrayList();
    Connection conn = database.getConnection();
    String query="select * from remarque where id_radio = "+idRadio+" ";
		
	
    Statement st;
    ResultSet rs;
    
    try{
        st = conn.createStatement();
        rs = st.executeQuery(query);
        Remarque remarque;
        while(rs.next()){
            remarque = new Remarque(rs.getInt("id"), rs.getString("remarque"), rs.getDouble("x"), rs.getDouble("y"), rs.getString("type")) ;
          
            list.add(remarque);
          
        }
            
    }catch(Exception ex){
        ex.printStackTrace();
    }
    return list;

	
}
	
}
