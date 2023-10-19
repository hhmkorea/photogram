package com.cos.photogramstart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	BCryptPasswordEncoder encode() { // 암호화
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
				.antMatchers("/", "/user/**", "/image/**", "/subscribe/**", "/comment/**").authenticated()
				.anyRequest().permitAll()
				.and()
				.formLogin()
				.loginPage("/auth/signin") // GET
				.loginProcessingUrl("/auth/signin") // POST -> Spring Security가 로그인 프로세스 진행
				.defaultSuccessUrl("/");
		return http.build();
	}
}
