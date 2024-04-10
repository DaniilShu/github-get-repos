package com.example.githubgetrepos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;


@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RepositoryInfo {

    private Owner owner;
    private String name;
    private String html_url;
    private LocalDateTime updated_at;
    private String description;
    private long size;
}
