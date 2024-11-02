package com.project.EmployeeManagement.repository;
import com.project.EmployeeManagement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
