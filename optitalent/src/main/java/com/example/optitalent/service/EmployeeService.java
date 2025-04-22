package com.example.optitalent.service;

import com.example.optitalent.models.Employee;
import com.example.optitalent.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado con ID: " + id));
    }

    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Employee existingEmployee = getEmployeeById(id);

        existingEmployee.setDni(employeeDetails.getDni());
        existingEmployee.setName(employeeDetails.getName());
        existingEmployee.setLastName(employeeDetails.getLastName());
        existingEmployee.setAddress(employeeDetails.getAddress());
        existingEmployee.setEmail(employeeDetails.getEmail());
        existingEmployee.setPhone(employeeDetails.getPhone());
        existingEmployee.setPassword(employeeDetails.getPassword());
        existingEmployee.setCompany(employeeDetails.getCompany());
        existingEmployee.setPosition(employeeDetails.getPosition());

        return employeeRepository.save(existingEmployee);
    }

    public void deleteEmployee(Long id) {
        Employee employee = getEmployeeById(id);
        employeeRepository.delete(employee);
    }
}
