package me.ra.poc.azure.servicebus.stream.gateway.out.event.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = PRIVATE, force = true)
public class CashInCashOutFinalizadoEvent {
    private final String idTitulo;
    private final String documentoCliente;
    private final double valorMovimentado;
    private final LocalDateTime dataHora;
}
