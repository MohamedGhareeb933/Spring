package com.luv2code.springsecurity.demo.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration // Configuration Class
@EnableWebMvc // provides similar support to <mvc:annotatin-driven> To read @Controllers.
@ComponentScan(basePackages="com.luv2code.springsecurity.demo") // which packages to scan to look forward for Controllers
@PropertySource("classpath:persistence-mysql.properties") // read properties file. // classpath is prebuilt in maven director src/main/resources
public class DemoAppConfig implements WebMvcConfigurer {
	
	// hold the data in properties file
	// auto wire and read properties file names and values .
	@Autowired
	private Environment env;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	// define a bean for a ViewResolver
	// this bean handle the prefix and suffix of the value returning from string controller EX:(/WEB-INF/view/"customer-list".jsp)
	@Bean
	public ViewResolver viewResolver() {
			
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;	
	}

	// serving up /css directory 
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations("/css/");
	}
	
	// define a bean for security data source.
	// data source is an alternative to DriverManager and used to get connection to jdbc driver.
	@Bean
	public DataSource securityDataSource() {
		
		// create a connection pool.
		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
		
		try {
			// set the jdbc driver class
			// read properties from file.
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver")); 
			
			// log the connection props
			logger.info(">>> jdbc.url" + env.getProperty("jdbc.url"));
			logger.info(">>> jdbc.username" + env.getProperty("jdbc.user"));
			
		} catch (PropertyVetoException exc) {
			throw new RuntimeException(exc); // throw new exception instance.
		}finally {
			//A return statement inside a finally block will cause any exception that might be thrown in the try or catch block to be discarded.
		}
		
			// set db connection url. username and password
			securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
			securityDataSource.setUser(env.getProperty("jdbc.user"));
			securityDataSource.setPassword(env.getProperty("jdbc.password"));
					
			// set a connection pool props.
			securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
			securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize")); 
			securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
			securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
		
		return securityDataSource;
	}
		
	// read the environment property and convert to int. - helper method
	private int getIntProperty(String propName) {
		// get the property 
		String propVal = env.getProperty(propName);
			
		// convert the property that passed in the arg into int.
		return Integer.parseInt(propVal);
	}
	
}
