package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class ContactForm extends JPanel {
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JTextField textFieldMail;

	/**
	 * Create the panel.
	 */
	public ContactForm() {
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 1366, 570);
		setLayout(null);
		
		JPanel panelContact = new JPanel();
		panelContact.setBackground(new Color(0, 128, 128));
		panelContact.setBounds(0, 0, 1366, 570);
		add(panelContact);
		panelContact.setLayout(null);
		
		JLabel lblNom = new JLabel("Nom : ");
		lblNom.setHorizontalAlignment(SwingConstants.CENTER);
		lblNom.setFont(new Font("Papyrus", Font.BOLD, 16));
		lblNom.setBounds(222, 40, 112, 26);
		panelContact.add(lblNom);
		
		textFieldNom = new JTextField();
		textFieldNom.setFont(new Font("Papyrus", Font.BOLD, 14));
		textFieldNom.setBounds(344, 43, 156, 20);
		panelContact.add(textFieldNom);
		textFieldNom.setColumns(10);
		
		JLabel lblPrenom = new JLabel("Prenom : ");
		lblPrenom.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrenom.setFont(new Font("Papyrus", Font.BOLD, 16));
		lblPrenom.setBounds(570, 40, 112, 26);
		panelContact.add(lblPrenom);
		
		textFieldPrenom = new JTextField();
		textFieldPrenom.setFont(new Font("Papyrus", Font.BOLD, 14));
		textFieldPrenom.setColumns(10);
		textFieldPrenom.setBounds(692, 43, 156, 20);
		panelContact.add(textFieldPrenom);
		
		JLabel lblMail = new JLabel("Email : ");
		lblMail.setHorizontalAlignment(SwingConstants.CENTER);
		lblMail.setFont(new Font("Papyrus", Font.BOLD, 16));
		lblMail.setBounds(872, 40, 112, 26);
		panelContact.add(lblMail);
		
		textFieldMail = new JTextField();
		textFieldMail.setFont(new Font("Papyrus", Font.BOLD, 14));
		textFieldMail.setColumns(10);
		textFieldMail.setBounds(994, 43, 156, 20);
		panelContact.add(textFieldMail);
		
		JButton btnEnvoyer = new JButton("ENVOYER");
		btnEnvoyer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnEnvoyer.setForeground(Color.RED);
		btnEnvoyer.setFont(new Font("Papyrus", Font.BOLD, 12));
		btnEnvoyer.setBounds(543, 503, 119, 37);
		panelContact.add(btnEnvoyer);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(241, 180, 792, 243);
		panelContact.add(textPane);
		
		JButton btnRetour = new JButton("RETOUR");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelContact.removeAll();
				EspaceClient ec = new EspaceClient();
				panelContact.add(ec);
				panelContact.repaint();
				panelContact.revalidate();
			}
		});
		btnRetour.setForeground(new Color(255, 0, 0));
		btnRetour.setFont(new Font("Papyrus", Font.BOLD, 12));
		btnRetour.setBounds(25, 29, 112, 37);
		panelContact.add(btnRetour);
		
		JLabel lblMsg = new JLabel("Message : ");
		lblMsg.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsg.setFont(new Font("Papyrus", Font.BOLD, 16));
		lblMsg.setBounds(94, 180, 112, 26);
		panelContact.add(lblMsg);
	}
}