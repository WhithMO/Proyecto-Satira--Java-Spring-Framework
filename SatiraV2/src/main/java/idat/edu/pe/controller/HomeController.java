package idat.edu.pe.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

import idat.edu.pe.model.Categoria;
import idat.edu.pe.model.Cliente;
import idat.edu.pe.model.Producto;
import idat.edu.pe.service.CategoriaService;

import idat.edu.pe.service.ProductoService;

@Controller
public class HomeController {
	
	@Autowired
	private CategoriaService service;
	@Autowired
	private ProductoService productoService;
	
	
	@RequestMapping(value = {"/home", "/"})
	public String paginaInicio(Model model) {
		return "home";
	}
	
	@RequestMapping("/sedes")
	public String sedeLista(Model model) {
		return "nuestrasTiendas";
	}
	
	@RequestMapping("/nosotros")
	public String paginaNosotros(Model model) {
		return "nosotros";
	}
	
	@RequestMapping("/catalogo")
	public String paginaCatalogo(Model model) {
		List<Categoria> listaCategorias = service.buscarTodo();
		model.addAttribute("listaCategorias", listaCategorias);
		
		List<Producto> listaProductos = productoService.buscarTodo();
		model.addAttribute("listaProductos", listaProductos);
		
		
		return "/moduloProductos/frmCatalogoProducto";
	}
}
