package com.siddhant.portfolio.controller;

import com.siddhant.portfolio.dto.ProjectRequest;
import com.siddhant.portfolio.dto.ProjectResponse;
import com.siddhant.portfolio.entity.Project;
import com.siddhant.portfolio.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/projects")
public class ProjectController {

    private ProjectService projectService;

    public ProjectController(ProjectService projectService){
        this.projectService = projectService;
    }

    @GetMapping
    public List<ProjectResponse> getAllProjects(){
        return projectService.getAllProjects();

    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponse> getProjectById(@PathVariable Long id){

        ProjectResponse response = projectService.getProjectById(id);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ProjectResponse> CreatProject(
            @Valid @RequestBody ProjectRequest request){
        ProjectResponse response = projectService.createProject(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectResponse> UpdateProject(
            @PathVariable long id,
            @Valid @RequestBody ProjectRequest request){

        ProjectResponse response = projectService.updateProject(id, request);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeleteProject(@PathVariable long id){
        boolean deleted = projectService.deleteProject(id);
        if(!deleted){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.noContent().build();
        }
    }

}
