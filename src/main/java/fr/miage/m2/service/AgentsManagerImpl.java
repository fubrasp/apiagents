package fr.miage.m2.service;

import fr.miage.m2.connection.AgentDao;
import fr.miage.m2.metier.Agent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AgentsManagerImpl implements AgentManager{

    @Value("$maxEvents")
    int maxEvents;

    @Autowired
    AgentDao agentDao;

    @Override
    public void connect(int idAgent) {
        agentDao.setAvailability(idAgent, maxEvents );
    }

    @Override
    public void disconnect(int idAgent) {
        agentDao.setAvailability(idAgent, 0);
    }

    @Override
    public void receiveEvent(int idAgent, int idEvent) {
        Agent agent = new Agent(idAgent);
        agent.getEvents().add(idEvent);
        agentDao.setAvailability(idAgent,agentDao.getAvailability(idAgent)-1);
    }

    @Override
    public void consumeEvent(int idAgent, int idEvent) {
        Agent agent = new Agent(idAgent);
        if(agent.getEvents().contains(idEvent))
            agent.getEvents().remove(idEvent);
        agentDao.setAvailability(idAgent,agentDao.getAvailability(idAgent)+1);
    }
}
