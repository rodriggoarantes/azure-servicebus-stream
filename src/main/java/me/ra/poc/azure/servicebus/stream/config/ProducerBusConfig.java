package me.ra.poc.azure.servicebus.stream.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

@Slf4j
@Configuration
public class ProducerBusConfig {

    private static final AtomicInteger sequence = new AtomicInteger();

    @Bean
    public Sinks.Many<Message<String>> produtorFilaService() {
        return Sinks.many().unicast().onBackpressureBuffer();
    }

    @Bean
    public Supplier<Flux<Message<String>>> produtorFila(Sinks.Many<Message<String>> produtorFilaService) {
        return () -> produtorFilaService.asFlux()
                .doOnNext(m -> log.info("Manually sending message1 {}", m))
                .doOnError(t -> log.error("Error encountered", t));
    }
}
