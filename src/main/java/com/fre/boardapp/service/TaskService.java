package com.fre.boardapp.service;

import com.fre.boardapp.domain.Task;
import com.fre.boardapp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task saveOrUpdateTask(Task task) {
        if (task.getStatus() == null || task.getStatus() == "")
            task.setStatus("TO_DO");

        return taskRepository.save(task);
    }

    public Iterable<Task> findAll(){
        return taskRepository.findAll();
    }

    public Task findById(Long id){
        return taskRepository.getById(id);
    }

    public void deleteById(Long id){
        Task task = taskRepository.getById(id);
        taskRepository.delete(task);
    }
}
