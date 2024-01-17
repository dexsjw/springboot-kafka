package springboot.kafka.webgamesservice.model;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;

@Log
@Getter
@Setter
@NoArgsConstructor
public class TicTacToeBoardState {

    // @Value("${message.topic.name.player-one.coordinates}")
    // private String topicPlayerOneCoordinates;

    // @Value("${message.topic.name.player-two.coordinates}")
    // private String topicPlayerTwoCoordinates;

    private Map<String, BoardCoordinate[]> ticTacToeBoardState;
    // private PlayerOneCoordinates playerOneCoordinates;
    // private PlayerTwoCoordinates playerTwoCoordinates;

    // public void getPlayersCoordinates() {
    //     playerOneCoordinates.setPlayerOneCoordinates(ticTacToeBoardState.get(topicPlayerOneCoordinates));
    //     playerTwoCoordinates.setPlayerTwoCoordinates(ticTacToeBoardState.get(topicPlayerTwoCoordinates));
    // }

    public void printBoardCoordinates() {
        for (Map.Entry<String, BoardCoordinate[]> playerCoordinates : ticTacToeBoardState.entrySet()) {
            log.info(playerCoordinates.getKey() + ": ");
            for (BoardCoordinate coordinate : playerCoordinates.getValue()) {
                log.info("  Column: " + coordinate.getColumn());
                log.info("     Row: " + coordinate.getRow());
            }
        }
    }
    
}
