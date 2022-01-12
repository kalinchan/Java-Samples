package topic;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@JMSDestinationDefinition(
        name = "java:global/queue/myTopic",
        interfaceName = "javax.jms.Topic",
        destinationName = "myTopic"
)
@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:global/queue/myTopic"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class TopicMessageConsumer implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("Message #1 received on " + this.getClass().getCanonicalName() + ": " + message.getBody(String.class));
        } catch (JMSException ex) {
            ex.printStackTrace();
        }
    }
}
