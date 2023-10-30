package idat.edu.pe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.model.Cliente;
import idat.edu.pe.repository.ClienteRepository;

@Service
@Transactional
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	public ClienteService() {

	}
	
	public List<Cliente> buscarTodo() {
		return (List<Cliente>) repository.findAll();
	}

	public Cliente crear(Cliente cliente) {
		return repository.save(cliente);
	}
	
	public Cliente actualizar(Cliente clienteActualizar) {

		Cliente clienteActual = repository.findById(clienteActualizar.getIdCliente()).get();

		clienteActual.setIdCliente(clienteActualizar.getIdCliente());
		clienteActual.setNombre(clienteActualizar.getNombre());
		clienteActual.setApellidos(clienteActualizar.getApellidos());
		clienteActual.setCorreo(clienteActualizar.getCorreo());
		clienteActual.setDescripcion(clienteActualizar.getDescripcion());


		Cliente clienteActualizado = repository.save(clienteActual);

		return clienteActualizado;

	}
	
	public Cliente buscarPorID(Integer idCliente) {
		return repository.findById(idCliente).get();

	}

	public void borrarPorID(Integer idCliente) {
		repository.deleteById(idCliente);
	}
	
	
}
