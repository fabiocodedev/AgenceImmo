package Model;

public class User {

	private int id;
	private String prenom;
	private String nom;
	protected String email;
	private String password;
//constructeur complet
	public User(int id, String prenom, String nom, String email, String password) {
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.password = password;
	}
	//contructeur sans id sans password
	public User(String prenom, String nom, String email) {
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
	}
	public User(String prenom, String nom, String email, String password) {
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.password = password;
	}
//constructeur par defaut
//constructeur par defaut
	public User() {
	}
//getters / setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
