package cardcoin;
import playerslot.Player;
import playerslot.SlotMachine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

import static javax.swing.JOptionPane.showMessageDialog;
import static playerslot.Player.*;

public class Card {
    public int[] price;
    public static boolean[][] visitlabel;
    public static int[][] currentcards;
    public String[] colors;

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
    static JPanel cellPanel = new JPanel();
    static JPanel cellPanel1 = new JPanel();
    static JPanel cellPanel2 = new JPanel();
    static JPanel cellPanel3 = new JPanel();
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
        Arrays.fill(price, 0);
        colors = new String[3];
        visitlabel = new boolean[4][4];
        currentcards = new int[4][4];
        int min;
        int max;
        int range;
        int rand;
        Random random = new Random();
        Random house = new Random();
        this.level = level;
        if (level == 1) {
            rand = random.nextInt(2);
            setPoint(rand);
            int[] numbers;
            numbers = new int[2];
            int[] houses = new int[2];
            min = 1;
            max = 3;
            range = max - min + 1;
            numbers[0] = (int) (Math.random() * range) + min;
            if (numbers[0] == 1)
                numbers[1] = 3;
            else {
                min = 2;
                max = 3;
                range = max - min + 1;
                numbers[1] = (int) (Math.random() * range) + min;
            }

            houses[0] = house.nextInt(4);

            if (houses[0] == 0) {
                this.colors[0] = "green";
            } else if (houses[0] == 1) {
                this.colors[0] = "red";
            } else if (houses[0] == 2) {
                this.colors[0] = "blue";
            } else {
                this.colors[0] = "black";
            }
            for (int i = 1; i < 2; i++) {

                houses[i] = house.nextInt(5);
                if (houses[i] <= houses[0]) {
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
            int[] numbers;
            numbers = new int[2];
            int[] houses = new int[2];
            min = 3;
            range = max - min + 1;
            numbers[0] = (int) (Math.random() * range) + min;

            min = 3;
            max = 4;
            range = max - min + 1;
            numbers[1] = (int) (Math.random() * range) + min;

            houses[0] = house.nextInt(4);

            if (houses[0] == 0) {
                this.colors[0] = "green";
            } else if (houses[0] == 1) {
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
                if (houses[i] <= houses[0]) {
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
            int[] numbers;
            numbers = new int[3];
            int[] houses = new int[3];
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

            if (houses[0] == 0) {
                this.colors[0] = "green";
            } else if (houses[0] == 1) {
                this.colors[0] = "red";
            } else if (houses[0] == 2) {
                this.colors[0] = "blue";
            }
            for (int i = 1; i < 2; i++) {

                houses[i] = house.nextInt(4);
                if (houses[i] <= houses[0]) {
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
                if (houses[i] <= houses[0] || houses[i] <= houses[1]) {
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

            if (houses[0] == 0) {
                this.colors[0] = "green";
            } else if (houses[0] == 1) {
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
                if (houses[i] <= houses[0]) {
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

    public void setCardlevel0ocation(int index, int point, String color1, String color2, int price1, int price2) {
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
                currentcards[0][index] = index;
                visitlabel[0][index] = true;
            }
        }
    }

    public void setCardlevel1Location(int index, int point, String color, String color1, String color2, int price1, int price2) {
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
                set1and2cardText(point, color, color1, price1, color2, price2, currentLabel);
                currentcards[1][index] = index;
                visitlabel[1][index] = true;

            }
        }
    }


    public void setCardlevel2Location(int index, int point, String color, String color1, String color2, int price1, int price2) {
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
                set1and2cardText(point, color, color1, price1, color2, price2, currentLabel);
                currentcards[2][index] = index;
                visitlabel[2][index] = true;
            }
        }
    }

    public void setCardlevel3Location(int index, int point, String color, String color1, String color2, String color3, int price1, int price2, int price3) {

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
                set3cardText(point, color, color1, color2, color3, price1, price2, price3, currentLabel);
                currentcards[3][index] = index;
                visitlabel[3][index] = true;
            }
        }
    }

    public static void set1and2cardText(int point, String color, String color1, int price1, String color2, int price2, JLabel currentLabel) {
        currentLabel.setText("<html>" + point + "      " + color + "<br>" + color1 + " = " + price1 + "             " + color2 + " = " + price2 + "</html>");
        currentLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        currentLabel.setVerticalTextPosition(SwingConstants.TOP);
        currentLabel.setForeground(Color.black);
        currentLabel.setFont(new Font("tahome", Font.PLAIN, 14));
        currentLabel.setIconTextGap(5);
    }

    public static void set3cardText(int point, String color, String color1, String color2, String color3, int price1, int price2, int price3, JLabel currentLabel) {
        currentLabel.setText("<html>" + point + "  " + color + "<br>" + color1 + " = " + price1 + "    " + color2 + " = " + price2 + color3 + " = " + price3 + "</html>");
        currentLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        currentLabel.setVerticalTextPosition(SwingConstants.TOP);
        currentLabel.setForeground(Color.black);
        currentLabel.setFont(new Font("tahome", Font.PLAIN, 12));
        currentLabel.setIconTextGap(5);
    }

    public static void findprice(int[] price, int[] pass) {
        int k = 0;
        for (int i = 0; i < 5; i++) {
            if (price[i] != 0) {
                pass[k] = price[i];
                k++;
            }
        }
    }

    public static void updateCard(Card card) {
        int[] passprice = new int[3];
        findprice(card.price, passprice);
        for (int i = 0; i < visitlabel.length; i++) {
            if (card.level == 1) {
                if (!visitlabel[1][i]) {
                    if (i == 0) {
                        set1and2cardText(card.getPoint(), card.coin.color, card.colors[0], passprice[0], card.colors[1], passprice[1], lev1card1);
                        visitlabel[1][i] = true;
                    } else if (i == 1) {
                        set1and2cardText(card.getPoint(), card.coin.color, card.colors[0], passprice[0], card.colors[1], passprice[1], lev1card2);
                        visitlabel[1][i] = true;
                    } else if (i == 2) {
                        set1and2cardText(card.getPoint(), card.coin.color, card.colors[0], passprice[0], card.colors[1], passprice[1], lev1card3);
                        visitlabel[1][i] = true;
                    } else if (i == 3) {
                        set1and2cardText(card.getPoint(), card.coin.color, card.colors[0], passprice[0], card.colors[1], passprice[1], lev1card4);
                        visitlabel[1][i] = true;
                    }
                }
            } else if (card.level == 2) {
                if (!visitlabel[2][i]) {
                    if (i == 0) {
                        set1and2cardText(card.getPoint(), card.coin.color, card.colors[0], passprice[0], card.colors[1], passprice[1], lev2card1);
                        visitlabel[2][i] = true;
                    } else if (i == 1) {
                        set1and2cardText(card.getPoint(), card.coin.color, card.colors[0], passprice[0], card.colors[1], passprice[1], lev2card2);
                        visitlabel[2][i] = true;
                    } else if (i == 2) {
                        set1and2cardText(card.getPoint(), card.coin.color, card.colors[0], passprice[0], card.colors[1], passprice[1], lev2card3);
                        visitlabel[2][i] = true;
                    } else if (i == 3) {
                        set1and2cardText(card.getPoint(), card.coin.color, card.colors[0], passprice[0], card.colors[1], passprice[1], lev2card4);
                        visitlabel[2][i] = true;
                    }
                }
            } else if (card.level == 3) {
                if (!visitlabel[3][i]) {
                    if (i == 0) {
                        set3cardText(card.getPoint(), card.coin.color, card.colors[0], card.colors[1], card.colors[2], passprice[0], passprice[1], passprice[2], lev3card1);
                        visitlabel[3][i] = true;
                    } else if (i == 1) {
                        set3cardText(card.getPoint(), card.coin.color, card.colors[0], card.colors[1], card.colors[2], passprice[0], passprice[1], passprice[2], lev3card2);
                        visitlabel[3][i] = true;
                    } else if (i == 2) {
                        set3cardText(card.getPoint(), card.coin.color, card.colors[0], card.colors[1], card.colors[2], passprice[0], passprice[1], passprice[2], lev3card3);
                        visitlabel[3][i] = true;
                    } else if (i == 3) {
                        set3cardText(card.getPoint(), card.coin.color, card.colors[0], card.colors[1], card.colors[2], passprice[0], passprice[1], passprice[2], lev3card4);
                        visitlabel[3][i] = true;
                    }
                }

            }
        }
    }

    public static void initstorepanel(JPanel Storepanel) {

        cellPanel.setLayout(new BoxLayout(cellPanel, BoxLayout.LINE_AXIS));
        cellPanel.setBackground(new Color(139, 0, 0));

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

        Color goGreen = new Color(0, 171, 102);
        Color yellow = new Color(165, 124, 0);

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

        cellPanel.add(claw1);

        cellPanel.add(claw2);

        cellPanel.add(claw3);

        cellPanel1.setLayout(new BoxLayout(cellPanel1, BoxLayout.LINE_AXIS));
        cellPanel1.setBackground(new Color(139, 0, 0));

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


        cellPanel2.setLayout(new BoxLayout(cellPanel2, BoxLayout.LINE_AXIS));
        cellPanel2.setBackground(new Color(139, 0, 0));

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


        cellPanel3.setLayout(new BoxLayout(cellPanel3, BoxLayout.LINE_AXIS));
        cellPanel3.setBackground(new Color(139, 0, 0));

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

    public static void BuyCards(Player p1, Player p2, boolean[] turn, Card[][] cards, JLabel P1label, int next[], SlotMachine green, SlotMachine red, SlotMachine blue, SlotMachine black, SlotMachine white, JButton button0, JButton button1, JButton button2, JButton button3, JButton button4, JFrame frame) {

        ActionListener lev1cardlistener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean sw = false;
                if (turn[0]) {
                    if (e.getSource() == lev1button1) {
                        for (int i = 0; i < 5; i++) {
                            if ((p1.specialcoincount[i] + p1.coincount[i]) < cards[1][currentcards[1][0]].price[i]) {
                                sw = true;
                                break;
                            }
                        }
                        if (sw) {
                            showMessageDialog(null, "You cant buy this card");
                        } else {
                            if (cards[1][currentcards[1][0]].coin.color == "green") {
                                p1.specialcoincount[0]++;
                            } else if (cards[1][currentcards[1][0]].coin.color == "red") {
                                p1.specialcoincount[1]++;
                            } else if (cards[1][currentcards[1][0]].coin.color == "blue") {
                                p1.specialcoincount[2]++;
                            } else if (cards[1][currentcards[1][0]].coin.color == "black") {
                                p1.specialcoincount[3]++;
                            } else if (cards[1][currentcards[1][0]].coin.color == "white") {
                                p1.specialcoincount[4]++;
                            }

                            for (int i = 0; i < 5; i++) {
                                p1.coincount[i] -= cards[1][currentcards[1][0]].price[i];
                                if (p1.coincount[i] < 0)
                                    p1.coincount[i] = 0;
                            }
                            green.count += cards[1][currentcards[1][0]].price[0];
                            red.count += cards[1][currentcards[1][0]].price[1];
                            blue.count += cards[1][currentcards[1][0]].price[2];
                            black.count += cards[1][currentcards[1][0]].price[3];
                            white.count += cards[1][currentcards[1][0]].price[4];

                            green.setslotText(button0);
                            red.setslotText(button1);
                            blue.setslotText(button2);
                            black.setslotText(button3);
                            white.setslotText(button4);

                            p1.point += cards[1][currentcards[1][0]].getPoint();
                            addPrize1(cards[0][0], p1);
                            addPrize2(cards[0][1] , p1);
                            addPrize3(cards[0][2] , p1);
                            checkwinner(p1, frame);
                            if (next[1] <= 14) {
                                visitlabel[1][0] = false;
                                currentcards[1][0] = next[1];
                                updateCard(cards[1][next[1]]);
                                next[1]++;
                            } else {
                                cellPanel1.remove(lev1card1);
                                cellPanel1.remove(lev1button1);
                                cellPanel1.remove(lev1Res1);
                            }
                        }

                    }

                    if (e.getSource() == lev1button2) {
                        for (int i = 0; i < 5; i++) {
                            if ((p1.specialcoincount[i] + p1.coincount[i]) < cards[1][currentcards[1][1]].price[i])
                                sw = true;
                        }
                        if (sw) {
                            showMessageDialog(null, "You cant buy this card");
                        } else {
                            if (cards[1][currentcards[1][1]].coin.color == "green") {
                                p1.specialcoincount[0]++;
                            } else if (cards[1][currentcards[1][1]].coin.color == "red") {
                                p1.specialcoincount[1]++;
                            } else if (cards[1][currentcards[1][1]].coin.color == "blue") {
                                p1.specialcoincount[2]++;
                            } else if (cards[1][currentcards[1][1]].coin.color == "black") {
                                p1.specialcoincount[3]++;
                            } else if (cards[1][currentcards[1][1]].coin.color == "white") {
                                p1.specialcoincount[4]++;
                            }

                            for (int i = 0; i < 5; i++) {
                                p1.coincount[i] -= cards[1][currentcards[1][1]].price[i];
                                if (p1.coincount[i] < 0)
                                    p1.coincount[i] = 0;
                            }

                            green.count += cards[1][currentcards[1][1]].price[0];
                            red.count += cards[1][currentcards[1][1]].price[1];
                            blue.count += cards[1][currentcards[1][1]].price[2];
                            black.count += cards[1][currentcards[1][1]].price[3];
                            white.count += cards[1][currentcards[1][1]].price[4];

                            green.setslotText(button0);
                            red.setslotText(button1);
                            blue.setslotText(button2);
                            black.setslotText(button3);
                            white.setslotText(button4);

                            p1.point += cards[1][currentcards[1][1]].getPoint();
                            addPrize1(cards[0][0], p1);
                            addPrize2(cards[0][1] , p1);
                            addPrize3(cards[0][2] , p1);
                            checkwinner(p1, frame);
                            if (next[1] <= 14) {
                                visitlabel[1][1] = false;
                                currentcards[1][1] = next[1];
                                updateCard(cards[1][next[1]]);
                                next[1]++;
                            } else {
                                cellPanel1.remove(lev1card2);
                                cellPanel1.remove(lev1button2);
                                cellPanel1.remove(lev1Res2);
                            }
                        }

                    }

                    if (e.getSource() == lev1button3) {
                        for (int i = 0; i < 5; i++) {
                            if ((p1.specialcoincount[i] + p1.coincount[i]) < cards[1][currentcards[1][2]].price[i])
                                sw = true;
                        }
                        if (sw) {
                            showMessageDialog(null, "You cant buy this card");
                        } else {
                            if (cards[1][currentcards[1][2]].coin.color == "green") {
                                p1.specialcoincount[0]++;
                            } else if (cards[1][currentcards[1][2]].coin.color == "red") {
                                p1.specialcoincount[1]++;
                            } else if (cards[1][currentcards[1][2]].coin.color == "blue") {
                                p1.specialcoincount[2]++;
                            } else if (cards[1][currentcards[1][2]].coin.color == "black") {
                                p1.specialcoincount[3]++;
                            } else if (cards[1][currentcards[1][2]].coin.color == "white") {
                                p1.specialcoincount[4]++;
                            }

                            for (int i = 0; i < 5; i++) {
                                p1.coincount[i] -= cards[1][currentcards[1][2]].price[i];
                                if (p1.coincount[i] < 0)
                                    p1.coincount[i] = 0;
                            }
                            green.count += cards[1][currentcards[1][2]].price[0];
                            red.count += cards[1][currentcards[1][2]].price[1];
                            blue.count += cards[1][currentcards[1][2]].price[2];
                            black.count += cards[1][currentcards[1][2]].price[3];
                            white.count += cards[1][currentcards[1][2]].price[4];

                            green.setslotText(button0);
                            red.setslotText(button1);
                            blue.setslotText(button2);
                            black.setslotText(button3);
                            white.setslotText(button4);

                            p1.point += cards[1][currentcards[1][2]].getPoint();
                            addPrize1(cards[0][0], p1);
                            addPrize2(cards[0][1] , p1);
                            addPrize3(cards[0][2] , p1);
                            checkwinner(p1, frame);
                            if (next[1] <= 14) {
                                visitlabel[1][2] = false;
                                currentcards[1][2] = next[1];
                                updateCard(cards[1][next[1]]);
                                next[1]++;
                            } else {
                                cellPanel1.remove(lev1card3);
                                cellPanel1.remove(lev1button3);
                                cellPanel1.remove(lev1Res3);
                            }
                        }

                    }

                    if (e.getSource() == lev1button4) {
                        for (int i = 0; i < 5; i++) {
                            if ((p1.specialcoincount[i] + p1.coincount[i]) < cards[1][currentcards[1][3]].price[i]) {
                                sw = true;
                                break;
                            }
                        }
                        if (sw) {
                            showMessageDialog(null, "You cant buy this card");
                        } else {
                            if (cards[1][currentcards[1][3]].coin.color == "green") {
                                p1.specialcoincount[0]++;
                            } else if (cards[1][currentcards[1][3]].coin.color == "red") {
                                p1.specialcoincount[1]++;
                            } else if (cards[1][currentcards[1][3]].coin.color == "blue") {
                                p1.specialcoincount[2]++;
                            } else if (cards[1][currentcards[1][3]].coin.color == "black") {
                                p1.specialcoincount[3]++;
                            } else if (cards[1][currentcards[1][3]].coin.color == "white") {
                                p1.specialcoincount[4]++;
                            }

                            for (int i = 0; i < 5; i++) {
                                p1.coincount[i] -= cards[1][currentcards[1][3]].price[i];
                                if (p1.coincount[i] < 0)
                                    p1.coincount[i] = 0;
                            }
                            green.count += cards[1][currentcards[1][3]].price[0];
                            red.count += cards[1][currentcards[1][3]].price[1];
                            blue.count += cards[1][currentcards[1][3]].price[2];
                            black.count += cards[1][currentcards[1][3]].price[3];
                            white.count += cards[1][currentcards[1][3]].price[4];

                            green.setslotText(button0);
                            red.setslotText(button1);
                            blue.setslotText(button2);
                            black.setslotText(button3);
                            white.setslotText(button4);

                            p1.point += cards[1][currentcards[1][3]].getPoint();
                            addPrize1(cards[0][0], p1);
                            addPrize2(cards[0][1] , p1);
                            addPrize3(cards[0][2] , p1);
                            checkwinner(p1, frame);
                            if (next[1] <= 14) {
                                visitlabel[1][3] = false;
                                currentcards[1][3] = next[1];
                                updateCard(cards[1][next[1]]);
                                next[1]++;
                            } else {
                                cellPanel1.remove(lev1card4);
                                cellPanel1.remove(lev1button4);
                                cellPanel1.remove(lev1Res4);
                            }
                        }

                    }

                    if (e.getSource() == lev2button1) {
                        for (int i = 0; i < 5; i++) {
                            if ((p1.specialcoincount[i] + p1.coincount[i]) < cards[2][currentcards[2][0]].price[i])
                                sw = true;
                            else
                                continue;
                        }
                        if (sw) {
                            showMessageDialog(null, "You cant buy this card");
                        } else {
                            if (cards[2][currentcards[2][0]].coin.color == "green") {
                                p1.specialcoincount[0]++;
                            } else if (cards[2][currentcards[2][0]].coin.color == "red") {
                                p1.specialcoincount[1]++;
                            } else if (cards[2][currentcards[2][0]].coin.color == "blue") {
                                p1.specialcoincount[2]++;
                            } else if (cards[2][currentcards[2][0]].coin.color == "black") {
                                p1.specialcoincount[3]++;
                            } else if (cards[2][currentcards[2][0]].coin.color == "white") {
                                p1.specialcoincount[4]++;
                            }

                            for (int i = 0; i < 5; i++) {
                                p1.coincount[i] -= cards[2][currentcards[2][0]].price[i];
                                if (p1.coincount[i] < 0)
                                    p1.coincount[i] = 0;
                            }
                            green.count += cards[2][currentcards[2][0]].price[0];
                            red.count += cards[2][currentcards[2][0]].price[1];
                            blue.count += cards[2][currentcards[2][0]].price[2];
                            black.count += cards[2][currentcards[2][0]].price[3];
                            white.count += cards[2][currentcards[2][0]].price[4];

                            green.setslotText(button0);
                            red.setslotText(button1);
                            blue.setslotText(button2);
                            black.setslotText(button3);
                            white.setslotText(button4);

                            p1.point += cards[2][currentcards[2][0]].getPoint();
                            addPrize1(cards[0][0], p1);
                            addPrize2(cards[0][1] , p1);
                            addPrize3(cards[0][2] , p1);
                            checkwinner(p1 , frame);
                            if (next[2] <= 14) {
                                visitlabel[2][0] = false;
                                currentcards[2][0] = next[2];
                                updateCard(cards[2][next[2]]);
                                next[2]++;
                            } else {
                                cellPanel2.remove(lev2card1);
                                cellPanel2.remove(lev2button1);
                                cellPanel2.remove(lev2Res1);
                            }
                        }
                    } else if (e.getSource() == lev2button2) {
                        for (int i = 0; i < 5; i++) {
                            if ((p1.specialcoincount[i] + p1.coincount[i]) < cards[2][currentcards[2][1]].price[i])
                                sw = true;
                            else
                                continue;
                        }
                        if (sw) {
                            showMessageDialog(null, "You cant buy this card");
                        } else {
                            if (cards[2][currentcards[2][1]].coin.color == "green") {
                                p1.specialcoincount[0]++;
                            } else if (cards[2][currentcards[2][1]].coin.color == "red") {
                                p1.specialcoincount[1]++;
                            } else if (cards[2][currentcards[2][1]].coin.color == "blue") {
                                p1.specialcoincount[2]++;
                            } else if (cards[2][currentcards[2][1]].coin.color == "black") {
                                p1.specialcoincount[3]++;
                            } else if (cards[2][currentcards[2][1]].coin.color == "white") {
                                p1.specialcoincount[4]++;
                            }

                            for (int i = 0; i < 5; i++) {
                                p1.coincount[i] -= cards[2][currentcards[2][1]].price[i];
                                if (p1.coincount[i] < 0)
                                    p1.coincount[i] = 0;
                            }
                            green.count += cards[2][currentcards[2][1]].price[0];
                            red.count += cards[2][currentcards[2][1]].price[1];
                            blue.count += cards[2][currentcards[2][1]].price[2];
                            black.count += cards[2][currentcards[2][1]].price[3];
                            white.count += cards[2][currentcards[2][1]].price[4];

                            green.setslotText(button0);
                            red.setslotText(button1);
                            blue.setslotText(button2);
                            black.setslotText(button3);
                            white.setslotText(button4);

                            p1.point += cards[2][currentcards[2][1]].getPoint();
                            addPrize1(cards[0][0], p1);
                            addPrize2(cards[0][1] , p1);
                            addPrize3(cards[0][2] , p1);
                            if (next[2] <= 14) {
                                visitlabel[2][1] = false;
                                currentcards[2][1] = next[2];
                                updateCard(cards[2][next[2]]);
                                next[2]++;
                            } else {
                                cellPanel2.remove(lev2card2);
                                cellPanel2.remove(lev2button2);
                                cellPanel2.remove(lev2Res2);
                            }
                        }

                    } else if (e.getSource() == lev2button3) {
                        for (int i = 0; i < 5; i++) {
                            if ((p1.specialcoincount[i] + p1.coincount[i]) < cards[2][currentcards[2][2]].price[i])
                                sw = true;
                            else
                                continue;
                        }
                        if (sw) {
                            showMessageDialog(null, "You cant buy this card");
                        } else {
                            if (cards[2][currentcards[2][2]].coin.color == "green") {
                                p1.specialcoincount[0]++;
                            } else if (cards[2][currentcards[2][2]].coin.color == "red") {
                                p1.specialcoincount[1]++;
                            } else if (cards[2][currentcards[2][2]].coin.color == "blue") {
                                p1.specialcoincount[2]++;
                            } else if (cards[2][currentcards[2][2]].coin.color == "black") {
                                p1.specialcoincount[3]++;
                            } else if (cards[2][currentcards[2][2]].coin.color == "white") {
                                p1.specialcoincount[4]++;
                            }

                            for (int i = 0; i < 5; i++) {
                                p1.coincount[i] -= cards[2][currentcards[2][2]].price[i];
                                if (p1.coincount[i] < 0)
                                    p1.coincount[i] = 0;
                            }
                            green.count += cards[2][currentcards[2][2]].price[0];
                            red.count += cards[2][currentcards[2][2]].price[1];
                            blue.count += cards[2][currentcards[2][2]].price[2];
                            black.count += cards[2][currentcards[2][2]].price[3];
                            white.count += cards[2][currentcards[2][2]].price[4];

                            green.setslotText(button0);
                            red.setslotText(button1);
                            blue.setslotText(button2);
                            black.setslotText(button3);
                            white.setslotText(button4);

                            p1.point += cards[2][currentcards[2][2]].getPoint();
                            if (next[2] <= 14) {
                                visitlabel[2][2] = false;
                                currentcards[2][2] = next[2];
                                updateCard(cards[2][next[2]]);
                                next[2]++;
                            } else {
                                cellPanel2.remove(lev2card3);
                                cellPanel2.remove(lev2button3);
                                cellPanel2.remove(lev2Res3);
                            }
                        }
                    } else if (e.getSource() == lev2button4) {
                        for (int i = 0; i < 5; i++) {
                            if ((p1.specialcoincount[i] + p1.coincount[i]) < cards[2][currentcards[2][3]].price[i])
                                sw = true;
                            else
                                continue;
                        }
                        if (sw) {
                            showMessageDialog(null, "You cant buy this card");
                        } else {
                            if (cards[2][currentcards[2][3]].coin.color == "green") {
                                p1.specialcoincount[0]++;
                            } else if (cards[2][currentcards[2][3]].coin.color == "red") {
                                p1.specialcoincount[1]++;
                            } else if (cards[2][currentcards[2][3]].coin.color == "blue") {
                                p1.specialcoincount[2]++;
                            } else if (cards[2][currentcards[2][3]].coin.color == "black") {
                                p1.specialcoincount[3]++;
                            } else if (cards[2][currentcards[2][3]].coin.color == "white") {
                                p1.specialcoincount[4]++;
                            }

                            for (int i = 0; i < 5; i++) {
                                p1.coincount[i] -= cards[2][currentcards[2][3]].price[i];
                                if (p1.coincount[i] < 0)
                                    p1.coincount[i] = 0;
                            }
                            green.count += cards[2][currentcards[2][3]].price[0];
                            red.count += cards[2][currentcards[2][3]].price[1];
                            blue.count += cards[2][currentcards[2][3]].price[2];
                            black.count += cards[2][currentcards[2][3]].price[3];
                            white.count += cards[2][currentcards[2][3]].price[4];

                            green.setslotText(button0);
                            red.setslotText(button1);
                            blue.setslotText(button2);
                            black.setslotText(button3);
                            white.setslotText(button4);

                            p1.point += cards[2][currentcards[2][3]].getPoint();
                            addPrize1(cards[0][0], p1);
                            addPrize2(cards[0][1] , p1);
                            addPrize3(cards[0][2] , p1);
                            if (next[2] <= 14) {
                                visitlabel[2][3] = false;
                                currentcards[2][3] = next[2];
                                updateCard(cards[2][next[2]]);
                                next[2]++;
                            } else {
                                cellPanel2.remove(lev2card4);
                                cellPanel2.remove(lev2button4);
                                cellPanel2.remove(lev2Res4);
                            }
                        }
                    }

                    if (e.getSource() == lev3button1) {
                        for (int i = 0; i < 5; i++) {
                            if ((p1.specialcoincount[i] + p1.coincount[i]) < cards[3][currentcards[3][0]].price[i])
                                sw = true;
                            else
                                continue;
                        }
                        if (sw == true) {
                            showMessageDialog(null, "You cant buy this card");
                        } else {
                            if (cards[3][currentcards[3][0]].coin.color == "green") {
                                p1.specialcoincount[0]++;
                            } else if (cards[3][currentcards[3][0]].coin.color == "red") {
                                p1.specialcoincount[1]++;
                            } else if (cards[3][currentcards[3][0]].coin.color == "blue") {
                                p1.specialcoincount[2]++;
                            } else if (cards[3][currentcards[3][0]].coin.color == "black") {
                                p1.specialcoincount[3]++;
                            } else if (cards[3][currentcards[3][0]].coin.color == "white") {
                                p1.specialcoincount[4]++;
                            }

                            for (int i = 0; i < 5; i++) {
                                p1.coincount[i] -= cards[3][currentcards[3][0]].price[i];
                                if (p1.coincount[i] < 0)
                                    p1.coincount[i] = 0;
                            }
                            green.count += cards[3][currentcards[3][0]].price[0];
                            red.count += cards[3][currentcards[3][0]].price[1];
                            blue.count += cards[3][currentcards[3][0]].price[2];
                            black.count += cards[3][currentcards[3][0]].price[3];
                            white.count += cards[3][currentcards[3][0]].price[4];

                            green.setslotText(button0);
                            red.setslotText(button1);
                            blue.setslotText(button2);
                            black.setslotText(button3);
                            white.setslotText(button4);

                            p1.point += cards[3][currentcards[3][0]].getPoint();
                            addPrize1(cards[0][0], p1);
                            addPrize2(cards[0][1] , p1);
                            addPrize3(cards[0][2] , p1);
                            if (next[3] <= 14) {
                                visitlabel[3][0] = false;
                                currentcards[3][0] = next[3];
                                updateCard(cards[3][next[3]]);
                                next[3]++;
                            } else {
                                cellPanel3.remove(lev3card1);
                                cellPanel3.remove(lev3button1);
                                cellPanel3.remove(lev3Res1);
                            }
                        }
                    } else if (e.getSource() == lev3button2) {
                        for (int i = 0; i < 5; i++) {
                            if ((p1.specialcoincount[i] + p1.coincount[i]) < cards[3][currentcards[3][1]].price[i])
                                sw = true;
                            else
                                continue;
                        }
                        if (sw == true) {
                            showMessageDialog(null, "You cant buy this card");
                        } else {
                            if (cards[3][currentcards[3][1]].coin.color == "green") {
                                p1.specialcoincount[0]++;
                            } else if (cards[3][currentcards[3][1]].coin.color == "red") {
                                p1.specialcoincount[1]++;
                            } else if (cards[3][currentcards[3][1]].coin.color == "blue") {
                                p1.specialcoincount[2]++;
                            } else if (cards[3][currentcards[3][1]].coin.color == "black") {
                                p1.specialcoincount[3]++;
                            } else if (cards[3][currentcards[3][1]].coin.color == "white") {
                                p1.specialcoincount[4]++;
                            }

                            for (int i = 0; i < 5; i++) {
                                p1.coincount[i] -= cards[3][currentcards[3][1]].price[i];
                                if (p1.coincount[i] < 0)
                                    p1.coincount[i] = 0;
                            }
                            green.count += cards[3][currentcards[3][1]].price[0];
                            red.count += cards[3][currentcards[3][1]].price[1];
                            blue.count += cards[3][currentcards[3][1]].price[2];
                            black.count += cards[3][currentcards[3][1]].price[3];
                            white.count += cards[3][currentcards[3][1]].price[4];

                            green.setslotText(button0);
                            red.setslotText(button1);
                            blue.setslotText(button2);
                            black.setslotText(button3);
                            white.setslotText(button4);

                            p1.point += cards[3][currentcards[3][1]].getPoint();
                            addPrize1(cards[0][0], p1);
                            addPrize2(cards[0][1] , p1);
                            addPrize3(cards[0][2] , p1);
                            if (next[3] <= 14) {
                                visitlabel[3][1] = false;
                                currentcards[3][1] = next[3];
                                updateCard(cards[3][next[3]]);
                                next[3]++;
                            } else {
                                cellPanel3.remove(lev3card2);
                                cellPanel3.remove(lev3button2);
                                cellPanel3.remove(lev3Res2);
                            }
                        }
                    }

                    if (e.getSource() == lev3button3) {
                        for (int i = 0; i < 5; i++) {
                            if ((p1.specialcoincount[i] + p1.coincount[i]) < cards[3][currentcards[3][2]].price[i])
                                sw = true;
                            else
                                continue;
                        }
                        if (sw) {
                            showMessageDialog(null, "You cant buy this card");
                        } else {
                            if (cards[3][currentcards[3][2]].coin.color == "green") {
                                p1.specialcoincount[0]++;
                            } else if (cards[3][currentcards[3][2]].coin.color == "red") {
                                p1.specialcoincount[1]++;
                            } else if (cards[3][currentcards[3][2]].coin.color == "blue") {
                                p1.specialcoincount[2]++;
                            } else if (cards[3][currentcards[3][2]].coin.color == "black") {
                                p1.specialcoincount[3]++;
                            } else if (cards[3][currentcards[3][2]].coin.color == "white") {
                                p1.specialcoincount[4]++;
                            }

                            for (int i = 0; i < 5; i++) {
                                p1.coincount[i] -= cards[3][currentcards[3][2]].price[i];
                                if (p1.coincount[i] < 0)
                                    p1.coincount[i] = 0;
                            }
                            green.count += cards[3][currentcards[3][2]].price[0];
                            red.count += cards[3][currentcards[3][2]].price[1];
                            blue.count += cards[3][currentcards[3][2]].price[2];
                            black.count += cards[3][currentcards[3][2]].price[3];
                            white.count += cards[3][currentcards[3][2]].price[4];

                            green.setslotText(button0);
                            red.setslotText(button1);
                            blue.setslotText(button2);
                            black.setslotText(button3);
                            white.setslotText(button4);

                            p1.point += cards[3][currentcards[3][2]].getPoint();
                            addPrize1(cards[0][0], p1);
                            addPrize2(cards[0][1] , p1);
                            addPrize3(cards[0][2] , p1);
                            if (next[3] <= 14) {
                                visitlabel[3][2] = false;
                                currentcards[3][2] = next[3];
                                updateCard(cards[3][next[3]]);
                                next[3]++;
                            } else {
                                cellPanel3.remove(lev3card3);
                                cellPanel3.remove(lev3button3);
                                cellPanel3.remove(lev3Res3);
                            }
                        }
                    }

                    if (e.getSource() == lev3button4) {
                        for (int i = 0; i < 5; i++) {
                            if ((p1.specialcoincount[i] + p1.coincount[i]) < cards[3][currentcards[3][3]].price[i])
                                sw = true;
                            else
                                continue;
                        }
                        if (sw) {
                            showMessageDialog(null, "You cant buy this card");
                        } else {
                            if (cards[3][currentcards[3][3]].coin.color == "green") {
                                p1.specialcoincount[0]++;
                            } else if (cards[3][currentcards[3][3]].coin.color == "red") {
                                p1.specialcoincount[1]++;
                            } else if (cards[3][currentcards[3][3]].coin.color == "blue") {
                                p1.specialcoincount[2]++;
                            } else if (cards[3][currentcards[3][3]].coin.color == "black") {
                                p1.specialcoincount[3]++;
                            } else if (cards[3][currentcards[3][3]].coin.color == "white") {
                                p1.specialcoincount[4]++;
                            }

                            for (int i = 0; i < 5; i++) {
                                p1.coincount[i] -= cards[3][currentcards[3][3]].price[i];
                                if (p1.coincount[i] < 0)
                                    p1.coincount[i] = 0;
                            }
                            green.count += cards[3][currentcards[3][3]].price[0];
                            red.count += cards[3][currentcards[3][3]].price[1];
                            blue.count += cards[3][currentcards[3][3]].price[2];
                            black.count += cards[3][currentcards[3][3]].price[3];
                            white.count += cards[3][currentcards[3][3]].price[4];

                            green.setslotText(button0);
                            red.setslotText(button1);
                            blue.setslotText(button2);
                            black.setslotText(button3);
                            white.setslotText(button4);

                            p1.point += cards[3][currentcards[3][3]].getPoint();
                            addPrize1(cards[0][0], p1);
                            addPrize2(cards[0][1] , p1);
                            addPrize3(cards[0][2] , p1);
                            if (next[3] <= 14) {
                                visitlabel[3][3] = false;
                                currentcards[3][3] = next[3];
                                updateCard(cards[3][next[3]]);
                                next[3]++;
                            } else {
                                cellPanel3.remove(lev3card4);
                                cellPanel3.remove(lev3button4);
                                cellPanel3.remove(lev3Res4);
                            }
                        }
                    }
                }

                if (!turn[0]) {
                    if (e.getSource() == lev1button1) {
                        for (int i = 0; i < 5; i++) {
                            if ((p2.specialcoincount[i] + p2.coincount[i]) < cards[1][currentcards[1][0]].price[i])
                                sw = true;
                        }
                        if (sw) {
                            showMessageDialog(null, "You cant buy this card");
                        } else {
                            if (cards[1][currentcards[1][0]].coin.color == "green") {
                                p2.specialcoincount[0]++;
                            } else if (cards[1][currentcards[1][0]].coin.color == "red") {
                                p2.specialcoincount[1]++;
                            } else if (cards[1][currentcards[1][0]].coin.color == "blue") {
                                p2.specialcoincount[2]++;
                            } else if (cards[1][currentcards[1][0]].coin.color == "black") {
                                p2.specialcoincount[3]++;
                            } else if (cards[1][currentcards[1][0]].coin.color == "white") {
                                p2.specialcoincount[4]++;
                            }

                            for (int i = 0; i < 5; i++) {
                                p2.coincount[i] -= cards[1][currentcards[1][0]].price[i];
                                if (p2.coincount[i] < 0)
                                    p2.coincount[i] = 0;
                            }
                            green.count += cards[1][currentcards[1][0]].price[0];
                            red.count += cards[1][currentcards[1][0]].price[1];
                            blue.count += cards[1][currentcards[1][0]].price[2];
                            black.count += cards[1][currentcards[1][0]].price[3];
                            white.count += cards[1][currentcards[1][0]].price[4];

                            green.setslotText(button0);
                            red.setslotText(button1);
                            blue.setslotText(button2);
                            black.setslotText(button3);
                            white.setslotText(button4);

                            p2.point += cards[1][currentcards[1][0]].getPoint();
                            addPrize1(cards[0][0], p2);
                            addPrize2(cards[0][1] , p2);
                            addPrize3(cards[0][2] , p2);
                            if (next[1] <= 14) {
                                visitlabel[1][0] = false;
                                currentcards[1][0] = next[1];
                                updateCard(cards[1][next[1]]);
                                next[1]++;
                            } else {
                                cellPanel1.remove(lev1card1);
                                cellPanel1.remove(lev1button1);
                                cellPanel1.remove(lev1Res1);
                            }
                        }

                    }

                    if (e.getSource() == lev1button2) {
                        for (int i = 0; i < 5; i++) {
                            if ((p2.specialcoincount[i] + p2.coincount[i]) < cards[1][currentcards[1][1]].price[i])
                                sw = true;
                        }
                        if (sw) {
                            showMessageDialog(null, "You cant buy this card");
                        } else {
                            if (cards[1][currentcards[1][1]].coin.color == "green") {
                                p2.specialcoincount[0]++;
                            } else if (cards[1][currentcards[1][1]].coin.color == "red") {
                                p2.specialcoincount[1]++;
                            } else if (cards[1][currentcards[1][1]].coin.color == "blue") {
                                p2.specialcoincount[2]++;
                            } else if (cards[1][currentcards[1][1]].coin.color == "black") {
                                p2.specialcoincount[3]++;
                            } else if (cards[1][currentcards[1][1]].coin.color == "white") {
                                p2.specialcoincount[4]++;
                            }

                            for (int i = 0; i < 5; i++) {
                                p2.coincount[i] -= cards[1][currentcards[1][1]].price[i];
                                if (p1.coincount[i] < 0)
                                    p2.coincount[i] = 0;
                            }

                            green.count += cards[1][currentcards[1][1]].price[0];
                            red.count += cards[1][currentcards[1][1]].price[1];
                            blue.count += cards[1][currentcards[1][1]].price[2];
                            black.count += cards[1][currentcards[1][1]].price[3];
                            white.count += cards[1][currentcards[1][1]].price[4];

                            green.setslotText(button0);
                            red.setslotText(button1);
                            blue.setslotText(button2);
                            black.setslotText(button3);
                            white.setslotText(button4);

                            p2.point += cards[1][currentcards[1][1]].getPoint();
                            addPrize1(cards[0][0], p2);
                            addPrize2(cards[0][1] , p2);
                            addPrize3(cards[0][2] , p2);
                            if (next[1] <= 14) {
                                visitlabel[1][1] = false;
                                currentcards[1][1] = next[1];
                                updateCard(cards[1][next[1]]);
                                next[1]++;
                            } else {
                                cellPanel1.remove(lev1card2);
                                cellPanel1.remove(lev1button2);
                                cellPanel1.remove(lev1Res2);
                            }
                        }

                    }

                    if (e.getSource() == lev1button3) {
                        for (int i = 0; i < 5; i++) {
                            if ((p2.specialcoincount[i] + p2.coincount[i]) < cards[1][currentcards[1][2]].price[i])
                                sw = true;
                        }
                        if (sw) {
                            showMessageDialog(null, "You cant buy this card");
                        } else {
                            if (cards[1][currentcards[1][2]].coin.color == "green") {
                                p2.specialcoincount[0]++;
                            } else if (cards[1][currentcards[1][2]].coin.color == "red") {
                                p2.specialcoincount[1]++;
                            } else if (cards[1][currentcards[1][2]].coin.color == "blue") {
                                p2.specialcoincount[2]++;
                            } else if (cards[1][currentcards[1][2]].coin.color == "black") {
                                p2.specialcoincount[3]++;
                            } else if (cards[1][currentcards[1][2]].coin.color == "white") {
                                p2.specialcoincount[4]++;
                            }

                            for (int i = 0; i < 5; i++) {
                                p2.coincount[i] -= cards[1][currentcards[1][2]].price[i];
                                if (p1.coincount[i] < 0)
                                    p2.coincount[i] = 0;
                            }
                            green.count += cards[1][currentcards[1][2]].price[0];
                            red.count += cards[1][currentcards[1][2]].price[1];
                            blue.count += cards[1][currentcards[1][2]].price[2];
                            black.count += cards[1][currentcards[1][2]].price[3];
                            white.count += cards[1][currentcards[1][2]].price[4];

                            green.setslotText(button0);
                            red.setslotText(button1);
                            blue.setslotText(button2);
                            black.setslotText(button3);
                            white.setslotText(button4);

                            p2.point += cards[1][currentcards[1][2]].getPoint();
                            addPrize1(cards[0][0], p2);
                            addPrize2(cards[0][1] , p2);
                            addPrize3(cards[0][2] , p2);
                            if (next[1] <= 14) {
                                visitlabel[1][2] = false;
                                currentcards[1][2] = next[1];
                                updateCard(cards[1][next[1]]);
                                next[1]++;
                            } else {
                                cellPanel1.remove(lev1card3);
                                cellPanel1.remove(lev1button3);
                                cellPanel1.remove(lev1Res3);
                            }
                        }

                    }

                    if (e.getSource() == lev1button4) {
                        for (int i = 0; i < 5; i++) {
                            if ((p2.specialcoincount[i] + p2.coincount[i]) < cards[1][currentcards[1][3]].price[i])
                                sw = true;
                        }
                        if (sw) {
                            showMessageDialog(null, "You cant buy this card");
                        } else {
                            if (cards[1][currentcards[1][3]].coin.color == "green") {
                                p2.specialcoincount[0]++;
                            } else if (cards[1][currentcards[1][3]].coin.color == "red") {
                                p2.specialcoincount[1]++;
                            } else if (cards[1][currentcards[1][3]].coin.color == "blue") {
                                p2.specialcoincount[2]++;
                            } else if (cards[1][currentcards[1][3]].coin.color == "black") {
                                p2.specialcoincount[3]++;
                            } else if (cards[1][currentcards[1][3]].coin.color == "white") {
                                p2.specialcoincount[4]++;
                            }

                            for (int i = 0; i < 5; i++) {
                                p2.coincount[i] -= cards[1][currentcards[1][3]].price[i];
                                if (p1.coincount[i] < 0)
                                    p2.coincount[i] = 0;
                            }
                            green.count += cards[1][currentcards[1][3]].price[0];
                            red.count += cards[1][currentcards[1][3]].price[1];
                            blue.count += cards[1][currentcards[1][3]].price[2];
                            black.count += cards[1][currentcards[1][3]].price[3];
                            white.count += cards[1][currentcards[1][3]].price[4];

                            green.setslotText(button0);
                            red.setslotText(button1);
                            blue.setslotText(button2);
                            black.setslotText(button3);
                            white.setslotText(button4);

                            p2.point += cards[1][currentcards[1][3]].getPoint();
                            addPrize1(cards[0][0], p2);
                            addPrize2(cards[0][1] , p2);
                            addPrize3(cards[0][2] , p2);
                            if (next[1] <= 14) {
                                visitlabel[1][3] = false;
                                currentcards[1][3] = next[1];
                                updateCard(cards[1][next[1]]);
                                next[1]++;
                            } else {
                                cellPanel1.remove(lev1card4);
                                cellPanel1.remove(lev1button4);
                                cellPanel1.remove(lev1Res4);
                            }
                        }

                    }

                    if (e.getSource() == lev2button1) {
                        for (int i = 0; i < 5; i++) {
                            if ((p2.specialcoincount[i] + p2.coincount[i]) < cards[2][currentcards[2][0]].price[i])
                                sw = true;
                            else
                                continue;
                        }
                        if (sw) {
                            showMessageDialog(null, "You cant buy this card");
                        } else {
                            if (cards[2][currentcards[2][0]].coin.color == "green") {
                                p2.specialcoincount[0]++;
                            } else if (cards[2][currentcards[2][0]].coin.color == "red") {
                                p2.specialcoincount[1]++;
                            } else if (cards[2][currentcards[2][0]].coin.color == "blue") {
                                p2.specialcoincount[2]++;
                            } else if (cards[2][currentcards[2][0]].coin.color == "black") {
                                p2.specialcoincount[3]++;
                            } else if (cards[2][currentcards[2][0]].coin.color == "white") {
                                p2.specialcoincount[4]++;
                            }

                            for (int i = 0; i < 5; i++) {
                                p2.coincount[i] -= cards[2][currentcards[2][0]].price[i];
                                if (p1.coincount[i] < 0)
                                    p2.coincount[i] = 0;
                            }
                            green.count += cards[2][currentcards[2][0]].price[0];
                            red.count += cards[2][currentcards[2][0]].price[1];
                            blue.count += cards[2][currentcards[2][0]].price[2];
                            black.count += cards[2][currentcards[2][0]].price[3];
                            white.count += cards[2][currentcards[2][0]].price[4];

                            green.setslotText(button0);
                            red.setslotText(button1);
                            blue.setslotText(button2);
                            black.setslotText(button3);
                            white.setslotText(button4);

                            p2.point += cards[2][currentcards[2][0]].getPoint();
                            addPrize1(cards[0][0], p2);
                            addPrize2(cards[0][1] , p2);
                            addPrize3(cards[0][2] , p2);
                            if (next[2] <= 14) {
                                visitlabel[2][0] = false;
                                currentcards[2][0] = next[2];
                                updateCard(cards[2][next[2]]);
                                next[2]++;
                            } else {
                                cellPanel2.remove(lev2card1);
                                cellPanel2.remove(lev2button1);
                                cellPanel2.remove(lev2Res1);
                            }
                        }
                    } else if (e.getSource() == lev2button2) {
                        for (int i = 0; i < 5; i++) {
                            if ((p2.specialcoincount[i] + p2.coincount[i]) < cards[2][currentcards[2][1]].price[i])
                                sw = true;
                            else
                                continue;
                        }
                        if (sw) {
                            showMessageDialog(null, "You cant buy this card");
                        } else {
                            if (cards[2][currentcards[2][1]].coin.color == "green") {
                                p2.specialcoincount[0]++;
                            } else if (cards[2][currentcards[2][1]].coin.color == "red") {
                                p2.specialcoincount[1]++;
                            } else if (cards[2][currentcards[2][1]].coin.color == "blue") {
                                p2.specialcoincount[2]++;
                            } else if (cards[2][currentcards[2][1]].coin.color == "black") {
                                p2.specialcoincount[3]++;
                            } else if (cards[2][currentcards[2][1]].coin.color == "white") {
                                p2.specialcoincount[4]++;
                            }

                            for (int i = 0; i < 5; i++) {
                                p2.coincount[i] -= cards[2][currentcards[2][1]].price[i];
                                if (p1.coincount[i] < 0)
                                    p2.coincount[i] = 0;
                            }
                            green.count += cards[2][currentcards[2][1]].price[0];
                            red.count += cards[2][currentcards[2][1]].price[1];
                            blue.count += cards[2][currentcards[2][1]].price[2];
                            black.count += cards[2][currentcards[2][1]].price[3];
                            white.count += cards[2][currentcards[2][1]].price[4];

                            green.setslotText(button0);
                            red.setslotText(button1);
                            blue.setslotText(button2);
                            black.setslotText(button3);
                            white.setslotText(button4);

                            p2.point += cards[2][currentcards[2][1]].getPoint();
                            addPrize1(cards[0][0], p2);
                            addPrize2(cards[0][1] , p2);
                            addPrize3(cards[0][2] , p2);
                            if (next[2] <= 14) {
                                visitlabel[2][1] = false;
                                currentcards[2][1] = next[2];
                                updateCard(cards[2][next[2]]);
                                next[2]++;
                            } else {
                                cellPanel2.remove(lev2card2);
                                cellPanel2.remove(lev2button2);
                                cellPanel2.remove(lev2Res2);
                            }
                        }

                    } else if (e.getSource() == lev2button3) {
                        for (int i = 0; i < 5; i++) {
                            if ((p2.specialcoincount[i] + p2.coincount[i]) < cards[2][currentcards[2][2]].price[i])
                                sw = true;
                            else
                                continue;
                        }
                        if (sw) {
                            showMessageDialog(null, "You cant buy this card");
                        } else {
                            if (cards[2][currentcards[2][2]].coin.color == "green") {
                                p2.specialcoincount[0]++;
                            } else if (cards[2][currentcards[2][2]].coin.color == "red") {
                                p2.specialcoincount[1]++;
                            } else if (cards[2][currentcards[2][2]].coin.color == "blue") {
                                p2.specialcoincount[2]++;
                            } else if (cards[2][currentcards[2][2]].coin.color == "black") {
                                p2.specialcoincount[3]++;
                            } else if (cards[2][currentcards[2][2]].coin.color == "white") {
                                p2.specialcoincount[4]++;
                            }

                            for (int i = 0; i < 5; i++) {
                                p2.coincount[i] -= cards[2][currentcards[2][2]].price[i];
                                if (p1.coincount[i] < 0)
                                    p2.coincount[i] = 0;
                            }
                            green.count += cards[2][currentcards[2][2]].price[0];
                            red.count += cards[2][currentcards[2][2]].price[1];
                            blue.count += cards[2][currentcards[2][2]].price[2];
                            black.count += cards[2][currentcards[2][2]].price[3];
                            white.count += cards[2][currentcards[2][2]].price[4];

                            green.setslotText(button0);
                            red.setslotText(button1);
                            blue.setslotText(button2);
                            black.setslotText(button3);
                            white.setslotText(button4);

                            p2.point += cards[2][currentcards[2][2]].getPoint();
                            addPrize1(cards[0][0], p2);
                            addPrize2(cards[0][1] , p2);
                            addPrize3(cards[0][2] , p2);
                            if (next[2] <= 14) {
                                visitlabel[2][2] = false;
                                currentcards[2][2] = next[2];
                                updateCard(cards[2][next[2]]);
                                next[2]++;
                            } else {
                                cellPanel2.remove(lev2card3);
                                cellPanel2.remove(lev2button3);
                                cellPanel2.remove(lev2Res3);
                            }
                        }
                    } else if (e.getSource() == lev2button4) {
                        for (int i = 0; i < 5; i++) {
                            if ((p2.specialcoincount[i] + p2.coincount[i]) < cards[2][currentcards[2][3]].price[i])
                                sw = true;
                            else
                                continue;
                        }
                        if (sw) {
                            showMessageDialog(null, "You cant buy this card");
                        } else {
                            if (cards[2][currentcards[2][3]].coin.color == "green") {
                                p2.specialcoincount[0]++;
                            } else if (cards[2][currentcards[2][3]].coin.color == "red") {
                                p2.specialcoincount[1]++;
                            } else if (cards[2][currentcards[2][3]].coin.color == "blue") {
                                p2.specialcoincount[2]++;
                            } else if (cards[2][currentcards[2][3]].coin.color == "black") {
                                p2.specialcoincount[3]++;
                            } else if (cards[2][currentcards[2][3]].coin.color == "white") {
                                p2.specialcoincount[4]++;
                            }

                            for (int i = 0; i < 5; i++) {
                                p2.coincount[i] -= cards[2][currentcards[2][3]].price[i];
                                if (p1.coincount[i] < 0)
                                    p2.coincount[i] = 0;
                            }
                            green.count += cards[2][currentcards[2][3]].price[0];
                            red.count += cards[2][currentcards[2][3]].price[1];
                            blue.count += cards[2][currentcards[2][3]].price[2];
                            black.count += cards[2][currentcards[2][3]].price[3];
                            white.count += cards[2][currentcards[2][3]].price[4];

                            green.setslotText(button0);
                            red.setslotText(button1);
                            blue.setslotText(button2);
                            black.setslotText(button3);
                            white.setslotText(button4);

                            p2.point += cards[2][currentcards[2][3]].getPoint();
                            addPrize1(cards[0][0], p2);
                            addPrize2(cards[0][1] , p2);
                            addPrize3(cards[0][2] , p2);
                            if (next[2] <= 14) {
                                visitlabel[2][3] = false;
                                currentcards[2][3] = next[2];
                                updateCard(cards[2][next[2]]);
                                next[2]++;
                            } else {
                                cellPanel2.remove(lev2card4);
                                cellPanel2.remove(lev2button4);
                                cellPanel2.remove(lev2Res4);
                            }
                        }
                    }

                    if (e.getSource() == lev3button1) {
                        for (int i = 0; i < 5; i++) {
                            if ((p2.specialcoincount[i] + p2.coincount[i]) < cards[3][currentcards[3][0]].price[i])
                                sw = true;
                            else
                                continue;
                        }
                        if (sw == true) {
                            showMessageDialog(null, "You cant buy this card");
                        } else {
                            if (cards[3][currentcards[3][0]].coin.color == "green") {
                                p2.specialcoincount[0]++;
                            } else if (cards[3][currentcards[3][0]].coin.color == "red") {
                                p2.specialcoincount[1]++;
                            } else if (cards[3][currentcards[3][0]].coin.color == "blue") {
                                p2.specialcoincount[2]++;
                            } else if (cards[3][currentcards[3][0]].coin.color == "black") {
                                p2.specialcoincount[3]++;
                            } else if (cards[3][currentcards[3][0]].coin.color == "white") {
                                p2.specialcoincount[4]++;
                            }

                            for (int i = 0; i < 5; i++) {
                                p2.coincount[i] -= cards[3][currentcards[3][0]].price[i];
                                if (p1.coincount[i] < 0)
                                    p2.coincount[i] = 0;
                            }
                            green.count += cards[3][currentcards[3][0]].price[0];
                            red.count += cards[3][currentcards[3][0]].price[1];
                            blue.count += cards[3][currentcards[3][0]].price[2];
                            black.count += cards[3][currentcards[3][0]].price[3];
                            white.count += cards[3][currentcards[3][0]].price[4];

                            green.setslotText(button0);
                            red.setslotText(button1);
                            blue.setslotText(button2);
                            black.setslotText(button3);
                            white.setslotText(button4);

                            p2.point += cards[3][currentcards[3][0]].getPoint();
                            addPrize1(cards[0][0], p2);
                            addPrize2(cards[0][1] , p2);
                            addPrize3(cards[0][2] , p2);
                            if (next[3] <= 14) {
                                visitlabel[3][0] = false;
                                currentcards[3][0] = next[3];
                                updateCard(cards[3][next[3]]);
                                next[3]++;
                            } else {
                                cellPanel3.remove(lev3card1);
                                cellPanel3.remove(lev3button1);
                                cellPanel3.remove(lev3Res1);
                            }
                        }
                    } else if (e.getSource() == lev3button2) {
                        for (int i = 0; i < 5; i++) {
                            if ((p2.specialcoincount[i] + p2.coincount[i]) < cards[3][currentcards[3][1]].price[i])
                                sw = true;
                            else
                                continue;
                        }
                        if (sw == true) {
                            showMessageDialog(null, "You cant buy this card");
                        } else {
                            if (cards[3][currentcards[3][1]].coin.color == "green") {
                                p2.specialcoincount[0]++;
                            } else if (cards[3][currentcards[3][1]].coin.color == "red") {
                                p2.specialcoincount[1]++;
                            } else if (cards[3][currentcards[3][1]].coin.color == "blue") {
                                p2.specialcoincount[2]++;
                            } else if (cards[3][currentcards[3][1]].coin.color == "black") {
                                p2.specialcoincount[3]++;
                            } else if (cards[3][currentcards[3][1]].coin.color == "white") {
                                p2.specialcoincount[4]++;
                            }

                            for (int i = 0; i < 5; i++) {
                                p2.coincount[i] -= cards[3][currentcards[3][1]].price[i];
                                if (p1.coincount[i] < 0)
                                    p2.coincount[i] = 0;
                            }
                            green.count += cards[3][currentcards[3][1]].price[0];
                            red.count += cards[3][currentcards[3][1]].price[1];
                            blue.count += cards[3][currentcards[3][1]].price[2];
                            black.count += cards[3][currentcards[3][1]].price[3];
                            white.count += cards[3][currentcards[3][1]].price[4];

                            green.setslotText(button0);
                            red.setslotText(button1);
                            blue.setslotText(button2);
                            black.setslotText(button3);
                            white.setslotText(button4);

                            p2.point += cards[3][currentcards[3][1]].getPoint();
                            addPrize1(cards[0][0], p2);
                            addPrize2(cards[0][1] , p2);
                            addPrize3(cards[0][2] , p2);
                            if (next[3] <= 14) {
                                visitlabel[3][1] = false;
                                currentcards[3][1] = next[3];
                                updateCard(cards[3][next[3]]);
                                next[3]++;
                            } else {
                                cellPanel3.remove(lev3card2);
                                cellPanel3.remove(lev3button2);
                                cellPanel3.remove(lev3Res2);
                            }
                        }
                    }

                    if (e.getSource() == lev3button3) {
                        for (int i = 0; i < 5; i++) {
                            if ((p2.specialcoincount[i] + p2.coincount[i]) < cards[3][currentcards[3][2]].price[i])
                                sw = true;
                            else
                                continue;
                        }
                        if (sw == true) {
                            showMessageDialog(null, "You cant buy this card");
                        } else {
                            if (cards[3][currentcards[3][2]].coin.color == "green") {
                                p2.specialcoincount[0]++;
                            } else if (cards[3][currentcards[3][2]].coin.color == "red") {
                                p2.specialcoincount[1]++;
                            } else if (cards[3][currentcards[3][2]].coin.color == "blue") {
                                p2.specialcoincount[2]++;
                            } else if (cards[3][currentcards[3][2]].coin.color == "black") {
                                p2.specialcoincount[3]++;
                            } else if (cards[3][currentcards[3][2]].coin.color == "white") {
                                p2.specialcoincount[4]++;
                            }

                            for (int i = 0; i < 5; i++) {
                                p2.coincount[i] -= cards[3][currentcards[3][2]].price[i];
                                if (p1.coincount[i] < 0)
                                    p2.coincount[i] = 0;
                            }
                            green.count += cards[3][currentcards[3][2]].price[0];
                            red.count += cards[3][currentcards[3][2]].price[1];
                            blue.count += cards[3][currentcards[3][2]].price[2];
                            black.count += cards[3][currentcards[3][2]].price[3];
                            white.count += cards[3][currentcards[3][2]].price[4];

                            green.setslotText(button0);
                            red.setslotText(button1);
                            blue.setslotText(button2);
                            black.setslotText(button3);
                            white.setslotText(button4);

                            p2.point += cards[3][currentcards[3][2]].getPoint();
                            addPrize1(cards[0][0], p2);
                            addPrize2(cards[0][1] , p2);
                            addPrize3(cards[0][2] , p2);
                            if (next[3] <= 14) {
                                visitlabel[3][2] = false;
                                currentcards[3][2] = next[3];
                                updateCard(cards[3][next[3]]);
                                next[3]++;
                            } else {
                                cellPanel3.remove(lev3card3);
                                cellPanel3.remove(lev3button3);
                                cellPanel3.remove(lev3Res3);
                            }
                        }
                    }

                    if (e.getSource() == lev3button4) {
                        for (int i = 0; i < 5; i++) {
                            if ((p2.specialcoincount[i] + p2.coincount[i]) < cards[3][currentcards[3][3]].price[i])
                                sw = true;
                            else
                                continue;
                        }
                        if (sw == true) {
                            showMessageDialog(null, "You cant buy this card");
                        } else {
                            if (cards[3][currentcards[3][3]].coin.color == "green") {
                                p2.specialcoincount[0]++;
                            } else if (cards[3][currentcards[3][3]].coin.color == "red") {
                                p2.specialcoincount[1]++;
                            } else if (cards[3][currentcards[3][3]].coin.color == "blue") {
                                p2.specialcoincount[2]++;
                            } else if (cards[3][currentcards[3][3]].coin.color == "black") {
                                p2.specialcoincount[3]++;
                            } else if (cards[3][currentcards[3][3]].coin.color == "white") {
                                p2.specialcoincount[4]++;
                            }

                            for (int i = 0; i < 5; i++) {
                                p2.coincount[i] -= cards[3][currentcards[3][3]].price[i];
                                if (p1.coincount[i] < 0)
                                    p2.coincount[i] = 0;
                            }
                            green.count += cards[3][currentcards[3][3]].price[0];
                            red.count += cards[3][currentcards[3][3]].price[1];
                            blue.count += cards[3][currentcards[3][3]].price[2];
                            black.count += cards[3][currentcards[3][3]].price[3];
                            white.count += cards[3][currentcards[3][3]].price[4];

                            green.setslotText(button0);
                            red.setslotText(button1);
                            blue.setslotText(button2);
                            black.setslotText(button3);
                            white.setslotText(button4);

                            p2.point += cards[3][currentcards[3][3]].getPoint();
                            addPrize1(cards[0][0], p2);
                            addPrize2(cards[0][1] , p2);
                            addPrize3(cards[0][2] , p2);
                            if (next[3] <= 14) {
                                visitlabel[3][3] = false;
                                currentcards[3][3] = next[3];
                                updateCard(cards[3][next[3]]);
                                next[3]++;
                            } else {
                                cellPanel3.remove(lev3card4);
                                cellPanel3.remove(lev3button4);
                                cellPanel3.remove(lev3Res4);
                            }
                        }
                    }
                }
                setplayertext(P1label, p1, 1);
            }
        };

        lev1button1.addActionListener(lev1cardlistener);
        lev1button2.addActionListener(lev1cardlistener);
        lev1button3.addActionListener(lev1cardlistener);
        lev1button4.addActionListener(lev1cardlistener);

        lev2button1.addActionListener(lev1cardlistener);
        lev2button2.addActionListener(lev1cardlistener);
        lev2button3.addActionListener(lev1cardlistener);
        lev2button4.addActionListener(lev1cardlistener);

        lev3button1.addActionListener(lev1cardlistener);
        lev3button2.addActionListener(lev1cardlistener);
        lev3button3.addActionListener(lev1cardlistener);
        lev3button4.addActionListener(lev1cardlistener);
    }

    public static void ReserveCards(Player p1, Player p2, boolean[] turn, Card[][] cards, JLabel P1label, JLabel P2label, int[] next, JLabel currentTurn) {
        ActionListener Reservelistener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn[0]) {
                    if (e.getSource() == lev1Res1) {
                        if (p1.checkReserve() == -1) {
                            showMessageDialog(null, "You cant reserve more than 3 cards !");
                        } else {
                            p1.ReserveCards[p1.checkReserve()] = currentcards[1][0];
                            visitlabel[1][0] = false;
                            currentcards[1][0] = next[1];
                            updateCard(cards[1][next[1]]);
                            next[1]++;
                            p1.specialcoincount[5]++;
                            turn[0] = false;
                            ShowTurn(turn , currentTurn);
                        }
                    }
                    if (e.getSource() == lev1Res2) {
                        if (p1.checkReserve() == -1) {
                            showMessageDialog(null, "You cant reserve more than 3 cards !");
                        } else {
                            p1.ReserveCards[p1.checkReserve()] = currentcards[1][1];
                            visitlabel[1][1] = false;
                            currentcards[1][1] = next[1];
                            updateCard(cards[1][next[1]]);
                            next[1]++;
                            p1.specialcoincount[5]++;
                            turn[0] = false;
                            ShowTurn(turn , currentTurn);
                        }
                    }
                    if (e.getSource() == lev1Res3) {
                        if (p1.checkReserve() == -1) {
                            showMessageDialog(null, "You cant reserve more than 3 cards !");
                        } else {
                            p1.ReserveCards[p1.checkReserve()] = currentcards[1][2];
                            visitlabel[1][2] = false;
                            currentcards[1][2] = next[1];
                            updateCard(cards[1][next[1]]);
                            next[1]++;
                            p1.specialcoincount[5]++;
                            turn[0] = false;
                            ShowTurn(turn , currentTurn);
                        }
                    }
                    if (e.getSource() == lev1Res4) {
                        if (p1.checkReserve() == -1) {
                            showMessageDialog(null, "You cant reserve more than 3 cards !");
                        } else {
                            p1.ReserveCards[p1.checkReserve()] = currentcards[1][3];
                            visitlabel[1][3] = false;
                            currentcards[1][3] = next[1];
                            updateCard(cards[1][next[1]]);
                            next[1]++;
                            p1.specialcoincount[5]++;
                            turn[0] = false;
                            ShowTurn(turn , currentTurn);
                        }
                    }
                    if (e.getSource() == lev2Res1) {
                        if (p1.checkReserve() == -1) {
                            showMessageDialog(null, "You cant reserve more than 3 cards !");
                        } else {
                            p1.ReserveCards[p1.checkReserve()] = currentcards[2][0];
                            visitlabel[2][0] = false;
                            currentcards[2][0] = next[2];
                            updateCard(cards[2][next[2]]);
                            next[2]++;
                            p1.specialcoincount[5]++;
                            turn[0] = false;
                            ShowTurn(turn , currentTurn);
                        }
                    }
                    if (e.getSource() == lev2Res2) {
                        if (p1.checkReserve() == -1) {
                            showMessageDialog(null, "You cant reserve more than 3 cards !");
                        } else {
                            p1.ReserveCards[p1.checkReserve()] = currentcards[2][1];
                            visitlabel[2][1] = false;
                            currentcards[2][1] = next[2];
                            updateCard(cards[2][next[2]]);
                            next[2]++;
                            p1.specialcoincount[5]++;
                            turn[0] = false;
                            ShowTurn(turn , currentTurn);
                        }
                    }
                    if (e.getSource() == lev2Res3) {
                        if (p1.checkReserve() == -1) {
                            showMessageDialog(null, "You cant reserve more than 3 cards !");
                        } else {
                            p1.ReserveCards[p1.checkReserve()] = currentcards[2][2];
                            visitlabel[2][2] = false;
                            currentcards[2][2] = next[2];
                            updateCard(cards[2][next[2]]);
                            next[2]++;
                            p1.specialcoincount[5]++;
                            turn[0] = false;
                            ShowTurn(turn , currentTurn);
                        }
                    }
                    if (e.getSource() == lev2Res4) {
                        if (p1.checkReserve() == -1) {
                            showMessageDialog(null, "You cant reserve more than 3 cards !");
                        } else {
                            p1.ReserveCards[p1.checkReserve()] = currentcards[2][3];
                            visitlabel[2][3] = false;
                            currentcards[2][3] = next[2];
                            updateCard(cards[2][next[2]]);
                            next[2]++;
                            p1.specialcoincount[5]++;
                            turn[0] = false;
                            ShowTurn(turn , currentTurn);
                        }
                    }
                    if (e.getSource() == lev3Res1) {
                        if (p1.checkReserve() == -1) {
                            showMessageDialog(null, "You cant reserve more than 3 cards !");
                        } else {
                            p1.ReserveCards[p1.checkReserve()] = currentcards[3][0];
                            visitlabel[3][0] = false;
                            currentcards[3][0] = next[3];
                            updateCard(cards[3][next[3]]);
                            next[3]++;
                            p1.specialcoincount[5]++;
                            turn[0] = false;
                            ShowTurn(turn , currentTurn);
                        }
                    }
                    if (e.getSource() == lev3Res2) {
                        if (p1.checkReserve() == -1) {
                            showMessageDialog(null, "You cant reserve more than 3 cards !");
                        } else {
                            p1.ReserveCards[p1.checkReserve()] = currentcards[3][1];
                            visitlabel[3][1] = false;
                            currentcards[3][1] = next[3];
                            updateCard(cards[3][next[3]]);
                            next[3]++;
                            p1.specialcoincount[5]++;
                            turn[0] = false;
                            ShowTurn(turn , currentTurn);
                        }
                    }
                    if (e.getSource() == lev3Res3) {
                        if (p1.checkReserve() == -1) {
                            showMessageDialog(null, "You cant reserve more than 3 cards !");
                        } else {
                            p1.ReserveCards[p1.checkReserve()] = currentcards[3][2];
                            visitlabel[3][2] = false;
                            currentcards[3][2] = next[3];
                            updateCard(cards[3][next[3]]);
                            next[3]++;
                            p1.specialcoincount[5]++;
                            turn[0] = false;
                            ShowTurn(turn , currentTurn);
                        }
                    }
                    if (e.getSource() == lev3Res4) {
                        if (p1.checkReserve() == -1) {
                            showMessageDialog(null, "You cant reserve more than 3 cards !");
                        } else {
                            p1.ReserveCards[p1.checkReserve()] = currentcards[3][1];
                            visitlabel[3][3] = false;
                            currentcards[3][3] = next[3];
                            updateCard(cards[3][next[3]]);
                            next[3]++;
                            p1.specialcoincount[5]++;
                            turn[0] = false;
                            ShowTurn(turn , currentTurn);
                        }
                    }

                } else if (!turn[0]) {
                    if (e.getSource() == lev1Res1) {
                        if (p2.checkReserve() == -1) {
                            showMessageDialog(null, "You cant reserve more than 3 cards !");
                        } else {
                            p2.ReserveCards[p2.checkReserve()] = currentcards[1][0];
                            visitlabel[1][0] = false;
                            currentcards[1][0] = next[1];
                            updateCard(cards[1][next[1]]);
                            next[1]++;
                            p2.specialcoincount[5]++;
                            turn[0] = true;
                            ShowTurn(turn , currentTurn);
                        }
                    }
                    if (e.getSource() == lev1Res2) {
                        if (p2.checkReserve() == -1) {
                            showMessageDialog(null, "You cant reserve more than 3 cards !");
                        } else {
                            p2.ReserveCards[p2.checkReserve()] = currentcards[1][1];
                            visitlabel[1][1] = false;
                            currentcards[1][1] = next[1];
                            updateCard(cards[1][next[1]]);
                            next[1]++;
                            p2.specialcoincount[5]++;
                            turn[0] = true;
                            ShowTurn(turn , currentTurn);
                        }
                    }
                    if (e.getSource() == lev1Res3) {
                        if (p2.checkReserve() == -1) {
                            showMessageDialog(null, "You cant reserve more than 3 cards !");
                        } else {
                            p2.ReserveCards[p2.checkReserve()] = currentcards[1][2];
                            visitlabel[1][2] = false;
                            currentcards[1][2] = next[1];
                            updateCard(cards[1][next[1]]);
                            next[1]++;
                            p2.specialcoincount[5]++;
                            turn[0] = true;
                            ShowTurn(turn , currentTurn);
                        }
                    }
                    if (e.getSource() == lev1Res4) {
                        if (p2.checkReserve() == -1) {
                            showMessageDialog(null, "You cant reserve more than 3 cards !");
                        } else {
                            p2.ReserveCards[p2.checkReserve()] = currentcards[1][3];
                            visitlabel[1][3] = false;
                            currentcards[1][3] = next[1];
                            updateCard(cards[1][next[1]]);
                            next[1]++;
                            p2.specialcoincount[5]++;
                            turn[0] = true;
                            ShowTurn(turn , currentTurn);
                        }
                    }
                    if (e.getSource() == lev2Res1) {
                        if (p2.checkReserve() == -1) {
                            showMessageDialog(null, "You cant reserve more than 3 cards !");
                        } else {
                            p2.ReserveCards[p2.checkReserve()] = currentcards[2][0];
                            visitlabel[2][0] = false;
                            currentcards[2][0] = next[2];
                            updateCard(cards[2][next[2]]);
                            next[2]++;
                            p2.specialcoincount[5]++;
                            turn[0] = true;
                            ShowTurn(turn , currentTurn);
                        }
                    }
                    if (e.getSource() == lev2Res2) {
                        if (p2.checkReserve() == -1) {
                            showMessageDialog(null, "You cant reserve more than 3 cards !");
                        } else {
                            p2.ReserveCards[p2.checkReserve()] = currentcards[2][1];
                            visitlabel[2][1] = false;
                            currentcards[2][1] = next[2];
                            updateCard(cards[2][next[2]]);
                            next[2]++;
                            p2.specialcoincount[5]++;
                            turn[0] = true;
                            ShowTurn(turn , currentTurn);
                        }
                    }
                    if (e.getSource() == lev2Res3) {
                        if (p2.checkReserve() == -1) {
                            showMessageDialog(null, "You cant reserve more than 3 cards !");
                        } else {
                            p2.ReserveCards[p2.checkReserve()] = currentcards[2][2];
                            visitlabel[2][2] = false;
                            currentcards[2][2] = next[2];
                            updateCard(cards[2][next[2]]);
                            next[2]++;
                            p2.specialcoincount[5]++;
                            turn[0] = true;
                            ShowTurn(turn , currentTurn);
                        }
                    }
                    if (e.getSource() == lev2Res4) {
                        if (p2.checkReserve() == -1) {
                            showMessageDialog(null, "You cant reserve more than 3 cards !");
                        } else {
                            p2.ReserveCards[p2.checkReserve()] = currentcards[2][3];
                            visitlabel[2][3] = false;
                            currentcards[2][3] = next[2];
                            updateCard(cards[2][next[2]]);
                            next[2]++;
                            p2.specialcoincount[5]++;
                            turn[0] = true;
                            ShowTurn(turn , currentTurn);

                        }
                    }
                    if (e.getSource() == lev3Res1) {
                        if (p2.checkReserve() == -1) {
                            showMessageDialog(null, "You cant reserve more than 3 cards !");
                        } else {
                            p2.ReserveCards[p2.checkReserve()] = currentcards[3][0];
                            visitlabel[3][0] = false;
                            currentcards[3][0] = next[3];
                            updateCard(cards[3][next[3]]);
                            next[3]++;
                            p2.specialcoincount[5]++;
                            turn[0] = true;
                            ShowTurn(turn , currentTurn);
                        }
                    }
                    if (e.getSource() == lev3Res2) {
                        if (p2.checkReserve() == -1) {
                            showMessageDialog(null, "You cant reserve more than 3 cards !");
                        } else {
                            p2.ReserveCards[p2.checkReserve()] = currentcards[3][1];
                            visitlabel[3][1] = false;
                            currentcards[3][1] = next[3];
                            updateCard(cards[3][next[3]]);
                            next[3]++;
                            p2.specialcoincount[5]++;
                            turn[0] = true;
                            ShowTurn(turn , currentTurn);
                        }
                    }
                    if (e.getSource() == lev3Res3) {
                        if (p2.checkReserve() == -1) {
                            showMessageDialog(null, "You cant reserve more than 3 cards !");
                        } else {
                            p2.ReserveCards[p2.checkReserve()] = currentcards[3][2];
                            visitlabel[3][2] = false;
                            currentcards[3][2] = next[3];
                            updateCard(cards[3][next[3]]);
                            next[3]++;
                            p2.specialcoincount[5]++;
                            turn[0] = true;
                            ShowTurn(turn , currentTurn);
                        }
                    }
                    if (e.getSource() == lev3Res4) {
                        if (p2.checkReserve() == -1) {
                            showMessageDialog(null, "You cant reserve more than 3 cards !");
                        } else {
                            p2.ReserveCards[p2.checkReserve()] = currentcards[3][1];
                            visitlabel[3][3] = false;
                            currentcards[3][3] = next[3];
                            updateCard(cards[3][next[3]]);
                            next[3]++;
                            p2.specialcoincount[5]++;
                            turn[0] = true;
                            ShowTurn(turn , currentTurn);
                        }
                    }
                }
                setplayertext(P1label, p1, 1);
                setplayertext(P2label, p2, 2);
            }
        };

        lev1Res1.addActionListener(Reservelistener);
        lev1Res2.addActionListener(Reservelistener);
        lev1Res3.addActionListener(Reservelistener);

        lev2Res1.addActionListener(Reservelistener);
        lev2Res2.addActionListener(Reservelistener);
        lev2Res3.addActionListener(Reservelistener);

        lev3Res1.addActionListener(Reservelistener);
        lev3Res2.addActionListener(Reservelistener);
        lev3Res3.addActionListener(Reservelistener);
    }

    public static void SetFalse() {
        lev1button1.setEnabled(false);
        lev1button2.setEnabled(false);
        lev1button3.setEnabled(false);
        lev1button4.setEnabled(false);

        lev2button1.setEnabled(false);
        lev2button2.setEnabled(false);
        lev2button3.setEnabled(false);
        lev2button4.setEnabled(false);

        lev3button1.setEnabled(false);
        lev3button2.setEnabled(false);
        lev3button3.setEnabled(false);
        lev3button4.setEnabled(false);

        lev1Res1.setEnabled(false);
        lev1Res2.setEnabled(false);
        lev1Res3.setEnabled(false);
        lev1Res4.setEnabled(false);

        lev2Res1.setEnabled(false);
        lev2Res2.setEnabled(false);
        lev2Res3.setEnabled(false);
        lev2Res4.setEnabled(false);

        lev3Res1.setEnabled(false);
        lev3Res2.setEnabled(false);
        lev3Res3.setEnabled(false);
        lev3Res4.setEnabled(false);

    }

    public static void SetTrue() {
        lev1button1.setEnabled(true);
        lev1button2.setEnabled(true);
        lev1button3.setEnabled(true);
        lev1button4.setEnabled(true);

        lev2button1.setEnabled(true);
        lev2button2.setEnabled(true);
        lev2button3.setEnabled(true);
        lev2button4.setEnabled(true);

        lev3button1.setEnabled(true);
        lev3button2.setEnabled(true);
        lev3button3.setEnabled(true);
        lev3button4.setEnabled(true);

        lev1Res1.setEnabled(true);
        lev1Res2.setEnabled(true);
        lev1Res3.setEnabled(true);
        lev1Res4.setEnabled(true);

        lev2Res1.setEnabled(true);
        lev2Res2.setEnabled(true);
        lev2Res3.setEnabled(true);
        lev2Res4.setEnabled(true);

        lev3Res1.setEnabled(true);
        lev3Res2.setEnabled(true);
        lev3Res3.setEnabled(true);
        lev3Res4.setEnabled(true);
    }

    public static void addPrize1(Card card, Player p1) {
        boolean sw = true;
        for (int i = 0; i < 5; i++) {
            if (p1.specialcoincount[i] < card.price[i]) {
                sw = false;
                break;
            }
        }

            if (sw) {
                p1.point += card.getPoint();
                cellPanel.remove(claw1);
                showMessageDialog(null , "Congrats you have won a prize card with " + card.point + " point");
            }

    }
    public static void addPrize2(Card card, Player p1) {
        boolean sw = true;
        for (int i = 0; i < 5; i++) {
            if (p1.specialcoincount[i] < card.price[i]) {
                sw = false;
                break;
            }
        }

        if (sw) {
            p1.point += card.getPoint();
            cellPanel.remove(claw2);
            showMessageDialog(null , "Congrats you have won a prize card with " + card.point + " point");
        }

    }
    public static void addPrize3(Card card, Player p1) {
        boolean sw = true;
        for (int i = 0; i < 5; i++) {
            if (p1.specialcoincount[i] < card.price[i]) {
                sw = false;
                break;
            }
        }

        if (sw) {
            p1.point += card.getPoint();
            cellPanel.remove(claw3);
            showMessageDialog(null , "Congrats you have won a prize card with " + card.point + " point");
        }

    }
}

