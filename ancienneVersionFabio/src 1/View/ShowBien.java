package View;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import javax.swing.JButton;

import Model.Bien;
import Model.User;
import Model.Employe;
import Model.Client;
import Model.Proprietaire;
import Model.Message;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShowBien extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public ShowBien(Bien bien) {
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 1366, 492);
		setLayout(null);
		
		JPanel panelShowBien = new JPanel();
		panelShowBien.setBackground(new Color(0, 128, 128));
		panelShowBien.setBounds(0, 0, 1366, 492);
		add(panelShowBien);
		panelShowBien.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setAutoscrolls(true);
		scrollPane.setBounds(0, 0, 1366, 492);
		panelShowBien.add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		JLabel LabelTitre = new JLabel("Appartement à louer  ");
		LabelTitre.setHorizontalAlignment(SwingConstants.CENTER);
		LabelTitre.setHorizontalTextPosition(SwingConstants.CENTER);
		LabelTitre.setFont(new Font("Papyrus", Font.BOLD, 22));
		LabelTitre.setBounds(10, 11, 231, 43);
		panel.add(LabelTitre);
		
		JLabel LabelLocalisation = new JLabel("Paris");
		LabelLocalisation.setFont(new Font("Papyrus", Font.BOLD, 24));
		LabelLocalisation.setHorizontalAlignment(SwingConstants.CENTER);
		LabelLocalisation.setIcon(new ImageIcon(ShowBien.class.getResource("/ressource/rsz_map-location-location-icon.jpg")));
		LabelLocalisation.setBounds(30, 113, 211, 102);
		panel.add(LabelLocalisation);
		
		JLabel LabelNbrePieces = new JLabel("4 pièces");
		LabelNbrePieces.setHorizontalTextPosition(SwingConstants.CENTER);
		LabelNbrePieces.setHorizontalAlignment(SwingConstants.CENTER);
		LabelNbrePieces.setFont(new Font("Papyrus", Font.BOLD, 22));
		LabelNbrePieces.setBounds(20, 59, 123, 43);
		panel.add(LabelNbrePieces);
		
		JLabel LabelSuperficie = new JLabel("66 m²");
		LabelSuperficie.setHorizontalTextPosition(SwingConstants.CENTER);
		LabelSuperficie.setHorizontalAlignment(SwingConstants.CENTER);
		LabelSuperficie.setFont(new Font("Papyrus", Font.BOLD, 22));
		LabelSuperficie.setBounds(153, 59, 123, 36);
		panel.add(LabelSuperficie);
		
		JLabel LabelPrix = new JLabel("885 €  /mois");
		LabelPrix.setHorizontalTextPosition(SwingConstants.CENTER);
		LabelPrix.setHorizontalAlignment(SwingConstants.CENTER);
		LabelPrix.setFont(new Font("Papyrus", Font.BOLD, 26));
		LabelPrix.setBounds(370, 172, 161, 55);
		panel.add(LabelPrix);
		
		JLabel LabelTitreAvis = new JLabel("Avis de l'agent");
		LabelTitreAvis.setFont(new Font("Papyrus", Font.BOLD, 22));
		LabelTitreAvis.setBounds(56, 275, 185, 43);
		panel.add(LabelTitreAvis);
		
		JLabel LabelAvis = new JLabel("PROCHE DU CENTRE VILLE DE LA GARDE ET DES COMMODITES BEL APPARTEMENT RENOVE SEJOUR DOUBLE ET 2 CHAMBRES BALCON - CLIMATISATION GRAND PARKING COLLECTIF RARE A LA LOCATION SUR CE SECTEUR Les informations sur les risques auxquels ce bien est exposé sont disponibles sur le site Géorisques : www.georisques.gouv.fr . Loyer mensuel 780 euros - Charges locatives 105 euros.");
		LabelAvis.setAutoscrolls(true);
		LabelAvis.setMinimumSize(new Dimension(400, 14));
		LabelAvis.setMaximumSize(new Dimension(597, 14));
		LabelAvis.setFont(new Font("Papyrus", Font.PLAIN, 14));
		LabelAvis.setBounds(50, 329, 480, 82);
		panel.add(LabelAvis);
		
		JButton btnContactAgence = new JButton("Ecrire à l'agence");
		btnContactAgence.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Redirection vers la page d'accueil
				panelShowBien.removeAll();
				ContactForm cf = new ContactForm();
				panelShowBien.add(cf);
				panelShowBien.repaint();
				panelShowBien.revalidate();
				
			}
		});
		btnContactAgence.setFont(new Font("Papyrus", Font.PLAIN, 20));
		btnContactAgence.setBounds(50, 443, 314, 36);
		panel.add(btnContactAgence);
		
		JLabel LabelBienImage = new JLabel("");
		LabelBienImage.setIcon(new ImageIcon(ShowBien.class.getResource("/ressource/rsz_1appart1.jpg")));
		LabelBienImage.setBounds(591, 7, 720, 472);
		panel.add(LabelBienImage);
		
		if (bien.getImages() == null) {
			
			LabelBienImage.setText("Pas d'image");
			
		}else {
			
			LabelBienImage.setIcon(new ImageIcon(ShowBien.class.getResource("/ressource/"+bien.getImages())));
		}
		
		
		LabelAvis.setText(bien.getTexte());
		 LabelPrix.setText(bien.getPrix().toString()+ " €");
		 LabelSuperficie.setText(bien.getSuperficie()+" m²");
		 LabelTitre.setText(bien.getTitre());
		 LabelLocalisation.setText(bien.getVille());
		 LabelNbrePieces.setText(bien.getNbPiece()+" pièces");
		
		

	}

	public ShowBien() {
		// TODO Auto-generated constructor stub
	}
}
