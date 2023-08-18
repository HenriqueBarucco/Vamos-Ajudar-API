package com.ong.vamosajudar.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.net.UnknownHostException;
import java.util.List;

@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
@EnableWebMvc
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI myOpenAPI() throws UnknownHostException {

        Server server = new Server();
        server.setUrl("/");
        server.setDescription("Dev");

        Info info = new Info()
                .title("Vamos Ajudar? API")
                .version("1.0.0")
                .description("API de integração do sistema do 'Vamos Ajudar?' voltado a ajudar ONG's")
                .termsOfService("https://henriquebarucco.com.br/");

        return new OpenAPI().info(info).servers(List.of(server));
    }
}