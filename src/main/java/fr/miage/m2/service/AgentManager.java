package fr.miage.m2.service;

public interface AgentManager {

    public void connect(int idAgent);
    public void disconnect(int idAgent);
    public void receiveEvent(int idAgent, int idEvent);
    public void consumeEvent(int idAgent, int idEvent);

}
