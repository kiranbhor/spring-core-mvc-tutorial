package day1.lab3;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan
//@ImportResource("classpath:demo1.xml")
public class Demo3Application {
	
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource("jdbc:mysql://localhost:3306/springlab","kiran","innovation");
		return ds;
	}

	public static void main(String[] args) {
		
		
		ApplicationContext appContext = new AnnotationConfigApplicationContext(Demo3Application.class);
		System.out.println("Context Loaded");
		DeptDAO dao = appContext.getBean("deptDAO",DeptDAO.class);
		dao.insert(new Department(10,"Marketing"));

	}

}
