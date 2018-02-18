package com.bordergame.Entity;

import java.util.concurrent.ThreadLocalRandom;

public class Cell {

    private static final int MAX_BONUS = 20;

    private int position;
    private int point;

    public static final Cell START = new Cell(0);

    public Cell(int position) {
        this.position = position;
        generateRandomPoint();
    }


    private void generateRandomPoint() {
        this.point = ThreadLocalRandom.current().nextInt(0, MAX_BONUS + 1);
    }

    public int getPosition() {
        return position;
    }

    public int getPoint() {
        return point;
    }


}
