package springboot.kafka.webgamesservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.java.Log;
import springboot.kafka.webgamesservice.model.TicTacToeBoardState;

@Log
@Service
public class MessageListenerService {

    @Value("${message.topic.name.tic-tac-toe.board.state}")
    private String topicTicTacToeBoardState;

    @Value("${message.topic.name.player-one.coordinates}")
    private String topicPlayerOneCoordinates;

    @Value("${message.topic.name.player-two.coordinates}")
    private String topicPlayerTwoCoordinates;

    @KafkaListener(topics = "${message.topic.name.tic-tac-toe.board.state}", containerFactory = "ticTacToeBoardStateKafkaListenerContainerFactory")
    public void listenTicTacToeBoardState(TicTacToeBoardState ticTacToeBoardState) {
        log.info("Received message for Topic: " + topicTicTacToeBoardState);
        log.info("Message content: ");
        ticTacToeBoardState.printBoardCoordinates();
    }

    // @KafkaListener(topics = "${message.topic.name.player-two.coordinates}", groupId = "${group.id.game.tic-tac-toe}")
    // public void listenGroupTicTacToe(String message) {
    //     log.info("Received message for Topic '" + topicPlayerTwoCoordinates + "'in group 'TicTacToe': " + message);
    // }

}
