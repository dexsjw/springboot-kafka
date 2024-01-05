package springboot.kafka.webgamesservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PlayerOneCoordinates extends BoardCoordinate {

    private BoardCoordinate[] playerOneCoordinates;
    
}
