package com.example.githubgetrepos.service;

import com.example.githubgetrepos.mappers.RepositoryMapper;
import com.example.githubgetrepos.models.RepositoryEntity;
import com.example.githubgetrepos.models.RepositoryInfo;
import com.example.githubgetrepos.models.RepositoryInfoDTO;
import com.example.githubgetrepos.models.Request;
import com.example.githubgetrepos.repositories.RepositoryInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@Slf4j
public class RepositoryInfoService {
    private final RepositoryInfoRepository repositoryInfoRepository;
    private final WebClient webClient;
    private final RepositoryMapper repositoryMapper;


    public RepositoryInfoService(@Autowired RepositoryInfoRepository repositoryInfoRepository, @Autowired WebClient webClient, @Autowired RepositoryMapper repositoryMapper) {
        this.repositoryInfoRepository = repositoryInfoRepository;
        this.webClient = webClient;
        this.repositoryMapper = repositoryMapper;
    }

    public void getRepositoriesByLoginFromGithub(final String login) {
        List<RepositoryInfo> repoListFromGithub = webClient
                .get()
                .uri(String.join("", login, "/repos"))
                .retrieve()
                .bodyToFlux(RepositoryInfo.class).collectList().block();
        log.info("got repos from Github: {}", repoListFromGithub);
        List<RepositoryEntity> repositoryEntityList = repositoryMapper.toListRepositoryEntity(repoListFromGithub);
        repositoryInfoRepository.saveAll(repositoryEntityList);
        log.info("saved to database: {}", repositoryEntityList);
    }


    public List<RepositoryInfoDTO> getRepositories(Request request) {
        List<RepositoryEntity> repositoryEntity = repositoryInfoRepository.findAllByTsBetween(request.getDateFrom(), request.getDateTo());
        List<RepositoryInfoDTO> repositoryInfoDTOS = repositoryMapper.toListRepositoryInfoDTO(repositoryEntity);
        log.info("got from database: {}",repositoryInfoDTOS);
        return repositoryInfoDTOS;
    }

}