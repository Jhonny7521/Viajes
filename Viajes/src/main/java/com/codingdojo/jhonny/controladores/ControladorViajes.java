package com.codingdojo.jhonny.controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.jhonny.modelos.Gasto;
import com.codingdojo.jhonny.servicios.ServicioViajes;

@Controller//indico que es un controlador
@RequestMapping("/expenses")
public class ControladorViajes {

	private final ServicioViajes servicio;
	 
	public ControladorViajes(ServicioViajes servicio) {
		this.servicio = servicio;
	}
	
	@RequestMapping(value= "", method= RequestMethod.GET)
	public String index(Model model) {
		List<Gasto> lista_gastos = servicio.get_gastos();
		
		model.addAttribute("lista_gastos", lista_gastos);
		
		return "index.jsp";
	}
	
	@RequestMapping(value= "/new", method= RequestMethod.GET)
	public String new_expense(@ModelAttribute("gasto") Gasto gasto) {
		return "new.jsp";
	}
	
	//@RequestMapping(value= "/create", method= RequestMethod.GET)
	@PostMapping("/create")
	public String create(@Valid @ModelAttribute("gasto") Gasto gasto,
						 BindingResult result) {
		if(result.hasErrors()) {
			return "new.jsp";
		}else {
			servicio.save_gasto(gasto);
			return "redirect:/expenses";
		}
	}
	
	@RequestMapping(value= "/delete/{id_url}", method= RequestMethod.DELETE)
	public String eliminate(@PathVariable("id_url") Long id) {
		servicio.delete_gasto(id);
		return "redirect:/expenses";
	}
	
	//model --> envia del controlador a jsp
	//modelatribute relisa ina instancia de la clase Gasto y la nombro gastp
	//@RequestMapping(value= "/edit/{id_url}")
	@GetMapping(value= "/edit/{id_url}")
	public String edit(@PathVariable("id_url") Long id, 
					   Model model, 
					   @ModelAttribute("gasto") Gasto gasto) {
		
		Gasto gasto_edit = servicio.find_gasto(id);
		model.addAttribute("gasto", gasto_edit);
		return "edit.jsp";
	}
	
	
}
