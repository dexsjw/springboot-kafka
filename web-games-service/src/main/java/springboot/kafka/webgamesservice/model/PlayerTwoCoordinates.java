package springboot.kafka.webgamesservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PlayerTwoCoordinates extends BoardCoordinate {

    private BoardCoordinate[] playerTwoCoordinates;
    
}
