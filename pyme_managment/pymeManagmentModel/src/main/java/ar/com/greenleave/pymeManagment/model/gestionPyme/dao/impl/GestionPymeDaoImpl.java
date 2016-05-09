package ar.com.greenleave.pymeManagment.model.gestionPyme.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Repository;

import ar.com.greenleave.pymeManagment.model.gestionPyme.dao.GestionPymeDao;
import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente.Country;
import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente.Person;
import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionEmpleados.Employee;
import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionEmpleados.HorarioLaboral;
import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionEmpleados.TypeOfEmployee;

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

	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeesByTypeEmployee(String typeEmployee) {
		Criteria criteria= getSession().createCriteria(Employee.class, "e");
		if(typeEmployee!=null){
			criteria.createAlias("e.typeOfEmplyee","te");
			criteria.add(Restrictions.eq("te.nombre", typeEmployee));
		}
		return criteria.list() ;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeesByTypeEmployeeId(Long id){
		
		Criteria criteria = getSession().createCriteria(Employee.class, "e");
		if(id!=null){
			criteria.createAlias("e.typeOfEmplyee","te");
			criteria.add(Restrictions.eq("te.id", id));
		}
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<TypeOfEmployee> getTypeEmployeesByLikeName(String name) {
		Criteria criteria = getSession().createCriteria(TypeOfEmployee.class, "te");
		if(name!=null){
			criteria.add(Restrictions.eq("nombre", name));
			return criteria.list();
		}else{
			return new ArrayList<TypeOfEmployee>();
		}
		
	}

	public List<HorarioLaboral> getHorariosLaboralesByHorario(Date dateIn, Date dateOut) {
		if(dateIn ==null && dateOut == null ){
			return new ArrayList<HorarioLaboral>();
		}
		else{
			Criteria criteria = getSession().createCriteria(HorarioLaboral.class, "hl");
			if(dateIn!=null){
				criteria.add(Restrictions.eq("horarioEntrada", dateIn));
			}
			if(dateOut != null){
				criteria.add(Restrictions.eq("horarioSalida", dateOut));
			}
				return criteria.list();
		}
	}
	
}