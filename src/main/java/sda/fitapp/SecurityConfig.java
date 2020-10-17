package sda.fitapp;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

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
                    .antMatchers("/error").permitAll()      //---- error log access

                    .antMatchers("/swagger-ui.html/**").permitAll()         //---- swagger access
                    .antMatchers("/swagger-ui.html").permitAll()            //---- swagger access
                    .antMatchers("/swagger-resources.html/**").permitAll()  //---- swagger access

                    .antMatchers("/h2-console/**").permitAll()              //---- h2 access

                    .antMatchers("/ingredient/**").hasRole("ADMIN")                                          //---- ingredient access
                    .antMatchers(HttpMethod.GET,"/ingredient").hasAnyRole("ADMIN","SUBSCRIBED_USER")   //---- get method for user

                    .antMatchers("/api/meal/**").hasRole("ADMIN")                                            //---- meals access
                    .antMatchers(HttpMethod.GET,"/api/meal").hasAnyRole("ADMIN","SUBSCRIBED_USER")     //---- get method for user

                    .antMatchers(HttpMethod.POST,"/questionnaire").permitAll()   //---- survey access
                    .antMatchers("/users").hasRole("ADMIN")                      //---- for user management access

                    .antMatchers("/").permitAll()                               //---- access
                .and()
                    .formLogin();
        http.csrf().disable();
    }
}