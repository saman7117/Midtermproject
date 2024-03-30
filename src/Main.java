import cardcoin.Card;
import playerslot.Player;
import playerslot.SlotMachine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static cardcoin.Card.BuyLevel1Cards;
import static cardcoin.Card.initstorepanel;
import static javax.swing.JOptionPane.showMessageDialog;
import static playerslot.Player.setplayertext;

public class Main  {


    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(1400 , 800);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ImageIcon titleiImage = new ImageIcon("Ap2.png");


        frame.setTitle("Amusement Park");
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.setIconImage(titleiImage.getImage());

        JPanel slotpanel = new JPanel(new GridLayout(5 , 1));
        JPanel P1panel = new JPanel();
        JPanel P2panel = new JPanel();
        JPanel Storepanel = new JPanel(new GridLayout(4 , 4, 20 , 0));
        JPanel tablepanel = new JPanel();
        tablepanel.setLayout(null);

        Card claw = new Card(0);



        slotpanel.setBackground(Color.lightGray);
        P1panel.setBackground(new Color(75 , 216 , 230));
        P2panel.setBackground(new Color(255 , 111 , 0));
        tablepanel.setBackground(new Color(1, 50, 32));
        Storepanel.setBackground(new Color(139 , 0 , 0));

        slotpanel.setPreferredSize(new Dimension(100 , 100));
        P1panel.setPreferredSize(new Dimension(200 , 100));
        P2panel.setPreferredSize(new Dimension(200 , 100));
        //tablepanel.setPreferredSize(new Dimension);
        Storepanel.setPreferredSize(new Dimension(860 , 400));

        Player player1 = new Player();
        Player player2 = new Player();
        Card [] Level1cards;
        Level1cards = new Card[15];
        Card [] Level2cards;
        Level2cards = new Card[15];
        Card [] Level3cards;
        Level3cards = new Card[15];
        for (int i = 0; i < Level1cards.length; i++) {
            Level1cards[i] = new Card(1);
            Level2cards[i] = new Card(2);
            Level3cards[i] = new Card(3);
        }

        Card [] prizecards;
        prizecards = new Card[3];
        for (int i = 0; i < prizecards.length; i++) {
            prizecards[i] = new Card(0);
        }


        JLabel P1label = new JLabel();

        setplayertext(P1label , player1 , 1);


        JLabel P2label = new JLabel();

        setplayertext(P2label , player2 , 2);


        initstorepanel(Storepanel);

            int[] passprice;
            passprice = new int[2];

        for (int i = 0; i < 4; i++) {
            for (int k = 0; k < 2; k++) {
                for (int j = 0; j < 5; j++) {
                    if (Level1cards[i].price[j] != 0)
                        passprice[k] = Level1cards[i].price[j];
                }
            }
            Level1cards[i].setCardlevel1Location(i, Level1cards[i].getPoint(), Level1cards[i].coin.color, Level1cards[i].colors[0], Level1cards[i].colors[1] , passprice[0] , passprice[1]);
        }


        for (int i = 0; i < 4; i++) {
            for (int k = 0; k < 2; k++) {
                for (int j = 0; j < 5; j++) {
                    if (Level2cards[i].price[j] != 0)
                        passprice[k] = Level1cards[i].price[j];
                }
            }
            Level2cards[i].setCardlevel2Location(i, Level2cards[i].getPoint(), Level2cards[i].coin.color, Level2cards[i].colors[0], Level2cards[i].colors[1] , passprice[0] , passprice[1]);
        }


        for (int i = 0; i < 4; i++) {
            for (int k = 0; k < 2; k++) {
                for (int j = 0; j < 5; j++) {
                    if (Level3cards[i].price[j] != 0)
                        passprice[k] = Level3cards[i].price[j];
                }
            }
            Level3cards[i].setCardlevel3Location(i, Level3cards[i].getPoint(), Level3cards[i].coin.color, Level3cards[i].colors[0], Level3cards[i].colors[1] , passprice[0] , passprice[1]);
        }

        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 2; k++) {
                for (int j = 0; j < 5; j++) {
                    if (prizecards[i].price[j] != 0)
                        passprice[k] = prizecards[i].price[j];
                }
            }
            prizecards[i].setCardlevel0ocation(i, prizecards[i].getPoint(), prizecards[i].colors[0] ,  prizecards[i].colors[1] , passprice[0] , passprice[1]);
        }

        P1label.setForeground(Color.BLACK);
        P2label.setForeground(Color.BLACK);
        P1panel.add(P1label);
        P2panel.add(P2label);


        frame.add(slotpanel , BorderLayout.WEST);
        frame.add(P1panel , BorderLayout.SOUTH);
        frame.add(P2panel , BorderLayout.NORTH);
        frame.add(Storepanel , BorderLayout.EAST);
        frame.add(tablepanel , BorderLayout.CENTER);



        JButton button0 = new JButton();
        JButton button1 = new JButton();
        JButton button2 = new JButton();
        JButton button3 = new JButton();
        JButton button4 = new JButton();




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
        JToggleButton P1draw2 = new JToggleButton("draw 2" , false);
        P1draw2.setBounds(170 , 520 , 80 , 30);
        JToggleButton P2draw2 = new JToggleButton("draw 2" , false);
        P2draw2.setBounds(170 , 10 , 80 , 30);

        //clawbutton1.setFocusable(false);
        /*clawbutton2.setFocusable(false);
        clawbutton3.setFocusable(false);
        lev1button1.setFocusable(false);
        lev1button2.setFocusable(false);
        lev1button3.setFocusable(false);
        lev1button4.setFocusable(false);
        lev2button1.setFocusable(false);
        lev2button2.setFocusable(false);
        lev2button3.setFocusable(false);
        lev2button4.setFocusable(false);
        lev3button1.setFocusable(false);
        lev3button2.setFocusable(false);
        lev3button3.setFocusable(false);
        lev3button4.setFocusable(false);*/


        button1.setText(red.count + "/4");
        button0.setText(green.count + "/4");
        button2.setText(blue.count + "/4");
        button3.setText(black.count + "/4");
        button4.setText(white.count + "/4");

        slotpanel.add(button0);
        slotpanel.add(button1);
        slotpanel.add(button2);
        slotpanel.add(button3);
        slotpanel.add(button4);
        P1draw2.setBackground(Color.RED);
        tablepanel.add(P1draw2 , BorderLayout.SOUTH);
        tablepanel.add(P2draw2);
        final boolean[] playerturn = {true};  // true = P1  ,  false = P2

        ActionListener slotlistener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean check = false;

                if (playerturn[0]) {
                    if (P1draw2.isSelected() == true) {
                        if (red.checkfullslotmachine(blue, green, white, black) == true){
                            check = true;
                            //P1draw2.setSelected(true);
                            if (e.getSource() == button0) {
                                green.drawCoinsFromSameMachine(player1, 0);
                                button0.setText(green.count + "/4");
                                playerturn[0] = false;
                            } else if (e.getSource() == button1) {
                                red.drawCoinsFromSameMachine(player1, 1);
                                button1.setText(red.count + "/4");
                                playerturn[0] = false;
                            } else if (e.getSource() == button2) {
                                blue.drawCoinsFromSameMachine(player1, 2);
                                button2.setText(blue.count + "/4");
                                playerturn[0] = false;
                            } else if (e.getSource() == button3) {
                                black.drawCoinsFromSameMachine(player1, 3);
                                button3.setText(black.count + "/4");
                                playerturn[0] = false;
                            } else if (e.getSource() == button4) {
                                white.drawCoinsFromSameMachine(player1, 4);
                                button4.setText(white.count + "/4");
                                playerturn[0] = false;
                            }

                        }
                        else if (red.checkfullslotmachine(blue, green, white, black) == false){
                            P1draw2.setSelected(false);

                            showMessageDialog(null , "There is no full slot Machine");
                        }
                    }
                        else  {
                        int count = 0;

                            if (e.getSource() == button0) {
                                count++;
                                green.drawCoinsFromDifferentMachines(player1, 0 , count , playerturn[0]);
                                button0.setText(green.count + "/4");

                            } else if (e.getSource() == button1) {
                                count ++;
                                red.drawCoinsFromDifferentMachines(player1, 1 , count , playerturn[0]);
                                button1.setText(red.count + "/4");
                            } else if (e.getSource() == button2) {
                                count++;
                                blue.drawCoinsFromDifferentMachines(player1, 2 , count , playerturn[0]);
                                button2.setText(blue.count + "/4");
                            } else if (e.getSource() == button3) {
                                count ++;
                                black.drawCoinsFromDifferentMachines(player1, 3 , count , playerturn[0]);
                                button3.setText(black.count + "/4");
                            } else if (e.getSource() == button4) {
                                count++;
                                white.drawCoinsFromDifferentMachines(player1, 4 , count , playerturn[0]);
                                button4.setText(white.count + "/4");
                            }

                    }
                    setplayertext(P1label , player1 , 1);
                }


                if (!playerturn[0]) {
                    if (P2draw2.isSelected() == true) {
                        if (red.checkfullslotmachine(blue, green, white, black) == true){
                            check = true;
                            //P1draw2.setSelected(true);
                            if (e.getSource() == button0) {
                                green.drawCoinsFromSameMachine(player2, 0);
                                button0.setText(green.count + "/4");
                                playerturn[0] = true;
                            } else if (e.getSource() == button1) {
                                red.drawCoinsFromSameMachine(player2, 1);
                                button1.setText(red.count + "/4");
                                playerturn[0] = true;
                            } else if (e.getSource() == button2) {
                                blue.drawCoinsFromSameMachine(player2, 2);
                                button2.setText(blue.count + "/4");
                                playerturn[0] = true;
                            } else if (e.getSource() == button3) {
                                black.drawCoinsFromSameMachine(player2, 3);
                                button3.setText(black.count + "/4");
                                playerturn[0] = true;
                            } else if (e.getSource() == button4) {
                                white.drawCoinsFromSameMachine(player2, 4);
                                button4.setText(white.count + "/4");
                                playerturn[0] = true;
                            }

                        }
                        else if (red.checkfullslotmachine(blue, green, white, black) == false){
                            P2draw2.setSelected(false);

                            showMessageDialog(null , "There is no full slot Machine");
                        }
                    }
                    else  {
                        int count = 0;

                        if (e.getSource() == button0) {
                            count++;
                            green.drawCoinsFromDifferentMachines(player2, 0 , count , playerturn[0]);
                            button0.setText(green.count + "/4");

                        } else if (e.getSource() == button1) {
                            count ++;
                            red.drawCoinsFromDifferentMachines(player2, 1 , count , playerturn[0]);
                            button1.setText(red.count + "/4");
                        } else if (e.getSource() == button2) {
                            count++;
                            blue.drawCoinsFromDifferentMachines(player2, 2 , count , playerturn[0]);
                            button2.setText(blue.count + "/4");
                        } else if (e.getSource() == button3) {
                            count ++;
                            black.drawCoinsFromDifferentMachines(player2, 3 , count , playerturn[0]);
                            button3.setText(black.count + "/4");
                        } else if (e.getSource() == button4) {
                            count++;
                            white.drawCoinsFromDifferentMachines(player2, 4 , count , playerturn[0]);
                            button4.setText(white.count + "/4");
                        }

                    }
                    setplayertext(P2label , player2 , 2);
                }
            }
        };
        int [] addslot;
        addslot = new int[5];
        BuyLevel1Cards(player1 , player2 , playerturn[0], Level1cards , P1label , addslot);
        red.addcoin(green ,blue , black , white , addslot);
        red.setSlotmachineText(green ,blue , black , white , button1 , button0 , button2 , button3 , button4);





        button0.addActionListener(slotlistener);
        button1.addActionListener(slotlistener);
        button2.addActionListener(slotlistener);
        button3.addActionListener(slotlistener);
        button4.addActionListener(slotlistener);
        P1draw2.addActionListener(slotlistener);

        frame.setVisible(true);
    }

}
