package com.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.model.Student;

import com.repo.StudentRepo;
@Component
public class StudentServices {

	
	@Autowired
	StudentRepo sturepo;
	
	public void updateStudents(Student s, int id) {  

		s.setId(id);
		this.sturepo.save(s);
	
}
	
	public void deleteStudents(int id) {
		

		this.sturepo.deleteById(id);
	}
	
	public List<Student> getAllStudents() {


		List<Student> list = (List<Student>) this.sturepo.findAll();
		return list;
	}
	
	public Student addUsers(Student s) {
//      

		this.sturepo.save(s);

		return s;
	}
	
	public Optional<Student> getStudentById(int id) {
	    return sturepo.findById(id);
	}
	
}
