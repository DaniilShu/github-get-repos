package com.example.githubgetrepos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;


@SpringBootApplication
@Component
@EnableScheduling
public class GithubGetReposApplication {

    public static void main(String[] args) {
        SpringApplication.run(GithubGetReposApplication.class, args);
    }

}