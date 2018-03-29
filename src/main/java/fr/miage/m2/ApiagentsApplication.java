package fr.miage.m2;

import com.google.gson.Gson;
import fr.miage.m2.metier.Agent;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.ArrayList;
import java.util.List;

@EnableRabbit
@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class ApiagentsApplication implements CommandLineRunner {
public static void main(String[] args) {
		SpringApplication.run(ApiagentsApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

		/*AgentManager agentManager = new AgentsManagerImpl();
		for (int i = 0; i < 2 ; i++) {
		    agentManager.connect(String.valueOf(i+1));
		}*/

		/*List<Agent> agents = new ArrayList<>();
		agents.add(new Agent("1"));
		agents.add(new Agent("8"));
		agents.add(new Agent("33"));
		agents.add(new Agent("26"));
		agents.add(new Agent("62"));
		agents.add(new Agent("19"));
		agents.add(new Agent("12"));
		agents.add(new Agent("11"));
		agents.add(new Agent("10"));
		agents.add(new Agent("51"));
		agents.add(new Agent("43"));

		Gson gson = new Gson();
		System.out.println(gson.toJson(agents));*/
	}
}
