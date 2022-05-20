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
@Table(name = "categoria")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c"),
		@NamedQuery(name = "Categoria.findByIdProducto", query = "SELECT c FROM Categoria c WHERE c.idCategoria = :idCategoria"),
		@NamedQuery(name = "Categoria.findByNombreCategoria", query = "SELECT c FROM Categoria c WHERE c.nombreCategoria = :nombreCategoria"),
		@NamedQuery(name = "Categoria.findByDescripcionCategoria", query = "SELECT c FROM Categoria c WHERE c.descripcionCategoria = :descripcionCategoria")
})
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idCategoria")
	private Integer idCategoria;
	
	@Column(name = "nombreCategoria")
	private String nombreCategoria;
	
	@Column(name = "descripcionCategoria")
	private String descripcionCategoria;

	
	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	public String getDescripcionCategoria() {
		return descripcionCategoria;
	}

	public void setDescripcionCategoria(String descripcionCategoria) {
		this.descripcionCategoria = descripcionCategoria;
	}

	public Categoria(Integer idCategoria, String nombreCategoria, String descripcionCategoria) {
		super();
		this.idCategoria = idCategoria;
		this.nombreCategoria = nombreCategoria;
		this.descripcionCategoria = descripcionCategoria;
	}

	public Categoria() {

	}

	public Categoria(Integer idCategoria, String nombreCategoria) {

		this.idCategoria = idCategoria;
		this.nombreCategoria = nombreCategoria;
	}
	
	@Override
	public int hashCode() {
		 int hash = 0;
		 hash += (idCategoria != null? idCategoria.hashCode():0);
		 return hash; 
	}
	
	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
	    if (!(object instanceof Categoria)) {
	        return false;
	    }
	    Categoria other = (Categoria) object;
	    if ((this.idCategoria == null && other.idCategoria != null) || (this.idCategoria != null && !this.idCategoria.equals(other.idCategoria))) {
	        return false;
	    }
	    return true;

	}
	
	@Override
	public String toString() {
	    return "idat.edu.pe.model.Categoria[ idCategoria=" + idCategoria + " ]";
	}

	public Categoria buscarPorID(int i) {
		// TODO Auto-generated method stub
		return null;
	}
}
