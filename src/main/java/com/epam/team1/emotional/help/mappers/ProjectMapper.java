package com.epam.team1.emotional.help.mappers;

import com.epam.team1.emotional.help.dto.project.ProjectRequestDto;
import com.epam.team1.emotional.help.dto.project.ProjectResponseDto;
import com.epam.team1.emotional.help.model.Project;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
@Slf4j
@Component
public class ProjectMapper {
    /**
     * maps {@link ProjectRequestDto} to {@link Project} entity
     * @param dto - {@link ProjectRequestDto}
     * @return {@link Project}
     */
    public Project toProject(ProjectRequestDto dto){
        log.info("Call of ProjectMapper.toProject method. Params: dto {}", dto);
        return Project.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .build();
    }
    /**
     * maps {@link Project} entity to {@link ProjectResponseDto}
     * @param project {@link Project} entity
     * @return - {@link ProjectResponseDto}
     */
    public ProjectResponseDto toProjectResponseDto(Project project){
        log.info("Call of ProjectMapper.toProjectResponseDto method. Params: project {}", project);
        return ProjectResponseDto.builder()
                .id(project.getId())
                .title(project.getTitle())
                .description(project.getDescription())
                .build();
    }
    /**
     * maps List of {@link Project} entity to list of {@link ProjectResponseDto}
     * @param  projects - List of {@link Project}
     * @return list of {@link ProjectResponseDto}
     */
    public List<ProjectResponseDto> toProjectResponseDtoList(List<Project> projects) {
        log.info("Call of ProjectMapper.toProjectResponseDtoList method. Params: projects {}", projects);
        return projects.stream()
                .map(this::toProjectResponseDto)
                .toList();
    }
}
