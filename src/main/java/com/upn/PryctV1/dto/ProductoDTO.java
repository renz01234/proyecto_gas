package com.upn.PryctV1.dto;

public class ProductoDTO {
	
	private int codProducto;
    private String nomMarca;
    private double precio;
    private String tamano;
    
    public ProductoDTO() {
    	
    }

	public ProductoDTO(int codProducto, String nomMarca, double precio, String tamano) {
		this.codProducto = codProducto;
		this.nomMarca = nomMarca;
		this.precio = precio;
		this.tamano = tamano;
	}

	public int getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(int codProducto) {
		this.codProducto = codProducto;
	}

	public String getNomMarca() {
		return nomMarca;
	}

	public void setNomMarca(String nomMarca) {
		this.nomMarca = nomMarca;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getTamano() {
		return tamano;
	}

	public void setTamano(String tamano) {
		this.tamano = tamano;
	}
	
    
}
