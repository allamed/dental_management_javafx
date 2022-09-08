package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EvolutionPatients {
	private LocalDate date;
	private int effectif;
	
	/**
	 * @param date
	 * @param effectif
	 */
	public EvolutionPatients(LocalDate date, int effectif) {
		super();
		this.date = date;
		this.effectif = effectif;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public int getEffectif() {
		return effectif;
	}
	public void setEffectif(int effectif) {
		this.effectif = effectif;
	}
	
	public static ObservableList<EvolutionPatients> getList(){
		ObservableList<EvolutionPatients> list = FXCollections.observableArrayList();
        Connection conn = database.getConnection();
        String query = "SELECT date_inscription, count(*) as effectif FROM patient group by date_inscription ";
        Statement st;
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            EvolutionPatients ep;
            int existant=0;
            while(rs.next()){
            	existant+=rs.getInt("effectif");
                ep = new EvolutionPatients(rs.getDate("date_inscription").toLocalDate(),existant );
                list.add(ep);
              
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return list;
	}
}
