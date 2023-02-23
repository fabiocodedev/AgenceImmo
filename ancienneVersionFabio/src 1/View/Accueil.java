package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Controller.BienDao;
import Model.Bien;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Accueil extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField fieldPrix;
	private JTextField fieldSup;
	
	BienDao bienDao = new BienDao();

	
	/**
	 * Create the panel.
	 */
	public Accueil() {
		setBounds(0, 0, 1366, 492);
		setLayout(null);
		//PANEL BASE ----------------------------------------------------------------------------------------------------------
		JPanel panelAccueilBase = new JPanel();
		panelAccueilBase.setBackground(new Color(0, 64, 128));
		panelAccueilBase.setBounds(0, 0, 1366, 492);
		add(panelAccueilBase);
		//PANEL REPLACE ----------------------------------------------------------------------------------------------------------
		JPanel panelReplace = new JPanel();
		//panelReplace.setBounds(81, 85, 1137, 327);
		panelAccueilBase.add(panelReplace);
		panelReplace.setBounds(24, 68, 1318, 401);
		panelReplace.setLayout(null);
		//PANEL ACCUEIL ----------------------------------------------------------------------------------------------------------
		JPanel panelAccueil = new JPanel();
		panelAccueil.setBackground(new Color(0, 128, 128));
		panelAccueil.setBounds(0, 0, 1318, 401);
		panelReplace.add(panelAccueil);
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
		panelListAccueil.setBackground(new Color(0, 128, 128));
		panelListAccueil.setBounds(10, 57, 1298, 333);
		panelAccueil.add(panelListAccueil);
		panelListAccueil.setLayout(null);
		
		String col[] = {"Titre", "image","ville","prix"};
		
		
//		try {
//			for ( Bien listBien : BienDao.read()) {
//				listBien.getTitre();
//			}
//		} catch (Exception e1) {
//			e1.printStackTrace();
//		}
		
		
		JPanel panelCard1 = new JPanel();
		panelCard1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelReplace.removeAll();
				ShowBien sb = new ShowBien();
				panelReplace.add(sb);
				panelReplace.repaint();
				panelReplace.revalidate();
			}
		});
		panelCard1.setBackground(new Color(255, 255, 255));
		panelCard1.setBounds(45, 11, 247, 311);
		panelListAccueil.add(panelCard1);
		panelCard1.setLayout(null);
		
		JLabel lblTitre1 = new JLabel("");
		lblTitre1.setBackground(new Color(255, 255, 255));
		lblTitre1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitre1.setBounds(22, 11, 198, 23);
		panelCard1.add(lblTitre1);
		//lblTitre1.setText(bien.getTitre());
		
		JLabel lblIMG1 = new JLabel("");
		lblIMG1.setBounds(22, 45, 198, 173);
		panelCard1.add(lblIMG1);
		
		JLabel lblVille1 = new JLabel("");
		lblVille1.setHorizontalAlignment(SwingConstants.CENTER);
		lblVille1.setBackground(Color.WHITE);
		lblVille1.setBounds(22, 240, 198, 23);
		panelCard1.add(lblVille1);
		
		JLabel lblPrix1 = new JLabel("");
		lblPrix1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrix1.setBackground(Color.WHITE);
		lblPrix1.setBounds(22, 277, 198, 23);
		panelCard1.add(lblPrix1);
		
		JPanel panelCard2 = new JPanel();
		panelCard2.setBounds(363, 11, 247, 311);
		panelListAccueil.add(panelCard2);
		panelCard2.setLayout(null);
		
		JLabel lblTitre2 = new JLabel("");
		lblTitre2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitre2.setBackground(Color.WHITE);
		lblTitre2.setBounds(25, 11, 198, 23);
		panelCard2.add(lblTitre2);
		
		JLabel lblIMG2 = new JLabel("");
		lblIMG2.setBounds(25, 45, 198, 173);
		panelCard2.add(lblIMG2);
		
		JLabel lblVille2 = new JLabel("");
		lblVille2.setHorizontalAlignment(SwingConstants.CENTER);
		lblVille2.setBackground(Color.WHITE);
		lblVille2.setBounds(25, 240, 198, 23);
		panelCard2.add(lblVille2);
		
		JLabel lblPrix2 = new JLabel("");
		lblPrix2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrix2.setBackground(Color.WHITE);
		lblPrix2.setBounds(25, 277, 198, 23);
		panelCard2.add(lblPrix2);
		
		JPanel panelCard3 = new JPanel();
		panelCard3.setBounds(685, 11, 247, 311);
		panelListAccueil.add(panelCard3);
		panelCard3.setLayout(null);
		
		JLabel lblTitre3 = new JLabel("");
		lblTitre3.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitre3.setBackground(Color.WHITE);
		lblTitre3.setBounds(26, 11, 198, 23);
		panelCard3.add(lblTitre3);
		
		JLabel lblIMG3 = new JLabel("");
		lblIMG3.setBounds(26, 45, 198, 173);
		panelCard3.add(lblIMG3);
		
		JLabel lblVille3 = new JLabel("");
		lblVille3.setHorizontalAlignment(SwingConstants.CENTER);
		lblVille3.setBackground(Color.WHITE);
		lblVille3.setBounds(26, 240, 198, 23);
		panelCard3.add(lblVille3);
		
		JLabel lblPrix3 = new JLabel("");
		lblPrix3.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrix3.setBackground(Color.WHITE);
		lblPrix3.setBounds(26, 277, 198, 23);
		panelCard3.add(lblPrix3);
		
		JPanel panelCard4 = new JPanel();
		panelCard4.setBounds(1000, 11, 247, 311);
		panelListAccueil.add(panelCard4);
		panelCard4.setLayout(null);
		
		JLabel lblTitre4 = new JLabel("");
		lblTitre4.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitre4.setBackground(Color.WHITE);
		lblTitre4.setBounds(25, 11, 198, 23);
		panelCard4.add(lblTitre4);
		
		JLabel lblIMG4 = new JLabel("");
		lblIMG4.setBounds(25, 45, 198, 173);
		panelCard4.add(lblIMG4);
		
		JLabel lblVille4 = new JLabel("");
		lblVille4.setHorizontalAlignment(SwingConstants.CENTER);
		lblVille4.setBackground(Color.WHITE);
		lblVille4.setBounds(25, 247, 198, 23);
		panelCard4.add(lblVille4);
		
		JLabel lblPrix4 = new JLabel("");
		lblPrix4.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrix4.setBackground(Color.WHITE);
		lblPrix4.setBounds(25, 277, 198, 23);
		panelCard4.add(lblPrix4);
		//PANEL ACHAT ----------------------------------------------------------------------------------------------------------
		JPanel panelAchat = new JPanel();
		panelAchat.setBackground(new Color(0, 128, 128));
		panelAchat.setBounds(0, 0, 1318, 401);
		panelReplace.add(panelAchat);
		panelAchat.setVisible(false);
		
		JPanel panelListAchat = new JPanel();
		panelListAchat.setBackground(new Color(0, 128, 128));
		panelListAchat.setBounds(10, 11, 1298, 379);
		panelAchat.add(panelListAchat);
		panelListAchat.setLayout(null);
		
		JPanel card1achat = new JPanel();
		card1achat.setBounds(56, 11, 215, 357);
		panelListAchat.add(card1achat);
		card1achat.setLayout(null);
		
		JLabel titre1achat = new JLabel("");
		titre1achat.setBounds(9, 11, 196, 24);
		card1achat.add(titre1achat);
		
		JLabel img1achat = new JLabel("");
		img1achat.setBounds(9, 64, 198, 173);
		card1achat.add(img1achat);
		
		JLabel ville1achat = new JLabel("");
		ville1achat.setBounds(9, 266, 196, 24);
		card1achat.add(ville1achat);
		
		JLabel prix1achat = new JLabel("");
		prix1achat.setBounds(9, 311, 196, 24);
		card1achat.add(prix1achat);
		
		JPanel card2achat = new JPanel();
		card2achat.setLayout(null);
		card2achat.setBounds(359, 11, 215, 357);
		panelListAchat.add(card2achat);
		
		JLabel titre2achat = new JLabel("");
		titre2achat.setBounds(9, 11, 196, 24);
		card2achat.add(titre2achat);
		
		JLabel img2achat = new JLabel("");
		img2achat.setBounds(9, 64, 198, 173);
		card2achat.add(img2achat);
		
		JLabel ville2achat = new JLabel("");
		ville2achat.setBounds(9, 266, 196, 24);
		card2achat.add(ville2achat);
		
		JLabel prix2achat = new JLabel("");
		prix2achat.setBounds(9, 311, 196, 24);
		card2achat.add(prix2achat);
		
		JPanel card3achat = new JPanel();
		card3achat.setLayout(null);
		card3achat.setBounds(696, 11, 215, 357);
		panelListAchat.add(card3achat);
		
		JLabel titre3achat = new JLabel("");
		titre3achat.setBounds(9, 11, 196, 24);
		card3achat.add(titre3achat);
		
		JLabel img3achat = new JLabel("");
		img3achat.setBounds(9, 64, 198, 173);
		card3achat.add(img3achat);
		
		JLabel ville3achat = new JLabel("");
		ville3achat.setBounds(9, 266, 196, 24);
		card3achat.add(ville3achat);
		
		JLabel prix3achat = new JLabel("");
		prix3achat.setBounds(9, 311, 196, 24);
		card3achat.add(prix3achat);
		
		JPanel card4achat = new JPanel();
		card4achat.setLayout(null);
		card4achat.setBounds(1010, 11, 215, 357);
		panelListAchat.add(card4achat);
		
		JLabel titre4achat = new JLabel("");
		titre4achat.setBounds(9, 11, 196, 24);
		card4achat.add(titre4achat);
		
		JLabel img4achat = new JLabel("");
		img4achat.setBounds(9, 64, 198, 173);
		card4achat.add(img4achat);
		
		JLabel ville4achat = new JLabel("");
		ville4achat.setBounds(9, 266, 196, 24);
		card4achat.add(ville4achat);
		
		JLabel prix4achat = new JLabel("");
		prix4achat.setBounds(9, 311, 196, 24);
		card4achat.add(prix4achat);
		panelAchat.setLayout(null);
		
		//PANEL LOCATION ----------------------------------------------------------------------------------------------------------
		JPanel panelLocation = new JPanel();
		panelLocation.setBackground(new Color(0, 128, 128));
		panelLocation.setBounds(0, 0, 1318, 401);
		panelReplace.add(panelLocation);
		panelLocation.setVisible(true);
		
		JPanel panelListLoc = new JPanel();
		panelListLoc.setBackground(new Color(0, 128, 128));
		panelListLoc.setBounds(10, 11, 1298, 379);
		panelLocation.setLayout(null);
		panelLocation.add(panelListLoc);
		panelListLoc.setLayout(null);
		
		JPanel card1loc = new JPanel();
		card1loc.setBackground(new Color(255, 255, 255));
		card1loc.setBounds(56, 11, 215, 357);
		panelListLoc.add(card1loc);
		card1loc.setLayout(null);
		
		JLabel titre1loc = new JLabel("");
		titre1loc.setBounds(9, 11, 196, 24);
		card1loc.add(titre1loc);
		
		JLabel img1loc = new JLabel("");
		img1loc.setBounds(9, 67, 198, 173);
		card1loc.add(img1loc);
		
		JLabel ville1loc = new JLabel("");
		ville1loc.setBounds(9, 266, 196, 24);
		card1loc.add(ville1loc);
		
		JLabel prix1loc = new JLabel("");
		prix1loc.setBounds(9, 311, 196, 24);
		card1loc.add(prix1loc);
		
		JPanel card2loc = new JPanel();
		card2loc.setLayout(null);
		card2loc.setBounds(359, 11, 215, 357);
		panelListLoc.add(card2loc);
		
		JLabel titre2loc = new JLabel("");
		titre2loc.setBounds(9, 11, 196, 24);
		card2loc.add(titre2loc);
		
		JLabel img2loc = new JLabel("");
		img2loc.setBounds(9, 67, 198, 173);
		card2loc.add(img2loc);
		
		JLabel ville2loc = new JLabel("");
		ville2loc.setBounds(9, 266, 196, 24);
		card2loc.add(ville2loc);
		
		JLabel prix2loc = new JLabel("");
		prix2loc.setBounds(9, 311, 196, 24);
		card2loc.add(prix2loc);
		
		JPanel card3loc = new JPanel();
		card3loc.setLayout(null);
		card3loc.setBounds(696, 11, 215, 357);
		panelListLoc.add(card3loc);
		
		JLabel titre3loc = new JLabel("");
		titre3loc.setBounds(9, 11, 196, 24);
		card3loc.add(titre3loc);
		
		JLabel img3loc = new JLabel("");
		img3loc.setBounds(9, 67, 198, 173);
		card3loc.add(img3loc);
		
		JLabel ville3loc = new JLabel("");
		ville3loc.setBounds(9, 266, 196, 24);
		card3loc.add(ville3loc);
		
		JLabel prix3loc = new JLabel("");
		prix3loc.setBounds(9, 311, 196, 24);
		card3loc.add(prix3loc);
		
		JPanel card4loc = new JPanel();
		card4loc.setLayout(null);
		card4loc.setBounds(1010, 11, 215, 357);
		panelListLoc.add(card4loc);
		
		JLabel titre4loc = new JLabel("");
		titre4loc.setBounds(9, 11, 196, 24);
		card4loc.add(titre4loc);
		
		JLabel img4loc = new JLabel("");
		img4loc.setBounds(9, 67, 198, 173);
		card4loc.add(img4loc);
		
		JLabel ville4loc = new JLabel("");
		ville4loc.setBounds(9, 266, 196, 24);
		card4loc.add(ville4loc);
		
		JLabel prix4loc = new JLabel("");
		prix4loc.setBounds(9, 311, 196, 24);
		card4loc.add(prix4loc);

		//BOUTON ACCUEIL ----------------------------------------------------------------------------------------------------------
		JButton btnAccueil = new JButton("ACCUEIL");
		btnAccueil.setBounds(65, 11, 255, 31);
		btnAccueil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Afficher la page d'accueil
				panelReplace.removeAll();
				panelReplace.add(panelAccueil);
				panelAccueil.setVisible(true);
				panelReplace.repaint();
				panelReplace.revalidate();
			}
		});
		panelAccueilBase.setLayout(null);
		btnAccueil.setFont(new Font("Papyrus", Font.BOLD, 16));
		panelAccueilBase.add(btnAccueil);
		//BOUTON ACHAT ----------------------------------------------------------------------------------------------------------
		JButton btnAchat = new JButton("ACHAT");
		btnAchat.setBounds(549, 11, 255, 31);
		btnAchat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Afficher la page achat
				panelReplace.removeAll();
				panelReplace.add(panelAchat);
				panelAchat.setVisible(true);
				panelReplace.repaint();
				panelReplace.revalidate();
			}
		});
		btnAchat.setFont(new Font("Papyrus", Font.BOLD, 16));
		panelAccueilBase.add(btnAchat);
		//BOUTON LOCATION ----------------------------------------------------------------------------------------------------------
		JButton btnLoc = new JButton("LOCATION");
		btnLoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Afficher la page location
				panelReplace.removeAll();
				panelReplace.add(panelLocation);
				panelLocation.setVisible(true);
				panelReplace.repaint();
				panelReplace.revalidate();
			}
		});
		btnLoc.setBounds(1030, 11, 255, 31);
		btnLoc.setFont(new Font("Papyrus", Font.BOLD, 16));
		panelAccueilBase.add(btnLoc);
		//PANEL VISIBLE PAR DEFAUT ----------------------------------------------------------------------------------------------------------
		panelReplace.removeAll();
		panelReplace.add(panelAccueil);
		panelAccueil.setVisible(true);
		panelReplace.repaint();
		panelReplace.revalidate();

	}

}
