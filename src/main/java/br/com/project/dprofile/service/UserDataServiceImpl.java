package br.com.project.dprofile.service;

import br.com.project.dprofile.dto.DataUserDTO;
import br.com.project.dprofile.entity.UserData;
import br.com.project.dprofile.repository.UserDataRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class UserDataServiceImpl implements UserDataService{

    private final UserDataRepository userDataRepository;

    @Override
    public void save(DataUserDTO data) {
        UserData userData = UserData.builder()
                .name(data.name())
                .birthDate(data.birthDate())
                .occupation(data.occupation())
                .description(data.description())
                .isGraduated(data.isGraduated())
                .githubLink(data.githubLink())
                .linkedinLink(data.linkedinLink())
                .email(data.email())
                .build();

        userDataRepository.save(userData);
    }
}
