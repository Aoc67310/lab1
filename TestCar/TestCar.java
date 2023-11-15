import org.junit.Test;

import java.awt.*;
import java.util.Objects;

import static java.awt.Color.RED;
import static org.junit.Assert.*;

public class TestCar{

    Saab95 saab = new Saab95();
    Volvo240 volvo = new Volvo240();

    Scania scania = new Scania();
    // Car.java


    // Tests for Car
    @Test
    public void TestGetNrOfDoors() {
        assertEquals(2, saab.getNrDoors()); }
    @Test
    public void testGetModelName(){
        assertEquals("Saab95", saab.modelName);
    }

    @Test
    public void TestGetEnginePowerSaab95(){
        assertEquals(125, saab.getEnginePower(), 0.0);}

    @Test
    public void TestGetColor(){
        assertEquals(saab.getColor(), RED);}

    @Test
    public void TestSetColor() {
        saab.setColor(Color.red);
        assertEquals(Color.red, saab.color);}

    @Test
    public void TestStartEngine() {
        saab.startEngine();
        assertEquals(0.1, saab.currentSpeed, 0.0); }

    @Test
    public void TestGetCurrentSpeed() {
        saab.startEngine();
        assertEquals(saab.getCurrentSpeed(), saab.currentSpeed, 0.0);
    }
    @Test
    public void TestStopEngine() {
        saab.stopEngine();
        assertEquals(0.0, saab.currentSpeed, 0.0);
    }

    @Test
    public void TestMove(){
        // Moving in a circle
        double beforecordx = saab.xkoordinat;
        double beforecordy = saab.ykoordinat;
        saab.move();
        assertEquals(saab.xkoordinat, beforecordx + saab.currentSpeed, 0.0);
        assertEquals(saab.ykoordinat, beforecordy, 0.0);

        beforecordx = saab.xkoordinat;
        beforecordy = saab.ykoordinat;
        saab.direction = 90;
        saab.move();
        assertEquals(saab.ykoordinat, beforecordy + saab.currentSpeed, 0.0);
        assertEquals(saab.xkoordinat, beforecordx, 0.0);

        beforecordx = saab.xkoordinat;
        beforecordy = saab.ykoordinat;
        saab.direction = 180;
        saab.move();
        assertEquals(saab.xkoordinat, beforecordx - saab.currentSpeed, 0.0);
        assertEquals(saab.ykoordinat, beforecordy, 0.0);

        beforecordx = saab.xkoordinat;
        beforecordy = saab.ykoordinat;
        saab.direction = 270;
        saab.move();
        assertEquals(saab.ykoordinat, beforecordy - saab.currentSpeed, 0.0);
        assertEquals(saab.xkoordinat, beforecordx, 0.0);
    }

    @Test
    public void TestTurnRight() {
        int beforedirection = saab.direction;
        saab.turnRight();
        assertEquals(saab.direction, (beforedirection + 90) % 360);
    }

    @Test
    public void TestTurnLeft() {
        int beforedirection = saab.direction;
        saab.turnLeft();
        assertEquals(saab.direction, (beforedirection - 90) % 360);
    }

    @Test
    public void TestGasCar() {

        // currentSpeed is over enginePower after gas()
        saab.startEngine();
        double beforespeed = saab.currentSpeed;
        saab.gas(200);
        assertEquals(saab.currentSpeed, beforespeed, 0.0);

        // Value inside the given index
        saab.currentSpeed = 50;
        beforespeed = saab.currentSpeed;
        saab.gas(0.5);
        assertEquals(saab.currentSpeed, beforespeed + 0.5 * saab.speedFactor(), 0.0);

    }

    @Test
    public void TestBreak() {
        // out of index
        saab.startEngine();
        double beforespeed = saab.currentSpeed;
        saab.brake(200);
        assertEquals(saab.currentSpeed, beforespeed, 0.0);

        // Value inside the given index
        saab.currentSpeed = 50;
        beforespeed = saab.currentSpeed;
        saab.brake(0.5);
        assertEquals(saab.currentSpeed, beforespeed - saab.speedFactor()* 0.5, 0.0);
    }


    //Volvo240
    @Test
    public void TestVolvo240SpeedFactor() {
        assertEquals(volvo.speedFactor(), volvo.enginePower * 0.01 * 1.25, 0.0); }

    //Saab95
    @Test
    public void TestSaab95setTurboOn(){
        saab.setTurboOn();
        assertTrue(saab.turboOn);
    }

    @Test
    public  void TestSaab95setTurboOff() {
        Saab95 Saab = (Saab95) saab;
        Saab.setTurboOff();
        assertFalse(Saab.turboOn);
    }

    @Test
    public void TestSaab95speedFactorTurboOff() {
        Saab95 Saab = (Saab95) saab;
        Saab.setTurboOff();
        assertEquals(Saab.speedFactor(), Saab.enginePower * 0.01, 0.0);
    }

    @Test
    public void TestSaab95speedFactorTurboOn() {
        Saab95 Saab = (Saab95) saab;
        Saab.setTurboOn();
        assertEquals(Saab.speedFactor(), Saab.enginePower * 0.01 * 1.3, 0.0);
    }


    // test Truck

    @Test
    public void TestgetCargoAngle() {
        assertEquals(scania.getCargoAngle(), 0.0, 0.0);
    }

    @Test
    public void TestincreaseCargoAngle() {
        double beforeangle = scania.getCargoAngle();
        double amount = 2;
        scania.increaseCargoAngle(amount);
        assertEquals(scania.getCargoAngle(), beforeangle + amount, 0.0);
        beforeangle = scania.getCargoAngle();
        scania.increaseCargoAngle(70);
        assertEquals(scania.getCargoAngle(), beforeangle, 0.0);
    }

    @Test
    public void  TestdecreaseCargoAngle() {
        double beforeangle = scania.getCargoAngle();
        double amount = 2;
        scania.increaseCargoAngle(amount);
        scania.decreaseCargoAngle(amount);
        assertEquals(scania.getCargoAngle(), beforeangle, 0.0);

        beforeangle = scania.getCargoAngle();
        scania.decreaseCargoAngle(70);
       assertEquals(scania.getCargoAngle(), beforeangle, 0.0);

    }

    @Test
    public void TestGasTruck() {
        double beforespeed = scania.getCurrentSpeed();
        scania.gas(1.0);
        assertEquals(scania.getCurrentSpeed(), beforespeed + 1, 0.0);
    }

    @Test
    public void TestSpeedfactor() {
        assertEquals(scania.speedFactor(), 1, 0.0);
    }

}

