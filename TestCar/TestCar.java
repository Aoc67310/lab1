import org.junit.Test;

import java.awt.*;
import java.util.Objects;

import static java.awt.Color.RED;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestCar{

    Car saab = new Saab95();
    Car volvo = new Volvo240();

    // Car.java

    @Test
    public void TestGetNrOfDoors() {assertTrue(Objects.equals(saab.getNrDoors(), 2)); }
    @Test
    public void testGetModelName(){
    assertTrue(Objects.equals(saab.modelName, "Saab95"));
    }

    @Test
    public void TestGetEnginePowerSaab95(){assertTrue(saab.getEnginePower() == 125);}

    @Test
    public void TestGetColor(){assertTrue(Objects.equals(saab.getColor(), RED));}

    @Test
    public void TestSetColor() {
        saab.setColor(Color.red);
        assertTrue(Objects.equals(Color.red, saab.color));}

    @Test
    public void TestStartEngine() {
        saab.startEngine();
        assertTrue(Objects.equals(saab.currentSpeed, 0.1)); }

    @Test
    public void TestGetCurrentSpeed() {
        saab.startEngine();
        assertTrue(Objects.equals(saab.getCurrentSpeed(), saab.currentSpeed));
    }
    @Test
    public void TestStopEngine() {
        saab.stopEngine();
        assertTrue(Objects.equals(saab.currentSpeed, 0.0));
    }

    @Test
    public void TestMove(){
        double beforecordx = saab.xkoordinat;
        double beforecordy = saab.ykoordinat;
        saab.move();
        assertTrue(Objects.equals(saab.xkoordinat, beforecordx + saab.currentSpeed));
        assertTrue(Objects.equals(saab.ykoordinat, beforecordy));
        beforecordx = saab.xkoordinat;
        beforecordy = saab.ykoordinat;
        saab.direction = 90;
        saab.move();
        assertTrue(Objects.equals(saab.ykoordinat, beforecordy + saab.currentSpeed));
        assertTrue(Objects.equals(saab.xkoordinat, beforecordx));
        beforecordx = saab.xkoordinat;
        beforecordy = saab.ykoordinat;
        saab.direction = 180;
        saab.move();
        assertTrue(Objects.equals(saab.xkoordinat, beforecordx - saab.currentSpeed));
        assertTrue(Objects.equals(saab.ykoordinat, beforecordy));
        beforecordx = saab.xkoordinat;
        beforecordy = saab.ykoordinat;
        saab.direction = 270;
        saab.move();
        assertTrue(Objects.equals(saab.ykoordinat, beforecordy - saab.currentSpeed));
        assertTrue(Objects.equals(saab.xkoordinat, beforecordx));
    }

    @Test
    public void TestTurnRight() {
        int beforedirection = saab.direction;
        saab.turnRight();
        assertTrue(Objects.equals(saab.direction, (beforedirection + 90) % 360));
    }

    @Test
    public void TestTurnLeft() {
        int beforedirection = saab.direction;
        saab.turnLeft();
        assertTrue(Objects.equals(saab.direction, (beforedirection - 90) % 360));
    }

    //Volvo240
    @Test
    public void TestVolvo240SpeedFactor() {assertTrue(Objects.equals(volvo.speedFactor(), volvo.enginePower * 0.01 * 1.25)); }
    @Test
    public void TestVolvo240IncrementSpeed() {
        double beforespeed = volvo.currentSpeed;
        volvo.incrementSpeed(1.0);
        assertTrue(Objects.equals(volvo.currentSpeed, Math.min(beforespeed + volvo.speedFactor()* volvo.currentSpeed, volvo.speedFactor()))); }

    @Test
    public void TestVolvo240DecrementSpeed(){
        double beforespeed = volvo.currentSpeed;
        volvo.decrementSpeed(1.0);
        assertTrue(Objects.equals(volvo.currentSpeed, Math.max(beforespeed - volvo.speedFactor() * 1,0)));
    }

    //Saab95
    @Test
    public void TestSaab95setTurboOn(){
        Saab95 Saab = (Saab95) saab;
        Saab.setTurboOn();
        assertTrue(Saab.turboOn);
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
        assertTrue(Objects.equals(Saab.speedFactor(), Saab.enginePower * 0.01));
    }

    @Test
    public void TestSaab95speedFactorTurboOn() {
        Saab95 Saab = (Saab95) saab;
        Saab.setTurboOn();
        assertTrue(Objects.equals(Saab.speedFactor(), Saab.enginePower * 0.01 * 1.3));
    }

    @Test
    public void TestSaab95incrementSpeed() {
        double beforespeed = saab.currentSpeed;
        saab.incrementSpeed(1.0);
        assertTrue(Objects.equals(saab.currentSpeed, beforespeed + saab.speedFactor() * 1));
    }

    @Test
    public void TestSaab95decrementSpeed() {
        double beforespeed = saab.currentSpeed;
        saab.decrementSpeed(1.0);
        assertTrue(Objects.equals(saab.currentSpeed, beforespeed - saab.speedFactor() * 1));
    }
}

