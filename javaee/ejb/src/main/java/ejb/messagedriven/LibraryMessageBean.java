package ejb.messagedriven;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import ejb.persistence.Book;
import ejb.persistence.LibraryPersistentBeanRemote;
@MessageDriven(name = "BookMessageHandler", activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "BookQueue") })
public class LibraryMessageBean implements MessageListener {

	@Resource
	private MessageDrivenContext messageDrivenContext;
	
	@EJB
	LibraryPersistentBeanRemote libraryBean;
	
	public LibraryMessageBean() {
	}
	
	@Override
	public void onMessage(Message message) {
		ObjectMessage objectMessage = null;
	      try {
	         objectMessage = (ObjectMessage) message;
	         Book book = (Book) objectMessage.getObject(); 
	         libraryBean.addBook(book);
	 
	      } catch (JMSException ex) {
	         messageDrivenContext.setRollbackOnly();
	      } 
	}

}
