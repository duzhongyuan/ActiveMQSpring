package cn.com.dzy.activemq.mq.consumer.queue;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Component;

/**
 * 
 * @ClassName: QueueReceiver1 
 * @Description: ������Ϣ������
 * @author asus
 * @date 2016-10-9 ����1:53:00 
 *
 */
@Component
public class QueueReceiver1 implements MessageListener{

	@Override
	public void onMessage(Message message) {
		try {
			
			System.out.println("QueueReceiver1���յ�����Ϣ:" + ((TextMessage)message).getText());
			Thread.sleep(5 * 1000);
			System.out.println("�ȴ�5S��������һ����Ϣ...........");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
