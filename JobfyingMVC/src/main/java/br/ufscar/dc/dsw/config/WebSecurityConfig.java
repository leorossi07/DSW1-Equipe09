package br.ufscar.dc.dsw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// Removido o import da classe depreciada
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import br.ufscar.dc.dsw.security.UsuarioDetailsServiceImpl;

@Configuration
public class WebSecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        return new UsuarioDetailsServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @SuppressWarnings("removal")
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authenticationProvider(authenticationProvider())
            .authorizeHttpRequests((authz) -> authz
                .requestMatchers("/error", "/login/**", "/js/**", "/css/**", "/image/**", "/webjars/**").permitAll()
                .requestMatchers("/api/**").permitAll() // Permite acesso público às rotas da API
                .requestMatchers("/candidaturas/**").hasRole("USER")
                .requestMatchers("/empresas/**", "/vagas/**", "/usuarios/**").hasRole("ADMIN")
                .anyRequest().authenticated())
            .formLogin((form) -> form
                .loginPage("/login")
                .permitAll())
            .logout((logout) -> logout
                .logoutSuccessUrl("/").permitAll())
            .csrf().disable(); // Desabilita CSRF para facilitar testes com a API

        return http.build();
    }
}
