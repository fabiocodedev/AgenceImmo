package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import Controller.BienDao;
import Model.Bien;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EspaceEmploye extends JPanel {
	private static final long serialVersionUID = 1L;

	private JTable table;
	private JTextField textFieldPrix;
	private JTextField textFieldSuperficie;

	BienDao bienDao = new BienDao();
	ArrayList<Bien> Biens = bienDao.read();
	Bien bn = new Bien();

	Bien bienShow;
	/**
	 * Create the panel.
	 */
	public EspaceEmploye() {
		setLayout(null);
		setBounds(0, 0, 1366, 570);

		JPanel panelEspaceEmploye = new JPanel();
		panelEspaceEmploye.setBackground(new Color(0, 64, 128));
		panelEspaceEmploye.setBounds(0, 0, 1366, 570);
		add(panelEspaceEmploye);
		panelEspaceEmploye.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(2, 146, 700, 424);
		panelEspaceEmploye.add(scrollPane);


		table = new JTable();
		table.setForeground(new Color(0, 0, 0));
		table.setModel(listeBiens(Biens));

		scrollPane.add(table);
		table.setModel(listeBiens(Biens));
		table.setFont(new Font("Papyrus", Font.PLAIN, 20));
		table.setBackground(new Color(0, 128, 128));
		table.setBounds(0, 58, 1356, 545);
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
				System.err.println("++++++++++++++++++++");
			}
		});
		LabelFiltre.setHorizontalAlignment(SwingConstants.CENTER);
		LabelFiltre.setFont(new Font("Papyrus", Font.BOLD, 24));
		LabelFiltre.setBounds(0, 0, 88, 46);
		panelEspaceEmploye.add(LabelFiltre);

		JLabel lblVille = new JLabel("Ville :");
		lblVille.setFont(new Font("Papyrus", Font.PLAIN, 16));
		lblVille.setHorizontalAlignment(SwingConstants.CENTER);
		lblVille.setBounds(77, 0, 66, 44);
		panelEspaceEmploye.add(lblVille);


		ArrayList<String> villes = bienDao.getVille();
		villes.add(0, "*");
		String[] villeToCombo = villes.toArray(new String[villes.size()]);
		JComboBox comboBoxVille = new JComboBox(villeToCombo);
		comboBoxVille.setBounds(139, 11, 151, 26);
		panelEspaceEmploye.add(comboBoxVille);


		JLabel lblPrixMax = new JLabel("Prix Maximum :");
		lblPrixMax.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrixMax.setFont(new Font("Papyrus", Font.PLAIN, 16));
		lblPrixMax.setBounds(300, 0, 113, 46);
		panelEspaceEmploye.add(lblPrixMax);

		textFieldPrix = new JTextField();
		textFieldPrix.setText("500000");
		textFieldPrix.setBounds(439, 11, 149, 25);
		panelEspaceEmploye.add(textFieldPrix);
		textFieldPrix.setColumns(10);

		JComboBox comboBoxType = new JComboBox(new Object[]{});
		comboBoxType.setModel(new DefaultComboBoxModel(new String[] {"Maison", "Appartement"}));
		comboBoxType.setBounds(139, 48, 151, 26);
		panelEspaceEmploye.add(comboBoxType);

		JLabel lblType = new JLabel("Type :");
		lblType.setHorizontalAlignment(SwingConstants.CENTER);
		lblType.setFont(new Font("Papyrus", Font.PLAIN, 16));
		lblType.setBounds(77, 37, 66, 44);
		panelEspaceEmploye.add(lblType);

		JLabel lblNombreDePieces = new JLabel("Nombre de pieces :");
		lblNombreDePieces.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreDePieces.setFont(new Font("Papyrus", Font.PLAIN, 16));
		lblNombreDePieces.setBounds(2, 71, 141, 44);
		panelEspaceEmploye.add(lblNombreDePieces);

		JComboBox comboBoxPieces = new JComboBox(new Object[]{});
		comboBoxPieces.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6"}));
		comboBoxPieces.setBounds(139, 82, 151, 26);
		panelEspaceEmploye.add(comboBoxPieces);

		JLabel lblSuperficie = new JLabel("Superficie :");
		lblSuperficie.setHorizontalAlignment(SwingConstants.CENTER);
		lblSuperficie.setFont(new Font("Papyrus", Font.PLAIN, 16));
		lblSuperficie.setBounds(284, 39, 159, 33);
		panelEspaceEmploye.add(lblSuperficie);

		textFieldSuperficie = new JTextField();
		textFieldSuperficie.setText("100");
		textFieldSuperficie.setColumns(10);
		textFieldSuperficie.setBounds(439, 47, 149, 25);
		panelEspaceEmploye.add(textFieldSuperficie);

		JLabel lblCategorie = new JLabel("Categorie :");
		lblCategorie.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategorie.setFont(new Font("Papyrus", Font.PLAIN, 16));
		lblCategorie.setBounds(300, 71, 124, 44);
		panelEspaceEmploye.add(lblCategorie);

		JComboBox comboBoxCat = new JComboBox(new Object[]{});
		comboBoxCat.setModel(new DefaultComboBoxModel(new String[] {"Achat", "Location"}));
		comboBoxCat.setBounds(437, 82, 151, 26);
		panelEspaceEmploye.add(comboBoxCat);

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
				ArrayList<Bien> bienE = bienDao.filtreClientEmploye(villeSearch, prixSearch, typeSearch, NbPieceSearch, superficieSearch, catSearch);
				table.setModel(listeBiensEmploye(bienE));
				System.err.println("-------------------");
			}
		});
		btnSearch.setIcon(new ImageIcon(Accueil.class.getResource("/ressource/rsz_search.png")));
		btnSearch.setBounds(617, 36, 45, 45);
		panelEspaceEmploye.add(btnSearch);

		JPanel panelDFEmploye = new JPanel();
		panelDFEmploye.setBackground(new Color(128, 128, 64));
		panelDFEmploye.setBounds(701, 0, 670, 634);
		panelEspaceEmploye.add(panelDFEmploye);
		panelDFEmploye.setLayout(null);

		JLabel LabelTitreDFEmploye = new JLabel("Titre");
		LabelTitreDFEmploye.setFont(new Font("Papyrus", Font.PLAIN, 14));
		LabelTitreDFEmploye.setHorizontalAlignment(SwingConstants.CENTER);
		LabelTitreDFEmploye.setBounds(0, 0, 200, 40);
		panelDFEmploye.add(LabelTitreDFEmploye);

		JLabel LabelPrixDFEmploye = new JLabel("Prix");
		LabelPrixDFEmploye.setHorizontalAlignment(SwingConstants.CENTER);
		LabelPrixDFEmploye.setFont(new Font("Papyrus", Font.PLAIN, 14));
		LabelPrixDFEmploye.setBounds(533, 0, 89, 40);
		panelDFEmploye.add(LabelPrixDFEmploye);

		JLabel LabelVilleDFEmploye = new JLabel("Ville");
		LabelVilleDFEmploye.setIcon(new ImageIcon(EspaceClient.class.getResource("/ressource/rsz_map-location-location-icon.jpg")));
		LabelVilleDFEmploye.setHorizontalAlignment(SwingConstants.LEFT);
		LabelVilleDFEmploye.setFont(new Font("Papyrus", Font.PLAIN, 14));
		LabelVilleDFEmploye.setBounds(10, 390, 175, 63);
		panelDFEmploye.add(LabelVilleDFEmploye);

		JLabel LabelTypeDFEmploye = new JLabel("Type");
		LabelTypeDFEmploye.setHorizontalAlignment(SwingConstants.CENTER);
		LabelTypeDFEmploye.setFont(new Font("Papyrus", Font.PLAIN, 14));
		LabelTypeDFEmploye.setBounds(221, 0, 200, 40);
		panelDFEmploye.add(LabelTypeDFEmploye);

		JLabel LabelSuperficieDFEmploye = new JLabel("Superficie");
		LabelSuperficieDFEmploye.setHorizontalAlignment(SwingConstants.CENTER);
		LabelSuperficieDFEmploye.setFont(new Font("Papyrus", Font.PLAIN, 14));
		LabelSuperficieDFEmploye.setBounds(477, 401, 145, 40);
		panelDFEmploye.add(LabelSuperficieDFEmploye);

		JLabel LabelStatusDFEmploye = new JLabel("Status");
		LabelStatusDFEmploye.setHorizontalAlignment(SwingConstants.CENTER);
		LabelStatusDFEmploye.setFont(new Font("Papyrus", Font.PLAIN, 14));
		LabelStatusDFEmploye.setBounds(221, 401, 102, 40);
		panelDFEmploye.add(LabelStatusDFEmploye);

		JLabel LabelImagesDFEmploye = new JLabel("");
		LabelImagesDFEmploye.setIcon(new ImageIcon(EspaceClient.class.getResource("/ressource/"+Biens.get(0).getImages())));
		LabelImagesDFEmploye.setVerticalAlignment(SwingConstants.BOTTOM);
		LabelImagesDFEmploye.setHorizontalAlignment(SwingConstants.CENTER);
		LabelImagesDFEmploye.setBounds(42, 64, 580, 315);
		panelDFEmploye.add(LabelImagesDFEmploye);

		JButton btnActualiser = new JButton("Actualiser");
		btnActualiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelEspaceEmploye.removeAll();
				Update ub = new Update(bienShow);
				panelEspaceEmploye.add(ub);
				panelEspaceEmploye.repaint();
				panelEspaceEmploye.revalidate();


			}
		});
		btnActualiser.setBackground(new Color(128, 255, 255));
		btnActualiser.setFont(new Font("Papyrus", Font.BOLD | Font.ITALIC, 16));
		btnActualiser.setForeground(new Color(255, 0, 0));
		btnActualiser.setBounds(101, 513, 130, 38);
		panelDFEmploye.add(btnActualiser);

		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//LE CLIC SUR UNE LIGNE DU TABLEAU AVANT LE CLIC  SUPPRIMER
				System.out.println ("TEST BEFORE DELETE  ****** "+bienShow.getId());
				if(bienDao.delete(bienShow)) {
					System.out.println("TESTER DELETE OK ==================");
					JOptionPane.showMessageDialog(null, "Attention !!!, Le bien est supprimé  ! ", " Suppresionn Bien ",JOptionPane.ERROR_MESSAGE);
					//MAJ TABLEAU
					table.setModel(listeBiens(Biens));

				}
				else {
					System.out.println("Dans le else");
					JOptionPane.showMessageDialog(null, "OUPS, erreur DELETE ************************...");	
				}


			}
		});
		btnSupprimer.setForeground(Color.RED);
		btnSupprimer.setFont(new Font("Papyrus", Font.BOLD | Font.ITALIC, 16));
		btnSupprimer.setBackground(new Color(128, 255, 255));
		btnSupprimer.setBounds(470, 513, 130, 38);
		panelDFEmploye.add(btnSupprimer);

		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelEspaceEmploye.removeAll();
				AjoutBien ab = new AjoutBien();
				panelEspaceEmploye.add(ab);
				panelEspaceEmploye.repaint();
				panelEspaceEmploye.revalidate();
			}
		});
		btnAjouter.setForeground(Color.RED);
		btnAjouter.setFont(new Font("Papyrus", Font.BOLD | Font.ITALIC, 16));
		btnAjouter.setBackground(new Color(128, 255, 255));
		btnAjouter.setBounds(277, 513, 130, 38);
		panelDFEmploye.add(btnAjouter);
		
		JButton btnVoirMessages = new JButton("Voir les messages");
		btnVoirMessages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelEspaceEmploye.removeAll();
				EspaceMessage em = new EspaceMessage();
				panelEspaceEmploye.add(em);
				panelEspaceEmploye.repaint();
				panelEspaceEmploye.revalidate();
			}
			
			
		});
		
		btnVoirMessages.setBackground(new Color(64, 128, 128));
		btnVoirMessages.setBounds(12, 121, 159, 23);
		panelEspaceEmploye.add(btnVoirMessages);


		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				System.err.println(table.getSelectedRow());

				bienShow = bienDao.read().get(table.getSelectedRow());

				System.out.println("ID : "+bienShow.getId());

				LabelImagesDFEmploye.setIcon(new ImageIcon(Accueil.class.getResource("/ressource/"+bienShow.getImages())));
				LabelVilleDFEmploye.setText(bienShow.getVille());
				LabelTypeDFEmploye.setText(bienShow.getType());
				LabelPrixDFEmploye.setText("Prix: "+ bienShow.getPrix().toString()+" €");
				LabelTitreDFEmploye.setText(bienShow.getTitre());
				LabelSuperficieDFEmploye.setText("Superficie: "+String.valueOf(bienShow.getSuperficie())+" m²");
				LabelStatusDFEmploye.setText("A "+ bienShow.getStatus());
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
	public DefaultTableModel listeBiensEmploye(ArrayList<Bien> bienC) {
		String col[] = {"Titre", "Localisation", "Prix", "Image"};
		DefaultTableModel tableauE = new  DefaultTableModel(null, col);

		for (Bien  bienEmploye : bienC) {
			tableauE.addRow(new Object[] {
					bienEmploye.getTitre(),
					bienEmploye.getVille(),
					bienEmploye.getPrix(),
					bienEmploye.getImages(),
			});
		}
		System.out.println("tableauE crée");
		return tableauE;
	}
}
