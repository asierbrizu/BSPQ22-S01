package concesionario.clases;

import java.util.Objects;

public class Compra {
	
	private String id;
	private Cliente cliente;
	private String matricula;
	private String fecha;
	private String id_coche;
	
	public Compra() {	
	}
	
	public Compra(String id, Cliente cliente, String matricula, String fecha, String id_coche) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.matricula = matricula;
		this.fecha = fecha;
		this.id_coche = id_coche;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
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

	

}
