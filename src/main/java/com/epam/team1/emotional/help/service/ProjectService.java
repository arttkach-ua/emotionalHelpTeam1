package com.epam.team1.emotional.help.service;

import com.epam.team1.emotional.help.dto.project.ProjectRequestDto;
import com.epam.team1.emotional.help.dto.project.ProjectResponseDto;
import com.epam.team1.emotional.help.mappers.ProjectMapper;
import com.epam.team1.emotional.help.model.Project;
import com.epam.team1.emotional.help.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    public List<ProjectResponseDto> getAll() {
        log.info("Call of ProjectService.getAll method.");
        return projectMapper.toProjectResponseDtoList(projectRepository.findAll());
    }
    public ProjectResponseDto create(ProjectRequestDto dto){
        log.info("Call of ProjectService.create method. dto is{}", dto);
        Project project = projectRepository.save(projectMapper.toProject(dto));
        return projectMapper.toProjectResponseDto(project);
    }
}
