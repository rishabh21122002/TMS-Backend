package com.sam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sam.dto.CountType;
import com.sam.model.Task;
import com.sam.repositories.TaskRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	@Transactional(readOnly = true)
	public List<Task> getTasks(){
		return taskRepository.getAllTaskDueDateDesc();
	}
	@Transactional
	public Task save(Task task) {
		return taskRepository.saveAndFlush(task);
	}
	@Transactional(readOnly = true)
	public boolean existById(Long id) {
		return taskRepository.existsById(id);
	}
	@Transactional(readOnly = true)
	public Optional<Task> getTaskById(Long id) {
		System.out.println("service");
		System.out.println(taskRepository.findById(id));
		return taskRepository.findById(id);
	}
	public void delete(Long id) {
		taskRepository.deleteById(id); 
	}
	
	public List<CountType> getPercentageGroupByType() {
		return taskRepository.getPercentageGroupByType();
		
	}
	

}
