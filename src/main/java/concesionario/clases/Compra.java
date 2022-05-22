package concesionario.clases;

import java.util.Objects;

public class Compra {
	
	private String id;
	private String cliente;
	private String matricula;
	private String fecha;
	private String id_coche;
	
	public Compra(String id, String cliente, String matricula, String fecha, String id_coche) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.matricula = matricula;
		this.fecha = fecha;
		this.id_coche = id_coche;
	}
	
	public Compra() {
		super();
		this.id = null;
		this.cliente = null;
		this.matricula = null;
		this.fecha = null;
		this.id_coche = null;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getId_coche() {
		return id_coche;
	}

	public void setId_coche(String id_coche) {
		this.id_coche = id_coche;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compra other = (Compra) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Compra [id=" + id + ", cliente=" + cliente + ", matricula=" + matricula + ", fecha=" + fecha
				+ ", id_coche=" + id_coche + "]";
	}

	

}
