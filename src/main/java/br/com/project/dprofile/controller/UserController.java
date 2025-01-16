package br.com.project.dprofile.controller;

import br.com.project.dprofile.dto.DataUserDTO;
import br.com.project.dprofile.dto.LoginUserDTO;
import br.com.project.dprofile.dto.RecoveryJwtTokenDTO;
import br.com.project.dprofile.dto.UserDTO;
import br.com.project.dprofile.service.JwtTokenService;
import br.com.project.dprofile.service.UserDataService;
import br.com.project.dprofile.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Data
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDataService userDataService;

    @Autowired
    private final JwtTokenService jwtTokenService;

    @PostMapping
    public ResponseEntity<?> create (@RequestBody UserDTO user) {
        userService.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<RecoveryJwtTokenDTO> login(@RequestBody LoginUserDTO loginUserDTO) {
        RecoveryJwtTokenDTO token = userService.authenticateUser(loginUserDTO);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @PostMapping("/data")
    public ResponseEntity<?> finishRegistration(@RequestBody DataUserDTO dataUserDTO) {
        userDataService.save(dataUserDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
