package idat.edu.pe.model;

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
@Table(name = "estado")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Estado.findAll", query = "SELECT e FROM Estado e"),
		@NamedQuery(name = "Estado.findByIdEstado", query = "SELECT e FROM Estado e WHERE e.idEstado = :idEstado"),
		@NamedQuery(name = "Estado.findByNombre", query = "SELECT e FROM Estado e WHERE e.nombre = :nombre"),
		@NamedQuery(name = "Estado.findByDescripcion", query = "SELECT e FROM Estado e WHERE e.descripcion = :descripcion")
})
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idEstado")
	private Integer idEstado;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "descripcion")
	private String descripcion;

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
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

	public Estado(Integer idEstado, String nombre, String descripcion) {
		super();
		this.idEstado = idEstado;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public Estado() {

	}

	public Estado(Integer idEstado, String nombre) {
		super();
		this.idEstado = idEstado;
		this.nombre = nombre;
	}
	
	@Override
	public int hashCode() {
		 int hash = 0;
		 hash += (idEstado != null? idEstado.hashCode():0);
		 return hash; 
	}
	
	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
	    if (!(object instanceof Estado)) {
	        return false;
	    }
	    Estado other = (Estado) object;
	    if ((this.idEstado == null && other.idEstado != null) || (this.idEstado != null && !this.idEstado.equals(other.idEstado))) {
	        return false;
	    }
	    return true;

	}
	
	@Override
	public String toString() {
	    return "idat.edu.pe.model.Estado[ idEstado=" + idEstado + " ]";
	}

	public Estado buscarPorID(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
