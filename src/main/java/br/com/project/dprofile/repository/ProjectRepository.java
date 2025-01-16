package br.com.project.dprofile.repository;

import br.com.project.dprofile.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
