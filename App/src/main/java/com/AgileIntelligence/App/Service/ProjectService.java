package com.AgileIntelligence.App.Service;

import com.AgileIntelligence.App.Domain.Project;
import com.AgileIntelligence.App.Exceptions.ProjectIdException;
import com.AgileIntelligence.App.Repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
}
