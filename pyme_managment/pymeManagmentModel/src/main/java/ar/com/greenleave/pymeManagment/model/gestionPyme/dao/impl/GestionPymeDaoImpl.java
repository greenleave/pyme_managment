package ar.com.greenleave.pymeManagment.model.gestionPyme.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Repository;

import ar.com.greenleave.pymeManagment.model.gestionPyme.dao.GestionPymeDao;
import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente.Country;
import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente.Person;

@Repository(value = "gestionPymeDao")
public class GestionPymeDaoImpl extends HibernateDaoHelper implements GestionPymeDao {
	
	@SuppressWarnings("unused")
	private final static Logger logger = Logger.getLogger(GestionPymeDaoImpl.class);

	@SuppressWarnings("unchecked")
	public List<Country> getCountries(Country country) {
		// Le especifico que tiene que traer la clase Country y el alias de esta es c
		Criteria c= getSession().createCriteria(Country.class, "c");
		if(country!=null){
			if(country.getCountry()!=null){
				c.add(Restrictions.like("country", country.getCountry()));
			}
				
			if(country.getCodPhone()!=null){
				c.add(Restrictions.like("codPhone", country.getCodPhone()));
			}
				
			if(country.getCountryCode()!=null){
				c.add(Restrictions.eq("countryCode", country.getCountryCode()));
			}
			
		}
		return c.list();
	}

	@SuppressWarnings("unchecked")
	public List<Person> getPersons(Person person) {
		Criteria c= getSession().createCriteria(Person.class, "p");
		if(person!=null){
			if(person.getDocument()!=null){
				c.add(Restrictions.eq("document", person.getDocument()));
			}
//			if(person.getAdress()!=null) // aca era la magia en la que tenia que crear un nuevo alias para que no me rompa demasiado las pelotas a la hora de filtrar.
		}
		return c.list();
	}
	
}