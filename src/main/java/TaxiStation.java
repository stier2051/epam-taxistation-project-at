import model.Car;
import model.DeliveryTaxi;
import model.PassengerTaxi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TaxiStation {
    private List<Car> cars;

    public TaxiStation(List<Car> cars) {
        this.cars = cars;
    }

    public TaxiStation sortCarsByFuelConsumption() {
        cars.sort((Comparator<Car>) (o1, o2) -> o1.getFuelConsumption() - o2.getFuelConsumption());
        return this;
    }

    public List<Car> searchCarsBySpeedRange(int min, int max) {
        List<Car> list = new ArrayList<>();
        for (Car car : cars) {
            if (car.getMaxSpeed() >= min && car.getMaxSpeed() <= max)
                list.add(car);
        }
        return list;
    }

    public int fullCostOfTaxiStation() {
        int fullCost = 0;
        for (Car car : cars) {
            fullCost += car.getPrice();
        }
        return fullCost;
    }

    public List<DeliveryTaxi> getListOFDeliveryTaxi() {
        List<DeliveryTaxi> deliveryTaxis = new ArrayList<>();
        for (Car car : cars) {
            if (car instanceof DeliveryTaxi) deliveryTaxis.add((DeliveryTaxi) car);
        }

        return deliveryTaxis;
    }

    public List<PassengerTaxi> getListOfPassengerTaxi() {
        List<PassengerTaxi> passengerTaxis = new ArrayList<>();
        for (Car car : cars) {
            if (car instanceof PassengerTaxi) passengerTaxis.add((PassengerTaxi) car);
        }
        return passengerTaxis;
    }

    @Override
    public String toString() {
        return "TaxiStation{" +
                "cars=" + cars +
                '}';
    }
}
