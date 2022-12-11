package com.epam.team1.emotional.help.service;

import com.epam.team1.emotional.help.dto.project.ProjectRequestDto;
import com.epam.team1.emotional.help.dto.project.ProjectResponseDto;
import com.epam.team1.emotional.help.mappers.ProjectMapper;
import com.epam.team1.emotional.help.model.Project;
import com.epam.team1.emotional.help.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    public List<ProjectResponseDto> getAll() {
        return projectMapper.toProjectResponseDtoList(projectRepository.findAll());
    }
    public ProjectResponseDto create(ProjectRequestDto dto){
        Project project = projectRepository.save(projectMapper.toProject(dto));
        return projectMapper.toProjectResponseDto(project);
    }
}
