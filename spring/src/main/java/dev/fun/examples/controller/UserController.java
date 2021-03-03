package dev.fun.examples.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.fun.examples.dao.UserRepository;
import dev.fun.examples.domain.Authority;
import dev.fun.examples.domain.Role;
import dev.fun.examples.domain.User;
import dev.fun.examples.dto.UserDto;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

	@Autowired
	private UserRepository repo;
	
	@GetMapping("/users")
	public List<UserDto> getAll() {
		return fromUserList(repo.findAll());
	}
	
	private List<UserDto> fromUserList(List<User> userList) {
		return userList.stream().map(this::fromUser).collect(Collectors.toList());
	}
	
	private UserDto fromUser(User user) {
		UserDto dto = new UserDto();
		dto.setId(user.getId());
		dto.setUsername(user.getUsername());
		dto.setPassword(user.getPassword());
		Role userRole = user.getRole();
		dto.setRoleTitle(userRole.getTitle());
		List<String> authTitles = userRole.getAuthorities().stream().map(Authority::getTitle).collect(Collectors.toList());
		dto.setAuthTitles(authTitles);
		return dto;
	}
	
}
