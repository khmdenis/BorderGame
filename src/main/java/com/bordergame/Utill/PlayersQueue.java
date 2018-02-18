package com.bordergame.Utill;

import com.bordergame.Entity.Player;

public interface PlayersQueue {
    Player getNext();
    Player getCurrent();
    void remove();
}
