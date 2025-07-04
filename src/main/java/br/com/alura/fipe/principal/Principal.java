package br.com.alura.fipe.principal;

import br.com.alura.fipe.service.FipeApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Principal implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Principal.class, args);
    }

    @Override
    public void run(String... args) {
        FipeApplication app = new FipeApplication();
        app.iniciar();
    }
}
