package fr.miage.m2.metier;

import java.util.ArrayList;
import java.util.List;

public class Agent{

    private String id;
    private List<Integer> events;

    public Agent(String id) {
        this.id = id;
        events = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public List<Integer> getEvents() {
        return events;
    }

    public void setEvents(List<Integer> events) {
        this.events = events;
    }

}
