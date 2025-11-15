package com.app.taskmanager.service;

import com.app.taskmanager.dto.TaskRequest;
import com.app.taskmanager.dto.TaskResponse;

import java.util.List;

public interface TaskService {

    TaskResponse create(TaskRequest request);

    TaskResponse update(Long id, TaskRequest request);

    TaskResponse getById(Long id);

    List<TaskResponse> getAll();

    void delete(Long id);

}
