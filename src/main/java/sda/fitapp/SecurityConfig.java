package sda.fitapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()
                    .headers()
                    .frameOptions()
                    .sameOrigin()
                .and()
                    .authorizeRequests()
                    .antMatchers("/error").permitAll()      //---- error log access - all access for production only

                    .antMatchers("/swagger-ui.html").permitAll()            //---- swagger access - all access for production only
                    .antMatchers("/swagger-ui.html/**").permitAll()         //---- swagger access - all access for production only
                    .antMatchers("/swagger-resources.html/**").permitAll()  //---- swagger access - all access for production only

                    .antMatchers("/h2-console/**").permitAll()              //---- h2 access - all access for production only

                    .antMatchers(HttpMethod.GET,"/ingredient").hasAnyRole("ADMIN","SUBSCRIBED_USER")   //---- get method for user
                    .antMatchers("/ingredient/**").hasRole("ADMIN")                                          //---- ingredient access

                    .antMatchers(HttpMethod.GET,"/api/meal").hasAnyRole("ADMIN","SUBSCRIBED_USER")     //---- get method for user
                    .antMatchers("/api/meal/**").hasRole("ADMIN")                                            //---- meals access

                    .antMatchers(HttpMethod.POST,"/questionnaire").permitAll()   //---- survey access
                    .antMatchers("/users").hasRole("ADMIN")                      //---- for user management access

                    .antMatchers("/").permitAll()                               //---- access
                .and()
                    .formLogin();
        http.csrf().disable();
    }

    //-------------------------- PRODUCTION CODE ONLY - DELETE LATER -------------------------------------------------
    @Override
    @Bean
    public UserDetailsService userDetailsService() {
        List<UserDetails> users= new ArrayList<UserDetails>();
        users.add(User.withDefaultPasswordEncoder().username("admin").password("admin").roles("ADMIN").build());
        users.add(User.withDefaultPasswordEncoder().username("subuser").password("subuser").roles("SUBSCRIBED_USER").build());
        users.add(User.withDefaultPasswordEncoder().username("user").password("user").roles("USER").build());
        return new InMemoryUserDetailsManager(users);
    }
    //-------------------------- PRODUCTION CODE ONLY - DELETE LATER --------------------------------------------------
}