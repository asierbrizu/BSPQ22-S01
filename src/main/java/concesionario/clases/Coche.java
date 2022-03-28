package concesionario.clases;

import java.util.Objects;

public class Coche {
	
	private String matricula;
	private String color;
	private String marca;
	private String modelo;
	private double precioBase;
	
	public Coche() {
	}
	
	public Coche(String matricula, String color, String marca, String modelo, double precioBase) {
		super();
		this.matricula = matricula;
		this.color = color;
		this.marca = marca;
		this.modelo = modelo;
		this.precioBase = precioBase;
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
