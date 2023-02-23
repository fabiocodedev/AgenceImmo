package Model;

public class Client extends User{
	private int id;
	private String adresse;
	private String telephone;
	private User user;
//constructeur complet
	public Client(int id,String prenom, String nom, String email,  String adresse, String telephone, User user) {
		super(prenom, nom, email);
		this.id = id;
		this.adresse = adresse;
		this.telephone = telephone;
		this.user = user;
	}
//constructeur sans id
	public Client(String prenom, String nom, String email, String adresse, String telephone, User user) {
		super(prenom, nom, email);
		this.adresse = adresse;
		this.telephone = telephone;
		this.user = user;
	}
//constructeur juste avec l'heritage
	public Client(int id, String prenom, String nom, String email) {
		super(prenom, nom, email);
	}
//constructeur juste avec l'heritage et sans id
	public Client(String adresse, String telephone, User user) {
		this.adresse = adresse;
		this.telephone = telephone;
		this.user = user;
	}
//constructeur par defaut
	public Client() {
	}
//getters / setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
