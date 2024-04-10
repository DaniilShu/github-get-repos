package com.example.githubgetrepos.controllers;

import com.example.githubgetrepos.models.*;
import com.example.githubgetrepos.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/repositories")
public class UserController {

    @Autowired
    private RepositoryInfoService repositoryInfoService;

    @GetMapping("/get")
    public ResponseEntity<List<RepositoryInfoDTO>> findAll(@RequestBody Request request) {

        return ResponseEntity.ok(this.repositoryInfoService.getRepositories(request));
    }
}
