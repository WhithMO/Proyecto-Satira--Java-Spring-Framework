package idat.edu.pe.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import idat.edu.pe.model.Cliente;

import idat.edu.pe.service.ClienteService;


@RestController
@RequestMapping("/rest/contacto")
public class ClienteRestController {

	@Autowired
	private ClienteService servicio;
	
	@GetMapping
	public ResponseEntity<Object> buscarTodo() {
		List<Cliente> listaCliente = servicio.buscarTodo();
		return new ResponseEntity<> (listaCliente, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public ResponseEntity<Object> buscarPorId(@PathVariable("id") int id) {
		Cliente cliente = servicio.buscarPorID(id);
		if (cliente == null)

			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Contacto no encontrado,id porporcionado no es correcto");
		return new ResponseEntity<Object>(cliente, HttpStatus.OK);
	}
	
	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Object> crear(@RequestBody Cliente cliente) {
		servicio.crear(cliente);
		return new ResponseEntity<Object>("Contacto creado correctamente", HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Object> actualizar(@PathVariable("id") int id, @RequestBody Cliente cliente) {
		servicio.actualizar(cliente);
		return new ResponseEntity<Object>("Contacto actualizado correctamente", HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> borrar(@PathVariable("id") int id) {
		servicio.borrarPorID(id);
		return new ResponseEntity<Object>("Contacto eliminado correctamente", HttpStatus.OK);
	}
}
