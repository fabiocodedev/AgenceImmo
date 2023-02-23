package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Controller.BienDao;
import Controller.ProprietaireDao;
import Model.Bien;
import Model.Proprietaire;

public class Update extends JPanel {

	private JTextField fieldTitreU;
	private JTextField fieldVilleU;
	private JTextField fieldPrixU;
	private JTextField fieldNbPieceU;
	private JTextField fieldSuperficieU;
	private JTextField fieldIMGU;
	private JTextField fieldProprietaireU;
	BienDao bienDao = new BienDao();
	ArrayList<Bien> Biens = bienDao.read();


	String cbxTypeU = "";
	String cbxCatU = "";
	String cbxStatusU = "";

	/**
	 * Create the panel.
	 */
	public Update(Bien bienShow) {
		System.out.println(bienShow.getId());
		System.out.println(bienShow.getTitre());

		setLayout(null);
		setBounds(0, 0, 1366, 570);

		JPanel panelUpdate = new JPanel();
		panelUpdate.setBounds(0, 0, 1366, 570);
		add(panelUpdate);
		panelUpdate.setLayout(null);

		panelUpdate.setName("nom");
		panelUpdate.setBackground(new Color(0, 128, 128));

		panelUpdate.setLayout(null);

		JLabel labelTitreU = new JLabel("Titre");
		labelTitreU.setFont(new Font("Papyrus", Font.PLAIN, 14));
		labelTitreU.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitreU.setBounds(47, 150, 104, 23);
		panelUpdate.add(labelTitreU);

		fieldTitreU = new JTextField();
		fieldTitreU.setBounds(198, 151, 332, 20);
		panelUpdate.add(fieldTitreU);
		fieldTitreU.setColumns(10);

		JLabel labelTypeU = new JLabel("Type");
		labelTypeU.setHorizontalAlignment(SwingConstants.CENTER);
		labelTypeU.setFont(new Font("Papyrus", Font.PLAIN, 14));
		labelTypeU.setBounds(35, 212, 104, 23);
		panelUpdate.add(labelTypeU);

		JCheckBox chckbxAchatU = new JCheckBox("ACHAT");
		chckbxAchatU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbxTypeU = "achat";
				System.out.println(chckbxAchatU.getText());
			}
		});
		chckbxAchatU.setFont(new Font("Papyrus", Font.BOLD, 11));
		chckbxAchatU.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxAchatU.setBounds(196, 213, 104, 23);
		panelUpdate.add(chckbxAchatU);

		JCheckBox chckbxLocU = new JCheckBox("LOCATION");
		chckbxLocU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbxTypeU = "location";
				System.out.println(chckbxLocU.getText());
			}
		});
		chckbxLocU.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxLocU.setFont(new Font("Papyrus", Font.BOLD, 11));
		chckbxLocU.setBounds(362, 213, 168, 23);
		panelUpdate.add(chckbxLocU);

		//Crer un group de CheckBox
		ButtonGroup bgAchatLocU = new ButtonGroup();
		//ajouter les boutons radio au groupe
		bgAchatLocU.add(chckbxAchatU);
		bgAchatLocU.add(chckbxLocU);

		JLabel labelCategorieU = new JLabel("Categorie");
		labelCategorieU.setHorizontalAlignment(SwingConstants.CENTER);
		labelCategorieU.setFont(new Font("Papyrus", Font.PLAIN, 14));
		labelCategorieU.setBounds(47, 278, 104, 23);
		panelUpdate.add(labelCategorieU);

		JCheckBox chckbxMaisonU = new JCheckBox("MAISON");
		chckbxMaisonU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbxCatU = "maison";
				System.out.println(chckbxMaisonU.getText());
			}
		});
		chckbxMaisonU.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxMaisonU.setFont(new Font("Papyrus", Font.BOLD, 11));
		chckbxMaisonU.setBounds(197, 268, 114, 23);
		panelUpdate.add(chckbxMaisonU);

		JCheckBox chckbxAppartU = new JCheckBox("APPARTEMENT");
		chckbxAppartU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbxCatU = "appartement";
				System.out.println(chckbxAppartU.getText());
			}
		});
		chckbxAppartU.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxAppartU.setFont(new Font("Papyrus", Font.BOLD, 11));
		chckbxAppartU.setBounds(362, 268, 168, 23);
		panelUpdate.add(chckbxAppartU);

		//Crer un group de CheckBox
		ButtonGroup bgMaisonAppartU = new ButtonGroup();
		//ajouter les boutons radio au groupe
		bgMaisonAppartU.add(chckbxMaisonU);
		bgMaisonAppartU.add(chckbxAppartU);

		JLabel labelVilleU = new JLabel("Ville");
		labelVilleU.setHorizontalAlignment(SwingConstants.CENTER);
		labelVilleU.setFont(new Font("Papyrus", Font.PLAIN, 14));
		labelVilleU.setBounds(35, 351, 104, 23);
		panelUpdate.add(labelVilleU);

		fieldVilleU = new JTextField();
		fieldVilleU.setColumns(10);
		fieldVilleU.setBounds(197, 338, 332, 20);
		panelUpdate.add(fieldVilleU);

		JLabel labelPrixU = new JLabel("Prix");
		labelPrixU.setHorizontalAlignment(SwingConstants.CENTER);
		labelPrixU.setFont(new Font("Papyrus", Font.PLAIN, 14));
		labelPrixU.setBounds(35, 413, 104, 23);
		panelUpdate.add(labelPrixU);

		fieldPrixU = new JTextField();
		fieldPrixU.setColumns(10);
		fieldPrixU.setBounds(197, 414, 332, 20);
		panelUpdate.add(fieldPrixU);

		JLabel labelNbPieceU = new JLabel("Nombre de Pieces");
		labelNbPieceU.setHorizontalAlignment(SwingConstants.CENTER);
		labelNbPieceU.setFont(new Font("Papyrus", Font.PLAIN, 14));
		labelNbPieceU.setBounds(36, 483, 129, 23);
		panelUpdate.add(labelNbPieceU);

		fieldNbPieceU = new JTextField();
		fieldNbPieceU.setColumns(10);
		fieldNbPieceU.setBounds(197, 484, 332, 20);
		panelUpdate.add(fieldNbPieceU);

		fieldSuperficieU = new JTextField();
		fieldSuperficieU.setColumns(10);
		fieldSuperficieU.setBounds(197, 537, 332, 20);
		panelUpdate.add(fieldSuperficieU);

		JLabel labelSuperficieU = new JLabel("Superficie");
		labelSuperficieU.setHorizontalAlignment(SwingConstants.CENTER);
		labelSuperficieU.setFont(new Font("Papyrus", Font.PLAIN, 14));
		labelSuperficieU.setBounds(36, 536, 129, 23);
		panelUpdate.add(labelSuperficieU);

		JLabel labelTexteU = new JLabel("Texte");
		labelTexteU.setHorizontalAlignment(SwingConstants.CENTER);
		labelTexteU.setFont(new Font("Papyrus", Font.PLAIN, 14));
		labelTexteU.setBounds(559, 77, 129, 23);
		panelUpdate.add(labelTexteU);

		JTextArea fieldTextAreaU = new JTextArea();
		fieldTextAreaU.setLineWrap(true);
		fieldTextAreaU.setBounds(698, 34, 585, 137);
		panelUpdate.add(fieldTextAreaU);

		JLabel labelPhotoU = new JLabel("Photos");
		labelPhotoU.setHorizontalAlignment(SwingConstants.CENTER);
		labelPhotoU.setFont(new Font("Papyrus", Font.PLAIN, 14));
		labelPhotoU.setBounds(612, 212, 129, 23);
		panelUpdate.add(labelPhotoU);

		fieldIMGU = new JTextField();
		fieldIMGU.setBounds(751, 205, 363, 37);
		panelUpdate.add(fieldIMGU);
		fieldIMGU.setColumns(10);

		JButton btnIMGU = new JButton("AJOUTER");
		btnIMGU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser file = new JFileChooser();
				file.showOpenDialog(file);

				// RECUPERATION DU FICHIER SELECTIONNER
				File fileSelected = file.getSelectedFile();
				String chemin = fileSelected.getAbsolutePath();
				String destination = "src/ressource/";

				File source = new File(chemin);
				//Retirer les espaces dans le titre
				String	imageName = fieldTitreU.getText().trim().replaceAll(" ","_");
				String test = imageName+"."+chemin.substring(chemin.lastIndexOf(".")+1);
				fieldIMGU.setText(test);
				File destinationFinal = new File(destination+test);
				System.out.println(destinationFinal);
				try {
					Files.copy(source.toPath(), destinationFinal.toPath());
					System.out.println("Dans le try");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnIMGU.setFont(new Font("Papyrus", Font.BOLD, 16));
		btnIMGU.setBounds(1124, 205, 159, 37);
		panelUpdate.add(btnIMGU);

		JLabel labelStatusU = new JLabel("Status");
		labelStatusU.setHorizontalAlignment(SwingConstants.CENTER);
		labelStatusU.setFont(new Font("Papyrus", Font.PLAIN, 14));
		labelStatusU.setBounds(652, 297, 129, 23);
		panelUpdate.add(labelStatusU);

		JCheckBox chckbxAvendreU= new JCheckBox("VENDRE");
		chckbxAvendreU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbxStatusU = "vendre";
				System.out.println(chckbxAvendreU.getText());
			}
		});
		chckbxAvendreU.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxAvendreU.setFont(new Font("Papyrus", Font.BOLD, 11));
		chckbxAvendreU.setBounds(815, 297, 114, 23);
		panelUpdate.add(chckbxAvendreU);

		JCheckBox chckbxAlouerU = new JCheckBox("LOUER");
		chckbxAlouerU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbxStatusU = "louer";
				System.out.println(chckbxAlouerU.getText());
			}
		});
		chckbxAlouerU.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxAlouerU.setFont(new Font("Papyrus", Font.BOLD, 11));
		chckbxAlouerU.setBounds(830, 393, 99, 23);
		panelUpdate.add(chckbxAlouerU);

		//Crer un group de CheckBox
		ButtonGroup bgStatusU = new ButtonGroup();
		//ajouter les boutons radio au groupe
		bgStatusU.add(chckbxAvendreU);
		bgStatusU.add(chckbxAlouerU);

		JLabel labelProprietaireU = new JLabel("Proprietaire");
		labelProprietaireU.setHorizontalAlignment(SwingConstants.CENTER);
		labelProprietaireU.setFont(new Font("Papyrus", Font.PLAIN, 14));
		labelProprietaireU.setBounds(676, 468, 129, 23);
		panelUpdate.add(labelProprietaireU);

		fieldProprietaireU= new JTextField();
		fieldProprietaireU.setColumns(10);
		fieldProprietaireU.setBounds(815, 469, 291, 20);
		panelUpdate.add(fieldProprietaireU);

		
		//SET DES CHAMPS
		fieldTitreU.setText(bienShow.getTitre());
		fieldVilleU.setText(bienShow.getVille());
		fieldPrixU.setText(bienShow.getPrix().toString());
		fieldNbPieceU.setText(String.valueOf(bienShow.getNbPiece()));
		fieldSuperficieU.setText(String.valueOf(bienShow.getSuperficie()));
		fieldTextAreaU.setText(bienShow.getTexte()); 
		fieldIMGU.setText(bienShow.getImages());
		//fieldProprietaireU.setText(bienShow.getProprietaire().getUser().getEmail());
		
		JButton btnPublierU = new JButton("Update");
		btnPublierU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BienDao bienDao = new BienDao();
				ProprietaireDao pd = new ProprietaireDao();

				//INSTANCIATION
				Proprietaire proprietaire = pd.isExistProprio(fieldProprietaireU.getText());
				int id = bienShow.getId();

				Bien bien = new Bien(fieldTitreU.getText(), cbxCatU, cbxTypeU, fieldVilleU.getText(), Float.parseFloat(fieldPrixU.getText()),
						(Integer.parseInt(fieldNbPieceU.getText())), (Integer.parseInt(fieldSuperficieU.getText())),
						fieldTextAreaU.getText(), fieldIMGU.getText(), cbxStatusU, proprietaire);

				System.out.println("TESTER11111");
				if(bienDao.update(bien, id)) {
					System.out.println("TESTER");
					JOptionPane.showMessageDialog(null, "Bravo, bien actualiser !");
					//Redirection vers espace employe
					panelUpdate.removeAll();
					EspaceEmploye eEmp = new EspaceEmploye();
					panelUpdate.add(eEmp);
					panelUpdate.repaint();
					panelUpdate.revalidate();
				}
				else {
					System.out.println("Dans le else");
					JOptionPane.showMessageDialog(null, "OUPS, erreur lors de l'actualisation...");	
				}
			}
		});
		btnPublierU.setFont(new Font("Papyrus", Font.BOLD, 22));
		btnPublierU.setBounds(982, 501, 341, 50);
		panelUpdate.add(btnPublierU);

		JLabel LabelActualisation = new JLabel("Actualisation bien");
		LabelActualisation.setHorizontalAlignment(SwingConstants.CENTER);
		LabelActualisation.setFont(new Font("Papyrus", Font.BOLD | Font.ITALIC, 25));
		LabelActualisation.setBounds(218, 24, 278, 59);
		panelUpdate.add(LabelActualisation);
		
		JButton btnRetour = new JButton("RETOUR");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Redirection vers espace employe
				panelUpdate.removeAll();
				EspaceEmploye eEmp = new EspaceEmploye();
				panelUpdate.add(eEmp);
				panelUpdate.repaint();
				panelUpdate.revalidate();
			}
		});
		btnRetour.setForeground(new Color(255, 0, 0));
		btnRetour.setFont(new Font("Papyrus", Font.BOLD, 12));
		btnRetour.setBounds(25, 29, 99, 37);
		panelUpdate.add(btnRetour);


	}
}
