package com.fre.boardapp.web;

import com.fre.boardapp.domain.Task;
import com.fre.boardapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/board")
@CrossOrigin
public class TaskController {

    @Autowired
    private TaskService taskService;

    /**
     * Add task
     *
     * @return
     */
    @PostMapping("")
    public ResponseEntity<?> addTaskToBoard(@Valid @RequestBody Task task, BindingResult result) {

        if (result.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            //result.getFieldErrors()

            for (FieldError error : result.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }

            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        Task myTask = taskService.saveOrUpdateTask(task);

        return new ResponseEntity<Task>(myTask, HttpStatus.MULTI_STATUS.CREATED);
    }

    /**
     * retrive all tasks
     *
     * @return
     */
    @GetMapping("/all")
    public Iterable<Task> getAllTasks() {
        return taskService.findAll();
    }

    /**
     * retrieve task by id
     *
     * @return
     */
    @GetMapping("/{task_id}")
    public ResponseEntity<?> getTaskByID(@PathVariable Long task_id) {
        Task task = taskService.findById(task_id);
        return new ResponseEntity<Task>(task, HttpStatus.OK);
    }

    /**
     * Delete task
     *
     * @return
     */
    @DeleteMapping("/{task_id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long task_id) {
        taskService.deleteById(task_id);
        return new ResponseEntity<String>("Task deleted", HttpStatus.OK);
    }
}
