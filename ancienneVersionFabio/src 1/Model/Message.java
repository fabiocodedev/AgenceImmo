package Model;

public class Message {
	private int  id;
	private String msg;
	private int id_Bien;
	private int id_Client;
	//CONSTRUCTEUR COMPLET
	public Message(int id, String msg, int id_Bien, int id_Client) {
		super();
		this.id = id;
		this.msg = msg;
		this.id_Bien = id_Bien;
		this.id_Client = id_Client;
	}
	//CONSTRUCTEUR SANS ID
	public Message(String msg, int id_Bien, int id_Client) {
		super();
		this.msg = msg;
		this.id_Bien = id_Bien;
		this.id_Client = id_Client;
	}
	//GETTERS / SETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getId_Bien() {
		return id_Bien;
	}
	public void setId_Bien(int id_Bien) {
		this.id_Bien = id_Bien;
	}
	public int getId_Client() {
		return id_Client;
	}
	public void setId_Client(int id_Client) {
		this.id_Client = id_Client;
	}
}
