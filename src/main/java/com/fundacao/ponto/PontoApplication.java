package com.fundacao.ponto;

import org.modelmapper.ModelMapper;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class PontoApplication {
	public static void main(String[] args) {
		// Obtém a porta a partir da variável de ambiente
        int port = Integer.parseInt(System.getenv("PORT"));

        // Configura a aplicação para escutar na porta especificada
        System.setProperty("server.port", String.valueOf(port));
		
		new SpringApplicationBuilder(PontoApplication.class).run(args);
	}

@Bean
public ModelMapper getModelMapper() {
	return new ModelMapper();
}

}
