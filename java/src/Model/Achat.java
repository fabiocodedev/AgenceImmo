package Model;

import java.util.Date;

public class Achat {
	private int  id;
	private Date date;
	private Float fraisAgenceAchat;
	private Bien bien;
	private Client client;
//CONSTRUCTEUR PAR DEFAUT
	public Achat() {
	}
	//CONSTRUCTEUR COMPLET
	public Achat(int id, Date date, Float fraisAgenceAchat, Bien bien, Client client) {
		this.id = id;
		this.date = date;
		this.fraisAgenceAchat = fraisAgenceAchat;
		this.bien = bien;
		this.client = client;
	}
	//CONSTRUCTEUR SANS ID
	public Achat(Date date, Float fraisAgenceAchat, Bien bien, Client client) {
		this.date = date;
		this.fraisAgenceAchat = fraisAgenceAchat;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Float getFraisAgenceAchat() {
		return fraisAgenceAchat;
	}
	public void setFraisAgenceAchat(Float fraisAgenceAchat) {
		this.fraisAgenceAchat = fraisAgenceAchat;
	}
	public Bien getBien() {
		return bien;
	}
	public void setBien(Bien bien) {
		this.bien = bien;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
}
