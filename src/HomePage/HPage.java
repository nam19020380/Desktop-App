package Hpage;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.ImageGraphicAttribute;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.border.LineBorder;
import javax.swing.GroupLayout.Alignment;

public class HPage extends JFrame   {

    private JLabel Label1;
    private JTextField textField1;
    String [] game = {"Tân Long", "Nam", "Duy"};
    private JTextField table_number_0;
    private JTextField player_name_1_table_1;
    private JTextField player_name_2_table_1;
    private JTextField table_number_1;
    private JTextField player_name_1_table_2;
    private JTextField player_name_2_table_2;
    private JTextField table_number_2;
    private JTextField player_name_1_table_3;
    private JTextField player_name_2_table_3;
    private JTextField table_number_3;
    private JTextField player_name_1_table_4;
    private JTextField player_name_2_table_4;
    private JTextField table_number_4;
    private JTextField player_name_1_table_5;
    private JTextField player_name_2_table_5;
    private JTextField table_number_5;
    private JTextField player_name_1_table_6;
    private JTextField player_name_2_table_6;

    public HPage(){
        setTitle("HomePage");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(850,600);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        getContentPane().setLayout(null);

        JPanel userIn4Panel = new JPanel();
        userIn4Panel.setBackground(Color.PINK);
        userIn4Panel.setBounds(0, 0, 174, 563);
        getContentPane().add(userIn4Panel);
        userIn4Panel.setLayout(null);

        JButton changePasswordButton = new JButton("Đổi mật khẩu");
        changePasswordButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        changePasswordButton.setFont(new Font("Segoe UI Variable", Font.BOLD, 13));
        changePasswordButton.setBounds(10, 457, 144, 35);
        userIn4Panel.add(changePasswordButton);

        JButton logOutButton = new JButton("Đăng xuất");
        logOutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        logOutButton.setFont(new Font("Segoe UI Variable", Font.BOLD, 13));
        logOutButton.setBounds(10, 502, 144, 35);
        userIn4Panel.add(logOutButton);

        JLabel userName = new JLabel("Tân Long");
        userName.setFont(new Font("Segoe UI Emoji", Font.BOLD, 16));
        userName.setHorizontalAlignment(SwingConstants.CENTER);
        userName.setBounds(10, 157, 144, 41);
        userIn4Panel.add(userName);

        JLabel avatar_user = new JLabel("Avatar");
        avatar_user.setBorder(new LineBorder(Color.LIGHT_GRAY, 4));
        BufferedImage avt = null;
        try {
            avt = ImageIO.read(new File("img/avt.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Image avt_img = avt.getScaledInstance(132,135,Image.SCALE_SMOOTH);
        ImageIcon avt_icon = new ImageIcon(avt_img);
        avatar_user.setIcon(avt_icon);
        avatar_user.setOpaque(true);
        avatar_user.setBounds(22, 20, 132, 135);
        userIn4Panel.add(avatar_user);


        JPanel TableGamePanel = new JPanel();
        TableGamePanel.setBackground(Color.ORANGE);
        TableGamePanel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        TableGamePanel.setBounds(175, 0, 458, 563);
        getContentPane().add(TableGamePanel);
        TableGamePanel.setLayout(null);

//        JLabel floor_color = new JLabel("Floor_Color");
//        floor_color.setBounds(0, 0, 458, 563);
//        TableGamePanel.add(floor_color);
//        BufferedImage TableGamePanel_img = null;
//        try {
//            TableGamePanel_img = ImageIO.read(new File("img/sannha.jpg"));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        Image TableGamePanel_dimg = TableGamePanel_img.getScaledInstance(458,563,Image.SCALE_SMOOTH);
//        ImageIcon Table_Game_Icon = new ImageIcon(TableGamePanel_dimg);
//        floor_color.setIcon(Table_Game_Icon);


        JPanel table_1_0 = new JPanel();
        table_1_0.setBorder(new LineBorder(Color.DARK_GRAY, 3));
        table_1_0.setBounds(0, 0, 233, 200);
        table_1_0.setBackground(Color.ORANGE);
        TableGamePanel.add(table_1_0);
        table_1_0.setLayout(null);

        table_number_0 = new JTextField();
        table_number_0.setBorder(null);
        table_number_0.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
        table_number_0.setHorizontalAlignment(SwingConstants.CENTER);
        table_number_0.setText("Table 1");
        table_number_0.setOpaque(false);
        table_number_0.setBounds(55, 158, 96, 19);
        table_1_0.add(table_number_0);
        table_number_0.setColumns(10);

        JLabel img_chess_0 = new JLabel("img_table");
        img_chess_0.setBounds(67, 52, 84, 70);
        table_1_0.add(img_chess_0);
        BufferedImage read_img_table_0 = null;
        try {
            read_img_table_0 = ImageIO.read(new File("img/banco.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Image img_table_0 = read_img_table_0.getScaledInstance(84,70,Image.SCALE_SMOOTH);
        ImageIcon icon_table_0 = new ImageIcon(img_table_0);
        img_chess_0.setIcon(icon_table_0);
        img_chess_0.setBackground(Color.GREEN);
        img_chess_0.setOpaque(true);

        player_name_1_table_1 = new JTextField();
        player_name_1_table_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 13));
        player_name_1_table_1.setBackground(Color.ORANGE);
        player_name_1_table_1.setBorder(null);
        player_name_1_table_1.setText("player 1");
        player_name_1_table_1.setBounds(10, 103, 49, 19);
        table_1_0.add(player_name_1_table_1);
        player_name_1_table_1.setColumns(10);

        player_name_2_table_1 = new JTextField();
        player_name_2_table_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 13));
        player_name_2_table_1.setBackground(Color.ORANGE);
        player_name_2_table_1.setBorder(null);
        player_name_2_table_1.setText("player 2");
        player_name_2_table_1.setColumns(10);
        player_name_2_table_1.setBounds(157, 103, 60, 19);
        table_1_0.add(player_name_2_table_1);

        JPanel table_1_1 = new JPanel();
        table_1_1.setBorder(new LineBorder(Color.DARK_GRAY, 3));
        table_1_1.setBounds(231, 0, 227, 200);
        table_1_1.setBackground(Color.ORANGE);
        table_1_1.setLayout(null);
        TableGamePanel.add(table_1_1);

        table_number_1 = new JTextField();
        table_number_1.setBorder(null);
        table_number_1.setText("Table 2");
        table_number_1.setOpaque(false);
        table_number_1.setHorizontalAlignment(SwingConstants.CENTER);
        table_number_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
        table_number_1.setColumns(10);
        table_number_1.setBounds(55, 159, 96, 19);
        table_1_1.add(table_number_1);

        JLabel img_chess_1 = new JLabel("img_table");
        img_chess_1.setOpaque(true);
        img_chess_1.setIcon(icon_table_0);
        img_chess_1.setBackground(Color.GREEN);
        img_chess_1.setBounds(67, 49, 84, 70);
        table_1_1.add(img_chess_1);

        player_name_1_table_2 = new JTextField();
        player_name_1_table_2.setFont(new Font("Segoe UI Variable", Font.BOLD, 13));
        player_name_1_table_2.setBackground(Color.ORANGE);
        player_name_1_table_2.setBorder(null);
        player_name_1_table_2.setText("player 1");
        player_name_1_table_2.setColumns(10);
        player_name_1_table_2.setBounds(10, 100, 50, 19);
        table_1_1.add(player_name_1_table_2);

        player_name_2_table_2 = new JTextField();
        player_name_2_table_2.setFont(new Font("Segoe UI Variable", Font.BOLD, 13));
        player_name_2_table_2.setBackground(Color.ORANGE);
        player_name_2_table_2.setBorder(null);
        player_name_2_table_2.setText("player 2");
        player_name_2_table_2.setColumns(10);
        player_name_2_table_2.setBounds(157, 100, 50, 19);
        table_1_1.add(player_name_2_table_2);

        JPanel table_1_2 = new JPanel();
        table_1_2.setBorder(new LineBorder(Color.DARK_GRAY, 3));
        table_1_2.setBounds(0, 194, 233, 194);
        table_1_2.setBackground(Color.ORANGE);
        table_1_2.setLayout(null);
        TableGamePanel.add(table_1_2);

        table_number_2 = new JTextField();
        table_number_2.setBorder(null);
        table_number_2.setText("Table 3");
        table_number_2.setOpaque(false);
        table_number_2.setHorizontalAlignment(SwingConstants.CENTER);
        table_number_2.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
        table_number_2.setColumns(10);
        table_number_2.setBounds(55, 133, 96, 19);
        table_1_2.add(table_number_2);

        JLabel img_chess_2 = new JLabel("img_table");
        img_chess_2.setOpaque(true);
        img_chess_2.setIcon(icon_table_0);
        img_chess_2.setBackground(Color.GREEN);
        img_chess_2.setBounds(67, 42, 84, 70);
        table_1_2.add(img_chess_2);

        player_name_1_table_3 = new JTextField();
        player_name_1_table_3.setFont(new Font("Segoe UI Variable", Font.BOLD, 13));
        player_name_1_table_3.setBackground(Color.ORANGE);
        player_name_1_table_3.setBorder(null);
        player_name_1_table_3.setText("player 1");
        player_name_1_table_3.setColumns(10);
        player_name_1_table_3.setBounds(10, 93, 47, 19);
        table_1_2.add(player_name_1_table_3);

        player_name_2_table_3 = new JTextField();
        player_name_2_table_3.setFont(new Font("Segoe UI Variable", Font.BOLD, 13));
        player_name_2_table_3.setBackground(Color.ORANGE);
        player_name_2_table_3.setBorder(null);
        player_name_2_table_3.setText("player 2");
        player_name_2_table_3.setColumns(10);
        player_name_2_table_3.setBounds(157, 93, 60, 19);
        table_1_2.add(player_name_2_table_3);

        JPanel table_1_3 = new JPanel();
        table_1_3.setBorder(new LineBorder(Color.DARK_GRAY, 3));
        table_1_3.setBounds(231, 194, 227, 194);
        table_1_3.setBackground(Color.ORANGE);
        table_1_3.setLayout(null);
        TableGamePanel.add(table_1_3);

        table_number_3 = new JTextField();
        table_number_3.setBorder(null);
        table_number_3.setText("Table 4");
        table_number_3.setOpaque(false);
        table_number_3.setHorizontalAlignment(SwingConstants.CENTER);
        table_number_3.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
        table_number_3.setColumns(10);
        table_number_3.setBounds(55, 135, 96, 19);
        table_1_3.add(table_number_3);

        JLabel img_chess_3 = new JLabel("img_table");
        img_chess_3.setOpaque(true);
        img_chess_3.setIcon(icon_table_0);
        img_chess_3.setBackground(Color.GREEN);
        img_chess_3.setBounds(67, 44, 84, 70);
        table_1_3.add(img_chess_3);

        player_name_1_table_4 = new JTextField();
        player_name_1_table_4.setFont(new Font("Segoe UI Variable", Font.BOLD, 13));
        player_name_1_table_4.setBackground(Color.ORANGE);
        player_name_1_table_4.setBorder(null);
        player_name_1_table_4.setText("player 1");
        player_name_1_table_4.setColumns(10);
        player_name_1_table_4.setBounds(10, 95, 51, 19);
        table_1_3.add(player_name_1_table_4);

        player_name_2_table_4 = new JTextField();
        player_name_2_table_4.setFont(new Font("Segoe UI Variable", Font.BOLD, 13));
        player_name_2_table_4.setBackground(Color.ORANGE);
        player_name_2_table_4.setBorder(null);
        player_name_2_table_4.setText("player 2");
        player_name_2_table_4.setColumns(10);
        player_name_2_table_4.setBounds(157, 95, 60, 19);
        table_1_3.add(player_name_2_table_4);

        JPanel table_1_4 = new JPanel();
        table_1_4.setBorder(new LineBorder(new Color(64, 64, 64), 3));
        table_1_4.setBounds(0, 387, 233, 176);
        table_1_4.setBackground(Color.ORANGE);
        table_1_4.setLayout(null);
        TableGamePanel.add(table_1_4);

        table_number_4 = new JTextField();
        table_number_4.setBorder(null);
        table_number_4.setText("Table 5");
        table_number_4.setOpaque(false);
        table_number_4.setHorizontalAlignment(SwingConstants.CENTER);
        table_number_4.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
        table_number_4.setColumns(10);
        table_number_4.setBounds(55, 119, 96, 19);
        table_1_4.add(table_number_4);

        JLabel img_chess_4 = new JLabel("img_table");
        img_chess_4.setOpaque(true);
        img_chess_4.setIcon(icon_table_0);
        img_chess_4.setBackground(Color.GREEN);
        img_chess_4.setBounds(67, 39, 84, 70);
        table_1_4.add(img_chess_4);

        player_name_1_table_5 = new JTextField();
        player_name_1_table_5.setFont(new Font("Segoe UI Variable", Font.BOLD, 13));
        player_name_1_table_5.setBackground(Color.ORANGE);
        player_name_1_table_5.setBorder(null);
        player_name_1_table_5.setText("player 1");
        player_name_1_table_5.setColumns(10);
        player_name_1_table_5.setBounds(10, 90, 52, 19);
        table_1_4.add(player_name_1_table_5);

        player_name_2_table_5 = new JTextField();
        player_name_2_table_5.setFont(new Font("Segoe UI Variable", Font.BOLD, 13));
        player_name_2_table_5.setBackground(Color.ORANGE);
        player_name_2_table_5.setBorder(null);
        player_name_2_table_5.setText("player 2");
        player_name_2_table_5.setColumns(10);
        player_name_2_table_5.setBounds(157, 90, 60, 19);
        table_1_4.add(player_name_2_table_5);

        JPanel table_1_5 = new JPanel();
        table_1_5.setBorder(new LineBorder(Color.DARK_GRAY, 3));
        table_1_5.setBounds(231, 387, 227, 176);
        table_1_5.setBackground(Color.ORANGE);
        table_1_5.setLayout(null);
        TableGamePanel.add(table_1_5);

        table_number_5 = new JTextField();
        table_number_5.setBorder(null);
        table_number_5.setText("Table 6");
        table_number_5.setOpaque(false);
        table_number_5.setHorizontalAlignment(SwingConstants.CENTER);
        table_number_5.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
        table_number_5.setColumns(10);
        table_number_5.setBounds(55, 121, 96, 19);
        table_1_5.add(table_number_5);

        JLabel img_chess_5 = new JLabel("img_table");
        img_chess_5.setOpaque(true);

        img_chess_5.setIcon(icon_table_0);
        img_chess_5.setBackground(Color.GREEN);
        img_chess_5.setBounds(67, 41, 84, 70);
        table_1_5.add(img_chess_5);

        player_name_1_table_6 = new JTextField();
        player_name_1_table_6.setFont(new Font("Segoe UI Variable", Font.BOLD, 13));
        player_name_1_table_6.setBackground(Color.ORANGE);
        player_name_1_table_6.setBorder(null);
        player_name_1_table_6.setText("player 1");
        player_name_1_table_6.setColumns(10);
        player_name_1_table_6.setBounds(10, 92, 47, 19);
        table_1_5.add(player_name_1_table_6);

        player_name_2_table_6 = new JTextField();
        player_name_2_table_6.setFont(new Font("Segoe UI Variable", Font.BOLD, 13));
        player_name_2_table_6.setBackground(Color.ORANGE);
        player_name_2_table_6.setBorder(null);
        player_name_2_table_6.setText("player 2");
        player_name_2_table_6.setColumns(10);
        player_name_2_table_6.setBounds(157, 92, 60, 19);
        table_1_5.add(player_name_2_table_6);












        JPanel userFriend = new JPanel();
        userFriend.setBounds(634, 0, 202, 563);
        getContentPane().add(userFriend);
        userFriend.setBackground(Color.PINK);
        userFriend.setLayout(null);

        JComboBox gameSelectBox = new JComboBox(game);
        gameSelectBox.setBounds(0, 0, 202, 32);
        userFriend.add(gameSelectBox);
        gameSelectBox.setFont(new Font("Segoe UI Variable", Font.BOLD, 19));



        //Co vua
        JButton chessButton = new JButton("Cờ Vua");
        chessButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("img/GameChess.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimg = img.getScaledInstance(202,171,Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);
        chessButton.setIcon(imageIcon);
        chessButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        chessButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        chessButton.setBounds(0, 30, 202, 171);
        userFriend.add(chessButton);


        //Caro
        JButton caroButton = new JButton("Caro");
        caroButton.setBounds(0, 200, 202, 176);
        BufferedImage img_caro = null;
        try {
            img_caro = ImageIO.read(new File("img/caroimg.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Image dimg_caro = img_caro.getScaledInstance(202,176,Image.SCALE_SMOOTH);
        caroButton.setIcon(new ImageIcon(dimg_caro));
        userFriend.add(caroButton);
        caroButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
        caroButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


        //O an quan
        JButton OAnQuanButton = new JButton("Ô ăn quan");
        OAnQuanButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        OAnQuanButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        OAnQuanButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
        OAnQuanButton.setBounds(0, 373, 202, 190);
        BufferedImage img_an_quan = null;
        try {
            img_an_quan = ImageIO.read(new File("img/oanquan.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Image dimg_an_quan = img_an_quan.getScaledInstance(202,190,Image.SCALE_SMOOTH);
        OAnQuanButton.setIcon(new ImageIcon(dimg_an_quan));
        userFriend.add(OAnQuanButton);



    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new HPage();
            }
        });


    }
}
