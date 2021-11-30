package br.com.thiagocavalieri.forum.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@AllArgsConstructor
@Configuration
@EnableWebSecurity
@Profile("dev")
public class SecurityConfigDEV extends WebSecurityConfigurerAdapter {

    //Method for authorization configuration
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/**").permitAll()
                .and().csrf().disable();
    }
}
