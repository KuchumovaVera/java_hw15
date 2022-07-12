package ru.netology.domain;

import java.util.ArrayList;
import java.util.Collection;

public class Game {
    protected Collection<Player> players = new ArrayList<>();


    public Game() {
        this.players = players;
    }

    public void register(Player player) {
        players.add(player);
    }

    public Collection<Player> findAll() {
        return players;
    }

    public Player findByName(String playerName) {
        for (Player player : players) {
            if (player.getName() == playerName) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {

        if (findByName(playerName1) == null) {
            throw new NotRegisteredException("Игрок " + playerName1 + " не зарегистрирован");
        }
        if (findByName(playerName2) == null) {
            throw new NotRegisteredException("Игрок " + playerName2 + " не зарегистрирован");
        }
        if (findByName(playerName1) == null && findByName(playerName2) == null) {
            throw new NotRegisteredException("Игроки " + playerName1 + ", " + playerName2 + " не зарегистрированы");
        }

        if (findByName(playerName1).getStrength() == findByName(playerName2).getStrength()) {
            return 0;
        }
        if (findByName(playerName1).getStrength() > findByName(playerName2).getStrength()) {
            return 1;
        } else {
            return 2;
        }
    }
}