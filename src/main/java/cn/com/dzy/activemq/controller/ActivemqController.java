package cn.com.dzy.activemq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.dzy.activemq.mq.producer.queue.QueueSender;
import cn.com.dzy.activemq.mq.producer.topic.TopicSender;

/**
 * 
 * @ClassName: ActivemqController 
 * @Description: Controller����
 * @author asus
 * @date 2016-10-9 ����2:19:24 
 *
 */
@Controller
@RequestMapping("/activemq")
public class ActivemqController {

	@Autowired
	private QueueSender queueSender;
	
	@Autowired
	private TopicSender topicSender;
	
	/**
	 * @Title: queueSender 
	 * @Description: ������Ϣ������  	Queue����:����һ�������߻��յ���Ϣ,��Ϣһ��������Ͳ�����ڶ�����
	 * @param message	������Ϣ������
	 * @return String    �������� 
	 * @throws
	 */
	@ResponseBody
	@RequestMapping("queueSender")
	public String queueSender(@RequestParam("message") String message){
		String opt = "";
		try {
			queueSender.send("test.queue", message);
			opt = "suc";
		} catch (Exception e) {
			opt = e.getCause().toString();
		}
		return opt;
	}
	
	/**
	 * 
	 * @Title: topicSender 
	 * @Description: 	������Ϣ������ 	Topic����:����һ����Ϣ,���ж����߶����յ�  ���������һ�Զ�
	 * @param message	Ҫ�������Ϣ
	 * @return String    �������� 
	 * @throws
	 */
	@ResponseBody
	@RequestMapping("topicSender")
	public String topicSender(@RequestParam("message")String message){
		String opt = "";
		try {
			topicSender.send("test.topic", message);
			opt = "suc";
		} catch (Exception e) {
			opt = e.getCause().toString();
		}
		return opt;
	}
}
