package br.com.project.dprofile.repository;

import br.com.project.dprofile.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDataRepository extends JpaRepository<UserData, Long> {

}
