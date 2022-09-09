package me.ra.poc.azure.servicebus.stream.gateway.out.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.function.Supplier;

@Slf4j
@Component
public class InvestimentoResgateProducer implements Supplier<Flux<Message<InvestimentoResgatadoEvent>>> {

    private final Sinks.Many<Message<InvestimentoResgatadoEvent>> sinks;

    public InvestimentoResgateProducer() {
        this.sinks = Sinks.many().unicast().onBackpressureBuffer();
    }

    public void send(InvestimentoResgatadoEvent event) {
        log.info("Going to add message {} to Sinks.Many.", event);

        final var msg = MessageBuilder
                .withPayload(event)
                .build();

        log.info("send : {}", sinks);
        sinks.emitNext(msg, Sinks.EmitFailureHandler.FAIL_FAST);
    }

    @Override
    public Flux<Message<InvestimentoResgatadoEvent>> get() {
        log.info("supplier : {}", sinks);
        return sinks.asFlux()
                .doOnNext(m -> log.info("Mensagem enviada manualmente :: {}", m))
                .doOnError(t -> log.error("Error encountered", t));
    }
}
