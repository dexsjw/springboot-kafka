package springboot.kafka.webgamesservice.model;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;

import lombok.extern.java.Log;

@Log
public class MessageProducerPlayerTwo {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${message.topic.name.player-two.moves}")
    private String topicPlayerTwoMoves;

    public void sendMessagePlayerTwo(String message) {
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(topicPlayerTwoMoves, message);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                log.info("Sending message of PlayerOne moves...");
                log.info("PlayerOneMoves: " + message);
                log.info(String.format("PlayerOneMoves offset: %d", result.getRecordMetadata().offset()));
            } else {
                log.info("Failed to send message of PlayerOne moves...");
                log.info("Unable to send message: " + message);
                log.info("Failure due to: ");
                ex.printStackTrace();
            }
        });
    }
    
}
