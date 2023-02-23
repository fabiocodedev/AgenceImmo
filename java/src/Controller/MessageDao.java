package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import Connect.BDDConnection;
import Model.Bien;
import Model.User;
import Model.Client;
import Model.Message;
import Model.Proprietaire;

public class MessageDao implements ImmoIntDao<Message> {

	Connection connect= BDDConnection.getConnect();
	ResultSet rs = null;
	
	Bien bien = new Bien();
	UserDao userDao = new UserDao();
	User user = new User();
	ClientDao clientDao = new ClientDao();
	Client client = new Client();
	Proprietaire proprietaire = new Proprietaire();

	@Override
	public boolean create(Message message) {
		String   Requet = "INSERT INTO message (msg,client,bien)"
				+ "VALUES (?,?,?)";
		try {
			PreparedStatement nsq = connect.prepareStatement(Requet);
			nsq.setString(1,message.getMsg());
			nsq.setInt(2, message.getClient().getUser().getId());
			nsq.setInt(3, message.getBien().getId());

			System.out.println(nsq +" \n ***************");
			nsq.execute();
			nsq = connect.prepareStatement("select distinct LAST_INSERT_ID() as id from client");
			rs = nsq.executeQuery();

			if(rs.next()) {
				message.setId(rs.getInt("id"));
				//prevoir une liste de matricule
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public ArrayList<Message> read() {
		ArrayList<Message> listeMessage = new ArrayList<>();
		try {
			PreparedStatement sql = connect.prepareStatement(" SELECT *, message.id as msID FROM message "
					+ " INNER JOIN client ON message.client = client.id "
					+ " INNER JOIN bien on message.bien = bien.id "
					+ " JOIN user u ON client.user = u.id");
			System.out.println(sql);
			rs= sql.executeQuery();
			while(rs.next()) {
				User user = new User(rs.getString("prenom"),rs.getString("nom"),rs.getString("email"));
				
				Client client = new Client(rs.getInt("id"),rs.getString("prenom"),rs.getString("nom"),rs.getString("email"),
						rs.getString("adresse"),rs.getString("telephone"), user);

				Proprietaire proprietaire = new Proprietaire(rs.getInt("id"),rs.getString("prenom"),rs.getString("nom"),rs.getString("email"),
						rs.getString("adresse"),rs.getString("telephone"), user);

				Bien bien = new Bien(rs.getInt("id"),rs.getString("titre"),rs.getString("type"),
						rs.getString("categorie"), rs.getString("ville"),
						rs.getFloat("prix"), rs.getInt("nbPiece"),
						rs.getInt("superficie"), rs.getString("texte"),
						rs.getString("images"), rs.getString("status"),
						proprietaire) ;
				Message mess = new Message(rs.getInt("msID"), rs.getString("msg"), client, bien );

				listeMessage.add(mess);
				System.out.println(listeMessage);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeMessage;

	}

	@Override
	public boolean delete(Message message) {
		try {			
			PreparedStatement req = connect.prepareStatement("DELETE FROM message WHERE id=?");	

			req.setInt(1, message.getId());

			req.executeUpdate();
			return true;
		}catch(Exception e) {
			e.printStackTrace();		
		}
		return false;
	}

	@Override
	public boolean update(Message message,int id) {
		try {
			PreparedStatement ps = connect.prepareStatement("UPDATE message SET msg = ?, client=?, bien=?");

			ps.setString(1,message.getMsg());
			ps.setInt(2,message.getClient().getUser().getId());
			ps.setInt(3,message.getBien().getId());

			ps.setInt(4,id);
			//System.out.println(ps);
			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
