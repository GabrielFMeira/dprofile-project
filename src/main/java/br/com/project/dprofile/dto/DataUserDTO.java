package br.com.project.dprofile.dto;

import java.time.LocalDate;

public record DataUserDTO(
        String name,
        LocalDate birthDate,
        String occupation,
        String decription,
        boolean isGraduated,
        String githubLink,
        String linkedinLink
) {
}
