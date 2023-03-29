package com.crudoperations;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.crudoperations.entities.Student;
import com.crudoperations.repository.StudentRepository;

@SpringBootTest
class CruddemoApplicationTests {

	@Autowired
	private StudentRepository studentRepo;
	
	@Test
	void saveOneStudent() {
		Student s = new Student();
		s.setName("surajs");
		s.setCourse("Analyst");
		s.setFee(30000);
		
		studentRepo.save(s);
	}

	@Test
	void deleteOneStudent() {
		studentRepo.deleteById(3L);
	}
	
	@Test
	void findOneStudent() {
		Optional<Student> findById = studentRepo.findById(2L);
		Student student = findById.get();
		System.out.println(student.getId());
		System.out.println(student.getName());
		System.out.println(student.getCourse());
		System.out.println(student.getFee());
	}
	@Test
	void findOneStudentByName() {
		Student student = studentRepo.findByName("shail");
		System.out.println(student.getId());
		System.out.println(student.getCourse());
		System.out.println(student.getFee());
	}
	@Test
	void updateOneStudent() {
		Optional<Student> findById = studentRepo.findById(1L);
		Student student = findById.get();
		student.setCourse("Testing");
		
		studentRepo.save(student);
	}
	@Test
	void getAllStudents() {
		Iterable<Student> findAll = studentRepo.findAll();
		for (Student student : findAll) {
			System.out.println(student.getId());
			System.out.println(student.getName());
			System.out.println(student.getCourse());
			System.out.println(student.getFee());
		}
	}
}
