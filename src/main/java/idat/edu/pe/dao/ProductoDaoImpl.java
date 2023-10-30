package idat.edu.pe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.model.Producto;

@Repository
public class ProductoDaoImpl implements IProductoDao {
	
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("from Producto").getResultList();
	}

	@Override
	@Transactional
	public void save(Producto producto) {
		em.persist(producto);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findOne(Integer id) {
		
		return em.find(Producto.class, id);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		
		Producto producto  = findOne(id);
		em.remove(producto);
	}

}
