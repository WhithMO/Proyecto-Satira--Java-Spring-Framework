package idat.edu.pe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.model.Producto;
import idat.edu.pe.repository.ProductoRepository;

@Service
@Transactional
public class ProductoService {
	
	@Autowired
	private ProductoRepository repository;

	public ProductoService() {

	}

	public List<Producto> buscarTodo() {
		return (List<Producto>) repository.findAll();
	}

	public Producto crear(Producto producto) {
		return repository.save(producto);
	}

	public Producto actualizar(Producto productoActualizar) {

		Producto productoActual = repository.findById(productoActualizar.getIdProducto()).get();

		productoActual.setIdProducto(productoActualizar.getIdProducto());
		productoActual.setNombre(productoActualizar.getNombre());
		productoActual.setDescripcion(productoActualizar.getDescripcion());
		productoActual.setPresentacion(productoActualizar.getPresentacion());
		productoActual.setPrecio(productoActualizar.getPrecio());
		productoActual.setContenido(productoActualizar.getContenido());
		productoActual.setIbu(productoActualizar.getIbu());
		productoActual.setVolumen(productoActualizar.getVolumen());
		productoActual.setMarca(productoActualizar.getMarca());
		productoActual.setStock(productoActualizar.getStock());
		productoActual.setIdEstado(productoActualizar.getIdEstado());
		productoActual.setProcedencia(productoActualizar.getProcedencia());
		productoActual.setIdCategoria(productoActualizar.getIdCategoria());
		productoActual.setImagen(productoActualizar.getImagen());


		Producto productoActualizado = repository.save(productoActual);

		return productoActualizado;

	}

	public Producto buscarPorID(Integer idProducto) {
		return repository.findById(idProducto).get();

	}

	public void borrarPorID(Integer idProducto) {
		repository.deleteById(idProducto);
	}
}
