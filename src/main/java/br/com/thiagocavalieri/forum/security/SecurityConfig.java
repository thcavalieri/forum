package br.com.thiagocavalieri.forum.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@AllArgsConstructor
@Configuration
//@Import(SecurityConfig.RolePrefixConfiguration.class)
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        securedEnabled = true, // securedEnabled = true enables @Secured annotation.
        jsr250Enabled = true, // jsr250Enabled = true enables @RolesAllowed annotation.
        prePostEnabled = true) // prePostEnabled = true enables @PreAuthorize, @PostAuthorize, @PreFilter, @PostFilter annotations.
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private AuthenticationService authenticationService;
    private AuthenticationByTokenFilter authenticationByTokenFilter;

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

//    The code below is to remove prefix 'ROLE_' from grantedAuthorityDefaults. If you want to use this code, you need
//    to uncomment @Import on this class and change data.sql to save ADMIN instead of ROLE_ADMIN.
//    public static class RolePrefixConfiguration {
//        @Bean
//        public GrantedAuthorityDefaults grantedAuthorityDefaults() {
//            return new GrantedAuthorityDefaults(""); // "remove prefix 'ROLE_' from grantedAuthorityDefaults"
//        }
//    }

        //Method for authentication configuration
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authenticationService).passwordEncoder(new BCryptPasswordEncoder());
    }

    //Method for authorization configuration
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").permitAll().and()
                .authorizeRequests().antMatchers("/h2-console/**").permitAll()
                .antMatchers(HttpMethod.GET,"/topics", "/topics/*").permitAll()
                .antMatchers(HttpMethod.POST,"/auth").permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable().headers().frameOptions().disable()
                .and().headers().frameOptions().disable()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().addFilterBefore(authenticationByTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }

    //Method for static sources(js, images, css, etc) configuration
    @Override
    public void configure(WebSecurity web) throws Exception {
    }

    /* This main is here just for test proposal. If you want another password to test the security, you can use this method
        and add the new generated has in data.sql */
    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }

}
