import java.awt.*;


public class Volvo240 extends Car implements Movable {
    private final static double trimFactor = 1.25;

    private String direction;

    private Point position;
    
    public Volvo240(){
        super(4, 100, Color.red, "Volvo240");
    }

    @Override
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

    @Override
    public void incrementSpeed(double amount){
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }
    @Override
    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }
    @Override
    public void move() {
        if (direction.equals("North")) {
            position.move();
        } else if (direction.equals("West")) {
            direction = "South";
        } else if (direction.equals("South")) {
            direction = "East";
        } else if (direction.equals("East")) {
            direction = "North";
        }
    }
    @Override
    public void turnLeft() {
        if (direction.equals("North")) {
            direction = "West";
        } else if (direction.equals("West")) {
            direction = "South";
        } else if (direction.equals("South")) {
            direction = "East";
        } else if (direction.equals("East")) {
            direction = "North";
        }
    }
    @Override
    public void turnRight() {
        if (direction.equals("North")) {
            direction = "East";
        } else if (direction.equals("East")) {
            direction = "South";
        } else if (direction.equals("South")) {
            direction = "West";
        } else if (direction.equals("West")) {
            direction = "North";
        }

    }

}
