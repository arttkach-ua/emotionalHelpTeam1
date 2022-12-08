package com.epam.team1.emotional.help.controller;

import com.epam.team1.emotional.help.dto.project.ProjectRequestDto;
import com.epam.team1.emotional.help.dto.project.ProjectResponseDto;
import com.epam.team1.emotional.help.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    @ResponseStatus(HttpStatus.CREATED)
    public ProjectResponseDto createProject(@RequestBody @Valid ProjectRequestDto dto){
        return projectService.create(dto);
    }
}
