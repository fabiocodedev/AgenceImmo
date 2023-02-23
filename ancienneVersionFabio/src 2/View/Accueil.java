package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import Controller.BienDao;
import Controller.ClientDao;
import Controller.EmployeDao;
import Controller.MatriculeDao;
import Controller.ProprietaireDao;
import Controller.UserDao;
import Model.Bien;
import Model.Client;
import Model.Employe;
import Model.Proprietaire;
import Model.User;

import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Accueil extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField textFieldPrix;
	private String villesCbx = null;

	private String villeSearch ;
	private Float prixSearch;

	UserDao userDao = new UserDao();
	MatriculeDao matriculeDao = new MatriculeDao();
	EmployeDao employeDao = new EmployeDao();
	ClientDao clientDao = new ClientDao();
	ProprietaireDao proprietaireDao = new ProprietaireDao();

	BienDao bienDao = new BienDao();
	ArrayList<Bien> Biens = bienDao.read();
	Bien bn = new Bien();
	/**
	 * Create the panel.
	 */
	public Accueil() {
		setLayout(null);
		setBounds(0, 0, 1366, 632);

		// PANEL ------------------------------------------------------
		JPanel panelShowlistBien = new JPanel();
		panelShowlistBien.setBounds(0, 0, 1366, 570);
		add(panelShowlistBien);
		panelShowlistBien.setLayout(null);

		// SCROLL ------------------------------------------------------
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 47, 704, 588);
		panelShowlistBien.add(scrollPane);

		// TABLEAU ------------------------------------------------------
		table = new JTable();
		table.setFont(new Font("Papyrus", Font.PLAIN, 20));
		table.setBackground(new Color(0, 128, 128));
		//Appel des elémement de la base données via la fonctions listeBiens
		table.setModel(listeBiens(Biens));
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
		LabelFiltre.setFont(new Font("Papyrus", Font.BOLD, 18));
		LabelFiltre.setBounds(144, 9, 69, 26);
		panelShowlistBien.add(LabelFiltre);

		JLabel lblVille = new JLabel("Ville :");
		lblVille.setFont(new Font("Papyrus", Font.PLAIN, 16));
		lblVille.setHorizontalAlignment(SwingConstants.CENTER);
		lblVille.setBounds(214, 2, 57, 44);
		panelShowlistBien.add(lblVille);


		ArrayList<String> villes = bienDao.getVille();
		villes.add(0, "*");
		String[] villeToCombo = villes.toArray(new String[villes.size()]);
		JComboBox comboBoxVille = new JComboBox(villeToCombo);
		comboBoxVille.setBounds(273, 9, 151, 26);
		panelShowlistBien.add(comboBoxVille);



		JLabel lblPrixMax = new JLabel("Prix Max:");
		lblPrixMax.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrixMax.setFont(new Font("Papyrus", Font.PLAIN, 16));
		lblPrixMax.setBounds(436, 1, 83, 46);
		panelShowlistBien.add(lblPrixMax);

		textFieldPrix = new JTextField();
		textFieldPrix.setText("500000");
		textFieldPrix.setBounds(515, 10, 134, 25);
		panelShowlistBien.add(textFieldPrix);
		textFieldPrix.setColumns(10);
		//		Float prixSearch = (float) 100000 ;

		JButton btnSearch = new JButton("");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String villeSearch = comboBoxVille.getSelectedItem().toString();
				Float prixSearch = Float.parseFloat(textFieldPrix.getText()) ;
				ArrayList<Bien> bienF = bienDao.filtreAccueil(villeSearch, prixSearch);
				table.setModel(listeBiensFiltre(bienF));
			}
		});
		btnSearch.setIcon(new ImageIcon(Accueil.class.getResource("/ressource/rsz_search.png")));
		btnSearch.setBounds(651, 6, 45, 35);
		panelShowlistBien.add(btnSearch);

		//AFFICHAGE BIEN -----------------------------------------------------------
		JPanel panelBienDefaut = new JPanel();
		panelBienDefaut.setBackground(new Color(128, 128, 64));
		panelBienDefaut.setBounds(708, 0, 670, 634);
		panelShowlistBien.add(panelBienDefaut);
		panelBienDefaut.setLayout(null);

		JLabel LabelTitreDF = new JLabel("Titre");
		LabelTitreDF.setHorizontalAlignment(SwingConstants.CENTER);
		LabelTitreDF.setFont(new Font("Papyrus", Font.BOLD, 40));
		LabelTitreDF.setBounds(32, 11, 599, 34);
		panelBienDefaut.add(LabelTitreDF);

		JLabel LabelLocalisationDF = new JLabel("Ville");
		LabelLocalisationDF.setHorizontalAlignment(SwingConstants.CENTER);
		LabelLocalisationDF.setFont(new Font("Papyrus", Font.PLAIN, 20));
		LabelLocalisationDF.setBounds(49, 443, 237, 27);
		panelBienDefaut.add(LabelLocalisationDF);

		JLabel LabelPrixDF = new JLabel("Prix");
		LabelPrixDF.setHorizontalAlignment(SwingConstants.CENTER);
		LabelPrixDF.setFont(new Font("Papyrus", Font.PLAIN, 30));
		LabelPrixDF.setBounds(346, 443, 226, 34);
		panelBienDefaut.add(LabelPrixDF);

		JLabel LabelImageDF = new JLabel("");
		LabelImageDF.setBounds(21, 64, 580, 315);
		panelBienDefaut.add(LabelImageDF);

		//SET LES LABELS
		LabelTitreDF.setText(Biens.get(0).getTitre());
		LabelLocalisationDF.setText(Biens.get(0).getVille());
		LabelPrixDF.setText(Biens.get(0).getPrix().toString());
		LabelImageDF.setIcon(new ImageIcon(Accueil.class.getResource("/ressource/"+Biens.get(0).getImages())));
		//BOUTON -----------------------------------------------------------------
		JButton btnDetails = new JButton("Voir détails");
		btnDetails.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				if(InscriptionConnexion.currentUser == null) {

					JOptionPane.showMessageDialog(null,"Connectez-vous ou créer un compte pour accèder à plus d'informations sur les biens de cette agence" ," Connexion requise",  JOptionPane.WARNING_MESSAGE);

					panelShowlistBien.removeAll();
					InscriptionConnexion ic = new InscriptionConnexion();
					panelShowlistBien.add(ic);
					panelShowlistBien.repaint();
					panelShowlistBien.revalidate();
				} 
			}
		});
		btnDetails.setForeground(new Color(255, 128, 0));
		btnDetails.setFont(new Font("Papyrus", Font.PLAIN, 18));
		btnDetails.setBounds(235, 511, 177, 37);
		panelBienDefaut.add(btnDetails);

		JButton btnEspace = new JButton("Mon Espace");
		btnEspace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(InscriptionConnexion.currentUser == null) {
					JOptionPane.showMessageDialog(null,"Connectez-vous ou créer un compte pour accèder à plus d'informations sur les biens de cette agence" ," Connexion requise",  JOptionPane.WARNING_MESSAGE);

					panelShowlistBien.removeAll();
					InscriptionConnexion ic = new InscriptionConnexion();
					panelShowlistBien.add(ic);
					panelShowlistBien.repaint();
					
					panelShowlistBien.revalidate();

				}
				else if (clientDao.isExistClient(InscriptionConnexion.currentUser.getEmail()) != null) {
					panelShowlistBien.removeAll();
					EspaceClient ec = new EspaceClient();
					panelShowlistBien.add(ec);
					panelShowlistBien.repaint();
					panelShowlistBien.revalidate();
				
				}
				else if (employeDao.isExistEmploye(InscriptionConnexion.currentUser.getEmail())!= null) {
					panelShowlistBien.removeAll();
					EspaceEmploye ee = new EspaceEmploye();
					panelShowlistBien.add(ee);
					panelShowlistBien.repaint();
					panelShowlistBien.revalidate();
					
				}
				else if (proprietaireDao.isExistProprio(InscriptionConnexion.currentUser.getEmail())!= null) {
					panelShowlistBien.removeAll();
					EspaceProprietaire ep = new EspaceProprietaire();
					panelShowlistBien.add(ep);
					panelShowlistBien.repaint();
					panelShowlistBien.revalidate();
				}
				else {
					//Redirection vers la page d'accueil
					System.out.println(InscriptionConnexion.currentUser.getEmail());
					panelShowlistBien.removeAll();
					Accueil ac = new Accueil();
					panelShowlistBien.add(ac);
					panelShowlistBien.repaint();
					panelShowlistBien.revalidate();
				}
			}
		});
		
		if(InscriptionConnexion.currentUser != null) {
			btnDetails.setVisible(false);
			//AbstractButton btnInscriptConnect = null;
			//btnInscriptConnect.setText("Vous êtes "+InscriptionConnexion.currentUser.getPrenom()+" "+InscriptionConnexion.currentUser.getNom());
			System.out.println("========= "+InscriptionConnexion.currentUser.getPrenom());
			
			
		}
		btnEspace.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnEspace.setBackground(new Color(130, 254, 235));
		btnEspace.setBounds(6, 8, 117, 29);
		panelShowlistBien.add(btnEspace);


		//CLIC SUR LIGNE DU TABLEAU 
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				System.err.println(table.getSelectedRow());

				Bien bienShow = Biens.get(table.getSelectedRow());

				//panelBienDefaut.removeAll();
				//panelBienDefaut.add(ShowBien(bienShow));
				LabelImageDF.setIcon(new ImageIcon(Accueil.class.getResource("/ressource/"+bienShow.getImages())));
				LabelLocalisationDF.setText(bienShow.getVille());
				LabelPrixDF.setText(bienShow.getPrix().toString());
				LabelTitreDF.setText(bienShow.getTitre().toString());

				System.out.println(bienShow.getTitre());
				//String.valueOf(bien.getPrix())
			}
		});

	} //   FIN METHODE ShowListBien

	// METHODE AJOUT LIGNE TABLEAU POUR CHAQUE BIENS
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
		}
		System.out.println(tableau);
		return tableau;
	}
	// METHODE AJOUT LIGNE TABLEAU POUR LE FILTRE
	public DefaultTableModel listeBiensFiltre(ArrayList<Bien> bienF) {
		String col[] = {"Titre", "Localisation", "Prix", "Image"};
		DefaultTableModel tableauF = new  DefaultTableModel(null, col);

		for (Bien  bienfiltre : bienF) {
			tableauF.addRow(new Object[] {
					bienfiltre.getTitre(),
					bienfiltre.getVille(),
					bienfiltre.getPrix(),
					bienfiltre.getImages(),
			});
		}
		System.out.println("tableauF crée");
		return tableauF;
	}
}
