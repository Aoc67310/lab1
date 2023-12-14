import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CarApp {

    private CarController cc;
    private CarView cw;
    final int delay = 50;
    private Timer timer = new Timer(delay, new TimerListener());
    private Carmodel cm;

    public CarApp(){
        cw = new CarView();
        cm = new Carmodel();
        cc = new CarController(cw, cm);

        cc.cm.createcars();
        timer.start();
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            cc.cm.Checkcollison();
            // Sends an ArrayList of all the vehicles to the DrawPanel
            cw.drawPanel.uppdatecarlist(cc.cm.cars);
            cw.drawPanel.moveit();
            // repaint() calls the paintComponent method of the panel
            cw.drawPanel.repaint();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CarApp();
                });

    }


}

