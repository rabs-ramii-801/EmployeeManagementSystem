package com.project.EmployeeManagement.controller;
import com.project.EmployeeManagement.model.Employee;
import org.springframework.ui.Model;
import com.project.EmployeeManagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String listEmployee(Model model){
        model.addAttribute("employees",employeeService.getAllEmployees());
        return "index";
    }

    @GetMapping("/employee/new")
    public String createEmployee(Model model){
        Employee employee=new Employee();
        model.addAttribute("employee",employee);
        return "create_employee";
    }

    @PostMapping("/employee/new")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/employee/edit/{id}")
    public String editEmployee(@PathVariable long id, Model model){
        Optional<Employee> employeeOptional=employeeService.getEmployeeById(id);
        // Check if the employee exists
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get(); // Extract Employee object
            model.addAttribute("employee", employee);
        } else {
            // Handle the case where the employee is not found (optional)
            throw new IllegalArgumentException("Invalid employee Id:" + id);
        }

        return "edit";
    }

    @PostMapping("/employee/edit/{id}")
    public String editEmployee(@PathVariable long id, @ModelAttribute("employee") Employee updateEmployee){
        Optional<Employee> employeeOptional=employeeService.getEmployeeById(id);
        // Check if the employee exists
        if (employeeOptional.isPresent()) {
            Employee existingEmployee = employeeOptional.get(); // Extract Employee object
            existingEmployee.setName(updateEmployee.getName());
            existingEmployee.setEmail(updateEmployee.getEmail());
            existingEmployee.setMobile(updateEmployee.getMobile());
            existingEmployee.setSalary(updateEmployee.getSalary());
            // Save the updated employee to the database
            employeeService.updateEmployee(existingEmployee);
        } else {
            // Handle the case where the employee is not found (optional)
            throw new IllegalArgumentException("Invalid employee Id:" + id);
        }
        return "redirect:/";

    }

    @GetMapping("/employee/delete/{id}")
    public String deleteEmployee(@PathVariable long id,  RedirectAttributes redirectAttributes){
        employeeService.deleteEmployeeById(id);
        // Add a success message to the redirect attributes
        redirectAttributes.addFlashAttribute("deleteMessage", "Employee deleted successfully!");

        // Redirect to the employee list page
        return "redirect:/";
    }
}
