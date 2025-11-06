package matepore.springboot.gestion.clientes.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Gestión de clientes API Client")
                        .description("Cliente interno que maneja los datos de clientes.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Matepore")
                                .url("https://github.com/matepore")
                                .email("calcagno.mateo@gmail.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")));
    }
}