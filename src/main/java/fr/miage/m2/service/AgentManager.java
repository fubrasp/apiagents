package fr.miage.m2.service;

public interface AgentManager {

    public void connect(Integer idAgent);
    public void disconnect(Integer idAgent);
    public void receiveEvent(Integer idAgent, int idEvent);
    public void consumeEvent(Integer idAgent, int idEvent);

}
