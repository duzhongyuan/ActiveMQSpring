package cn.com.dzy.activemq.mq.consumer.queue;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Component;

/**
 * 
 * @ClassName: QueueReceiver1 
 * @Description: 队列消息监听器
 * @author asus
 * @date 2016-10-9 下午1:53:00 
 *
 */
@Component
public class QueueReceiver1 implements MessageListener{

	@Override
	public void onMessage(Message message) {
		try {
			
			System.out.println("QueueReceiver1接收到的消息:" + ((TextMessage)message).getText());
			Thread.sleep(5 * 1000);
			System.out.println("等待5S后消费下一条消息...........");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
