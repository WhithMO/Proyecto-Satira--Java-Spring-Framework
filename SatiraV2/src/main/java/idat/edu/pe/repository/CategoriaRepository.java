package idat.edu.pe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.model.Categoria;

public interface CategoriaRepository  extends CrudRepository<Categoria, Integer>{
	
	@Query(value = "SELECT a FROM Producto a WHERE a.nombre =?1")
	public List<Categoria> buscarCategoriasPorNombre(String nombreCategoria);

	@Query(value = "SELECT a FROM Producto a WHERE a.nombre like CONCAT(?1, '%')")
	public List<Categoria> buscarCategoriaLikeNombre(String nombreCategoria);
}
