package fr.miage.m2.connection;

public interface AgentDao {

    void setAvailability(Integer idAgent, int possibleEvents);
    int getAvailability(Integer idAgent);
}
