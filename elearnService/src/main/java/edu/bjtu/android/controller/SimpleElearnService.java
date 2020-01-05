package edu.bjtu.android.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.bjtu.android.entity.*;
import edu.bjtu.android.dao.*;

@RestController
@RequestMapping("/elearn")
public class SimpleElearnService {
	@Autowired
	CourseDao courseDao;
	
	@Autowired
	MaterialDao materialDao;
	
	@Autowired
	TeacherDao teacherDao;
	
	@Autowired
	CustomersDao customersDao;
	

	@RequestMapping(method = RequestMethod.GET, path = "/courses", produces = "application/json")
	public List<Course> allCources() {
		return courseDao.selectAll();
	}
	

	
	@RequestMapping(method = RequestMethod.GET, path = "/customers", produces = "application/json")
	public List<Customers> allCustomers() {
		return customersDao.selectAll();
	}

	@RequestMapping(method = RequestMethod.GET, path = "/{addCustomer}", produces = "application/json")
	public int addUser(@PathVariable("addCustomer") String addCustomer) {
		Customers customer = new Customers();
		String[] arr = addCustomer.split(",");
		customer.setUsername(arr[0]);
		customer.setPassword(arr[1]);
		customer.setEmail(arr[2]);
		int isAdded = customersDao.insert(customer);
		
    	return isAdded;
	}

	@RequestMapping(method = RequestMethod.GET, path = "courses/{courseid}/materials", produces = "application/json")
	public List<Material> getMaterials(@PathVariable("courseid") String courseid) {
		List<Material> materials = materialDao.selectByCourseId(courseid);
		return materials;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "courses/{courseid}/teachers", produces = "application/json")
	public List<Teacher> getTeacherbyCourseId(@PathVariable("courseid") String courseid) {
		List<Teacher> teacher = teacherDao.selectByCourseId(courseid);
		return teacher;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/courses/{id}", produces = "application/json")
	public Course getCourse(@PathVariable("id") String id) {
		Course course = courseDao.selectByPrimaryKey(id);
		return course;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/customers/{username}", produces = "application/json")
	public Customers getCustomerbyUsername(@PathVariable("username") String username) {
		Customers customers = customersDao.selectByPrimaryKey(username);
		return customers;
	}
	
	
	
	
}
