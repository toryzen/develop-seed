package cn.company;

import cn.company.project.filter.SecurityFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@EnableConfigurationProperties
@SpringBootApplication
@MapperScan("cn.company.project.dao")
public class Application {

	protected final Logger logger=LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) throws IOException {
		SpringApplication.run(Application.class, args);
	}

	@Configuration
	public class FilterConfig {
		@Bean
		public FilterRegistrationBean filterRegist() {
			FilterRegistrationBean frBean = new FilterRegistrationBean();
			frBean.setFilter(new SecurityFilter());
			frBean.addUrlPatterns("/api/*");
			return frBean;
		}
	}
}