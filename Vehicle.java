import java.awt.*;

public abstract class Vehicle implements Movable{

    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car

    protected double currentSpeed; // The current speed of the car

    protected Color color; // Color of the car

    protected String modelName; // The car model name

    public double x;

    protected double y;
    
    protected int direction;


    public Vehicle(int nrDoors ,double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.stopEngine();
        this.x = 0;
        this.y = 0;
        this.direction = 0;
    } // constructor

    public int getNrDoors(){
        return nrDoors;
    }

    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed() {
        if (0 < currentSpeed && currentSpeed < enginePower) {
            return currentSpeed;
        }
        return 0;
    }

    // Getters

    public double getX() { return x;}

    public double getY() { return y;}

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

    // Methods

    abstract double speedFactor();
    private void incrementSpeed(double amount) {currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);}
    private void decrementSpeed(double amount) {currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);}

    // TODO fix this method according to lab pm
    public void gas(double amount) {
        if (amount <= 1.0 && amount >= 0.0) {
            incrementSpeed(amount);
        }
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        if (amount >= 0  && amount <= 1) {
            decrementSpeed(amount);
        }
    }

    @Override
    public void turnRight() {direction = (direction + 90) % 360;}
    @Override
    public void turnLeft(){
        direction = (direction - 90) % 360;
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
    }
}
