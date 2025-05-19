package com.example.TicTacToe;

import com.example.TicTacToe.enums.Mark;
import com.example.TicTacToe.model.Board;
import com.example.TicTacToe.model.Game;
import com.example.TicTacToe.model.Player;
import com.example.TicTacToe.service.GameService;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GameClient {
    public static void initialiseGame(Game game, int row, int col, List<Player> playerList, int currentPlayer) {
        Board board = new Board();
        board.setRow(row);
        board.setCol(col);
        board.setGrid(new Mark[row][col]);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board.getGrid()[i][j] = Mark.EMPTY;
            }
        }
        game.setBoard(board);
        game.addAllPlayers(playerList);
        game.setCurrentPlayer(currentPlayer);
        game.setGameOver(false);

    }

    public static void main(String[] args) {
        Game game = Game.getInstance();
        GameService gameService = new GameService();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter row size for board: ");
        int row = sc.nextInt();
        System.out.println("Enter col size for board: ");
        int col = sc.nextInt();
        // Initialize players
        Player p1 = new Player(1, "Player 1", Mark.X);
        Player p2 = new Player(2, "Player 2", Mark.O);
        List<Player> players = Arrays.asList(p1, p2);
        System.out.println("Enter curr player to start: ");
        int currentPlayer = sc.nextInt();

        // Initialize game
        initialiseGame(game, row, col, players, currentPlayer);
        gameService.startGame(sc, game);
        sc.close();
    }
}
