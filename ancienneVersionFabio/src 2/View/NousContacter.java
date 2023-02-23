package View;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class NousContacter extends JPanel {

	/**
	 * Create the panel.
	 */
	public NousContacter() {
		
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 1366, 570);
		setLayout(null);
		
		JPanel panelNousContacter = new JPanel();
		panelNousContacter.setBackground(new Color(0, 128, 128));
		panelNousContacter.setBounds(0, 0, 1366, 570);
		add(panelNousContacter);
		panelNousContacter.setLayout(null);
		
		JLabel lblAdresse = new JLabel("Notre Adresse : 6 8 Rue Georges et Mai Politzer, 75012 Paris");
		lblAdresse.setFont(new Font("Papyrus", Font.BOLD, 20));
		lblAdresse.setBounds(361, 75, 721, 42);
		panelNousContacter.add(lblAdresse);
		
		JLabel lblTel = new JLabel("Notre Telephone : 06 15 26 59 48");
		lblTel.setFont(new Font("Papyrus", Font.BOLD, 20));
		lblTel.setBounds(483, 179, 345, 42);
		panelNousContacter.add(lblTel);
		
		JTextField lblMail = new JTextField("Notre Email :   msa.camara@gmail.com");
		lblMail.setBackground(new Color(255, 0, 0));
		lblMail.setFont(new Font("Papyrus", Font.BOLD, 60));
		lblMail.setBounds(141, 265, 1122, 185);
		panelNousContacter.add(lblMail);
		
	}

}
