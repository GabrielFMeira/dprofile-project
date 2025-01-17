package br.com.project.dprofile.service;

import br.com.project.dprofile.dto.SkillDTO;

import java.util.List;

public interface SkillService {

    List<SkillDTO> fetchSkills();
}
