package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Remarque {
	private int idRemarque;
	private String remarque;
	private double xValue;
	private double yValue;
	private String type;
	/**
	 * @param idRemarque
	 * @param remarque
	 * @param xValue
	 * @param yValue
	 * @param type
	 */
	public Remarque(int idRemarque, String remarque, double xValue, double yValue, String type) {
		super();
		this.idRemarque = idRemarque;
		this.remarque = remarque;
		this.xValue = xValue;
		this.yValue = yValue;
		this.type = type;
	}
	public int getIdRemarque() {
		return idRemarque;
	}
	public void setIdRemarque(int idRemarque) {
		this.idRemarque = idRemarque;
	}
	public String getRemarque() {
		return remarque;
	}
	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}
	public double getxValue() {
		return xValue;
	}
	public void setxValue(double xValue) {
		this.xValue = xValue;
	}
	public double getyValue() {
		return yValue;
	}
	public void setyValue(double yValue) {
		this.yValue = yValue;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public static boolean supprimerRemarque(int idRemarque) {


		 String query="delete from remarque where id="+ idRemarque+"";
		if( database.executeQuery(query)==1) {
			return true;
		}
		else return false;
		

		
	}
	public static boolean ajouterRemarque(String remarque,int idRadio,  double x, double y, String type) {
		int N= lastId() +1;
		String query="insert into remarque values ("+ N +", '"+remarque+"', "+ idRadio+", '"+type+"', "+ x +" , "+ y +" )"; 
		if(database.executeQuery(query)==1) {
			return true;
		}
		else {
			return false;
		}
	}
	public static int lastId(){
        
        Connection conn = database.getConnection();
        String query="select max(id) as max from remarque";
        Statement st;
        ResultSet rs;
        int max=0;
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
}
