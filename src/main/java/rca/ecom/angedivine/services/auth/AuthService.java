package rca.ecom.angedivine.services.auth;

import rca.ecom.angedivine.dto.SignupRequest;
import rca.ecom.angedivine.dto.UserDto;

public interface AuthService {

        public UserDto createUser(SignupRequest signupRequest);

        public Boolean hasUserWithEmail(String email);

        public void createAdminAccount();

}
