package me.ra.poc.azure.servicebus.stream.gateway.out.event;

import lombok.extern.slf4j.Slf4j;
import me.ra.poc.azure.servicebus.stream.gateway.out.event.data.CashInCashOutFinalizadoEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MovimentacaoFinanceiraProducer extends AbstractProducer<CashInCashOutFinalizadoEvent> {

    @Override
    public void send(CashInCashOutFinalizadoEvent event) {
        dispatch(event);
    }
}
