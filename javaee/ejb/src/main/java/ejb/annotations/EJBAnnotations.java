package ejb.annotations;

public class EJBAnnotations {

	/*-
	 * @Stateless:
	 * 	-Specifies that a given EJB class is a stateless session bean.
	 * 	Attributes:
	 * 		-name: name of session bean
	 * 		-mappedName: specifiy the jndi name of session bean
	 * 		-description: provide a description of session bean
	 * 
	 * @Statefull:
	 * 	-Specifies that a given EJB class is a stateful session bean.
	 * 	Attributes:
	 * 		-name: name of session bean
	 * 		-mappedName: specifiy the jndi name of session bean
	 * 		-description: provide a description of session bean
	 * 
	 * @MessageDriven
	 * 	-Specifies that a given EJB class is a message driven bean.
	 * 	Attributes:
	 * 		name : Used to specify name of the message driven bean.
	 * 		messageListenerInterface : Used to specify message listener interface for the message driven bean.
	 * 		activationConfig : Used to specify the configuration details of the message-driven bean in an operational environment of the message driven bean.
	 * 		mappedName : Used to specify the JNDI name of the session bean.
	 * 		description : Used to provide description of the session bean.
	 * 
	 * @EJB
	 * 	-Used to specify or inject a dependency as EJB instance into another EJB.
	 * 	Attributes:
	 * 		name : Used to specify name, which will be used to locate the referenced bean in the environment.
	 * 	    beanInterface : Used to specify the interface type of the referenced bean.
	 * 	    beanName : Used to provide name of the referenced bean.
	 * 	    mappedName : Used to specify the JNDI name of the referenced bean.
	 * 	    description : Used to provide description of the referenced bean.
	 * 
	 * @Local
	 * 	-Used to specify Local interface(s) of a session bean. 
	 * 	This local interface states the business methods of the session bean
	 *  (which can be stateless or stateful).
	 * 	Attributes:
	 * 	    value − Used to specify the list of local interfaces as an array of interfaces.
	 * 
	 * @Remote
	 * 	-Used to specify Remote interface(s) of a session bean. This remote interface states 
	 * 	the business methods of the session bean (which can be stateless or stateful).
	 * 	Attributes:	
	 * 	    value − Used to specify the list of remote interfaces as an array of interfaces.
	 * 
	 * @ActivationConfigProperty
	 * 	-Used to specify properties required for a message driven bean. 
	 * 	For example, end point, destination, message selector etc.
	 * 	Passed as a param to activationConfig in @MessageDriven
	 * 	Attributes:
	 * 	    propertyName − name of the property.
	 * 	    propertyValue − value of the property.
	 * 
	 * @PostActivate
	 * 	-Used to specify callback method of EJB lifecycle. 
	 * This method will be called when EJB container just activated/reactivated the bean instance.
	 */
}
