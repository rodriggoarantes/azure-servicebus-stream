---
# Azure ServiceBus Stream

- Projeto criado para realizar testes entre Azure ServiceBus e Spring Cloud Stream

# Objetivo

- Conseguir comunicar com o ServiceBus, usando a configuração do Spring Cloud Stream, onde o projeto ira publicar uma mensagem na fila.
- Ler de uma fila, processar no caso de uso
- Notificar um topico com um evento disparado pelo caso de uso
- Receber a notificação do topico completando o ciclo de testes esperado


## Documentações utilizadas
https://spring.io/projects/spring-cloud-stream

https://docs.spring.io/spring-cloud-stream/docs/current/reference/html/

https://www.baeldung.com/spring-cloud-stream

https://docs.microsoft.com/pt-br/azure/developer/java/spring-framework/configure-spring-cloud-stream-binder-java-app-with-service-bus

https://microsoft.github.io/spring-cloud-azure/4.0.0/reference/html/index.html#spring-cloud-stream-binder-for-azure-service-bus

https://github.com/Azure-Samples/azure-spring-boot-samples/blob/spring-cloud-azure_4.0.0/servicebus/spring-cloud-azure-stream-binder-servicebus/servicebus-multibinders/src/main/resources/application.yaml

https://github.com/Azure-Samples/azure-spring-boot-samples/tree/spring-cloud-azure_v4.3.0/servicebus/spring-cloud-azure-stream-binder-servicebus/servicebus-topic-binder

https://tanzu.vmware.com/developer/guides/scs-what-is/

# Conclusão
- Foi possivel realizar o teste com sucesso, o binder com o dependencia construida pela Microsoft funciona normalmente, assim como exemplo com Kafka.