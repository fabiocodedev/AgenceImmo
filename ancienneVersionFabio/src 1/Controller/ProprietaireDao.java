package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connect.BDDConnection;
import Model.Matricule;
import Model.Proprietaire;
import Model.User;

public class ProprietaireDao implements ImmoIntDao<Proprietaire> {
	
	Connection connect= BDDConnection.getConnect();
	ResultSet rs = null;
	UserDao userDao = new UserDao();
	
	@Override
	public boolean create(Proprietaire proprietaire) {
		
			// Creation du user global
			userDao.create(proprietaire);
	                
	         //ou prevoir un trigger ou eliminer la table user
	             
	             String   Requet = "INSERT INTO proprietaire (adresse,telephone,user)"
	            		 + "VALUES (?,?,?)";
	             
	             try {
	            	 PreparedStatement nsq = connect.prepareStatement(Requet);
	            	// nsq.setInt(1,  proprietaire.getId());
	            	 nsq.setString(1, proprietaire.getAdresse());
	            	 nsq.setString(2,  proprietaire.getTelephone());
	            	 nsq.setInt(3,  proprietaire.getUser().getId());
	            		//System.out.println(nsq +" \n ***************");
	            	 nsq.execute();
	            	 nsq = connect.prepareStatement("select distinct LAST_INSERT_ID() as id from proprietaire ");
	            	 rs = nsq.executeQuery();
	            	 
	            	 if(rs.next()) {
	            		 
	            		 proprietaire.setId(rs.getInt("id"));
	            		 //prevoir une liste de matricule
	            	 }

	             }catch(SQLException e) {	 
	            	 e.printStackTrace();
	             }      
	            
		
		return false;
	}

		//Fonction de récupération de liste des proprietaires
	@Override
	public List<Proprietaire> read() {
		
		ArrayList<Proprietaire> listeProprietaire = new ArrayList<>();
		try {
			PreparedStatement sql = connect.prepareStatement(" SELECT *, proprietaire.id as proprioID FROM proprietaire "
					+ " INNER JOIN user ON proprietaire.user = user.id ");
			
			rs= sql.executeQuery();
			
			while(rs.next()) {
				User user = new User(rs.getString("nom"),rs.getString("prenom"),rs.getString("email"));
			
				Proprietaire proprio = new Proprietaire(rs.getInt("proprioID"),rs.getString("prenom"),rs.getString("nom"),rs.getString("email"),
						rs.getString("adresse"),rs.getString("telephone"), user);
			
				listeProprietaire.add(proprio);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listeProprietaire;
	}

	@Override
	public void update(Proprietaire proprietaire) {
		
	}

	@Override
	public boolean delete(Proprietaire proprietaire) {	
		try {			
			PreparedStatement req = connect.prepareStatement("DELETE FROM proprietaire WHERE id=?");	
			req.setInt(1, proprietaire.getId());
			req.executeUpdate();
			return true;
		}catch(Exception e) {
			e.printStackTrace();		
		}
		return false;	
	}

	public Proprietaire isExistProprio(String email) {
        try {
            PreparedStatement sql = connect.prepareStatement("SELECT * FROM user "
            		+ " INNER JOIN proprietaire pro ON user.id = pro.user WHERE email=?");// id=5 emai=fabtester pour cdamt2

            sql.setString(1, email);

            System.out.println(sql);
            ResultSet rs = sql.executeQuery();

            if (rs.next()) {
            	System.out.println(rs.getInt("id")+" ********************** "+rs.getString("email"));
                //return new Proprietaire(5,fab@dsdssdss);
            	User user = new User(rs.getInt("id"),rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),rs.getString("password"));
            	
            	return  new Proprietaire(rs.getInt("id"),rs.getString("adresse"),rs.getString("telephone"),user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
	
}

