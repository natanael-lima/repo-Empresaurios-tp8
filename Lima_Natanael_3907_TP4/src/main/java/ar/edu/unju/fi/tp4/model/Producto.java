package ar.edu.unju.fi.tp4.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "PRODUCTOS")
public class Producto {

	/**
	 * Atributos
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pro_codigo")
	private int codigo;
	@Column(name = "pro_nombre")
	@NotEmpty(message = "Falta nombre")
	@Size(min = 2, message = "El nombre no debe ser vacío, como mínimo 3 caracteres")
	private String nombre;
	@Column(name = "pro_precio")
	@Min(value = 10)
	private double precio;
	@Column(name = "pro_marca")
	@NotEmpty(message = "Falta marca")
	@Size(min = 3, message = "La marca no debe ser vacío, como mínimo 4 caracteres")
	private String marca;
	@Column(name = "pro_stock")
	@Min(value = 1, message = "Valor minimo 1")
	private int stock;
	@Valid
	@OneToMany(mappedBy = "producto")
	private List<Compra> compras;

	public Producto() {

	}

	public Producto(int codigo, String nombre, double precio, String marca, int stock) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.marca = marca;
		this.stock = stock;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", marca=" + marca
				+ ", stock=" + stock + "]";
	}

}