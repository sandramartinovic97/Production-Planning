package project.productionplanning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;

@SpringBootApplication //(exclude = SqlInitializationAutoConfiguration.class)
public class ProductionPlanningApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductionPlanningApplication.class, args);
	}

	/*@Bean
	public ServletRegistrationBean h2servletRegistration() {
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
		registrationBean.addUrlMappings("/h2-console/*");
		return registrationBean;
	}*/
}
