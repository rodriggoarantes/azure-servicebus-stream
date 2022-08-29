package me.ra.poc.azure.servicebus.stream.config;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Slf4j
@Configuration
public class ServiceBusConfig {

    private static final AtomicInteger sequence = new AtomicInteger();

    @Bean
    public Consumer<Message<String>> consumidor() {
        return message -> {
            log.info("New message received: {} | {}",
                    message.getPayload(), message.getHeaders());
        };
    }

    @Bean
    public Supplier<Message<String>> produtor() {
        return () -> {
            final var i = sequence.getAndAdd(1);
            log.info("Sending message, sequence " + i);
            return MessageBuilder.withPayload("Hello world, " + i).build();
        };
    }
}
