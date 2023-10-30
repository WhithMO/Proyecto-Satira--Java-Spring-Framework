package idat.edu.pe.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "producto")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
		@NamedQuery(name = "Producto.findByIdProducto", query = "SELECT p FROM Producto p WHERE p.idProducto = :idProducto"),
		@NamedQuery(name = "Producto.findByNombre", query = "SELECT p FROM Producto p WHERE p.nombre = :nombre"),
		@NamedQuery(name = "Producto.findByDescripcion", query = "SELECT p FROM Producto p WHERE p.descripcion = :descripcion"),
		@NamedQuery(name = "Producto.findByPresentacion", query = "SELECT p FROM Producto p WHERE p.presentacion= presentacion"),
		@NamedQuery(name = "Producto.findByPrecio", query = "SELECT p FROM Producto p WHERE p.precio = :precio"),
		@NamedQuery(name = "Producto.findByContenido", query = "SELECT p FROM Producto p WHERE p.contenido = :contenido"),
		@NamedQuery(name = "Producto.findByIbu", query = "SELECT p FROM Producto p WHERE p.ibu = :ibu"),
		@NamedQuery(name = "Producto.findByVolumen", query = "SELECT p FROM Producto p WHERE p.volumen = :volumen"),
		@NamedQuery(name = "Producto.findByMarca", query = "SELECT p FROM Producto p WHERE p.marca = :marca"),
		@NamedQuery(name = "Producto.findByStock", query = "SELECT p FROM Producto p WHERE p.stock = :stock"),
		@NamedQuery(name = "Producto.findByIdEstado", query = "SELECT p FROM Producto p WHERE p.idEstado = :idEstado"),
		@NamedQuery(name = "Producto.findByProcedencia", query = "SELECT p FROM Producto p WHERE p.procedencia = :procedencia")

})
public class Producto {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idproducto")
	private Integer idProducto;
	

	@Column(name = "nombre")
	private String nombre;
	

	@Column(name = "descripcion")
	private String descripcion;
	

	@Column(name = "presentacion")
	private String presentacion;
	

	@Column(name = "precio")
	private Float precio;
	

	@Column(name = "contenido")
	private String contenido;
	

	@Column(name = "ibu")
	private String ibu;
	

	@Column(name = "volumen")
	private String volumen;
	

	@Column(name = "marca")
	private String marca;
	

	@Column(name = "stock")
	private Integer stock;
	

	@Column(name = "idEstado")
	private Integer idEstado;
	

	@Column(name = "procedencia")
	private String procedencia;
	

	@Column(name = "idCategoria")
	private Integer idCategoria;
	

	@Column(name = "imagen")
	private String imagen;
	
	/*
    @JoinColumn(name = "cliente", referencedColumnName = "idCliente")			
    @ManyToOne(optional = false)
    private Cliente cliente;
	 */

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getPresentacion() {
		return presentacion;
	}

	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getIbu() {
		return ibu;
	}

	public void setIbu(String ibu) {
		this.ibu = ibu;
	}

	public String getVolumen() {
		return volumen;
	}

	public void setVolumen(String volumen) {
		this.volumen = volumen;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public String getProcedencia() {
		return procedencia;
	}

	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	public Producto() {
		
	}
	 
	public Producto(Integer idProducto, String nombre, String descripcion, String presentacion, Float precio,
			String contenido, String ibu, String volumen, String marca, Integer stock, Integer idEstado,
			String procedencia, Integer idCategoria, String imagen) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.presentacion = presentacion;
		this.precio = precio;
		this.contenido = contenido;
		this.ibu = ibu;
		this.volumen = volumen;
		this.marca = marca;
		this.stock = stock;
		this.idEstado = idEstado;
		this.procedencia = procedencia;
		this.idCategoria = idCategoria;
		this.imagen = imagen;

	}
	
	

	@Override
	public int hashCode() {
		 int hash = 0;
		 hash += (idProducto != null? idProducto.hashCode():0);
		 return hash; 
	}
	
	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
	    if (!(object instanceof Producto)) {
	        return false;
	    }
	    Producto other = (Producto) object;
	    if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
	        return false;
	    }
	    return true;

	}
	
	@Override
	public String toString() {
	    return "idat.edu.pe.model.Producto[ idProducto=" + idProducto + " ]";
	}

	public Producto buscarPorID(int i) {
		// TODO Auto-generated method stub
		return null;
	}
}
