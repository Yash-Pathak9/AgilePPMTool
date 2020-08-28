package com.AgileIntelligence.App.repositories;

import com.AgileIntelligence.App.Domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project,Long> {

}
