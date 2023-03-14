package com.likeonashirt.twodue;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;

import com.likeonashirt.twodue.dto.TaskDTO;
import com.likeonashirt.twodue.model.Task;
import com.likeonashirt.twodue.model.User;
import com.likeonashirt.twodue.repository.TaskRepository;
import com.likeonashirt.twodue.repository.UserRepository;
import com.likeonashirt.twodue.service.TaskService;
import com.likeonashirt.twodue.service.UserService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TwoDueApplicationTests {

	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TaskService taskService;

	@Autowired
	private UserService userService;

	@ParameterizedTest
	@ValueSource(strings = { "johndoe@example.com", "janedoe@example.com" })
	@DisplayName("Test findByTaskassignee method in TaskRepository")
	public void testFindByTaskassignee(String email) {
		List<Task> tasks = taskRepository.findByTaskassignee(email);
		assertThat(tasks).isNotNull();
	}

	@org.junit.jupiter.api.Test
	@DisplayName("Test saveTask method in TaskService")
	public void testSaveTask() {
		TaskDTO taskDTO = new TaskDTO();
		taskDTO.setTaskname("Test task");
		taskDTO.setDuedate(LocalDateTime.now());
		String email = "johndoe@example.com";
		taskService.saveTask(taskDTO, email);
		List<Task> tasks = taskRepository.findByTaskassignee(email);
		assertThat(tasks).isNotEmpty();
	}

	@org.junit.jupiter.api.Test
	@DisplayName("Test getUserByEmailAndPassword method in UserService")
	public void testGetUserByEmailAndPassword() {
		User user = userService.createUser("johndoe@example.com", "John", "Doe", "John D", "password");
		User retrievedUser = userService.getUserByEmailAndPassword("johndoe@example.com", "password");
		assertThat(retrievedUser).isEqualTo(user);
	}

	@org.junit.jupiter.api.Test
	@DisplayName("Test emailExists method in UserService")
	public void testEmailExists() {
		User user = userService.createUser("johndoe@example.com", "John", "Doe", "John D", "password");
		boolean emailExists = userService.emailExists("johndoe@example.com");
		assertThat(emailExists).isTrue();
	}

}

