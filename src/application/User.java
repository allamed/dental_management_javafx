package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import javafx.collections.ObservableList;

public abstract class User implements Serializable {
 private String login;
 private String password;
 private String fonction;
/**
 * @param login
 * @param password
 */
public User(String login, String password) {
	super();
	this.login = login;
	this.password = password;
}
public String getLogin() {
	return login;
}
public String getFonction() {
	return fonction;
}
public void setFonction(String fonction) {
	this.fonction = fonction;
}
public void setLogin(String login) {
	this.login = login;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public static ObservableList<User> getUsersList() {
	// TODO Auto-generated method stub
	return null;
}
public static int check(String nomUtilisateur, String motDePasse) throws ClassNotFoundException, IOException {
	ArrayList<User> list =readListFromFile();
	boolean resultat=false;
	for(User bean: list){
		if (bean.getLogin().contains(nomUtilisateur) && bean.getPassword().contains(motDePasse)) {
			resultat=true;
			if (bean.getFonction().contains("Dentiste") ) {
				return 1;
			}
			else return 0;
		}
		
	}
	return -1;
	
}






	public static void storeListInFile(ArrayList<User> list) throws IOException, InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		Crypter crypter=new Crypter();
		for (User bean: list) {
			bean.setLogin(crypter.encrypt(bean.getLogin()) );
			bean.setPassword(crypter.encrypt(bean.getPassword()) );
			
		}
		FileOutputStream fos = new FileOutputStream("t.tmp");
		
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(list);
		oos.close();
	}

	public static ArrayList<User> readListFromFile() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("t.tmp");
		ObjectInputStream ois = new ObjectInputStream(fis);
		ArrayList<User> usersList = (ArrayList<User>) ois.readObject();
		ois.close();
		Crypter crypter=new Crypter();
		for (User bean: usersList) {
			bean.setLogin(crypter.decrypt(bean.getLogin()) );
			bean.setPassword(crypter.decrypt(bean.getPassword()) );
		}
		return usersList;
	}

public static boolean ajouterUtilisateur(String login, String password, String fonction) throws ClassNotFoundException, IOException {
	
	User us;
	if (fonction=="Dentiste") {
		us=new Dentiste(login, password);
	}
	else {
		us=new Assistant(login, password);
	}
	try {
		ArrayList<User> list =readListFromFile();
	list.add(us);
	storeListInFile(list);
	
	} catch (Exception e) {
		return false;
	}
	return true;
	
}
public static boolean supprimerUtilisateur(User user) {
	//boolean estSupprime=false;
	try {
		ArrayList<User> list =readListFromFile();
		ArrayList<User> list2= new ArrayList();
	for (User bean: list) {
		if (!bean.getLogin().contains(user.getLogin()) ) {
			list2.add(bean);
		}
	}
	
	storeListInFile(list2);
	
	
	} catch (Exception e) {
		
		return false;
	}
	return true;
	
}





}
