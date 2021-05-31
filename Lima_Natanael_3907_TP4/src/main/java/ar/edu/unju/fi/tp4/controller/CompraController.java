package ar.edu.unju.fi.tp4.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp4.model.Compra;
import ar.edu.unju.fi.tp4.model.Producto;
import ar.edu.unju.fi.tp4.service.ICompraService;
import ar.edu.unju.fi.tp4.service.IProductoService;

@Controller
public class CompraController {

	@Autowired
	private Compra compra;

	@Autowired
	@Qualifier("tableCompraRepository")
	private ICompraService compraService;

	@Autowired
	@Qualifier("tableProductoRepository")
	private IProductoService productoService;

	// --------------------- TP5 ---------------------

	@GetMapping("/index/compra")
	public String getFormCompra(Model model) {

		model.addAttribute(compra);
		model.addAttribute("productos", productoService.obtenerListaProducto());
		return "nuevacompra";
	}

	@PostMapping("/index/guardarCompra")
	public String getGuardarCompra(@Valid @ModelAttribute("compra") Compra compra, BindingResult result, Model model) {
		String errorCompra = "";

		if (compra.getProducto() == null || result.hasErrors()) {
			model.addAttribute(compra);
			model.addAttribute("productos", productoService.obtenerListaProducto());
			model.addAttribute("texto", errorCompra);
			System.out.println("Hubo errores en el formulario");
			return "nuevacompra";
		} else {

			Producto producto = productoService.buscarProductoID(compra.getProducto().getCodigo());
			compra.setProducto(producto);

			if (compra.getCantidad() > producto.getStock()) {
				errorCompra = "No hay suficiente stock";
				model.addAttribute(compra);
				model.addAttribute("productos", productoService.obtenerListaProducto());
				model.addAttribute("texto", errorCompra);
				System.out.println("Hubo errores en el formulario");
				return "nuevacompra";
			} else {
				compra.setTotal(producto.getPrecio() * compra.getCantidad());
				compraService.agregarCompra(compra);
				model.addAttribute("compras", compraService.obtenerCompras());
				System.out.println("Se guardo con exito");
				return "mostrarcompra";
			}

		}
	}


	@GetMapping("/index/listadoCompra")
	public ModelAndView getCompraListado() {
		ModelAndView model = new ModelAndView("mostrarcompra");
		model.addObject(compra);
		model.addObject("compras", compraService.obtenerCompras());
		return model;
	}

	// --------------------- TP7 ---------------------

	// Controller Compra

	@GetMapping("/index/eliminarCompra/{id}")
	public ModelAndView getEliminarCompra(@PathVariable(value = "id") int param) {
		ModelAndView model = new ModelAndView("mostrarcompra");
		compraService.eliminarCompra(param);
		model.addObject("compras", compraService.obtenerCompras());
		return model;
	}

	@GetMapping("/index/modificarCompra/{id}")
	public String getModificarCompra(@PathVariable(value = "id") int param, Model model) {
		Optional<Compra> compras = compraService.buscarCompra(param);
		model.addAttribute("compra", compras);

		model.addAttribute("productos", productoService.obtenerListaProducto());
		return ("nuevacompra");
	}
	
	// --------------------- TP8 ---------------------
	
	@GetMapping("/index/buscarCompra")
	public String buscarCompraPorFiltro (@RequestParam(name="producto.nombre")String nombreProd, @RequestParam(name="total") double monto,Model model, @ModelAttribute(name="compra")Compra compra) {
		model.addAttribute(compra);
		model.addAttribute("compras", compraService.buscarCompras(nombreProd, monto));
		return "mostrarcompra";
	}

}
