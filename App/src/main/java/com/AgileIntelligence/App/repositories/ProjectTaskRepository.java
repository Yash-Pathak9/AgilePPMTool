package com.AgileIntelligence.App.Repositories;

import com.AgileIntelligence.App.Domain.ProjectTask;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectTaskRepository extends CrudRepository<ProjectTask,Long> {
}
