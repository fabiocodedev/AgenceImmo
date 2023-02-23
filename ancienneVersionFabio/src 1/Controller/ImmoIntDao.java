package Controller;

import java.util.List;

public interface ImmoIntDao<T> {
	
	public boolean create(T object);
	public List<T> read();
	public void update(T object);
	public boolean delete(T object);

}
