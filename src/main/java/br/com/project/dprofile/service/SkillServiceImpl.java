package br.com.project.dprofile.service;

import br.com.project.dprofile.dto.SkillDTO;
import br.com.project.dprofile.repository.SkillRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class SkillServiceImpl implements SkillService{
    
    private final SkillRepository skillRepository;
    
    @Override
    public List<SkillDTO> fetchSkills() {
        var skills = skillRepository.findAll();
        List<SkillDTO> skillList = new ArrayList<>();

        if (!skills.isEmpty()) {
            for (var skill : skills) {
                SkillDTO dto = new SkillDTO(skill.getId(), skill.getNome());

                skillList.add(dto);
            }
            return skillList;
        }

        return null;
    }
}
