package org.example.chess_game;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.MatteBorder;


import java.awt.*;

import javax.swing.border.LineBorder;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class chess_2 extends JFrame {
    Timer T1;
    Timer T2;
    Timer T3;
    static String sendUser = "Long: ";
    static int count = 0;
    private static JTextField chatField;
    final boolean[] w = {true};
    String[][] arr;
    String[][] color_arr = new String[8][8];
    JButton[][] b;

    String bp = "265F"; // tốt
    String br = "265C";// xe
    String bh = "265E";//ngựa
    String bn = "265D";//tương
    String bk = "265A";//vua
    String bq = "265B";//hậu
    int row = 8, col = 8;
    String brown = "#8A6A4F";
    String white = "#FABB79";
    boolean[][] state = new boolean[8][8];
    boolean[][] state_move;

    boolean[][] state_color;
    int bienluu1 = 0;
    int bienluu2 =0;
    int fontSize = 33;
    private JTextField textField;
    static String [] chat = new String [1000];
    private JTextField txtName;
    private JTextField win_text2;
    private JTextField txtName1;
    private JTextField win_text1;
    int t1 = 1200;
    int t2 = 1200;
    int m1 = 20;
    int m2 = 20;
    int s1 =0;
    int s2 = 0;
    public chess_2() {
        count = 0;

        state_move = new boolean[][]{{true, true, true, true, true, true, true, true,},
                {true, true, true, true, true, true, true, true,},
                {true, true, true, true, true, true, true, true,},
                {true, true, true, true, true, true, true, true,},
                {true, true, true, true, true, true, true, true,},
                {true, true, true, true, true, true, true, true,},
                {true, true, true, true, true, true, true, true,},
                {true, true, true, true, true, true, true, true,},};
        arr = new String[][]{{"br", "bh", "bn", "bq", "bk", "bn", "bh", "br"},
                {"bp", "bp", "bp", "bp", "bp", "bp", "bp", "bp"},
                {"--", "--", "--", "--", "--", "--", "--", "--"},
                {"--", "--", "--", "--", "--", "--", "--", "--"},
                {"--", "--", "--", "--", "--", "--", "--", "--"},
                {"--", "--", "--", "--", "--", "--", "--", "--"},
                {"wp", "wp", "wp", "wp", "wp", "wp", "wp", "wp"},
                {"wr", "wh", "wn", "wq", "wk", "wn", "wh", "wr"}};
        setSize(1200, 750);
        setVisible(true);
        setResizable(false);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel Panel_Ban_Co = new JPanel();
        Panel_Ban_Co.setBackground(Color.DARK_GRAY);
        Panel_Ban_Co.setBorder(new LineBorder(new Color(128, 0, 64), 3));
        Panel_Ban_Co.setBounds(10, -10, 1186, 713);
        getContentPane().add(Panel_Ban_Co);
        Panel_Ban_Co.setLayout(null);

        JPanel panel_1 = new JPanel();
        Panel_Ban_Co.add(panel_1);



        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(587, 212, 573, 422);
        Panel_Ban_Co.add(scrollPane);





        JTextArea textArea = new JTextArea();
        scrollPane.setViewportView(textArea);
        textArea.setFont(new Font("Segoe UI Variable", Font.BOLD, 17));
        textArea.setBackground(Color.PINK);
        textArea.setBorder(new MatteBorder(5, 5, 5, 5, (Color) Color.ORANGE));
        textArea.setEditable(false);
        chatField = new JTextField();
        chatField.setFont(new Font("Segoe UI Variable", Font.PLAIN, 18));
        chatField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER) {
                    if(count <= 999) {
                        chat[count] = chatField.getText();
                        chatField.setText("");
                        count++;
                        textArea.append(sendUser + chat[count-1] + "\n");
                    }
                }
            }
        });
        chatField.setBounds(589, 644, 476, 59);
        Panel_Ban_Co.add(chatField);
        chatField.setColumns(10);



        JButton btnNewButton = new JButton("Gửi");
        btnNewButton.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                if(count <= 999) {
                    chat[count] = chatField.getText();
                    chatField.setText("");
                    count++;
                    textArea.append(sendUser + chat[count-1] + "\n");
                }


            }
        });
        btnNewButton.setBounds(1071, 644, 89, 59);
        Panel_Ban_Co.add(btnNewButton);

        textField = new JTextField();
        textField.setEditable(false);
        textField.setBounds(587, 81, 589, 121);
        Panel_Ban_Co.add(textField);
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setFont(new Font("Dialog", Font.BOLD, fontSize));
        textField.setText("Bên trắng đánh" + String.valueOf(Character.toChars(Integer.parseInt(bh, 16))));
        textField.setColumns(10);

        txtName = new JTextField();
        txtName.setBounds(105, 646, 135, 30);
        Panel_Ban_Co.add(txtName);
        txtName.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        txtName.setFont(new Font("Segoe UI Variable", Font.BOLD, 17));
        txtName.setText("Tân Long");
        txtName.setForeground(Color.WHITE);
        txtName.setOpaque(false);
        txtName.setEditable(false);
        txtName.setColumns(10);

        JLabel AnhDaiDien2 = new JLabel("New label");
        AnhDaiDien2.setBounds(22, 646, 73, 57);
        BufferedImage avt2 = null;
        try {
            avt2 = ImageIO.read(new File("img/avt.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Image avt2_user = avt2.getScaledInstance(73,57,Image.SCALE_SMOOTH);
        ImageIcon avt2_icon = new ImageIcon(avt2_user);
        AnhDaiDien2.setIcon(avt2_icon);
        Panel_Ban_Co.add(AnhDaiDien2);
        AnhDaiDien2.setOpaque(true);

        win_text2 = new JTextField();
        win_text2.setBounds(106, 673, 134, 30);
        Panel_Ban_Co.add(win_text2);
        win_text2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        win_text2.setText("Win: ");
        win_text2.setOpaque(false);
        win_text2.setForeground(Color.WHITE);
        win_text2.setFont(new Font("Segoe UI Variable", Font.BOLD, 17));
        win_text2.setEditable(false);
        win_text2.setColumns(10);

        JLabel AnhDaiDien1 = new JLabel("New label");
        AnhDaiDien1.setOpaque(true);
        AnhDaiDien1.setBounds(22, 14, 73, 57);
        BufferedImage avt1 = null;
        try {
            avt1 = ImageIO.read(new File("img/IMG_1745.PNG"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Image avt1_user = avt1.getScaledInstance(73,57,Image.SCALE_SMOOTH);
        ImageIcon avt1_icon = new ImageIcon(avt1_user);
        AnhDaiDien1.setIcon(avt1_icon);
        Panel_Ban_Co.add(AnhDaiDien1);

        txtName1 = new JTextField();
        txtName1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        txtName1.setForeground(Color.WHITE);
        txtName1.setOpaque(false);
        txtName1.setText("Hồng Nhung");
        txtName1.setFont(new Font("Segoe UI Variable", Font.BOLD, 16));
        txtName1.setHorizontalAlignment(SwingConstants.LEFT);
        txtName1.setBounds(105, 14, 119, 31);
        Panel_Ban_Co.add(txtName1);
        txtName1.setColumns(10);

        win_text1 = new JTextField();
        win_text1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        win_text1.setFont(new Font("Segoe UI Variable", Font.BOLD, 16));
        win_text1.setText("Win: ");
        win_text1.setHorizontalAlignment(SwingConstants.LEFT);
        win_text1.setForeground(Color.WHITE);
        win_text1.setOpaque(false);
        win_text1.setBounds(105, 41, 120, 41);
        Panel_Ban_Co.add(win_text1);
        win_text1.setColumns(10);

        JLabel TimeLabel_1 = new JLabel("Time player 1");
        TimeLabel_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 16));
        TimeLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        TimeLabel_1.setOpaque(true);
        TimeLabel_1.setBounds(431, 14, 146, 57);
        Panel_Ban_Co.add(TimeLabel_1);


        JLabel TimeLabel_2 = new JLabel("Time player 2");
        TimeLabel_2.setOpaque(true);
        TimeLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        TimeLabel_2.setFont(new Font("Segoe UI Variable", Font.BOLD, 16));
        TimeLabel_2.setBounds(431, 646, 146, 57);
        Panel_Ban_Co.add(TimeLabel_2);

        load_game(panel_1);
        time_countDown(TimeLabel_1, TimeLabel_2);

    }


    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new chess_2();
            }
        });
    }

    private void time_countDown(JLabel TimeLabel, JLabel TimeLabe2) {
        t1 = 1200;
        t2 = 1200;
        m1 = 0;
        m2 = 0;
        s1 = 5;
        s2 = 5;
        T1 = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s1--;
                if(s1 < 10) {
                    TimeLabel.setText(String.valueOf(m1) + ":0" + String.valueOf(s1));
                }else {
                    TimeLabel.setText(String.valueOf(m1) + ":" + String.valueOf(s1));
                }
                if(s1 == 0) {
                    if(m1>0){
                        m1--;
                        s1 = 59;
                    }else if(m1==0){
                        s1 = 0;
                    }
                }
                if(m1 == 0) {
                    if(s1 == 0) {
                        TimeLabel.setText(String.valueOf(m1) + ":0" + String.valueOf(s1));
                        arr = new String[][]{{"br", "bh", "bn", "bq", "bk", "bn", "bh", "br"},
                                {"bp", "bp", "bp", "bp", "bp", "bp", "bp", "bp"},
                                {"--", "--", "--", "--", "--", "--", "--", "--"},
                                {"--", "--", "--", "--", "--", "--", "--", "--"},
                                {"--", "--", "--", "--", "--", "--", "--", "--"},
                                {"--", "--", "--", "--", "--", "--", "--", "--"},
                                {"wp", "wp", "wp", "wp", "wp", "wp", "wp", "wp"},
                                {"wr", "wh", "wn", "wq", "wk", "wn", "wh", "wr"}};
                        updatState(1,1);
                        JOptionPane.showMessageDialog(null, "Đen hết thời gian trắng thắng");

                        w[0] = true;
                        T1.stop();
                        m1=19;
                        m2=19;
                        s1=60;
                        s2=60;
                        TimeLabel.setText(String.valueOf(20) + ":0" + String.valueOf(0));
                        TimeLabe2.setText(String.valueOf(20) + ":0" + String.valueOf(0));
                    }
                }
            }
        });
        T2 = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                s2--;
                if(s2 < 10) {
                    TimeLabe2.setText(String.valueOf(m2) + ":0" + String.valueOf(s2));
                }else {
                    TimeLabe2.setText(String.valueOf(m2) + ":" + String.valueOf(s2));
                }
                if(s2 == 0) {
                    if(m2>0){
                        m2--;
                        s2 = 59;
                    }else if(m2==0){
                        s2 = 0;
                    }

                }
                if(m2 == 0) {
                    if(s2 == 0) {
                        TimeLabe2.setText(String.valueOf(m2) + ":0" + String.valueOf(s2));
                        arr = new String[][]{{"br", "bh", "bn", "bq", "bk", "bn", "bh", "br"},
                                {"bp", "bp", "bp", "bp", "bp", "bp", "bp", "bp"},
                                {"--", "--", "--", "--", "--", "--", "--", "--"},
                                {"--", "--", "--", "--", "--", "--", "--", "--"},
                                {"--", "--", "--", "--", "--", "--", "--", "--"},
                                {"--", "--", "--", "--", "--", "--", "--", "--"},
                                {"wp", "wp", "wp", "wp", "wp", "wp", "wp", "wp"},
                                {"wr", "wh", "wn", "wq", "wk", "wn", "wh", "wr"}};
                        updatState(1,1);
                        JOptionPane.showMessageDialog(null, "Trắng hết thời gian đen thắng");
                        w[0] = true;
                        T2.stop();
                        m1=19;
                        m2=19;
                        s1=60;
                        s2= 60;
                        TimeLabel.setText(String.valueOf(20) + ":0" + String.valueOf(0));
                        TimeLabe2.setText(String.valueOf(20) + ":0" + String.valueOf(0));
                    }
                }
            }
        });

    }

    public void load_game(JPanel panel_1) {
        panel_1.setBackground(Color.GRAY);
        panel_1.setBorder(new LineBorder(Color.PINK, 2));
        panel_1.setBounds(22, 81, 555, 555);
        panel_1.setLayout(new GridLayout(row, col));


        int countt;
        b = new JButton[8][8];
        for (int i = 0; i < 8; i++) {
            if (i % 2 == 0) {
                countt = 0;
            } else {
                countt = 1;
            }
            for (int j = 0; j < 8; j++) {
                if (countt % 2 == 0) {
                    b[i][j] = new JButton(" ");
                    b[i][j].setBackground(Color.decode(white));
                    color_arr[i][j] = "b";

                } else {
                    b[i][j] = new JButton(" ");
                    b[i][j].setBackground(Color.decode(brown));
                    color_arr[i][j] = "w";
                }
                panel_1.add(b[i][j]);
                state[i][j] = true;

                countt++;
            }

        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (arr[i][j].equalsIgnoreCase("br")) {
                    b[i][j].setFont(new Font("Dialog", Font.BOLD, fontSize));
                    b[i][j].setText(String.valueOf(Character.toChars(Integer.parseInt(br, 16))));
                    state[i][j] = true;
                    b[i][j].setForeground(Color.BLACK);
                } else if (arr[i][j].equalsIgnoreCase("bh")) {
                    b[i][j].setFont(new Font("Dialog", Font.BOLD, fontSize));
                    b[i][j].setText(String.valueOf(Character.toChars(Integer.parseInt(bh, 16))));
                    state[i][j] = true;
                    b[i][j].setForeground(Color.BLACK);
                } else if (arr[i][j].equalsIgnoreCase("bn")) {
                    b[i][j].setFont(new Font("Dialog", Font.BOLD, fontSize));
                    b[i][j].setText(String.valueOf(Character.toChars(Integer.parseInt(bn, 16))));
                    state[i][j] = true;
                    b[i][j].setForeground(Color.BLACK);
                } else if (arr[i][j].equalsIgnoreCase("bq")) {
                    b[i][j].setFont(new Font("Dialog", Font.BOLD, fontSize));
                    b[i][j].setText(String.valueOf(Character.toChars(Integer.parseInt(bq, 16))));
                    state[i][j] = true;
                    b[i][j].setForeground(Color.BLACK);
                } else if (arr[i][j].equalsIgnoreCase("bk")) {
                    b[i][j].setFont(new Font("Dialog", Font.BOLD, fontSize));
                    b[i][j].setText(String.valueOf(Character.toChars(Integer.parseInt(bk, 16))));
                    state[i][j] = true;
                    b[i][j].setForeground(Color.BLACK);
                } else if (arr[i][j].equalsIgnoreCase("bp")) {
                    b[i][j].setFont(new Font("Dialog", Font.BOLD, fontSize));
                    b[i][j].setText(String.valueOf(Character.toChars(Integer.parseInt(bp, 16))));
                    state[i][j] = true;
                    b[i][j].setForeground(Color.BLACK);
                } else if (arr[i][j].equalsIgnoreCase("wr")) {
                    b[i][j].setForeground(Color.WHITE);
                    b[i][j].setFont(new Font("Dialog", Font.BOLD, fontSize));
                    b[i][j].setText(String.valueOf(Character.toChars(Integer.parseInt(br, 16))));
                    state[i][j] = true;
                } else if (arr[i][j].equalsIgnoreCase("wh")) {
                    b[i][j].setForeground(Color.WHITE);
                    b[i][j].setFont(new Font("Dialog", Font.BOLD, fontSize));
                    b[i][j].setText(String.valueOf(Character.toChars(Integer.parseInt(bh, 16))));
                    state[i][j] = true;
                } else if (arr[i][j].equalsIgnoreCase("wn")) {
                    b[i][j].setForeground(Color.WHITE);
                    b[i][j].setFont(new Font("Dialog", Font.BOLD, fontSize));
                    b[i][j].setText(String.valueOf(Character.toChars(Integer.parseInt(bn, 16))));
                    state[i][j] = true;
                } else if (arr[i][j].equalsIgnoreCase("wq")) {
                    b[i][j].setForeground(Color.WHITE);
                    b[i][j].setFont(new Font("Dialog", Font.BOLD, fontSize));
                    b[i][j].setText(String.valueOf(Character.toChars(Integer.parseInt(bq, 16))));
                    state[i][j] = true;
                } else if (arr[i][j].equalsIgnoreCase("wk")) {
                    b[i][j].setForeground(Color.WHITE);
                    b[i][j].setFont(new Font("Dialog", Font.BOLD, fontSize));
                    b[i][j].setText(String.valueOf(Character.toChars(Integer.parseInt(bk, 16))));
                    state[i][j] = true;
                } else if (arr[i][j].equalsIgnoreCase("wp")) {
                    b[i][j].setForeground(Color.WHITE);
                    b[i][j].setFont(new Font("Dialog", Font.BOLD, fontSize));
                    b[i][j].setText(String.valueOf(Character.toChars(Integer.parseInt(bp, 16))));
                    state[i][j] = true;
                } else {
                    state[i][j] = false;
                }

            }
        } // hiện bbàn cờ


        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                int finalI = i;
                int finalJ = j;


                b[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        updatState(finalI,finalJ);
                        if(w[0] == true){
                            if(!arr[finalI][finalJ].equalsIgnoreCase("--") && b[finalI][finalJ].getForeground() == Color.white){
                                movement(finalI,finalJ);
                            }
                            else if(arr[finalI][finalJ].equalsIgnoreCase("--") && b[finalI][finalJ].getBackground() == Color.green){
                                movement(finalI,finalJ);
                            }
                            else if(!arr[finalI][finalJ].equalsIgnoreCase("--") && b[finalI][finalJ].getBackground() == Color.RED){
                                movement(finalI,finalJ);
                            }

                        }
                        else{
                            if(!arr[finalI][finalJ].equalsIgnoreCase("--") && b[finalI][finalJ].getForeground() == Color.black){
                                movement(finalI,finalJ);
                            }
                            else if(arr[finalI][finalJ].equalsIgnoreCase("--") && b[finalI][finalJ].getBackground() == Color.green){
                                movement(finalI,finalJ);
                            }
                            else if(!arr[finalI][finalJ].equalsIgnoreCase("--") && b[finalI][finalJ].getBackground() == Color.RED){
                                movement(finalI,finalJ);
                            }
                        }

                    }

                });


            }
        }  //Chọn và đánh cờ


    }


    public void movement(int finalI, int finalJ){

        state_move[finalI][finalJ] = !state_move[finalI][finalJ];
        if (!arr[finalI][finalJ].equalsIgnoreCase("--") && b[finalI][finalJ].getBackground() != Color.RED) {
            if (state_move[finalI][finalJ] == false) {
                b[finalI][finalJ].setBackground(Color.blue);
                if (arr[finalI][finalJ].equalsIgnoreCase("wq") || arr[finalI][finalJ].equalsIgnoreCase("bq")) {
                    queen(finalI, finalJ);
                } else if (arr[finalI][finalJ].equalsIgnoreCase("wr") || arr[finalI][finalJ].equalsIgnoreCase("br")) {
                    rook(finalI, finalJ);
                } else if (arr[finalI][finalJ].equalsIgnoreCase("wn") || arr[finalI][finalJ].equalsIgnoreCase("bn")) {
                    bishop(finalI, finalJ);
                } else if (arr[finalI][finalJ].equalsIgnoreCase("wp") || arr[finalI][finalJ].equalsIgnoreCase("bp")) {
                    pawn(finalI, finalJ);
                } else if (arr[finalI][finalJ].equalsIgnoreCase("wK") || arr[finalI][finalJ].equalsIgnoreCase("bk")) {
                    king(finalI, finalJ);
                } else if (arr[finalI][finalJ].equalsIgnoreCase("bh") || arr[finalI][finalJ].equalsIgnoreCase("wh")) {
                    horse(finalI, finalJ);
                }

            }
        }

        if(arr[finalI][finalJ].equalsIgnoreCase("--") && b[finalI][finalJ].getBackground() == Color.green){ //di chuyển

            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8; j++){
                    if(b[i][j].getBackground() == Color.blue){
                        String s = "";
                        s = arr[finalI][finalJ];
                        arr[finalI][finalJ] = arr[i][j];
                        arr[i][j] = s;
                        updatState(i,j);
                        w[0] = !w[0];
                        if(w[0] == true) {
                            textField.setText("Bên trắng đánh" + String.valueOf(Character.toChars(Integer.parseInt(bh, 16))));
                            T2.start();
                            T1.stop();
                                                    }
                        else if(w[0] == false) {
                            textField.setText("Bên đen đánh" + String.valueOf(Character.toChars(Integer.parseInt(bh, 16))));
                            T2.stop();
                            T1.start();
                        }

                    }
                }
            }
        }System.out.println(arr[finalI][finalJ]);
        System.out.println(b[finalI][finalJ].getBackground());
        if(arr[finalI][finalJ]!= "--" && b[finalI][finalJ].getBackground() == Color.RED){// ăn
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8; j++){
                    if(b[i][j].getBackground() == Color.blue){
                        if(i == 4 && finalI == 4){
                            if(arr[i][j] == "bp" && arr[finalI][finalJ] == "wp"){
                                arr[finalI+1][finalJ] = arr[i][j];
                                arr[i][j] = "--";
                                arr[finalI][finalJ] = arr[i][j];
                                updatState(i,j);
                                w[0] = !w[0];
                                if(w[0] == true) {
                                    textField.setText("Bên trắng đánh" + String.valueOf(Character.toChars(Integer.parseInt(bh, 16))));
                                    T2.start();
                                    T1.stop();

                                }
                                else if(w[0] == false) {
                                    textField.setText("Bên đen đánh" + String.valueOf(Character.toChars(Integer.parseInt(bh, 16))));
                                    T1.start();
                                    T2.stop();
                                }
                            }
                        }
                        else if(i == 3 && finalI == 3){
                            if(arr[i][j] == "wp" && arr[finalI][finalJ] == "bp"){
                                arr[finalI-1][finalJ] = arr[i][j];
                                arr[i][j] = "--";
                                arr[finalI][finalJ] = arr[i][j];
                                updatState(i,j);
                                w[0] = !w[0];

                            }
                        }
                        else{
                            if(arr[finalI][finalJ] == "wk"){
                                arr[finalI][finalJ] = arr[i][j];
                                arr[i][j] = "--";
                                arr = new String[][]{{"br", "bh", "bn", "bq", "bk", "bn", "bh", "br"},
                                        {"bp", "bp", "bp", "bp", "bp", "bp", "bp", "bp"},
                                        {"--", "--", "--", "--", "--", "--", "--", "--"},
                                        {"--", "--", "--", "--", "--", "--", "--", "--"},
                                        {"--", "--", "--", "--", "--", "--", "--", "--"},
                                        {"--", "--", "--", "--", "--", "--", "--", "--"},
                                        {"wp", "wp", "wp", "wp", "wp", "wp", "wp", "wp"},
                                        {"wr", "wh", "wn", "wq", "wk", "wn", "wh", "wr"}};
                                updatState(i,j);
                                textField.setText("Bên trắng đánh" + String.valueOf(Character.toChars(Integer.parseInt(bh, 16))));
                                w[0] = true;
                                JOptionPane.showMessageDialog(null, "Bên đen thắng rồi đm trắng ngu l");

                            }
                            else if(arr[finalI][finalJ] == "bk"){
                                arr[finalI][finalJ] = arr[i][j];
                                arr[i][j] = "--";
                                arr = new String[][]{{"br", "bh", "bn", "bq", "bk", "bn", "bh", "br"},
                                        {"bp", "bp", "bp", "bp", "bp", "bp", "bp", "bp"},
                                        {"--", "--", "--", "--", "--", "--", "--", "--"},
                                        {"--", "--", "--", "--", "--", "--", "--", "--"},
                                        {"--", "--", "--", "--", "--", "--", "--", "--"},
                                        {"--", "--", "--", "--", "--", "--", "--", "--"},
                                        {"wp", "wp", "wp", "wp", "wp", "wp", "wp", "wp"},
                                        {"wr", "wh", "wn", "wq", "wk", "wn", "wh", "wr"}};
                                updatState(i,j);
                                w[0] = true;
                                textField.setText("Bên trắng đánh" + String.valueOf(Character.toChars(Integer.parseInt(bh, 16))));
                                JOptionPane.showMessageDialog(null, "Bên trắng thắng rồi đm đen ngu l");

                            }
                            else{
                                arr[finalI][finalJ] = arr[i][j];
                                arr[i][j] = "--";
                                updatState(i,j);
                                w[0] = !w[0];
                            }
                        }

                    }
                }
            }
        }
    }

    public void updatState(int x, int y) {
        if(b[x][y].getBackground() == Color.green){
            System.out.print("Green + ");
        }
        else if(b[x][y].getBackground() == Color.RED){
            System.out.print("RED + ");
        }

        else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (arr[i][j].equalsIgnoreCase("br")) {
                        b[i][j].setForeground(Color.BLACK);
                        b[i][j].setFont(new Font("Dialog", Font.BOLD, fontSize));
                        b[i][j].setText(String.valueOf(Character.toChars(Integer.parseInt(br, 16))));
                        state[i][j] = true;
                    } else if (arr[i][j].equalsIgnoreCase("bh")) {
                        b[i][j].setFont(new Font("Dialog", Font.BOLD, fontSize));
                        b[i][j].setText(String.valueOf(Character.toChars(Integer.parseInt(bh, 16))));
                        state[i][j] = true;
                        b[i][j].setForeground(Color.BLACK);
                    } else if (arr[i][j].equalsIgnoreCase("bn")) {
                        b[i][j].setFont(new Font("Dialog", Font.BOLD, fontSize));
                        b[i][j].setText(String.valueOf(Character.toChars(Integer.parseInt(bn, 16))));
                        state[i][j] = true;
                        b[i][j].setForeground(Color.BLACK);
                    } else if (arr[i][j].equalsIgnoreCase("bq")) {
                        b[i][j].setFont(new Font("Dialog", Font.BOLD, fontSize));
                        b[i][j].setText(String.valueOf(Character.toChars(Integer.parseInt(bq, 16))));
                        state[i][j] = true;
                        b[i][j].setForeground(Color.BLACK);
                    } else if (arr[i][j].equalsIgnoreCase("bk")) {
                        b[i][j].setFont(new Font("Dialog", Font.BOLD, fontSize));
                        b[i][j].setText(String.valueOf(Character.toChars(Integer.parseInt(bk, 16))));
                        state[i][j] = true;
                        b[i][j].setForeground(Color.BLACK);
                    } else if (arr[i][j].equalsIgnoreCase("bp")) {
                        b[i][j].setFont(new Font("Dialog", Font.BOLD, fontSize));
                        b[i][j].setText(String.valueOf(Character.toChars(Integer.parseInt(bp, 16))));
                        if(i == 7){
                            b[i][j].setText(String.valueOf(Character.toChars(Integer.parseInt(bq, 16))));
                            arr[i][j] = "bq";
                        }
                        b[i][j].setForeground(Color.BLACK);
                        state[i][j] = true;
                    } else if (arr[i][j].equalsIgnoreCase("wr")) {
                        b[i][j].setForeground(Color.WHITE);
                        b[i][j].setFont(new Font("Dialog", Font.BOLD, fontSize));
                        b[i][j].setText(String.valueOf(Character.toChars(Integer.parseInt(br, 16))));
                        state[i][j] = true;
                    } else if (arr[i][j].equalsIgnoreCase("wh")) {
                        b[i][j].setForeground(Color.WHITE);
                        b[i][j].setFont(new Font("Dialog", Font.BOLD, fontSize));
                        b[i][j].setText(String.valueOf(Character.toChars(Integer.parseInt(bh, 16))));
                        state[i][j] = true;
                    } else if (arr[i][j].equalsIgnoreCase("wn")) {
                        b[i][j].setForeground(Color.WHITE);
                        b[i][j].setFont(new Font("Dialog", Font.BOLD, fontSize));
                        b[i][j].setText(String.valueOf(Character.toChars(Integer.parseInt(bn, 16))));
                        state[i][j] = true;
                    } else if (arr[i][j].equalsIgnoreCase("wq")) {
                        b[i][j].setForeground(Color.WHITE);
                        b[i][j].setFont(new Font("Dialog", Font.BOLD, fontSize));
                        b[i][j].setText(String.valueOf(Character.toChars(Integer.parseInt(bq, 16))));
                        state[i][j] = true;
                    } else if (arr[i][j].equalsIgnoreCase("wk")) {
                        b[i][j].setForeground(Color.WHITE);
                        b[i][j].setFont(new Font("Dialog", Font.BOLD, fontSize));
                        b[i][j].setText(String.valueOf(Character.toChars(Integer.parseInt(bk, 16))));
                        state[i][j] = true;
                    } else if (arr[i][j].equalsIgnoreCase("wp")) {
                        b[i][j].setForeground(Color.WHITE);
                        b[i][j].setFont(new Font("Dialog", Font.BOLD, fontSize));
                        b[i][j].setText(String.valueOf(Character.toChars(Integer.parseInt(bp, 16))));
                        if(i == 0){
                            b[i][j].setText(String.valueOf(Character.toChars(Integer.parseInt(bq, 16))));
                            arr[i][j] = "wq";
                        }
                        state[i][j] = true;
                    } else {
                        b[i][j].setText("");
                        state[i][j] = false;
                    }
                    if (color_arr[i][j].equalsIgnoreCase("w")) {
                        b[i][j].setBackground(Color.decode(brown));

                    } else {
                        b[i][j].setBackground(Color.decode(white));
                    }
                    state_move[i][j] = true;
                }
            }
        }

    }



    public void queen(int x, int y) {
        boolean faceAlies = false;
        int temp_1 = 0;
        int temp_2 = 0;
        for (int i = 1; i < 8; i++) { //dọc hướng lên trên
            if (x - i < 0) {
                break;
            }
            if (state[x - i][y] == true) {
                char c = arr[x][y].charAt(0);
                char c2 = arr[x - i][y].charAt(0);
                if (c != c2) {
                    b[x - i][y].setBackground(Color.RED);
                    break;
                } else break;
            }

            if (x - i >= 0) {
                b[x - i][y].setBackground(Color.green);

            } else break;
        }

        for (int i = 1; i < 8; i++) {  //dọc xuống dưới
            if (x + i > 7) {
                break;
            }
            if (state[x + i][y] == true) {
                char c = arr[x][y].charAt(0);
                char c2 = arr[x + i][y].charAt(0);
                if (c != c2) {
                    b[x + i][y].setBackground(Color.RED);
                    break;
                } else {
                    break;
                }


            }
            if (x + i < 8) {
                b[x + i][y].setBackground(Color.green);
            } else break;
        }
        for (int i = 1; i < 8; i++) { //ngang sang trái
            if (y - i < 0) {
                break;
            }
            if (state[x][y - i] == true) {
                char c = arr[x][y].charAt(0);
                char c2 = arr[x][y - i].charAt(0);
                if (c != c2) {
                    b[x][y - i].setBackground(Color.RED);
                    break;
                } else break;
            }
            if (y - i >= 0) {
                b[x][y - i].setBackground(Color.green);
            } else break;
        }

        for (int i = 1; i < 8; i++) {// ngang sang phải
            if (y + i > 7) {
                break;
            }
            if (state[x][y + i] == true) {
                char c = arr[x][y].charAt(0);
                char c2 = arr[x][y + i].charAt(0);
                if (c != c2) {
                    b[x][y + i].setBackground(Color.RED);
                    break;
                } else break;
            }
            if (y + i < 8) {
                b[x][y + i].setBackground(Color.green);

            } else break;
        }
        faceAlies = false;
        temp_1 = 0;
        temp_2 = 0;
        for (int i = 1; i < 8; i++) {  //chéo xuống dưới phải
            if (b[temp_1][temp_2].getBackground() == Color.RED || faceAlies == true) {
                break;
            }
            for (int j = 1; j < 8; j++) {

                if (x + i > 7 || y + i > 7) {
                    break;
                }
                if (state[x + i][y + i] == true) {
                    faceAlies = true;
                    char c = arr[x][y].charAt(0);
                    char c2 = arr[x + i][y + i].charAt(0);
                    temp_1 = x + i;
                    temp_2 = y + i;
                    if (c != c2) {
                        b[x + i][y + i].setBackground(Color.RED);
                        break;
                    } else break;
                }
                if (x + i < 8 || y + i < 8) {
                    b[x + i][y + i].setBackground(Color.green);

                } else break;
            }
        }
        faceAlies = false;
        temp_1 = 0;
        temp_2 = 0;
        for (int i = 1; i < 8; i++) {  //chéo lên phải
            if (b[temp_1][temp_2].getBackground() == Color.RED || faceAlies == true) {
                break;
            }
            for (int j = 1; j < 8; j++) {

                if (x - i < 0 || y + i > 7) {
                    break;
                }
                if (state[x - i][y + i] == true) {
                    faceAlies = true;
                    char c = arr[x][y].charAt(0);
                    char c2 = arr[x - i][y + i].charAt(0);
                    temp_1 = x - i;
                    temp_2 = y + i;
                    if (c != c2) {
                        b[x - i][y + i].setBackground(Color.RED);
                        break;
                    }
                    break;


                }
                if (x - i > 0 || y + i < 8) {
                    b[x - i][y + i].setBackground(Color.green);
                } else break;
            }
        }
        faceAlies = false;
        temp_1 = 0;
        temp_2 = 0;
        for (int i = 1; i < 8; i++) {  //chéo lên trên trái
            if (b[temp_1][temp_2].getBackground() == Color.RED || faceAlies == true) {
                break;
            }
            for (int j = 1; j < 8; j++) {
                if (x - i < 0 || y - i < 0) {
                    break;
                }
                if (state[x - i][y - i] == true) {
                    faceAlies = true;
                    char c = arr[x][y].charAt(0);
                    char c2 = arr[x - i][y - i].charAt(0);
                    temp_1 = x - i;
                    temp_2 = y - i;
                    if (c != c2) {
                        b[x - i][y - i].setBackground(Color.RED);
                        break;
                    } else break;
                }
                if (x - i > 0 || y - i > 0) {
                    b[x - i][y - i].setBackground(Color.green);
                } else break;
            }
        }
        faceAlies = false;
        temp_1 = 0;
        temp_2 = 0;
        for (int i = 1; i < 8; i++) {  //chéo xuống trái
            if (b[temp_1][temp_2].getBackground() == Color.RED || faceAlies == true) {
                break;
            }
            for (int j = 1; j < 8; j++) {
                if (x + i > 7 || y - i < 0) {
                    break;
                }
                if (state[x + i][y - i] == true) {
                    faceAlies = true;
                    char c = arr[x][y].charAt(0);
                    char c2 = arr[x + i][y - i].charAt(0);
                    temp_1 = x + i;
                    temp_2 = y - i;
                    if (c != c2) {
                        b[x + i][y - i].setBackground(Color.RED);
                        break;
                    } else break;
                }
                if (x + i < 8 || y - i > 0) {
                    b[x + i][y - i].setBackground(Color.green);

                } else break;
            }
        }


    }

    public void rook(int x, int y) {
        for (int i = 1; i < 8; i++) { //dọc hướng lên trên
            if (x - i < 0) {
                break;
            }
            if (state[x - i][y] == true) {
                char c = arr[x][y].charAt(0);
                char c2 = arr[x - i][y].charAt(0);
                if (c != c2) {
                    b[x - i][y].setBackground(Color.RED);
                    break;
                } else break;
            }

            if (x - i >= 0) {
                b[x - i][y].setBackground(Color.green);
            } else break;
        }

        for (int i = 1; i < 8; i++) {  //dọc xuống dưới
            if (x + i > 7) {
                break;
            }
            if (state[x + i][y] == true) {
                char c = arr[x][y].charAt(0);
                char c2 = arr[x + i][y].charAt(0);
                if (c != c2) {
                    b[x + i][y].setBackground(Color.RED);
                    break;
                } else {
                    break;
                }


            }
            if (x + i < 8) {
                b[x + i][y].setBackground(Color.green);
            } else break;
        }
        for (int i = 1; i < 8; i++) { //ngang sang trái
            if (y - i < 0) {
                break;
            }
            if (state[x][y - i] == true) {
                char c = arr[x][y].charAt(0);
                char c2 = arr[x][y - i].charAt(0);
                if (c != c2) {
                    b[x][y - i].setBackground(Color.RED);
                    break;
                } else break;
            }
            if (y - i >= 0) {
                b[x][y - i].setBackground(Color.green);
            } else break;
        }

        for (int i = 1; i < 8; i++) {// ngang sang phải
            if (y + i > 7) {
                break;
            }
            if (state[x][y + i] == true) {
                char c = arr[x][y].charAt(0);
                char c2 = arr[x][y + i].charAt(0);
                if (c != c2) {
                    b[x][y + i].setBackground(Color.RED);
                    break;
                } else break;
            }
            if (y + i < 8) {
                b[x][y + i].setBackground(Color.green);

            } else break;
        }
    }

    public void bishop(int x, int y) {
        boolean faceAlies = false;
        int temp_1 = 0;
        int temp_2 = 0;
        for (int i = 1; i < 8; i++) {  //chéo xuống dưới phải
            if (b[temp_1][temp_2].getBackground() == Color.RED || faceAlies == true) {
                break;
            }
            for (int j = 1; j < 8; j++) {

                if (x + i > 7 || y + i > 7) {
                    break;
                }
                if (state[x + i][y + i] == true) {
                    faceAlies = true;
                    char c = arr[x][y].charAt(0);
                    char c2 = arr[x + i][y + i].charAt(0);
                    temp_1 = x + i;
                    temp_2 = y + i;
                    if (c != c2) {
                        b[x + i][y + i].setBackground(Color.RED);
                        break;
                    } else break;
                }
                if (x + i < 8 || y + i < 8) {
                    b[x + i][y + i].setBackground(Color.green);

                } else break;
            }
        }
        faceAlies = false;
        temp_1 = 0;
        temp_2 = 0;
        for (int i = 1; i < 8; i++) {  //chéo lên phải
            if (b[temp_1][temp_2].getBackground() == Color.RED || faceAlies == true) {
                break;
            }
            for (int j = 1; j < 8; j++) {

                if (x - i < 0 || y + i > 7) {
                    break;
                }
                if (state[x - i][y + i] == true) {
                    faceAlies = true;
                    char c = arr[x][y].charAt(0);
                    char c2 = arr[x - i][y + i].charAt(0);
                    temp_1 = x - i;
                    temp_2 = y + i;
                    if (c != c2) {
                        b[x - i][y + i].setBackground(Color.RED);
                        break;
                    }
                    break;


                }
                if (x - i > 0 || y + i < 8) {
                    b[x - i][y + i].setBackground(Color.green);
                } else break;
            }
        }
        faceAlies = false;
        temp_1 = 0;
        temp_2 = 0;
        for (int i = 1; i < 8; i++) {  //chéo lên trên trái
            if (b[temp_1][temp_2].getBackground() == Color.RED || faceAlies == true) {
                break;
            }
            for (int j = 1; j < 8; j++) {
                if (x - i < 0 || y - i < 0) {
                    break;
                }
                if (state[x - i][y - i] == true) {
                    faceAlies = true;
                    char c = arr[x][y].charAt(0);
                    char c2 = arr[x - i][y - i].charAt(0);
                    temp_1 = x - i;
                    temp_2 = y - i;
                    if (c != c2) {
                        b[x - i][y - i].setBackground(Color.RED);
                        break;
                    } else break;
                }
                if (x - i > 0 || y - i > 0) {
                    b[x - i][y - i].setBackground(Color.green);
                } else break;
            }
        }
        faceAlies = false;
        temp_1 = 0;
        temp_2 = 0;
        for (int i = 1; i < 8; i++) {  //chéo xuống trái
            if (b[temp_1][temp_2].getBackground() == Color.RED || faceAlies == true) {
                break;
            }
            for (int j = 1; j < 8; j++) {
                if (x + i > 7 || y - i < 0) {
                    break;
                }
                if (state[x + i][y - i] == true) {
                    faceAlies = true;
                    char c = arr[x][y].charAt(0);
                    char c2 = arr[x + i][y - i].charAt(0);
                    temp_1 = x + i;
                    temp_2 = y - i;
                    if (c != c2) {
                        b[x + i][y - i].setBackground(Color.RED);
                        break;
                    } else break;
                }
                if (x + i < 8 || y - i > 0) {
                    b[x + i][y - i].setBackground(Color.green);

                } else break;
            }
        }
    }


    public void pawn(int x, int y) {
        if (arr[x][y] == "bp") {
            if (x + 1 > 7) {

            } else {
                if (x == 1) {
                    if (state[x + 1][y] == true) {

                    } else if (state[x + 2][y] == true) {
                        b[x + 1][y].setBackground(Color.green);
                    } else {
                        b[x + 1][y].setBackground(Color.green);
                        b[x + 2][y].setBackground(Color.green);
                    }
                } else if (x != 1) {
                    if (state[x + 1][y] == true) {
                    } else {
                        b[x + 1][y].setBackground(Color.green);
                    }
                }

                if (y + 1 > 7 || y - 1 < 0) {

                } else {
                    if (state[x + 1][y + 1] == true) {
                        char c = arr[x][y].charAt(0);
                        char c2 = arr[x + 1][y + 1].charAt(0);
                        if (c != c2) {
                            b[x + 1][y + 1].setBackground(Color.RED);
                        }
                    }
                    if(state[x][y + 1] == true && x == 4){
                        char c = arr[x][y].charAt(0);
                        char c2 = arr[x][y + 1].charAt(0);
                        if (c != c2) {
                            b[x][y + 1].setBackground(Color.RED);
                        }
                    }
                    if (state[x + 1][y - 1] == true) {
                        char c = arr[x][y].charAt(0);
                        char c2 = arr[x + 1][y - 1].charAt(0);
                        if (c != c2) {
                            b[x + 1][y - 1].setBackground(Color.RED);
                        }
                    }
                    if(state[x][y - 1] == true && x == 4){
                        char c = arr[x][y].charAt(0);
                        char c2 = arr[x][y - 1].charAt(0);
                        if (c != c2) {
                            b[x][y - 1].setBackground(Color.RED);
                        }
                    }
                }
            }
        } else if (arr[x][y] == "wp") {
            if (x - 1 < 0) {

            } else {
                if (x == 6) {

                    if (state[x - 1][y] == true) {

                    } else if (state[x - 2][y] == true) {
                        b[x - 1][y].setBackground(Color.green);
                    } else {
                        b[x - 1][y].setBackground(Color.green);
                        b[x - 2][y].setBackground(Color.green);
                    }
                } else if (x != 6) {
                    if (state[x - 1][y] == true) {
                    } else {
                        b[x - 1][y].setBackground(Color.green);
                    }
                }

                if (y + 1 > 7 || y - 1 < 0) {

                } else {
                    if (state[x - 1][y + 1] == true) {
                        char c = arr[x][y].charAt(0);
                        char c2 = arr[x - 1][y + 1].charAt(0);
                        if (c != c2) {
                            b[x - 1][y + 1].setBackground(Color.RED);
                        }
                    }
                    if(state[x][y + 1] == true && x == 3){
                        char c = arr[x][y].charAt(0);
                        char c2 = arr[x][y + 1].charAt(0);
                        if (c != c2) {
                            b[x][y + 1].setBackground(Color.RED);
                        }
                    }
                    if(state[x][y - 1] == true && x == 3){
                        char c = arr[x][y].charAt(0);
                        char c2 = arr[x][y - 1].charAt(0);
                        if (c != c2) {
                            b[x][y - 1].setBackground(Color.RED);
                        }
                    }
                    if (state[x - 1][y - 1] == true) {
                        char c = arr[x][y].charAt(0);
                        char c2 = arr[x - 1][y - 1].charAt(0);
                        if (c != c2) {
                            b[x - 1][y - 1].setBackground(Color.RED);
                        }
                    }
                }
            }
        }
    }

    public void king(int x, int y) {
        //chéo lên trái
        if (x - 1 >= 0 && y - 1 >= 0) {
            if (state[x - 1][y - 1] == true) {
                char c = arr[x][y].charAt(0);
                char c2 = arr[x - 1][y - 1].charAt(0);
                if (c != c2) {
                    b[x - 1][y - 1].setBackground(Color.RED);
                }
            } else {
                b[x - 1][y - 1].setBackground(Color.green);
            }
        }
        //chéo lên phải
        if (x - 1 >= 0 && y + 1 < 8) {
            if (state[x - 1][y + 1] == true) {
                char c = arr[x][y].charAt(0);
                char c2 = arr[x - 1][y + 1].charAt(0);
                if (c != c2) {
                    b[x - 1][y + 1].setBackground(Color.RED);
                }
            } else {
                b[x - 1][y + 1].setBackground(Color.green);
            }
        }
        //chéo xuống trái
        if (x + 1 < 8 && y - 1 >= 0) {
            if (state[x + 1][y - 1] == true) {
                char c = arr[x][y].charAt(0);
                char c2 = arr[x + 1][y - 1].charAt(0);
                if (c != c2) {
                    b[x + 1][y - 1].setBackground(Color.RED);
                }
            } else {
                b[x + 1][y - 1].setBackground(Color.green);
            }
        }
        //chéo xuống phải
        if (x + 1 <8  && y + 1 < 8) {
            if (state[x + 1][y + 1] == true) {
                char c = arr[x][y].charAt(0);
                char c2 = arr[x + 1][y + 1].charAt(0);
                if (c != c2) {
                    b[x + 1][y + 1].setBackground(Color.RED);
                }
            } else {
                b[x + 1][y + 1].setBackground(Color.green);
            }
        }
        //tiến lên
        if (x - 1 >= 0) {
            if (state[x - 1][y] == true) {
                char c = arr[x][y].charAt(0);
                char c2 = arr[x - 1][y].charAt(0);
                if (c != c2) {
                    b[x - 1][y].setBackground(Color.RED);
                }
            } else {
                b[x - 1][y].setBackground(Color.green);
            }
        }
        //Lùi lai
        if (x + 1 < 8) {
            if (state[x + 1][y] == true) {
                char c = arr[x][y].charAt(0);
                char c2 = arr[x + 1][y].charAt(0);
                if (c != c2) {
                    b[x + 1][y].setBackground(Color.RED);
                }
            } else {
                b[x + 1][y].setBackground(Color.green);
            }
        }
        //sang trái
        if (y - 1 >= 0) {
            if (state[x][y - 1] == true) {
                char c = arr[x][y].charAt(0);
                char c2 = arr[x][y - 1].charAt(0);
                if (c != c2) {
                    b[x][y - 1].setBackground(Color.RED);
                }
            } else {
                b[x][y - 1].setBackground(Color.green);
            }

        }
        //sang phải
        if (y + 1 < 8) {
            if (state[x][y - 1] == true) {
                char c = arr[x][y].charAt(0);
                char c2 = arr[x][y + 1].charAt(0);
                if (c != c2) {
                    b[x][y + 1].setBackground(Color.RED);
                }
            } else {
                b[x][y + 1].setBackground(Color.green);
            }

        }
    }

    public void horse(int x, int y) {
        if(x-2>=0 && y - 1>=0){
            if (state[x - 2][y - 1] == true) {
                char c = arr[x][y].charAt(0);
                char c2 = arr[x - 2][y - 1].charAt(0);
                if (c != c2) {
                    b[x - 2][y - 1].setBackground(Color.RED);
                }
            } else {
                b[x - 2][y - 1].setBackground(Color.green);
            }
        }
        if(x-2>=0 && y+1<8){
            if (state[x - 2][y + 1] == true) {
                char c = arr[x][y].charAt(0);
                char c2 = arr[x - 2][y + 1].charAt(0);
                if (c != c2) {
                    b[x - 2][y + 1].setBackground(Color.RED);
                }
            } else {
                b[x - 2][y + 1].setBackground(Color.green);
            }
        }
        if(x+2<8 && y - 1>=0){
            if (state[x + 2][y - 1] == true) {
                char c = arr[x][y].charAt(0);
                char c2 = arr[x + 2][y - 1].charAt(0);
                if (c != c2) {
                    b[x + 2][y - 1].setBackground(Color.RED);
                }
            } else {
                b[x + 2][y - 1].setBackground(Color.green);
            }
        }
        if(x+2<8 && y + 1<8){
            if (state[x + 2][y + 1] == true) {
                char c = arr[x][y].charAt(0);
                char c2 = arr[x + 2][y + 1].charAt(0);
                if (c != c2) {
                    b[x + 2][y + 1].setBackground(Color.RED);
                }
            } else {
                b[x + 2][y + 1].setBackground(Color.green);
            }
        }
        if(x-1>=0 && y + 2<8){
            if (state[x - 1][y + 2] == true) {
                char c = arr[x][y].charAt(0);
                char c2 = arr[x - 1][y + 2].charAt(0);
                if (c != c2) {
                    b[x - 1][y + 2].setBackground(Color.RED);
                }
            } else {
                b[x - 1][y + 2].setBackground(Color.green);
            }
        }
        if(x-1>=0 && y - 2>=0){
            if (state[x - 1][y - 2] == true) {
                char c = arr[x][y].charAt(0);
                char c2 = arr[x - 1][y - 2].charAt(0);
                if (c != c2) {
                    b[x - 1][y - 2].setBackground(Color.RED);
                }
            } else {
                b[x - 1][y - 2].setBackground(Color.green);
            }
        }
        if(x+1<8 && y - 2>=0){
            if (state[x + 1][y - 2] == true) {
                char c = arr[x][y].charAt(0);
                char c2 = arr[x + 1][y - 2].charAt(0);
                if (c != c2) {
                    b[x + 1][y - 2].setBackground(Color.RED);
                }
            } else {
                b[x +1][y - 2].setBackground(Color.green);
            }
        }
        if(x+1<8 && y +2 < 8){
            if (state[x + 1][y + 2] == true) {
                char c = arr[x][y].charAt(0);
                char c2 = arr[x + 1][y + 2].charAt(0);
                if (c != c2) {
                    b[x + 1][y + 2].setBackground(Color.RED);
                }
            } else {
                b[x + 1][y + 2].setBackground(Color.green);
            }
        }
    }
}

