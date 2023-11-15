import java.awt.*;

class Main{
    public static void main(String[] args)
    {
        Car newcar1 = new Saab95();
        newcar1.turnLeft();
        System.out.println(newcar1.direction);
        Car newcar2 = new Volvo240();
        newcar1.turnLeft();
        System.out.println(newcar1.direction);
        newcar1.startEngine();
        System.out.println(newcar1.currentSpeed);
        newcar1.move();
        newcar1.gas(1.0);
        System.out.println(newcar1.currentSpeed);
        Truck newcar3 = new Scania();
        System.out.println(newcar3.getEnginePower());
        CarTransport newtransport = new CarTransport();
        newtransport.increaseCargoAngle(20);
        System.out.println(newtransport.getCargoAngle());


        System.out.println("I am a Geek");
    }
}