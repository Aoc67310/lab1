import java.awt.*;

public class Scania extends Truck{

    public Scania() {super(2, 400, Color.cyan, "Scania");}

    @Override
    public double speedFactor(){
        return 1;
    }


}
