
package com.epam.team1.emotional.help.providers;

import com.epam.team1.emotional.help.dto.project.ProjectRequestDto;
import com.epam.team1.emotional.help.model.Project;

import java.util.List;

public class ProjectsDataProvider {
    public static List<Project> getProjectListForTests(){
        return List.of(
                Project.builder().id(1L).title("some title 1").description("some description 1").build(),
                Project.builder().id(2L).title("some title 2").description("some description 2").build());
    }
    public static Project getSingleProjectForTests(){
        return Project.builder()
                .id(1L)
                .title("some title 1")
                .description("some description 1")
                .build();
    }
    public static ProjectRequestDto getSingleProjectRequestDtoForTests(){
        return ProjectRequestDto.builder()
                .title("some title")
                .description("some description")
                .build();
    }
}
