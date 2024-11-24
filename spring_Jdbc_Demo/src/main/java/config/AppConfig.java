package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.darshan.spring_Jdbc_Demo.Repo.EmployeeImplRepo;
import com.darshan.spring_Jdbc_Demo.model.Employee;

@Configuration
public class AppConfig {

	@Bean
	@Scope("prototype")
	public Employee employee() {
		return new Employee();
	}

	@Bean
	public DriverManagerDataSource dataSource() {

		DriverManagerDataSource source = new DriverManagerDataSource();

		source.setDriverClassName("org.postgresql.Driver");
		source.setUrl("jdbc:postgresql://localhost:5432/postgres");
		source.setUsername("postgres");
		source.setPassword("data@123");
		return source;
	}

	@Bean
	public JdbcTemplate template(@Autowired DriverManagerDataSource ds) {

		JdbcTemplate template = new JdbcTemplate();
		
		template.setDataSource(ds);
		
		return template;
	}

	@Bean
	public EmployeeImplRepo employeeRepo(@Autowired JdbcTemplate template) {

		EmployeeImplRepo repo = new EmployeeImplRepo();

		repo.setTemplate(template);

		return repo;
	}
}
