package com.example.TicTacToe.model;

import com.example.TicTacToe.enums.Mark;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board {
    int row;
    int col;
    Mark[][] grid;

    public boolean isValidMove(Game game, int x, int y) { // x,y : 0 indexed based
        Board board = game.getBoard();
        Mark[][] grid = board.getGrid();
        if (!game.isGameOver()) {
//            check if cell is empty & pos is valid
            if (   x >= 0 && x < board.getRow()
                    && y >= 0 && y < board.getCol()
                    && grid[x][y] == Mark.EMPTY) {
                return true;
            }
        }
        return false;
    }
    public boolean makeMove(Game game, int playerId, int x, int y) {
        Mark mark = game.getPlayerMarkMap().get(playerId);
        if (grid[x][y] == Mark.EMPTY) {
            grid[x][y] = mark;
            return true;
        } else {
//            throw exception & do same fn again: take inputs and so on for the same user
        }
        return false;
    }
    public boolean isRowStriked(Game game, int x, int y, Mark mark) {
        for (int i = 0; i < col; i++) {
            if (grid[x][i] != mark){
                return false;
            }
        }
        return true;
    }
    public boolean isColStriked(Game game, int x, int y, Mark mark) {
        for (int i = 0; i < row; i++) {
            if (grid[i][y] != mark){
                return false;
            }
        }
        return true;
    }
    public boolean isAnyDiagonalStriked(Game game, int x, int y, Mark mark) {
        boolean isStriked = true;
        for (int i = 0; i < row; i++) {
            if (grid[i][i] != mark){
                isStriked = false;
                break;
            }
        }
        if (isStriked) return true;
        isStriked = true;
        for (int i = 0; i < row; i++) {
            if (grid[i][row-i-1] != mark) {
                isStriked = false;
            }
        }
        return isStriked;
    }

    public boolean isWinner(Game game, int playerId, int x, int y) {
        Mark mark = game.getPlayerMarkMap().get(playerId);
        boolean isDiagStriked = false;

        if (x == y || (x+y == row-1)) {  // 0,2:
            isDiagStriked = isAnyDiagonalStriked(game, x, y, mark);
        }

        if (isColStriked(game, x, y, mark) || isRowStriked(game, x, y, mark)
                || isDiagStriked) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == Mark.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}
