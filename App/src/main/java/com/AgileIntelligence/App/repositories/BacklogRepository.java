package com.AgileIntelligence.App.Repositories;

import com.AgileIntelligence.App.Domain.Backlog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BacklogRepository extends CrudRepository<Backlog,Long> {
}
