package View;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import Controller.BienDao;
import Controller.MessageDao;
import Model.Bien;
import Model.Message;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EspaceMessage extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tableBien;
	private JTable tableMessage;
	private DefaultTableCellRenderer cellRenderer;
	
	BienDao bienDao = new BienDao();
	ArrayList<Bien> Biens = bienDao.read();
	MessageDao messageDao = new MessageDao();
	ArrayList<Message> messages = messageDao.read();
	Bien bn = new Bien();

	/**
	 * Create the panel.
	 */
	public EspaceMessage() {
		setLayout(null);
		setBounds(0, 0, 1366, 768);
		
		JPanel panelEspaceMessage = new JPanel();
		panelEspaceMessage.setBackground(new Color(0, 64, 128));
		panelEspaceMessage.setBounds(0, 0, 1366, 570);
		add(panelEspaceMessage);
		panelEspaceMessage.setLayout(null);
		
		JPanel panelMessageBien = new JPanel();
		panelMessageBien.setBackground(new Color(128, 128, 64));
		panelMessageBien.setBounds(0, 44, 1366, 526);
		panelEspaceMessage.add(panelMessageBien);
		panelMessageBien.setLayout(null);
		
		JScrollPane scrollPaneMessage = new JScrollPane();
		scrollPaneMessage.setBounds(0, 0, 1366, 570);
		panelMessageBien.add(scrollPaneMessage);
		
		tableMessage = new JTable();
		tableMessage.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableMessage.setFont(new Font("Papyrus", Font.PLAIN, 14));
		tableMessage.setBounds(0, 0, 1366, 570);
		tableMessage.setBackground(new Color(128, 128, 64));
		tableMessage.setRowHeight(50);
		
		tableMessage.setModel(listeMessageBien(messages));
		scrollPaneMessage.add(tableMessage);
		scrollPaneMessage.setViewportView(tableMessage);
		
		JButton btnRetourEE = new JButton("Retour");
		btnRetourEE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelEspaceMessage.removeAll();
				EspaceEmploye EEm = new EspaceEmploye();
				panelEspaceMessage.add(EEm);
				panelEspaceMessage.repaint();
				panelEspaceMessage.revalidate();
			}
		});
		btnRetourEE.setBackground(new Color(64, 128, 128));
		btnRetourEE.setFont(new Font("Papyrus", Font.BOLD, 16));
		btnRetourEE.setBounds(10, 0, 200, 42);
		panelEspaceMessage.add(btnRetourEE);
		// set the column width for each column
		tableMessage.getColumnModel().getColumn(0).setPreferredWidth(1066);
		tableMessage.getColumnModel().getColumn(1).setPreferredWidth(150);
		tableMessage.getColumnModel().getColumn(2).setPreferredWidth(150);
		 cellRenderer = new DefaultTableCellRenderer();
		 cellRenderer.setHorizontalAlignment(JLabel.CENTER);
		//tableMessage.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
	}
	
		// METHODE AJOUT LIGNE TABLEAU POUR CHAQUE MESSAGE
	
	public DefaultTableModel listeMessageBien(ArrayList<Message> messages) {
		String col[] = {"Message", "Client", "Bien"};
		DefaultTableModel tableauMessage = new  DefaultTableModel(null, col);
		
		for (Message message : messages) {
			tableauMessage.addRow(new Object[] {
					message.getMsg(),
					message.getClient().getPrenom()+" "+ message.getClient().getNom(),
					message.getBien().getTitre()
					
			});
		}
		System.out.println("tableau message :========="+tableauMessage);
		return tableauMessage;
	}

}
