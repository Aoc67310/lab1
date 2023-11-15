import java.awt.*;

public abstract class Truck extends Vehicle{

    protected double cargoAngle;
    public Truck(int nrDoors, double enginePower, Color color, String modelName) {
        super(nrDoors, enginePower, color, modelName);
    } // constructor

    public double getCargoAngle(){
        return cargoAngle;
    }

    public void increaseCargoAngle(double amount){
        if (amount + cargoAngle <= 70 && amount + cargoAngle > 0 && currentSpeed == 0.0) {
            cargoAngle = cargoAngle + amount;
        }
    }
    public void  decreaseCargoAngle(double amount){
        if (cargoAngle - amount <= 70 && cargoAngle - amount >= 0 && currentSpeed == 0.0) {
            cargoAngle = cargoAngle - amount;
        }
    }

    @Override
    public void gas(double amount){
        if (cargoAngle == 0.0) {
            currentSpeed = Math.min(currentSpeed + amount, enginePower);
        } else {System.out.println(" Cargogate is not closed");}

    }
}
