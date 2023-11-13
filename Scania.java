import java.awt.*;

public class Scania extends Car{

    private double cargoAngle;

    public Scania() {super(4, 400, Color.cyan, "Scania");}

    @Override
    public double speedFactor(){
        return 1;
    }

    // Returns the angle off the cargo
    public double getCargoAngle(){
        return cargoAngle;
    }

    //increase the angle of the cargo
    public void increaseCargoAngle(double amount){
        if (amount + cargoAngle <= 70 && amount + cargoAngle > 0 && currentSpeed == 0.0) {
            cargoAngle = cargoAngle + amount;
        }
    }

    //decrease the angle of the cargo
    public void  decreaseCargoAngle(double amount){
        if (cargoAngle - amount <= 70 && cargoAngle - amount > 0 && currentSpeed == 0.0) {
            cargoAngle = cargoAngle - amount;
        }
    }
    @Override
    public void gas(double amount){
        if (cargoAngle == 0.0) {
            currentSpeed = Math.min(currentSpeed + amount, enginePower);
        }

    }

}
