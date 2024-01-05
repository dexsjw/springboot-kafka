package springboot.kafka.webgamesservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.java.Log;
import springboot.kafka.webgamesservice.model.BoardCoordinate;
import springboot.kafka.webgamesservice.model.TicTacToeBoardState;
import springboot.kafka.webgamesservice.service.MessageProducerService;

@Log
@RestController
@RequestMapping(path = "/tic-tac-toe", produces = MediaType.APPLICATION_JSON_VALUE)
public class TicTacToeController {

    @Autowired
    private MessageProducerService messageProducerService;

    @PostMapping(path = "/board/state", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> sendMessageTicTacToeBoardState(@RequestBody TicTacToeBoardState ticTacToeBoardState) {
        for (BoardCoordinate coordinate : ticTacToeBoardState.getBoardCoordinates()) {
            log.info(coordinate.getColumn());
            log.info(coordinate.getRow());
        }
        messageProducerService.sendMessageTicTacToeBoardState(ticTacToeBoardState);
        return ResponseEntity.ok("Tic-Tac-Toe board state successfully sent!");
    }

    // @PostMapping(path = "/board/state", consumes = MediaType.APPLICATION_JSON_VALUE)
    // public ResponseEntity<String> sendMessage(@RequestBody String payload) {
    //     log.info(payload);
    //     return ResponseEntity.ok("Tic-Tac-Toe board state successfully sent!");
    // }
    
}
