package springboot.kafka.webgamesservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardCoordinate {

    private String column;
    private String row;
    
}
