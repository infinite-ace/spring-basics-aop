package com.infinitelambda.demo;

import com.infinitelambda.demo.entity.Employee;
import com.infinitelambda.demo.repository.EmployeeRepo;
import java.util.Optional;
import com.infinitelambda.demo.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    EmployeeService employeeService;

    public DemoApplication(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        employeeService.createEmployee("Employee 1");
        employeeService.createEmployee("Employee 2");
        employeeService.findAllEmployee();
        employeeService.updateEmployee(1l, "New Employee 1");
        employeeService.findAllEmployee();
        employeeService.removeEmployee(1l);
        employeeService.findAllEmployee();
    }
}
