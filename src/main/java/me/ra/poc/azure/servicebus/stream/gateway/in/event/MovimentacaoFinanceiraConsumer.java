package me.ra.poc.azure.servicebus.stream.gateway.in.event;

import lombok.extern.slf4j.Slf4j;
import me.ra.poc.azure.servicebus.stream.gateway.out.event.data.CashInCashOutFinalizadoEvent;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Slf4j
@Component
public class MovimentacaoFinanceiraConsumer implements Consumer<CashInCashOutFinalizadoEvent> {

    @Override
    public void accept(CashInCashOutFinalizadoEvent event) {
        log.info("--------------------");
        log.info("Nova mensagem recebida do topico: {}", event);
        log.info("--------------------");
    }
}
