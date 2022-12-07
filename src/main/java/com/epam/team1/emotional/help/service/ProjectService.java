package com.epam.team1.emotional.help.service;

import com.epam.team1.emotional.help.dto.project.ProjectRequestDto;
import com.epam.team1.emotional.help.dto.project.ProjectResponseDto;
import com.epam.team1.emotional.help.mappers.ProjectMapper;
import com.epam.team1.emotional.help.model.Project;
import com.epam.team1.emotional.help.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private ProjectMapper projectMapper;

    public List<ProjectResponseDto> getAll() {
        return projectMapper.toProjectResponseDtoList(projectRepository.findAll());
    }
    public ProjectResponseDto create(ProjectRequestDto dto){
        Project project = projectRepository.save(projectMapper.toProject(dto));
        return projectMapper.toProjectResponseDto(project);
    }
}
