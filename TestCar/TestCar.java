import org.junit.Test;

import java.awt.*;
import java.util.Objects;
import java.util.Stack;

import static java.awt.Color.RED;
import static org.junit.Assert.*;

public class TestCar {

    Saab95 saab = new Saab95();

    Volvo240 volvo = new Volvo240();
    Volvo240 volvo2 = new Volvo240();

    Scania scania = new Scania();

    CarTransport carTransport = new CarTransport();

    CarWorkshop Volvoworkshop = new CarWorkshop<>(3);

    // Car.java

    // Tests for Car
    @Test
    public void TestGetNrOfDoors() {
        assertEquals(2, saab.getNrDoors());
    }

    @Test
    public void testGetModelName() {
        assertEquals("Saab95", saab.modelName);
    }

    @Test
    public void TestGetEnginePowerSaab95() {
        assertEquals(125, saab.getEnginePower(), 0.0);
    }

    @Test
    public void TestGetColor() {
        assertEquals(saab.getColor(), RED);
    }

    @Test
    public void TestSetColor() {
        saab.setColor(Color.red);
        assertEquals(Color.red, saab.color);
    }

    @Test
    public void TestStartEngine() {
        saab.startEngine();
        assertEquals(0.1, saab.currentSpeed, 0.0);
    }

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
    public void TestMove() {
        // Moving in a circle
        double beforecordx = saab.point.x;
        double beforecordy = saab.point.y;
        saab.move();
        assertEquals(saab.point.x, beforecordx + saab.currentSpeed, 0.0);
        assertEquals(saab.point.y, beforecordy, 0.0);

        beforecordx = saab.point.x;
        beforecordy = saab.point.y;
        saab.direction = 90;
        saab.move();
        assertEquals(saab.point.x, beforecordy + saab.currentSpeed, 0.0);
        assertEquals(saab.point.y, beforecordx, 0.0);

        beforecordx = saab.point.x;
        beforecordy = saab.point.y;
        saab.direction = 180;
        saab.move();
        assertEquals(saab.point.x, beforecordx - saab.currentSpeed, 0.0);
        assertEquals(saab.point.y, beforecordy, 0.0);

        beforecordx = saab.point.x;
        beforecordy = saab.point.y;
        saab.direction = 270;
        saab.move();
        assertEquals(saab.point.y, beforecordy - saab.currentSpeed, 0.0);
        assertEquals(saab.point.x, beforecordx, 0.0);
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
        assertEquals(saab.currentSpeed, beforespeed - saab.speedFactor() * 0.5, 0.0);
    }

    //Volvo240

    @Test
    public void TestVolvo240SpeedFactor() {
        assertEquals(volvo.speedFactor(), volvo.enginePower * 0.01 * 1.25, 0.0);
    }

    //Saab95

    @Test
    public void TestSaab95setTurboOn() {
        saab.setTurboOn();
        assertTrue(saab.turboOn);
    }

    @Test
    public void TestSaab95setTurboOff() {
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
    public void TestdecreaseCargoAngle() {
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

    // test CarTransport

    @Test
    public void TestCarTransportgetCargo() {
        assertSame(carTransport.getCargo().toString(), "[]");
    }

    @Test
    public void Testopenandclosecacrgo() {
        carTransport.openCargo();
        assertEquals(carTransport.getCargoAngle(), 1, 0);
        carTransport.closeCargo();
        assertEquals(carTransport.getCargoAngle(), 0, 0);
    }

    @Test
    public void TestCarTransportgetNrOfCars_load_and_unload() {
        assertEquals(carTransport.getNrOfCars(), 0, 0);
        carTransport.openCargo();
        carTransport.addCar(volvo2);
        assertEquals(carTransport.getNrOfCars(), 1, 0);
        carTransport.removeCar();
        assertEquals(volvo2.point.x, carTransport.point.x + 1, 0);
    }

    @Test
    public void Testdecrementcargoangleandincrementcargoangle() {
        carTransport.decreaseCargoAngle(1);
        carTransport.increaseCargoAngle(1);
    }

    @Test
    public void Testmove() {
        carTransport.openCargo();
        carTransport.addCar(volvo2);
        carTransport.closeCargo();
        carTransport.gas(1);
        carTransport.move();
        assertEquals(volvo2.x, carTransport.x, 0);
        carTransport.turnRight();
        carTransport.move();
        assertEquals(volvo2.point.y, carTransport.point.y, 0);
        carTransport.turnRight();
        carTransport.move();
        carTransport.turnRight();
        carTransport.move();
        carTransport.brake(1);
        carTransport.openCargo();
        carTransport.removeCar();
        assertEquals(volvo2.point.x, carTransport.point.x + 1, 0);
        assertEquals(volvo2.point.y, carTransport.point.y + 1, 0);
    }

    // Test CarWorkshop

    @Test
    public void testLoadCar() {
        Volvo240 volvo1 = new Volvo240();
        Volvo240 volvo2 = new Volvo240();
        Volvo240 volvo3 = new Volvo240();

        Volvoworkshop.loadCar(volvo1);
        Volvoworkshop.loadCar(volvo2);
        Volvoworkshop.loadCar(volvo3);

        assertEquals(3, Volvoworkshop.getCars().size());
        assertTrue(Volvoworkshop.getCars().contains(volvo1));
        assertTrue(Volvoworkshop.getCars().contains(volvo2));
        assertTrue(Volvoworkshop.getCars().contains(volvo3));
    }

    @Test
    public void testmaxcapacity(){
        Volvo240 volvo1 = new Volvo240();
        Volvo240 volvo2 = new Volvo240();
        Volvo240 volvo3 = new Volvo240();

        Volvoworkshop.loadCar(volvo1);
        Volvoworkshop.loadCar(volvo2);
        Volvoworkshop.loadCar(volvo3);

        Volvo240 extravolvo = new Volvo240();
        Volvoworkshop.loadCar(extravolvo);

        assertEquals(3, Volvoworkshop.getCars().size());
        assertFalse(Volvoworkshop.getCars().contains(extravolvo));
    }

    @Test
    public void testunloadCar(){
        Volvo240 volvo1 = new Volvo240();
        Volvoworkshop.loadCar(volvo1);
        Volvoworkshop.unloadCar(volvo1);

        assertEquals(0,Volvoworkshop.getCars().size());
        assertFalse(Volvoworkshop.getCars().contains(volvo1));
    }

}

