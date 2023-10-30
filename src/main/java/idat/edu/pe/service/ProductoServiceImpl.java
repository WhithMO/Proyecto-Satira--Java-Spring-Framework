package idat.edu.pe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.dao.IProductoDao;
import idat.edu.pe.model.Producto;

@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	private IProductoDao productoDao;
	
	@Override
	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		return productoDao.findAll();
	}

	@Override
	public void save(Producto producto) {
		productoDao.save(producto);
		
	}

	@Override
	public Producto findOne(Integer id) {

		return productoDao.findOne(id);
	}

	@Override
	public void delete(Integer id) {
		productoDao.delete(id);		
	}

	
}
