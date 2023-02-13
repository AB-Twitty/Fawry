package FawrySystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import FawrySystem.Filters.AuthFilter;

@SpringBootApplication
@Component
public class FawrySystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(FawrySystemApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean<AuthFilter> filterRegistrationBean() {
		FilterRegistrationBean<AuthFilter> registrationBean = new FilterRegistrationBean<>();
		AuthFilter authFilter = new AuthFilter();
		registrationBean.setFilter(authFilter);
		registrationBean.addUrlPatterns("/Wallet/*");
		registrationBean.addUrlPatterns("/Transaction/*");
		registrationBean.addUrlPatterns("/Refund/*");
		registrationBean.addUrlPatterns("/Service/*");
		registrationBean.addUrlPatterns("/Discount/*");
		return registrationBean;
	}
}
