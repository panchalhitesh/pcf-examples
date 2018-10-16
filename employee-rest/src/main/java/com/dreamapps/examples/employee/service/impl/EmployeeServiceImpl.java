package com.dreamapps.examples.employee.service.impl;

import com.dreamapps.examples.employee.domain.Employee;
import com.dreamapps.examples.employee.repository.EmployeeRepository;
import com.dreamapps.examples.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Mono<Employee> add(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Flux<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Flux<Employee> getEmployeesByFirstName(String firstName) {
        return employeeRepository.findByFirstNameLike(firstName);
    }

    @Override
    public Flux<Employee> getEmployeesByBirthDate(LocalDateTime birthDate) {
        return employeeRepository.findByBirthDate(birthDate);
    }

    @Override
    public Mono<Employee> findById(String id) {
        return employeeRepository.findById(id);
    }
}
