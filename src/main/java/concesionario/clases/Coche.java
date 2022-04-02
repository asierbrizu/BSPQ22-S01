package concesionario.clases;

import java.util.ArrayList;
import java.util.Objects;

public class Coche {
	
	private String idCoche;
	
	
	private String matricula;
	private String color;
	private String marca;
	private String modelo;
	private double precioBase;
	private String imagen;
	private ArrayList<Extra> extras = new ArrayList();
	 
	public Coche(String idCoche, String matricula, String color, String marca, String modelo, double precioBase,
			String imagen, ArrayList<Extra> extras) {
		super();
		this.idCoche = idCoche;
		this.matricula = matricula;
		this.color = color;
		this.marca = marca;
		this.modelo = modelo;
		this.precioBase = precioBase;
		this.imagen = imagen;
		this.extras = extras;
	}


	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}
	
	

	public ArrayList<Extra> getExtras() {
		return extras;
	}

	public void setExtras(ArrayList<Extra> extras) {
		this.extras = extras;
	}

	public String getIdCoche() {
		return idCoche;
	}


	public void setIdCoche(String idCoche) {
		this.idCoche = idCoche;
	}


	public String getImagen() {
		return imagen;
	}



	public void setImagen(String imagen) {
		this.imagen = imagen;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coche other = (Coche) obj;
		return Objects.equals(matricula, other.matricula);
	}

	
}
