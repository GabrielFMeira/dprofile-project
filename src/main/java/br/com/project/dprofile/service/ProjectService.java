package br.com.project.dprofile.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ProjectService {

    void processArchive(MultipartFile file, Long userId) throws IOException;
}
