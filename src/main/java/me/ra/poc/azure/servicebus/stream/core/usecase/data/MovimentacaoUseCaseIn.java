package me.ra.poc.azure.servicebus.stream.core.usecase.data;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class MovimentacaoUseCaseIn {
    private final String tituloId;
    private final String documentoCliente;
}
