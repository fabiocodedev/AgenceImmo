package View;

import java.awt.Color;

import javax.swing.JPanel;

public class ContactForm extends JPanel {

	/**
	 * Create the panel.
	 */
	public ContactForm() {
		
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 1366, 492);
		setLayout(null);
		
		JPanel panelContactForm = new JPanel();
		panelContactForm.setBackground(new Color(0, 128, 128));
		panelContactForm.setBounds(0, 0, 1366, 492);
		add(panelContactForm);
		panelContactForm.setLayout(null);
	}

}
