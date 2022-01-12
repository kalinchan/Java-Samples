package queue;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@JMSDestinationDefinition(
        name = "java:global/queue/myQueue",
        interfaceName = "javax.jms.Queue",
        destinationName = "myQueue"
)
@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:global/queue/myQueue"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class QueueMessageConsumer implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try{
            System.out.println("Received Message: " + message.getBody(String.class));
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
