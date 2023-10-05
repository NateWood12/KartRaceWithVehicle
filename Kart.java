import java.io.Console;
import java.util.Random;
public class Kart extends Vehicle{
    public Kart(String brand, int speed) {super(brand, speed);}
    private static Random rand = new Random();
    private SpecialItem[] Items = new SpecialItem[3];
    private SpecialItem lastAttack;
    public Kart(int speed) {
        super("Mario Kart", speed);
        Items[0] = new SpecialItem("Green Shell", 5, ConsoleColors.RED);
        Items[0] = new SpecialItem("Boomerang", 7, ConsoleColors.BLUE);
        Items[0] = new SpecialItem("Banana", 1, ConsoleColors.YELLOW);
    }

    public int attack(){
        int num1 = detailedAttack();
        if (num1 == 0) {
            return 7;
        }else if (num1 == 1) {
            return 5;
        } else if (num1 == 2) {
            return 1;
        } else {
            return 0;
        }
    }

    public int detailedAttack() {
        int ItemUsed = rand.nextInt(Items.length);
        lastAttack = Items[ItemUsed];
        return ItemUsed;


    }
}
