package application;

public class Assistant extends User {

	public Assistant(String login, String password) {
		super(login, password);
		this.setFonction("Assistant");
	}

}
