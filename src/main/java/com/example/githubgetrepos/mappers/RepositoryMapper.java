package com.example.githubgetrepos.mappers;

import com.example.githubgetrepos.models.*;
import com.example.githubgetrepos.service.*;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = RepositoryInfoService.class)
public interface RepositoryMapper {
    @Mapping(target = "username", source = "repositoryEntity.login")
    @Mapping(target = "url", source = "repositoryEntity.html_url")
    RepositoryInfoDTO toRepositoryInfoDTO(RepositoryEntity repositoryEntity);

    @Mapping(target = "username", source = "repositoryEntity.login")
    @Mapping(target = "url", source = "repositoryEntity.html_url")
    List<RepositoryInfoDTO> toListRepositoryInfoDTO(List<RepositoryEntity> repositoryEntity);

    RepositoryInfo toRepositoryInfo(RepositoryEntity repositoryEntity);

    RepositoryEntity toRepositoryEntity(RepositoryInfo repositoryInfo);

    List<RepositoryEntity> toListRepositoryEntity(List<RepositoryInfo> repositoryInfos);

    @AfterMapping
    default void convertOwnerLoginToLogin(RepositoryInfo repositoryInfo, @MappingTarget RepositoryEntity repositoryEntity) {
        repositoryEntity.setLogin(repositoryInfo.getOwner().getLogin());
    }

}
