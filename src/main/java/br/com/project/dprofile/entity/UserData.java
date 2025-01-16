package br.com.project.dprofile.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Builder
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private LocalDate birthDate;

    private String occupation;

    private String description;

    private boolean isGraduated;

    private String githubLink;

    private String linkedinLink;

    @Column(unique = true)
    private String email;

}
