package fr.miage.m2.asynchMessaging;

import fr.miage.m2.service.Timer;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class AllocationReceiver {

    @RabbitListener(queues = RabbiMQConfig.queueName)
    public void receiveEventStream(String idAgent, Integer idEvent) {
        System.out.println("*****");
        System.out.println(idAgent +" | "+ idEvent);
        new Timer(idAgent,idEvent).run();
    }

}
