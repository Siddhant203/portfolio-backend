package com.siddhant.portfolio.service;

import com.siddhant.portfolio.dto.ProjectRequest;
import com.siddhant.portfolio.dto.ProjectResponse;
import com.siddhant.portfolio.entity.Project;
import com.siddhant.portfolio.exception.ProjectNotFoundException;
import com.siddhant.portfolio.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }
    public List<ProjectResponse> getAllProjects(){
        return projectRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .toList();
    }

    private ProjectResponse convertToResponse(Project project){
        return new ProjectResponse(
                project.getId(),
                project.getTitle(),
                project.getDescription(),
                project.getTechnologies(),
                project.getGithubUrl(),
                project.getLiveUrl()
        );
    }


    public ProjectResponse getProjectById(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() ->
                        new ProjectNotFoundException(
                                "Project not found with id: " + id
                        )
                );

        return convertToResponse(project);
    }


    public ProjectResponse createProject(ProjectRequest request){
        Project project = new Project(
                request.getTitle(),
                request.getDescription(),
                request.getTechnologies(),
                request.getGithubUrl(),
                request.getLiveUrl()
        );

        Project savedProject = projectRepository.save(project);
        return convertToResponse(savedProject);
    }

    public ProjectResponse updateProject(Long id, ProjectRequest request){
        Project project = projectRepository.findById(id)
                .orElseThrow(() ->
                        new ProjectNotFoundException("Project not found with id "+id));
        project.setTitle(request.getTitle());
        project.setDescription(request.getDescription());
        project.setTechnologies(request.getTechnologies());
        project.setGithubUrl(request.getGithubUrl());
        project.setLiveUrl(request.getLiveUrl());

        Project updatedProject = projectRepository.save(project);

        return convertToResponse(updatedProject);
    }

    public boolean deleteProject(Long id){
        if(!projectRepository.existsById(id)){
            return false;
        }else{
            projectRepository.deleteById(id);
            return true;
        }
    }
}
