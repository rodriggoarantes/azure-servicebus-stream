package me.ra.poc.azure.servicebus.stream.gateway.out.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.function.Supplier;

@Slf4j
abstract class AbstractProducer<T> implements Supplier<Flux<Message<T>>> {

    private final Sinks.Many<Message<T>> sinks = Sinks.many().unicast().onBackpressureBuffer();

    /**
     * NOTA: metodo mantido caso haja necessidade de realizar algum tratamento na mensagem antes do envio
     */
    abstract public void send(T event);

    protected void dispatch(T event) {
        log.info("Going to add message {} to Sinks.Many.", event);

        final var msg = MessageBuilder
                .withPayload(event)
                .build();

        log.info("send : {}", sinks);
        sinks.emitNext(msg, Sinks.EmitFailureHandler.FAIL_FAST);
    }

    @Override
    public Flux<Message<T>> get() {
        return sinks.asFlux()
                .doOnNext(m -> log.info("Mensagem enviada manualmente :: {}", m))
                .doOnError(t -> {
                    log.error("Falha", t);
                    throw new IllegalArgumentException("falha ao processar mensagem");
                });
    }
}
