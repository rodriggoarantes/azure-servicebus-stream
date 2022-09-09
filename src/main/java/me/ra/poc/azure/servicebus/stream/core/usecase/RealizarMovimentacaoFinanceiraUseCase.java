package me.ra.poc.azure.servicebus.stream.core.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.ra.poc.azure.servicebus.stream.core.usecase.data.MovimentacaoUseCaseIn;
import me.ra.poc.azure.servicebus.stream.gateway.out.event.MovimentacaoFinanceiraProducer;
import me.ra.poc.azure.servicebus.stream.gateway.out.event.data.CashInCashOutFinalizadoEvent;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class RealizarMovimentacaoFinanceiraUseCase {

    private final MovimentacaoFinanceiraProducer producer;

    public void executar(final MovimentacaoUseCaseIn useCaseIn) {

        log.info("-----------");
        log.info("Movimentacao realizada com sucesso: {}", useCaseIn);

        final var event = CashInCashOutFinalizadoEvent.of(
                useCaseIn.getTituloId(), useCaseIn.getDocumentoCliente(), Math.random(), LocalDateTime.now());

        producer.send(event); // Envia a notificaçao para o topico
        log.info("-----------");
    }
}
