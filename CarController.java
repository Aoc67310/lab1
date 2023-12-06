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

    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    Carmodel cm = new Carmodel();


    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */

    // Calls the gas method for each car once
    void gas(int amount) {

        cm.gas(amount);
    }

    void brake(int amount) {
        cm.brake(amount);
    }

    void setTurboOn() {
        cm.setTurboOn();
    }

    void setTurboOf(){
        cm.setTurboOf();
    }

    void liftBed(double amount){
        cm.liftBed(amount);
    }

    void lowerBed(double amount){
        cm.lowerBed(amount);
    }
    void start(){
        cm.start();
    }
    void stop(){
        cm.stop();
    }

    void addCar() {
        cm.addCar();
    }

    void removeCar() {
        cm.removeCar();
    }

}

