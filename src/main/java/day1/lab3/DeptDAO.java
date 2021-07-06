package day1.lab3;

import java.util.List;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class DeptDAO {

	@Autowired
	@Qualifier(value = "sql")
	Connection connection;

	@Autowired
	DataSource ds;

	@Autowired
	SessionFactory sf;
	
	@Autowired
	HibernateTemplate template;

	@Bean
	@Scope("singleton")
	HibernateTemplate hibernetTemplate() {
		System.out.println("getHibernateTemplate called");
		return new HibernateTemplate(sf);
	}

	public void insert(Department dept) {
		hibernetTemplate().save(dept);
	}

	public void update(int deptNo, Department newDept) {

		Department oldDept = template.get(Department.class, deptNo);
		oldDept.setDeptName(newDept.getDeptName());
		hibernetTemplate().save(oldDept);
	}

	public void delete(int deptNo) {
		Department dept = template.get(Department.class,deptNo);
		hibernetTemplate().delete(dept);
	}
	
	
	public void printDept() {
		List<Department> depts = template.loadAll(Department.class);
		
		for (Department department : depts) {
			System.out.println(department);
		}
	}
	
}
