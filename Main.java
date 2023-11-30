import java.awt.*;

class Main {
    public static void main(String[] args) {

        // Create a CarTransport and Saab95 instances
        CarTransport newTransport = new CarTransport();
        CarWorkshop<Volvo240> volvoWorkshop = new CarWorkshop<Volvo240>(3);
        Saab95 saab = new Saab95();
        Volvo240 volvo = new Volvo240();

        /*
        // Increase cargo angle, open cargo gate
        newTransport.increaseCargoAngle(20);
        newTransport.openCargo();

        // Print relevant information
        System.out.println("Cargo Angle: " + newTransport.getCargoAngle());
        System.out.println("Saab Speed: " + saab.getCurrentSpeed());
        System.out.println("Transport Speed: " + newTransport.getCurrentSpeed());
        System.out.println("Number of Cars on Transport: " + newTransport.getNrOfCars());

        // Load Saab onto the CarTransport
        newTransport.addCar(saab);

        // Print information after loading
        System.out.println("Number of Cars on Transport: " + newTransport.getNrOfCars());

        // Close cargo gate, accelerate, move
        newTransport.closeCargo();
        newTransport.gas(1);
        newTransport.move();

        // Print updated positions and speed
        System.out.println("Transport Speed after Move: " + newTransport.getCurrentSpeed());

        // Brake, print cargo angle
        newTransport.brake(1);
        System.out.println("Current Speed after Brake: " + newTransport.getCurrentSpeed());
        System.out.println("Cargo Angle after Brake: " + newTransport.getCargoAngle());

        // Unload from transport
        newTransport.removeCar();

        // Print information after unloading
        System.out.println("Number of Cars on Transport after Unload: " + newTransport.getNrOfCars());

        System.out.println("I am a Geek");

        newTransport.openCargo();
        newTransport.addCar(saab);
        newTransport.addCar(volvo);
        System.out.println(newTransport.carStack);
        */

        saab.setPoint(5,7);
        System.out.println(saab.point);

    }
}



