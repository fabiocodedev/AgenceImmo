package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Connect.BDDConnection;
import Model.User;

public class UserDao implements ImmoIntDao<User>{
	Connection connect= BDDConnection.getConnect();


	public static User currentUser = new User();


	@Override
	public boolean create(User user) {
		// Mettre dans la base de données
		String maRequete = "INSERT INTO user (nom,prenom,email,password) "
				+ "VALUES (?,?,?,PASSWORD(?))";
		try {
			PreparedStatement sql = connect.prepareStatement(maRequete);
			sql.setString(1, user.getNom());
			sql.setString(2, user.getPrenom());
			sql.setString(3, user.getEmail());
			sql.setString(4, user.getPassword());
			sql.execute();
			sql = connect.prepareStatement("select distinct LAST_INSERT_ID() as id from user");
			ResultSet rs = sql.executeQuery();
			if (rs.next()) {
				user.setId(rs.getInt("id"));
			}
			return true;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<User> read() {

		return null;
	}

	

	@Override
	public boolean delete(User user) {
		try {			
			PreparedStatement req = connect.prepareStatement("DELETE FROM user WHERE id=?");	
			req.setInt(1, user.getId());
			req.executeUpdate();
			return true;
		}catch(Exception e) {
			e.printStackTrace();		
		}
		return false;	
	}

	/*
	 * Check si le mail passé en param existe dans la BDD
	 * Cette méthode retourne TRUE sil existe sinon elle retourne FALSE
	 */
	public Boolean isExist(String email) {
		try {
			PreparedStatement sql = connect.prepareStatement("SELECT * FROM user WHERE email=?");

			sql.setString(1, email);

			ResultSet rs = sql.executeQuery();

			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public User connection(String email, String password) {
		try {
			PreparedStatement sql = connect.prepareStatement("SELECT * FROM user WHERE email=? AND password =PASSWORD(?)");

			sql.setString(1, email);
			sql.setString(2, password);
			//System.out.println(sql);
			ResultSet rs = sql.executeQuery();
			if (rs.next()) {
				currentUser = new User(rs.getString("prenom"),rs.getString("nom"),rs.getString("email"),rs.getString("password"));
				return currentUser;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean isValidEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
				"[a-zA-Z0-9_+&*-]+)*@" +
				"(?:[a-zA-Z0-9-]+\\.)+[a-z" +
				"A-Z]{2,7}$";                             
		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}

	public boolean isPasswordValid(String password) {
		String regExpn = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=])(?=\\S+$).{8,}$";
		String inputStr = password;
		Pattern pattern = Pattern.compile(regExpn,Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(inputStr);
		if(matcher.matches())
			return true;
		else
			return false;
	}

	public boolean isPhoneValid(String telephone) {	
		String regExpn = "[0]{1}[1-7]{1}[0-9]{8}";
		String inputStr = telephone;
		Pattern pattern = Pattern.compile(regExpn,Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(inputStr);
		if(matcher.matches())
			return true;
		else
			return false;
	}

	@Override
	public boolean update(User object, int id) {
		// TODO Auto-generated method stub
		return false;
	}
}
