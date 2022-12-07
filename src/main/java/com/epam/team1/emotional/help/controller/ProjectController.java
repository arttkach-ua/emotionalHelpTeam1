package com.epam.team1.emotional.help.controller;

import com.epam.team1.emotional.help.dto.project.ProjectRequestDto;
import com.epam.team1.emotional.help.dto.project.ProjectResponseDto;
import com.epam.team1.emotional.help.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
@CrossOrigin
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping
    public List<ProjectResponseDto> getAllProjects(){
        return projectService.getAll();
    }
    @PostMapping
    public ProjectResponseDto createProject(@RequestBody ProjectRequestDto dto){
        return projectService.create(dto);
    }
}
