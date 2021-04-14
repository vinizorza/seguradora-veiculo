# Seguradora Veiculo
Aplicação para cadastro de cliente e apólices de seguro.

## Tecnologias Utilizadas
- Java 1.8
- Spring Boot 2.4.4
- Swagger 2.9.2
- MongoDB 4.4.5

## Documentação da API
Pode ser encontrada no endereço `{uri}/swagger-ui.html`

## Estrutura do projeto
```
└───seguradora-veiculo
    └───src
        └───main
            ├───java
            │   └───com
            │       └───vinizorza
            │           └───seguradoraveiculo
            │               │   SeguradoraVeiculoApplication.java
            │               │
            │               ├───config
            │               │       SwaggerConfig.java
            │               │
            │               ├───controller
            │               │       ApoliceController.java
            │               │       ClienteController.java
            │               │
            │               ├───dto
            │               │       ApoliceCompletaDTO.java
            │               │       ApoliceDTO.java
            │               │       ClienteDTO.java
            │               │
            │               ├───exception
            │               │       BadRequestException.java
            │               │       NotFoundException.java
            │               │
            │               ├───model
            │               │       Apolice.java
            │               │       Cliente.java
            │               │       DatabaseSequence.java
            │               │
            │               ├───repository
            │               │       ApoliceRepository.java
            │               │       ClienteRepository.java
            │               │
            │               └───service
            │                   │   ApoliceService.java
            │                   │   ClienteService.java
            │                   │   SequenceGeneratorService.java
            │                   │
            │                   └───impl
            │                           ApoliceServiceImpl.java
            │                           ClienteServiceImpl.java
            │                           SequenceGeneratorServiceImpl.java
            │
            └───resources
                    application.properties
```                                


