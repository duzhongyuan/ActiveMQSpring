package cn.com.dzy.activemq.mq.consumer.queue;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Component;

/**
 * 
 * @ClassName: QueueReceiver2 
 * @Description: 队列消息监听器 
 * @author asus
 * @date 2016-10-9 下午2:03:33 
 *
 */
@Component
public class QueueReceiver2 implements MessageListener{

	@Override
	public void onMessage(Message message) {
		try {
			
			System.out.println("QueueReceiver2接收到消息:"+((TextMessage)message).getText());
			Thread.sleep(5 * 1000);
			System.out.println("等待5S后消费下一条消息...........");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
