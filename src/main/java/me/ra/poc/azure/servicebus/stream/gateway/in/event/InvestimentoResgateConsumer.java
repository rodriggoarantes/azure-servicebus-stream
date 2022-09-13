package me.ra.poc.azure.servicebus.stream.gateway.in.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.ra.poc.azure.servicebus.stream.core.usecase.RealizarMovimentacaoFinanceiraUseCase;
import me.ra.poc.azure.servicebus.stream.core.usecase.data.MovimentacaoUseCaseIn;
import me.ra.poc.azure.servicebus.stream.gateway.out.event.data.InvestimentoResgatadoEvent;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Slf4j
@Component
@RequiredArgsConstructor
public class InvestimentoResgateConsumer implements Consumer<InvestimentoResgatadoEvent> {

    private final RealizarMovimentacaoFinanceiraUseCase movimentacaoFinanceiraUseCase;

    @Override
    public void accept(InvestimentoResgatadoEvent investimentoResgatadoEvent) {
        log.info("--------------------");
        log.info("Nova mensagem recebida da fila: {}", investimentoResgatadoEvent);

        final var useCaseIn = MovimentacaoUseCaseIn.of(
                investimentoResgatadoEvent.getId(),
                investimentoResgatadoEvent.getDocumento()
        );

        movimentacaoFinanceiraUseCase.executar(useCaseIn);

        log.info("--------------------");
    }
}
