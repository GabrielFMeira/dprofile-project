package br.com.project.dprofile.dto;

import java.time.LocalDate;

public record DataUserDTO(
        String name,
        LocalDate birthDate,
        String occupation,
        String description,
        boolean isGraduated,
        String githubLink,
        String linkedinLink,
        String email
) {
}
