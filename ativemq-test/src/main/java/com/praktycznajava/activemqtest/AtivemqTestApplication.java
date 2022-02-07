package com.praktycznajava.activemqtest;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.listener.SimpleMessageListenerContainer;
import org.springframework.jms.remoting.JmsInvokerServiceExporter;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;


@SpringBootApplication
public class AtivemqTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(AtivemqTestApplication.class, args);
    }

    @Bean
    BookingService bookingService() {
        return new BookingServiceImpl();
    }

    @Bean
    Queue queue() {
        return new ActiveMQQueue("remotingQueue");
    }

    @Bean
    JmsInvokerServiceExporter exporter(BookingService implementation) {
        JmsInvokerServiceExporter exporter = new JmsInvokerServiceExporter();
        exporter.setServiceInterface(BookingService.class);
        exporter.setService(implementation);
        return exporter;
    }

    @Bean
    SimpleMessageListenerContainer listener(
            ConnectionFactory factory,
            JmsInvokerServiceExporter exporter) {

        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(factory);
        container.setDestinationName("remotingQueue");
        container.setConcurrentConsumers(1);
        container.setMessageListener(exporter);
        return container;
    }

}
