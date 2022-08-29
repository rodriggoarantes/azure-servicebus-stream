package me.ra.poc.azure.servicebus.stream.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(
        path = "/hello",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class HelloController {

    @GetMapping("/{name}")
    public Map<String, String> who(@PathVariable String name) {
        return Map.of("name", name);
    }
}
