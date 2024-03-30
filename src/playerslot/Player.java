package playerslot;

import cardcoin.*;

import javax.swing.*;
import java.awt.*;

public class Player {
    public static Font playerspec = new Font("varsity_regular" , Font.BOLD , 14);
    public int point;
    public int[] coincount;
    public int[] specialcoincount;
    Card [] cards;


    public Player() {
        point = 0;
        coincount = new int[5]; //  0 = green     1 = red    2 = blue    3 = black     4 = white
        specialcoincount = new int[5]; //  0 = green     1 = red    2 = blue    3 = black     4 = white
        for (int i = 0; i < 5 ;i ++) {
            coincount[i] = 0;
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
                    " white coins = " + p1.specialcoincount[4] + "</html>");
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
                    " white coins = " + p1.specialcoincount[4] + "</html>");
        }
    }

}
