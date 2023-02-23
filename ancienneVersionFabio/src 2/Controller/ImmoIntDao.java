package Controller;

import java.util.List;

import Model.Achat;

public interface ImmoIntDao<T> {
	
	public boolean create(T object);
	public List<T> read();
	public boolean update(T object, int id);
	public boolean delete(T object);

	

}
