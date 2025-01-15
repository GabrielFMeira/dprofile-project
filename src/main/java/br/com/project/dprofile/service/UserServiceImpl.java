package br.com.project.dprofile.service;

import br.com.project.dprofile.dto.UserDTO;
import br.com.project.dprofile.entity.User;
import br.com.project.dprofile.repository.UserRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public void save(UserDTO user) {

//        User user =
//
//        userRepository.save(user);
    }
}
