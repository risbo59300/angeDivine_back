package rca.ecom.angedivine.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import rca.ecom.angedivine.dto.AuthenticationRequest;
import rca.ecom.angedivine.entities.User;
import rca.ecom.angedivine.repository.UserRepository;
import rca.ecom.angedivine.utils.JwtUtil;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class AuthController {

        private final AuthenticationManager authenticationManager;
        private final UserDetailsService userDetailsService;
        private final UserRepository userRepository;
        private final JwtUtil jwtUtil;
        private static final String TOKEN_PREFIX = "Bearer";
        private static final String HEADER_STRING = "Authorization";


        @PostMapping("/authenticate")
        public void createAuthenticationT7oken(@RequestBody AuthenticationRequest authenticationRequest,
                                               HttpServletResponse response) throws JSONException, IOException {

                try {
                        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
                                                                                                   authenticationRequest.getPassword()));
                } catch (BadCredentialsException e){
                        throw new BadCredentialsException("Incorret username or password");
                }

                final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
                Optional<User> optionalUser = userRepository.findFirstByEmail(userDetails.getUsername());
                final String jwt = jwtUtil.generateToken(userDetails.getUsername());

                if( optionalUser.isPresent()){
                        response.getWriter().write(new JSONObject()
                                   .put("userId", optionalUser.get().getId())
                                   .put("role", optionalUser.get().getRole())
                                   .toString()
                        );
                }

                response.addHeader(HEADER_STRING, TOKEN_PREFIX + jwt);
        }
}