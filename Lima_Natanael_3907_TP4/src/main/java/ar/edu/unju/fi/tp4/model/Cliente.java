package ar.edu.unju.fi.tp4.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;


@Entity
@Table(name = "CLIENTES")
@Component
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cli_codigo")
	private long codigo;
	@Column(name = "cli_tipoDocumento")
	private String tipoDocumento;
	@Column(name = "cli_nroDocumento")
	private int nroDocumento;
	@Column(name = "cli_nombreApellido")
	private String nombreApellido;
	@Column(name = "cli_mail")
	private String mail;
	@Column(name = "cli_password")
	private String password;
	@Column(name = "cli_fechaNacimiento")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate fechaNacimiento;

	@Column(name = "cli_codigoAreaTelefono")
	private int codigoAreaTelefono;
	@Column(name = "cli_nroTelefono")
	private int nroTelefono;

	
	@Autowired
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "cuenta_id")
	private Cuenta cuenta;
	
	public Cuenta getCuenta() {
		return cuenta;
	}


	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}


	public Cliente() {
		
	}


	public Cliente(String tipoDocumento, int nroDocumento, String nombreApellido, String mail, String password,
			LocalDate fechaNacimiento, int codigoAreaTelefono, int nroTelefono) {
		super();
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDocumento;
		this.nombreApellido = nombreApellido;
		this.mail = mail;
		this.password = password;
		this.fechaNacimiento = fechaNacimiento;

		this.codigoAreaTelefono = codigoAreaTelefono;
		this.nroTelefono = nroTelefono;

	}

	

	public long getCodigo() {
		return codigo;
	}


	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}


	public String getTipoDocumento() {
		return tipoDocumento;
	}


	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}


	public int getNroDocumento() {
		return nroDocumento;
	}


	public void setNroDocumento(int nroDocumento) {
		this.nroDocumento = nroDocumento;
	}


	public String getNombreApellido() {
		return nombreApellido;
	}


	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public int getCodigoAreaTelefono() {
		return codigoAreaTelefono;
	}


	public void setCodigoAreaTelefono(int codigoAreaTelefono) {
		this.codigoAreaTelefono = codigoAreaTelefono;
	}


	public int getNroTelefono() {
		return nroTelefono;
	}


	public void setNroTelefono(int nroTelefono) {
		this.nroTelefono = nroTelefono;
	}


	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", tipoDocumento=" + tipoDocumento + ", nroDocumento=" + nroDocumento
				+ ", nombreApellido=" + nombreApellido + ", mail=" + mail + ", password=" + password
				+ ", fechaNacimiento=" + fechaNacimiento + ", codigoAreaTelefono=" + codigoAreaTelefono
				+ ", nroTelefono=" + nroTelefono + ", cuenta=" + cuenta + "]";
	}




	
  
	
}
