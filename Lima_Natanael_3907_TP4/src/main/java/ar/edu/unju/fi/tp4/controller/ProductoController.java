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
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp4.model.Producto;
import ar.edu.unju.fi.tp4.service.IProductoService;

@Controller
public class ProductoController {

	@Autowired
	private Producto producto;

	@Autowired
	@Qualifier("tableProductoRepository")
	private IProductoService productoService;

	@GetMapping("/index/producto")
	public String getPageProd(Model model) {
		model.addAttribute(producto);
		return "nuevoprod";
	}

	@PostMapping("/index/guardar")
	public String getProceso(@Valid @ModelAttribute("producto") Producto producto, BindingResult result, Model model) {
		
		if(result.hasErrors()){
			
			model.addAttribute(producto);
			System.out.println("Hubo errores en el formulario");
			return "nuevoprod";
		}
		productoService.agregarList(producto);
		model.addAttribute("productos", productoService.obtenerListaProducto());
		System.out.println("Guardo con exito");
		return "mostrarprod";
	}

	@GetMapping("/index/ultimo")
	public String getProcesoUltimo(Model model) {
		model.addAttribute("productos", productoService.obtenerListaProducto());
		
		return "mostrarprod";
	}

	// --------------------- TP7 ---------------------

	// Controller Producto
	@GetMapping("/index/eliminarProducto/{id}")
	public ModelAndView getEliminarProducto(@PathVariable(value = "id") int param) {
		ModelAndView model = new ModelAndView("mostrarprod");
		productoService.eliminarProducto(param);
		model.addObject("productos", productoService.obtenerListaProducto());
		return model;
	}

	@GetMapping("/index/modificarProducto/{id}")
	public ModelAndView getModificarProducto(@PathVariable(value = "id") int param) {
		ModelAndView model = new ModelAndView("nuevoprod");
		Optional<Producto> producto = productoService.buscarProducto(param);
		model.addObject("producto", producto);
		return model;
	}

}
