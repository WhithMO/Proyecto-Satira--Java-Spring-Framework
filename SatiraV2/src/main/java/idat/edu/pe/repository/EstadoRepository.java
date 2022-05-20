package idat.edu.pe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.model.Estado;

public interface EstadoRepository extends CrudRepository<Estado, Integer>{
	@Query(value = "SELECT a FROM Producto a WHERE a.nombre =?1")
	public List<Estado> buscarEstadosPorNombre(String nombre);

	@Query(value = "SELECT a FROM Producto a WHERE a.nombre like CONCAT(?1, '%')")
	public List<Estado> buscarEstadoLikeNombre(String nombre);
}
