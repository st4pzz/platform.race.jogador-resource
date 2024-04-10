package insper.store.jogador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = { "insper.store.account", "insper.store.partida" })
@EnableDiscoveryClient
@SpringBootApplication
public class JogadorApplication {

    public static void main(String[] args) {
        SpringApplication.run(JogadorApplication.class, args);
    }
    
}
