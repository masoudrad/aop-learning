package ir.negoud.service;

import ir.negoud.model.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	public Employee createEmployee(String name, String empId) {

		Employee emp = new Employee();
		emp.setName(name);
		emp.setEmpId(empId);
		return emp;
	}

	public void deleteEmployee(String empId) throws Exception {
		System.out.println("Delete");
		try {
			throw new Exception();
		}catch (Exception e){
			e.getStackTrace();
		}
		
	}

	public Employee updateEmployee(String name,String empId,int age){
		Employee emp = new Employee();
		emp.setEmpId(empId);
		emp.setName(name);
		emp.setAge(age);
		return emp;
	}
}