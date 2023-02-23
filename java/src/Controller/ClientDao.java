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
import Model.Proprietaire;
import Model.User;

public class ClientDao implements ImmoIntDao<Client> {

	Connection connect= BDDConnection.getConnect();
	ResultSet rs = null;

	UserDao userDao = new UserDao();

	@Override
	public boolean create(Client client) {

	
		String   Requet = "INSERT INTO client (adresse,telephone,user)"
				+ "VALUES (?,?,?)";

		try {

			PreparedStatement nsq = connect.prepareStatement(Requet);

			//nsq.setInt(1, client.getId());
			nsq.setString(1,client.getAdresse());
			nsq.setString(2, client.getTelephone());
			nsq.setInt(3, client.getUser().getId());

			System.out.println(nsq +" \n ***************");
			nsq.execute();
			
			
			nsq = connect.prepareStatement("select distinct LAST_INSERT_ID() as id from client");
			rs = nsq.executeQuery();

			if(rs.next()) {

				client.setId(rs.getInt("id"));
				//prevoir une liste de matricule
			}

		}catch(SQLException e) {                                     

			e.printStackTrace();
		}
		return false;
	}
	//Fonction de récupération de liste des clients
	@Override
	public List<Client> read() {
		ArrayList<Client> listeClient = new ArrayList<>();
		try {
			PreparedStatement sql = connect.prepareStatement(" SELECT *, client.id as clID FROM client "
					+ " INNER JOIN user ON client.user = user.id ");

			rs= sql.executeQuery();

			while(rs.next()) {
				User user = new User(rs.getString("nom"),rs.getString("prenom"),rs.getString("email"));

				Client cli = new Client(rs.getInt("clID"),rs.getString("prenom"),rs.getString("nom"),rs.getString("email"),
						rs.getString("adresse"),rs.getString("telephone"), user);

				listeClient.add(cli);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeClient;

	}

	

	@Override
	public boolean delete(Client client) {
		try {			
			PreparedStatement req = connect.prepareStatement("DELETE FROM client WHERE id=?");	

			req.setInt(1, client.getId());

			req.executeUpdate();
			return true;
		}catch(Exception e) {
			e.printStackTrace();		
		}
		return false;	
	}
	// METHODE IVERICATION SI L'EMAIL DEJA
	public Client isExistClient(String email) {
        try {
            PreparedStatement sql = connect.prepareStatement("SELECT * FROM user "
            		+ " INNER JOIN client cli ON user.id = cli.user WHERE email=?");

            sql.setString(1, email);

            System.out.println(sql);
            ResultSet rs = sql.executeQuery();

            if (rs.next()) {
            	//System.out.println(rs.getInt("id")+" ********************** "+rs.getString("email"));
            	User user = new User(rs.getInt("id"),rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),rs.getString("password"));
            	
            	return  new Client(rs.getInt("id"),rs.getString("adresse"),rs.getString("telephone"),user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
	@Override
	public boolean update(Client object, int id) {
	
		return false;
	}

}
