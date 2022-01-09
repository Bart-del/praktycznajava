package pl.praktycznajava.springintegration;

import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.BridgeFrom;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.handler.LoggingHandler;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;


public class Channels {

    @Bean
    public MessageChannel fileChannelFirst() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel fileChannelSecond() {
        return new DirectChannel();
    }

    @Bean
    @ServiceActivator(inputChannel= "fileChannelFirst", outputChannel = "fileChannelSecond")
    public MessageHandler loggingMessageHandler() {
        //Dalszy kod...
        return new LoggingHandler("INFO");
    }

    @Bean
    public MessageChannel pubSubFileChannel() {
        return new PublishSubscribeChannel();
    }
}
