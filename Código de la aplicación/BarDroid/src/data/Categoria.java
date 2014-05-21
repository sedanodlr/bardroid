package data;

public class Categoria {
	private int idcat;
	private String nombre;
	private int idbar;
	
	public Categoria(){
	}
	
	public Categoria(int id, String nom){
		idcat = id;
		nombre = nom;
	}
	
	public int getIdcat() {
		return idcat;
	}
	public void setIdcat(int idcat) {
		this.idcat = idcat;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getIdbar() {
		return idbar;
	}
	public void setIdbar(int idbar) {
		this.idbar = idbar;
	}
}
