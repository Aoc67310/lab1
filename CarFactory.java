import java.awt.*;

public class CarFactory {

    public Car createSaab95() {
        return new Saab95();
    }

    public Car createVolvo240(){

        Car car = new Volvo240() {
        };
        return car;

    }

}
