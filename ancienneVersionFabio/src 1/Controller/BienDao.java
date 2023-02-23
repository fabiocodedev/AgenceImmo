package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
			System.out.println("OK Connection Create Bien");
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
			
			System.out.println(sql);
			
			sql.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public List<Bien> read() {
		List<Bien> listBien = new ArrayList<>();
		try {
			System.out.println("OK Connection Read Bien");
			PreparedStatement sql = connect.prepareStatement("SELECT * FROM Bien");
			rs = sql.executeQuery();
			
			
			while (rs.next()) {
				Bien bien = new Bien(rs.getString("titre"),rs.getString("type"),
						rs.getString("categorie"), rs.getString("ville"),
						rs.getFloat("prix"), rs.getInt("nbPiece"),
						rs.getInt("superficie"), rs.getString("texte"),
						rs.getString("images"), rs.getString("status"),
						proprietaire) ;
				listBien.add(bien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listBien;
	}
	
	@Override
	public void update(Bien object) {

		
	}
	
//	@Override
//	public void update(Float prix, String status) {
//		
//		try {
//			PreparedStatement ps = connect.prepareStatement("UPDATE bien SET prix=?, status=? WHERE id=?");
//			ps.setFloat(1,bien.getPrix());
//			ps.setString(2,bien.getStatus);
//			ps.setInt(3,bien.getId());
//			
//			ps.executeUpdate();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	
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
}
