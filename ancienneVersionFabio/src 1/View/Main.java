package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelHeader = new JPanel();
		panelHeader.setBackground(new Color(0, 64, 128));
		panelHeader.setBounds(0, 0, 1366, 91);
		contentPane.add(panelHeader);
		panelHeader.setLayout(null);
		
		JLabel labelTitreBase = new JLabel("CDA  IMMOBILIER");
		labelTitreBase.setForeground(new Color(0, 128, 64));
		labelTitreBase.setFont(new Font("Papyrus", Font.BOLD | Font.ITALIC, 28));
		labelTitreBase.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitreBase.setBounds(303, 10, 383, 69);
		panelHeader.add(labelTitreBase);
		
		JPanel panelContainer = new JPanel();
		panelContainer.setBounds(0, 91, 1366, 492);
		contentPane.add(panelContainer);
		panelContainer.setLayout(null);
		
		//Afficher la page d'accueil
		panelContainer.removeAll();
		Accueil ac = new Accueil();
		panelContainer.add(ac);
		panelContainer.repaint();
		panelContainer.revalidate();
		
		JButton btnInscriptConnect = new JButton("Connection / Inscription");
		btnInscriptConnect.setForeground(new Color(128, 64, 0));
		btnInscriptConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("OK BOUTTON");
				panelContainer.removeAll();
				InscriptionConnexion inscriptionConnexion = new InscriptionConnexion();
				panelContainer.add(inscriptionConnexion);
				panelContainer.repaint();
				panelContainer.revalidate();
			}
		});
		btnInscriptConnect.setBackground(new Color(0, 128, 128));
		btnInscriptConnect.setFont(new Font("Papyrus", Font.BOLD | Font.ITALIC, 20));
		btnInscriptConnect.setBounds(951, 19, 279, 57);
		panelHeader.add(btnInscriptConnect);
		
		JButton btnNewButton = new JButton("BIEN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelContainer.removeAll();
				EspaceEmploye espEmp = new EspaceEmploye();
				panelContainer.add(espEmp);
				panelContainer.repaint();
				panelContainer.revalidate();
			}
		});
		btnNewButton.setBounds(821, 38, 89, 23);
		panelHeader.add(btnNewButton);
		
		JButton btnHome = new JButton("");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelContainer.removeAll();
				Accueil ac = new Accueil();
				panelContainer.add(ac);
				panelContainer.repaint();
				panelContainer.revalidate();
			}
		});
		btnHome.setIcon(new ImageIcon(Main.class.getResource("/ressource/rsz_home1.png")));
		btnHome.setBounds(29, 24, 55, 45);
		panelHeader.add(btnHome);
		
		
		JPanel panelFooter = new JPanel();
		panelFooter.setBackground(new Color(0, 64, 128));
		panelFooter.setBounds(0, 582, 1366, 68);
		contentPane.add(panelFooter);
		panelFooter.setLayout(null);
		
		JLabel labelCopyright = new JLabel("");
		labelCopyright.setIcon(new ImageIcon(Main.class.getResource("/ressource/Copyright.png")));
		labelCopyright.setBounds(92, 0, 70, 70);
		panelFooter.add(labelCopyright);
		
		JLabel labelPropos = new JLabel("A  Propos");
		labelPropos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelContainer.removeAll();
				APropos ap = new APropos();
				panelContainer.add(ap);
				panelContainer.repaint();
				panelContainer.revalidate();
			}
		});
		labelPropos.setForeground(new Color(0, 128, 64));
		labelPropos.setHorizontalAlignment(SwingConstants.CENTER);
		labelPropos.setFont(new Font("Papyrus", Font.BOLD, 20));
		labelPropos.setBounds(464, 13, 137, 42);
		panelFooter.add(labelPropos);
		
		JLabel labelContact = new JLabel("Nous Contacter");
		labelContact.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelContainer.removeAll();
				ContactForm cf = new ContactForm();
				panelContainer.add(cf);
				panelContainer.repaint();
				panelContainer.revalidate();
			}
		});
		labelContact.setForeground(new Color(0, 128, 64));
		labelContact.setFont(new Font("Papyrus", Font.BOLD, 20));
		labelContact.setHorizontalAlignment(SwingConstants.CENTER);
		labelContact.setBounds(912, 13, 168, 42);
		panelFooter.add(labelContact);
		
	}
}
