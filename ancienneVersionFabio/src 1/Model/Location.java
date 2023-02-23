package Model;

import java.util.Date;

public class Location {
	private int  id;
	private Float fraisAgenceLoc;
	private Date dateDebut;
	private Date dateFin;
	private Bien bien;
	private Client client;
//CONSTRUCTEUR PAR DEFAUT
	public Location() {
	}
	//CONSTRUCTEUR COMPLET
	public Location(int id, Float fraisAgenceLoc, Date dateDebut, Date dateFin, Bien bien, Client client) {
		super();
		this.id = id;
		this.fraisAgenceLoc = fraisAgenceLoc;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.bien = bien;
		this.client = client;
	}
	//CONSTRUCTEUR SANS ID
	public Location(Float fraisAgenceLoc, Date dateDebut, Date dateFin, Bien bien, Client client) {
		super();
		this.fraisAgenceLoc = fraisAgenceLoc;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.bien = bien;
		this.client = client;
	}
	//GETTERS / SETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Float getFraisAgenceLoc() {
		return fraisAgenceLoc;
	}
	public void setFraisAgenceLoc(Float fraisAgenceLoc) {
		this.fraisAgenceLoc = fraisAgenceLoc;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public Bien getBien() {
		return bien;
	}
	public void setId_Bien(Bien bien) {
		this.bien = bien;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
}
