package com.collage.light.dao;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Repository;

import com.collage.light.dao.AbstractDao;
import com.collage.light.dao.EmployeeDao;
import com.collage.light.model.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl extends AbstractDao<Integer, Employee> implements EmployeeDao {

	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		return getByKey(id);
	}

	@Override
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		persist(employee);

	}

	@Override
	public void deleteEmployeeBySsn(String ssn) {
		// TODO Auto-generated method stub
		Query query = getSession().createSQLQuery("delete from Employee where ssn = :ssn");
		query.setString("ssn", ssn);
		query.executeUpdate();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findAllEmployees() {
		// TODO Auto-generated method stub
		Criteria criteria = createEntityCriteria();
		return (List<Employee>) criteria.list();
	}

	@Override
	public Employee findEmployeeBySsn(String ssn) {
		// TODO Auto-generated method stub
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("ssn", ssn));
		return (Employee) criteria.uniqueResult();
	}

	@Override
	public Long getNext() {
		// TODO Auto-generated method stub
		Query query = getSession().createSQLQuery("select student_seq.nextval as num from dual").addScalar("num", StandardBasicTypes.BIG_INTEGER);
		return ((BigInteger) query.uniqueResult()).longValue();
	}

}
