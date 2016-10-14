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
 * @Description: 队列消息生产者,发送消息到队列 
 * @author asus
 * @date 2016-10-9 上午11:45:53 
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
	 * @Description: 	    发送一条消息到指定的队列(目标)
	 * @param queueName	    队列名称
	 * @param message    消息内容 
	 * @return void      返回类型 
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
