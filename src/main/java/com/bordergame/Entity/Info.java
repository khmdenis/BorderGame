package com.bordergame.Entity;

public class Info {
    private Cell currentCell;
    private int totalScore;

    public Info(Cell currentCell, int totalScore) {
        this.currentCell = currentCell;
        this.totalScore = totalScore;
    }

    public Cell getCurrentCell() {
        return currentCell;
    }

    public void moveToCell(Cell currentCell) {
        totalScore += currentCell.getPoint();
        this.currentCell = currentCell;
    }

    public int getTotalScore() {
        return totalScore;
    }
}
