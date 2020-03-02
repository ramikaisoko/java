package com.fre.boardapp.repository;

import com.fre.boardapp.domain.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring @Repository annotation is used to indicate that the class provides the mechanism for storage,
 * retrieval, search, update and delete operation on objects.
 */
@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {

    Task getById(Long id);
}
