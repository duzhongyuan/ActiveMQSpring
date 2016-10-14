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
 * @Description: Topic生产者发送消息到Topic 
 * @author asus
 * @date 2016-10-9 下午1:43:16 
 *
 */
@Component("topicSender")
public class TopicSender {

	@Autowired
	@Qualifier("jmsTopicTemplate")
	private JmsTemplate jmsTemplate;
	
	/**
	 * @Title: send 
	 * @Description: 发送一条消息到指定的主题(目标)
	 * @param topicName	主题名称	
	 * @param message   消息内容
	 * @return void    返回类型 
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
