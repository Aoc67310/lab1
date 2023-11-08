import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertTrue;

public class TestCar{

    Car saab = new Saab95();
    Car volvo = new Volvo240();
    
    @Test
    public void testGetName(){
    assertTrue(saab.modelName == "Saab95");
    }

    @Test
    public void TestGetEnginePowerSaab95(){
    assertTrue(volvo.enginePower == 125);
    }

}
