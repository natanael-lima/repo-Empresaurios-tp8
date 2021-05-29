package ar.edu.unju.fi.tp4.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp4.model.Producto;
import ar.edu.unju.fi.tp4.repository.IProductoRepository;
import ar.edu.unju.fi.tp4.service.IProductoService;
@Service("tableProductoRepository")
public class ProductoServiceRepositoryImp implements IProductoService{
	
	@Autowired
    private IProductoRepository productoRepository;
	
	@Override
	public void agregarList(Producto producto) {
		productoRepository.save(producto);
		
	}

	@Override
	public List<Producto> obtenerListaProducto() {
		// TODO Auto-generated method stub
		return (List<Producto>) productoRepository.findAll();
	}

	@Override
	public Producto obtenerList() {
		return null;
	}

	@Override
	public Producto mostrarUltimoProducto() {
		return null;
	}

	@Override
	public void eliminarProducto(int id) {
		productoRepository.deleteById(id);
		
	}

	@Override
	public Optional<Producto> buscarProducto(int id) {
		// TODO Auto-generated method stub
		return productoRepository.findById(id);
	}

	@Override
	public Producto buscarProductoID(int id) {
		// TODO Auto-generated method stub
		return productoRepository.findById(id).orElse(null);
	}
	
	

}
