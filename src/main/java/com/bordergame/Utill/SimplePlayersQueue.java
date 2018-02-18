package com.bordergame.Utill;

import com.bordergame.Entity.Player;

import java.util.List;

public class SimplePlayersQueue implements PlayersQueue {

    private Node first;
    private Node last;
    private Node current;

    public SimplePlayersQueue(List<Player> players) {
        for (Player player : players) {
            add(player);
        }
    }

    @Override
    public Player getNext() {
        current = current.next;
        return current.item;
    }

    @Override
    public Player getCurrent() {
        return current.item;
    }

    public void add(Player player) {
        if (first == null) {
            first = new Node(player, null, null);
            current = first;
            last = first;
            return;
        }
        Node tmp = last;
        last = new Node(player, tmp, first);
        tmp.next = last;
    }

    @Override
    public void remove() {
        current.prev.next = current.next;
        current.next.prev = current.prev;
    }

    private static class Node {

        public Node(Player item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }

        Player item;
        SimplePlayersQueue.Node next;
        SimplePlayersQueue.Node prev;

    }
}
