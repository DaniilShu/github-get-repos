package com.example.githubgetrepos.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RepositoryInfoDTO {

    private LocalDateTime ts;
    private String username;//login
    private String name;//name of repos
    private String url;
    private LocalDateTime updated_at;
    private String description;
    private long size;

}
