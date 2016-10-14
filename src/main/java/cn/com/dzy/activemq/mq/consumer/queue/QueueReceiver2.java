package cn.com.dzy.activemq.mq.consumer.queue;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Component;

/**
 * 
 * @ClassName: QueueReceiver2 
 * @Description: ������Ϣ������ 
 * @author asus
 * @date 2016-10-9 ����2:03:33 
 *
 */
@Component
public class QueueReceiver2 implements MessageListener{

	@Override
	public void onMessage(Message message) {
		try {
			
			System.out.println("QueueReceiver2���յ���Ϣ:"+((TextMessage)message).getText());
			Thread.sleep(5 * 1000);
			System.out.println("�ȴ�5S��������һ����Ϣ...........");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
