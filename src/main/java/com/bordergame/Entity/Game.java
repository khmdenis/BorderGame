package com.bordergame.Entity;


import com.bordergame.Utill.PlayersQueue;
import com.bordergame.Utill.SimplePlayersQueue;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


public class Game {

    private final int MIN_DICE = 1;
    private final int MAX_DICE = 6;

    private GameMap gameMap;
    private PlayersQueue playersQueue;
    private Player currentPlayer;

    public Game(List<Player> players) {
        gameMap = new GameMap();
        playersQueue = new SimplePlayersQueue(players);
        currentPlayer = playersQueue.getCurrent();
    }

    public Step nextStep() {
        Info currentPlayerInfo = currentPlayer.getPlayerInfo();
        Cell currCell = currentPlayerInfo.getCurrentCell();
        int dice = ThreadLocalRandom.current().nextInt(MIN_DICE, MAX_DICE + 1);
        Cell newCell = gameMap.move(currCell, dice);
        currentPlayerInfo.moveToCell(newCell);
        Step step = new Step(currentPlayer, dice);
        currentPlayer = playersQueue.getNext();
        return step;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
}
