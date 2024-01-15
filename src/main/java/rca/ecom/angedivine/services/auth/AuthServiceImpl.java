package rca.ecom.angedivine.services.auth;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import rca.ecom.angedivine.dto.SignupRequest;
import rca.ecom.angedivine.dto.UserDto;
import rca.ecom.angedivine.entities.User;
import rca.ecom.angedivine.enums.UserRole;
import rca.ecom.angedivine.repository.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {

        @Autowired
        private UserRepository userRepository;

        private BCryptPasswordEncoder bCryptPasswordEncoder;

        public UserDto createUser(SignupRequest signupRequest){

                User user = new User();

                user.setEmail(signupRequest.getEmail());
                user.setName(signupRequest.getName());
                user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
                user.setRole(UserRole.CUSTOMER);

                User createdUser = userRepository.save(user);

                UserDto userDto = new UserDto();
                userDto.setId(createdUser.getId());

                return userDto;
        }

        @Override
        public Boolean hasUserWithEmail(String email) {
                return userRepository.findFirstByEmail(email).isPresent();
        }

        @PostConstruct
        public void createAdminAccount() {

                User adminAcount = userRepository.findByRole(UserRole.ADMIN);

                if( null == adminAcount){
                        User user = new User();
                        user.setEmail("admin@rca.com");
                        user.setName("admin");
                        user.setRole(UserRole.ADMIN);
                        user.setPassword(new BCryptPasswordEncoder().encode("admin"));
                        userRepository.save(user);
                }
        }


}
