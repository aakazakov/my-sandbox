package dev.fun.examples.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import dev.fun.examples.dao.StudentRepository;
import dev.fun.examples.domain.Student;
import dev.fun.examples.dto.StudentDto;

@Controller
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentRepository repo;

	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("student", new StudentDto());
		return "add-form";
	}
	
	@PostMapping("/add")
	public String add(StudentDto dto) {
		repo.save(toStudent(dto));
		return "redirect:/students/all";
	}
	
	@GetMapping("/all")
	public String getAll(Model model) {
		model.addAttribute("students", fromStudentList(repo.findAll()));
		return "index";
	}
	
	@GetMapping("/id/{id}")
	public StudentDto get(@PathVariable(name = "id") Long id) {
		return fromStudent(repo.findById(id).orElse(new Student()));
	}
	
//	@GetMapping("/update")
//	public String update(Model model) {
//		
//	}
	
	@PutMapping("/update")
	public StudentDto update(StudentDto dto) {
		if (dto.getId() == null) {
			throw new IllegalArgumentException("id must not be null");
		}
		return fromStudent(repo.save(toStudent(dto)));
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam(name = "id") Long id) {
		repo.deleteById(id);
		return "redirect:/students/all";
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
