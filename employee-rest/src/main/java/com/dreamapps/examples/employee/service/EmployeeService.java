package com.dreamapps.examples.employee.service;

import com.dreamapps.examples.employee.domain.Employee;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

public interface EmployeeService {

    public Mono<Employee> add(Employee employee);
    public Mono<Employee> findById(String id);
    public Flux<Employee> getAllEmployees();
    public Flux<Employee> getEmployeesByFirstName(String firstName);
    public Flux<Employee> getEmployeesByBirthDate(LocalDateTime birthDate);

}
