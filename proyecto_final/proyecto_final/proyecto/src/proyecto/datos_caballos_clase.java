package proyecto;

import java.io.Serializable;

public class datos_caballos_clase  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String nombre;
	String raza;
	String capa;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public String getCapa() {
		return capa;
	}
	public void setCapa(String capa) {
		this.capa = capa;
	}
}
