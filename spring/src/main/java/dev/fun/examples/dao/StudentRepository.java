package dev.fun.examples.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.fun.examples.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
