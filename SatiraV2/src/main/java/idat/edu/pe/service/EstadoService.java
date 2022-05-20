package idat.edu.pe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.model.Estado;

import idat.edu.pe.repository.EstadoRepository;


@Service
@Transactional
public class EstadoService {

	@Autowired
	private EstadoRepository repository;

	public EstadoService() {

	}
	
	public List<Estado> buscarTodo() {
		return (List<Estado>) repository.findAll();
	}

	public Estado crear(Estado estado) {
		return repository.save(estado);
	}
	
	public Estado actualizar(Estado estadoActualizar) {

		Estado estadoActual = repository.findById(estadoActualizar.getIdEstado()).get();

		estadoActual.setIdEstado(estadoActualizar.getIdEstado());
		estadoActual.setNombre(estadoActualizar.getNombre());
		estadoActual.setDescripcion(estadoActualizar.getDescripcion());


		Estado estadoActualizado = repository.save(estadoActual);

		return estadoActualizado;
	}

	public Estado buscarPorID(Integer idEstado) {
		return repository.findById(idEstado).get();

	}

	public void borrarPorID(Integer idEstado) {
		repository.deleteById(idEstado);
	}
	
}
