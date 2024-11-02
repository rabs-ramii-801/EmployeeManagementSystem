package com.project.EmployeeManagement.service;

import com.project.EmployeeManagement.model.Employee;
import com.project.EmployeeManagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee>getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(long id){
        return employeeRepository.findById(id);
    }

    public void saveEmployee(Employee employee){
        employeeRepository.save(employee);
    }
    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);  // save() will either create or update the employee record
    }

    public void deleteEmployeeById(long id){
        employeeRepository.deleteById(id);
    }

}
