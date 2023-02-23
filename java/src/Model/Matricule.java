package Model;

public class Matricule {
	private int id;
	private String mat;
//constructeur complet
	public Matricule(int id, String mat) {
		this.id = id;
		this.mat = mat;
	}
//constructeur sans id
	public Matricule(String mat) {
		this.mat = mat;
	}
//constructeur par defaut
	public Matricule() {
	}
//getters / setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMat() {
		return mat;
	}
	public void setMat(String mat) {
		this.mat = mat;
	}
	@Override
	public String toString() {
		return "Matricule [id = " + id + ", mat = " + mat + "]";
	}
}
