package ar.edu.unju.fi.tp4.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="CUENTAS")
public class Cuenta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cuenta_id")
	private long id;
	@Column(name = "cuenta_saldo")
	@NotNull(message = "Debes introducir un saldo")
	@Min(value=1,message="Minimo valor 1")
	private double saldo;
	@Column(name = "cuenta_fechaCreacion")
	@NotNull(message = "Debes introducir una fecha")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate fechaCreacion;
	@Column(name = "cuenta_estado")
	@NotNull(message = "Debes introducir un estado")
	private String estado; //ACTIVA, INACTIVA 
	
	@Autowired
	@OneToOne(mappedBy = "cuenta",fetch = FetchType.LAZY)
	private Cliente Cliente;
	
	public Cuenta() {
		
	}

	public Cuenta(long id, double saldo, LocalDate fechaCreacion, String estado) {
		super();
		this.id = id;
		this.saldo = saldo;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Cuenta [id=" + id + ", saldo=" + saldo + ", fechaCreacion=" + fechaCreacion + ", estado=" + estado
				+ "]";
	}
	
	
	
}
