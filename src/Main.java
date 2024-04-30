import cardcoin.Card;
import playerslot.Player;
import playerslot.SlotMachine;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static cardcoin.Card.*;
import static javax.swing.JOptionPane.showMessageDialog;
import static playerslot.Player.*;

public class Main  {


    public static void main(String[] args) throws UnsupportedAudioFileException , IOException , LineUnavailableException {
        JFrame frame = new JFrame();
        frame.setSize(1400, 800);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ImageIcon titleiImage = new ImageIcon("Ap2.png");

        File file = new File("Sakura-Girl-Daisy-chosic.com_.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        clip.start();
        frame.setTitle("Amusement Park");
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.setIconImage(titleiImage.getImage());

        JPanel slotpanel = new JPanel(new GridLayout(5, 1));
        JPanel P1panel = new JPanel();
        JPanel P2panel = new JPanel();
        JPanel Storepanel = new JPanel(new GridLayout(4, 4, 20, 0));
        JPanel tablepanel = new JPanel(new BorderLayout());
        tablepanel.setLayout(null);

        Card claw = new Card(0);


        slotpanel.setBackground(Color.lightGray);
        P1panel.setBackground(new Color(75, 216, 230));
        P2panel.setBackground(new Color(255, 111, 0));
        tablepanel.setBackground(new Color(1, 50, 32));
        Storepanel.setBackground(new Color(139, 0, 0));

        slotpanel.setPreferredSize(new Dimension(100, 100));
        P1panel.setPreferredSize(new Dimension(200, 100));
        P2panel.setPreferredSize(new Dimension(200, 100));
        //tablepanel.setPreferredSize(new Dimension);
        Storepanel.setPreferredSize(new Dimension(860, 400));

        Player player1 = new Player();
        Player player2 = new Player();
        Card[] Level1cards;
        Level1cards = new Card[15];
        Card[] Level2cards;
        Level2cards = new Card[15];
        Card[] Level3cards;
        Level3cards = new Card[15];
        for (int i = 0; i < Level1cards.length; i++) {
            Level1cards[i] = new Card(1);
            Level2cards[i] = new Card(2);
            Level3cards[i] = new Card(3);
        }

        Card[] prizecards;
        prizecards = new Card[3];
        for (int i = 0; i < prizecards.length; i++) {
            prizecards[i] = new Card(0);
        }

        Card[][] cards = new Card[4][15];
        for (int i = 0; i < 15; i++) {
            cards[1][i] = new Card(1);
            cards[2][i] = new Card(2);
            cards[3][i] = new Card(3);
        }

        for (int i = 0; i < 3; i++) {
            cards[0][i] = new Card(0);
        }

        JLabel P1label = new JLabel();

        setplayertext(P1label, player1, 1);


        JLabel P2label = new JLabel();

        setplayertext(P2label, player2, 2);


        initstorepanel(Storepanel);

        int j = 0;
        int k = 0;
        for (int i = 0; i < 4; i++) {
            int[] passprice = new int[2];
            k = 0;
            for (j = 0; j < 5; j++) {
                if (cards[1][i].price[j] != 0) {
                    passprice[k] = cards[1][i].price[j];
                    k++;
                }
            }


            cards[1][i].setCardlevel1Location(i, cards[1][i].getPoint(), cards[1][i].coin.color, cards[1][i].colors[0], cards[1][i].colors[1], passprice[0], passprice[1]);
        }


        for (int i = 0; i < 4; i++) {
            int[] passprice = new int[2];
            k = 0;
            for (j = 0; j < 5; j++) {
                if (cards[2][i].price[j] != 0) {
                    passprice[k] = cards[2][i].price[j];
                    k++;
                }
            }
            cards[2][i].setCardlevel2Location(i, cards[2][i].getPoint(), cards[2][i].coin.color, cards[2][i].colors[0], cards[2][i].colors[1], passprice[0], passprice[1]);
        }


        for (int i = 0; i < 4; i++) {
            int[] passprice = new int[3];
            k = 0;
            for (j = 0; j < 5; j++) {
                if (cards[3][i].price[j] != 0) {
                    passprice[k] = cards[3][i].price[j];
                    k++;
                }
            }

            cards[3][i].setCardlevel3Location(i, cards[3][i].getPoint(), cards[3][i].coin.color, cards[3][i].colors[0], cards[3][i].colors[1], cards[3][i].colors[2], passprice[0], passprice[1], passprice[2]);
        }

        for (int i = 0; i < 3; i++) {
            int [] passprice = new int[2];
            k = 0;
            for (j = 0; j < 5; j++) {
                if (cards[0][i].price[j] != 0) {
                    passprice[k] = cards[0][i].price[j];
                    k++;
                }
            }

            cards[0][i].setCardlevel0ocation(i, cards[0][i].getPoint(), cards[0][i].colors[0], cards[0][i].colors[1], passprice[0], passprice[1]);
        }




        P1label.setForeground(Color.BLACK);
        P2label.setForeground(Color.BLACK);
        P1panel.add(P1label);
        P2panel.add(P2label);


        frame.add(slotpanel, BorderLayout.WEST);
        frame.add(P1panel, BorderLayout.SOUTH);
        frame.add(P2panel, BorderLayout.NORTH);
        frame.add(Storepanel, BorderLayout.EAST);
        frame.add(tablepanel, BorderLayout.CENTER);

        JLabel CurrentTurn = new JLabel();
        CurrentTurn.setText("Turn : Player 1");
        CurrentTurn.setBackground(Color.RED);
        CurrentTurn.setForeground(Color.CYAN);
        CurrentTurn.setBounds(0 , 100 , 200 , 200);

        JButton button0 = new JButton();
        JButton button1 = new JButton();
        JButton button2 = new JButton();
        JButton button3 = new JButton();
        JButton button4 = new JButton();

        JButton P1Res1 = new JButton("1");
        JButton P1Res2 = new JButton("2");
        JButton P1Res3 = new JButton("3");

        JButton P2Res1 = new JButton("1");
        JButton P2Res2 = new JButton("2");
        JButton P2Res3 = new JButton("3");

        SlotMachine red = new SlotMachine();
        SlotMachine blue = new SlotMachine();
        SlotMachine green = new SlotMachine();
        SlotMachine black = new SlotMachine();
        SlotMachine white = new SlotMachine();

        button1.setBackground(Color.RED);
        button0.setBackground(Color.GREEN);
        button2.setBackground(Color.blue);
        button3.setBackground(Color.BLACK);
        button4.setBackground(Color.white);

        button1.setFocusable(false);
        button2.setFocusable(false);
        button3.setFocusable(false);
        button4.setFocusable(false);
        button0.setFocusable(false);
        JToggleButton P1draw2 = new JToggleButton("draw 2", false);
        P1draw2.setBounds(170, 520, 80, 30);
        JToggleButton P2draw2 = new JToggleButton("draw 2", false);
        P2draw2.setBounds(170, 10, 80, 30);




        button1.setText(red.count + "/4");
        button0.setText(green.count + "/4");
        button2.setText(blue.count + "/4");
        button3.setText(black.count + "/4");
        button3.setForeground(Color.white);
        button4.setText(white.count + "/4");

        slotpanel.add(button0);
        slotpanel.add(button1);
        slotpanel.add(button2);
        slotpanel.add(button3);
        slotpanel.add(button4);

        P1panel.add(P1Res1);
        P1panel.add(P1Res2);
        P1panel.add(P1Res3);

        P2panel.add(P2Res1);
        P2panel.add(P2Res2);
        P2panel.add(P2Res3);
        P1draw2.setBackground(Color.RED);
        tablepanel.add(P1draw2, BorderLayout.SOUTH);
        tablepanel.add(P2draw2);
        tablepanel.add(CurrentTurn);
        boolean[] playerturn = {true};  // true = P1  ,  false = P2
        final int[] count = {-1};
        boolean [] SlotStatus = new boolean[5];  //  green = 0     red = 1      blue = 2     black = 3    white = 4
        ActionListener slotlistener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean check = false;
                if (playerturn[0] && player1.calcutecoincount() <= 10) {
                    if (P1draw2.isSelected() == false) {
                        SetFalse();
                        P1draw2.setEnabled(false);
                        if (e.getSource() == button0) {

                            if (!SlotStatus[0]) {

                                count[0]++;
                                green.drawCoinsFromDifferentMachines(player1, 0, count, playerturn, SlotStatus , P1draw2);
                                green.setslotText(button0);
                            }
                        } else if (e.getSource() == button1) {
                            if (!SlotStatus[1]) {

                                count[0]++;
                                red.drawCoinsFromDifferentMachines(player1, 1, count, playerturn, SlotStatus , P1draw2);
                                red.setslotText(button1);
                            }
                        } else if (e.getSource() == button2) {
                            if (!SlotStatus[2]) {

                                count[0]++;
                                blue.drawCoinsFromDifferentMachines(player1, 2, count, playerturn, SlotStatus , P1draw2);
                                blue.setslotText(button2);
                            }
                        } else if (e.getSource() == button3) {
                            if (!SlotStatus[3]) {

                                count[0]++;
                                black.drawCoinsFromDifferentMachines(player1, 3, count, playerturn, SlotStatus , P1draw2);
                                black.setslotText(button3);
                            }
                        } else if (e.getSource() == button4) {
                            if (!SlotStatus[4]) {

                                count[0]++;
                                white.drawCoinsFromDifferentMachines(player1, 4, count, playerturn, SlotStatus , P1draw2);
                                white.setslotText(button4);
                            }
                        }

                    } else if (P1draw2.isSelected() == true) {
                        if (red.checkfullslotmachine(blue, green, white, black) == true) {
                            SetFalse();
                            if (e.getSource() == button0 && green.checkcurrentslotmachine()) {
                                green.drawCoinsFromSameMachine(player1, 0);
                                button0.setText(green.count + "/4");
                                P1draw2.setSelected(false);
                                playerturn[0] = false;
                                SetTrue();
                            } else if (e.getSource() == button1 && red.checkcurrentslotmachine()) {
                                red.drawCoinsFromSameMachine(player1, 1);
                                button1.setText(red.count + "/4");
                                P1draw2.setSelected(false);
                                playerturn[0] = false;
                                SetTrue();
                            } else if (e.getSource() == button2 && blue.checkcurrentslotmachine()) {
                                blue.drawCoinsFromSameMachine(player1, 2);
                                button2.setText(blue.count + "/4");
                                P1draw2.setSelected(false);
                                playerturn[0] = false;
                                SetTrue();
                            } else if (e.getSource() == button3 && black.checkcurrentslotmachine()) {
                                black.drawCoinsFromSameMachine(player1, 3);
                                button3.setText(black.count + "/4");
                                P1draw2.setSelected(false);
                                playerturn[0] = false;
                                SetTrue();
                            } else if (e.getSource() == button4 && white.checkcurrentslotmachine()) {
                                white.drawCoinsFromSameMachine(player1, 4);
                                button4.setText(white.count + "/4");
                                P1draw2.setSelected(false);
                                playerturn[0] = false;
                                SetTrue();
                            }

                        } else if (red.checkfullslotmachine(blue, green, white, black) == false) {
                            P1draw2.setSelected(false);

                            showMessageDialog(null, "There is no full slot Machine");
                        }
                    }

                    P2draw2.setSelected(false);
                    setplayertext(P1label, player1, 1);
                    ShowTurn(playerturn , CurrentTurn);
                }
                else if (!playerturn[0] && player2.calcutecoincount() <= 10) {
                    if (P2draw2.isSelected() == false) {

                        P2draw2.setEnabled(false);
                        SetFalse();
                        if (e.getSource() == button0) {
                            if (!SlotStatus[0]) {
                                count[0]++;
                                green.drawCoinsFromDifferentMachines(player2, 0, count, playerturn, SlotStatus , P2draw2);
                                green.setslotText(button0);
                            }
                        } else if (e.getSource() == button1) {
                            if (!SlotStatus[1]) {
                                count[0]++;
                                red.drawCoinsFromDifferentMachines(player2, 1, count, playerturn, SlotStatus , P2draw2);
                                red.setslotText(button1);
                            }
                        } else if (e.getSource() == button2) {
                            if (!SlotStatus[2]) {
                                count[0]++;
                                blue.drawCoinsFromDifferentMachines(player2, 2, count, playerturn, SlotStatus , P2draw2);
                                blue.setslotText(button2);
                            }
                        } else if (e.getSource() == button3) {
                            if (!SlotStatus[3]) {
                                count[0]++;
                                black.drawCoinsFromDifferentMachines(player2, 3, count, playerturn, SlotStatus , P2draw2);
                                black.setslotText(button3);
                            }
                        } else if (e.getSource() == button4) {
                            if (!SlotStatus[4]) {
                                count[0]++;
                                white.drawCoinsFromDifferentMachines(player2, 4, count, playerturn, SlotStatus , P2draw2);
                                white.setslotText(button4);
                            }
                        }
                    } else if (P2draw2.isSelected() == true) {
                        if (red.checkfullslotmachine(blue, green, white, black) == true) {
                            SetFalse();
                            if (e.getSource() == button0 && green.checkcurrentslotmachine()) {
                                green.drawCoinsFromSameMachine(player2, 0);
                                button0.setText(green.count + "/4");
                                P2draw2.setSelected(false);
                                playerturn[0] = true;
                                SetTrue();
                            } else if (e.getSource() == button1 && red.checkcurrentslotmachine()) {
                                red.drawCoinsFromSameMachine(player2, 1);
                                button1.setText(red.count + "/4");
                                P2draw2.setSelected(false);
                                playerturn[0] = true;
                                SetTrue();
                            } else if (e.getSource() == button2 && blue.checkcurrentslotmachine()) {
                                blue.drawCoinsFromSameMachine(player2, 2);
                                button2.setText(blue.count + "/4");
                                P2draw2.setSelected(false);
                                playerturn[0] = true;
                                SetTrue();
                            } else if (e.getSource() == button3 && black.checkcurrentslotmachine()) {
                                black.drawCoinsFromSameMachine(player2, 3);
                                button3.setText(black.count + "/4");
                                P2draw2.setSelected(false);
                                playerturn[0] = true;
                                SetTrue();
                            } else if (e.getSource() == button4 && white.checkcurrentslotmachine()) {
                                white.drawCoinsFromSameMachine(player2, 4);
                                button4.setText(white.count + "/4");
                                P2draw2.setSelected(false);
                                playerturn[0] = true;
                                SetTrue();
                            }

                        } else if (red.checkfullslotmachine(blue, green, white, black) == false) {
                            P2draw2.setSelected(false);

                            showMessageDialog(null, "There is no full slot Machine");
                        }
                    }
                    P2draw2.setSelected(false);
                    setplayertext(P2label, player2, 2);
                    ShowTurn(playerturn , CurrentTurn);
                }
            }
        };

        int Next[] = new int[4];
        for (int i = 0; i < Next.length; i++) {
            Next[i] = 4;
        }

        int[] addslot;
        addslot = new int[5];
        BuyCards(player1, player2, playerturn, cards, P1label, Next, green, red, blue, black, white, button0, button1, button2, button3, button4 , frame);
        ReserveCards(player1, player2, playerturn, cards, P1label ,P2label , Next , CurrentTurn);

        ActionListener BuyReserveCards = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean sw = false;
                if (e.getSource() == P1Res1) {
                    for (int i = 0; i < 5; i++) {
                        if ((player1.specialcoincount[i] + player1.coincount[i]) < cards[1][player1.ReserveCards[0]].price[i])
                            sw = true;
                    }
                    if (sw == true)
                        showMessageDialog(null, "You cant buy this card");
                    else {
                        if (cards[1][player1.ReserveCards[0]].coin.color == "green") {
                            player1.specialcoincount[0]++;
                        } else if (cards[1][player1.ReserveCards[0]].coin.color == "red") {
                            player1.specialcoincount[1]++;
                        } else if (cards[1][player1.ReserveCards[0]].coin.color == "blue") {
                            player1.specialcoincount[2]++;
                        } else if (cards[1][player1.ReserveCards[0]].coin.color == "black") {
                            player1.specialcoincount[3]++;
                        } else if (cards[1][player1.ReserveCards[0]].coin.color == "white") {
                            player1.specialcoincount[4]++;
                        }

                        for (int i = 0; i < 5; i++) {
                            player1.coincount[i] -= cards[1][player1.ReserveCards[0]].price[i];
                            if (player1.coincount[i] < 0)
                                player1.coincount[i] = 0;
                        }
                        green.count += cards[1][player1.ReserveCards[0]].price[0];
                        red.count += cards[1][player1.ReserveCards[0]].price[1];
                        blue.count += cards[1][player1.ReserveCards[0]].price[2];
                        black.count += cards[1][player1.ReserveCards[0]].price[3];
                        white.count += cards[1][player1.ReserveCards[0]].price[4];

                        green.setslotText(button0);
                        red.setslotText(button1);
                        blue.setslotText(button2);
                        black.setslotText(button3);
                        white.setslotText(button4);

                        player1.point += cards[1][player1.ReserveCards[0]].getPoint();
                        player1.ReserveCards[0] = -10;
                        player1.specialcoincount[5] --;

                    }

                }
            setplayertext(P1label, player1, 1);
                ShowTurn(playerturn , CurrentTurn);
            }
        };



        P1Res1.addActionListener(BuyReserveCards);


        button0.addActionListener(slotlistener);
        button1.addActionListener(slotlistener);
        button2.addActionListener(slotlistener);
        button3.addActionListener(slotlistener);
        button4.addActionListener(slotlistener);
        P1draw2.addActionListener(slotlistener);

        frame.setVisible(true);

    }

}
