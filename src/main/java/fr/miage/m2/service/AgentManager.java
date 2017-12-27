package fr.miage.m2.service;

public interface AgentManager {

    public void connect(String idAgent);
    public void disconnect(String idAgent);
    public void receiveEvent(String idAgent, int idEvent);
    public void consumeEvent(String idAgent, int idEvent);

}
