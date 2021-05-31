package ar.edu.unju.fi.tp4.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tp4.model.Compra;

public interface ICompraRepository extends CrudRepository<Compra, Integer>{
	
	public List<Compra> findByProductoNombreAndTotalGreaterThanEqual (String nombreProd, double monto);
	
	public List<Compra> findByTotalGreaterThanEqual (double monto);
	
}
