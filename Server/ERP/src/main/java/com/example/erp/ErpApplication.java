package com.example.erp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.dao.UserDetailsReposistory;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableJpaRepositories("com.example.dao")
@EntityScan("com.example.model")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@ComponentScan(basePackages = { "com.example.service", "com.example.controller", "com.example.config" , "com.example.scheduler"})
@SpringBootApplication
@EnableScheduling
@EnableSwagger2
//@PropertySource("file:D:\\Spring\\application.properties")
public class ErpApplication {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UserDetailsReposistory userDetailsReposistory;

	public static void main(String[] args) {
		SpringApplication.run(ErpApplication.class, args);
		System.out.println("Server Running Successfully!!!");
	}

//Swagger Used for APIS	
	 @Bean
	   public Docket productApi() {
	      return new Docket(DocumentationType.SWAGGER_2).select()
	         .apis(RequestHandlerSelectors.basePackage("com.example.controller")).build();
	   }
//	@PostConstruct
//	public void init() {
//		List<Authority> authorityList = new ArrayList<>();
//
//		authorityList.add(createAuthority("USER", "Its a Basic User Role"));
//		authorityList.add(createAuthority("Admin", "Its a Basic Admin Role"));
//		
//		User user = new User();
//		user.setUserName("Siva");
//		user.setPassword(passwordEncoder.encode("Admin@123"));
//		user.setFirstName("Test");
//		user.setLastName("Sample");
//		user.setEnabled(true);
//		
//		
//		user.setAuthorities(authorityList);
//		
//		userDetailsReposistory.save(user);
//		
//
//	}

//	private Authority createAuthority(String roleCode, String roleDescription) {
//		Authority authority = new Authority();
//		authority.setRoleCode(roleCode);
//		authority.setRoleDescription(roleDescription);
//		return authority;
//
//	}

}
