package proyecto;

import java.io.Serializable;

public class datos_compra implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 private String id;
	 private String productos;
	 private int cantidad;
	 private String precio;
	 private int precio_final;
	 
	public int getPrecio_final() {
		return precio_final;
	}
	public void setPrecio_final(int precio_final) {
		this.precio_final = precio_final;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProductos() {
		return productos;
	}
	public void setProductos(String productos) {
		this.productos = productos;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad2) {
		this.cantidad = cantidad2;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
