package kodlama.io.ecommerce.business.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kodlama.io.ecommerce.business.abstracts.UserService;
import kodlama.io.ecommerce.business.requests.LoginRequest;
import kodlama.io.ecommerce.core.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.ArrayList;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthenticationFilter  extends UsernamePasswordAuthenticationFilter {

        private UserService userService;

	@Autowired
	public AuthenticationFilter(AuthenticationManager authenticationManager, UserService userService) {
            this.userService = userService;
            super.setAuthenticationManager(authenticationManager);
        }

        @Override
        public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {

            try {

                LoginRequest credentials = new ObjectMapper().readValue(request.getInputStream(), LoginRequest.class);

                return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(
                        credentials.getEmail(), credentials.getPassword(), new ArrayList<>()));
            } catch (IOException e) {
                throw new RuntimeException();
            }

        }

        @Override
        protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                Authentication authResult) throws IOException, ServletException {

            String userName = ((User) authResult.getPrincipal()).getUsername();

            UserDto userDetails = this.userService.getUserDetailsByEmail(userName);

            String token = Jwts.builder().setSubject(userDetails.getId())
                    .setExpiration(new Date(System.currentTimeMillis() + 10000))
                    .signWith(SignatureAlgorithm.HS512, "mysupersecretkeymysupersecretkeymysupersecretkey").compact();

            response.addHeader("token", token);
            response.addHeader("userId", userDetails.getId());
        }
}
