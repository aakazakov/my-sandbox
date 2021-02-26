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

	@GetMapping("/actions/{act}")
	public String addOrUpdate(
				Model model, 
				@RequestParam(name = "id", required = false) Long id, 
				@PathVariable(name = "act") String act
			) {
		if (act.equals("add")) {
			model.addAttribute("student", new StudentDto());
		} else if (act.equals("update")) {
			model.addAttribute("student", fromStudent(repo.getOne(id)));
		}
		return "add-or-update-form";
	}
	
	@PostMapping("/add-or-update")
	public String addOrUpdate(StudentDto dto) {
		repo.save(toStudent(dto));
		return "redirect:/students/all";
	}
	
	@GetMapping("/all")
	public String getAll(Model model) {
		model.addAttribute("students", fromStudentList(repo.findAll()));
		return "index";
	}
	
	@GetMapping("/update")
	public String update(Model model, @RequestParam(name = "id") Long id) {
		model.addAttribute("student", fromStudent(repo.getOne(id)));
		return "update-form";
	}
	
	@GetMapping("/actions/delete")
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
