/*
 * package com.ait.security;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.core.userdetails.User; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import
 * org.springframework.security.crypto.password.PasswordEncoder; import
 * org.springframework.security.provisioning.InMemoryUserDetailsManager; import
 * org.springframework.security.web.SecurityFilterChain;
 * 
 * @Configuration public class SecurityConfig {
 * 
 * @Bean public SecurityFilterChain securityFilterChain(HttpSecurity http)
 * throws Exception { http.csrf().disable() .authorizeRequests()
 * .antMatchers("/public").permitAll() // Allow public access
 * .antMatchers("/user/**").hasRole("USER") // Only USER role access
 * .antMatchers("/admin/**").hasRole("ADMIN") // Only ADMIN role access
 * .anyRequest().authenticated() .and() .httpBasic(); // Use HTTP Basic
 * Authentication
 * 
 * return http.build(); }
 * 
 * @Bean public InMemoryUserDetailsManager userDetailsService() { UserDetails
 * user = User.builder() .username("user")
 * .password(passwordEncoder().encode("password")) .roles("USER") .build();
 * 
 * UserDetails admin = User.builder() .username("admin")
 * .password(passwordEncoder().encode("admin")) .roles("ADMIN") .build();
 * 
 * return new InMemoryUserDetailsManager(user, admin); }
 * 
 * @Bean public PasswordEncoder passwordEncoder() { return new
 * BCryptPasswordEncoder(); } }
 */