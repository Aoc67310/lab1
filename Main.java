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
        newcar1.incrementSpeed(1.0);
        System.out.println(newcar1.currentSpeed);

        System.out.println("I am a Geek");
    }
}