package org.example.chess_game;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.border.LineBorder;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class chess_2 extends JFrame {
    String [][]arr;
    String [][]color_arr = new String [8][8];
    JButton [][] b;

    String bp="265F"; // tốt
    String br="265C";// xe
    String bh="265E";//ngựa
    String bn="265D";//tương
    String bk="265A";//vua
    String bq="265B";//hậu
    int row = 8, col = 8;
    String brown="#8A6A4F";
    String white="#FABB79";
    boolean[][] state = new boolean[8][8];
    boolean[][] state_move;



    public chess_2 () {
        state_move = new boolean[][]{{true,true,true,true,true,true,true,true,},
                {true,true,true,true,true,true,true,true,},
                {true,true,true,true,true,true,true,true,},
                {true,true,true,true,true,true,true,true,},
                {true,true,true,true,true,true,true,true,},
                {true,true,true,true,true,true,true,true,},
                {true,true,true,true,true,true,true,true,},
                {true,true,true,true,true,true,true,true,},};
        arr = new String[][]{ { "br","bh","bn","bq","bk","bn","bh","br" },
                { "bp","bp","bp","bp","bp","bp","bp","bp" },
                { "--","--","--","--","--","--","--","--" },
                { "--","--","--","--","--","--","--","--" },
                { "--","--","--","wq","--","--","--","--" },
                { "--","--","--","--","--","--","--","--" },
                { "wp","wp","wp","wp","wp","wp","wp","wp" },
                { "wr","wh","wn","wq","wk","wn","wh","wr" }};
        setSize(1200, 750);
        setVisible(true);
        setResizable(false);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.MAGENTA));
        panel.setBounds(0, 0, 1186, 713);
        getContentPane().add(panel);
        panel.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new LineBorder(Color.PINK, 2));
        panel_1.setBounds(49, 29, 660, 660);
        panel.add(panel_1);
        panel_1.setLayout(new GridLayout(row,col));



        load_game(panel_1);

    }




    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new chess_2();
            }
        });
    }


    public void load_game(JPanel panel_1) {
        int count;
        b = new JButton[8][8];
        for(int i = 0; i< 8; i++) {
            if(i%2==0) {
                count = 0;
            }
            else {
                count = 1;
            }
            for(int j = 0 ; j < 8; j++) {
                if(count%2==0) {
                    b[i][j] = new JButton(" " );
                    b[i][j].setBackground(Color.decode(brown));
                    color_arr[i][j] = "b";

                }
                else {
                    b[i][j] = new JButton(" ");
                    b[i][j].setBackground(Color.decode(white));
                    color_arr[i][j] = "w";
                }
                panel_1.add(b[i][j]);
                state[i][j] = true;

                count++;
            }

        }

        for(int i = 0; i< 8; i++) {
            for(int j = 0 ; j < 8; j++) {
                if(arr[i][j].equalsIgnoreCase("br")) {
                    b[i][j].setFont(new Font("Dialog", Font.BOLD, 40));
                    b[i][j].setText(String.valueOf(Character.toChars(Integer.parseInt(br,16))));
                    state[i][j] = true;
                }
                else if(arr[i][j].equalsIgnoreCase("bh")) {
                    b[i][j].setFont(new Font("Dialog", Font.BOLD, 40));
                    b[i][j].setText(String.valueOf(Character.toChars(Integer.parseInt(bh,16))));
                    state[i][j] = true;
                }
                else if(arr[i][j].equalsIgnoreCase("bn")) {
                    b[i][j].setFont(new Font("Dialog", Font.BOLD, 40));
                    b[i][j].setText(String.valueOf(Character.toChars(Integer.parseInt(bn,16))));
                    state[i][j] = true;
                }
                else if(arr[i][j].equalsIgnoreCase("bq")) {
                    b[i][j].setFont(new Font("Dialog", Font.BOLD, 40));
                    b[i][j].setText(String.valueOf(Character.toChars(Integer.parseInt(bq,16))));
                    state[i][j] = true;
                }
                else if(arr[i][j].equalsIgnoreCase("bk")) {
                    b[i][j].setFont(new Font("Dialog", Font.BOLD, 40));
                    b[i][j].setText(String.valueOf(Character.toChars(Integer.parseInt(bk,16))));
                    state[i][j] = true;
                }
                else if(arr[i][j].equalsIgnoreCase("bp")) {
                    b[i][j].setFont(new Font("Dialog", Font.BOLD, 40));
                    b[i][j].setText(String.valueOf(Character.toChars(Integer.parseInt(bp,16))));
                    state[i][j] = true;
                }
                else if(arr[i][j].equalsIgnoreCase("wr")) {
                    b[i][j].setForeground(Color.WHITE);
                    b[i][j].setFont(new Font("Dialog", Font.BOLD, 40));
                    b[i][j].setText(String.valueOf(Character.toChars(Integer.parseInt(br,16))));
                    state[i][j] = true;
                }
                else if(arr[i][j].equalsIgnoreCase("wh")) {
                    b[i][j].setForeground(Color.WHITE);
                    b[i][j].setFont(new Font("Dialog", Font.BOLD, 40));
                    b[i][j].setText(String.valueOf(Character.toChars(Integer.parseInt(bh,16))));
                    state[i][j] = true;
                }
                else if(arr[i][j].equalsIgnoreCase("wn")) {
                    b[i][j].setForeground(Color.WHITE);
                    b[i][j].setFont(new Font("Dialog", Font.BOLD, 40));
                    b[i][j].setText(String.valueOf(Character.toChars(Integer.parseInt(bn,16))));
                    state[i][j] = true;
                }
                else if(arr[i][j].equalsIgnoreCase("wq")) {
                    b[i][j].setForeground(Color.WHITE);
                    b[i][j].setFont(new Font("Dialog", Font.BOLD, 40));
                    b[i][j].setText(String.valueOf(Character.toChars(Integer.parseInt(bq,16))));
                    state[i][j] = true;
                }
                else if(arr[i][j].equalsIgnoreCase("wk")) {
                    b[i][j].setForeground(Color.WHITE);
                    b[i][j].setFont(new Font("Dialog", Font.BOLD, 40));
                    b[i][j].setText(String.valueOf(Character.toChars(Integer.parseInt(bk,16))));
                    state[i][j] = true;
                }
                else if(arr[i][j].equalsIgnoreCase("wp")) {
                    b[i][j].setForeground(Color.WHITE);
                    b[i][j].setFont(new Font("Dialog", Font.BOLD, 40));
                    b[i][j].setText(String.valueOf(Character.toChars(Integer.parseInt(bp,16))));
                }
                else {
                    state[i][j] = false;
                }

            }
        }

            chosen();
    }


        public void chosen(){

            for(int i = 0; i< 8; i++) {
                for (int j = 0; j < 8; j++) {
                    int finalI = i;
                    int finalJ = j;

                    b[i][j].addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            state_move[finalI][finalJ] = !state_move[finalI][finalJ];
                            if(state[finalI][finalJ]==true && state_move[finalI][finalJ] == false){
                                b[finalI][finalJ].setBackground(Color.blue);
                                if(arr[finalI][finalJ].equalsIgnoreCase("wq") || arr[finalI][finalJ].equalsIgnoreCase("bq")){
                                    queen(finalI,finalJ);
                                }
                            }
                            else if(state[finalI][finalJ]==true && state_move[finalI][finalJ] == true){

                                    for(int i = 0; i < 8; i++){
                                        for (int j = 0; j < 8 ; j++){
                                                if(color_arr[i][j].equalsIgnoreCase("w")){
                                                    b[i][j].setBackground(Color.decode(white));
                                                }
                                                else b[i][j].setBackground(Color.decode(brown));

                                            }

                                    }
                            }

                        }

                    });


                }
            }
        }
    public void queen(int x, int y){
        for(int i = 1; i < 8; i++){ //dọc hướng lên trên
            if(x - i <0 ){
                break;
            }
            if(state[x-i][y] == true){
                char c = arr[x][y].charAt(0);
                char c2 = arr[x-i][y].charAt(0);
                if(c != c2){
                    b[x-i][y].setBackground(Color.RED);
                    break;
                }
                else break;
            }

            if(x-i >=0){
                b[x-i][y].setBackground(Color.green);
            }
            else break;
        }

        for(int i = 1 ; i<8; i++){  //dọc xuống dưới
            if(x+i > 7 ){
                break;
            }
            if(state[x+i][y] == true){
                break;
            }
            if(x+i < 8){
                b[x+i][y].setBackground(Color.green);
            }
            else break;
        }
        for(int i = 1; i < 8; i++){ //ngang sang trái
            if(y - i < 0){
                break;
            }
            if(state[x][y-i] == true){
                break;
            }
            if(y-i >=0){
                b[x][y-i].setBackground(Color.green);
            }
            else break;
        }

        for(int i = 1 ; i<8; i++){// ngang sang phải
            if( y+i>7){
                break;
            }
            if(state[x][y+i] == true){
                break;
            }
            if(y+i < 8){
                b[x][y+i].setBackground(Color.green);
                System.out.println(x +" " +(y+i));
            }
            else break;
        }


    }


}
