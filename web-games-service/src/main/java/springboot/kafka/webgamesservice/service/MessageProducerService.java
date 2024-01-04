package springboot.kafka.webgamesservice.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import lombok.extern.java.Log;
import springboot.kafka.webgamesservice.model.PlayerOneCoordinates;
import springboot.kafka.webgamesservice.model.PlayerTwoCoordinates;
import springboot.kafka.webgamesservice.model.TicTacToeBoardState;

@Log
@Service
public class MessageProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, TicTacToeBoardState> ticTacToeBoardStateKafkaTemplate;

    @Autowired
    private KafkaTemplate<String, PlayerOneCoordinates> playerOneCoordinatesKafkaTemplate;

    @Autowired
    private KafkaTemplate<String, PlayerTwoCoordinates> playerTwoCoordinatesKafkaTemplate;

    @Value("${message.topic.name.tic-tac-toe.board.state}")
    private String topicTicTacToeBoardState;

    @Value("${message.topic.name.player-one.coordinates}")
    private String topicPlayerOneCoordinates;

    @Value("${message.topic.name.player-two.coordinates}")
    private String topicPlayerTwoCoordinates;

    public void sendMessage(String message) {
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send("topicName", message);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                log.info("Sending message...");
                log.info("Message content: " + message);
                log.info(String.format("Message offset: %d", result.getRecordMetadata().offset()));
            } else {
                log.info("Failed to send message...");
                log.info("Unable to send message: " + message);
                log.info("Failure due to: ");
                ex.printStackTrace();
            }
        });
    }

    public void sendMessageTicTacToeBoardState(TicTacToeBoardState tttBoardState) {
        ticTacToeBoardStateKafkaTemplate.send(topicTicTacToeBoardState, tttBoardState);
    }

    public void sendMessagePlayerOneCoordinates(PlayerOneCoordinates playerOneCoordinates) {
        playerOneCoordinatesKafkaTemplate.send(topicPlayerOneCoordinates, playerOneCoordinates);
    }

    public void sendMessagePlayerTwoCoordinates(PlayerTwoCoordinates playerTwoCoordinates) {
        playerTwoCoordinatesKafkaTemplate.send(topicPlayerTwoCoordinates, playerTwoCoordinates);
    }

}
