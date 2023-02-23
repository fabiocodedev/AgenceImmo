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

	private static final long serialVersionUID = 1L;

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
		panelHeader.setBounds(0, 0, 1352, 65);
		contentPane.add(panelHeader);
		panelHeader.setLayout(null);
		
		JPanel panelContainer = new JPanel();
		
		JLabel labelTitreBase = new JLabel("CDA  IMMOBILIER");
		
		labelTitreBase.setForeground(new Color(0, 128, 64));
		labelTitreBase.setFont(new Font("Papyrus", Font.BOLD | Font.ITALIC, 28));
		labelTitreBase.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitreBase.setBounds(209, 11, 397, 43);
		panelHeader.add(labelTitreBase);
		
		
		panelContainer.setBounds(0, 65, 1352, 570);
		contentPane.add(panelContainer);
		panelContainer.setLayout(null);
		
		//Afficher la liste
		panelContainer.removeAll();
		Accueil slb = new  Accueil();
		slb.setBounds(0, 0, 1352, 632);
		panelContainer.add(slb);
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
		btnInscriptConnect.setFont(new Font("Papyrus", Font.BOLD | Font.ITALIC, 16));
		btnInscriptConnect.setBounds(1085, 11, 234, 43);
		panelHeader.add(btnInscriptConnect);
		
		JButton btnHome = new JButton("");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelContainer.removeAll();
				Accueil slb = new Accueil();
				panelContainer.add(slb);
				panelContainer.repaint();
				panelContainer.revalidate();
			}
		});
		btnHome.setIcon(new ImageIcon(Main.class.getResource("/ressource/rsz_home (1).png")));
		btnHome.setBounds(32, 11, 50, 50);
		panelHeader.add(btnHome);
		

		JPanel panelFooter = new JPanel();
		panelFooter.setBackground(new Color(0, 64, 128));
		panelFooter.setBounds(0, 634, 1352, 66);
		contentPane.add(panelFooter);
		panelFooter.setLayout(null);
		
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
		labelPropos.setFont(new Font("Papyrus", Font.BOLD, 16));
		labelPropos.setBounds(602, 23, 137, 20);
		panelFooter.add(labelPropos);
		
		JLabel labelContact = new JLabel("Nous Contacter");
		labelContact.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelContainer.removeAll();
				NousContacter nc = new NousContacter();
				panelContainer.add(nc);
				panelContainer.repaint();
				panelContainer.revalidate();
			}
		});
		labelContact.setForeground(new Color(0, 128, 64));
		labelContact.setFont(new Font("Papyrus", Font.BOLD, 16));
		labelContact.setHorizontalAlignment(SwingConstants.CENTER);
		labelContact.setBounds(1148, 23, 168, 20);
		panelFooter.add(labelContact);
		
		JLabel labelCopyright = new JLabel("");
		labelCopyright.setBounds(75, 11, 50, 50);
		panelFooter.add(labelCopyright);

		labelCopyright.setIcon(new ImageIcon(Main.class.getResource("/ressource/rsz_copyright (1).png")));
		
		
		
		
		
		
	}
}
