package fr.miage.m2.service;

import org.springframework.beans.factory.annotation.Autowired;

public class Timer extends Thread {

	AgentManager agentManager = new AgentsManagerImpl();

	Integer idAgent;
	int idEvent;

	public Timer(Integer idAgent, int idEvent) {
		this.idAgent = idAgent;
        this.idEvent = idEvent;
	}

	@Override
	public void run() {		
		try {
			agentManager.receiveEvent(idAgent, idEvent);
			sleep(10000);
			agentManager.consumeEvent(idAgent,idEvent);
			stop();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
