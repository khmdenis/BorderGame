package com.bordergame;

import java.util.ArrayList;
import java.util.List;

import com.bordergame.Entity.Game;
import com.bordergame.Entity.Player;
import com.bordergame.Entity.Step;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GameController {

    private static boolean isInit = false;
    private Game game;


    @MessageMapping("/start_game")
    @SendTo("/process/game_started")
    Game startGame() {
        List<Player> players = new ArrayList<>();
        players.add(new Player(123, "User1"));
        players.add(new Player(124, "User2"));
        if (game == null) {
            game = new Game(players);
        }
        return game;
    }

    @MessageMapping("/curr_user")
    @SendTo("/process/user")
    Player showCurrentPlayer() {
        return game.getCurrentPlayer();
    }

    @MessageMapping("/dice")
    @SendTo("/process/dice")
    Step dice() {
        return game.nextStep();
    }
}