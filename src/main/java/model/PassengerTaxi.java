package model;

import enums.AutoMake;
import enums.TaxiType;

public class PassengerTaxi extends Car{
    private TaxiType taxiType;
    private int passengerCapacity;

    public PassengerTaxi(AutoMake autoMake, String model, int price, int maxSpeed, int fuelConsumption, TaxiType taxiType, int passengerCapacity) {
        super(autoMake, model, price, maxSpeed, fuelConsumption);
        this.taxiType = taxiType;
        this.passengerCapacity = passengerCapacity;
    }

    public TaxiType getTaxiClass() {
        return taxiType;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    @Override
    public String toString() {
        return "PassengerTaxi {" +
                "Model = " + getAutoMake() + " " + getModel() +
                ", Maximal speed = " + getMaxSpeed() +
                ", Fuel consumption = " + getFuelConsumption() +
                '}' + System.lineSeparator();
    }
}
