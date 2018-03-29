package fr.miage.m2.controller;

import fr.miage.m2.metier.Agent;
import fr.miage.m2.service.AgentManager;
import fr.miage.m2.service.AgentsManagerImpl;
import fr.miage.m2.service.Timer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/agents")
public class AgentsController {


    AgentManager agentManager = new AgentsManagerImpl();

    @PostMapping(value = "allocate")
    public ResponseEntity allocate(@RequestParam Integer idAgent, @RequestParam Integer idEvent) throws IOException{
        System.out.println("*****");
        System.out.println(idAgent +" | "+ idEvent);
        new Timer(idAgent,idEvent).run();
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @PostMapping(value = "connect")
    public ResponseEntity connect(@RequestBody List<Agent> agents) throws IOException{
        for (Agent agent:agents) {
            agentManager.connect(agent.getId());
        }
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
