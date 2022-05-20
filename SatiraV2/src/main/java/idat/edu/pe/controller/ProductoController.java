package idat.edu.pe.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import idat.edu.pe.model.Producto;
import idat.edu.pe.service.CategoriaService;
import idat.edu.pe.service.EstadoService;
import idat.edu.pe.service.IProductoService;
import idat.edu.pe.service.ProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	@Autowired
	private ProductoService service;
	
	@Autowired
	private IProductoService iproductoService;

	@Autowired
	private CategoriaService categoriaService;

	@Autowired
	private EstadoService estadoService;
	
	@GetMapping(value="/detalle/{idproducto}")
	public String ver(@PathVariable(value="idproducto") Integer idproducto, Map<String, Object> model) {
		
		Producto producto = iproductoService.findOne(idproducto);
		if(producto == null) {
			//flash.addAttribute("error", "El producto no existe en la bbbd.");
			return "redirect:/producto/listarTodo";
		}
		
		model.put("producto", producto);
		model.put("titulo", producto.getNombre());
		
		return "/moduloProductos/frmDetalleProducto";
	}

	@RequestMapping("/listarTodo")
	public String listarProductos(Model model) {

		List<Producto> listaProductos = service.buscarTodo();

		System.out.println("LISTA DE PRODUCTOS : " + listaProductos);

		model.addAttribute("listaProductos", listaProductos);
		return "/moduloProductos/listarTodo";
	}
 
	@RequestMapping("/nuevo")
	public String nuevoProducto(Model model) {

		// traemos el servicio de CATEGORIA para usarlo en el COMBOBOX
		model.addAttribute("listacategorias", categoriaService.buscarTodo());

		// traemos el servicio de ESTADO para usarlo en el COMBOBOX
		model.addAttribute("listaestados", estadoService.buscarTodo());

		Producto producto = new Producto();
		model.addAttribute("producto", producto);
		return "/moduloProductos/nuevoProducto";

	}

	@RequestMapping(value = "/guardar" , method = RequestMethod.POST)
	public String crearProducto(@ModelAttribute("producto") Producto producto, @RequestParam("file") MultipartFile imagen) {
		
		if(!imagen.isEmpty()) {
			Path directorioRecursos = Paths.get("src//main//resources//static/archivos");
			String rootPath = directorioRecursos.toFile().getAbsolutePath();
			try {
				byte[] bytes = imagen.getBytes();
				Path rutaCompleta = Paths.get(rootPath + "//" + imagen.getOriginalFilename());
				Files.write(rutaCompleta, bytes);
				//flash.addFlashAttribute("info", "Has subido correctamente " + foto.get)
				producto.setImagen(imagen.getOriginalFilename());
				
			}
			catch (IOException e){
				e.printStackTrace();
			}
			
		}
		
		    service.crear(producto);
		    return "redirect:/producto/listarTodo";
	
	}

	@RequestMapping(value = "/actualizar/{idproducto}")
	public ModelAndView editarProducto(@PathVariable(name = "idproducto") int idproducto, Model model) {

		// traemos el servicio de CATEGORIA para usarlo en el COMBOBOX
		model.addAttribute("listacategorias", categoriaService.buscarTodo());
		// traemos el servicio de ESTADO para usarlo en el COMBOBOX
		model.addAttribute("listaestados", estadoService.buscarTodo());

		ModelAndView mav = new ModelAndView("/moduloProductos/editarProducto");
		Producto producto = service.buscarPorID(idproducto);
		mav.addObject("producto", producto);
		return mav;

	}

	@RequestMapping(value = "/eliminar/{idproducto}")
	public String eliminarProducto(@PathVariable(name = "idproducto") int idproducto) {
		service.borrarPorID(idproducto);
		return "redirect:/producto/listarTodo";

	}
}
