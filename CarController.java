import javax.sql.rowset.CachedRowSet;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());
    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> cars = new ArrayList<>();


    //private CarView CarView;
    //private DrawPanel DrawPanel;


    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        // Added: Add a new vehicle to the arraylist cars
        cc.cars.add(new Volvo240());
        cc.cars.add(new Saab95());
        cc.cars.add(new Scania());

        // Added: every new vehicle added has their y coordinate shifted by 100
        for (int i = 0; i < cc.cars.size(); i++) {
            cc.cars.get(i).setPoint(0, 100 * i);
        }

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle vehicle : cars) {

                vehicle.move();
                // Checks if the vehicles have collided with any walls and sends them back 180 degrees
                // in the opposite direction
                if (vehicle.getPoint().x > 700.0 || vehicle.getPoint().x < 0.0) {
                    vehicle.turnRight();
                    vehicle.turnRight();
                }

                // Sends an ArrayList of all the vehicles to the DrawPanel
                frame.drawPanel.moveit(cars);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
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


    void lowerBed(double amount){
        for (Vehicle vehicle : cars){
            if (vehicle instanceof Scania) {
                ((Scania) vehicle).decreaseCargoAngle(amount);

            }
        }
    }
    void start(){
            for (Vehicle vehicle : cars){
                vehicle.startEngine();
            }
    }
    void stop(){
        for (Vehicle vehicle : cars){
            vehicle.stopEngine();
        }
    }




}