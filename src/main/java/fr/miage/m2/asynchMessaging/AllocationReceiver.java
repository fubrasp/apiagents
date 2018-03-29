package fr.miage.m2.asynchMessaging;

import fr.miage.m2.metier.Allocation;
import fr.miage.m2.service.AgentManager;
import fr.miage.m2.service.Timer;
import javafx.util.Pair;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AllocationReceiver {

    @Autowired
    AgentManager agentManager;
    @RabbitListener(queues = RabbiMQConfig.queueName)
    public void receiveEventStream(Allocation allocation) {
        System.out.println("*****");
        System.out.println(allocation.getIdAgent() +" | "+ allocation.getIdEvent());
        agentManager.receiveEvent(allocation.getIdAgent(), allocation.getIdEvent());
        //new Timer(allocation.getIdAgent(),allocation.getIdEvent()).run();
    }

}
