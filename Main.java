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

        System.out.println(newtransport.getCargo() + "getcargo()");
        System.out.println(newtransport.getNrOfCars() +  " getNrOfCars()");
        newtransport.closeCargo();
        newtransport.gas(1);
        newtransport.move();
        System.out.println(newtransport.getX() + "Xpos for truck");
        System.out.println(saab.getX() + "saab xpos in truck");
        newtransport.brake(1);
        System.out.println(newtransport.getCurrentSpeed() + "current speed");
        System.out.println(newtransport.getCargoAngle() + "cargo angle");
        newtransport.unload();
        System.out.println(newtransport.getCargo() + "getcargoafter");
        System.out.println(newtransport.getNrOfCars()+ "nr of cars ");

        System.out.println(saab.getX() + "saabxpos");
        System.out.println(saab.getY() + "saabypos");
        System.out.println("I am a Geek");
    }
}