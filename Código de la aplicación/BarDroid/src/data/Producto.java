package data;

import android.database.Cursor;
public class Producto {
	private int ID;
	private int ID_bar;
	private String nombre;
	private double precio;
	private int catego;
	
	
	
	public Producto(){
		
	}
	
	public Producto(int id, String n, int cat, double precio){
		this.ID = id;
		this.nombre = n;		
		this.catego = cat;
		this.precio = precio;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
	}
	
	
	
	public String getNombreProd() {
		return nombre;
	}
	public void setNombreProd(String nombre) {
		this.nombre = nombre;
	}
	
	public double getPrecioProd() {
		return precio;
	}
	public void setPrecioProd(double p) {
		this.precio = p;
	}
	
	
	public void setId(int int1) {
		// TODO Auto-generated method stub
		ID = int1;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return ID;
	}
	
	public String toString(){
		return getNombreProd();
	}

	public static Producto getProducto(Cursor item) {
		Producto producto = new Producto();
		producto.setId(Integer.parseInt(item.getString(0)));
        producto.setNombreProd(item.getString(1));
        producto.setPrecioProd(item.getFloat(2));
		return producto;
	}

	public int getID_bar() {
		return ID_bar;
	}

	public void setID_bar(int iD_bar) {
		ID_bar = iD_bar;
	}

	public int getCatego() {
		return catego;
	}

	public void setCatego(int catego) {
		this.catego = catego;
	}

}
