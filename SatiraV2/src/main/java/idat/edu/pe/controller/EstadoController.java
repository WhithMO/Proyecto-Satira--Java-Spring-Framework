package idat.edu.pe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import idat.edu.pe.model.Estado;
import idat.edu.pe.service.EstadoService;

@Controller
@RequestMapping("/estado")
public class EstadoController {
	
	@Autowired
	private EstadoService service;
	
	@RequestMapping("/listarTodo")
	public String listarEstados(Model model) {
		List<Estado> listaEstados = service.buscarTodo();
		
		System.out.println("LISTA DE Estados : " + listaEstados);
		
		model.addAttribute("listaEstados", listaEstados);
		return "/moduloEstados/listarTodo";
	}
	
	@RequestMapping("/nuevo")
	public String nuevoEstado(Model model) {
		Estado estado = new Estado();
		model.addAttribute("estado", estado);
		return "/moduloEstados/nuevoEstado";
		
	}
	
	@RequestMapping(value = "/guardar" , method = RequestMethod.POST)
	public String crearEstado(@ModelAttribute("estado") Estado estado) {
		    service.crear(estado);
		    return "redirect:/estado/listarTodo";
	
	}
	
	@RequestMapping(value = "/actualizar/{idEstado}")
	public ModelAndView editarEstado(@PathVariable(name="idEstado") int idEstado) {
		
		ModelAndView mav = new ModelAndView("/moduloEstados/editarEstado");
		Estado estado = service.buscarPorID(idEstado);
		mav.addObject("estado", estado );
		return mav;
		
	}
	
	@RequestMapping(value = "/eliminar/{idEstado}")
	public String eliminarEstado(@PathVariable(name="idEstado") int idEstado) {
		service.borrarPorID(idEstado);
		return "redirect:/estado/listarTodo";
	}
}
