package springboot.kafka.webgamesservice.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class KafkaAdminConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configProps);
    }

    @Bean
    public NewTopic playerOneMovesTopic() {
        return new NewTopic("PlayerOneMoves", 1, (short) 1);
    }

    @Bean
    public NewTopic playerTwoMovesTopic() {
        return new NewTopic("PlayerTwoMoves", 1, (short) 1);
    }

    
}
