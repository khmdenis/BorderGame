package com.bordergame;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GameController {

    private final Random random = new Random();
    private final int MIN_DICE = 1;
    private final int MAX_DICE = 6;

    @MessageMapping("/hello")
    @SendTo("/topic/dice")
    int dice() {
        int dice = ThreadLocalRandom.current().nextInt(MIN_DICE, MAX_DICE + 1);
        return dice;
    }
}