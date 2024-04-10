package com.example.githubgetrepos.schedule;

import com.example.githubgetrepos.service.RepositoryInfoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class ScheduledTaskService {
    private final RepositoryInfoService repositoryInfoService;


    public ScheduledTaskService(RepositoryInfoService repositoryInfoService) {
        this.repositoryInfoService = repositoryInfoService;
    }

    @Value("${GithubUsername}")
    private String githubUsername;

    @Scheduled(fixedDelayString = "#{new Integer(${GithubFrequencyGet})}", timeUnit = TimeUnit.MINUTES)
    public void ScheduledTask() {
       repositoryInfoService.getRepositoriesByLoginFromGithub(githubUsername);

    }

}
