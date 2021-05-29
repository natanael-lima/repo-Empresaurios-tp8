package ar.edu.unju.fi.tp4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	
	/**
	 * Metodo que muestra la pagina de forma static
	 */
	@GetMapping("/index")
	public String getPage(Model model) {
		
		return "index";
	}

}
