import java.awt.*;
import java.util.Stack;
import java.lang.Math;

public class CarTransport extends Truck {

    protected int nrOfCars;

    public Stack<Objects> stk = new Stack<>();

    public CarTransport() {super(2, 400, Color.black, "Cartransport");} //constructor

    public int getNrOfCars() {
        return nrOfCars;
    }

    // 1 represents an open cargo gate, 0 represents a closed cargo gate.
    @Override
    public double getCargoAngle(){
        if (cargoAngle == 70){
            return 1.0;
        } else {return 0.0;}
    }

    public void openCargo(){
        cargoAngle = 70;
    }

    public void closeCargo(){
        cargoAngle = 0;
    }

    public void addCar(){
    }

    @Override
    public void increaseCargoAngle(double amount){
        System.out.println("You can only open the cargo gate fully with openCargo ");
    }
    @Override
    public void  decreaseCargoAngle(double amount){
        System.out.println("Wou can only close the cargo gate fully with closeCargo ");
    }

    @Override
    public double speedFactor(){
        return 1;
    }

    @Override
    public void move(){
        double speed = getCurrentSpeed();
        switch (direction){
            case 0:
                x += speed;
                break;
            case 90:
                y += speed;
                break;
            case 180:
                x -= speed;
                break;
            case 270:
                y -= speed;
                break;
        }
        for (int i = 0; i < nrOfCars ; i++){
            stk.get(i).x = x;
            stk.get(i).y = y;
        }
    }


}
