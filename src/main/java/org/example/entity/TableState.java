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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getPlayer1Id() {
        return player1Id;
    }

    public void setPlayer1Id(Integer player1Id) {
        this.player1Id = player1Id;
    }

    public Integer getPlayer2Id() {
        return player2Id;
    }

    public void setPlayer2Id(Integer player2Id) {
        this.player2Id = player2Id;
    }

    public String getPlayer1IdMove() {
        return player1IdMove;
    }

    public void setPlayer1IdMove(String player1IdMove) {
        this.player1IdMove = player1IdMove;
    }

    public String getPlayer2IdMove() {
        return player2IdMove;
    }

    public void setPlayer2IdMove(String player2IdMove) {
        this.player2IdMove = player2IdMove;
    }

    public List<String> getChatLog() {
        return chatLog;
    }

    public void setChatLog(List<String> chatLog) {
        this.chatLog = chatLog;
    }
}
