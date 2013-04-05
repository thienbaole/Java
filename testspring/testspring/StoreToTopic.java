package testspring.testspring;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class StoreToTopic implements StoreRecord {
	@Autowired
	private SerializeTool tool;
	@Autowired
	JmsTemplate jmsTemplate;
	
	@Override
	public void doStore(final RuntimeRecord obj) {
		// TODO Auto-generated method stub
		//send to topic to broker
		
		jmsTemplate.send(new MessageCreator() {
							public Message createMessage(Session session) throws JMSException
							{
								return session.createTextMessage(tool.doSerialize(obj));
							}
						}
					);
	}

}
