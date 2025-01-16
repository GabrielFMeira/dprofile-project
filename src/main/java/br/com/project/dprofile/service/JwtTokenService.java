package br.com.project.dprofile.service;

import br.com.project.dprofile.entity.UserDetailsImpl;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtTokenService {

    String generateToken(UserDetailsImpl user);

    String getSubjectFromToken(String token);

    UserDetails getUserByToken();
}
