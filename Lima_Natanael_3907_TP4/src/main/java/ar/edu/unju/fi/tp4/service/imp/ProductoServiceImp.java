package ar.edu.unju.fi.tp4.service.imp;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.tp4.model.Producto;
import ar.edu.unju.fi.tp4.service.IProductoService;

@Service("tableProductos")
public class ProductoServiceImp implements IProductoService {
	
	private static final Log LOGGER = LogFactory.getLog(ProductoServiceImp.class);
    @Autowired
	
    private List<Producto> productoList;
    
    /**
     * Metodo de agregar el producto
     */
	@Override
	public void agregarList(Producto producto) {
		
		LOGGER.info("SERVICE: IProductoService -> ProductoServiceImp");
		LOGGER.info("METHOD: agregarList()");
		LOGGER.info("RESULT:a object Producto");
		LOGGER.info("Resultado Producto: "+producto);
		productoList.add(producto);
	}
	public List<Producto> obtenerListaProducto(){
		return productoList;
	}
	
	/**
     * Metodo de obtener el producto de la lista
     */
     public Producto obtenerList() {
	    int count= productoList.size();
		Producto prod = productoList.get(count-1);
		return prod;
	}
     @Override
 	public Producto mostrarUltimoProducto() {

 		return productoList.get(productoList.size()-1);
 		
 	}
	@Override
	public void eliminarProducto(int id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Optional<Producto> buscarProducto(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Producto buscarProductoID(int id) {
		// TODO Auto-generated method stub
		return null;
	}
     

}
