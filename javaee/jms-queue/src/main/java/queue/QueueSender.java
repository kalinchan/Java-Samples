package queue;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.Date;

@Path("send")
public class QueueSender {

    @Inject
    JMSContext jmsContext;

    @Resource(lookup = "java:global/queue/myQueue")
    Queue queue;

    @GET
    public Response sendMessage(){
        jmsContext.createProducer().send(queue, "Sent a message from " + QueueSender.class.getName() + " @ " + new Date());
        return Response.ok("Message sent").build();
    }
}
