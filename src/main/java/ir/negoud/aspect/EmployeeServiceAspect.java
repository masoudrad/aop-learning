package ir.negoud.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeServiceAspect {

	@Before(value = "execution(* ir.negoud.service.EmployeeService.*(..)) && args(name,empId,age)")
	public void beforeAdvice(JoinPoint joinPoint,String name,String empId,int age) {
		System.out.println("Before method:" + joinPoint.getSignature());

		System.out.println("Creating Employee with name - " + " and id - " );
	}

	@After(value = "execution(* ir.negoud.service.EmployeeService.*(String,String,int))")
	public void afterAdvice(JoinPoint joinPoint) {
		System.out.println("After method:" + joinPoint.getSignature());

		System.out.println("Successfully created Employee with name - "  + " and id - " );
	}
	@AfterThrowing(value =  "execution(* ir.negoud.service.EmployeeService.*(..))")
	public void afterThrowingAdvice(JoinPoint joinPoint){
		System.out.println("After method " + joinPoint.getSignature() + " throws exception!");
	}
}
