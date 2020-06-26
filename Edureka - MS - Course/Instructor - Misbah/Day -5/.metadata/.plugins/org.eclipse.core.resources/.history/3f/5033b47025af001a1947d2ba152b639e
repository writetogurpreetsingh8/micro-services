package com.edureka.mqserver;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;

@SpringBootApplication
@RestController
@EnableJms
public class MqServerApplication {

	@GetMapping("/messages/queue1/{message}")
	public void publish1(@PathVariable String message) {
		System.out.println("message received : " + message);
		jmsTemplate.convertAndSend(queue_1, "1-" + message);
	}
	
	@GetMapping("/messages/queue2/{message}")
	public void publish2(@PathVariable String message) {
		System.out.println("message received : " + message);
		jmsTemplate.convertAndSend(queue_2, "2-" + message);
	}

	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	private Queue queue_1;
	@Autowired
	private Queue queue_2;

	@Bean
	public Queue queue_1() {
		return new ActiveMQQueue("queue_1");
	}

	@Bean
	public Queue queue_2() {
		return new ActiveMQQueue("queue_2");
	}

	public static void main(String[] args) {
		SpringApplication.run(MqServerApplication.class, args);
	}

}
