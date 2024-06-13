# :house_with_garden: Cliente API com Spring Boot

Este projeto é uma API RESTful para gerenciamento de clientes e seus endereços, utilizando Spring Boot.

## :sparkles: Funcionalidades

- :mag_right: Buscar todos os clientes
- :bust_in_silhouette: Buscar cliente por ID
- :heavy_plus_sign: Inserir novo cliente
- :pencil2: Atualizar cliente existente
- :wastebasket: Deletar cliente

## :hammer_and_wrench: Tecnologias Utilizadas

- :coffee: Java
- :leaves: Spring Boot
- :floppy_disk: Spring Data JPA
- :computer: H2 Database
- :link: Feign Client
- :book: Swagger/OpenAPI

## :gear: Configuração

Para executar este projeto, você precisará ter o Java e o Maven instalados.

1. Clone o repositório:
   ```
   git clone URL_DO_REPOSITORIO
   ```
2. Navegue até a pasta do projeto e execute:
   ```
   mvn spring-boot:run
   ```

## :rocket: Uso da API

Após iniciar a aplicação, você pode acessar a documentação da API e testar os endpoints através do Swagger UI:

```
http://localhost:8080/swagger-ui.html
```

## :world_map: Endpoints

A API possui os seguintes endpoints:

- `GET /clientes`: Retorna uma lista de todos os clientes.
- `GET /clientes/{id}`: Retorna os detalhes de um cliente específico.
- `POST /clientes`: Insere um novo cliente.
- `PUT /clientes/{id}`: Atualiza os dados de um cliente existente.
- `DELETE /clientes/{id}`: Remove um cliente do sistema.

## :floppy_disk: Configuração do Banco de Dados

Este projeto utiliza o banco de dados H2, um banco de dados em memória.

## :handshake: Contribuições

Contribuições são bem-vindas. Por favor, abra uma issue para discutir a mudança que você deseja fazer.
