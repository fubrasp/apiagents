package fr.miage.m2.metier;

import java.util.List;

public class Agent{

    private int id;
    private List<Integer> events;

    public Agent(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public List<Integer> getEvents() {
        return events;
    }

    public void setEvents(List<Integer> events) {
        this.events = events;
    }

}
