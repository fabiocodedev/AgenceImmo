package View;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.BienDao;
import Model.Bien;

public class NewAccueil extends JPanel {
	private JTextField fieldPrix;
	private JTextField fieldSup;

	
	
	//private JTable table;

	/**
	 * Create the panel.
	 */
	public NewAccueil() {
		setBounds(0, 0, 1366, 492);
		setLayout(null);
		//PANEL BASE ----------------------------------------------------------------------------------------------------------
		JPanel panelAccueilBaseT = new JPanel();
		panelAccueilBaseT.setBackground(new Color(0, 64, 128));
		//panelAccueilBase.setBounds(0, 0, 1366, 492);
		panelAccueilBaseT.setBounds(0, 0, 1366, 492);
		add(panelAccueilBaseT);
	
	
		//PANEL ACCUEIL ----------------------------------------------------------------------------------------------------------
				JPanel panelAccueil = new JPanel();
				panelAccueil.setBackground(new Color(0, 128, 128));
				panelAccueil.setBounds(0, 0, 1318, 401);
				//panelReplace.add(panelAccueil);
				panelAccueil.setVisible(false);
				panelAccueil.setLayout(null);
				
				JPanel panelFiltre = new JPanel();
				panelFiltre.setBackground(new Color(0, 128, 128));
				panelFiltre.setBounds(10, 11, 1298, 35);
				panelAccueil.add(panelFiltre);
				panelFiltre.setLayout(null);
				
				JLabel lblFiltre = new JLabel("FILTRE :");
				lblFiltre.setFont(new Font("Papyrus", Font.BOLD, 14));
				lblFiltre.setHorizontalAlignment(SwingConstants.CENTER);
				lblFiltre.setBounds(10, 8, 110, 18);
				panelFiltre.add(lblFiltre);
				
				JLabel lblPrix = new JLabel("Prix Maximum");
				lblPrix.setFont(new Font("Papyrus", Font.BOLD, 12));
				lblPrix.setHorizontalAlignment(SwingConstants.CENTER);
				lblPrix.setBounds(202, 11, 92, 14);
				panelFiltre.add(lblPrix);
				
				fieldPrix = new JTextField();
				fieldPrix.setBounds(304, 7, 96, 20);
				panelFiltre.add(fieldPrix);
				fieldPrix.setColumns(10);
				
				JLabel lblSup = new JLabel("Superficie Maximum");
				lblSup.setHorizontalAlignment(SwingConstants.CENTER);
				lblSup.setFont(new Font("Papyrus", Font.BOLD, 12));
				lblSup.setBounds(500, 10, 142, 14);
				panelFiltre.add(lblSup);
				
				fieldSup = new JTextField();
				fieldSup.setColumns(10);
				fieldSup.setBounds(652, 6, 96, 20);
				panelFiltre.add(fieldSup);
				
				JLabel lblVille = new JLabel("VILLE");
				lblVille.setHorizontalAlignment(SwingConstants.CENTER);
				lblVille.setFont(new Font("Papyrus", Font.BOLD, 12));
				lblVille.setBounds(903, 10, 142, 14);
				panelFiltre.add(lblVille);
				
				JComboBox comboBox = new JComboBox();
				comboBox.setBounds(1042, 6, 182, 22);
				panelFiltre.add(comboBox);

				JPanel panelListAccueil = new JPanel();
				panelListAccueil.setBackground(new Color(0, 255, 255));
				panelListAccueil.setBounds(10, 57, 1298, 333);
				panelAccueil.add(panelListAccueil);
				panelListAccueil.setLayout(null);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(0, 0, 1298, 333);
				panelListAccueil.add(scrollPane);
				
		
				
	}
}
