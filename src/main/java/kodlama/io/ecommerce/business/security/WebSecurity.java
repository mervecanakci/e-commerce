package kodlama.io.ecommerce.business.security;

import kodlama.io.ecommerce.business.abstracts.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class WebSecurity {

    private UserService service;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();

        // problem burda!
        http.authorizeRequests().antMatchers("/**").authenticated();

        http.addFilter(this.getAuthenticationFilter());
    }

    private AuthenticationFilter getAuthenticationFilter() throws Exception {

        AuthenticationFilter authenticationFilter = new AuthenticationFilter(authenticationManager(), service);

        authenticationFilter.setFilterProcessesUrl("/login");

        return authenticationFilter;
    }

    // doğrulama kısmı
    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {

        authenticationManagerBuilder.userDetailsService(this.service).passwordEncoder(bCryptPasswordEncoder);
    }
}
