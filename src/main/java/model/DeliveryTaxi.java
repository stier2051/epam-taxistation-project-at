package model;

import enums.AutoMake;
import enums.TaxiType;

public class DeliveryTaxi extends Car{
    private TaxiType taxiType;
    private int loadCapacity;

    public DeliveryTaxi(AutoMake autoMake, String model, int price, int maxSpeed, int fuelConsumption, TaxiType taxiType, int loadCapacity) {
        super(autoMake, model, price, maxSpeed, fuelConsumption);
        this.taxiType = taxiType;
        this.loadCapacity = loadCapacity;
    }

    public TaxiType getTaxiClass() {
        return taxiType;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    @Override
    public String toString() {
        return "DeliveryTaxi{" +
                "Model = " + getAutoMake() + " " + getModel() +
                ", Maximal speed = " + getMaxSpeed() +
                ", Fuel consumption = " + getFuelConsumption() +
                '}' + System.lineSeparator();
    }
}
