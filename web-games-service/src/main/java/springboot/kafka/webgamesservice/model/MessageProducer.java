package springboot.kafka.webgamesservice.model;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

public class MessageProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${message.topic.name.player-one.moves}")
    private String topicPlayerOneMoves;

    @Value("${message.topic.name.player-two.moves}")
    private String topicPlayerTwoMoves;

    public void sendMessage(String message) {
        CompletableFuture
    }
    
}
