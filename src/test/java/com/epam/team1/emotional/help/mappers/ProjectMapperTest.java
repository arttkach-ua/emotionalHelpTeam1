package com.epam.team1.emotional.help.mappers;

import com.epam.team1.emotional.help.dto.project.ProjectRequestDto;
import com.epam.team1.emotional.help.dto.project.ProjectResponseDto;
import com.epam.team1.emotional.help.model.Project;
import com.epam.team1.emotional.help.providers.ProjectsDataProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class ProjectMapperTest {
    @Autowired
    private ProjectMapper projectMapper;

    @Test
    void testToProject() {
        ProjectRequestDto dto = ProjectsDataProvider.getSingleProjectRequestDtoForTests();
        Project project = projectMapper.toProject(dto);
        assertEquals(dto.getTitle(), project.getTitle());
        assertEquals(dto.getDescription(), project.getDescription());
        assertNull(project.getId());
    }

    @Test
    void testToProjectResponseDto() {
        Project project = ProjectsDataProvider.getSingleProjectForTests();
        ProjectResponseDto resultDto = projectMapper.toProjectResponseDto(project);
        assertEquals(project.getId(), resultDto.getId());
        assertEquals(project.getTitle(), resultDto.getTitle());
        assertEquals(project.getDescription(), resultDto.getDescription());
    }

    @Test
    void testToProjectResponseDtoList() {
        List<Project> projectList = ProjectsDataProvider.getProjectListForTests();
        List<ProjectResponseDto> resultList = projectMapper.toProjectResponseDtoList(projectList);

        assertEquals(resultList.size(),projectList.size());
        assertEquals(1L, resultList.get(0).getId());
        assertEquals(2L, resultList.get(1).getId());
    }
}