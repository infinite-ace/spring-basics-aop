package com.infinitelambda.demo.service;

public interface EmployeeService {
    public void createEmployee(String name);
    public void removeEmployee(Long id);
    public void updateEmployee(Long id, String name);
    public void findAllEmployee();
}
