package proyecto;

import java.io.Serializable;

public class datos_pupilaje implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String fecha_nacimiento;
	String fecha_herrado;
	String fecha_veterinario;
	String fecha_desparasitado;
	String fecha_pienso;
	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(String nacimiento2) {
		this.fecha_nacimiento = nacimiento2;
	}
	public String getFecha_herrado() {
		return fecha_herrado;
	}
	public void setFecha_herrado(String fecha_herrado) {
		this.fecha_herrado = fecha_herrado;
	}
	public String getFecha_veterinario() {
		return fecha_veterinario;
	}
	public void setFecha_veterinario(String fecha_veterinario) {
		this.fecha_veterinario = fecha_veterinario;
	}
	public String getFecha_desparasitado() {
		return fecha_desparasitado;
	}
	public void setFecha_desparasitado(String fecha_desparasitado) {
		this.fecha_desparasitado = fecha_desparasitado;
	}
	public String getFecha_pienso() {
		return fecha_pienso;
	}
	public void setFecha_pienso(String fecha_pienso) {
		this.fecha_pienso = fecha_pienso;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
