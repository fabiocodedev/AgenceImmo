package View;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import Controller.BienDao;
import Model.Bien;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.DefaultComboBoxModel;

public class EspaceClient extends JPanel {
	
	BienDao bienDao = new BienDao();
	ArrayList<Bien> Biens = bienDao.read();
	Bien bn = new Bien();

	private static final long serialVersionUID = 1L;
	static JTable table;
	private JTextField textFieldPrix;
	private JTextField textFieldSuperficie;

	/**
	 * Create the panel.
	 */
	public EspaceClient() {
		setLayout(null);
		setBounds(0, 0, 1366, 765708);
		
		JPanel panelEspaceClient = new JPanel();
		panelEspaceClient.setBackground(new Color(255, 255, 255));
		panelEspaceClient.setBounds(0, 0, 1366, 570);
		add(panelEspaceClient);
		panelEspaceClient.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(2, 119, 696, 515);
		panelEspaceClient.add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(0, 0, 0));
		table.setModel(listeBiens(Biens));
		scrollPane.add(table);
		table.setModel(listeBiens(Biens));
		table.setFont(new Font("Papyrus", Font.PLAIN, 20));
		table.setBackground(new Color(0, 128, 128));
		table.setBounds(0, 58, 1356, 588);
		table.setRowHeight(100);
		scrollPane.add(table);
		scrollPane.setViewportView(table);
		
		TableColumn tableColumn = new TableColumn();
		tableColumn.setPreferredWidth(100);
		
		
		// FILTRE ----------------------------------------------------------
		JLabel LabelFiltre = new JLabel("Filtre ");
		LabelFiltre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table.setModel(listeBiens(Biens));
			}
		});
		LabelFiltre.setHorizontalAlignment(SwingConstants.CENTER);
		LabelFiltre.setFont(new Font("Papyrus", Font.BOLD, 24));
		LabelFiltre.setBounds(0, 0, 88, 46);
		panelEspaceClient.add(LabelFiltre);
				
		JLabel lblVille = new JLabel("Ville :");
		lblVille.setFont(new Font("Papyrus", Font.PLAIN, 16));
		lblVille.setHorizontalAlignment(SwingConstants.CENTER);
		lblVille.setBounds(77, 0, 66, 44);
		panelEspaceClient.add(lblVille);

				
		ArrayList<String> villes = bienDao.getVille();
		villes.add(0, "*");
		String[] villeToCombo = villes.toArray(new String[villes.size()]);
		JComboBox comboBoxVille = new JComboBox(villeToCombo);
		comboBoxVille.setBounds(139, 11, 151, 26);
		panelEspaceClient.add(comboBoxVille);
		
				
		JLabel lblPrixMax = new JLabel("Prix Maximum :");
		lblPrixMax.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrixMax.setFont(new Font("Papyrus", Font.PLAIN, 16));
		lblPrixMax.setBounds(300, 0, 113, 46);
		panelEspaceClient.add(lblPrixMax);
				
		textFieldPrix = new JTextField();
		textFieldPrix.setText("500000");
		textFieldPrix.setBounds(439, 11, 149, 25);
		panelEspaceClient.add(textFieldPrix);
		textFieldPrix.setColumns(10);
				
		JComboBox comboBoxType = new JComboBox(new Object[]{});
		comboBoxType.setModel(new DefaultComboBoxModel(new String[] {"Maison", "Appartement"}));
		comboBoxType.setBounds(139, 48, 151, 26);
		panelEspaceClient.add(comboBoxType);
		
		JLabel lblType = new JLabel("Type :");
		lblType.setHorizontalAlignment(SwingConstants.CENTER);
		lblType.setFont(new Font("Papyrus", Font.PLAIN, 16));
		lblType.setBounds(77, 37, 66, 44);
		panelEspaceClient.add(lblType);
		
		JLabel lblNombreDePieces = new JLabel("Nombre de pieces :");
		lblNombreDePieces.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreDePieces.setFont(new Font("Papyrus", Font.PLAIN, 16));
		lblNombreDePieces.setBounds(2, 71, 141, 44);
		panelEspaceClient.add(lblNombreDePieces);
		
		JComboBox comboBoxPieces = new JComboBox(new Object[]{});
		comboBoxPieces.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6"}));
		comboBoxPieces.setBounds(139, 82, 151, 26);
		panelEspaceClient.add(comboBoxPieces);
		
		JLabel lblSuperficie = new JLabel("Superficie :");
		lblSuperficie.setHorizontalAlignment(SwingConstants.CENTER);
		lblSuperficie.setFont(new Font("Papyrus", Font.PLAIN, 16));
		lblSuperficie.setBounds(284, 39, 159, 33);
		panelEspaceClient.add(lblSuperficie);
		
		textFieldSuperficie = new JTextField();
		textFieldSuperficie.setText("100");
		textFieldSuperficie.setColumns(10);
		textFieldSuperficie.setBounds(439, 47, 149, 25);
		panelEspaceClient.add(textFieldSuperficie);
		
		JLabel lblCategorie = new JLabel("Categorie :");
		lblCategorie.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategorie.setFont(new Font("Papyrus", Font.PLAIN, 16));
		lblCategorie.setBounds(300, 71, 124, 44);
		panelEspaceClient.add(lblCategorie);
		
		JComboBox comboBoxCat = new JComboBox(new Object[]{});
		comboBoxCat.setModel(new DefaultComboBoxModel(new String[] {"Achat", "Location"}));
		comboBoxCat.setBounds(437, 82, 151, 26);
		panelEspaceClient.add(comboBoxCat);
		
		// BOUTON FILTRE ----------------------------------------------------------------------------------
		JButton btnSearch = new JButton("");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String villeSearch = comboBoxVille.getSelectedItem().toString();
				Float prixSearch = Float.parseFloat(textFieldPrix.getText()) ;
				String typeSearch = comboBoxType.getSelectedItem().toString().toLowerCase();
				Float NbPieceSearch = Float.parseFloat(comboBoxPieces.getSelectedItem().toString());
				Integer superficieSearch = Integer.parseInt(textFieldSuperficie.getText().toString()) ;
				String catSearch = comboBoxCat.getSelectedItem().toString().toLowerCase();
				ArrayList<Bien> bienC = bienDao.filtreClientEmploye(villeSearch, prixSearch, typeSearch, NbPieceSearch, superficieSearch, catSearch);
				table.setModel(listeBiensClient(bienC));
			}
		});
		btnSearch.setIcon(new ImageIcon(Accueil.class.getResource("/ressource/rsz_search.png")));
		btnSearch.setBounds(617, 36, 45, 45);
		panelEspaceClient.add(btnSearch);
		
		// PANEL VISU BIEN --------------------------------------------------------------------------------
		JPanel panelDFClient = new JPanel();
		panelDFClient.setBackground(new Color(128, 128, 64));
		panelDFClient.setBounds(701, 0, 670, 634);
		panelEspaceClient.add(panelDFClient);
		panelDFClient.setLayout(null);
		
		JLabel LabelTitreDFClient = new JLabel("Titre");
		LabelTitreDFClient.setFont(new Font("Papyrus", Font.PLAIN, 14));
		LabelTitreDFClient.setHorizontalAlignment(SwingConstants.CENTER);
		LabelTitreDFClient.setBounds(0, 0, 200, 40);
		panelDFClient.add(LabelTitreDFClient);
		
		JLabel LabelPrixDFClient = new JLabel("Prix");
		LabelPrixDFClient.setHorizontalAlignment(SwingConstants.CENTER);
		LabelPrixDFClient.setFont(new Font("Papyrus", Font.PLAIN, 14));
		LabelPrixDFClient.setBounds(533, 0, 89, 40);
		panelDFClient.add(LabelPrixDFClient);
		
		JLabel LabelVilleDFClient = new JLabel("Ville");
		LabelVilleDFClient.setIcon(new ImageIcon(EspaceClient.class.getResource("/ressource/rsz_map-location-location-icon.jpg")));
		LabelVilleDFClient.setHorizontalAlignment(SwingConstants.LEFT);
		LabelVilleDFClient.setFont(new Font("Papyrus", Font.PLAIN, 14));
		LabelVilleDFClient.setBounds(10, 390, 175, 63);
		panelDFClient.add(LabelVilleDFClient);
		
		JLabel LabelTypeDFClient = new JLabel("Type");
		LabelTypeDFClient.setHorizontalAlignment(SwingConstants.CENTER);
		LabelTypeDFClient.setFont(new Font("Papyrus", Font.PLAIN, 14));
		LabelTypeDFClient.setBounds(221, 0, 200, 40);
		panelDFClient.add(LabelTypeDFClient);
		
		JLabel LabelSuperficieDFClient = new JLabel("Superficie");
		LabelSuperficieDFClient.setHorizontalAlignment(SwingConstants.CENTER);
		LabelSuperficieDFClient.setFont(new Font("Papyrus", Font.PLAIN, 14));
		LabelSuperficieDFClient.setBounds(477, 401, 145, 40);
		panelDFClient.add(LabelSuperficieDFClient);
		
		JLabel LabelStatusDFClient = new JLabel("Status");
		LabelStatusDFClient.setHorizontalAlignment(SwingConstants.CENTER);
		LabelStatusDFClient.setFont(new Font("Papyrus", Font.PLAIN, 14));
		LabelStatusDFClient.setBounds(221, 401, 102, 40);
		panelDFClient.add(LabelStatusDFClient);
		
		JLabel LabelImagesDFClient = new JLabel("");
		LabelImagesDFClient.setIcon(new ImageIcon(EspaceClient.class.getResource("/ressource/"+Biens.get(0).getImages())));
		
		LabelImagesDFClient.setVerticalAlignment(SwingConstants.BOTTOM);
		LabelImagesDFClient.setHorizontalAlignment(SwingConstants.CENTER);
		LabelImagesDFClient.setBounds(42, 64, 580, 315);
		panelDFClient.add(LabelImagesDFClient);
		
		JButton btnLouer = new JButton("Louer");
		btnLouer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelEspaceClient.removeAll();
				ShowBienLocation sbl = new ShowBienLocation(bn);
				panelEspaceClient.add(sbl);
				panelEspaceClient.repaint();
				panelEspaceClient.revalidate();
			}
		});
		btnLouer.setBackground(new Color(128, 255, 255));
		btnLouer.setFont(new Font("Papyrus", Font.BOLD | Font.ITALIC, 16));
		btnLouer.setForeground(new Color(255, 0, 0));
		btnLouer.setBounds(42, 525, 130, 38);
		panelDFClient.add(btnLouer);
		
		JButton btnAcheter = new JButton("Acheter");
		btnAcheter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelEspaceClient.removeAll();
				
				ShowBienAchat sba = new ShowBienAchat(bn);
				panelEspaceClient.add(sba);
				panelEspaceClient.repaint();
				panelEspaceClient.revalidate();
			}
		});
		btnAcheter.setForeground(Color.RED);
		btnAcheter.setFont(new Font("Papyrus", Font.BOLD | Font.ITALIC, 16));
		btnAcheter.setBackground(new Color(128, 255, 255));
		btnAcheter.setBounds(255, 525, 130, 38);
		panelDFClient.add(btnAcheter);
		
		JLabel LabelAvisAgence = new JLabel("Avis de l'agent :");
		LabelAvisAgence.setFont(new Font("Papyrus", Font.BOLD | Font.ITALIC, 16));
		LabelAvisAgence.setBounds(10, 464, 130, 27);
		panelDFClient.add(LabelAvisAgence);
		
		JPanel panelAvis = new JPanel();
		panelAvis.setBackground(new Color(0, 128, 128));
		panelAvis.setBorder(null);
		panelAvis.setBounds(139, 464, 454, 53);
		panelDFClient.add(panelAvis);
		panelAvis.setLayout(null);
		
		JTextPane textPaneAvis = new JTextPane();
		textPaneAvis.setBorder(null);
		textPaneAvis.setBackground(new Color(128, 128, 64));
		textPaneAvis.setFont(new Font("Papyrus", Font.PLAIN, 14));
		textPaneAvis.setBounds(0, 0, 454, 53);
		panelAvis.add(textPaneAvis);
		
		JButton Ecrire = new JButton("Message");
		Ecrire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelEspaceClient.removeAll();
				ContactForm cf = new ContactForm();
				panelEspaceClient.add(cf);
				panelEspaceClient.repaint();
				panelEspaceClient.revalidate();
			}
		});
		Ecrire.setForeground(Color.RED);
		Ecrire.setFont(new Font("Papyrus", Font.BOLD | Font.ITALIC, 16));
		Ecrire.setBackground(new Color(128, 255, 255));
		Ecrire.setBounds(477, 525, 130, 38);
		panelDFClient.add(Ecrire);
		
		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				System.err.println(table.getSelectedRow());
				
				Bien bienShow = bienDao.read().get(table.getSelectedRow());
				
				//panelBienDefaut.removeAll();
				//panelBienDefaut.add(ShowBien(bienShow));
				LabelImagesDFClient.setIcon(new ImageIcon(Accueil.class.getResource("/ressource/"+bienShow.getImages())));
				LabelVilleDFClient.setText(bienShow.getVille());
				LabelTypeDFClient.setText(bienShow.getType());
				LabelPrixDFClient.setText("Prix: "+bienShow.getPrix().toString()+" €");
				LabelTitreDFClient.setText(bienShow.getTitre());
				LabelSuperficieDFClient.setText("Superficie: "+String.valueOf(bienShow.getSuperficie())+" m²");
				
				
				LabelStatusDFClient.setText("A "+ bienShow.getStatus());
				textPaneAvis.setText(bienShow.getTexte());
				
				//String.valueOf(bien.getPrix())
				
			}
		});
	}
	// METHODE AJOUT LIGNE TABLEAU
	public DefaultTableModel listeBiens(ArrayList<Bien> biens) {
		String col[] = {"Titre", "Localisation", "Prix", "Image"};
		DefaultTableModel tableau = new  DefaultTableModel(null, col);
		
		for (Bien bien : Biens) {
			tableau.addRow(new Object[] {
					bien.getTitre(),
					bien.getVille(),
					bien.getPrix(),
					bien.getImages(),
			});
			System.out.println(bien.getImages());
		}
		System.out.println(tableau);
		return tableau;
	}
// METHODE AJOUT LIGNE TABLEAU POUR LE FILTRE CLIENT
		public DefaultTableModel listeBiensClient(ArrayList<Bien> bienC) {
			String col[] = {"Titre", "Localisation", "Prix", "Image"};
			DefaultTableModel tableauC = new  DefaultTableModel(null, col);
			
			for (Bien  bienClient : bienC) {
				tableauC.addRow(new Object[] {
						bienClient.getTitre(),
						bienClient.getVille(),
						bienClient.getPrix(),
						bienClient.getImages(),
				});
			}
			System.out.println("tableauC crée");
			return tableauC;
		}
}
