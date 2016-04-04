package ar.com.greenleave.pymeManagment.model.login;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="PM_USER")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="username")
	private String userName;
	
	@Column(name="password")
	private String password;

	@Column(name="email")
	private String email;
	
	@Type(type = "org.hibernate.type.NumericBooleanType")
	@Column(name="locked")
	private Boolean isLocked;
	
	
}
