import java.util.ArrayList;
import java.awt.*;
import java.util.Collection;
import java.util.Observable;
import java.util.Observer;

public class Carmodel {

    ArrayList<Vehicle> cars = new ArrayList<>();

    CarFactory cf = new CarFactory();

    private  ArrayList<Observer> observers = new ArrayList<>();

    public void createcars() {
        cars.add(new Volvo240());
        cars.add(new Saab95());
        cars.add(new Scania());
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).setPoint(0, 50 * i);
        }
    }
    public void addobserver(Observer observer){
        observers.add(observer);
    }
    public void notifyObservers(){
        for (Observer observer: observers)
        {
            observer.update((Observable) observer, cars);
        }
    }

    public void Checkcollison() {
        for (Vehicle vehicle : cars) {
            vehicle.move();
            // Checks if the vehicles have collided with any walls and sends them back 180 degrees
            // in the opposite direction
            if (vehicle.getPoint().x > 700.0 || vehicle.getPoint().x < 0.0) {
                vehicle.turnRight();
                vehicle.turnRight();
            }
        }
    }

    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : cars
        ) {
            vehicle.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle vehicle : cars
        ) {
            vehicle.brake(brake);
        }
    }

    void setTurboOn() {
        for (Vehicle vehicle : cars) {
            if (vehicle instanceof Saab95) {
                ((Saab95) vehicle).setTurboOn();
            }

        }
    }

    void setTurboOf() {
        for (Vehicle vehicle : cars) {
            if (vehicle instanceof Saab95) {
                ((Saab95) vehicle).setTurboOff();
            }
        }
    }

    void liftBed(double amount) {
        for (Vehicle vehicle : cars) {
            if (vehicle instanceof Scania) {
                ((Scania) vehicle).increaseCargoAngle(amount);
            }
        }
    }


    void lowerBed(double amount) {
        for (Vehicle vehicle : cars) {
            if (vehicle instanceof Scania) {
                ((Scania) vehicle).decreaseCargoAngle(amount);
                System.out.println("hh");
            }
        }
    }

    void start() {
        for (Vehicle vehicle : cars) {
            vehicle.startEngine();
        }
    }

    void stop() {
        for (Vehicle vehicle : cars) {
            vehicle.stopEngine();
        }
    }


    void addCar(){
        cars.add(cf.createSaab95());
    }

    void removeCar() {
        if (cars.size() >= 1) {
            cars.remove(cars.size() - 1);
        }
    }
}

