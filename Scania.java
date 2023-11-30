import java.awt.*;

public class Scania extends Truck{

    private double cargoAngle;

    public Scania() {super(2, 100, Color.cyan, "Scania");}

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

    @Override
    public double speedFactor(){
        return 1;
    }


}
