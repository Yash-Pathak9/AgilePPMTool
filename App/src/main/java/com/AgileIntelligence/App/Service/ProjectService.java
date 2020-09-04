package com.AgileIntelligence.App.Service;

import com.AgileIntelligence.App.Domain.Project;
import com.AgileIntelligence.App.Exceptions.ProjectIdException;
import com.AgileIntelligence.App.Repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    ProjectRepository projectRepository;

    public Project saveOrUpdate(Project project){
        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        }
        catch (Exception e){
            throw new ProjectIdException("Project ID: "+project.getProjectIdentifier().toUpperCase()+" already exists");

        }

    }
    public Project findProjectByIdentifier(String projectId){
        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
        if(project==null){
            throw new ProjectIdException("Project ID "+projectId+" Doesn't Exist");
        }
        return  project;
    }
    public Iterable<Project> findAllProjects(){
        return projectRepository.findAll();
    }
    public void deleteProjectByIdtentifier(String projectId){
        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
        if(project==null){
            throw new ProjectIdException("Project with Id: "+projectId+" Doesn't Exist");
        }
        projectRepository.delete(project);
    }

}
