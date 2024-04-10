package com.example.githubgetrepos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZoneId;


@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "repositories")
public class RepositoryEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private LocalDateTime ts = LocalDateTime.now(ZoneId.of("Europe/Moscow"));
    @Column(name = "username")
    private String login;
    @Column
    private String name;
    @Column(name = "url")
    private String html_url;
    @Column(name = "update_ts")
    private LocalDateTime updated_at;
    @Column
    private long size;
    @Column
    private String description;

}
