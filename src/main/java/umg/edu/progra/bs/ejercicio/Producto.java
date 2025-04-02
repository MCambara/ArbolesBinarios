package umg.edu.progra.bs.ejercicio;

import umg.edu.progra.bst.Empleado;

public class Producto implements Comparable<Producto> {
	
	private int id;
	private String nombre;
	private String categoria;
	private double precio;
	
	public Producto(int id, String nombre, String categoria, double precio) {
		
		this.id = id;
		this.nombre = nombre;
		this.categoria = categoria;
		this.precio = precio;
		
	}
	
	@Override
	public String toString() {
	    return "\tID: " + id + " | Nombre: " + nombre + " | Categoría: " + categoria + " | Precio: " + precio + "\n";
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	  @Override
	    public int compareTo(Producto emp) {
	        if (id == emp.getId()) {
	            return 0;
	        } else if (id < emp.getId()) {
	            return -1;
	        } else {
	            return 1;
	        }
	    }

}
