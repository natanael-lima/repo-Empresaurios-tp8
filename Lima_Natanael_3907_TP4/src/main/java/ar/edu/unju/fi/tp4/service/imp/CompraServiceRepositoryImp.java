package ar.edu.unju.fi.tp4.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp4.model.Compra;
import ar.edu.unju.fi.tp4.repository.ICompraRepository;
import ar.edu.unju.fi.tp4.service.ICompraService;

@Service("tableCompraRepository")
public class CompraServiceRepositoryImp implements ICompraService{
	@Autowired
	private ICompraRepository compraRepository;

	@Override
	public void generarListaCompras() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void agregarCompra(Compra compra) {
		compraRepository.save(compra);
		
	}

	@Override
	public List<Compra> obtenerCompras() {
		// TODO Auto-generated method stub
		return (List<Compra>) compraRepository.findAll();
	}

	@Override
	public void eliminarCompra(int id) {
		compraRepository.deleteById(id);
		
	}

	@Override
	public Optional<Compra> buscarCompra(int id) {
		// TODO Auto-generated method stub
		return compraRepository.findById(id);
	}

	@Override
	public List<Compra> buscarCompras(String nombreProd, double monto) {
		List<Compra> compras = new ArrayList<Compra>();
		if (!nombreProd.isEmpty() && monto>=0) {
			compras = compraRepository.findByProductoNombreAndTotalGreaterThanEqual(nombreProd, monto);
		}else if (nombreProd.isEmpty() && monto>=0){
			compras = compraRepository.findByTotalGreaterThanEqual(monto);
		}
		return compras;
	}

	

}
