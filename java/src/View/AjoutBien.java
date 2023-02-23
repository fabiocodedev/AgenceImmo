package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

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

public class AjoutBien extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField fieldTitre;
	private JTextField fieldVille;
	private JTextField fieldPrix;
	private JTextField fieldNbPiece;
	private JTextField fieldSuperficie;
	private JTextField fieldIMG;
	
	
	String cbxType = "";
	String cbxCat = "";
	String cbxStatus = "";

	private JTextField fieldProprietaire;
	
	Bien bien = new Bien();

	/**
	 * Create the panel.
	 */
	public AjoutBien() {
		setLayout(null);
		setBounds(0, 0, 1366, 570);

		/*
		 * JPanel panelEmploye = new JPanel(); panelEmploye.setBackground(new Color(0,
		 * 64, 128)); panelEmploye.setBounds(0, 0, 1366, 768); add(panelEmploye);
		 * panelEmploye.setLayout(null);
		 */

		JPanel panelAjout = new JPanel();
		panelAjout.setName("nom");
		panelAjout.setBackground(new Color(0, 128, 128));
		panelAjout.setBounds(0, 0, 1366, 570);
		add(panelAjout);
		panelAjout.setLayout(null);

		JLabel labelTitre = new JLabel("Titre");
		labelTitre.setFont(new Font("Papyrus", Font.PLAIN, 14));
		labelTitre.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitre.setBounds(35, 117, 104, 23);
		panelAjout.add(labelTitre);

		fieldTitre = new JTextField();
		fieldTitre.setBounds(159, 118, 332, 20);
		panelAjout.add(fieldTitre);
		fieldTitre.setColumns(10);

		JLabel labelType = new JLabel("Type");
		labelType.setHorizontalAlignment(SwingConstants.CENTER);
		labelType.setFont(new Font("Papyrus", Font.PLAIN, 14));
		labelType.setBounds(35, 188, 104, 23);
		panelAjout.add(labelType);

		JCheckBox chckbxAchat = new JCheckBox("ACHAT");
		chckbxAchat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbxType = "achat";
				System.out.println(chckbxAchat.getText());
			}
		});
		chckbxAchat.setFont(new Font("Papyrus", Font.BOLD, 11));
		chckbxAchat.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxAchat.setBounds(169, 189, 104, 23);
		panelAjout.add(chckbxAchat);

		JCheckBox chckbxLoc = new JCheckBox("LOCATION");
		chckbxLoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbxType = "location";
				System.out.println(chckbxLoc.getText());
			}
		});
		chckbxLoc.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxLoc.setFont(new Font("Papyrus", Font.BOLD, 11));
		chckbxLoc.setBounds(336, 189, 155, 23);
		panelAjout.add(chckbxLoc);

		//Crer un group de CheckBox
		ButtonGroup bgAchatLoc = new ButtonGroup();
		//ajouter les boutons radio au groupe
		bgAchatLoc.add(chckbxAchat);
		bgAchatLoc.add(chckbxLoc);

		JLabel labelCategorie = new JLabel("Categorie");
		labelCategorie.setHorizontalAlignment(SwingConstants.CENTER);
		labelCategorie.setFont(new Font("Papyrus", Font.PLAIN, 14));
		labelCategorie.setBounds(35, 239, 104, 23);
		panelAjout.add(labelCategorie);

		JCheckBox chckbxMaison = new JCheckBox("MAISON");
		chckbxMaison.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbxCat = "maison";
				System.out.println(chckbxMaison.getText());
			}
		});
		chckbxMaison.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxMaison.setFont(new Font("Papyrus", Font.BOLD, 11));
		chckbxMaison.setBounds(169, 240, 104, 23);
		panelAjout.add(chckbxMaison);

		JCheckBox chckbxAppart = new JCheckBox("APPARTEMENT");
		chckbxAppart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbxCat = "appartement";
				System.out.println(chckbxAppart.getText());
			}
		});
		chckbxAppart.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxAppart.setFont(new Font("Papyrus", Font.BOLD, 11));
		chckbxAppart.setBounds(336, 240, 161, 23);
		panelAjout.add(chckbxAppart);

		//Crer un group de CheckBox
		ButtonGroup bgMaisonAppart = new ButtonGroup();
		//ajouter les boutons radio au groupe
		bgMaisonAppart.add(chckbxMaison);
		bgMaisonAppart.add(chckbxAppart);

		JLabel labelVille = new JLabel("Ville");
		labelVille.setHorizontalAlignment(SwingConstants.CENTER);
		labelVille.setFont(new Font("Papyrus", Font.PLAIN, 14));
		labelVille.setBounds(35, 296, 104, 23);
		panelAjout.add(labelVille);

		fieldVille = new JTextField();
		fieldVille.setColumns(10);
		fieldVille.setBounds(169, 297, 332, 20);
		panelAjout.add(fieldVille);

		JLabel labelPrix = new JLabel("Prix");
		labelPrix.setHorizontalAlignment(SwingConstants.CENTER);
		labelPrix.setFont(new Font("Papyrus", Font.PLAIN, 14));
		labelPrix.setBounds(24, 370, 104, 23);
		panelAjout.add(labelPrix);

		fieldPrix = new JTextField();
		fieldPrix.setColumns(10);
		fieldPrix.setBounds(169, 371, 332, 20);
		panelAjout.add(fieldPrix);

		JLabel labelNbPiece = new JLabel("Nombre de Pieces");
		labelNbPiece.setHorizontalAlignment(SwingConstants.CENTER);
		labelNbPiece.setFont(new Font("Papyrus", Font.PLAIN, 14));
		labelNbPiece.setBounds(30, 458, 129, 23);
		panelAjout.add(labelNbPiece);

		fieldNbPiece = new JTextField();
		fieldNbPiece.setColumns(10);
		fieldNbPiece.setBounds(169, 459, 332, 20);
		panelAjout.add(fieldNbPiece);

		fieldSuperficie = new JTextField();
		fieldSuperficie.setColumns(10);
		fieldSuperficie.setBounds(165, 528, 332, 20);
		panelAjout.add(fieldSuperficie);

		JLabel labelSuperficie = new JLabel("Superficie");
		labelSuperficie.setHorizontalAlignment(SwingConstants.CENTER);
		labelSuperficie.setFont(new Font("Papyrus", Font.PLAIN, 14));
		labelSuperficie.setBounds(6, 527, 129, 23);
		panelAjout.add(labelSuperficie);

		JLabel labelTexte = new JLabel("Texte");
		labelTexte.setHorizontalAlignment(SwingConstants.CENTER);
		labelTexte.setFont(new Font("Papyrus", Font.PLAIN, 14));
		labelTexte.setBounds(562, 80, 129, 23);
		panelAjout.add(labelTexte);

		JTextArea fieldTextArea = new JTextArea();
		fieldTextArea.setLineWrap(true);
		fieldTextArea.setBounds(701, 31, 585, 107);
		panelAjout.add(fieldTextArea);

		JLabel labelPhoto = new JLabel("Photos");
		labelPhoto.setHorizontalAlignment(SwingConstants.CENTER);
		labelPhoto.setFont(new Font("Papyrus", Font.PLAIN, 14));
		labelPhoto.setBounds(559, 239, 129, 23);
		panelAjout.add(labelPhoto);

		fieldIMG = new JTextField();
		fieldIMG.setBounds(701, 200, 368, 40);
		panelAjout.add(fieldIMG);
		fieldIMG.setColumns(10);

		JButton btnIMG = new JButton("Selectionner");
		btnIMG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser file = new JFileChooser();
				file.showOpenDialog(file);
				
				// RECUPERATION DU FICHIER SELECTIONNER
				File fileSelected = file.getSelectedFile();
				String chemin = fileSelected.getAbsolutePath();
				String destination = "src/ressource/";
				
				File source = new File(chemin);
				//Retirer les espaces dans le titre
			String	imageName = fieldTitre.getText().trim().replaceAll(" ","_");
			String test = imageName+"."+chemin.substring(chemin.lastIndexOf(".")+1);
			fieldIMG.setText(test);
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
		btnIMG.setFont(new Font("Papyrus", Font.BOLD, 16));
		btnIMG.setBounds(1094, 200, 192, 40);
		panelAjout.add(btnIMG);

		JLabel labelStatus = new JLabel("Status");
		labelStatus.setHorizontalAlignment(SwingConstants.CENTER);
		labelStatus.setFont(new Font("Papyrus", Font.PLAIN, 14));
		labelStatus.setBounds(576, 296, 129, 23);
		panelAjout.add(labelStatus);

		JCheckBox chckbxAvendre = new JCheckBox("VENDRE");
		chckbxAvendre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbxStatus = "vendre";
				System.out.println(chckbxAvendre.getText());
			}
		});
		chckbxAvendre.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxAvendre.setFont(new Font("Papyrus", Font.BOLD, 11));
		chckbxAvendre.setBounds(814, 297, 114, 23);
		panelAjout.add(chckbxAvendre);

		JCheckBox chckbxAlouer = new JCheckBox("LOUER");
		chckbxAlouer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbxStatus = "louer";
				System.out.println(chckbxAlouer.getText());
			}
		});
		chckbxAlouer.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxAlouer.setFont(new Font("Papyrus", Font.BOLD, 11));
		chckbxAlouer.setBounds(1137, 297, 99, 23);
		panelAjout.add(chckbxAlouer);

		//Crer un group de CheckBox
		ButtonGroup bgStatus = new ButtonGroup();
		//ajouter les boutons radio au groupe
		bgStatus.add(chckbxAvendre);
		bgStatus.add(chckbxAlouer);

		JLabel labelProprietaire = new JLabel("Proprietaire");
		labelProprietaire.setHorizontalAlignment(SwingConstants.CENTER);
		labelProprietaire.setFont(new Font("Papyrus", Font.PLAIN, 14));
		labelProprietaire.setBounds(591, 398, 129, 23);
		panelAjout.add(labelProprietaire);
		
		fieldProprietaire = new JTextField();
		fieldProprietaire.setColumns(10);
		fieldProprietaire.setBounds(730, 399, 556, 20);
		panelAjout.add(fieldProprietaire);

		JButton btnPublier = new JButton("Ajouter ");
		btnPublier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BienDao bienDao = new BienDao();
				ProprietaireDao pd = new ProprietaireDao();
				
				//INSTANCIATION
				Proprietaire proprietaire = pd.isExistProprio(fieldProprietaire.getText());
				
				Bien bien = new Bien(fieldTitre.getText(), cbxCat, cbxType, fieldVille.getText(), Float.parseFloat(fieldPrix.getText()),
						(Integer.parseInt(fieldNbPiece.getText())), (Integer.parseInt(fieldSuperficie.getText())),
						fieldTextArea.getText(), fieldIMG.getText(), cbxStatus, proprietaire);
				
				if(bienDao.create(bien)) {
					JOptionPane.showMessageDialog(null, "Bravo, bien publier !");
					//Redirection vers la page d'accueil
					panelAjout.removeAll();
					EspaceEmploye ee = new EspaceEmploye();
					panelAjout.add(ee);
					panelAjout.repaint();
					panelAjout.revalidate();
				}
				else {
					JOptionPane.showMessageDialog(null, "OUPS, erreur lors de la publication...");	
				}
			}
		});
		btnPublier.setFont(new Font("Papyrus", Font.BOLD, 22));
		btnPublier.setBounds(856, 458, 297, 73);
		panelAjout.add(btnPublier);
		
		JLabel labelPublication = new JLabel("Publication  bien");
		labelPublication.setHorizontalAlignment(SwingConstants.CENTER);
		labelPublication.setFont(new Font("Papyrus", Font.BOLD | Font.ITALIC, 30));
		labelPublication.setBounds(197, 11, 283, 58);
		panelAjout.add(labelPublication);
		
		JButton btnNewButton = new JButton("RETOUR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Redirection vers espace employe
				panelAjout.removeAll();
				EspaceEmploye eEmp = new EspaceEmploye();
				panelAjout.add(eEmp);
				panelAjout.repaint();
				panelAjout.revalidate();
			}
		});
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("Papyrus", Font.BOLD, 12));
		btnNewButton.setBounds(24, 26, 104, 43);
		panelAjout.add(btnNewButton);
		
	}
}

