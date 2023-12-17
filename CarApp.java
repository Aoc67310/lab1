import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CarApp {

    private CarController cc;
    private Carmodel cm;
    private CarView frame;
    private Timer timer;

    public CarApp(){
        final int delay = 50;

        cm = new Carmodel();

        frame = new CarView("CarSim 1.0",cc);

        cc = new CarController(cm,frame);

        timer = new Timer(delay, new TimerListener());

        cm.createcars();

        cm.addobserver(frame);

        timer.start();
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            cm.Checkcollison();
            // Sends an ArrayList of all the vehicles to the DrawPanel
            /*
            frame.drawPanel.uppdatecarlist(cm.cars);
            frame.drawPanel.moveit();
            // repaint() calls the paintComponent method of the panel
            frame.drawPanel.repaint();

             */
            
            cm.notifyObservers();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CarApp();
                });
        // Instance of this class

        // Added: Add a new vehicle to the arraylist cars
        // Added: every new vehicle added has their y coordinate shifted by 100

        // Start a new view and send a reference of self

        // Start the timer
    }


}

