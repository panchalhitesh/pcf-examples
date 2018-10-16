package com.dreamapps.examples.employee;

import com.dreamapps.examples.employee.domain.Employee;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.mockito.Mockito.mock;
import static reactor.core.publisher.Mono.just;

@RunWith(SpringRunner.class)
//@AutoConfigureWebTestClient
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Slf4j
//@WebFluxTest
public class EmployeeServiceApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	public void testASaveEmployee(){
		final Mono<WebTestClient.ResponseSpec> postResponse = just(
				webTestClient
					.post()
					.uri("/employees/add")
					.body(just(getEmployeeObject()), Employee.class)
					.accept(MediaType.APPLICATION_JSON_UTF8)
					.exchange());

		postResponse
				.map(WebTestClient.ResponseSpec::expectBody)
				.subscribe(responseBody -> log.info("Saved data Response: "
						+responseBody.returnResult()));
	}

	@Test
	public void testfindAll(){
		final Mono<WebTestClient.ResponseSpec> getResponse = just(
				webTestClient
						.get()
						.uri("/employees/findAll")
						.accept(MediaType.APPLICATION_JSON_UTF8)
						.exchange());

		getResponse
				.map(WebTestClient.ResponseSpec::expectBody)
				.subscribe(responseBody -> log.info("Response: "
						+responseBody.returnResult()));
	}



	private Employee getEmployeeObject(){
		 Employee employee = new Employee();
		 employee.setFirstName("testFirst");
		 employee.setLastName("testFirst");
		 employee.setBirthDate(LocalDateTime.now());
		return employee;
	}

}
