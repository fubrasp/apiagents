package fr.miage.m2;

import fr.miage.m2.service.AgentManager;
import fr.miage.m2.service.AgentsManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.SQLException;

@SpringBootApplication
public class Application {
    @Autowired
    static AgentManager agentManager;

    public static void main(String[] args) throws SQLException {

        SpringApplication.run(Application.class, args);

        for (int i = 0; i < 81 ; i++) {
            agentManager.connect(i);
        }


    }

}
