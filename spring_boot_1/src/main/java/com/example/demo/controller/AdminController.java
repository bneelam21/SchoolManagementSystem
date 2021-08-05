package com.example.demo.controller;


import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Teacher;
import com.example.demo.model.TeacherAttendence;
import com.example.demo.model.NonTeachingStaff;
import com.example.demo.model.NonTeachingStaffAttendence;
import com.example.demo.model.Student;
import com.example.demo.model.StudentAttendance;
import com.example.demo.service.AdminService;



@RestController
@RequestMapping("school/admin")
public class AdminController  
{
	private AdminService adminservice;
	
	public AdminController(AdminService adminservice) 
	{
		this.adminservice = adminservice;
	}
	
	//Controller method to insert student 
	@PostMapping(path="student/insert", consumes=MediaType.APPLICATION_JSON_VALUE)
	public String InsertStudent(@RequestBody Student student)
	{
		adminservice.insertStudent(student);
		return "Insertion Successfully";
	}
	
	//Controller method to retreiving student details
	@GetMapping(path="student/list")
	public List<Student> getStudentDetails()
	{
		return adminservice.getStudents();
	}
	
	//Controller method to delete the student details using id
	@GetMapping(path="student/delete")
	public void deleteStudentRecord(@RequestParam String id) 
	{
		adminservice.deleteStudent(id);
		System.out.println("Deleted Successfully");
	}
	
	//Controller method to get the student detail by id
	@GetMapping(path="student/byid")
	public Optional<Student> getStudentById(@RequestParam String id)
	{
		return adminservice.getStudentDetail(id);
	}
	
	//Controller method to update the details of student
	@PutMapping(path="student/update", consumes=MediaType.APPLICATION_JSON_VALUE)
	public String updateStudent(@RequestBody Student student)
	{
		adminservice.getUpdate(student);
		return "Updated Successfully";
	}
	
	//Controller method to insert the details of Teacher
	@PostMapping(path = "Teacher/insert", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> InsertEmployee(@RequestBody Teacher teacher)
	{
		try
		{
			//int i = 1/0;
			adminservice.insertEmployee(teacher);
			return ResponseEntity.ok("Exam conducted");
		}
		catch(RuntimeException re)
		{
			System.out.print(re);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("by zero error occured");
		}
	}	
	
	//Controller method to Count the number of Teacher
	@GetMapping(path = "Teacher/count")
	public long CountEmployee()
	{
		return adminservice.countEmployees();
	}
	
	//Controller method to retrieve the Teachers
	@GetMapping(path = "Teacher/list") 
	public List<Teacher> getAllEmployees()   
	{  
		return adminservice.getAllEmployees(); 
	}  
	
	//Controller method to update the Teacher
	@PutMapping(path = "employee/update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String UpdateEmployee(@RequestBody Teacher teacher)
	{
		adminservice.updateemployee(teacher);
		return "update successful";
	}	
	
	//Controller method to retrieve a particular record by id
	@GetMapping(path="employee/byid")
	public Object EmployeeDetailsbyid(@RequestParam String employee_id){
		return adminservice.employeedetailsbyid(employee_id);
	}
	
	//Controller method to delete the record of employee
	@GetMapping(path="employee/delete")
	public void deleteEmployeeRecord(@RequestParam String employee_id) 
	{
		adminservice.deleteEmployeerecord(employee_id);
		System.out.println("Deleted Successfully");
	}
	
	//Controller method to add a non teaching staff
	@PostMapping(path="insertstaff", consumes=MediaType.APPLICATION_JSON_VALUE)
	public String InsertStudent(@RequestBody NonTeachingStaff nonTeachingStaff)
	{
		adminservice.insertStaff(nonTeachingStaff);
		return "Insertion Successfully";
	}
		
	//controller method to list all non teaching staff
	@GetMapping(path="staff/list")
	public List<NonTeachingStaff> getStaffList()
	{
		return adminservice.getStaffList();
	}
		
	//controller method to remove a non teaching staff using id
	@GetMapping(path="staff/delete/byid")
	public String removeStaff(@RequestParam String employee_id) 
	{
		adminservice.removeStaff(employee_id);
		return "staff removed successfully";
	}
		
	//controller method to show a non teaching staff using id
	@GetMapping(path="staff/byid")
	public Object getEmployeeById(@RequestParam String employee_id)
	{
		return adminservice.getEmployeeById(employee_id);
	}
	
	/*@GetMapping(path = "insert")
	public String InsertDetailsOfStudent(@RequestParam String studentid,@RequestParam String rank,@RequestParam String class_room)
	{
		Student st = new Student();
		st.setStudent_id(studentid);
		st.setRank(rank);
		st.setClass_room(class_room);
		if(adminservice.Addstudent(st)==1)
		{
			return "success";
		}
		else 
		{
			return "Failed to insert";
		}
	}
	
	@GetMapping(path = "update")
	public String UpdateDetailsOfStudent(@RequestParam String student_id,@RequestParam String rank)
	{
		Student st = new Student();
		st.setStudent_id(student_id);
		st.setRank(rank);
		if(adminservice.UpdateStudent(st)==1)
		{
			return "updated successful";
		}
		else 
		{
			return "update failure";
		}
	}*/
	
	//Controller method for employee login
	@PostMapping(path="Employee/login",consumes=MediaType.APPLICATION_JSON_VALUE)
	public String EmployeeLogin(@RequestBody TeacherAttendence teacherAttendence) 
	{
		Time login_time=new Time(System.currentTimeMillis());
		teacherAttendence.setLogintime(login_time);
		LocalDate entry_date=LocalDate.now();
		teacherAttendence.setEntry_date(entry_date);
		adminservice.employeelogin(teacherAttendence);
		return "Login Successful";
	}
	
	//Controller method for employee logout
	@PostMapping(path = "Employee/logout", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String logout(@RequestBody TeacherAttendence teacherAttendence) 
	{
		Time time = new Time(System.currentTimeMillis());
		LocalDate entry_date=LocalDate.now();
		teacherAttendence.setLogouttime(time);
		teacherAttendence.setEntry_date(entry_date);
		adminservice.employeelogout(teacherAttendence);
		return "logout Succsessful";
	}
	
	//Controller method to retrieve the details by date
	@GetMapping(path = "Employee/attendence/date")
	public Collection<TeacherAttendence> RetrieveByDate(@RequestParam String date)
	{
		return adminservice.retrievebydate(date);
	}
	
	//Controller method for student login
	@PostMapping(path="student/login", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void Studentlogin(@RequestBody StudentAttendance studentattendance)
	{
		Time time = new Time(System.currentTimeMillis());
		long millis=System.currentTimeMillis();
		LocalDate entry_date=LocalDate.now();
		studentattendance.setLogin_time(time);
		studentattendance.setEntry_date(entry_date);
		adminservice.studentLogin(studentattendance);
	}
	
	//Controller method for student logout
	@PostMapping(path="student/logout", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void Studentlogout(@RequestBody StudentAttendance studentattendance)
	{
		Time time = new Time(System.currentTimeMillis());
		studentattendance.setLogout_time(time);
		long millis=System.currentTimeMillis();
		LocalDate entry_date=LocalDate.now();
		studentattendance.setEntry_date(entry_date);
		adminservice.StudentLogout(studentattendance);
	}
	
	//Controller method for staff login
	@PostMapping(path="staff/login",consumes=MediaType.APPLICATION_JSON_VALUE)
	public String nonTeachStaffLogin(@RequestBody NonTeachingStaffAttendence nonTeachingStaffAttendence) 
	{
		Time login_time=new Time(System.currentTimeMillis());
		nonTeachingStaffAttendence.setLogin_time(login_time);
		LocalDate entry_date=LocalDate.now();
		nonTeachingStaffAttendence.setEntry_date(entry_date);
		adminservice.nonTeachStaffLogin(nonTeachingStaffAttendence);
		return "student logged in at "+login_time+" on "+entry_date;
	}
	
	//Controller method for staff logout
	@PostMapping(path = "staff/logout", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String nonTeachStaffLogout(@RequestBody  NonTeachingStaffAttendence nonTeachingStaffAttendence) 
	{
		Time logout_time = new Time(System.currentTimeMillis());
		LocalDate entry_date=LocalDate.now();
		nonTeachingStaffAttendence.setLogout_time(logout_time);
		nonTeachingStaffAttendence.setEntry_date(entry_date);
		adminservice.nonTeachStaffLogout(nonTeachingStaffAttendence);
		return "logout Succsessful";
	}
}
