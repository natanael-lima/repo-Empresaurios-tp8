package ar.edu.unju.fi.tp4.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp4.model.Cliente;
import ar.edu.unju.fi.tp4.model.Compra;
import ar.edu.unju.fi.tp4.service.IClienteService;
import ar.edu.unju.fi.tp4.service.ICompraService;
import ar.edu.unju.fi.tp4.service.ICuentaService;
import ar.edu.unju.fi.tp4.model.Producto;
import ar.edu.unju.fi.tp4.repository.ICuentaRepository;
import ar.edu.unju.fi.tp4.service.IProductoService;


@Controller
public class IndexController {
	
	
	@Autowired
    private Producto producto;
	
	@Autowired
    private Cliente cliente;
	
	@Autowired
	private Compra compra;
	 
	 @Autowired
	 @Qualifier("tableClienteRepository")
	 private IClienteService clienteService;
	 
	 @Autowired
	 @Qualifier("tableCompraRepository")
	 private ICompraService compraService;
	 
	 @Autowired
	 @Qualifier("tableProductoRepository")
	 private IProductoService productoService;
	 
	 @Autowired
	 @Qualifier("tableCuentaRepository")
	 private ICuentaService cuentaService;
	
	/**
	 * Metodo que muestra la pagina de forma static
	 */
	@GetMapping("/index")
	public String getPage(Model model) {
		
		return "index";
	}
	
	@GetMapping("/index/producto")
	public String getPageProd(Model model) {
		model.addAttribute(producto);
		return "nuevoprod";
	}
	
	/**
	 * Metodo de proceso de guardar producto
	 */
	@PostMapping("/index/guardar")
	public String getProceso(@ModelAttribute("producto") Producto producto,Model model ) {
		productoService.agregarList(producto);
		
		model.addAttribute("productos",productoService.obtenerListaProducto());
    	return "mostrarprod";
	}
	
	/**
	 * Metodo de proceso de mostrar el ultimo producto cargado
	 */
	@GetMapping("/index/ultimo")
	public String getProcesoUltimo( Model model ) {
		model.addAttribute("productos",productoService.obtenerListaProducto());
    	return "mostrarprod";
	}
	
	 
	@GetMapping("/index/cliente")
	public String getPageMain(Model model) {
		model.addAttribute(cliente);
		return "nuevocliente";
	}
	 
	
	@PostMapping("/index/guardarcliente")
	public ModelAndView getProcesoGuardar(@ModelAttribute("cliente") Cliente cliente ) {
		ModelAndView model = new ModelAndView("mostrarclientes");
		clienteService.agregarCliente(cliente);
		model.addObject("clientes",clienteService.obtenerClientes());
		model.addObject("cuentas",cuentaService.obtenerCuentas());
		return model;
	}
	
	 @GetMapping("/index/listado")
	 public ModelAndView getProcesoListado() {
		ModelAndView model = new ModelAndView("mostrarclientes");
	
		model.addObject("clientes",clienteService.obtenerClientes());
		model.addObject("cuentas",cuentaService.obtenerCuentas());
		return model;
   	}
	 
	//Index del tp5 Compras
	
	@GetMapping("/index/compra")
	public String getFormCompra(Model model) {
	
		model.addAttribute(compra);
		model.addAttribute("productos",productoService.obtenerListaProducto());
		model.addAttribute("clientes",clienteService.obtenerClientes());
		
		return "nuevacompra";
	}
	 
	@PostMapping("/index/guardarCompra")
	public String getGuardarCompra(@ModelAttribute("compra") Compra compra,Model model) {
		String errorCompra="";
		Producto producto=productoService.buscarProductoID(compra.getProducto().getCodigo());
		compra.setProducto(producto); 
		if(compra.getCantidad()>producto.getStock()) {
			errorCompra="No hay suficiente stock";
			model.addAttribute(compra);
			model.addAttribute("productos",productoService.obtenerListaProducto());
			model.addAttribute("texto",errorCompra);
			return "nuevacompra";
		}else {
			
			compra.setTotal(producto.getPrecio()*compra.getCantidad());
			compraService.agregarCompra(compra);
			model.addAttribute("compras",compraService.obtenerCompras());
			
			return "mostrarcompra";
		}
		
	
		
		
		
		
		
	}
	
	@GetMapping("/index/listadoCompra")
	 public ModelAndView getCompraListado() {
		 ModelAndView model = new ModelAndView("mostrarcompra");
		
		model.addObject("compras",compraService.obtenerCompras());
		return model;
  	}
	
	//--------------------- TP7 ---------------------
	
	// Controller Cliente
	@GetMapping("/index/eliminar/{id}")
	 public ModelAndView getEliminarCliente(@PathVariable(value="id") int param) {
		 ModelAndView model = new ModelAndView("mostrarclientes");
		 clienteService.eliminarCliente(param);
		 model.addObject("clientes",clienteService.obtenerClientes());
		 return model;
  	}
	 
	@GetMapping("/index/modificar/{id}")
	 public ModelAndView getModificarCliente(@PathVariable(value="id") int param) {
		 ModelAndView model = new ModelAndView("nuevocliente");
		 Optional<Cliente> cliente = clienteService.buscarCliente(param);
		 model.addObject("cliente",cliente);
		 return model;
 	}
	
	// Controller Compra
		@GetMapping("/index/eliminarCompra/{id}")
		 public ModelAndView getEliminarCompra(@PathVariable(value="id") int param) {
			 ModelAndView model = new ModelAndView("mostrarcompra");
			 compraService.eliminarCompra(param);
			 model.addObject("compras",compraService.obtenerCompras());
			 return model;
	  	}
		 
		@GetMapping("/index/modificarCompra/{id}")
		 public String getModificarCompra(@PathVariable(value="id") int param,Model model) {
			 Optional<Compra> compras = compraService.buscarCompra(param);
			 model.addAttribute("compra",compras);
			 
			
			 
			 model.addAttribute("productos",productoService.obtenerListaProducto());
			 model.addAttribute("clientes",clienteService.obtenerClientes());
			 return ("nuevacompra");
	 	}
	
		// Controller Producto
				@GetMapping("/index/eliminarProducto/{id}")
				 public ModelAndView getEliminarProducto(@PathVariable(value="id") int param) {
					 ModelAndView model = new ModelAndView("mostrarprod");
					 productoService.eliminarProducto(param);
					 model.addObject("productos",productoService.obtenerListaProducto());
					 return model;
			  	}
				 
				@GetMapping("/index/modificarProducto/{id}")
				 public ModelAndView getModificarProducto(@PathVariable(value="id") int param) {
					 ModelAndView model = new ModelAndView("nuevoprod");
					 Optional<Producto> producto = productoService.buscarProducto(param);
					 model.addObject("producto",producto);
					 return model;
			 	}
	
}
