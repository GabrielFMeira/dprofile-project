package br.com.project.dprofile.service;

import br.com.project.dprofile.dto.DataUserDTO;
import br.com.project.dprofile.dto.LoginUserDTO;
import br.com.project.dprofile.dto.RecoveryJwtTokenDTO;
import br.com.project.dprofile.dto.UserDTO;

public interface UserService {

    RecoveryJwtTokenDTO authenticateUser(LoginUserDTO loginUserDTO);

    void save(UserDTO user);

    void registerUserData(DataUserDTO data);

}
