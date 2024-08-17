//
//package com.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@EnableWebSecurity
//
//@Configuration
//
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
//public class WebSecurityConfig extends WebSecurityConfiguration {
//
//	private static final String[] StudentList = {
//
//			"/", "/register", "/login", "/about", "/add",
//
//			"/assets/css/**", "/assets/img/**", "/assets/scss/**", "/assets/js/**", "/assets/lib/**",
//
//	};
//
//	@Bean
//	public static PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//
//	}
//
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
//
//		security
//		.authorizeRequests()
//		.requestMatchers(StudentList)
//		.permitAll()
//		.anyRequest()
//		.authenticated()
//		.and()
//				
//		.formLogin()
//		.loginPage("/login")
//		.loginProcessingUrl("/login")
//		.usernameParameter("emailString")
//		.passwordParameter("passwordString")
//		.defaultSuccessUrl("/", true)
//		.failureUrl("/login?error")
//		.permitAll()
//		.and()
//		.logout()
//		.logoutUrl("logout")
//	    .logoutSuccessUrl("/logout?success")
//		.and()
//		.httpBasic()
//		.disable();
//
//		return security.build();
//
//	}
//
//}