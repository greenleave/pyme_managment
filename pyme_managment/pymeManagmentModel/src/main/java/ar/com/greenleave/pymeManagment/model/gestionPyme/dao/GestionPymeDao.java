package ar.com.greenleave.pymeManagment.model.gestionPyme.dao;

import java.util.List;

import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente.Country;
import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente.Person;
import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionEmpleados.Employee;
import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionEmpleados.TypeOfEmployee;

public interface GestionPymeDao {

	List<Country> getCountries(Country country);

	List<Person> getPersons(Person person);

	List<Employee> getEmployeesByTypeEmployee(String typeEmployee);

	List<Employee> getEmployeesByTypeEmployeeId(Long id);

	List<TypeOfEmployee> getTypeEmployeesByLikeName(String name);
}
