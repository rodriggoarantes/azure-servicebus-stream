package me.ra.poc.azure.servicebus.stream.api;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping(
        path = "/fila",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class QueueController {

    @GetMapping("/send/{param}")
    public Map<String, String> enviarParaFila(@PathVariable String param) {
        return Map.of("param", param);
    }
}
