package playerslot;

import cardcoin.*;

import javax.swing.*;

import static javax.swing.JOptionPane.showMessageDialog;

public class SlotMachine {
    String color;
    Coin coin[] = new Coin[4];
    public int count = 4;


    public void drawCoinsFromSameMachine(Player p , int colornum) {
        if (this.count >= 2){
            this.count -=2;
        p.coincount[colornum] +=2;}
        else {
            showMessageDialog(null , "Not enough coin to draw :(");
        }
    }

    public void drawCoinsFromDifferentMachines(Player p , int colornum , int count , boolean turn) {
        if (count < 3) {
            if (this.count >= 1) {
                this.count--;
                p.coincount[colornum]++;
            } else
                showMessageDialog(null, "Not enough coin to draw");
        }
       else  if (count == 3)
            turn = !turn;
       return;

    }

    public boolean checkfullslotmachine (SlotMachine blue , SlotMachine green , SlotMachine white , SlotMachine black){
       if (this.count == 4 || blue.count ==4 || black.count == 4 || white.count ==4 || green.count == 4)
           return true;
       else
           return false;
    }

    public void setSlotmachineText (SlotMachine blue , SlotMachine green , SlotMachine white , SlotMachine black , JButton redbutton , JButton greenbutton , JButton bluebutton , JButton whitebutton , JButton blackbutton){
        greenbutton.setText(green.count + "/4");
        redbutton.setText(this.count + "/4");
        bluebutton.setText(blue.count + "/4");
        blackbutton.setText(black.count + "/4");
        whitebutton.setText(white.count + "/4");
        /*System.out.println(blue.count);
        System.out.println(black.count);
        System.out.println(green.count);*/
    }

    public void addcoin(SlotMachine blue , SlotMachine green , SlotMachine white , SlotMachine black , int [] slot){
        if (green.count + slot[0] <= 4)
                green.count += slot[0];
        if (this.count + slot[1] <= 4)
            this.count += slot[1];
        if (blue.count + slot[2] <= 4)
            blue.count += slot[2];
        if (black.count + slot[3] <= 4)
            black.count += slot[3];
        if (white.count + slot[4] <= 4)
            white.count += slot[4];



    }
}
