import enums.AutoMake;
import enums.TaxiType;
import model.Car;
import model.DeliveryTaxi;
import model.PassengerTaxi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Runner {
    private static final String FILE_NAME = "src/main/resources/listOfCars.txt";

    public static void main(String[] args) {
        List<String> linesFromFIle = new ArrayList<>();
        List<Car> cars = new ArrayList<>();
        Logger logger = Logger.getGlobal();

        try (FileReader reader = new FileReader(FILE_NAME);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            linesFromFIle = bufferedReader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            logger.info("File not found!");
        }

        for (String line : linesFromFIle) {
            String[] arguments = line.split("\\s");

            switch (arguments[0]) {
                case ("Passenger"):
                    try {
                        cars.add(new PassengerTaxi(
                                AutoMake.valueOf(arguments[1].toUpperCase()),
                                arguments[2],
                                Integer.parseInt(arguments[3]),
                                Integer.parseInt(arguments[4]),
                                Integer.parseInt(arguments[5]),
                                TaxiType.valueOf(arguments[6].toUpperCase()),
                                Integer.parseInt(arguments[7])
                        ));
                    } catch (IllegalArgumentException e) {
                        logger.info("Argument is illegal for " + line);
                    }
                    break;
                case ("Delivery"):
                    try {
                        cars.add(new DeliveryTaxi(
                                AutoMake.valueOf(arguments[1].toUpperCase()),
                                arguments[2],
                                Integer.parseInt(arguments[3]),
                                Integer.parseInt(arguments[4]),
                                Integer.parseInt(arguments[5]),
                                TaxiType.valueOf(arguments[6].toUpperCase()),
                                Integer.parseInt(arguments[7])
                        ));
                    } catch (IllegalArgumentException e) {
                        logger.info("Argument is illegal for " + line);
                    }
                    break;
                default:
                    logger.info("Such type of taxi is not exist!");
            }
        }

        TaxiStation taxiStation = new TaxiStation(cars);

        String fullCostOfTaxiStation = "Full cost of taxi station = " + taxiStation.fullCostOfTaxiStation();
        String sortCarsByFuelConsumption = "Sort cars by fuel consumption: " + taxiStation.sortCarsByFuelConsumption();
        String searchCarsBySpeedRange = "Search cars by speed range: " + taxiStation.searchCarsBySpeedRange(140, 160);

        logger.info(fullCostOfTaxiStation);
        logger.info(sortCarsByFuelConsumption);
        logger.info(searchCarsBySpeedRange);
    }
}
