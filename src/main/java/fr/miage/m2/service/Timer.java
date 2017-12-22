package fr.miage.m2.service;

import org.springframework.beans.factory.annotation.Autowired;

public class Timer extends Thread {

	@Autowired
	AgentManager agentManager;

	int idAgent;
	int idEvent;

	public Timer(int idAgent, int idEvent) {
		this.idAgent = idAgent;
        this.idEvent = idEvent;
	}

	@Override
	public void run() {		
		try {
			agentManager.receiveEvent(idAgent, idEvent);
			sleep(120000);
			agentManager.consumeEvent(idAgent,idEvent);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
