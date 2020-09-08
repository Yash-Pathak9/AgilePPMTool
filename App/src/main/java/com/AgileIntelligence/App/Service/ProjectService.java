package com.AgileIntelligence.App.Service;

import com.AgileIntelligence.App.Domain.Backlog;
import com.AgileIntelligence.App.Domain.Project;
import com.AgileIntelligence.App.Exceptions.ProjectIdException;
import com.AgileIntelligence.App.Repositories.BacklogRepository;
import com.AgileIntelligence.App.Repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    BacklogRepository backlogRepository;

    public Project saveOrUpdate(Project project){
        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            if(project.getId()==null){
                Backlog backlog = new Backlog();
                project.setBacklog(backlog);
                backlog.setProject(project);
                backlog.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            }
            else{
                project.setBacklog(backlogRepository.findByProjectIdentifier
                        (project.getProjectIdentifier().toUpperCase()));
            }
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
    public void deleteProjectByIdentifier(String projectId){
        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
        if(project==null){
            throw new ProjectIdException("Project with Id: "+projectId+" Doesn't Exist");
        }
        projectRepository.delete(project);
    }

}
