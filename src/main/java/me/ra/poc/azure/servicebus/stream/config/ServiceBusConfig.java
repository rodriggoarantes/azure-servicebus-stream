package me.ra.poc.azure.servicebus.stream.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

import java.util.function.Consumer;

@Slf4j
@Configuration
public class ServiceBusConfig {

    // @Bean
    public Consumer<Message<String>> consume() {
        return message -> {
            log.info("New message received: '{}'", message.getPayload());
        };
    }
}
