package com.example.githubgetrepos.repositories;

import com.example.githubgetrepos.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RepositoryInfoRepository extends JpaRepository<RepositoryEntity, Long> {
    List<RepositoryEntity> findAllByTsBetween(LocalDateTime dateFrom, LocalDateTime dateTo);
}

