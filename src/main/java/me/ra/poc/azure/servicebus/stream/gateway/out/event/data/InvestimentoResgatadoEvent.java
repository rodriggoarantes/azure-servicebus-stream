package me.ra.poc.azure.servicebus.stream.gateway.out.event.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = PRIVATE, force = true)
public class InvestimentoResgatadoEvent {
    private final String id;
    private final String descricao;
    private final String documento;
}
