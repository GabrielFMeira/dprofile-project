package br.com.project.dprofile.service;

import br.com.project.dprofile.entity.Project;
import br.com.project.dprofile.entity.UserData;
import br.com.project.dprofile.repository.ProjectRepository;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@Data
public class ProjectServiceImpl implements ProjectService{

    private final ProjectRepository projectRepository;

    @Override
    public void processArchive(MultipartFile file, Long userId) throws IOException {
        Project project = Project.builder()
                .name(file.getOriginalFilename())
                .fileBytes(file.getBytes())
                .userData(UserData.builder().id(userId).build())
                .build();

        projectRepository.save(project);
    }
}
