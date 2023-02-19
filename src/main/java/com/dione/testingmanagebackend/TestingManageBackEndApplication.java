package com.dione.testingmanagebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestingManageBackEndApplication {
//	private final RepositoryRestConfiguration restConfiguration;
//
//	public TestingManageBackEndApplication(RepositoryRestConfiguration restConfiguration) {
//		this.restConfiguration = restConfiguration;
//	}


	public static void main(String[] args) {
		SpringApplication.run(TestingManageBackEndApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		//Exposition des id
//		restConfiguration.exposeIdsFor(Releas.class);
//		restConfiguration.exposeIdsFor(Ticket.class);
//		restConfiguration.exposeIdsFor(Anomalie.class);
//		restConfiguration.exposeIdsFor(CasDeTest.class);
//		restConfiguration.exposeIdsFor(ScenarioDeTest.class);
//		restConfiguration.exposeIdsFor(Testeur.class);
//
//	}
}
