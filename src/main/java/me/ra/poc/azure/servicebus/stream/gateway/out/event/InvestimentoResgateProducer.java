package me.ra.poc.azure.servicebus.stream.gateway.out.event;

import lombok.extern.slf4j.Slf4j;
import me.ra.poc.azure.servicebus.stream.gateway.out.event.data.InvestimentoResgatadoEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class InvestimentoResgateProducer extends AbstractProducer<InvestimentoResgatadoEvent> {

    @Override
    public void send(InvestimentoResgatadoEvent event) {
        log.info("step=sendToQueue event={}", event);
        dispatch(event);
    }
}
