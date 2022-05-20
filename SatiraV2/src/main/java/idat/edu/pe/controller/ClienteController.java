package idat.edu.pe.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import idat.edu.pe.model.Cliente;

import idat.edu.pe.service.ClienteService;
import idat.edu.pe.service.ProductoService;


@Controller
@RequestMapping("/contacto")
public class ClienteController {
	
	protected final Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	private ClienteService service;
	
	@Autowired
	private ProductoService productoService;
	
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping("/listarTodo")
	public String listarClientes(Model model, Authentication authentication, HttpServletRequest request) {
		
		// Listar Clientes
		List<Cliente> listaClientes = service.buscarTodo();
		System.out.println("LISTA DE Clientes : " + listaClientes);
		model.addAttribute("listaClientes", listaClientes);
		
		// en la autentificacion esta el USUARIO y contrase;a.
		
		// Usando directamente autentificacion.
		if(authentication != null) {
			logger.info("Hola usuario autenticado, tu username es: ".concat(authentication.getName()));
		}
		
		// Usando la forma estatica
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null) {
			logger.info("Utilizando forma estática SecurityContextHolder.getContext().getAuthentication(): Usuario autenticado: ".concat(auth.getName()));
		}
		
		//usando el Metodo que se ha creado mas abajo.
		if(hasRole("ROLE_ADMIN")) {
			logger.info("Hola ".concat(auth.getName()).concat(" tienes acceso!"));
		} else {
			logger.info("Hola ".concat(auth.getName()).concat(" NO tienes acceso!"));
		}
		
		// segunda forma de mostrar el usuario q se conectara a la cuenta
		SecurityContextHolderAwareRequestWrapper securityContext = new SecurityContextHolderAwareRequestWrapper(request, "");
		if(securityContext.isUserInRole("ROLE_ADMIN")) {
			logger.info("Forma usando SecurityContextHolderAwareRequestWrapper: Hola ".concat(auth.getName()).concat(" tienes acceso!"));
		} else {
			logger.info("Forma usando SecurityContextHolderAwareRequestWrapper: Hola ".concat(auth.getName()).concat(" NO tienes acceso!"));
		}
		
		
		// Tercera forma de como mostrar los datos en consola sobre el usuario usando el HTTP.
		if(request.isUserInRole("ROLE_ADMIN")) {
			logger.info("Forma usando HttpServletRequest: Hola ".concat(auth.getName()).concat(" tienes acceso!"));
		} else {
			logger.info("Forma usando HttpServletRequest: Hola ".concat(auth.getName()).concat(" NO tienes acceso!"));
		}	
		
		return "/moduloContactos/listarTodo";
	}
	
	
	@RequestMapping("/nuevo")
	public String nuevaCliente(Model model) {
		// Nuevo cliente
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
		
		// Combo box de PRODUCTOS
		model.addAttribute("listaproductos", productoService.buscarTodo());
		return "/moduloContactos/nuevoContacto";
	}
	
	
	@RequestMapping(value = "/guardar" , method = RequestMethod.POST)
	public String crearCliente(@ModelAttribute("cliente") Cliente cliente) {
		    service.crear(cliente);
		    return "redirect:/home";
	
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/actualizar/{idCliente}")
	public ModelAndView editarCliente(@PathVariable(name="idCliente") int idCliente, Model model) {
		
		model.addAttribute("listaproductos", productoService.buscarTodo());
		
		ModelAndView mav = new ModelAndView("/moduloContactos/editarContacto");
		Cliente cliente = service.buscarPorID(idCliente);
		mav.addObject("cliente", cliente );
		return mav;
		
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/eliminar/{idCliente}")
	public String eliminarCliente(@PathVariable(name="idCliente") int idCliente) {
		service.borrarPorID(idCliente);
		return "redirect:/contacto/listarTodo";
		
	}
	
	
	// Este es un metodo para poder usarlo en los metodos anteriores para VALIDAR los ROLES.
	private boolean hasRole(String role) {
		
		SecurityContext context = SecurityContextHolder.getContext();
		
		if(context == null) {
			return false;
		}
		
		Authentication auth = context.getAuthentication();
		
		if(auth == null) {
			return false;
		}
		
		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
		
		/*
		for(GrantedAuthority authority: authorities) {
			if(role.equals(authority.getAuthority())) {
				logger.info("Hola usuario ".concat(auth.getName()).concat(" tu role es: ".concat(authority.getAuthority())));
				return true;
			}
		}
		*/
		
		return authorities.contains(new SimpleGrantedAuthority(role));
	}

}
