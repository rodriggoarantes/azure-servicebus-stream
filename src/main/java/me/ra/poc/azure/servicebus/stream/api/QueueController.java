package me.ra.poc.azure.servicebus.stream.api;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.ra.poc.azure.servicebus.stream.gateway.out.event.InvestimentoResgatadoEvent;
import me.ra.poc.azure.servicebus.stream.gateway.out.event.InvestimentoResgateProducer;
import org.springframework.http.MediaType;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Sinks;

import javax.annotation.Resource;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(
        path = "/fila",
        produces = MediaType.APPLICATION_JSON_VALUE
)
@RequiredArgsConstructor
public class QueueController {

    private final InvestimentoResgateProducer investimentoResgateProducer;
    @GetMapping("/enviar/{text}")
    public InvestimentoResgatadoEvent enviarParaFila(@PathVariable String text) {

        final var id = UUID.randomUUID().toString();
        final var msg = InvestimentoResgatadoEvent.of(id, text);

        investimentoResgateProducer.send(msg);

        return msg;
    }
}
