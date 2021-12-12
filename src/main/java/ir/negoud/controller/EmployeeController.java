package ir.negoud.controller;

import ir.negoud.model.Employee;
import ir.negoud.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/add/employee", method = RequestMethod.GET)
	public Employee addEmployee(@RequestParam("name") String name, @RequestParam("empId") String empId) {

		return employeeService.createEmployee(name, empId);

	}

	@RequestMapping(value = "/remove/employee", method = RequestMethod.GET)
	public String removeEmployee( @RequestParam("empId") String empId) {

		try {
			employeeService.deleteEmployee(empId);
		}catch (Exception e){
			logger.info("throw Exception in delete method");
//			e.printStackTrace();
		}


		return "Employee removed";
	}

	@RequestMapping(value = "/update/employee",method = RequestMethod.PUT)
	public Employee updateEmployee(@RequestParam("name") String name,@RequestParam("empId") String empId,@RequestParam("age") int age){
		return employeeService.updateEmployee(name,empId,age);
	}

}