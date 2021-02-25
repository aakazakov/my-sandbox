package dev.fun.examples.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import dev.fun.examples.dao.StudentRepository;
import dev.fun.examples.domain.Student;
import dev.fun.examples.dto.StudentDto;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentRepository repo;
	
	@PostMapping("/add")
	public StudentDto add(@RequestBody StudentDto dto) {
		return fromStudent(repo.save(toStudent(dto)));
	}
	
	@GetMapping("/all")
	public List<StudentDto> getAll() {
		return fromStudentList(repo.findAll());
	}
	
	@GetMapping("/id/{id}")
	public StudentDto get(@PathVariable(name = "id") Long id) {
		return fromStudent(repo.findById(id).orElse(new Student()));
	}
	
	@PutMapping("/update")
	public StudentDto update(@RequestBody StudentDto dto) {
		if (dto.getId() == null) {
			throw new IllegalArgumentException("id must not be null");
		}
		return fromStudent(repo.save(toStudent(dto)));
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestParam(name = "id") Long id) {
		repo.deleteById(id);
	}
	
	private List<StudentDto> fromStudentList(List<Student> students) {
		List<StudentDto> dtoList = new ArrayList<>();
		for (Student s : students) {
			dtoList.add(fromStudent(s));
		}
		return dtoList;
	}
	
	private StudentDto fromStudent(Student s) {
		StudentDto dto = new StudentDto();
		if (s.getId() != null)
			dto.setId(s.getId());
		if (s.getName() != null)
			dto.setName(s.getName());
		if (s.getAge() != null)
			dto.setAge(s.getAge());
		return dto;
	}
	
	private Student toStudent(StudentDto dto) {
		Student s = new Student();
		if (dto.getId() != null)
			s.setId(dto.getId());
		if (dto.getName() != null)
			s.setName(dto.getName());
		if (dto.getAge() != null)
			s.setAge(dto.getAge());
		return s;
	}
	

}
