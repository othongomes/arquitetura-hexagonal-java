package br.com.boletojuros11.application;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("API juros boleto")
                        .description("API para calcular juros de boleto vencido")
                        .contact(new Contact().name("Othon Gomes").email("othonmarcello@gmail.com"))
                        .version("1.0.0"));

    }
}
