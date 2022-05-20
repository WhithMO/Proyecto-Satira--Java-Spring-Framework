package idat.edu.pe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.model.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Integer> {
	@Query(value = "SELECT a FROM Producto a WHERE a.nombre =?1")
	public List<Producto> buscarProductosPorNombre(String nombre);

	@Query(value = "SELECT a FROM Producto a WHERE a.nombre like CONCAT(?1, '%')")
	public List<Producto> buscarProductoLikeNombre(String nombre);
}
