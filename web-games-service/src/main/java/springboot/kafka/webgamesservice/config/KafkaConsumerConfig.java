package springboot.kafka.webgamesservice.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import springboot.kafka.webgamesservice.model.TicTacToeBoardState;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;

    @Value("${group.id.game.tic-tac-toe}")
    private String groupIdTicTacToe;

    // @Bean
    // public ConsumerFactory<String, String> consumerFactory(String groupId) {
    //      Map<String, Object> configProps = new HashMap<>();
    //      configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
    //      configProps.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
    //      configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    //      configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    //      return new DefaultKafkaConsumerFactory<>(configProps);
    // }

    // @Bean
    // public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory(String groupId) {
    //     ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
    //     factory.setConsumerFactory(consumerFactory(groupId));
    //     return factory;
    // }

    @Bean
    public ConsumerFactory<String, TicTacToeBoardState> ticTacToeBoardStateConsumerFactory() {
         Map<String, Object> configProps = new HashMap<>();
         configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
         configProps.put(ConsumerConfig.GROUP_ID_CONFIG, groupIdTicTacToe);
         configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
         configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
         DefaultKafkaConsumerFactory<String, TicTacToeBoardState> consumerFactory = new DefaultKafkaConsumerFactory<>(configProps);
         consumerFactory.setValueDeserializer(new JsonDeserializer<>(TicTacToeBoardState.class));
         return consumerFactory;
        //  return new DefaultKafkaConsumerFactory<>(configProps);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, TicTacToeBoardState> ticTacToeBoardStateKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, TicTacToeBoardState> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(ticTacToeBoardStateConsumerFactory());
        return factory;
    }
    
}
