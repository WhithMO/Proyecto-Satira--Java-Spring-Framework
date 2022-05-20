package idat.edu.pe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.model.Categoria;

import idat.edu.pe.repository.CategoriaRepository;


@Service
@Transactional
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;
	
	public CategoriaService() {

	}
	
	//public List<Categoria> listarUsuarios() {
	//	return repository.findAll();
	//}
	
	public List<Categoria> buscarTodo() {
		return (List<Categoria>) repository.findAll();
	}

	public Categoria crear(Categoria categoria) {
		return repository.save(categoria);
	}
	
	public Categoria actualizar(Categoria categoriaActualizar) {

		Categoria categoriaActual = repository.findById(categoriaActualizar.getIdCategoria()).get();

		categoriaActual.setIdCategoria(categoriaActualizar.getIdCategoria());
		categoriaActual.setNombreCategoria(categoriaActualizar.getNombreCategoria());
		categoriaActual.setDescripcionCategoria(categoriaActualizar.getDescripcionCategoria());


		Categoria categoriaActualizado = repository.save(categoriaActual);

		return categoriaActualizado;

	}
	
	public Categoria buscarPorID(Integer idCategoria) {
		return repository.findById(idCategoria).get();

	}

	public void borrarPorID(Integer idCategoria) {
		repository.deleteById(idCategoria);
	}
	
}
