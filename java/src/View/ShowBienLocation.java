package View;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import Controller.BienDao;
import Controller.LocationDao;

import javax.swing.ImageIcon;
import java.awt.Dimension;
import javax.swing.JButton;

import Model.Bien;
import Model.User;
import Model.Employe;
import Model.Location;
import Model.Client;
import Model.Proprietaire;
import Model.Message;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ShowBienLocation extends JPanel {

	BienDao bienDao = new BienDao();

	ArrayList<Bien> Biens = bienDao.read();
	Bien bien = new Bien();

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public ShowBienLocation(Bien bien) {
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 1366, 570);
		setLayout(null);

		JPanel panelShowBien = new JPanel();
		panelShowBien.setBackground(new Color(0, 128, 128));
		panelShowBien.setBounds(0, 0, 1366, 570);
		add(panelShowBien);
		panelShowBien.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setAutoscrolls(true);
		scrollPane.setBounds(0, 0, 1366, 570);
		panelShowBien.add(scrollPane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		scrollPane.setViewportView(panel);
		panel.setLayout(null);

		JLabel LabelTitre = new JLabel("Appartement à louer  ");
		LabelTitre.setHorizontalAlignment(SwingConstants.CENTER);
		LabelTitre.setHorizontalTextPosition(SwingConstants.CENTER);
		LabelTitre.setFont(new Font("Papyrus", Font.BOLD, 30));
		LabelTitre.setBounds(212, 16, 231, 43);
		panel.add(LabelTitre);

		JLabel LabelLocalisation = new JLabel("Paris");
		LabelLocalisation.setFont(new Font("Papyrus", Font.BOLD, 24));
		LabelLocalisation.setHorizontalAlignment(SwingConstants.CENTER);
		LabelLocalisation.setIcon(new ImageIcon(ShowBienLocation.class.getResource("/ressource/rsz_map-location-location-icon.jpg")));
		LabelLocalisation.setBounds(171, 175, 211, 102);
		panel.add(LabelLocalisation);

		JLabel LabelNbrePieces = new JLabel("4 pièces");
		LabelNbrePieces.setHorizontalTextPosition(SwingConstants.CENTER);
		LabelNbrePieces.setHorizontalAlignment(SwingConstants.CENTER);
		LabelNbrePieces.setFont(new Font("Papyrus", Font.BOLD, 22));
		LabelNbrePieces.setBounds(191, 335, 231, 43);
		panel.add(LabelNbrePieces);

		JLabel LabelSuperficie = new JLabel("66 m²");
		LabelSuperficie.setHorizontalTextPosition(SwingConstants.CENTER);
		LabelSuperficie.setHorizontalAlignment(SwingConstants.CENTER);
		LabelSuperficie.setFont(new Font("Papyrus", Font.BOLD, 22));
		LabelSuperficie.setBounds(181, 288, 214, 36);
		panel.add(LabelSuperficie);

		JLabel LabelPrix = new JLabel("885 €  /mois");
		LabelPrix.setHorizontalTextPosition(SwingConstants.CENTER);
		LabelPrix.setHorizontalAlignment(SwingConstants.CENTER);
		LabelPrix.setFont(new Font("Papyrus", Font.BOLD, 26));
		LabelPrix.setBounds(171, 111, 219, 55);
		panel.add(LabelPrix);

		JLabel LabelTitreAvis = new JLabel("Avis de l'agent :");
		LabelTitreAvis.setFont(new Font("Papyrus", Font.BOLD, 22));
		LabelTitreAvis.setBounds(56, 386, 185, 43);
		panel.add(LabelTitreAvis);

		JLabel LabelAvis = new JLabel("PROCHE DU CENTRE VILLE DE LA GARDE ET DES COMMODITES BEL APPARTEMENT RENOVE SEJOUR DOUBLE ET 2 CHAMBRES BALCON - CLIMATISATION GRAND PARKING COLLECTIF RARE A LA LOCATION SUR CE SECTEUR Les informations sur les risques auxquels ce bien est exposé sont disponibles sur le site Géorisques : www.georisques.gouv.fr . Loyer mensuel 780 euros - Charges locatives 105 euros.");
		LabelAvis.setAutoscrolls(true);
		LabelAvis.setMinimumSize(new Dimension(400, 14));
		LabelAvis.setMaximumSize(new Dimension(597, 14));
		LabelAvis.setFont(new Font("Papyrus", Font.PLAIN, 14));
		LabelAvis.setBounds(56, 440, 480, 82);
		panel.add(LabelAvis);

		JLabel LabelBienImage = new JLabel("");
		LabelBienImage.setIcon(new ImageIcon(ShowBienLocation.class.getResource("/ressource/"+Biens.get(0).getImages())));
		LabelBienImage.setBounds(603, 102, 580, 315);
		panel.add(LabelBienImage);

		//SET les labels
		LabelAvis.setText(bien.getTexte());
		LabelPrix.setText(String.valueOf(bien.getPrix()));
		LabelSuperficie.setText(bien.getSuperficie()+" m²");
		LabelTitre.setText(bien.getTitre());
		LabelLocalisation.setText(bien.getVille());
		LabelNbrePieces.setText(bien.getNbPiece()+" pièces");

		JButton btnRetour = new JButton("RETOUR");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelShowBien.removeAll();
				EspaceClient ec = new EspaceClient();
				panelShowBien.add(ec);
				panelShowBien.repaint();
				panelShowBien.revalidate();
			}
		});
		btnRetour.setFont(new Font("Papyrus", Font.BOLD, 12));
		btnRetour.setForeground(new Color(255, 0, 0));
		btnRetour.setBounds(30, 23, 113, 36);
		panel.add(btnRetour);


		
		//SET DYNAMIQUE
		Bien bienShow = bienDao.read().get(EspaceClient.table.getSelectedRow());


		LabelBienImage.setIcon(new ImageIcon(Accueil.class.getResource("/ressource/"+bienShow.getImages())));
		LabelLocalisation.setText(bienShow.getVille());
		LabelPrix.setText("Prix: "+bienShow.getPrix().toString()+" €");
		LabelTitre.setText(bienShow.getTitre());
		LabelSuperficie.setText("Superficie: "+String.valueOf(bienShow.getSuperficie())+" m²");
		LabelAvis.setText(bienShow.getTexte());
		LabelNbrePieces.setText(bienShow.getNbPiece()+" pieces");
		
		JButton btnReserver = new JButton("Reserver !");
		btnReserver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Client client = new Client();
				LocationDao locationDao = new LocationDao();
				
				Location location = new Location();
				
//				if(LocationDao.create(location)) {
//					
//					
//					
//					JOptionPane.showMessageDialog(null,"Merci pour votre reservation, nous vous contacteront "
//							+ "afin de convenir d'un RDV en agence pour signer un contrat et la remise des cléfs.",
//							"Felicitation",JOptionPane.INFORMATION_MESSAGE);
//					
//					panelShowBien.removeAll();
//					EspaceClient ec = new EspaceClient();
//					panelShowBien.add(ec);
//					panelShowBien.repaint();
//					panelShowBien.revalidate();
//				}
//				else {
//					JOptionPane.showMessageDialog(null, "OUPS, erreur lors de la reservation...");	
//				}
//				
			}
		});
		btnReserver.setFont(new Font("Papyrus", Font.BOLD, 20));
		btnReserver.setBounds(806, 464, 198, 55);
		panel.add(btnReserver);
	}
}
