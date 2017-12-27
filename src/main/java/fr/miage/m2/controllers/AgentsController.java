package fr.miage.m2.controllers;

import fr.miage.m2.service.AgentManager;
import fr.miage.m2.service.AgentsManagerImpl;
import fr.miage.m2.service.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/agents")
public class AgentsController {


    AgentManager agentManager = new AgentsManagerImpl();

    @PostMapping(value = "allocate")
    public ResponseEntity allocate(@RequestParam String idAgent, @RequestParam Integer idEvent) throws IOException{
        System.out.println("*****");
        System.out.println(idAgent +" | "+ idEvent);
        new Timer(idAgent,idEvent).run();
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
