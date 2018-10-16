package com.dreamapps.examples.employee.repository;

import com.dreamapps.examples.employee.domain.Employee;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

@Repository
public interface EmployeeRepository extends ReactiveMongoRepository<Employee,String> {

    Flux<Employee> findByFirstNameLike(String firstName);
    Flux<Employee> findByBirthDate(LocalDateTime birthDate);

}
