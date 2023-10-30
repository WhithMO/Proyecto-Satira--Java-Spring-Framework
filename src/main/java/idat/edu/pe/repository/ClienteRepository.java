package idat.edu.pe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer>{

	@Query(value = "SELECT a FROM Cliente a WHERE a.nombre =?1")
	public List<Cliente> buscarClientesPorNombre(String nombreCliente);

	@Query(value = "SELECT a FROM Cliente a WHERE a.nombre like CONCAT(?1, '%')")
	public List<Cliente> buscarClienteLikeNombre(String nombreCliente);
}
