import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CarApp {

    private CarController cc;
    private CarView frame;
    private Timer timer;

    public CarApp(){
        cc = new CarController();
        frame = new CarView("CarSim 1.0",cc);

        final int delay = 50;
        timer = new Timer(delay, new TimerListener());

        cc.cm.createcars();
        timer.start();
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            cc.cm.Checkcollison();
            // Sends an ArrayList of all the vehicles to the DrawPanel
            frame.drawPanel.moveit();
            frame.drawPanel.uppdatecarlist(cc.cm.cars);
            // repaint() calls the paintComponent method of the panel
            frame.drawPanel.repaint();
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

