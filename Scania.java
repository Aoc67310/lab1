import java.awt.*;

public class Scania extends Truck{

    public Scania() {super(2, 100, Color.cyan, "Scania");}


    @Override
    public double speedFactor(){
        return 1;
    }


}
