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
 * @Description: Controller测试
 * @author asus
 * @date 2016-10-9 下午2:19:24 
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
	 * @Description: 发送消息到队列  	Queue队列:仅有一个订阅者会收到消息,消息一旦被处理就不会存在队列中
	 * @param message	发送消息的内容
	 * @return String    返回类型 
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
	 * @Description: 	发送消息到主题 	Topic主题:放入一个消息,所有订阅者都会收到  这个主题是一对多
	 * @param message	要放入的消息
	 * @return String    返回类型 
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
