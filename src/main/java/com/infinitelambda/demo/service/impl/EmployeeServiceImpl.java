package com.infinitelambda.demo.service.impl;

import com.infinitelambda.demo.entity.Employee;
import com.infinitelambda.demo.repository.EmployeeRepo;
import com.infinitelambda.demo.service.EmployeeService;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @PreDestroy
    public void sayGoodBye() {
        System.out.println("Goodbye from Employee Service.");
    }

    @PostConstruct
    public void sayHi() {
        System.out.println("Hi from Employee Service.");
    }

    public void createEmployee(String name) {
        Employee employee = new Employee();
        employee.setName(name);
        employeeRepo.save(employee);
    }

    public void removeEmployee(Long id) {
        Optional<Employee> optionalEmployee = employeeRepo.findById(id);
        if (optionalEmployee.isPresent()) {
            employeeRepo.delete(optionalEmployee.get());
        } else {
            System.out.println("This employee is not existed.");
        }
    }

    public void updateEmployee(Long id, String name) {
        Optional<Employee> optionalEmployee = employeeRepo.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setName(name);
            employeeRepo.save(employee);
        } else {
            System.out.println("This employee is not existed.");
        }
    }

    public void findAllEmployee() {
        for (Employee employee : employeeRepo.findAll()) {
            System.out.println(employee.getId() + " " + employee.getName());
        }
    }
}
