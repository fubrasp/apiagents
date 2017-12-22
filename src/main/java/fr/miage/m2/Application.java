package fr.miage.m2;

import fr.miage.m2.metier.Agent;
import fr.miage.m2.service.AgentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
