package cn.com.dzy.activemq.mq.producer.queue;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

/**
 * 
 * @ClassName: QueueSender 
 * @Description: ������Ϣ������,������Ϣ������ 
 * @author asus
 * @date 2016-10-9 ����11:45:53 
 *
 */
@Component("queueSender")
public class QueueSender {

	@Autowired
	@Qualifier("jmsQueueTemplate")
	private JmsTemplate jmsTemplate;
	
	/**
	 * 
	 * @Title: send 
	 * @Description: 	    ����һ����Ϣ��ָ���Ķ���(Ŀ��)
	 * @param queueName	    ��������
	 * @param message    ��Ϣ���� 
	 * @return void      �������� 
	 * @throws
	 */
	public void send(String queueName, final String message){
		jmsTemplate.send(queueName, new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(message);
			}
		});
	}
	
}
