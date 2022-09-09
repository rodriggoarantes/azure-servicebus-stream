package me.ra.poc.azure.servicebus.stream.config;

import lombok.extern.slf4j.Slf4j;
import me.ra.poc.azure.servicebus.stream.gateway.out.event.InvestimentoResgatadoEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Slf4j
@Configuration
public class ConsumerBusConfig {

    @Bean
    public Consumer<InvestimentoResgatadoEvent> consumidorFila() {
        return message -> {
            log.info("--------------------");
            log.info("Nova mensagem recebida: {}", message);
            log.info("--------------------");

            // checkpoint manual - retorno do metodo deve ser Consumer<org.springframework.messaging.Message<String>>
//            final var checkpointer = (Checkpointer) message.getHeaders().get(CHECKPOINTER);
//            Objects.requireNonNull(checkpointer)
//                    .success()
//                    .doOnSuccess(s -> log.info("Message '{}' successfully checkpointed", message.getPayload()))
//                    .doOnError(e -> log.error("Error found", e))
//                    .block();
        };
    }
}
