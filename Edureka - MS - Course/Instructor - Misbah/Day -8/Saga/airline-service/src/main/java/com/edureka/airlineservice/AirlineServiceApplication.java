package com.edureka.airlineservice;

import com.edureka.airlineservice.domain.Order;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.TextMessage;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableJms
public class AirlineServiceApplication {
	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	private Queue sagaQueue;
	@Bean
	public Queue sagaQueue() {
		return new ActiveMQQueue("saga-queue");
	}
	@Bean // Serialize message content to json using TextMessage
	public MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		Map<String, Class<?>> typeIdMappings = new HashMap<String, Class<?>>();
		typeIdMappings.put("JMS_TYPE", Order.class);

		converter.setTypeIdMappings(typeIdMappings);
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		return converter;
	}

	@Bean
	public JmsListenerContainerFactory<?> jsaFactory(ConnectionFactory connectionFactory,
													 DefaultJmsListenerContainerFactoryConfigurer configurer) {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setMessageConverter(jacksonJmsMessageConverter());
		configurer.configure(factory, connectionFactory);
		return factory;
	}

	@JmsListener(destination = "airline-queue")
	public void listen(Order message) {
		System.out.println("Message Consumed: " + message);
		if (message.getOrderStatus().equals("NEW")) {
			message.setOrderStatus("AIRLINE_SUCCESS");
			//todo: book airline ticket
		} else if (message.getOrderStatus().equals("HOTEL_FAILED")) {
			message.setOrderStatus("FAILED");
			// todo: compensate airline booking
		}

		jmsTemplate.convertAndSend(sagaQueue, message);
	}


	public static void main(String[] args) {
		SpringApplication.run(AirlineServiceApplication.class, args);
	}

}
