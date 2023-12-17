import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarController{

    private final Carmodel carModel;
    private final CarView carView;
    private final int gasAmount = 0;

    public CarController(Carmodel cm, CarView frame) {
        this.carModel = cm;
        this.carView = frame;
        initListeners();
    }

    private void initListeners() {
       carView.brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { carModel.brake(gasAmount);
            }
        });

        carView.turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carModel.setTurboOn();
            }
        });

        carView.turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carModel.setTurboOf();
            }
        });

        carView.liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carModel.liftBed(5);
            }
        });

        carView.lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carModel.lowerBed(5);
            }
        });

        carView.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carModel.start();
            }
        });

        carView.stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carModel.stop();
            }
        });

        carView.addCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carModel.addCar();
            }
        });

        carView.removeCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carModel.removeCar();
            }
        });

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

