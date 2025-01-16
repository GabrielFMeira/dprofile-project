package br.com.project.dprofile.controller;

import br.com.project.dprofile.service.ProjectService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/projects")
@Data
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping("/upload/{userId}")
    public ResponseEntity<?> upload(@RequestParam MultipartFile file, @RequestParam(name = "userId") Long userId) {
        try {
            projectService.processArchive(file, userId);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
