package fr.miage.m2;

import fr.miage.m2.service.AgentManager;
import fr.miage.m2.service.AgentsManagerImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiagentsApplication implements CommandLineRunner {
public static void main(String[] args) {
		SpringApplication.run(ApiagentsApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		AgentManager agentManager = new AgentsManagerImpl();

		for (int i = 0; i < 2 ; i++) {
		    agentManager.connect(String.valueOf(i+1));
		}
	}
}
