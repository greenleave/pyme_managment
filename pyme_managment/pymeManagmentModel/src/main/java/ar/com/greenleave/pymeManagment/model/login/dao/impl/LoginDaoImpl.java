package ar.com.greenleave.pymeManagment.model.login.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Repository;

import ar.com.greenleave.pymeManagment.model.gestionPyme.dao.impl.GestionPymeDaoImpl;
import ar.com.greenleave.pymeManagment.model.login.User;
import ar.com.greenleave.pymeManagment.model.login.dao.LoginDao;

@Repository(value = "loginDao")
public class LoginDaoImpl extends LoginHibernateDaoHelper implements LoginDao {

	@SuppressWarnings("unused")
	private final static Logger logger = Logger.getLogger(GestionPymeDaoImpl.class);
	
	@SuppressWarnings("unchecked")
	public User login(String userName, String password) {
		Criteria c=  getSession().createCriteria(User.class,"u");
		//Añado las restricciones para poder comparar si existe el username y ese password
		c.add(Restrictions.eq("userName", userName));
		c.add(Restrictions.eq("password", password));
		
		List<User> usuarios=c.list();
	
		if(usuarios.size()==1){
			 User user = usuarios.get(0);
			 user.setLastLogin(new Date());
			 getSession().update(user);
			 return user;
		}
		return null;
		
		
	}
	
	
	@SuppressWarnings("unchecked")
	public User getUserByEmail(String email) {
		Criteria c = getSession().createCriteria(User.class, "u");
		c.add(Restrictions.eq("u.email", email));
		List<User> usuarios = c.list();
		return usuarios.size()==1? usuarios.get(0) : null;
	}

	@SuppressWarnings("unchecked")
	public User getUserByUserName(String userName) {
		//La clase que voy a traer y el alias
		Criteria c = getSession().createCriteria(User.class, "u");
		c.add(Restrictions.eq("u.userName", userName));
		List<User> usuarios = c.list();
		return usuarios.size()==1? usuarios.get(0) : null;
	}


	public Boolean existUserByUserName(String userName) {
		Criteria c = getSession().createCriteria(User.class, "u");
		c.add(Restrictions.eq("u.userName", userName));
		return c.list().size() == 1 ;
	}


	public Boolean existUserByEmail(String email) {
		Criteria c = getSession().createCriteria(User.class, "u");
		c.add(Restrictions.eq("u.email", email));
		return c.list().size() == 1 ;
	}


	public Boolean existUserByName(String name) {
		Criteria c = getSession().createCriteria(User.class, "u");
		c.add(Restrictions.eq("u.name", name));
		return c.list().size() == 1 ;
	}
	

}
