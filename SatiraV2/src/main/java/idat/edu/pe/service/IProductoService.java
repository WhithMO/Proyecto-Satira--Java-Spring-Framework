package idat.edu.pe.service;

import java.util.List;

import idat.edu.pe.model.Producto;

public interface IProductoService {

	public List<Producto> findAll();
	
	public void save(Producto producto);
	
	public Producto findOne(Integer id);
	
	public void delete(Integer id);
}
