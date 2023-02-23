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
import Model.Location;

public class LocationDao implements ImmoIntDao<Location> {

	Connection connect = BDDConnection.getConnect();
	ResultSet rs = null;
	Client client = new Client();
	Bien bien = new Bien();
	
	@Override
	public boolean create(Location location) {
		
		try {
				PreparedStatement sql = connect.prepareStatement("INSERT INTO location (fraisAgenceAchat, dateDebut, dateFin)"
						+ " VALUES (?,?,?)");

				sql.setFloat(1,location.getFraisAgenceLoc());
				sql.setDate(2,Date.valueOf("dateDebut"));
				sql.setDate(2,Date.valueOf("dateFin"));
				sql.execute();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return false;
	}

	@Override
	public List<Location> read() {
		ArrayList<Location> listLoc = new ArrayList<>();
		try {
			PreparedStatement sql = connect.prepareStatement("SELECT * FROM location");
			rs = sql.executeQuery();

			while (rs.next()) {
				Location location = new Location(rs.getInt("id"), rs.getFloat("fraisAgenceAchat"), rs.getDate("dateDebut"),  rs.getDate("dateFin"), bien, client );
				listLoc.add(location);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listLoc;
	}


	@Override
	public boolean delete(Location location) {
		
		return false;
	}

	@Override
	public boolean update(Location object, int id) {
		// TODO Auto-generated method stub
		return false;
	}

	



}
