package model;

import enums.AutoMake;

public abstract class Car {
    private AutoMake autoMake;
    private String model;
    private int price;
    private int maxSpeed;
    private int fuelConsumption;

    protected Car(AutoMake autoMake, String model, int price, int maxSpeed, int fuelConsumption) {
        this.autoMake = autoMake;
        this.model = model;
        this.price = price;
        this.maxSpeed = maxSpeed;
        this.fuelConsumption = fuelConsumption;
    }

    public AutoMake getAutoMake() {
        return autoMake;
    }

    public String getModel() {
        return model;
    }

    public int getPrice() {
        return price;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }
}
