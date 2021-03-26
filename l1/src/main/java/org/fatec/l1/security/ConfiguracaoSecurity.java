package org.fatec.l1.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class ConfiguracaoSecurity extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//super.configure(http);
		http.authorizeRequests()
			// coloquei um liberação para algumas páginas / recursos / rotas
			.antMatchers("/","/webjars/**").permitAll()
			// coloquei uma solicitação de liberação para qualquer requisicao autenticada
			.anyRequest()
			.authenticated()
			// personlizei o formulario de login
			.and()
			.formLogin().loginPage("/login")
			.defaultSuccessUrl("/",true)
			.failureUrl("/login")
			.permitAll()
			// personalizacao de logout
			.and()
			.logout()
			.logoutSuccessUrl("/login");
	}
}