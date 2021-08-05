package com.example.demo.service;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Teacher;
import com.example.demo.model.TeacherAttendence;
import com.example.demo.model.NonTeachingStaff;
import com.example.demo.model.NonTeachingStaffAttendence;
import com.example.demo.model.Student;
import com.example.demo.model.StudentAttendance;
import com.example.demo.repository.TeacherAttendenceRepository;
import com.example.demo.repository.TeacherRepository;
import com.example.demo.repository.NonTeachingStaffAttendenceRepository;
import com.example.demo.repository.NonTeachingStaffRepository;
import com.example.demo.repository.StudentAttendanceRepository;
import com.example.demo.repository.StudentInterfaceRepository;
import com.example.demo.repository.StudentRepository;

@Service
public class AdminService {
	
	private StudentRepository studentrepository;
	private TeacherRepository employeerepository;
	private StudentInterfaceRepository studentintrepository;
	private NonTeachingStaffRepository nonTeachingStaffRepository;
	private TeacherAttendenceRepository teacherAttendenceRepository;
	private StudentAttendanceRepository studentattendancerepository;
	private NonTeachingStaffAttendenceRepository nonTeachingStaffAttendenceRepository;
	private RestTemplate restTemplate;

	
	public AdminService(StudentRepository studentrepository,TeacherRepository employeerepository,StudentInterfaceRepository studentintrepository
			,NonTeachingStaffRepository nonTeachingStaffRepository,TeacherAttendenceRepository teacherAttendenceRepository,
			StudentAttendanceRepository studentattendancerepository,NonTeachingStaffAttendenceRepository nonTeachingStaffAttendenceRepository,
			RestTemplate restTemplate )
	{
		this.studentrepository = studentrepository;
		this.employeerepository = employeerepository;
		this.studentintrepository = studentintrepository;
		this.nonTeachingStaffRepository = nonTeachingStaffRepository;
		this.teacherAttendenceRepository = teacherAttendenceRepository;
		this.studentattendancerepository = studentattendancerepository;
		this.nonTeachingStaffAttendenceRepository = nonTeachingStaffAttendenceRepository;
		this.restTemplate = restTemplate;
	}
	
	
	
	
	
	//Service method to add a student
	public void insertStudent(Student student) 
	{
		studentintrepository.save(student);
	}
	
	//Service method to retrieve all students
	public List<Student> getStudents() 
	{
		return (List<Student>) studentintrepository.findAll();
	}
	
	//Service method to delete a student by id
	public String deleteStudent(String id) 
	{
		studentintrepository.deleteById(id);
		return "Deleted Successfully";
	}
	
	//Service method to get the details of student by id
	public Optional<Student> getStudentDetail(String student_id) 
	{
		return studentintrepository.findById(student_id);
	}
	
	//Service method to update the details of student
	public Student getUpdate(Student student)
	{
		return studentintrepository.save(student);
	}
	
	//Service method to insert the employee details
	public void insertEmployee(Teacher teacher) 
	{
		employeerepository.save(teacher);
	}
	
	//Service method to count the number of employees
	public long countEmployees() 
	{
		return employeerepository.count();
	}
	
	//Service method to get the details of all employees
	public List<Teacher> getAllEmployees() 
	{
		List<Teacher> list = new ArrayList<Teacher>();
		employeerepository.findAll().forEach(list::add);
		return list;
	}
	
	//Service method to update the details of the employee
	public Teacher updateemployee(Teacher teacher) 
	{
		return employeerepository.save(teacher);
	}
	
	//Service method to delete the employee record by id
	public String deleteEmployeerecord(String employee_id) 
	{
		employeerepository.deleteById(employee_id);
		return "Deleted Successfully";
	}

	//Service method to get the details of a particular employee by id
	public Object employeedetailsbyid(String employee_id) 
	{
		return employeerepository.findById(employee_id);
	}

	// Service method to add a staff member
	public void insertStaff(NonTeachingStaff nonTeachingStaff) 
	{
		nonTeachingStaffRepository.save(nonTeachingStaff);
	}

	// Service method to print list of staff
	public List<NonTeachingStaff> getStaffList() 
	{
		return (List<NonTeachingStaff>) nonTeachingStaffRepository.findAll();
	}

	// Service method to remove staff by using id
	public void removeStaff(String employee_id) 
	{
		nonTeachingStaffRepository.deleteById(employee_id);
	}

	// Service method to get staff details by using id
	public Object getEmployeeById(String employee_id) 
	{
		return nonTeachingStaffRepository.findById(employee_id);
	}

	/*public int Addstudent(Student student) 
	{
		return studentrepository.AddStudent(student);
	}

	public int UpdateStudent(Student student) 
	{
		return studentrepository.UpdateStudent(student);
	}*/
	
	//Service method for Employee login
	public void employeelogin(TeacherAttendence teacherAttendence) throws RuntimeException
	{
		try
		{
		ResponseEntity<String> entity = restTemplate.postForEntity("http://localhost:8095/school/admin/Employee/login",teacherAttendence, String.class);
		System.out.println(entity.getBody());
		}
		catch(RuntimeException e)
		{
			System.out.print(e);
		}
		teacherAttendenceRepository.save(teacherAttendence);
	}
	
	
	//Service method for Employee logout
	@Transactional
	public void employeelogout(TeacherAttendence employeeAttendance) 
	{
		teacherAttendenceRepository.upadateLogoutTime(employeeAttendance.getLogouttime(),
				employeeAttendance.getEmployee_id(), employeeAttendance.getEntry_date());
	}
	
	//Service method for retrieving details by date
	public Collection<TeacherAttendence> retrievebydate(String date) 
	{
		return teacherAttendenceRepository.Getbydate(date);
	}
	
	//Service method for Student login
	public void studentLogin(StudentAttendance studentattendance) {
		studentattendancerepository.save(studentattendance);
	}
	
	//Service method for student logout
	@Transactional
	public void StudentLogout(StudentAttendance studentattendance)
	{
		studentattendancerepository.updateLogout(studentattendance.getLogout_time(),studentattendance.getStudent_id(),studentattendance.getEntry_date());
	}
	
	//Service method for staff login
	public void nonTeachStaffLogin(NonTeachingStaffAttendence nonTeachingStaffAttendence) 
	{
		nonTeachingStaffAttendenceRepository.save(nonTeachingStaffAttendence);
	}
	
	//Service method for staff logout
	@Transactional
	public void nonTeachStaffLogout(NonTeachingStaffAttendence nonTeachingStaffAttendence) 
	{
		nonTeachingStaffAttendenceRepository.updateLogoutTime(nonTeachingStaffAttendence.getLogout_time(),
				nonTeachingStaffAttendence.getEmployee_id(), nonTeachingStaffAttendence.getEntry_date());
	}
	
}
