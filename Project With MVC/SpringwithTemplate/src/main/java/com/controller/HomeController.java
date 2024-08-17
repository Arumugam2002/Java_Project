package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.model.Student;
import com.services.StudentServices;

@Controller
public class HomeController {

	@Autowired
	StudentServices sr;
	
	@GetMapping("/")
	public String index(Model m) {
		return "index";
	}
	
	@GetMapping("/register")
	public String register()
	{
		return "register";
	}
	
	@PostMapping("/add")
	public String add(@ModelAttribute Student s)
	{
		sr.addUsers(s);
		System.out.println(s);
		return "index";
	}
	
	@GetMapping("/about")
	public String about(Model m) {
		return "about";
	}
	
	@GetMapping("/contact")
	public String contact(Model m) {
		return "contact";
	}
	
	@GetMapping("/courses")
	public String courses(Model m) {
		return "courses";
	}
	
	@GetMapping("/team")
	public String team(Model m) {
		return "team";
	}
	
	@GetMapping("/testimonial")
	public String testimonial(Model m) {
		return "testimonial";
	}
	
	@GetMapping("/PageNotFound")
	public String PageNotFound(Model m) {
		return "PageNotFound";
	}
	
	@GetMapping("/home")
	public String home(Model m)
	{
		List<Student> list =  this.sr.getAllStudents();
		
		m.addAttribute("list", list);
		return "home";
	}
	
	@GetMapping("/edit/{id}")
	public String update( @PathVariable("id") int id, Model m)
	{
		Optional<Student> s = sr.getStudentById(id);
		
		if(s.isPresent())
		{
			m.addAttribute("s1", s.get());
			
			return "update";
			
		}
		
		else {
			return "redirect:/home";
		}
		
		
		
	}
	
	@PostMapping("/edit/{id}")
	public String updateStudent(@PathVariable("id") int id, @ModelAttribute Student s) {
	    sr.updateStudents(s, id);
	    System.out.println("Updated: " + s);
	    return "redirect:/home"; 
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id)
	{
		sr.deleteStudents(id);
		System.out.println("Deleted");
		return "redirect:/home	";
	}
	
	
	
	
	
	
	

}
