package com.edureka.sagaorchestrator.service;

import com.edureka.sagaorchestrator.domain.AirlineRequest;
import com.edureka.sagaorchestrator.domain.Order;
import com.edureka.sagaorchestrator.domain.OrderEvent;
import com.edureka.sagaorchestrator.domain.OrderState;
import com.edureka.sagaorchestrator.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AirlineAction implements Action<OrderState, OrderEvent> {
    private final JmsTemplate jmsTemplate;
    private final OrderRepository orderRepository;


    @Override
    public void execute(StateContext<OrderState, OrderEvent> context) {
        System.out.println("Airline Action");
//        String orderId = (String) context.getMessage().getHeaders().get("ORDER_ID_HEADER");
        String orderId = (String) context.getMessage().getHeaders().get("ORDER_ID_HEADER");
//        // find from DB orderId
//        Optional<Order> orderOptional = orderRepository.findById(Long.parseLong(orderId));
        Optional<Order> orderOptional = orderRepository.findById(Long.parseLong(orderId));

//        jmsTemplate.convertAndSend("airline-queue", "AirlineRequest.builder().order(orderOptional.get())");AdDDD
        jmsTemplate.convertAndSend("airline-queue", orderOptional.get());

       /* jmsTemplate.convertAndSend("airline-queue", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                final AirlineRequest.AirlineRequestBuilder order = AirlineRequest.builder().order(orderOptional.get());
                session.createObjectMessage(order);
                return null;
            }
        });*/

    }
}
