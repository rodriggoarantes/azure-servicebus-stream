package me.ra.poc.azure.servicebus.stream.config;

import com.azure.spring.messaging.checkpoint.Checkpointer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

import java.util.Objects;
import java.util.function.Consumer;

import static com.azure.spring.messaging.AzureHeaders.CHECKPOINTER;

@Slf4j
@Configuration
public class ConsumerBusConfig {

    @Bean
    public Consumer<Message<String>> consumidorFila() {
        return message -> {
            log.info("--------------------");
            log.info("Nova mensagem recebida: {} | {}",
                    message.getPayload(), message.getHeaders());
            log.info("--------------------");

            // checkpoint manual
            final var checkpointer = (Checkpointer) message.getHeaders().get(CHECKPOINTER);
            Objects.requireNonNull(checkpointer)
                    .success()
                    .doOnSuccess(s -> log.info("Message '{}' successfully checkpointed", message.getPayload()))
                    .doOnError(e -> log.error("Error found", e))
                    .block();
        };
    }
}
