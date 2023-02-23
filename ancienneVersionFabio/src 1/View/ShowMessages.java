package View;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;

public class ShowMessages extends JPanel {

	/**
	 * Create the panel.
	 */
	public ShowMessages() {
		
		
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 1318, 401);
		setLayout(null);
		
		JPanel panelShowMessages = new JPanel();
		panelShowMessages.setBackground(new Color(0, 128, 128));
		panelShowMessages.setBounds(0, 0, 1318, 401);
		add(panelShowMessages);
		panelShowMessages.setLayout(null);
		
		JLabel lblTitre = new JLabel("MESSAGES");
		lblTitre.setBounds(120, 11, 972, 52);
		lblTitre.setFont(new Font("Papyrus", Font.BOLD, 26));
		lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
		panelShowMessages.add(lblTitre);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(67, 74, 1141, 297);
		panelShowMessages.add(scrollPane);
		

	}
}
