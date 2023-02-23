package Model;

public class Proprietaire extends User {
	private int id;
	private String adresse;
	private String telephone;
	private User user;
//constructeur complet
	public Proprietaire(int id,String prenom, String nom, String email,  String adresse, String telephone, User user) {
		super(prenom, nom, email);
		this.id = id;
		this.adresse = adresse;
		this.telephone = telephone;
		this.user = user;
	}
//constructeur sans heritage
	public Proprietaire( int id, String adresse, String telephone, User user) {
		this.id = id;
		this.adresse = adresse;
		this.telephone = telephone;
		this.user = user;
	}
//constructeur avec heritage
	public Proprietaire(String adresse, String telephone, User user) {
		this.adresse = adresse;
		this.telephone = telephone;
		this.user = user;
	}
//constructeur sans id
	public Proprietaire(String prenom, String nom, String email, String adresse, String telephone, User user) {
		super(prenom, nom, email);
		this.adresse = adresse;
		this.telephone = telephone;
		this.user = user;
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
	public Proprietaire() {
	}
	@Override
	public String toString() {
		return "Proprietaire [id=" + id + ", adresse=" + adresse + ", telephone=" + telephone + ", user=" + user.getEmail()
				+ "]";
	}
}
