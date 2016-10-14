package cn.com.dzy.activemq.mq.producer.topic;

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
 * @ClassName: TopicSender 
 * @Description: Topic�����߷�����Ϣ��Topic 
 * @author asus
 * @date 2016-10-9 ����1:43:16 
 *
 */
@Component("topicSender")
public class TopicSender {

	@Autowired
	@Qualifier("jmsTopicTemplate")
	private JmsTemplate jmsTemplate;
	
	/**
	 * @Title: send 
	 * @Description: ����һ����Ϣ��ָ��������(Ŀ��)
	 * @param topicName	��������	
	 * @param message   ��Ϣ����
	 * @return void    �������� 
	 * @throws
	 */
	public void send(String topicName, final String message){
		jmsTemplate.send(topicName, new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(message);
			}
		});
	}
	
}
