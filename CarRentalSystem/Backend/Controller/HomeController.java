package com.project.carrentalsystem.Controller;

import  org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties.ShowSummary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.carrentalsystem.Model.Employee;
import com.project.carrentalsystem.Service.EmployeeService;

@Controller
public class HomeController {

	//99999999999999999999999999999999999999999444444444444444444444444444444994949994949494
	//87887787848743874378438747843874387347848747847848747843784784784874837477384
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public String homePage(Model model)
	{
		return "index";
	}
	
	
	
	@PostMapping("/registerEmployee") 
    public String addEmployee(@ModelAttribute("employee") Employee employee) {
        Employee savedEmployee = employeeService.addEmployee(employee);
        System.out.println("............................."+employee.getAccountType());
        System.out.println("saved employee ----------------"+savedEmployee);
        return "registrationSuccess"; 
    }
	
	
	 	@GetMapping("/registerEmployee")
	    public String showRegisterEmployeePage(Model model) {
	        model.addAttribute("employee", new Employee());
	        return "registerEmployee";
	    }
}
