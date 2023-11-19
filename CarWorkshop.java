import java.util.ArrayList;
import java.util.List;

public class CarWorkshop<T extends Car> {
    private List<T> cars;

    private final int maxCapacity;

    public List<T> getCars(){
        return cars;
    }

    public CarWorkshop(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.cars = new ArrayList<>();
    }


    public void loadCar(T car) {
        if (cars.size() < maxCapacity) {
            cars.add(car);
            System.out.println(car.getModelName() + " loaded into the workshop.");
        } else {
            System.out.println("Workshop is full. Cannot load " + car.getModelName() + ".");
        }
    }

    public void unloadCar(T car) {
        if (!cars.isEmpty()) {
            cars.remove(car);
            System.out.println(car.getModelName() + " unloaded from the workshop.");

        } else {
            System.out.println("Workshop is empty. Cannot unload a car.");
        }
    }
}