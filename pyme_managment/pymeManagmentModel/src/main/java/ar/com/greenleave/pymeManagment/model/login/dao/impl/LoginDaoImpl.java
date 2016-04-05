package ar.com.greenleave.pymeManagment.model.login.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Repository;

import ar.com.greenleave.pymeManagment.model.gestionCliente.dao.impl.GestionClienteDaoImpl;
import ar.com.greenleave.pymeManagment.model.login.User;
import ar.com.greenleave.pymeManagment.model.login.dao.LoginDao;

@Repository(value = "loginDao")
public class LoginDaoImpl extends LoginHibernateDaoHelper implements LoginDao {

	@SuppressWarnings("unused")
	private final static Logger logger = Logger.getLogger(GestionClienteDaoImpl.class);
	
	@SuppressWarnings("unchecked")
	public User login(String userName, String password) {
		Criteria c=  getSession().createCriteria(User.class,"u");
		c.add(Restrictions.eq("userName", userName));
		c.add(Restrictions.eq("password", password));
		
		List<User> usuarios=c.list();
		return usuarios.size()==1? usuarios.get(0) : null;
	}

}
