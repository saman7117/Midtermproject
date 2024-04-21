package playerslot;

import cardcoin.*;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

import static javax.swing.JOptionPane.showMessageDialog;

public class Player {
    public static Font playerspec = new Font("varsity_regular" , Font.BOLD , 14);
    public int point;
    public int[] coincount;
    public int[] specialcoincount;
    public int[] ReserveCards;
    public int currentReserve;



    public Player() {
        ReserveCards = new int[3];
        Arrays.fill(ReserveCards , -10);
        point = 0;
        coincount = new int[5]; //  0 = green     1 = red    2 = blue    3 = black     4 = white
        specialcoincount = new int[6]; //  0 = green     1 = red    2 = blue    3 = black     4 = white   5 = Gold
        for (int i = 0; i < 5 ;i ++) {
            coincount[i] = 00;
            specialcoincount[i] = 0;
        }
    }

    public static void setplayertext(JLabel P1label , Player p1 , int playerNum) {
        P1label.setFont(playerspec);
        if (playerNum == 1) {
            P1label.setText("<html>Player1 :                 point : " + p1.point + "<br>" +
                    " green coins = " + p1.coincount[0] +
                    " red coins = " + p1.coincount[1] +
                    " blue coins = " + p1.coincount[2] +
                    " black coins = " + p1.coincount[3] +
                    " white coins = " + p1.coincount[4] + "<br>" + "special coins :<br>" +
                    " green coins = " + p1.specialcoincount[0] +
                    " red coins = " + p1.specialcoincount[1] +
                    " blue coins = " + p1.specialcoincount[2] +
                    " black coins = " + p1.specialcoincount[3] +
                    " white coins = " + p1.specialcoincount[4] +
                    "Gold coins =" + p1.specialcoincount[5] + "</html>");
        } else if (playerNum == 2) {
            P1label.setText("<html>Player2 :                 point : " + p1.point + "<br>" +
                    " green coins = " + p1.coincount[0] +
                    " red coins = " + p1.coincount[1] +
                    " blue coins = " + p1.coincount[2] +
                    " black coins = " + p1.coincount[3] +
                    " white coins = " + p1.coincount[4] + "<br>" + "special coins :<br>" +
                    " green coins = " + p1.specialcoincount[0] +
                    " red coins = " + p1.specialcoincount[1] +
                    " blue coins = " + p1.specialcoincount[2] +
                    " black coins = " + p1.specialcoincount[3] +
                    " white coins = " + p1.specialcoincount[4] +
                    "Gold coins =" + p1.specialcoincount[5] + "</html>");
        }
    }

    public int checkReserve(){
        for (int i = 0; i < ReserveCards.length; i++) {
            if (ReserveCards[i] == -10){
                return i;
            }
        }
        return -1;
    }

    public static void ShowTurn(boolean turn[] , JLabel current){
        if (turn[0]){
            current.setText("Turn : Player 1");
        }
        else {
            current.setText("Turn : Player 2");
        }
    }

    public static void checkwinner (Player p1 , Player p2 , JFrame frame){
        if (p1.point == 15){
            frame.setVisible(false);
            showMessageDialog(null , "Player 1 is the winner !");
        }
        if (p2.point == 15){
            frame.setVisible(false);
            showMessageDialog(null , "Player 2 is the winner !");
        }
    }

}
