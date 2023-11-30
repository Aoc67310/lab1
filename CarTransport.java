import org.junit.runner.manipulation.Ordering;

import java.awt.*;
import java.util.Stack;
import java.lang.Math;

public class CarTransport extends Truck {

    protected int nrOfCars;

    boolean gateOpen;

    protected Stack<Car> carStack = new Stack<>();

    protected CarTransport() {super(2, 400, Color.black, "Cartransport");} //constructor

    protected int getNrOfCars() {
        return nrOfCars;
    }

    public Stack<Car> getCargo(){
        return carStack;
    }
    // 1 represents an open cargo gate, 0 represents a closed cargo gate.
    @Override
    public double getCargoAngle(){
        if (cargoAngle == 70){
            return 1.0;
        } else {return 0.0;}
    }

    public void openGate(){
        if ( currentSpeed == 0.0) {
            gateOpen = true;
        }
    }
    public void closeGate(){
        if (currentSpeed == 0.0){
            gateOpen = false;
        }
    }

    public void addCar(Car car) {
        if (gateOpen) {
            carStack.push(car);
            nrOfCars++;
            System.out.println(car.getModelName() + " added to the car transport.");
        } else {
            System.out.println("Open the cargo gate before adding a car.");
        }
    }

    public void removeCar() {
        if (gateOpen) {
            if (!carStack.isEmpty()) {
                carStack.get(carStack.size() - 1 ).point.x = point.x + 1;
                carStack.pop().point.y = point.y + 1;
                nrOfCars--;
            } else {
                System.out.println("No cars to remove from the car transport.");
            }
        } else {
            System.out.println("Open the cargo gate before removing a car.");
        }
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
                point.x += speed;
                break;
            case 90:
                point.y += speed;
                break;
            case 180:
                point.x -= speed;
                break;
            case 270:
                point.y -= speed;
                break;
        }
        for (int i = 0; i < nrOfCars ; i++){
            carStack.get(i).point.x = point.x;
            carStack.get(i).point.y = point.y;
        }
    }
}