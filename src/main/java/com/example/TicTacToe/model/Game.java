package com.example.TicTacToe.model;

import com.example.TicTacToe.enums.Mark;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class Game { // can be named as TicTacToe game
    Board board;
    List<Player> players;
    int currentPlayer;
    boolean isGameOver;
    Map<Integer, Mark> playerMarkMap;
    private static volatile Game game;


    private Game() {
        this.board = new Board();
        this.currentPlayer = -1;
        this.isGameOver = false;
        this.playerMarkMap = new HashMap<>();
        this.players = new ArrayList<>();
    }

    public static Game getInstance() {
        if (game == null) {
            synchronized (Game.class) {
                return new Game();
            }
        }
        return game;
    }
    public void addPlayers(Player p) {
        players.add(p);
        playerMarkMap.put(p.id, p.mark);
    }

    public void addAllPlayers(List<Player> pList) {
        for(Player p : pList) {
            players.add(p);
            playerMarkMap.put(p.id, p.mark);
        }
    }

}
