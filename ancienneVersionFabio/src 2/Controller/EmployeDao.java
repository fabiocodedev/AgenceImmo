package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connect.BDDConnection;
import Model.Achat;
import Model.Client;
import Model.Employe;
import Model.Matricule;
import Model.User;

public class EmployeDao implements ImmoIntDao<Employe>{
	Connection connect= BDDConnection.getConnect();

	ResultSet res = null;

	UserDao userDao = new UserDao();
	Matricule matricule = new Matricule();

	@Override
	public boolean create(Employe employe) {

		String   Requete = "INSERT INTO employe (user, matricule)"
				+ "VALUES (?,?)";

		try {

			PreparedStatement sq = connect.prepareStatement(Requete);
			sq.setInt(1, employe.getUser().getId());
			sq.setInt(2, employe.getMatricule().getId());
			System.out.println(sq +" \n ***************");
			sq.execute();
			sq = connect.prepareStatement("select distinct LAST_INSERT_ID() as id from employe");
			System.out.println(sq);
			ResultSet res = sq.executeQuery();

			if(res.next()) {

				employe.setId(res.getInt("id"));
				//prevoir une liste de matricule
				
			}

		}catch(SQLException e) {

			e.printStackTrace();
			return false;
		}
		return true;             
		
	}
	//Fonction de récupération de liste des employes
	@Override
	public List<Employe> read() {

		ArrayList<Employe> listeEmploye = new ArrayList<>();
		try {
			PreparedStatement sql = connect.prepareStatement("SELECT *, employe.id as emplID FROM employe"
					+ " INNER JOIN user ON employe.user = user.id"
					+ " INNER JOIN matricule ON employe.matricule = matricule.id");

			res= sql.executeQuery();

			while(res.next()) {
				User user = new User(res.getString("nom"),res.getString("prenom"),res.getString("email"));
				Matricule matricule = new Matricule(res.getString("num"));
				Employe empl = new Employe(res.getInt("emplID"),res.getString("prenom"),res.getString("nom"),res.getString("email"),user,matricule);

				listeEmploye.add(empl);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listeEmploye;
	}

	

	@Override
	public boolean delete(Employe employe) {

		try {			
			PreparedStatement req = connect.prepareStatement("DELETE FROM employe WHERE id=?");	

			req.setInt(1, employe.getId());

			req.executeUpdate();
			return true;
		}catch(Exception e) {
			e.printStackTrace();		
		}
		return false;	
	}

	public Employe findEmployeById(int id) {
		Employe employe=null;
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM employe "
					+ " INNER JOIN user "
					+ " ON user.id=employe.user "
					+ " INNER JOIN Matricule "
					+ " ON employe.id_matricule = matricule "
					+ " WHERE employe.id=? ");
			req.setInt(1, id);

			ResultSet rs = req.executeQuery();
			if(rs.next()) {
				User user = new User(rs.getString("prenom"), rs.getString("nom"), 
						rs.getString("email")
						);
				Matricule matricule = new Matricule(rs.getString("num"));

				employe = new Employe(rs.getInt("id"), user, matricule);

			}

		}catch(Exception e) {
			e.printStackTrace();

		}
		return employe;
	}
	// METHODE ISEXISTE
		public Employe isExistEmploye(String email) {
	        try {
	            PreparedStatement sql = connect.prepareStatement("SELECT * FROM user "
	            		+ " INNER JOIN employe emp ON user.id = emp.user WHERE email=?");

	            sql.setString(1, email);

	            System.out.println(sql);
	            ResultSet rs = sql.executeQuery();

	            if (rs.next()) {
	            	System.out.println(rs.getInt("id")+" ********************** "+rs.getString("email"));
	            	User user = new User(rs.getInt("id"),rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),rs.getString("password"));
	            	
	            	return  new Employe(rs.getInt("id"),user, matricule);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
		@Override
		public boolean update(Employe object, int id) {
			// TODO Auto-generated method stub
			return false;
		}
		
}
