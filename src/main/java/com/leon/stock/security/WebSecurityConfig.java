package com.leon.stock.security;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.leon.stock.filter.JwtAuthFilter;
import com.leon.stock.service.JwtService;
import com.nimbusds.jose.jwk.source.ImmutableSecret;

@Configuration
public class WebSecurityConfig {

	private String jwtKey = "ec8aaa345ff51c0f2fc71f63e7f679667fe35976c54f648dcfcdcc27937b353406b13ec952ee8e41b1588381618bdd465f844e048da00507540806e3b82c005ff98e0334f198c069fece2990dc99a48c12ec517eeba94e58e4033e4934caec869b1a8ce90593f8a621359915cdb44dc1dde84ae857ad254a9223949a25b1bfa5fa63a0cdaf1cdbab324a1bc9a24f55179da96074d7894d46a27c61e18bfc50968c278a86a1db5935f4e43b095c3f2f5ffd83003931dec6dc05ad4ca523fc04729f66993fc4b6aa0535b5c4f90e8c11f3157b977d60e22afb28472afbd2ee3cdc611330cbafbf459da6f5c0d51a36c3bbc33178dc4c5a475dd3b0e098030cfe04";

//	   @Autowired
//	   private JwtAuthFilter jwtAuthFilter; 
	   

//	@Bean
//	public JwtAuthFilter jwtAuthFilter() {
//		return new JwtAuthFilter(jwtService); // Injectez JwtService dans JwtAuthFilter
//	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http.csrf(csrf -> csrf.disable()).cors(Customizer.withDefaults())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests(
						(auth) -> auth.requestMatchers("/", "/login").permitAll()
						.anyRequest().authenticated())
				.httpBasic(Customizer.withDefaults())
				.oauth2ResourceServer((oauth2) -> oauth2.jwt(Customizer.withDefaults()))
				.addFilterBefore(new JwtAuthFilter(jwtDecoder()), UsernamePasswordAuthenticationFilter.class).build();
	}

	@Bean
	public UserDetailsService users() {
		UserDetails user = User.builder().username("user").password(passwordEncoder().encode("password")).roles("USER")
				.build();
		return new InMemoryUserDetailsManager(user);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public JwtDecoder jwtDecoder() {
		SecretKeySpec secretKey = new SecretKeySpec(this.jwtKey.getBytes(), 0, this.jwtKey.getBytes().length, "RSA");
		return NimbusJwtDecoder.withSecretKey(secretKey).macAlgorithm(MacAlgorithm.HS256).build();
	}

	@Bean
	public JwtEncoder jwtEncoder() {
		return new NimbusJwtEncoder(new ImmutableSecret<>(this.jwtKey.getBytes()));
	}

	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("http://localhost:4200/");
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}

}
