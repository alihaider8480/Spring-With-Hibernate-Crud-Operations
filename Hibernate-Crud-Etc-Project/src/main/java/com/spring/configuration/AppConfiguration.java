package com.spring.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages={"com.spring.*"})
@PropertySource(value={"classpath:Hibernate.properties"})
public class AppConfiguration  
{ 
	@Autowired 
    private Environment environment;
	
	@Bean
	public DataSource dataSource() 
	{
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
		driverManagerDataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
		driverManagerDataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
		driverManagerDataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
		return driverManagerDataSource;
	}
	
	 @Bean
	 public LocalSessionFactoryBean sessionFactory() 
	 {
	     LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	     sessionFactory.setDataSource(dataSource());
         sessionFactory.setPackagesToScan(new String[] { "com.spring.pojo" });
	     sessionFactory.setHibernateProperties(hibernateProperties());
	   
	     return sessionFactory;
	 }
	 
	 @Bean           
	 public Properties hibernateProperties() 
	 {
		 Properties properties = new Properties();
		 properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
		 properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
		 properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));		
		 properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
		 return properties;        
       }
	 
	  @Bean
	  public HibernateTransactionManager transactionManager() 
	  {
	     HibernateTransactionManager txManager = new HibernateTransactionManager();
	     txManager.setSessionFactory(sessionFactory().getObject());
	     return txManager;
	  }
}
