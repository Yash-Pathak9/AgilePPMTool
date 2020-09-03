package com.AgileIntelligence.App.Service;

import com.AgileIntelligence.App.Domain.Project;
import com.AgileIntelligence.App.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    ProjectRepository projectRepository;

    public Project saveOrUpdate(Project project){
        //logic
       return projectRepository.save(project);
    }
}
