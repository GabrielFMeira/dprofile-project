package br.com.project.dprofile.service;

import br.com.project.dprofile.entity.UserDetailsImpl;

public interface JwtTokenService {

    String generateToken(UserDetailsImpl user);

    String getSubjectFromToken(String token);
}
