package fr.miage.m2.connection;

public interface AgentDao {

    void setAvailability(String idAgent, int possibleEvents);
    int getAvailability(String idAgent);
}
