package br.com.project.dprofile.controller;

import br.com.project.dprofile.dto.SkillDTO;
import br.com.project.dprofile.service.SkillService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/skills")
@Data
public class SkillController {

    private final SkillService skillService;

    @GetMapping
    public ResponseEntity<List<SkillDTO>> getSkills() {
        var skills = skillService.fetchSkills();
        return new ResponseEntity<>(skills, HttpStatus.OK);
    }
}
