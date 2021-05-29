package ar.edu.unju.fi.tp4.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tp4.model.Producto;

public interface IProductoService {
    
	/**
	 * Interface para agregar producto
	 * @param producto
	 */
	public void agregarList(Producto producto);
	
	/**
	 * Interface para obtener producto
	 * @param producto
	 */
	public List<Producto> obtenerListaProducto();
	public Producto obtenerList();
	
	public Producto mostrarUltimoProducto();
	public void eliminarProducto(int id);
	public Optional<Producto> buscarProducto(int id);
	
	public Producto buscarProductoID(int id);
}
