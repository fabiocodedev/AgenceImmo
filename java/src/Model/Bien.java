package Model;

public class Bien {
private int  id;
private String titre;
private String type;
private String categorie;
private String ville;
private Float prix;
private int nbPiece;
private int superficie;
private String texte;
private String images;
private String status;
private Proprietaire proprietaire;



public Bien() {

}
//contructeur complet
public Bien(int id, String titre, String type, String categorie, String ville, Float prix, int nbPiece, int superficie,
		String texte, String images, String status, Proprietaire proprietaire) {
	this.id = id;
	this.titre = titre;
	this.type = type;
	this.categorie = categorie;
	this.ville = ville;
	this.prix = prix;
	this.nbPiece = nbPiece;
	this.superficie = superficie;
	this.texte = texte;
	this.images = images;
	this.status = status;
	this.proprietaire = proprietaire;
}
//constructeur sans ID bien
public Bien(String titre, String type, String categorie, String ville, Float prix, int nbPiece, int superficie,
		String texte, String images, String status, Proprietaire proprietaire) {
	this.titre = titre;
	this.type = type;
	this.categorie = categorie;
	this.ville = ville;
	this.prix = prix;
	this.nbPiece = nbPiece;
	this.superficie = superficie;
	this.texte = texte;
	this.images = images;
	this.status = status;
	this.proprietaire = proprietaire;
}
//constructeur pour le CREATE sans bien ni propietaire ni employe ID
public Bien(String titre, String type, String categorie, String ville, Float prix, int nbPiece, int superficie,
		String texte, String images, String status) {
	this.titre = titre;
	this.type = type;
	this.categorie = categorie;
	this.ville = ville;
	this.prix = prix;
	this.nbPiece = nbPiece;
	this.superficie = superficie;
	this.texte = texte;
	this.images = images;
	this.status = status;
}
//constructeur pour le FILTRE ACCUEIL
public Bien(String ville,Float prix) {
	this.ville = ville;
	this.prix = prix;
}
//GETTERS / SETTERS
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitre() {
	return titre;
}
public void setTitre(String titre) {
	this.titre = titre;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getCategorie() {
	return categorie;
}
public void setCategorie(String categorie) {
	this.categorie = categorie;
}
public String getVille() {
	return ville;
}
public void setVille(String ville) {
	this.ville = ville;
}
public Float getPrix() {
	return prix;
}
public void setPrix(Float prix) {
	this.prix = prix;
}
public int getNbPiece() {
	return nbPiece;
}
public void setNbPiece(int nbPiece) {
	this.nbPiece = nbPiece;
}
public int getSuperficie() {
	return superficie;
}
public void setSuperficie(int superficie) {
	this.superficie = superficie;
}
public String getTexte() {
	return texte;
}
public void setTexte(String texte) {
	this.texte = texte;
}
public String getImages() {
	return images;
}
public void setImages(String images) {
	this.images = images;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public Proprietaire getProprietaire() {
	return proprietaire;
}
public void setProprietaire(Proprietaire proprietaire) {
	this.proprietaire = proprietaire;
}
}
