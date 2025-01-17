package br.com.project.dprofile.repository;

import br.com.project.dprofile.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}
