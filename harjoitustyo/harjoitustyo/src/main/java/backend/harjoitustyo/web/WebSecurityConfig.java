package backend.harjoitustyo.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class WebSecurityConfig {
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http
 				.csrf(csrf -> csrf.ignoringRequestMatchers("/api/**", "/retket/**", "/retket/{id}/**"))

				.authorizeHttpRequests(authorize -> authorize

						.requestMatchers("/", "/login", "/koti", "/css/**", "/kuvat/**", "/retket", "/retket/**")
						.permitAll()
						.anyRequest().authenticated())
				.formLogin(formlogin -> formlogin
						.loginPage("/login")
						.defaultSuccessUrl("/retkilista", true)
						.permitAll())
				.logout(logout -> logout
						.permitAll());
		return http.build();
	}

}
