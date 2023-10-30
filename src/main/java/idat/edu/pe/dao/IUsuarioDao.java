package idat.edu.pe.dao;

import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.model.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long>{

	public Usuario findByUsername(String username);
}
