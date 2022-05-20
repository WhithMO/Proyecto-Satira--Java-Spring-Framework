package idat.edu.pe;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.crypto.password.PasswordEncoder;

import idat.edu.pe.auth.handler.LoginSuccessHandler;
import idat.edu.pe.service.JpaUserDetailsService;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled=true, prePostEnabled=true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

	//@Autowired
	//private DataSource dataSource;
	
	@Autowired
	private JpaUserDetailsService userDetailsService;
	
	@Autowired
	private LoginSuccessHandler successHandler;
	
	// El passwordEncoder se ha creado en el MVCCONFIG y aca se usa pero inyectandolo para no estar escribiendo todo ese codigo en cada archivo.
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().antMatchers("/", "/css/**", "/js/**", "/img/**", "/archivos/**", "/moduloCategorias/**", "/moduloProductos/**", "/moduloEstados/**", "/home", "/nosotros", "/sedes", "/catalogo", "/producto/detalle/**", "/contacto/guardar", "/contacto/nuevo", "/rest/contacto/**").permitAll()
		//.antMatchers("/producto/detalle/**").hasAnyRole("USER")
		.antMatchers("/producto/**").hasAnyRole("ADMIN")
		.antMatchers("/categoria/**").hasAnyRole("ADMIN")
		.antMatchers("/estado/**").hasAnyRole("ADMIN")
		.antMatchers("/contacto/**").hasAnyRole("USER")

		.anyRequest().authenticated()
		.and()
		    .formLogin().successHandler(successHandler)
		    	.loginPage("/login")	    
		    .permitAll()
		.and()
		.logout().permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/error_403");
	}



	
	
	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception
	{
		build.userDetailsService(userDetailsService)
		.passwordEncoder(passwordEncoder);
		//.usersByUsernameQuery("select username, password, enabled from users where username = ?")
		//.authoritiesByUsernameQuery("select u.username, a.authority from authorities a inner join users u on (a.user_id = u.id) where u.username = ?");
		
		/*
		PasswordEncoder encoder = this.passwordEncoder;
		
		UserBuilder users = User.builder().passwordEncoder(encoder::encode);
		
		build.inMemoryAuthentication()
		.withUser(users.username("admin").password("12345").roles("ADMIN", "USER"))
		.withUser(users.username("whith").password("12345").roles("USER"));
	*/
	}
}
