package org.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Configura os dados principais exibidos no Swagger/OpenAPI.
@Configuration
public class OpenApiConfig {
    @Value("${app.docs.server-url:http://localhost:8090}")
    private String serverUrl;

    // Registra a documentacao padrao da API no contexto Spring.
    @Bean
    public OpenAPI aulaDbeOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        // Nome exibido no topo da documentacao.
                        .title("Aula DBE API")
                        // Texto curto explicando o objetivo da API.
                        .description("""
                                Documentacao Swagger/OpenAPI da API Aula DBE.
                                
                                Uso em Docker para a aula:
                                - subir ambiente com `docker compose up --build`
                                - acessar a API em `http://localhost:8090`
                                - acessar esta interface em `http://localhost:8090/swagger-ui.html`
                                - acessar o PostgreSQL no computador do aluno por `localhost:6432`
                                
                                Topologia do ambiente:
                                - aplicacao Spring Boot dentro do container: porta 8080
                                - aplicacao publicada no host: porta 8090
                                - PostgreSQL dentro do container: porta 5432
                                - PostgreSQL publicado no host: porta 6432
                                - conexao interna da API com o banco: `jdbc:postgresql://postgres:5432/aula_dbe`
                                """)
                        // Versao atual da documentacao publicada.
                        .version("v1")
                        .contact(new Contact()
                                // Contato exibido na documentacao.
                                .name("Projeto Aula DBE")
                                .email("marcos.a.miguel@gmail.com"))
                        .license(new License()
                                // Tipo de uso informado para a API.
                                .name("Uso academico")
                                .url("https://example.local/licenca")))
                .addServersItem(new Server()
                        .url(serverUrl)
                        .description("Ambiente publicado da API"));
    }
}
