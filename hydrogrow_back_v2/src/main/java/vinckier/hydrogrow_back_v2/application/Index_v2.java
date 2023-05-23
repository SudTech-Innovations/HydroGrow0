package vinckier.hydrogrow_back_v2.application;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import vinckier.hydrogrow_back_v2.API.PlanteController;

@SpringBootApplication
public class Index_v2 {

    @Value("${server.port:3000}")
    private static int port;

    public static void main(String[] args) {

        System.setProperty("server.port", String.valueOf(port));

        SpringApplication.run(Index_v2.class, args);

    }
}
