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

public class EspaceEmploye extends JPanel {

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

	/**
	 * Create the panel.
	 */
	public EspaceEmploye() {
		setLayout(null);
		setBounds(0, 0, 1366, 492);

		JPanel panelEmploye = new JPanel();
		panelEmploye.setBackground(new Color(0, 64, 128));
		panelEmploye.setBounds(0, 0, 1366, 492);
		add(panelEmploye);
		panelEmploye.setLayout(null);

		JPanel panelReplace = new JPanel();
		panelReplace.setName("nom");
		panelReplace.setBackground(new Color(0, 128, 128));
		panelReplace.setBounds(24, 68, 1318, 401);
		panelEmploye.add(panelReplace);
		panelReplace.setLayout(null);
		panelReplace.setVisible(true);
		
		JPanel panelAjout = new JPanel();
		panelAjout.setName("nom");
		panelAjout.setBackground(new Color(0, 128, 128));
		panelAjout.setBounds(0, 0, 1318, 401);
		panelEmploye.add(panelAjout);
		panelAjout.setLayout(null);
		panelReplace.setVisible(true);
		
		JButton btnAjoutBien = new JButton("AJOUTER  UN  BIEN");
		btnAjoutBien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("1");
				panelReplace.removeAll();
				panelReplace.add(panelAjout);
				panelAjout.setVisible(true);
				panelReplace.repaint();
				panelReplace.revalidate();
				
			}
		});
		btnAjoutBien.setFont(new Font("Papyrus", Font.BOLD, 16));
		btnAjoutBien.setBounds(65, 11, 255, 31);
		panelEmploye.add(btnAjoutBien);

		JButton btnGererBien = new JButton("GERER  UN  BIEN");
		btnGererBien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("2");
				panelReplace.removeAll();
				ShowBienAgence sba = new ShowBienAgence();
				panelReplace.add(sba);
				sba.setVisible(true);
				panelReplace.repaint();
				panelReplace.revalidate();
			}
		});
		btnGererBien.setFont(new Font("Papyrus", Font.BOLD, 16));
		btnGererBien.setBounds(549, 11, 255, 31);
		panelEmploye.add(btnGererBien);

		JButton btnMessages = new JButton("MESSAGES");
		btnMessages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("3");
				panelReplace.removeAll();
				ShowMessages sm = new ShowMessages();
				panelReplace.add(sm);
				sm.setVisible(true);
				panelReplace.repaint();
				panelReplace.revalidate();
			}
		});
		btnMessages.setFont(new Font("Papyrus", Font.BOLD, 16));
		btnMessages.setBounds(1030, 11, 255, 31);
		panelEmploye.add(btnMessages);


		JLabel labelTitre = new JLabel("Titre");
		labelTitre.setFont(new Font("Papyrus", Font.PLAIN, 14));
		labelTitre.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitre.setBounds(35, 29, 104, 23);
		panelAjout.add(labelTitre);

		fieldTitre = new JTextField();
		fieldTitre.setBounds(142, 30, 332, 20);
		panelAjout.add(fieldTitre);
		fieldTitre.setColumns(10);

		JLabel labelType = new JLabel("Type");
		labelType.setHorizontalAlignment(SwingConstants.CENTER);
		labelType.setFont(new Font("Papyrus", Font.PLAIN, 14));
		labelType.setBounds(35, 77, 104, 23);
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
		chckbxAchat.setBounds(142, 77, 99, 23);
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
		chckbxLoc.setBounds(276, 77, 133, 23);
		panelAjout.add(chckbxLoc);

		//Crer un group de CheckBox
		ButtonGroup bgAchatLoc = new ButtonGroup();
		//ajouter les boutons radio au groupe
		bgAchatLoc.add(chckbxAchat);
		bgAchatLoc.add(chckbxLoc);

		JLabel labelCategorie = new JLabel("Categorie");
		labelCategorie.setHorizontalAlignment(SwingConstants.CENTER);
		labelCategorie.setFont(new Font("Papyrus", Font.PLAIN, 14));
		labelCategorie.setBounds(35, 125, 104, 23);
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
		chckbxMaison.setBounds(142, 126, 104, 23);
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
		chckbxAppart.setBounds(276, 126, 161, 23);
		panelAjout.add(chckbxAppart);

		//Crer un group de CheckBox
		ButtonGroup bgMaisonAppart = new ButtonGroup();
		//ajouter les boutons radio au groupe
		bgMaisonAppart.add(chckbxMaison);
		bgMaisonAppart.add(chckbxAppart);

		JLabel labelVille = new JLabel("Ville");
		labelVille.setHorizontalAlignment(SwingConstants.CENTER);
		labelVille.setFont(new Font("Papyrus", Font.PLAIN, 14));
		labelVille.setBounds(35, 168, 104, 23);
		panelAjout.add(labelVille);

		fieldVille = new JTextField();
		fieldVille.setColumns(10);
		fieldVille.setBounds(142, 169, 332, 20);
		panelAjout.add(fieldVille);

		JLabel labelPrix = new JLabel("Prix");
		labelPrix.setHorizontalAlignment(SwingConstants.CENTER);
		labelPrix.setFont(new Font("Papyrus", Font.PLAIN, 14));
		labelPrix.setBounds(35, 222, 104, 23);
		panelAjout.add(labelPrix);

		fieldPrix = new JTextField();
		fieldPrix.setColumns(10);
		fieldPrix.setBounds(142, 223, 332, 20);
		panelAjout.add(fieldPrix);

		JLabel labelNbPiece = new JLabel("Nombre de Pieces");
		labelNbPiece.setHorizontalAlignment(SwingConstants.CENTER);
		labelNbPiece.setFont(new Font("Papyrus", Font.PLAIN, 14));
		labelNbPiece.setBounds(10, 271, 129, 23);
		panelAjout.add(labelNbPiece);

		fieldNbPiece = new JTextField();
		fieldNbPiece.setColumns(10);
		fieldNbPiece.setBounds(142, 272, 332, 20);
		panelAjout.add(fieldNbPiece);

		fieldSuperficie = new JTextField();
		fieldSuperficie.setColumns(10);
		fieldSuperficie.setBounds(142, 326, 332, 20);
		panelAjout.add(fieldSuperficie);

		JLabel labelSuperficie = new JLabel("Superficie");
		labelSuperficie.setHorizontalAlignment(SwingConstants.CENTER);
		labelSuperficie.setFont(new Font("Papyrus", Font.PLAIN, 14));
		labelSuperficie.setBounds(10, 325, 129, 23);
		panelAjout.add(labelSuperficie);

		JLabel labelTexte = new JLabel("Texte");
		labelTexte.setHorizontalAlignment(SwingConstants.CENTER);
		labelTexte.setFont(new Font("Papyrus", Font.PLAIN, 14));
		labelTexte.setBounds(559, 29, 129, 23);
		panelAjout.add(labelTexte);

		JTextArea fieldTextArea = new JTextArea();
		fieldTextArea.setLineWrap(true);
		fieldTextArea.setBounds(698, 34, 585, 69);
		panelAjout.add(fieldTextArea);

		JLabel labelPhoto = new JLabel("Photos");
		labelPhoto.setHorizontalAlignment(SwingConstants.CENTER);
		labelPhoto.setFont(new Font("Papyrus", Font.PLAIN, 14));
		labelPhoto.setBounds(559, 141, 129, 23);
		panelAjout.add(labelPhoto);

		fieldIMG = new JTextField();
		fieldIMG.setBounds(698, 148, 363, 62);
		panelAjout.add(fieldIMG);
		fieldIMG.setColumns(10);

		JButton btnIMG = new JButton("AJOUTER");
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
		btnIMG.setBounds(1082, 148, 192, 62);
		panelAjout.add(btnIMG);

		JLabel labelStatus = new JLabel("Status");
		labelStatus.setHorizontalAlignment(SwingConstants.CENTER);
		labelStatus.setFont(new Font("Papyrus", Font.PLAIN, 14));
		labelStatus.setBounds(559, 234, 129, 23);
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
		chckbxAvendre.setBounds(698, 235, 114, 23);
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
		chckbxAlouer.setBounds(698, 284, 99, 23);
		panelAjout.add(chckbxAlouer);

		//Crer un group de CheckBox
		ButtonGroup bgStatus = new ButtonGroup();
		//ajouter les boutons radio au groupe
		bgStatus.add(chckbxAvendre);
		bgStatus.add(chckbxAlouer);

		JLabel labelProprietaire = new JLabel("Proprietaire");
		labelProprietaire.setHorizontalAlignment(SwingConstants.CENTER);
		labelProprietaire.setFont(new Font("Papyrus", Font.PLAIN, 14));
		labelProprietaire.setBounds(559, 337, 129, 23);
		panelAjout.add(labelProprietaire);
		
		fieldProprietaire = new JTextField();
		fieldProprietaire.setColumns(10);
		fieldProprietaire.setBounds(709, 337, 291, 20);
		panelAjout.add(fieldProprietaire);

		JButton btnPublier = new JButton("PUBLIER");
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
					panelEmploye.removeAll();
					EspaceEmploye ee = new EspaceEmploye();
					panelEmploye.add(ee);
					panelEmploye.repaint();
					panelEmploye.revalidate();
				}
				else {
					JOptionPane.showMessageDialog(null, "OUPS, erreur lors de la publication...");	
				}
			}
		});
		btnPublier.setFont(new Font("Papyrus", Font.BOLD, 22));
		btnPublier.setBounds(1031, 269, 252, 91);
		panelAjout.add(btnPublier);
		
		//Affiche page par defaut
		panelReplace.removeAll();
		panelReplace.add(panelAjout);
		panelAjout.setVisible(true);
		panelReplace.repaint();
		panelReplace.revalidate();
		
		
	}
}

