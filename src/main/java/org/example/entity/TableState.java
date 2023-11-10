package org.example.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TableState {
    private Integer id;

    private String type;

    private Integer player1Id;

    private Integer player2Id;

    private String player1IdMove;

    private String player2IdMove;

    private List<String> chatLog;
}
