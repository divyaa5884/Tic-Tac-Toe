package com.example.TicTacToe.service;

import com.example.TicTacToe.enums.Mark;
import com.example.TicTacToe.model.Board;
import com.example.TicTacToe.model.Game;
import com.example.TicTacToe.model.Player;

import java.util.List;
import java.util.Scanner;


public class GameService {

    public void startGame(Scanner sc, Game game) {
        int currPlayer = 0;
        Board board = game.getBoard();
        List<Player> playerList = game.getPlayers();
        while(!game.isGameOver()) { // game can be over w/o any player winning
            // check if board is full
            if (!board.isFull()) { // need to start a new game
                currPlayer = game.getCurrentPlayer();
                System.out.println("Enter cell positions(row) 1 - " + board.getRow() + ", (col) 1 - " + board.getCol() + " : ");
                int posX = sc.nextInt() - 1; // as board is 0 based indexed
                int posY = sc.nextInt() - 1;
                if (board.isValidMove(game, posX, posY)) {
                    if (!board.makeMove(game, currPlayer, posX, posY)) {
                        continue;
                    }
                    if (board.isWinner(game, currPlayer, posX, posY)) {
                        System.out.println("CurrPlayer " + currPlayer + " wins!");
                        game.setGameOver(true);
                        break;
                    }
                }
            } else {
                game.setGameOver(true);
                System.out.println("Board is full, please start a new game");
                break;
            }
            printBoard(board);
            // now turn should be for next player
            if (currPlayer % playerList.size() == 0) {
                currPlayer = 1;
            } else {
                currPlayer++;
            }
            game.setCurrentPlayer(currPlayer);
        }
    }
    public void printBoard(Board board) {
        System.out.println("\nCurrent Board:");
        for (int i = 0; i < board.getRow(); i++) {
            for (int j = 0; j < board.getCol(); j++) {
                Mark mark = board.getGrid()[i][j];
                System.out.print(mark == Mark.EMPTY ? " " : mark);
                if (j < board.getCol()) System.out.print(" | ");
            }
            System.out.println();
            if (i < board.getRow()) System.out.println("---------");
        }
    }
}
