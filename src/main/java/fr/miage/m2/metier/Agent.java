package fr.miage.m2.metier;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Agent implements Serializable{

    private String id;
    private List<Integer> events;

    public Agent() {
    }

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
