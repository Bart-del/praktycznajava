package com.praktycznajava.activemqtestclient;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.remoting.JmsInvokerProxyFactoryBean;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;


@SpringBootApplication
public class ActivemqtestClientApplication {

    @Bean
    Queue queue() {
        return new ActiveMQQueue("remotingQueue");
    }

    @Bean
    FactoryBean invoker(ConnectionFactory factory, Queue queue) {
        JmsInvokerProxyFactoryBean factoryBean = new JmsInvokerProxyFactoryBean();
        factoryBean.setConnectionFactory(factory);
        factoryBean.setServiceInterface(BookingService.class);
        factoryBean.setQueue(queue);
        return factoryBean;
    }

    public static void main(String[] args) {
        BookingService service = SpringApplication.run(ActivemqtestClientApplication.class, args).getBean(BookingService.class);
        Booking bookingOutcome = service.bookHotel("Grzybowska 63, 00-844 Warszawa");
        System.out.println(bookingOutcome);
    }
}

