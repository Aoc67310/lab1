import java.awt.*;
import java.util.List;

public abstract class Car implements Movable{

    public int nrDoors; // Number of doors on the car

    public double enginePower; // Engine power of the car

    public double currentSpeed; // The current speed of the car

    public Color color; // Color of the car

    public String modelName; // The car model name



    // constructor
    public Car(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors =  nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.stopEngine();
    }

    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    abstract double speedFactor();

    abstract void incrementSpeed(double amount);

    abstract void decrementSpeed(double amount);



    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }


}


