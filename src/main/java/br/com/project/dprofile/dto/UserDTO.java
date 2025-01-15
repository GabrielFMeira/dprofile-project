package br.com.project.dprofile.dto;

import br.com.project.dprofile.entity.Role;
import br.com.project.dprofile.entity.UserData;
import br.com.project.dprofile.entity.enumeration.RoleName;

import java.util.List;

public record UserDTO(String email, String password, UserData data, RoleName role) {
}
