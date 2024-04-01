package cardcoin;
import playerslot.Player;
import playerslot.SlotMachine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import static javax.swing.JOptionPane.showMessageDialog;
import static playerslot.Player.playerspec;
import static playerslot.Player.setplayertext;

public class Card {
    public int[] price;
    public static boolean [][] visitlabel;
    public static int [][] currentcards;
    public String [] colors;

    public int level;
    public Coin coin = new Coin();
    private int point;

    final static ImageIcon cardlevel1 = new ImageIcon("ferris wheel 1.png");
    final static ImageIcon cardlevel2 = new ImageIcon("carnival tent 1.png");
    final static ImageIcon cardlevel3 = new ImageIcon("baloon-removebg-preview.png");
    final static ImageIcon cardprize = new ImageIcon("prize claw 1.png");
    static JLabel claw1;
    static JLabel claw2;
    static JLabel claw3;
    static JLabel lev1card1;
    static JLabel lev1card2;
    static JLabel lev1card3;
    static JLabel lev1card4;

    static JLabel lev2card1;
    static JLabel lev2card2;
    static JLabel lev2card3;
    static JLabel lev2card4;

    static JLabel lev3card1;
    static JLabel lev3card2;
    static JLabel lev3card3;
    static JLabel lev3card4;

    static JButton clawbutton1 = new JButton("Buy");
    static JButton clawbutton2 = new JButton("Buy");
    static JButton clawbutton3 = new JButton("Buy");

    static JButton lev1button1 = new JButton("Buy");
    static JButton lev1button2 = new JButton("Buy");
    static JButton lev1button3 = new JButton("Buy");
    static JButton lev1button4 = new JButton("Buy");

    static JButton lev2button1 = new JButton("Buy");
    static JButton lev2button2 = new JButton("Buy");
    static JButton lev2button3 = new JButton("Buy");
    static JButton lev2button4 = new JButton("Buy");

    static JButton lev3button1 = new JButton("Buy");
    static JButton lev3button2 = new JButton("Buy");
    static JButton lev3button3 = new JButton("Buy");
    static JButton lev3button4 = new JButton("Buy");

    static JButton clawRes1 = new JButton("Reserve");
    static JButton clawRes2 = new JButton("Reserve");
    static JButton clawRes3 = new JButton("Reserve");

    static JButton lev1Res1 = new JButton("Reserve");
    static JButton lev1Res2 = new JButton("Reserve");
    static JButton lev1Res3 = new JButton("Reserve");
    static JButton lev1Res4 = new JButton("Reserve");

    static JButton lev2Res1 = new JButton("Reserve");
    static JButton lev2Res2 = new JButton("Reserve");
    static JButton lev2Res3 = new JButton("Reserve");
    static JButton lev2Res4 = new JButton("Reserve");

    static JButton lev3Res1 = new JButton("Reserve");
    static JButton lev3Res2 = new JButton("Reserve");
    static JButton lev3Res3 = new JButton("Reserve");
    static JButton lev3Res4 = new JButton("Reserve");





    public Card(int level) {

        price = new int[5]; //  0 = green     1 = red    2 = blue    3 = black     4 = white
        for (int i = 0; i < price.length; i++) {
            price[i] = 0;
        }
        colors = new String[3];
        visitlabel = new boolean[4][4];
        currentcards = new int[4][4];
        int min;
        int max;
        int range;
        int rand;
        int sum;
        Random random = new Random();
        Random house = new Random();
        this.level = level;
        if (level == 1) {
            rand = random.nextInt(2);
            setPoint(rand);
                int numbers[];
                numbers = new int[2];
                int houses[] = new int[2];
            min = 1;
            max = 3;
            range = max - min + 1;
                numbers[0] = (int) (Math.random() * range) + min;
                if (numbers[0] == 1)
                numbers[1] = 3;
                else{
                    min = 2;
                    max = 3;
                    range = max - min + 1;
                    numbers[1] = (int) (Math.random() * range) + min;
                }

                houses[0] = house.nextInt(4);

                if (houses[0] == 0){
                    this.colors[0] = "green";}
                else if (houses[0] == 1) {
                    this.colors[0] = "red";
                } else if (houses[0] == 2) {
                    this.colors[0] = "blue";
                } else if (houses[0] == 3) {
                    this.colors[0] = "black";
                } else if (houses[0] == 4) {
                    this.colors[0] = "white";
                }
            for (int i = 1; i < 2; i++) {

                houses[i] = house.nextInt(5);
                if (houses[i] <= houses[0]){
                    i--;
                    continue;
                }

                if (houses[i] == 0) {
                    this.colors[i] = "green";
                } else if (houses[i] == 1) {
                    this.colors[i] = "red";
                } else if (houses[i] == 2) {
                    this.colors[i] = "blue";
                } else if (houses[i] == 3) {
                    this.colors[i] = "black";
                } else if (houses[i] == 4) {
                    this.colors[i] = "white";
                }
            }

            this.price[houses[0]] = numbers[0];
            this.price[houses[1]] = numbers[1];

        } else if (level == 2) {
            min = 2;
            max = 4;
            range = max - min + 1;
            rand = (int) (Math.random() * range) + min;
            setPoint(rand);
            int numbers[];
            numbers = new int[2];
            int houses[] = new int[2];
            min = 3;
            max = 4;
            range = max - min + 1;
            numbers[0] = (int) (Math.random() * range) + min;

                min = 3;
                max = 4;
                range = max - min + 1;
                numbers[1] = (int) (Math.random() * range) + min;

            houses[0] = house.nextInt(4);

            if (houses[0] == 0){
                this.colors[0] = "green";}
            else if (houses[0] == 1) {
                this.colors[0] = "red";
            } else if (houses[0] == 2) {
                this.colors[0] = "blue";
            } else if (houses[0] == 3) {
                this.colors[0] = "black";
            } else if (houses[0] == 4) {
                this.colors[0] = "white";
            }
            for (int i = 1; i < 2; i++) {

                houses[i] = house.nextInt(5);
                if (houses[i] <= houses[0]){
                    i--;
                    continue;
                }

                if (houses[i] == 0) {
                    this.colors[i] = "green";
                } else if (houses[i] == 1) {
                    this.colors[i] = "red";
                } else if (houses[i] == 2) {
                    this.colors[i] = "blue";
                } else if (houses[i] == 3) {
                    this.colors[i] = "black";
                } else if (houses[i] == 4) {
                    this.colors[i] = "white";
                }
            }
            this.price[houses[0]] = numbers[0];
            this.price[houses[1]] = numbers[1];

        } else if (level == 3) {
            min = 3;
            max = 5;
            range = max - min + 1;
            rand = (int) (Math.random() * range) + min;
            setPoint(rand);
            int numbers[];
            numbers = new int[3];
            int houses[] = new int[3];
            min = 1;
            max = 2;
            range = max - min + 1;
            numbers[0] = (int) (Math.random() * range) + min;

                min = 2;
                max = 3;
                range = max - min + 1;
                numbers[1] = (int) (Math.random() * range) + min;

            min = 3;
            max = 5;
            range = max - min + 1;
            numbers[2] = (int) (Math.random() * range) + min;

            houses[0] = house.nextInt(3);

            if (houses[0] == 0){
                this.colors[0] = "green";}
            else if (houses[0] == 1) {
                this.colors[0] = "red";
            } else if (houses[0] == 2) {
                this.colors[0] = "blue";
            }
            for (int i = 1; i < 2; i++) {

                houses[i] = house.nextInt(4);
                if (houses[i] <= houses[0]){
                    i--;
                    continue;
                }

                if (houses[i] == 0) {
                    this.colors[i] = "green";
                } else if (houses[i] == 1) {
                    this.colors[i] = "red";
                } else if (houses[i] == 2) {
                    this.colors[i] = "blue";
                } else if (houses[i] == 3) {
                    this.colors[i] = "black";
                }
            }

            for (int i = 2; i < 3; i++) {

                houses[i] = house.nextInt(5);
                if (houses[i] <= houses[0] || houses[i] <= houses[1]){
                    i--;
                    continue;
                }

                if (houses[i] == 0) {
                    this.colors[i] = "green";
                } else if (houses[i] == 1) {
                    this.colors[i] = "red";
                } else if (houses[i] == 2) {
                    this.colors[i] = "blue";
                } else if (houses[i] == 3) {
                    this.colors[i] = "black";
                }else if (houses[i] == 3) {
                    this.colors[i] = "black";
                } else if (houses[i] == 4) {
                    this.colors[i] = "white";
                }
            }

            this.price[houses[0]] = numbers[0];
            this.price[houses[1]] = numbers[1];
            this.price[houses[2]] = numbers[2];

        } else if (level == 0) {
            min = 3;
            max = 4;
            range = max - min + 1;
            rand = (int) (Math.random() * range) + min;
            setPoint(rand);

            int numbers[];
            numbers = new int[2];
            int houses[] = new int[2];
            min = 4;
            max = 6;
            range = max - min + 1;
            numbers[0] = (int) (Math.random() * range) + min;

            numbers[1] = (int) (Math.random() * range) + min;

            houses[0] = house.nextInt(4);

            if (houses[0] == 0){
                this.colors[0] = "green";}
            else if (houses[0] == 1) {
                this.colors[0] = "red";
            } else if (houses[0] == 2) {
                this.colors[0] = "blue";
            } else if (houses[0] == 3) {
                this.colors[0] = "black";
            } else if (houses[0] == 4) {
                this.colors[0] = "white";
            }
            for (int i = 1; i < 2; i++) {

                houses[i] = house.nextInt(5);
                if (houses[i] <= houses[0]){
                    i--;
                    continue;
                }

                if (houses[i] == 0) {
                    this.colors[i] = "green";
                } else if (houses[i] == 1) {
                    this.colors[i] = "red";
                } else if (houses[i] == 2) {
                    this.colors[i] = "blue";
                } else if (houses[i] == 3) {
                    this.colors[i] = "black";
                } else if (houses[i] == 4) {
                    this.colors[i] = "white";
                }
            }
            this.price[houses[0]] = numbers[0];
            this.price[houses[1]] = numbers[1];

        }
    }




    public void setPoint(int point) {
        if (point < 0)
            System.out.println("Invalid");
        else
            this.point = point;
    }

    public int getPoint() {
        return point;
    }

    public void setCardlevel0ocation(int index, int point , String color1 , String color2 , int price1 , int price2) {
        if (!visitlabel[0][index]) {
            JLabel currentLabel = null;
            switch (index) {
                case 0:
                    currentLabel = claw1;
                    break;
                case 1:
                    currentLabel = claw2;
                    break;
                case 2:
                    currentLabel = claw3;
                    break;
            }

            if (currentLabel != null) {
                currentLabel.setText("<html>" + point + "<br>" + color1 + " = " + price1 + "             " + color2 + " = " + price2 + "</html>");
                currentLabel.setHorizontalTextPosition(SwingConstants.CENTER);
                currentLabel.setVerticalTextPosition(SwingConstants.TOP);
                currentLabel.setForeground(Color.black);
                currentLabel.setFont(new Font("tahome", Font.PLAIN, 14));
                currentLabel.setIconTextGap(5);
                currentcards [0][index] = index;
                visitlabel[0][index] = true;
            }
        }
    }
    public void setCardlevel1Location(int index , int point, String color, String color1, String color2, int price1, int price2) {
            if (!visitlabel[1][index]) {
                JLabel currentLabel = null;
                switch (index) {
                    case 0:
                        currentLabel = lev1card1;
                        visitlabel[1][index] = true;
                        break;
                    case 1:
                        currentLabel = lev1card2;
                        visitlabel[1][index] = true;
                        break;
                    case 2:
                        currentLabel = lev1card3;
                        visitlabel[1][index] = true;
                        break;
                    case 3:
                        currentLabel = lev1card4;
                        visitlabel[1][index] = true;
                        break;
                }


                if (currentLabel != null) {
                set1and2cardText(point , color , color1 , price1 , color2 , price2 , currentLabel);
                    currentcards [1][index] = index;
                    visitlabel[1][index] = true;

                }
            }
        }


    public void setCardlevel2Location(int index, int point, String color , String color1 , String color2 , int price1 , int price2) {
        if (!visitlabel[2][index]) {
            JLabel currentLabel = null;
            switch (index) {
                case 0:
                    currentLabel = lev2card1;
                    break;
                case 1:
                    currentLabel = lev2card2;
                    break;
                case 2:
                    currentLabel = lev2card3;
                    break;
                case 3:
                    currentLabel = lev2card4;
                    break;
            }

            if (currentLabel != null) {
                set1and2cardText(point , color , color1 , price1 , color2 , price2 , currentLabel);
                currentcards [2][index] = index;
                visitlabel[2][index] = true;
            }
        }
    }

    public void setCardlevel3Location(int index , int point, String color , String color1 , String color2 , String color3, int price1 , int price2 , int price3) {

            if (!visitlabel[3][index]) {
                JLabel currentLabel = null;
                switch (index) {
                    case 0:
                        currentLabel = lev3card1;
                        break;
                    case 1:
                        currentLabel = lev3card2;
                        break;
                    case 2:
                        currentLabel = lev3card3;
                        break;
                    case 3:
                        currentLabel = lev3card4;
                        break;
                }

                if (currentLabel != null) {
                    currentLabel.setText("<html>" + point + "  " + color + "<br>" + color1 + " = " + price1 + "    " + color2 + " = " + price2 + color3 + " = " + price3 + "</html>");
                    currentLabel.setHorizontalTextPosition(SwingConstants.CENTER);
                    currentLabel.setVerticalTextPosition(SwingConstants.TOP);
                    currentLabel.setForeground(Color.black);
                    currentLabel.setFont(new Font("tahome", Font.PLAIN, 12));
                    currentLabel.setIconTextGap(5);
                    currentcards [2][index] = index;
                    visitlabel[3][index] = true;
                }
            }
    }

    public static void set1and2cardText(int point, String color, String color1, int price1, String color2, int price2, JLabel currentLabel){
        currentLabel.setText("<html>" + point + "      " + color + "<br>" + color1 + " = " + price1 + "             " + color2 + " = " + price2 + "</html>");
        currentLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        currentLabel.setVerticalTextPosition(SwingConstants.TOP);
        currentLabel.setForeground(Color.black);
        currentLabel.setFont(new Font("tahome", Font.PLAIN, 14));
        currentLabel.setIconTextGap(5);


    }

    public static void findprice(int[] price, int[] pass){
        int k =0;
        for (int i = 0; i < 5; i++) {
            if (price[i] != 0){
                pass[k] = price[i];
                k++;}
        }
    }

    public static void updateCard(Card card ){
        int passprice[] = new int[2];
        findprice(card.price , passprice);
        for (int i = 0; i < visitlabel.length; i++) {
            if (!visitlabel[1][i]){
                if (i == 0) {
                    set1and2cardText(card.getPoint(), card.coin.color, card.colors[0], passprice[0] , card.colors[1] , passprice[1] , lev1card1);
                    visitlabel[1][i] = true;
                } else if (i == 1) {
                    set1and2cardText(card.getPoint(), card.coin.color, card.colors[0], passprice[0] , card.colors[1] , passprice[1] , lev1card2);
                    visitlabel[1][i] = true;
                } else if (i == 2) {
                    set1and2cardText(card.getPoint(), card.coin.color, card.colors[0], passprice[0] , card.colors[1] , passprice[1] , lev1card3);
                    visitlabel[1][i] = true;
                } else if (i == 3) {
                    set1and2cardText(card.getPoint(), card.coin.color, card.colors[0], passprice[0] , card.colors[1] , passprice[1] , lev1card4);
                    visitlabel[1][i] = true;
                }
            }

        }
    }
    public static void initstorepanel(JPanel Storepanel){
                JPanel cellPanel = new JPanel();
                cellPanel.setLayout(new BoxLayout(cellPanel, BoxLayout.LINE_AXIS));
                cellPanel.setBackground(new Color(139 , 0 , 0));

                claw1 = new JLabel(cardprize);
                claw2 = new JLabel(cardprize);
                claw3 = new JLabel(cardprize);

        lev1card1 = new JLabel(cardlevel1);
        lev1card2 = new JLabel(cardlevel1);
        lev1card3 = new JLabel(cardlevel1);
        lev1card4 = new JLabel(cardlevel1);

        lev2card1 = new JLabel(cardlevel2);
        lev2card2 = new JLabel(cardlevel2);
        lev2card3 = new JLabel(cardlevel2);
        lev2card4 = new JLabel(cardlevel2);

        Color goGreen = new Color(0 , 171 , 102);
        Color yellow = new Color(165 , 124 , 0);
        clawbutton1.setBackground(goGreen);
        clawbutton2.setBackground(goGreen);
        clawbutton3.setBackground(goGreen);

        lev1button1.setBackground(goGreen);
        lev1button2.setBackground(goGreen);
        lev1button3.setBackground(goGreen);
        lev1button4.setBackground(goGreen);

        lev2button1.setBackground(goGreen);
        lev2button2.setBackground(goGreen);
        lev2button3.setBackground(goGreen);
        lev2button4.setBackground(goGreen);

        lev3button1.setBackground(goGreen);
        lev3button2.setBackground(goGreen);
        lev3button3.setBackground(goGreen);
        lev3button4.setBackground(goGreen);

        clawRes1.setBackground(yellow);
        clawRes2.setBackground(yellow);
        clawRes3.setBackground(yellow);

        lev1Res1.setBackground(yellow);
        lev1Res2.setBackground(yellow);
        lev1Res3.setBackground(yellow);
        lev1Res4.setBackground(yellow);

        lev2Res1.setBackground(yellow);
        lev2Res2.setBackground(yellow);
        lev2Res3.setBackground(yellow);
        lev2Res4.setBackground(yellow);

        lev3Res1.setBackground(yellow);
        lev3Res2.setBackground(yellow);
        lev3Res3.setBackground(yellow);
        lev3Res4.setBackground(yellow);

        
       //  JButton button = new JButton("Reserve");


                cellPanel.add(claw1);
                cellPanel.add(clawbutton1);
                cellPanel.add(clawRes1);
                cellPanel.add(claw2);
                cellPanel.add(clawbutton2);
                cellPanel.add(clawRes2);
                cellPanel.add(claw3);
                cellPanel.add(clawbutton3);
                cellPanel.add(clawRes3);

                JPanel cellPanel1 = new JPanel();
                cellPanel1.setLayout(new BoxLayout(cellPanel1, BoxLayout.LINE_AXIS));
                cellPanel1.setBackground(new Color(139 , 0 , 0));

                cellPanel1.add(lev1card1);
                cellPanel1.add(lev1button1);
                cellPanel1.add(lev1Res1);
                cellPanel1.add(lev1card2);
                cellPanel1.add(lev1button2);
                cellPanel1.add(lev1Res2);
                cellPanel1.add(lev1card3);
                cellPanel1.add(lev1button3);
                cellPanel1.add(lev1Res3);
                cellPanel1.add(lev1card4);
                cellPanel1.add(lev1button4);
                cellPanel1.add(lev1Res4);

                JPanel cellPanel2 = new JPanel();
                cellPanel2.setLayout(new BoxLayout(cellPanel2, BoxLayout.LINE_AXIS));
                cellPanel2.setBackground(new Color(139 , 0 , 0));

        cellPanel2.add(lev2card1);
        cellPanel2.add(lev2button1);
        cellPanel2.add(lev2Res1);
        cellPanel2.add(lev2card2);
        cellPanel2.add(lev2button2);
        cellPanel2.add(lev2Res2);
        cellPanel2.add(lev2card3);
        cellPanel2.add(lev2button3);
        cellPanel2.add(lev2Res3);
        cellPanel2.add(lev2card4);
        cellPanel2.add(lev2button4);
        cellPanel2.add(lev2Res4);

                JPanel cellPanel3 = new JPanel();
                cellPanel3.setLayout(new BoxLayout(cellPanel3,BoxLayout.LINE_AXIS));
                cellPanel3.setBackground(new Color(139 , 0 , 0));

        lev3card1 = new JLabel(cardlevel3);
        lev3card2 = new JLabel(cardlevel3);
        lev3card3 = new JLabel(cardlevel3);
        lev3card4 = new JLabel(cardlevel3);

        cellPanel3.add(lev3card1);
        cellPanel3.add(lev3button1);
        cellPanel3.add(lev3Res1);
        cellPanel3.add(lev3card2);
        cellPanel3.add(lev3button2);
        cellPanel3.add(lev3Res2);
        cellPanel3.add(lev3card3);
        cellPanel3.add(lev3button3);
        cellPanel3.add(lev3Res3);
        cellPanel3.add(lev3card4);
        cellPanel3.add(lev3button4);
        cellPanel3.add(lev3Res4);


        Storepanel.add(cellPanel);
        Storepanel.add(cellPanel1);
        Storepanel.add(cellPanel2);
        Storepanel.add(cellPanel3);

        }

    public static void BuyLevel1Cards(Player p1 , Player p2 , boolean turn , Card [] cards , JLabel P1label , int lev1current , SlotMachine green , SlotMachine red , SlotMachine blue , SlotMachine black , SlotMachine white , JButton button0 , JButton button1 , JButton button2 , JButton button3, JButton button4 ){
        final int[] x = {0};
        x[0] = lev1current;
            ActionListener lev1cardlistener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                 boolean sw = false;
                    if (turn){
                        if (e.getSource() == lev1button1){
                            for (int i =0;i < 5;i++){
                            if ((p1.specialcoincount[i] + p1.coincount[i]) < cards[currentcards[1][0]].price[i])
                                sw = true;
                            else
                                continue;
                            }
                            if (sw == true){
                                showMessageDialog(null , "You cant buy this card");
                            }
                            else{
                               if (cards[currentcards[1][0]].coin.color == "green"){
                                   p1.specialcoincount[0] ++;
                               }
                               else if (cards[currentcards[1][0]].coin.color == "red") {
                                   p1.specialcoincount[1] ++;
                               }
                               else if (cards[currentcards[1][0]].coin.color == "blue") {
                                   p1.specialcoincount[2] ++;
                               }
                               else if (cards[currentcards[1][0]].coin.color == "black") {
                                   p1.specialcoincount[3] ++;
                               }
                               else if (cards[currentcards[1][0]].coin.color == "white") {
                                   p1.specialcoincount[4] ++;
                               }

                                for (int i = 0; i < 5; i++) {
                                    p1.coincount[i] -= cards[currentcards[1][0]].price[i];
                                }
                                green.count += cards[currentcards[1][1]].price[0];
                                red.count += cards[currentcards[1][1]].price[1];
                                blue.count += cards[currentcards[1][1]].price[2];
                                black.count += cards[currentcards[1][1]].price[3];
                                white.count += cards[currentcards[1][1]].price[4];

                                green.setslotText(button0);
                                red.setslotText(button1);
                                blue.setslotText(button2);
                                black.setslotText(button3);
                                white.setslotText(button4);

                                p1.point += cards[currentcards[1][0]].getPoint();
                                visitlabel[1][0] = false;
                               currentcards[1][0] = lev1current;
                               updateCard(cards[lev1current] );
                            }

                        }

                        if (e.getSource() == lev1button2){
                            for (int i =0;i < 5;i++){
                                if ((p1.specialcoincount[i] + p1.coincount[i]) < cards[currentcards[1][1]].price[i])
                                    sw = true;
                            }
                            if (sw == true){
                                showMessageDialog(null , "You cant buy this card");
                            }
                            else{
                                if (cards[currentcards[1][1]].coin.color == "green"){
                                    p1.specialcoincount[0] ++;
                                }
                                else if (cards[currentcards[1][1]].coin.color == "red") {
                                    p1.specialcoincount[1] ++;
                                }
                                else if (cards[currentcards[1][1]].coin.color == "blue") {
                                    p1.specialcoincount[2] ++;
                                }
                                else if (cards[currentcards[1][1]].coin.color == "black") {
                                    p1.specialcoincount[3] ++;
                                }
                                else if (cards[currentcards[1][1]].coin.color == "white") {
                                    p1.specialcoincount[4] ++;
                                }

                                for (int i = 0; i < 5; i++) {
                                    p1.coincount[i] -= cards[currentcards[1][1]].price[i];
                                }

                                green.count += cards[currentcards[1][1]].price[0];
                                red.count += cards[currentcards[1][1]].price[1];
                                blue.count += cards[currentcards[1][1]].price[2];
                                black.count += cards[currentcards[1][1]].price[3];
                                white.count += cards[currentcards[1][1]].price[4];

                                green.setslotText(button0);
                                red.setslotText(button1);
                                blue.setslotText(button2);
                                black.setslotText(button3);
                                white.setslotText(button4);

                                p1.point += cards[currentcards[1][1]].getPoint();
                                visitlabel[1][1] = false;
                                currentcards[1][1] = lev1current;
                                updateCard(cards[lev1current] );
                            }

                        }

                        if (e.getSource() == lev1button3){
                            for (int i =0;i < 5;i++){
                                if ((p1.specialcoincount[i] + p1.coincount[i]) < cards[currentcards[1][2]].price[i])
                                    sw = true;
                            }
                            if (sw == true){
                                showMessageDialog(null , "You cant buy this card");
                            }
                            else{
                                if (cards[currentcards[1][2]].coin.color == "green"){
                                    p1.specialcoincount[0] ++;
                                }
                                else if (cards[currentcards[1][2]].coin.color == "red") {
                                    p1.specialcoincount[1] ++;
                                }
                                else if (cards[currentcards[1][2]].coin.color == "blue") {
                                    p1.specialcoincount[2] ++;
                                }
                                else if (cards[currentcards[1][2]].coin.color == "black") {
                                    p1.specialcoincount[3] ++;
                                }
                                else if (cards[currentcards[1][2]].coin.color == "white") {
                                    p1.specialcoincount[4] ++;
                                }

                                for (int i = 0; i < 5; i++) {
                                    p1.coincount[i] -= cards[currentcards[1][2]].price[i];
                                }
                                green.count += cards[currentcards[1][1]].price[0];
                                red.count += cards[currentcards[1][1]].price[1];
                                blue.count += cards[currentcards[1][1]].price[2];
                                black.count += cards[currentcards[1][1]].price[3];
                                white.count += cards[currentcards[1][1]].price[4];

                                green.setslotText(button0);
                                red.setslotText(button1);
                                blue.setslotText(button2);
                                black.setslotText(button3);
                                white.setslotText(button4);

                                p1.point += cards[currentcards[1][2]].getPoint();
                                visitlabel[1][2] = false;
                                currentcards[1][2] = lev1current;
                                updateCard(cards[lev1current] );
                            }

                        }

                        if (e.getSource() == lev1button4){
                            for (int i =0;i < 5;i++){
                                if ((p1.specialcoincount[i] + p1.coincount[i]) < cards[currentcards[1][3]].price[i])
                                    sw = true;
                            }
                            if (sw == true){
                                showMessageDialog(null , "You cant buy this card");
                            }
                            else{
                                if (cards[currentcards[1][3]].coin.color == "green"){
                                    p1.specialcoincount[0] ++;
                                }
                                else if (cards[currentcards[1][3]].coin.color == "red") {
                                    p1.specialcoincount[1] ++;
                                }
                                else if (cards[currentcards[1][3]].coin.color == "blue") {
                                    p1.specialcoincount[2] ++;
                                }
                                else if (cards[currentcards[1][3]].coin.color == "black") {
                                    p1.specialcoincount[3] ++;
                                }
                                else if (cards[currentcards[1][3]].coin.color == "white") {
                                    p1.specialcoincount[4] ++;
                                }

                                for (int i = 0; i < 5; i++) {
                                    p1.coincount[i] -= cards[currentcards[1][3]].price[i];
                                }
                                green.count += cards[currentcards[1][1]].price[0];
                                red.count += cards[currentcards[1][1]].price[1];
                                blue.count += cards[currentcards[1][1]].price[2];
                                black.count += cards[currentcards[1][1]].price[3];
                                white.count += cards[currentcards[1][1]].price[4];

                                green.setslotText(button0);
                                red.setslotText(button1);
                                blue.setslotText(button2);
                                black.setslotText(button3);
                                white.setslotText(button4);

                                p1.point += cards[currentcards[1][3]].getPoint();
                                visitlabel[1][3] = false;
                                currentcards[1][3] = lev1current;
                                updateCard(cards[lev1current] );
                            }

                        }
                    }
                    setplayertext(P1label , p1 , 1);
                }
            };

            lev1button1.addActionListener(lev1cardlistener);
            lev1button2.addActionListener(lev1cardlistener);
            lev1button3.addActionListener(lev1cardlistener);
            lev1button4.addActionListener(lev1cardlistener);
        }
    }

