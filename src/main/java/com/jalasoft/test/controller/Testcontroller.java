package com.jalasoft.test.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;



@RestController
@RequestMapping("/hello")
@EnableConfigurationProperties(StorageProperties.class)
public class Testcontroller {
    private static String fileBasePath = "D:\\cursos\\Dev fundamentals II\\Proyectos\\test\\src\\main\\java\\com\\jalasoft\\test\\controller\\upload";
    @PostMapping
    public String sayHello(@RequestParam(value="name") String name,
                            @RequestParam(value="lastName") String lastName,
                           @RequestParam(value="file") MultipartFile file){
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Path path = Paths.get(fileBasePath + fileName);
        try {
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()

                .path(fileName)
                .toUriString();
        //return ResponseEntity.ok(fileDownloadUri);
        return"hello "+name +""+lastName;
    }

}
