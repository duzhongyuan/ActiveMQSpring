package cn.com.dzy.activemq.mq.consumer.topic;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Component;

/**
 * 
 * @ClassName: TopicReceiver2 
 * @Description: Topic��Ϣ������ 
 * @author asus
 * @date 2016-10-9 ����2:07:08 
 *
 */
@Component
public class TopicReceiver2 implements MessageListener{

	@Override
	public void onMessage(Message message) {
		try {
			System.out.println("TopicReceiver2���յ���Ϣ:"+((TextMessage)message).getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
