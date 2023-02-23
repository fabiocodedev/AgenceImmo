package Controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connect.BDDConnection;
import Model.Achat;
import Model.Bien;
import Model.Client;
import Model.User;

public class AchatDao implements ImmoIntDao<Achat> {

	Connection connect = BDDConnection.getConnect();
	ResultSet rs = null;
	Client client = new Client();
	Bien bien = new Bien();
	
	@Override
	public boolean create(Achat achat) {
		
	try {
			PreparedStatement sql = connect.prepareStatement("INSERT INTO achat (date, fraisAgenceAchat) VALUES (?,?)");

			sql.setDate(1,Date.valueOf("date"));
			sql.setFloat(2,achat.getFraisAgenceAchat());
			sql.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public List<Achat> read() {
		
		ArrayList<Achat> listAchat = new ArrayList<>();
		try {
			PreparedStatement sql = connect.prepareStatement("SELECT * FROM achat");
			rs = sql.executeQuery();

			while (rs.next()) {
				Achat achat = new Achat(rs.getInt("id"), rs.getDate("date"), rs.getFloat("fraisAgenceAchat"), bien, client );
				listAchat.add(achat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listAchat;
	}
	@Override
	public boolean delete(Achat object) {
		
		return false;
	}
	@Override
	public boolean update(Achat object, int id) {
		// TODO Auto-generated method stub
		return false;
	}
}
