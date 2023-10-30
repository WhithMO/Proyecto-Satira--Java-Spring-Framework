package idat.edu.pe.model;

import java.io.Serializable;


import javax.persistence.Basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Cliente.findAll", query = "SELECT e FROM Cliente e"),
		@NamedQuery(name = "Cliente.findByIdCliente", query = "SELECT e FROM Cliente e WHERE e.idCliente = :idCliente"),
		@NamedQuery(name = "Cliente.findByNombre", query = "SELECT e FROM Cliente e WHERE e.nombre = :nombre"),
		@NamedQuery(name = "Cliente.findByApellidos", query = "SELECT e FROM Cliente e WHERE e.apellidos = :apellidos"),
		@NamedQuery(name = "Cliente.findByCorreo", query = "SELECT e FROM Cliente e WHERE e.correo = :correo"),
		@NamedQuery(name = "Cliente.findByDescripcion", query = "SELECT e FROM Cliente e WHERE e.descripcion = :descripcion")
})
public class Cliente implements Serializable{

	public static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idCliente")
	private Integer idCliente;
	
	@Basic(optional = false)
	@Column(name = "nombre")
	private String nombre;
	
	@Basic(optional = false)
	@Column(name = "apellidos")
	private String apellidos;
	
	@Basic(optional = false)
	@Column(name = "correo")
	private String correo;
	
	@Basic(optional = false)
	@Column(name = "descripcion")
	private String descripcion;
	
	@Basic(optional = false)
	@Column(name = "idProducto")
	private Integer idProducto;
    

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public Cliente(Integer idCliente, String nombre, String apellidos, String correo, String descripcion,
			Integer idProducto) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.descripcion = descripcion;
		this.idProducto = idProducto;
	}

	public Cliente() {

	}

	@Override
	public int hashCode() {
		 int hash = 0;
		 hash += (idCliente != null? idCliente.hashCode():0);
		 return hash; 
	}
	
	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
	    if (!(object instanceof Estado)) {
	        return false;
	    }
	    Cliente other = (Cliente) object;
	    if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
	        return false;
	    }
	    return true;

	}
	
	
	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + "]";
	}
	
	public Cliente buscarPorID(int i) {
		
		return null;
	}
	
	
}
