package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connect.BDDConnection;
import Model.Matricule;

public class MatriculeDao implements ImmoIntDao<Matricule> {
	
	Connection connect= BDDConnection.getConnect();
	ResultSet rs = null;
	
	@Override
	public boolean create(Matricule matricule) {
		// Mettre dans la base de données
		String maRequete = "INSERT INTO matricule (mat) "
				+ " VALUES (?,)";
		try {
			PreparedStatement sql = connect.prepareStatement(maRequete);
			sql.setString(1, matricule.getMat());
			System.out.println(sql+" \n ***************");
			sql.execute();
			
			  sql = connect.prepareStatement("select distinct LAST_INSERT_ID() as id from matricule");
	          rs = sql.executeQuery();
			  if (rs.next()) {
				  matricule.setId(rs.getInt("id"));
			  }
			  return true;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Matricule> read() {
		ArrayList<Matricule> listeMatricule = new ArrayList<>();
		try {
			PreparedStatement sql = connect.prepareStatement(" SELECT *, matricule.id as matID FROM matricule ");
			rs= sql.executeQuery();
			while(rs.next()) {
			
				Matricule mat = new Matricule(rs.getInt("matID"),rs.getString("mat"));
				listeMatricule.add(mat);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listeMatricule;
	}

	@Override
	public void update(Matricule matricule) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean delete(Matricule matricule) {
		// TODO Auto-generated method stub
		return false;
	}

	   public Matricule isExistMat(String mat) {
	        try {
	            PreparedStatement sql = connect.prepareStatement("SELECT * FROM matricule WHERE mat=?");// tester pour cdamt2

	            sql.setString(1, mat);

	            ResultSet rs = sql.executeQuery();

	            if (rs.next()) {
	                return new Matricule(rs.getInt("id"),rs.getString("mat"));
	            }
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        return null;
	    }
	
	  
	   
	
}
