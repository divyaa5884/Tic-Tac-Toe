package com.example.TicTacToe.model;

import com.example.TicTacToe.enums.Mark;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {
    int id;
    String name;
    Mark mark;
}
