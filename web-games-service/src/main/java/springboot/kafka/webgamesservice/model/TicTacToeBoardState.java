package springboot.kafka.webgamesservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;

@Log
@Getter
@Setter
@NoArgsConstructor
public class TicTacToeBoardState extends BoardCoordinate {

    private BoardCoordinate[] boardCoordinates;

    public void displayBoardCoordinates() {
        for (BoardCoordinate coordinate : boardCoordinates) {
            log.info(coordinate.getColumn());
            log.info(coordinate.getRow());
        }
    }
    
}
