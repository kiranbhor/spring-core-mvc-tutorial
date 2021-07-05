package day1.lab3;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DeptDAO {

	@Autowired
	@Qualifier(value = "sql")
	Connection connection;
	
	
	@Autowired
	DataSource ds;
	

	public void insert(Department dept) {
		
		JdbcTemplate template = new JdbcTemplate(ds);
		
		StringBuffer query = new StringBuffer().append("insert into dept values(");
		
		query.append(dept.getDeptId());
		query.append(",'");
		query.append(dept.getDeptName());
		query.append("')");
		
		System.out.println(query.toString());
		
		
		template.execute(query.toString());
		
		
	}	

}
