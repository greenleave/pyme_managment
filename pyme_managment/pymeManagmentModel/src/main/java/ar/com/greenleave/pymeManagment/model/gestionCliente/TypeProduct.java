package ar.com.greenleave.pymeManagment.model.gestionCliente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PM_TYPE_PRODUCT")
public class TypeProduct {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="DESCRIPTION")
	private String descripcion;
	
	/**
	 * En caso de necesitar un "tipo de subproducto"
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_PADRE")
	private TypeProduct father;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public TypeProduct getFather() {
		return father;
	}

	public void setFather(TypeProduct father) {
		this.father = father;
	}
	
}
