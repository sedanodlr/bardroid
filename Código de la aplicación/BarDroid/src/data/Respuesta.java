package data;

import java.util.ArrayList;
public class Respuesta {
	
	
	private ArrayList<Categoria> cat= new ArrayList<Categoria>();
	private ArrayList<Producto> prod= new ArrayList<Producto>();
	private int success;
	
	
	

	public int getSuccess() {
		return success;
	}
	public void setSuccess(int success) {
		this.success = success;
	}
	
	
	
	public ArrayList<Categoria> getCatlist() {
		return cat;
	}
	public void setCatlist(ArrayList<Categoria> cat) {
		this.cat = cat;
	}
	public ArrayList<Producto> getProdlist() {
		return prod;
	}
	public void setProdlist(ArrayList<Producto> prod) {
		this.prod = prod;
	}
}
