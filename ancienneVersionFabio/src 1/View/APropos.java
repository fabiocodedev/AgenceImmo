package View;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;

public class APropos extends JPanel {

	/**
	 * Create the panel.
	 */
	public APropos() {
		
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 1366, 492);
		setLayout(null);
		
		JPanel panelAPropos = new JPanel();
		panelAPropos.setBackground(new Color(0, 128, 128));
		panelAPropos.setBounds(0, 0, 1366, 492);
		add(panelAPropos);
		panelAPropos.setLayout(null);
		
		JLabel lblTitre = new JLabel("Presentation de l'agence et de l'equipe");
		lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitre.setFont(new Font("Papyrus", Font.BOLD, 30));
		lblTitre.setBounds(220, 64, 772, 42);
		panelAPropos.add(lblTitre);
		
		JLabel lblPhotoAgence = new JLabel("");
		lblPhotoAgence.setIcon(new ImageIcon(APropos.class.getResource("/ressource/rsz_agence.jpg")));
		lblPhotoAgence.setBounds(87, 202, 200, 180);
		panelAPropos.add(lblPhotoAgence);
		
		JLabel lblPhotoEquipe = new JLabel("");
		lblPhotoEquipe.setIcon(new ImageIcon(APropos.class.getResource("/ressource/rsz_equipe.jpg")));
		lblPhotoEquipe.setBounds(931, 202, 200, 180);
		panelAPropos.add(lblPhotoEquipe);
		
		JTextArea txtrAvec = new JTextArea();
		txtrAvec.setFont(new Font("Papyrus", Font.BOLD, 16));
		txtrAvec.setLineWrap(true);
		txtrAvec.setText("Depuis plus de 50 ans, Orpi est une coopérative qui appartient à ses membres. Chaque décision est prise par les associés, pour les associés, au service de la réussite du parcours immobilier de chaque client. Avec 1 350 points de vente et 8 000 collaborateurs, Orpi est aujourd’hui le réseau d’agences immobilières leader en France. Créée en 1966, la coopérative est également le plus ancien réseau immobilier de France. ");
		txtrAvec.setBounds(363, 202, 515, 180);
		panelAPropos.add(txtrAvec);
	}
}
