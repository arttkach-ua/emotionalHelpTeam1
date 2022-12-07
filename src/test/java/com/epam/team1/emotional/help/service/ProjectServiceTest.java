//package com.epam.team1.emotional.help.service;
//
//import com.epam.team1.emotional.help.dto.project.ProjectRequestDto;
//import com.epam.team1.emotional.help.dto.project.ProjectResponseDto;
//import com.epam.team1.emotional.help.model.Project;
//import com.epam.team1.emotional.help.providers.ProjectsDataProvider;
//import com.epam.team1.emotional.help.repository.ProjectRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;
//
//@SpringBootTest
//class ProjectServiceTest {
//
//    @Autowired
//    private ProjectService projectService;
//    @MockBean
//    private ProjectRepository mockedProjectRepository;
//
//    @Test
//    void testFindAllDtoRepoIsEmpty() {
//        when(mockedProjectRepository.findAll())
//                .thenReturn(new ArrayList<Project>());
//        List<ProjectResponseDto> dtoList = projectService.getAll();
//        assertEquals(0, dtoList.size());
//        verify(mockedProjectRepository,times(1)).findAll();
//    }
//
//    @Test
//    void testFindAllDtoRepoHasData() {
//        List<Project> projectList = ProjectsDataProvider.getProjectListForTests();
//        when(mockedProjectRepository.findAll())
//                .thenReturn(projectList);
//
//        List<ProjectResponseDto> dtoList = projectService.getAll();
//        assertEquals(projectList.get(0).getTitle(), dtoList.get(0).getTitle());
//        assertEquals(projectList.get(1).getTitle(), dtoList.get(1).getTitle());
//        assertEquals(2, dtoList.size());
//        verify(mockedProjectRepository,times(1)).findAll();
//    }
//
//    @Test
//    void testCreate() {
//        ProjectRequestDto requestDto = ProjectsDataProvider.getSingleProjectRequestDtoForTests();
//        when(mockedProjectRepository.save(any(Project.class)))
//                .thenReturn(ProjectsDataProvider.getSingleProjectForTests());
//        ProjectResponseDto resultDto = projectService.create(requestDto);
//        assertEquals(1L, resultDto.getId());
//        assertEquals("some title 1", resultDto.getTitle());
//        assertEquals("some description 1", resultDto.getDescription());
//        verify(mockedProjectRepository,times(1)).save(any(Project.class));
//    }
//}