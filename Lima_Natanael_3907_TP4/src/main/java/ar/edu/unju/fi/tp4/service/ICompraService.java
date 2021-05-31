package ar.edu.unju.fi.tp4.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tp4.model.Compra;


public interface ICompraService {
	
	
	public void generarListaCompras();
	
	public void agregarCompra(Compra compra);
	
	public List<Compra> obtenerCompras();
	
	public void eliminarCompra(int id);
	
	public Optional<Compra> buscarCompra(int id);
	
	public List<Compra> buscarCompras (String nombreProd, double monto);
	
}
