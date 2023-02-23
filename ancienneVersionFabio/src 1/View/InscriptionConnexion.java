package View;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import Controller.ClientDao;
import Controller.EmployeDao;
import Controller.MatriculeDao;
import Controller.ProprietaireDao;
import Controller.UserDao;
import Model.Client;
import Model.Employe;
import Model.Matricule;
import Model.Proprietaire;
import Model.User;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InscriptionConnexion extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField email;
	private JPasswordField password;
	private JTextField prenom;
	private JTextField nom;
	private JTextField emailInscri;
	private JPasswordField passwordInscri;
	private JTextField matriculeInscri;
	private JTextField telephone;
	private JTextField adresse;

	static User currentUser;

	//String selected = "client";
	//String selected = "";
	UserDao userDao = new UserDao();
	MatriculeDao matriculeDao = new MatriculeDao();
	EmployeDao employeDao = new EmployeDao();
	ClientDao clientDao = new ClientDao();
	ProprietaireDao proprietaireDao = new ProprietaireDao();

	/**
	 * Create the panel.
	 */
	public InscriptionConnexion() {
		setLayout(null);
		setBounds(0, 0, 1366, 492);

		JPanel panelInscriptionConnexion = new JPanel();
		panelInscriptionConnexion.setBounds(0, 0, 1366, 492);
		add(panelInscriptionConnexion);
		panelInscriptionConnexion.setLayout(null);

		JPanel panelDetails = new JPanel();
		panelDetails.setBackground(new Color(0, 64, 128));
		panelDetails.setBounds(0, 0, 1366, 492);
		panelInscriptionConnexion.add(panelDetails);
		panelDetails.setLayout(null);

		JPanel panelInscription = new JPanel();
		panelInscription.setBackground(new Color(64, 128, 128));
		panelInscription.setBounds(662, 44, 571, 437);
		panelDetails.add(panelInscription);
		panelInscription.setLayout(null);

		JLabel PrenomLabel = new JLabel("Prenom");
		PrenomLabel.setFont(new Font("Papyrus", Font.PLAIN, 18));
		PrenomLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PrenomLabel.setBounds(39, 91, 130, 23);
		panelInscription.add(PrenomLabel);

		prenom = new JTextField();
		prenom.setFont(new Font("Papyrus", Font.PLAIN, 16));
		prenom.setBounds(227, 103, 214, 23);
		panelInscription.add(prenom);
		prenom.setColumns(10);

		JLabel NomLabel = new JLabel("Nom");
		NomLabel.setHorizontalAlignment(SwingConstants.CENTER);
		NomLabel.setFont(new Font("Papyrus", Font.PLAIN, 18));
		NomLabel.setBounds(39, 131, 107, 35);
		panelInscription.add(NomLabel);

		nom = new JTextField();
		nom.setFont(new Font("Papyrus", Font.PLAIN, 16));
		nom.setColumns(10);
		nom.setBounds(227, 137, 214, 23);
		panelInscription.add(nom);

		JLabel EmailInsLabel = new JLabel("Email");
		EmailInsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		EmailInsLabel.setFont(new Font("Papyrus", Font.PLAIN, 18));
		EmailInsLabel.setBounds(29, 182, 130, 29);
		panelInscription.add(EmailInsLabel);

		emailInscri = new JTextField();
		emailInscri.setHorizontalAlignment(SwingConstants.CENTER);
		emailInscri.setFont(new Font("Papyrus", Font.PLAIN, 16));
		emailInscri.setColumns(10);
		emailInscri.setBounds(227, 185, 214, 23);
		panelInscription.add(emailInscri);

		JLabel PasswordInscriLabel = new JLabel("Password");
		PasswordInscriLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PasswordInscriLabel.setFont(new Font("Papyrus", Font.PLAIN, 18));
		PasswordInscriLabel.setBounds(42, 224, 117, 23);
		panelInscription.add(PasswordInscriLabel);

		passwordInscri = new JPasswordField();
		passwordInscri.setFont(new Font("Papyrus", Font.PLAIN, 18));
		passwordInscri.setBounds(227, 224, 214, 23);
		panelInscription.add(passwordInscri);

		matriculeInscri = new JTextField();
		matriculeInscri.setFont(new Font("Papyrus", Font.PLAIN, 15));
		matriculeInscri.setHorizontalAlignment(SwingConstants.CENTER);
		matriculeInscri.setBounds(227, 57, 214, 23);
		panelInscription.add(matriculeInscri);
		matriculeInscri.setColumns(10);

		JLabel telephoneLabel = new JLabel("Telephone");
		telephoneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		telephoneLabel.setFont(new Font("Papyrus", Font.PLAIN, 18));
		telephoneLabel.setBounds(52, 265, 107, 35);
		panelInscription.add(telephoneLabel);

		telephone = new JTextField();
		telephone.setHorizontalAlignment(SwingConstants.CENTER);
		telephone.setFont(new Font("Papyrus", Font.PLAIN, 16));
		telephone.setColumns(10);
		telephone.setBounds(227, 271, 214, 23);
		panelInscription.add(telephone);

		JLabel adresseLabel = new JLabel("Adresse");
		adresseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		adresseLabel.setFont(new Font("Papyrus", Font.PLAIN, 18));
		adresseLabel.setBounds(52, 314, 107, 35);
		panelInscription.add(adresseLabel);

		adresse = new JTextField();
		adresse.setHorizontalAlignment(SwingConstants.CENTER);
		adresse.setFont(new Font("Papyrus", Font.PLAIN, 16));
		adresse.setColumns(10);
		adresse.setBounds(227, 320, 214, 23);
		panelInscription.add(adresse);
		matriculeInscri.setVisible(false);

		JPanel panelConnexion = new JPanel();
		panelConnexion.setBackground(new Color(64, 128, 128));
		panelConnexion.setBounds(48, 17, 502, 453);
		panelDetails.add(panelConnexion);
		panelConnexion.setLayout(null);

		JLabel TitreConnexion = new JLabel("Connexion");
		TitreConnexion.setForeground(new Color(0, 0, 0));
		TitreConnexion.setFont(new Font("Papyrus", Font.PLAIN, 24));
		TitreConnexion.setHorizontalAlignment(SwingConstants.CENTER);
		TitreConnexion.setBounds(96, 30, 277, 47);
		panelConnexion.add(TitreConnexion);

		JLabel EmailLabel = new JLabel("Email");
		EmailLabel.setHorizontalAlignment(SwingConstants.CENTER);
		EmailLabel.setFont(new Font("Papyrus", Font.PLAIN, 20));
		EmailLabel.setBounds(10, 152, 117, 32);
		panelConnexion.add(EmailLabel);

		email = new JTextField();
		email.setFont(new Font("Papyrus", Font.PLAIN, 16));
		email.setHorizontalAlignment(SwingConstants.CENTER);
		email.setBounds(172, 153, 219, 32);
		panelConnexion.add(email);
		email.setColumns(10);

		JLabel PasswordLabel = new JLabel("Password");
		PasswordLabel.setFont(new Font("Papyrus", Font.PLAIN, 18));
		PasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PasswordLabel.setBounds(10, 220, 117, 32);
		panelConnexion.add(PasswordLabel);

		password = new JPasswordField();
		password.setFont(new Font("Papyrus", Font.PLAIN, 18));
		password.setBounds(173, 220, 218, 32);
		panelConnexion.add(password);

		JButton submit_connexion = new JButton("Connexion");
		submit_connexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User user = userDao.connection(email.getText(), String.valueOf(password.getPassword()));	
				if (user != null) {
					InscriptionConnexion.currentUser = user;
					JOptionPane.showMessageDialog(null,"BRAVO  "+ currentUser.getPrenom()+" , vous êtes bien connecté","Connexion",JOptionPane.INFORMATION_MESSAGE);
					//Redirection vers la page d'accueil
					panelInscriptionConnexion.removeAll();
					Accueil ac = new Accueil();
					panelInscriptionConnexion.add(ac);
					panelInscriptionConnexion.repaint();
					panelInscriptionConnexion.revalidate();
				}else {
					JOptionPane.showMessageDialog(null,"Oups ! \n Email ou mot de passe incorrect","Connexion",JOptionPane.ERROR_MESSAGE);		
				}	
			}
		});
		submit_connexion.setFont(new Font("Papyrus", Font.PLAIN, 22));
		submit_connexion.setBounds(172, 358, 208, 50);
		panelConnexion.add(submit_connexion);

		JLabel lblInscription = new JLabel("Inscription");
		lblInscription.setHorizontalAlignment(SwingConstants.CENTER);
		lblInscription.setFont(new Font("Papyrus", Font.PLAIN, 24));
		lblInscription.setBounds(117, 11, 277, 35);
		panelInscription.add(lblInscription);

		JLabel matriculeLabel = new JLabel("Matricule");
		matriculeLabel.setFont(new Font("Papyrus", Font.PLAIN, 15));
		matriculeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		matriculeLabel.setBounds(42, 53, 117, 38);
		panelInscription.add(matriculeLabel);
		matriculeLabel.setVisible(false);

		//CREATION DES BOUTONS RADIOS
		//boutton radio client
		JRadioButton client_select = new JRadioButton("Client");
		client_select.setSelected(true);
		//bouton radio employe
		JRadioButton employe_select = new JRadioButton("Employe");
		//bouton radio proprietaire
		JRadioButton proprietaire_select = new JRadioButton("Propirietaire");

		//Crer un group de ButtonRadio
		ButtonGroup bg = new ButtonGroup();
		//ajouter les boutons radio au groupe
		bg.add(client_select);
		bg.add(employe_select);
		bg.add(proprietaire_select);

		//SELECTION CIENT
		client_select.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//selected = "client";
				//System.out.println(selected);

				//Basculer les autres boutons en false 
				client_select.setSelected(true);
				proprietaire_select.setSelected(false);
				employe_select.setSelected(false);
				//cacher le label et le champ matricule pour les clients
				matriculeLabel.setVisible(false);
				matriculeInscri.setVisible(false);
			}
		});
		//SELECTION EMPLOYE
		employe_select.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//selected = "employe";
				//System.out.println(selected);
				//Basculer les autres boutons en false 
				client_select.setSelected(false);
				proprietaire_select.setSelected(false);
				employe_select.setSelected(true);
				//Afficher le label et champ matricule
				matriculeLabel.setVisible(true);
				matriculeInscri.setVisible(true);
			}
		});
		//SELECTION PROPRIETAIRE
		proprietaire_select.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//selected = "proprietaire";
				//System.out.println(selected);

				//Basculer les autres boutons en false 
				proprietaire_select.setSelected(true);
				client_select.setSelected(false);
				employe_select.setSelected(false);

				//cacher le label et champ matricule
				matriculeLabel.setVisible(false);
				matriculeInscri.setVisible(false);
			}
		});

		employe_select.setBounds(1125, 0, 107, 37);
		panelDetails.add(employe_select);
		employe_select.setBackground(new Color(64, 128, 128));
		employe_select.setFont(new Font("Papyrus", Font.PLAIN, 18));

		client_select.setBounds(662, 0, 119, 37);
		panelDetails.add(client_select);
		client_select.setBackground(new Color(64, 128, 128));
		client_select.setFont(new Font("Papyrus", Font.PLAIN, 18));

		proprietaire_select.setBounds(889, 0, 123, 37);
		panelDetails.add(proprietaire_select);
		proprietaire_select.setBackground(new Color(64, 128, 128));
		proprietaire_select.setFont(new Font("Papyrus", Font.PLAIN, 18));

		/***********************************************************************************/
		//INSCRIPTION
		JButton submit_inscri = new JButton("S'inscrire");
		submit_inscri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//INSTANCIER
				User user = new User(prenom.getText(),nom.getText(),emailInscri.getText(),String.valueOf(passwordInscri));	
				if (prenom.getText().length() == 0 || nom.getText().length() ==0
						|| String.valueOf(passwordInscri.getPassword()).length() ==0  || adresse.getText().length() == 0
						|| telephone.getText().length() ==0 || emailInscri.getText().length() ==0)  {
					JOptionPane.showConfirmDialog(null,"OUPS ! Aucun champ ne doit être vide", " Echec Inscription", JOptionPane.ERROR_MESSAGE);
				}
				else if(!userDao.isValidEmail(emailInscri.getText())) {
					JOptionPane.showConfirmDialog(null,"OUPS ! L'email est invalide", " Echec Inscription", JOptionPane.ERROR_MESSAGE);
				}else if(!userDao.isPhoneValid(telephone.getText())) {
					JOptionPane.showConfirmDialog(null,"OUPS ! Le numero de telephone est invalide", " Echec Inscription", JOptionPane.ERROR_MESSAGE);	
				}else if (userDao.isExist(emailInscri.getText())) {
					JOptionPane.showMessageDialog(null, emailInscri.getText()+" existe deja!");
				}else if(!userDao.isPasswordValid(String.valueOf(passwordInscri.getPassword()))) {
					JOptionPane.showConfirmDialog(null,"OUPS ! Veuillez choissir un autre mot de passe" ," Le mot passe  est invalide",  JOptionPane.ERROR_MESSAGE);
				} else {
					if(userDao.create(user)) {
						//System.out.println(selected);
						//if(selected == "employe") {
						if(employe_select.isSelected()) {
							Matricule matricule = matriculeDao.isExistMat(matriculeInscri.getText());
							// matriculeDao.create(matricule);
							if(matriculeDao.isExistMat(matriculeInscri.getText()) != null) {
								Employe employe = new Employe(user,matricule);
								employeDao.create(employe);
							}else {
								System.out.println("Dans le else");
								JOptionPane.showMessageDialog(null, " La matricule " + matriculeInscri.getText()+" n'existe pas. Rapprochez de votre manager pour avoir votre numéro!");
							}
							//}else if (selected == "client") {
						}else if (client_select.isSelected()) {
							Client  client = new Client(adresse.getText(),telephone.getText(), user);
							clientDao.create(client);

							//}else if (selected == "proprietaire") {
						}else if (proprietaire_select.isSelected()) {
							Proprietaire proprietaire = new Proprietaire(adresse.getText(),telephone.getText(),user);
							proprietaireDao.create(proprietaire);
						}
						currentUser = user;
						JOptionPane.showMessageDialog(null, "Bravo "+currentUser.getPrenom()+", compte créé");
						//Redirection vers la page d'accueil
						panelInscriptionConnexion.removeAll();
						Accueil ac = new Accueil();
						panelInscriptionConnexion.add(ac);
						panelInscriptionConnexion.repaint();
						panelInscriptionConnexion.revalidate();
					}else {
						JOptionPane.showMessageDialog(null, "OUPS, erreur lors de la de l'inscription");						
					}
				}
			}
		});
		submit_inscri.setFont(new Font("Papyrus", Font.PLAIN, 22));
		submit_inscri.setBounds(227, 388, 214, 35);
		panelInscription.add(submit_inscri);
	}
}
