import java.awt.*;

public abstract class Vehicle implements Movable{

    public Object getPoint;
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car

    protected double currentSpeed; // The current speed of the car

    protected Color color; // Color of the car

    protected String modelName; // The car model name

    public double x;

    protected int direction;

    protected Point point;


    public Vehicle(int nrDoors ,double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.stopEngine();
        this.point = new Point();
        this.direction = 0;
        this.point = point;
    } // constructor


    public Point getPoint() {return point; }
    public String getModelName() {
        return modelName;
    }

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
    }
}

