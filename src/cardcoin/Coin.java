package cardcoin;
import cardcoin.Card;

import java.util.Random;

public class Coin {
    public String color;
    int price;
    public Coin(){
        Random random = new Random();
        int k = random.nextInt(5);
        if (k == 0)
            this.color = "green";
        else if (k == 1) {
            this.color = "red";
        } else if (k == 2) {
            this.color = "blue";
        } else if (k==3) {
            this.color = "white";
        } else if (k == 4) {
            this.color = "black";
        }

    }
}
