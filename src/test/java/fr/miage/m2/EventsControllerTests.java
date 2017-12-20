/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package fr.miage.m2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.miage.m2.connection.AgentDao;
import fr.miage.m2.genetics.GA;
import fr.miage.m2.metier.Agent;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EventsControllerTests {

    @Autowired
    private AgentDao agentDao;


    @Test
    public void geneticsRun(){
        ArrayList<Agent> agents = getAgents();
        ArrayList<Event> events = getEvents();
        Map<Event, Agent> bestSolutions = GA.genetics(events, agents);
        System.out.println(bestSolutions.toString());
    }

    @Test
    public void geneticsMutate() {
        Map<Map<Event, Agent>, Double> bestSolutions = getBestsolutionsExample();

        //On copie la Map pour pouvoire comparer
        Map<Map<Event, Agent>, Double> bestSolutionsModified = new HashMap<Map<Event, Agent>, Double>(bestSolutions);

        bestSolutionsModified = (Map<Map<Event, Agent>, Double>) GA.mutate(bestSolutionsModified);

        System.out.println("***source data***");
        System.out.println(bestSolutions.toString());
        System.out.println("***mutate data***");
        System.out.println(bestSolutionsModified.toString());

        Assert.assertNotEquals(bestSolutions, bestSolutionsModified);
    }
    private Map<Map<Event, Agent>, Double> getBestsolutionsExample(){

        Map<Map<Event, Agent>, Double> bestSolutions = new HashMap<Map<Event, Agent>, Double>();

        Map<Event, Agent> resultat = new HashMap<Event, Agent>();

        List<Event> events = getEvents();
        List<Agent> agents = getAgents();

        for (Event event:
                events) {
            event.setBestAvgExecTime(EntityManager.getInstance().averageExecutionTime(event.getIdevent_type()));
        }

        resultat.put(events.get(0), agents.get(0));
        resultat.put(events.get(1), agents.get(1));
        resultat.put(events.get(2), agents.get(2));
        resultat.put(events.get(3), agents.get(3));
        resultat.put(events.get(4), agents.get(4));
        resultat.put(events.get(5), agents.get(5));
        resultat.put(events.get(6), agents.get(6));
        resultat.put(events.get(7), agents.get(7));
        resultat.put(events.get(8), agents.get(8));

        Iterator resultatIterator = resultat.keySet().iterator();
        while (resultatIterator.hasNext()){
            HashMap<Event, Agent> key = new HashMap<Event, Agent>();

            Event keyOfInterest = (Event) resultatIterator.next();
            key.put(keyOfInterest, resultat.get(keyOfInterest));

            bestSolutions.put(key, GA.costEventAgent(key));
        }

        return bestSolutions;
    }

    private ArrayList<Agent> getAgents(){
        //return EntityManager.getInstance().getAgents();
        return new ArrayList<Agent>(agentDao.getFreeAgents());
    }

    private ArrayList<Event> getEvents(){

        List<Agent> agents = getAgents();
        ArrayList<Event> events = new ArrayList<Event>();

        Event event1 = new Event(1, 2, 1, agents.get(0).getId(), agents.get(0).getId(), "2015-04-02 11:18:43.664061", "LC04", "2015-03-18 10:49:06.877311", "2015-03-18 10:49:06.877311", "photo1.png", true, false, true);
        Event event2 = new Event(1, 2, 1, agents.get(1).getId(), agents.get(1).getId(), "2015-04-02 11:18:43.664061", "LC03", "2015-03-18 10:49:06.877311", "2015-03-18 10:49:06.877311", "photo1.png", true, false, true);
        Event event3 = new Event(1, 2, 1, agents.get(2).getId(), agents.get(2).getId(), "2015-04-02 11:18:44.664061", "LC01", "2015-03-18 10:49:06.877311", "2015-03-18 10:49:06.877311", "photo1.png", true, false, true);
        Event event4 = new Event(1, 3, 1, agents.get(3).getId(), agents.get(3).getId(), "2015-04-02 11:18:44.664061", "LC01", "2015-03-18 10:49:06.877311", "2015-03-18 10:49:06.877311", "photo1.png", true, false, true);
        Event event5 = new Event(1, 3, 1, agents.get(4).getId(), agents.get(4).getId(), "2015-04-02 11:18:44.664061", "LC01", "2015-03-18 10:49:06.877311", "2015-03-18 10:49:06.877311", "photo1.png", true, false, true);
        Event event6 = new Event(1, 3, 1, agents.get(5).getId(), agents.get(5).getId(), "2015-04-02 11:18:44.664061", "LC01", "2015-03-18 10:49:06.877311", "2015-03-18 10:49:06.877311", "photo1.png", true, false, true);
        Event event7 = new Event(1, 3, 2, agents.get(6).getId(), agents.get(6).getId(), "2015-04-02 11:18:44.664061", "LC01", "2015-03-18 10:49:06.877311", "2015-03-18 10:49:06.877311", "photo1.png", true, false, true);
        Event event8 = new Event(1, 3, 2, agents.get(7).getId(), agents.get(7).getId(), "2015-04-02 11:18:44.664061", "LC01", "2015-03-18 10:49:06.877311", "2015-03-18 10:49:06.877311", "photo1.png", true, false, true);
        Event event9 = new Event(1, 2, 2, agents.get(8).getId(), agents.get(8).getId(), "2015-04-02 11:18:45.664061", "LC01", "2015-03-18 10:49:06.877311", "2015-03-18 10:49:06.877311", "photo1.png", true, false, true);

        events.add(event1);
        events.add(event2);
        events.add(event3);
        events.add(event4);
        events.add(event5);
        events.add(event6);
        events.add(event7);
        events.add(event8);
        events.add(event9);


        ObjectMapper mapper = new ObjectMapper();

        //Object to JSON in String
        try {
            String jsonInString = mapper.writeValueAsString(events);
            System.out.println(jsonInString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return events;
    }

    @Test
    public void testDuplicateManagementAgentInexistant() {
        Map<Map<Event, Agent>, Double> bestSolutions = getBestsolutionsExample();
        boolean resultat = GA.agentDejaPresent(bestSolutions, null);
        Assert.assertTrue("lorsque l'agent choisi au hasard est null, on considere qu'il est deja present pour pouvoir recommencer le process", resultat);
    }

    @Test
    public void testDuplicateManagementAgentSimilaire() {
        Map<Map<Event, Agent>, Double> bestSolutions = getBestsolutionsExample();
        boolean resultat = GA.agentDejaPresent(bestSolutions, 60);
        System.out.println("RESULTAT = "+resultat);
        Assert.assertTrue("lorsque l'agent choisi au hasard est deja affecte, on doit recommencer le process", resultat);
    }

    @Test
    public void testDuplicateManagementAgentNonPresent() {
        Map<Map<Event, Agent>, Double> bestSolutions = getBestsolutionsExample();
        boolean resultat = GA.agentDejaPresent(bestSolutions, 15000);
        Assert.assertFalse("lorsque l'agent choisi au hasard n'est pas affecte, on NE doit PAS recommencer le process", resultat);
    }

    @Test
    public void test(){
        getEvents();
    }

}
