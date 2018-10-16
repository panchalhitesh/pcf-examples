package com.dreamapps.examples.employee.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Document(collection = "employee")
public class Employee {

    @Id
    @Getter
    private String id;

    @NotBlank
    @Size(max=40)
    private String firstName;

    @NotBlank
    @Size(max=40)
    private String lastName;

    @Builder.Default()
    private LocalDate birthDate =  LocalDate.now();

    @Builder.Default()
    private LocalDateTime lastModified = LocalDateTime.now();

    @Builder.Default()
    private LocalDateTime createTimestamp = LocalDateTime.now();
}
