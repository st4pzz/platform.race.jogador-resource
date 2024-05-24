package insper.store.jogador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cache.annotation.EnableCaching;

@EnableFeignClients(basePackages = { "insper.store.account", "insper.store.partida" })
@EnableDiscoveryClient
@SpringBootApplication
@EnableCaching
public class JogadorApplication {

    public static void main(String[] args) {
        SpringApplication.run(JogadorApplication.class, args);
    }
    
}
