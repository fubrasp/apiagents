package fr.miage.m2.metier;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Agent implements Serializable{

    private Integer id;
    private List<Integer> events;

    public Agent() {
    }

    public Agent(Integer id) {
        this.id = id;
        events = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public List<Integer> getEvents() {
        return events;
    }

    public void setEvents(List<Integer> events) {
        this.events = events;
    }

}
