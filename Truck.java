import java.awt.*;

public abstract class Truck extends Vehicle{

    protected double cargoAngle;
    public Truck(int nrDoors, double enginePower, Color color, String modelName) {
        super(nrDoors, enginePower, color, modelName);
    } // constructor


}