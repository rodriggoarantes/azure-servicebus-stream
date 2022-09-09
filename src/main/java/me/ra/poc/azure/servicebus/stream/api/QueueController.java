package me.ra.poc.azure.servicebus.stream.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Sinks;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping(
        path = "/fila",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class QueueController {

    @Resource(name = "produtorFilaService")
    private Sinks.Many<Message<String>> produtorFilaService;
    @GetMapping("/enviar/{text}")
    public Message<String> enviarParaFila(@PathVariable String text) {

        log.info("Going to add message {} to Sinks.Many.", text);

        final var msg = MessageBuilder
                .withPayload("Nova mensagem Produtor Manual :: " + text)
                .build();
        produtorFilaService.emitNext(msg, Sinks.EmitFailureHandler.FAIL_FAST);

        return msg;
    }
}
