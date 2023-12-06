import java.awt.*;

public class CarFactory {

    public Car createSaab95(){

        Car car = new Saab95() {
        };
        return car;

    }

    public Car createVolvo240(){

        Car car = new Volvo240() {
        };
        return car;

    }

}
