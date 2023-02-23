package Model;

public class Message {
	private int  id;
	private String msg;
	private Client client;
	private Bien bien;
	
	public Message(int id, String msg, Client client, Bien bien) {
		
		this.id = id;
		this.msg = msg;
		this.client = client;
		this.bien = bien;
	}
	
	public Message(String msg, Client client, Bien bien) {
		
		this.msg = msg;
		this.client = client;
		this.bien = bien;
	}
	
	

	public Message() {

	}

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
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Bien getBien() {
		return bien;
	}
	public void setBien(Bien bien) {
		this.bien = bien;
	}
	
	
	
	
	
}
