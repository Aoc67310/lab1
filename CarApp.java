public class CarApp {
    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        // Added: Add a new vehicle to the arraylist cars
        cc.cars.add(new Volvo240());
        cc.cars.add(new Saab95());
        cc.cars.add(new Scania());

        // Added: every new vehicle added has their y coordinate shifted by 100
        for (int i = 0; i < cc.cars.size(); i++) {
            cc.cars.get(i).setPoint(0, 50 * i);
        }

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }
}

