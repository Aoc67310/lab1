import java.awt.*;

class Main{
    public static void main(String[] args)
    {


        CarTransport newtransport = new CarTransport();

        Saab95 saab = new Saab95();


        newtransport.increaseCargoAngle(20);
        newtransport.openCargo();

        System.out.println( newtransport.getCargoAngle());
        System.out.println( saab.getCurrentSpeed());
        System.out.println( newtransport.getCurrentSpeed());
        System.out.println( newtransport.getNrOfCars());
        newtransport.load(saab);

        System.out.println(newtransport.getCargo());
        System.out.println(newtransport.getNrOfCars());
        newtransport.unload();

        System.out.println(saab.getX() + saab.getY());
        System.out.println("I am a Geek");
    }
}