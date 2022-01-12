package topic;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Topic;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.Date;

@Path("send")
public class TopicSender {

    @Inject
    JMSContext jmsContext;

    @Resource(lookup = "java:global/queue/myTopic")
    Topic topic;

    @GET
    public Response sendMessage(){
        jmsContext.createProducer().send(topic, "Sent a message from " + TopicSender.class.getName() + " @ " + new Date());
        return Response.ok("Message Sent").build();
    }

}
