package com.infinitelambda.demo;

import com.infinitelambda.demo.entity.Employee;
import com.infinitelambda.demo.repository.EmployeeRepo;
import java.util.Optional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private final EmployeeRepo employeeRepo;

    public DemoApplication(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    private void createEmployee(String name) {
        Employee employee = new Employee();
        employee.setName(name);
        employeeRepo.save(employee);
    }

    private void removeEmployee(Long id) {
        Optional<Employee> optionalEmployee = employeeRepo.findById(id);
        if (optionalEmployee.isPresent()) {
            employeeRepo.delete(optionalEmployee.get());
        } else {
            System.out.println("This employee is not existed.");
        }
    }

    private void updateEmployee(Long id, String name) {
        Optional<Employee> optionalEmployee = employeeRepo.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setName(name);
            employeeRepo.save(employee);
        } else {
            System.out.println("This employee is not existed.");
        }
    }

    private void findAllEmployee() {
        for (Employee employee : employeeRepo.findAll()) {
            System.out.println(employee.getId() + " " + employee.getName());
        }
    }

    @Override
    public void run(String... args) throws Exception {
        createEmployee("Employee 1");
        createEmployee("Employee 2");
        findAllEmployee();
        updateEmployee(1l, "New Employee 1");
        findAllEmployee();
        removeEmployee(1l);
        findAllEmployee();
    }
}
