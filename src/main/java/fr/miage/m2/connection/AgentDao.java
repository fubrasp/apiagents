package fr.miage.m2.connection;

public interface AgentDao {

    void setAvailability(int idAgent,int possibleEvents);
    int getAvailability(int idAgent);
}
