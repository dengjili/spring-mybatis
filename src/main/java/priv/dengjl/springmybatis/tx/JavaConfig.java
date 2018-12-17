package priv.dengjl.springmybatis.tx;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

@Configuration
@ComponentScan(basePackages={"priv.dengjl.springmybatis.*"})
@EnableTransactionManagement
public class JavaConfig implements TransactionManagementConfigurer{
	
	private DataSource dataSource;

	@Bean("dataSource")
	public DataSource getDataSource() {
		if (dataSource != null) {
			return dataSource;
		}
		
		Properties properties = new Properties();
		properties.setProperty("driverClassName", "com.mysql.cj.jdbc.Driver");
		properties.setProperty("url", "jdbc:mysql://127.0.0.1:3306/test");
		properties.setProperty("username", "root");
		properties.setProperty("password", "root");
		
		try {
			dataSource = BasicDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			return null;
		}
		
		return dataSource;
	}
	
	@Bean("jdbcTemplate")
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}

	@Bean("transactionManager")
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
		dataSourceTransactionManager.setDataSource(getDataSource());
		return dataSourceTransactionManager;
	}
}
