package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Connect.BDDConnection;
import Model.Bien;
import Model.Matricule;
import Model.Proprietaire;
import Model.User;

public class BienDao implements ImmoIntDao<Bien> {

	//INSTANCIATION GLOBAL
	Connection connect = BDDConnection.getConnect();
	ResultSet rs = null;
	User user = new User();
	Matricule matricule = new Matricule();
	Proprietaire proprietaire = new Proprietaire();

	@Override
	public boolean create(Bien bien) {

		try {
			
			PreparedStatement sql = connect.prepareStatement("INSERT INTO bien (titre, type, categorie, ville, prix, nbPiece,"
					+" superficie, texte, images, status, proprietaire) VALUES"
					+" (?,?,?,?,?,?,?,?,?,?,?)");

			sql.setString(1,bien.getTitre());
			sql.setString(2,bien.getType());
			sql.setString(3,bien.getCategorie());
			sql.setString(4,bien.getVille());
			sql.setFloat(5,bien.getPrix());
			sql.setInt(6,bien.getNbPiece());
			sql.setInt(7,bien.getSuperficie());
			sql.setString(8,bien.getTexte());
			sql.setString(9,bien.getImages());
			sql.setString(10,bien.getStatus());
			sql.setInt(11,bien.getProprietaire().getId());

			//System.out.println(sql);

			sql.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public ArrayList<Bien> read() {
		ArrayList<Bien> listBien = new ArrayList<>();
		try {

			//System.out.println("OK Connection Read Bien");
			PreparedStatement sql = connect.prepareStatement("SELECT * FROM Bien");

		

			rs = sql.executeQuery();


			while (rs.next()) {
				Bien bien = new Bien(rs.getInt("id"),rs.getString("titre"),rs.getString("type"),
						rs.getString("categorie"), rs.getString("ville"),
						rs.getFloat("prix"), rs.getInt("nbPiece"),
						rs.getInt("superficie"), rs.getString("texte"),
						rs.getString("images"), rs.getString("status"),
						proprietaire) ;
				listBien.add(bien);
				System.out.println(listBien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listBien;
	}

	@Override
	public boolean delete(Bien bien) {
		try {			
			PreparedStatement req = connect.prepareStatement("DELETE FROM bien WHERE id=?");	

			req.setInt(1, bien.getId());

			req.executeUpdate();
			return true;
		}catch(Exception e) {
			e.printStackTrace();		
		}
		return false;
	}

	//METHODE FILTRE ACCUEIL
	public ArrayList<Bien> filtreAccueil(String ville, Float prix) {
		ArrayList<Bien> listeFiltre = new ArrayList<>();
		try {
			//PreparedStatement req1 = connect.prepareStatement("SELECT * FROM bien;");
			PreparedStatement req = connect.prepareStatement("SELECT * FROM bien"+
					" WHERE ville=? AND prix<=? ;");
			req.setString(1, ville);
			req.setFloat(2, prix);

			ResultSet rs = req.executeQuery();
			//ResultSet rs1 = req1.executeQuery();

			while (rs.next()) {
				Bien bien = new Bien(rs.getString("titre"),rs.getString("type"),
						rs.getString("categorie"), rs.getString("ville"),
						rs.getFloat("prix"), rs.getInt("nbPiece"),
						rs.getInt("superficie"), rs.getString("texte"),
						rs.getString("images"), rs.getString("status"),
						proprietaire) ;
				listeFiltre.add(bien);
			}
			System.out.println(req);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("FILTRE ACCUEIL MARCHE PAS...");
		}
		return listeFiltre;
	}
	//METHODE FILTRE CLIENT
	public ArrayList<Bien> filtreClientEmploye(String ville, Float prix, String type, Float nbPiece, int superficie, String categorie) {
		ArrayList<Bien> listeClientEmploye = new ArrayList<>();
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM bien"+
					" WHERE ville=? AND prix<=? AND type=? AND nbPiece<=? AND superficie<=? AND categorie=?;");
			req.setString(1, ville);
			req.setFloat(2, prix);
			req.setString(3, type);
			req.setFloat(4, nbPiece);
			req.setInt(5, superficie);
			req.setString(6, categorie);

			ResultSet rs = req.executeQuery();

			while (rs.next()) {
				Bien bien = new Bien(rs.getString("titre"),rs.getString("type"),
						rs.getString("categorie"), rs.getString("ville"),
						rs.getFloat("prix"), rs.getInt("nbPiece"),
						rs.getInt("superficie"), rs.getString("texte"),
						rs.getString("images"), rs.getString("status"),
						proprietaire) ;
				listeClientEmploye.add(bien);
			}
			//System.out.println(req);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("FILTRE Client MARCHE PAS...");
		}
		return listeClientEmploye;
	}
	//METHODE VOIR MES BIENS PROPRIO
	public ArrayList<Bien> voirMesBiens(User user) {
		ArrayList<Bien> listeMesBiens = new ArrayList<>();
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM bien b INNER JOINT proprietaire p ON"
					+ " b.proprietaire = p.id"
					+ " WHERE proprietaire=? ;");
			req.setInt(1, proprietaire.getUser().getId());

			ResultSet rs = req.executeQuery();

			while (rs.next()) {
				Bien bienP = new Bien(rs.getString("titre"),rs.getString("type"),
						rs.getString("categorie"), rs.getString("ville"),
						rs.getFloat("prix"), rs.getInt("nbPiece"),
						rs.getInt("superficie"), rs.getString("texte"),
						rs.getString("images"), rs.getString("status"),
						proprietaire) ;
				listeMesBiens.add(bienP);
			}
			System.out.println(req);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("VOIR MES BIENS MARCHE PAS...");
		}
		return listeMesBiens;
	}
	//METHODE COMBOX VILLES
	public ArrayList<String> getVille() {
		ArrayList<String> villes = new ArrayList<>();
		try {
			PreparedStatement sql = connect.prepareStatement("SELECT ville FROM bien ;");
			rs = sql.executeQuery();

			while (rs.next()) {
				villes.add(rs.getString("ville"));
			}
			return villes;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean update(Bien bien,int id) {
		try {
			PreparedStatement ps = connect.prepareStatement("UPDATE bien SET titre = ?, type=?, "
					+ "categorie=?, ville=?, prix=?, nbpiece=?, superficie=?,texte=?, images=?,"
					+ " status=?, proprietaire=? WHERE id=?");
			ps.setString(1,bien.getTitre());
			ps.setString(2,bien.getType());
			ps.setString(3,bien.getCategorie());
			ps.setString(4,bien.getVille());
			ps.setFloat(5,bien.getPrix());
			ps.setInt(6,bien.getNbPiece());
			ps.setInt(7,bien.getSuperficie());
			ps.setString(8,bien.getTexte());
			ps.setString(9,bien.getImages());
			ps.setString(10,bien.getStatus());
			ps.setInt(11,bien.getProprietaire().getId());
			ps.setInt(12,id);
			//System.out.println(ps);
			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;


	}
}




