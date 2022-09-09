package me.ra.poc.azure.servicebus.stream.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.ra.poc.azure.servicebus.stream.gateway.out.event.data.InvestimentoResgatadoEvent;
import me.ra.poc.azure.servicebus.stream.gateway.out.event.InvestimentoResgateProducer;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(
        path = "/filas",
        produces = MediaType.APPLICATION_JSON_VALUE
)
@RequiredArgsConstructor
public class SimuladorFilaController {

    private final InvestimentoResgateProducer investimentoResgateProducer;
    @PostMapping("/{text}")
    public InvestimentoResgatadoEvent enviarParaFila(@PathVariable String text) {

        final var id = UUID.randomUUID().toString();
        final var msg = InvestimentoResgatadoEvent.of(id, text, "000456789-89");

        investimentoResgateProducer.send(msg);

        return msg;
    }
}
