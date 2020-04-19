package com.amsidh.mvc;

import java.util.Arrays;
import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;

import com.amsidh.mvc.mongo.document.Address;
import com.amsidh.mvc.mongo.document.Company;
import com.amsidh.mvc.mongo.document.Employee;
import com.amsidh.mvc.mongo.repositories.CompanyRepository;
import com.amsidh.mvc.mongo.repositories.EmployeeRepository;

@SpringBootApplication
@EnableWebFlux
@EnableMongoRepositories(basePackages = { "com.amsidh.mvc.mongo.repositories" })
public class EmplyeeDetailsReactiveAppApplication {

	@Autowired(required = true)
	private EmployeeRepository employeeRepository;
	@Autowired(required = true)
	private CompanyRepository companyRepository;

	public static void main(String[] args) {
		SpringApplication.run(EmplyeeDetailsReactiveAppApplication.class, args);
	}

	@Bean
	CommandLineRunner initializeSpringApp() {

		return (args) -> {
			employeeRepository.deleteAll().subscribe(null, null, () -> {
				Stream.of(
						new Employee("8410301", "Amsidh Lokhande", "amsidhlokhande@gmail.com", new Date(), 87853.323,
								new Address(UUID.randomUUID().toString(), "Pune-Pride World City", "Maharashtra",
										"India", 412105L),
								Arrays.asList(new Company(UUID.randomUUID().toString(), "Deutche Bank",
										Arrays.asList(
												new Address(UUID.randomUUID().toString(), "Pune-BusinessBay",
														"Maharashtra", "India", 411003L),
												new Address(UUID.randomUUID().toString(), "Pune-MagarPatta",
														"Maharashtra", "India", 411041L))))),
						new Employee("43534", "Madan Dale", "madaldale@gmail.com", new Date(), 65354.323,
								new Address(UUID.randomUUID().toString(), "Pune-Wakad", "Maharashtra", "India", 34543L),
								Arrays.asList(new Company(UUID.randomUUID().toString(), "KPI",
										Arrays.asList(
												new Address(UUID.randomUUID().toString(), "Pune-Hinjewadi",
														"Maharashtra", "India", 443432L),
												new Address(UUID.randomUUID().toString(), "Pune-Wakad", "Maharashtra",
														"India", 545443L))))))

						.forEach(employee -> employeeRepository.save(employee).subscribe(System.out::println));
			});

			companyRepository.deleteAll().subscribe(null, null, () -> {
				Stream.of(new Company(UUID.randomUUID().toString(), "Deutche Bank", Arrays.asList(
						new Address(UUID.randomUUID().toString(), "Pune-BusinessBay", "Maharashtra", "India", 411003L),
						new Address(UUID.randomUUID().toString(), "Pune-MagarPatta", "Maharashtra", "India", 411041L))),
						new Company(UUID.randomUUID().toString(), "KPI",
								Arrays.asList(
										new Address(UUID.randomUUID().toString(), "Pune-Hinjewadi", "Maharashtra",
												"India", 443432L),
										new Address(UUID.randomUUID().toString(), "Pune-Wakad", "Maharashtra", "India",
												545443L))))
						.forEach(company -> {
							companyRepository.save(company).subscribe(System.out::println);
						});
			});
		};
	}

}
