package Model;

public class Employe extends User {
	private int id;
	private User user;
	private Matricule matricule;
//CONSTRUCTEUR COMPLET
	public Employe(int id,String prenom, String nom, String email,  User user, Matricule matricule) {
		super(prenom, nom, email);
		this.id = id;
		this.user = user;
		this.matricule = matricule;
	}
//CONSTRUCTEUR SANS ID
	public Employe(String prenom, String nom, String email, User user, Matricule matricule) {
		super(prenom, nom, email);
		this.user = user;
		this.matricule = matricule;
	}
//CONSTRUCTEUR SANS HERITAGE 
	public Employe( int id, User user, Matricule matricule) {
		this.id = id;
		this.user = user;
		this.matricule = matricule;
	}
//CONSTRUCTEUR SANS ID SANS HERITAGE
	public Employe( User user, Matricule matricule) {
		this.user = user;
		this.matricule = matricule;
	}
//GETTERS / SETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Matricule getMatricule() {
		return matricule;
	}
	public void setMatricule(Matricule matricule) {
		this.matricule = matricule;
	}
}
