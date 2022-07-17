package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

public class GameTest {

    Player player1 = new Player(123, "Иван", 6);
    Player player2 = new Player(234, "Сергей", 11);
    Player player3 = new Player(345, "Александр", 16);
    Player player4 = new Player(456, "Владимир", 22);
    Player player5 = new Player(567, "Дмитрий", 16);
    Player player6 = new Player(678, "Антон", 13);
    Player player7 = new Player(789, "Анна", 8);
    Player player8 = new Player(891, "Светлана", 6);
    Player player9 = new Player(912, "Мария", 35);
    Player player10 = new Player(111, "Ирина", 1);
    @Test
    void shouldEmptyPlayers() {
        Game players = new Game();

        Collection<Player> actual = players.findAll();
        Collection<Player> expected = List.of();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldAddPlayers() {
        Game players = new Game();

        players.register(player1);
        players.register(player2);
        players.register(player3);
        players.register(player4);
        players.register(player5);
        players.register(player6);
        players.register(player7);
        players.register(player8);
        players.register(player9);
        players.register(player10);

        Collection<Player> actual = players.findAll();
        Collection<Player> expected = List.of(player1, player2, player3, player4, player5, player6, player7, player8, player9, player10);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldRoundPlayersRegister() {
        Game players = new Game();

        players.register(player1);
        players.register(player2);
        players.register(player3);
        players.register(player4);
        players.register(player5);
        players.register(player6);
        players.register(player7);
        players.register(player8);
        players.register(player9);
        players.register(player10);


        int actual1 = players.round("Иван", "Сергей");
        int expected1 = 2;

        Assertions.assertEquals(expected1, actual1);

        int actual2 = players.round("Александр", "Дмитрий");
        int expected2 = 0;

        Assertions.assertEquals(expected2, actual2);

        int actual3 = players.round("Мария", "Антон");
        int expected3 = 1;

        Assertions.assertEquals(expected3, actual3);
    }

    @Test
    void shouldRoundPlayersNotRegister() {
        Game players = new Game();

        players.register(player1);
        players.register(player2);
        players.register(player3);
        players.register(player4);
        players.register(player5);
        players.register(player6);
        players.register(player7);
        players.register(player8);
        players.register(player9);
        players.register(player10);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            players.round("Семен", "Сергей");
        });

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            players.round("Александр", "Петр");
        });

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            players.round("Семен", "Петр");
        });
    }
}
