package com.bordergame.Entity;

public class Player {
    private long userId;
    private String userName;
    private Info playerInfo;

    public Player(long userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.playerInfo = new Info(Cell.START, 0);
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Info getPlayerInfo() {
        return playerInfo;
    }
}
