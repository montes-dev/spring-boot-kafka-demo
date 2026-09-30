package dev.montes.kafka.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootKafkaDemoApplication {

  public static void main(String[] args) {
    var context = SpringApplication.run(SpringBootKafkaDemoApplication.class, args);
    String bootstrap = context.getEnvironment().getProperty("spring.kafka.bootstrap-servers");
    System.out.println("🔍 [DEBUG] Servidores Kafka configurados: " + bootstrap);
  }

}
