package ar.com.greenleave.pymeManagment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**TODO 
 * 
 * esta clase va a servir para guardar las diferentes transacciones que realicen los clientes.
*/
@Entity
@Table(name="PM_FOLDER")
public class Folder {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="")


}
