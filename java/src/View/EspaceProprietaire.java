package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import Controller.BienDao;
import Model.Bien;
import Model.Proprietaire;
import Model.User;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class EspaceProprietaire extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	
	BienDao bienDao = new BienDao();
	ArrayList<Bien> Biens = bienDao.read();
	

	/**
	 * Create the panel.
	 */
	public EspaceProprietaire() {
		setLayout(null);
		setBounds(0, 0, 1366, 570);
		
		// PANEL ------------------------------------------------------
		JPanel panelEspaceProprietaire = new JPanel();
		panelEspaceProprietaire.setBounds(0, 0, 1366, 570);
		add(panelEspaceProprietaire);
		panelEspaceProprietaire.setLayout(null);
		
		// SCROLL ------------------------------------------------------
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 47, 550, 588);
		panelEspaceProprietaire.add(scrollPane);
		
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
		
		//AFFICHAGE BIEN -----------------------------------------------------------
				JPanel panelBienDefaut = new JPanel();
				panelBienDefaut.setBackground(new Color(128, 128, 64));
				panelBienDefaut.setBounds(560, 0, 818, 570);
				panelEspaceProprietaire.add(panelBienDefaut);
				panelBienDefaut.setLayout(null);
				
				JLabel LabelTitreDF = new JLabel("Titre");
				LabelTitreDF.setHorizontalAlignment(SwingConstants.CENTER);
				LabelTitreDF.setFont(new Font("Papyrus", Font.BOLD, 40));
				LabelTitreDF.setBounds(127, 6, 599, 34);
				panelBienDefaut.add(LabelTitreDF);
				
				JLabel LabelLocalisationDF = new JLabel("Ville");
				LabelLocalisationDF.setHorizontalAlignment(SwingConstants.LEFT);
				LabelLocalisationDF.setFont(new Font("Papyrus", Font.PLAIN, 20));
				LabelLocalisationDF.setBounds(84, 369, 237, 27);
				panelBienDefaut.add(LabelLocalisationDF);
				
				JLabel LabelPrixDF = new JLabel("Prix");
				LabelPrixDF.setHorizontalAlignment(SwingConstants.LEFT);
				LabelPrixDF.setFont(new Font("Papyrus", Font.PLAIN, 20));
				LabelPrixDF.setBounds(538, 369, 226, 27);
				panelBienDefaut.add(LabelPrixDF);
				
				JLabel LabelImageDF = new JLabel("");
				LabelImageDF.setBounds(116, 42, 580, 315);
				panelBienDefaut.add(LabelImageDF);
				
				
				JLabel LabelCategorie = new JLabel("Categorie :");
				LabelCategorie.setHorizontalAlignment(SwingConstants.LEFT);
				LabelCategorie.setFont(new Font("Papyrus", Font.PLAIN, 20));
				LabelCategorie.setBounds(84, 408, 237, 27);
				panelBienDefaut.add(LabelCategorie);
				
				JLabel LabelType = new JLabel("Type :");
				LabelType.setHorizontalAlignment(SwingConstants.LEFT);
				LabelType.setFont(new Font("Papyrus", Font.PLAIN, 20));
				LabelType.setBounds(84, 447, 237, 27);
				panelBienDefaut.add(LabelType);
				
				JLabel LabelSuperficie = new JLabel("Superficie :");
				LabelSuperficie.setHorizontalAlignment(SwingConstants.LEFT);
				LabelSuperficie.setFont(new Font("Papyrus", Font.PLAIN, 20));
				LabelSuperficie.setBounds(538, 481, 237, 27);
				panelBienDefaut.add(LabelSuperficie);
				
				JLabel LabelNBPiece = new JLabel("Nombre de pieces : ");
				LabelNBPiece.setHorizontalAlignment(SwingConstants.LEFT);
				LabelNBPiece.setFont(new Font("Papyrus", Font.PLAIN, 20));
				LabelNBPiece.setBounds(538, 408, 226, 27);
				panelBienDefaut.add(LabelNBPiece);
				
				JLabel LabelStatus = new JLabel("Status : ");
				LabelStatus.setHorizontalAlignment(SwingConstants.LEFT);
				LabelStatus.setFont(new Font("Papyrus", Font.PLAIN, 20));
				LabelStatus.setBounds(538, 447, 226, 27);
				panelBienDefaut.add(LabelStatus);
				
				JTextPane txtpnAvisDeLagent = new JTextPane();
				txtpnAvisDeLagent.setText("Avis de l'agent :");
				txtpnAvisDeLagent.setFont(new Font("Papyrus", Font.PLAIN, 20));
				txtpnAvisDeLagent.setBounds(94, 486, 432, 77);
				txtpnAvisDeLagent.setBackground(new Color(128, 128, 64));
				panelBienDefaut.add(txtpnAvisDeLagent);
				
				//SET LES LABELS PAR DEFAUT
				LabelTitreDF.setText(Biens.get(0).getTitre());
				LabelLocalisationDF.setText("Ville :" + Biens.get(0).getVille());
				LabelPrixDF.setText("Prix : " + Biens.get(0).getPrix().toString());
				LabelImageDF.setIcon(new ImageIcon(Accueil.class.getResource("/ressource/"+Biens.get(0).getImages())));
				LabelCategorie.setText("Categorie : " + Biens.get(0).getCategorie().toString());
				LabelType.setText("Type : " + Biens.get(0).getType().toString());
				LabelSuperficie.setText("Superficie : " + Biens.get(0).getSuperficie());
				LabelNBPiece.setText("Nombre de pieces : " + Biens.get(0).getNbPiece());
				LabelStatus.setText("Status : " + Biens.get(0).getStatus().toString());
				txtpnAvisDeLagent.setText("Avis de l'agent : " + Biens.get(0).getTexte().toString());
				
				//BOUTON MES BIENS -----------------------------------------------------------------
				JButton btnMesBiens = new JButton("Voir mes biens");
				btnMesBiens.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						BienDao bienDao = new BienDao();
						User proprio = InscriptionConnexion.currentUser ;
						ArrayList<Bien> bienP = bienDao.voirMesBiens(proprio);
						table.setModel(listeBiensProprio(bienP));
					}
				});
				btnMesBiens.setFont(new Font("Papyrus", Font.BOLD, 16));
				btnMesBiens.setBounds(332, 4, 181, 40);
				panelEspaceProprietaire.add(btnMesBiens);
				
				//BOUTON TOUS LES BIENS -----------------------------------------------------------------
				JButton btnTousBiens = new JButton("Voir tous les biens");
				btnTousBiens.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						table.setModel(listeBiens(Biens));
					}
				});
				btnTousBiens.setFont(new Font("Papyrus", Font.BOLD, 16));
				btnTousBiens.setBounds(31, 4, 181, 40);
				panelEspaceProprietaire.add(btnTousBiens);
				
				//CLIC SUR LIGNE DU TABLEAU 
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						System.err.println(table.getSelectedRow());
						Bien bienShow = bienDao.read().get(table.getSelectedRow());
						
						//panelBienDefaut.removeAll();
						//panelBienDefaut.add(ShowBien(bienShow));
						LabelImageDF.setIcon(new ImageIcon(Accueil.class.getResource("/ressource/"+bienShow.getImages())));
						LabelLocalisationDF.setText("Ville :" + bienShow.getVille());
						LabelPrixDF.setText("Prix : " + bienShow.getPrix().toString());
						LabelTitreDF.setText(bienShow.getTitre().toString());
						LabelCategorie.setText("Categorie : " + bienShow.getCategorie().toString());
						LabelType.setText("Type : " + bienShow.getType().toString());
						LabelSuperficie.setText("Superficie : " + bienShow.getSuperficie());
						LabelNBPiece.setText("Nombre de pieces : " + bienShow.getNbPiece());
						LabelStatus.setText("Status : " + bienShow.getStatus().toString());
						txtpnAvisDeLagent.setText("Avis de l'agent : " + bienShow.getTexte().toString());
						
						System.out.println(bienShow.getTitre());
					}
				});
	}
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
		
		// METHODE AJOUT LIGNE TABLEAU UNIQUEMENT POUR LES BIENS D UN PROPRIO
		public DefaultTableModel listeBiensProprio(ArrayList<Bien> bienP) {
			String col[] = {"Titre", "Localisation", "Prix", "Image"};
			DefaultTableModel tableauP = new  DefaultTableModel(null, col);
			
			for (Bien  bienProprio : Biens) {
				tableauP.addRow(new Object[] {
						bienProprio.getTitre(),
						bienProprio.getVille(),
						bienProprio.getPrix(),
						bienProprio.getImages(),
				});
			}
			System.out.println("tableauP crée");
			return tableauP;
		}
}
