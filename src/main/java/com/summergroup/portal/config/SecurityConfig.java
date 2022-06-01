package com.summergroup.portal.config;

import com.summergroup.portal.security.CustomAuthenticationFilter;
import com.summergroup.portal.security.CustomAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static com.summergroup.portal.security.Roles.ROLE_ADMIN;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomAuthenticationFilter customAuthenticationFilter;
    private final CustomAuthorizationFilter customAuthorizationFilter;

    @Autowired
    public SecurityConfig(CustomAuthenticationFilter customAuthenticationFilter, CustomAuthorizationFilter customAuthorizationFilter) {
        this.customAuthenticationFilter = customAuthenticationFilter;
        this.customAuthorizationFilter = customAuthorizationFilter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        customAuthenticationFilter.setFilterProcessesUrl("/api/v1/login");

        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(STATELESS);
        http.authorizeRequests().antMatchers("/swagger-ui/**").permitAll();
        http.authorizeRequests().antMatchers("/v3/api-docs/**").permitAll();
        http.authorizeRequests().antMatchers("/api/v1/register").permitAll();
        http.authorizeRequests().antMatchers("/api/v1/login").permitAll();
        http.authorizeRequests().antMatchers(GET, "/api/v1/users/**").hasAnyAuthority(ROLE_ADMIN.name());
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(customAuthenticationFilter);
        http.addFilterBefore(customAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
