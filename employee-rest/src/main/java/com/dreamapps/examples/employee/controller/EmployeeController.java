package com.dreamapps.examples.employee.controller;

import com.dreamapps.examples.employee.domain.Employee;
import com.dreamapps.examples.employee.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController()
@RequestMapping("/employees")
@Api(value="employee", description="Employee rest accessor apis", produces = "application/json")
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "/add")
    @ApiOperation(value = "Save a new employee")
    @CachePut(value = "employees", key = "#employee.id")
    public Mono<Employee> add(@Valid @RequestBody Employee employee){
        return employeeService.add(employee);
    }

    @GetMapping(value = "/findAll")
    @ApiOperation(value = "Returns all employees")
    @Cacheable(value = "employees", key = "#employee.id")
    public Flux<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @ApiOperation(value = "Returns all employees by First name like")
    @GetMapping(value = "/findByFirstName/{firstName}")
    @Cacheable(value = "employees", key = "#employee.firstName")
    public Flux<Employee> getAllEmployeesByFirstName(@PathVariable(value = "firstName") String firstName){
        return employeeService.getEmployeesByFirstName(firstName);
    }

    @GetMapping(value = "/findByBirthDate")
    @ApiOperation(value = "Returns all employees with provided Birthdate")
    @Cacheable(value = "employees", key = "#employee.birthDate")
    public Flux<Employee> getAllEmployeesByBirthDate(@RequestBody LocalDateTime localDateTime){
        return employeeService.getEmployeesByBirthDate(localDateTime);
    }

    @ApiOperation(value = "Returns employee by Id")
    @GetMapping(value = "/findById/{id}")
    @Cacheable(value = "employees", key = "#employee.id")
    public Mono<Employee> findById(@PathVariable(value = "id") String id) {
        return employeeService.findById(id);
    }
}
