package com.bordergame.Entity;

public class Step {
    private Player player;
    private int dice;

    public Step(Player player, int dice) {
        this.player = player;
        this.dice = dice;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getDice() {
        return dice;
    }

    public void setDice(int dice) {
        this.dice = dice;
    }
}
