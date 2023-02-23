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

public class ShowBienAgence extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public ShowBienAgence(Bien bien) {

		
		
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 1366, 570);
		setLayout(null);
		
		JPanel panelShowBienAgence = new JPanel();
		panelShowBienAgence.setBackground(new Color(0, 128, 128));
		panelShowBienAgence.setBounds(0, 0, 1366, 570);
		add(panelShowBienAgence);
		panelShowBienAgence.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setAutoscrolls(true);
		scrollPane.setBounds(0, 0, 1366, 570);
		panelShowBienAgence.add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		JLabel LabelTitreE = new JLabel("Appartement à louer  ");
		LabelTitreE.setHorizontalAlignment(SwingConstants.CENTER);
		LabelTitreE.setHorizontalTextPosition(SwingConstants.CENTER);
		LabelTitreE.setFont(new Font("Papyrus", Font.BOLD, 22));
		LabelTitreE.setBounds(129, 11, 231, 43);
		panel.add(LabelTitreE);
		
		JLabel LabelLocalisationE = new JLabel("Paris");
		LabelLocalisationE.setFont(new Font("Papyrus", Font.BOLD, 24));
		LabelLocalisationE.setHorizontalAlignment(SwingConstants.CENTER);
		LabelLocalisationE.setIcon(new ImageIcon(ShowBienAchat.class.getResource("/ressource/rsz_map-location-location-icon.jpg")));
		LabelLocalisationE.setBounds(109, 133, 211, 102);
		panel.add(LabelLocalisationE);
		
		JLabel LabelNbrePiecesE = new JLabel("4 pièces");
		LabelNbrePiecesE.setHorizontalTextPosition(SwingConstants.CENTER);
		LabelNbrePiecesE.setHorizontalAlignment(SwingConstants.CENTER);
		LabelNbrePiecesE.setFont(new Font("Papyrus", Font.BOLD, 22));
		LabelNbrePiecesE.setBounds(93, 65, 123, 43);
		panel.add(LabelNbrePiecesE);
		
		JLabel LabelSuperficieE = new JLabel("66 m²");
		LabelSuperficieE.setHorizontalTextPosition(SwingConstants.CENTER);
		LabelSuperficieE.setHorizontalAlignment(SwingConstants.CENTER);
		LabelSuperficieE.setFont(new Font("Papyrus", Font.BOLD, 22));
		LabelSuperficieE.setBounds(264, 62, 123, 36);
		panel.add(LabelSuperficieE);
		
		JLabel LabelPrixE = new JLabel("885 €  /mois");
		LabelPrixE.setHorizontalTextPosition(SwingConstants.CENTER);
		LabelPrixE.setHorizontalAlignment(SwingConstants.CENTER);
		LabelPrixE.setFont(new Font("Papyrus", Font.BOLD, 26));
		LabelPrixE.setBounds(525, 180, 161, 55);
		panel.add(LabelPrixE);
		
		JLabel LabelTitreAvisE = new JLabel("Avis de l'agent");
		LabelTitreAvisE.setFont(new Font("Papyrus", Font.BOLD, 22));
		LabelTitreAvisE.setBounds(56, 275, 185, 43);
		panel.add(LabelTitreAvisE);
		
		JLabel LabelAvisE = new JLabel("PROCHE DU CENTRE VILLE DE LA GARDE ET DES COMMODITES BEL APPARTEMENT RENOVE SEJOUR DOUBLE ET 2 CHAMBRES BALCON - CLIMATISATION GRAND PARKING COLLECTIF RARE A LA LOCATION SUR CE SECTEUR Les informations sur les risques auxquels ce bien est exposé sont disponibles sur le site Géorisques : www.georisques.gouv.fr . Loyer mensuel 780 euros - Charges locatives 105 euros.");
		LabelAvisE.setAutoscrolls(true);
		LabelAvisE.setMinimumSize(new Dimension(400, 14));
		LabelAvisE.setMaximumSize(new Dimension(597, 14));
		LabelAvisE.setFont(new Font("Papyrus", Font.PLAIN, 14));
		LabelAvisE.setBounds(50, 329, 480, 82);
		panel.add(LabelAvisE);
		
		
		JLabel LabelBienImage = new JLabel("");
		LabelBienImage.setIcon(new ImageIcon(ShowBienAgence.class.getResource("/ressource/rsz_appart1.jpg")));
		LabelBienImage.setBounds(846, 59, 360, 270);
		panel.add(LabelBienImage);
		
		if (bien.getImages() == null) {
			
			LabelBienImage.setText("Pas d'image");
			
		}else {
			
			LabelBienImage.setIcon(new ImageIcon(ShowBienAchat.class.getResource("/ressource/"+bien.getImages())));
		}
		
		
		LabelAvisE.setText(bien.getTexte());
		 LabelPrixE.setText(bien.getPrix().toString()+ " €");
		 LabelSuperficieE.setText(bien.getSuperficie()+" m²");
		 LabelTitreE.setText(bien.getTitre());
		 LabelLocalisationE.setText(bien.getVille());
		 LabelNbrePiecesE.setText(bien.getNbPiece()+" pièces");
		 
		 JButton btnUpdate = new JButton("Actualiser");
		 btnUpdate.setFont(new Font("Papyrus", Font.PLAIN, 16));
		 btnUpdate.setBounds(870, 403, 148, 36);
		 panel.add(btnUpdate);
		 
		 JButton btnSupprimer = new JButton("Supprimer");
		 btnSupprimer.setForeground(Color.RED);
		 btnSupprimer.setFont(new Font("Papyrus", Font.BOLD, 16));
		 btnSupprimer.setBounds(1136, 403, 161, 36);
		 panel.add(btnSupprimer);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
