package View;

import javax.swing.JPanel;

import Controller.BienDao;
import Controller.ClientDao;
import Controller.EmployeDao;
import Controller.MatriculeDao;
import Controller.ProprietaireDao;
import Controller.UserDao;
import Model.User;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTable;

public class ShowListBien extends JPanel {
	
	
	static User currentUser;

	//String selected = "client";
	//String selected = "";
	UserDao userDao = new UserDao();
	MatriculeDao matriculeDao = new MatriculeDao();
	EmployeDao employeDao = new EmployeDao();
	ClientDao clientDao = new ClientDao();
	BienDao bienDao =new BienDao();
	ProprietaireDao proprietaireDao = new ProprietaireDao();
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ShowListBien() {
		setLayout(null);
		setBounds(0, 0, 1366, 492);
		
		JPanel panelShowListBien = new JPanel();
		panelShowListBien.setBounds(0, 0, 1366, 492);
		add(panelShowListBien);
		panelShowListBien.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 92, 855, 341);
		panelShowListBien.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);

		
		

		
		
	}
	
	
	
	
	
	
	
	
}
