package fr.miage.m2.controllers;

import fr.miage.m2.service.AgentManager;
import fr.miage.m2.service.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class AgentsController {

    @Autowired
    AgentManager agentManager;

    @PostMapping(value = "/allocate", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public ResponseEntity allocate(@RequestBody String idAgent, int idEvent) throws IOException{
        new Timer(idAgent,idEvent).run();
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
