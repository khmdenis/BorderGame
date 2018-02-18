package com.bordergame.Entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class GameMap {

    private static final int FIELD_SIZE = 50;


    private List<Cell> cells;

    public GameMap() {
        initialize();
    }

    private void initialize() {
        cells = new ArrayList<>();
        for (int i = 0; i < FIELD_SIZE; i++) {
            cells.add(new Cell(i+1));
        }
    }

    public Cell move(Cell curr, int shift) {
        return cells.get(curr.getPosition() + shift -1);
    }
    // ## Getters and setters

    public Cell getCell(int i) {
        return cells.get(i);
    }

    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }
}
