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

import idat.edu.pe.model.Categoria;
import idat.edu.pe.service.CategoriaService;


@Controller
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaService service;
	
	@RequestMapping("/listarTodo")
	public String listarCategorias(Model model) {
		List<Categoria> listaCategorias = service.buscarTodo();
		
		System.out.println("LISTA DE Categorias : " + listaCategorias);
		
		model.addAttribute("listaCategorias", listaCategorias);
		return "/moduloCategorias/listarTodo";
	}
	
	@RequestMapping("/nuevo")
	public String nuevaCategoria(Model model) {
		Categoria categoria = new Categoria();
		model.addAttribute("categoria", categoria);
		return "/moduloCategorias/nuevaCategoria";
		
	}
	
	@RequestMapping(value = "/guardar" , method = RequestMethod.POST)
	public String crearCategoria(@ModelAttribute("categoria") Categoria categoria) {
		    service.crear(categoria);
		    return "redirect:/categoria/listarTodo";
	
	}
	
	@RequestMapping(value = "/actualizar/{idCategoria}")
	public ModelAndView editarCategoria(@PathVariable(name="idCategoria") int idCategoria) {
		
		ModelAndView mav = new ModelAndView("/moduloCategorias/editarCategoria");
		Categoria categoria = service.buscarPorID(idCategoria);
		mav.addObject("categoria", categoria );
		return mav;
		
	}
	
	@RequestMapping(value = "/eliminar/{idCategoria}")
	public String eliminarCategoria(@PathVariable(name="idCategoria") int idCategoria) {
		service.borrarPorID(idCategoria);
		return "redirect:/categoria/listarTodo";
		
	}
}
