package br.com.project.dprofile.service;

import br.com.project.dprofile.config.SecurityConfiguration;
import br.com.project.dprofile.dto.DataUserDTO;
import br.com.project.dprofile.dto.LoginUserDTO;
import br.com.project.dprofile.dto.RecoveryJwtTokenDTO;
import br.com.project.dprofile.dto.UserDTO;
import br.com.project.dprofile.entity.Role;
import br.com.project.dprofile.entity.User;
import br.com.project.dprofile.entity.UserDetailsImpl;
import br.com.project.dprofile.repository.UserRepository;
import lombok.Data;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    private final SecurityConfiguration securityConfiguration;

    private final JwtTokenService jwtTokenService;

    private final AuthenticationManager authenticationManager;

    @Override
    public RecoveryJwtTokenDTO authenticateUser(LoginUserDTO loginUserDTO) {
        try {
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(loginUserDTO.email(), loginUserDTO.password());

            Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

            return new RecoveryJwtTokenDTO(jwtTokenService.generateToken(userDetails));
        } catch (Throwable e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public void save(UserDTO userDTO) {
        User user = User.builder()
                .email(userDTO.email())
                .password(securityConfiguration.passwordEncoder().encode(userDTO.password()))
                //.data(userDTO.data())
                .roles(List.of(Role.builder().name(userDTO.role()).build()))
                .build();

        userRepository.save(user);
    }

    @Override
    public void registerUserData(DataUserDTO data) {
        var currentUser = jwtTokenService.getUserByToken();

        //terminar lógica para cadastrar as infos através do user

        System.out.println(currentUser);
    }
}
