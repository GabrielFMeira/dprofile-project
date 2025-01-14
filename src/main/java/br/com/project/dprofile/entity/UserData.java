package br.com.project.dprofile.entity;

import jakarta.persistence.Entity;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class UserData {

    private String name;

    private LocalDate birthDate;

    private String occupation;

    private String description;

    private boolean isGraduated;

    private String githubLink;

    private String linkedinLink;

}
