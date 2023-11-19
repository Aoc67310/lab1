import java.awt.*;
import java.util.Stack;
import java.lang.Math;

public class CarTransport extends Truck {

    // Instance variables

    private int nrOfCars = 0;

    private int maxNrCars = 5;

    private Car[] Cars = new Car[5];

    public Stack<Car> stk = new Stack<Car>();

    // Vehicle pickup method

    public void load(Car car){
        if (getCurrentSpeed() == 0.0 && getCargoAngle() == 1.0 && car.getCurrentSpeed() == 0.0 && nrOfCars <= maxNrCars) {
            if (Math.abs(car.getX() - getX()) <= 5 && Math.abs(car.getY() - getY()) <= 5) {
                stk.push(car);
                nrOfCars = nrOfCars + 1;
            }
        }
   }

   // Vehicle unload method

   public void unload() {
       if (getCurrentSpeed() == 0.0 && cargoAngle == 70 ) {
           stk.get(stk.size() -1 ).x = x + 1;
           stk.pop().y = y + 1;
           nrOfCars = nrOfCars - 1;

       }
   }

   public Stack<Car> getCargo(){
       return stk;
   }

   // Constructor

    public CarTransport() {
       super(2, 400, Color.black, "CarTransport");
   }

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
