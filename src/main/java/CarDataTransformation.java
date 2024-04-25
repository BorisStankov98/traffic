import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CarDataTransformation {
    private ArrayList<Car> cars = new ArrayList<>();

    CarDataTransformation() throws FileNotFoundException {
        readFile();
    }

    private void readFile() throws FileNotFoundException {
        File file = new File("src/main/java/measurements.txt");

        Scanner sc = new Scanner(file);
        while (sc.hasNext()) {
            ArrayList<Float> entryPoint = new ArrayList<>();
            ArrayList<Float> leavingPoint = new ArrayList<>();
            String[] currentCar = sc.nextLine().split(" ");
            String licensePlate = currentCar[0];
            Collections.addAll(leavingPoint, Float.valueOf(currentCar[5]), Float.valueOf(currentCar[6]), Float.valueOf(currentCar[7]) + Float.valueOf(currentCar[8]) / 1000);
            Collections.addAll(entryPoint, Float.valueOf(currentCar[1]), Float.valueOf(currentCar[2]), Float.valueOf(currentCar[3]) + Float.valueOf(currentCar[4]) / 1000);
            Car car = new Car(licensePlate, entryPoint, leavingPoint);
            cars.add(car);
        }
    }

    public void printCarLength() {
        System.out.print("Exercise 2" + "\n");
        System.out.print("number of cars that passed the checkpoint: " + cars.size() + "\n");
    }

    public void printCars() {
        for (Car car : cars) {
            System.out.println(car.toString());
        }
    }

    public int numberOfCarsPassedBeforeNine() {
        int numberOfCars = 0;
        for (Car car : cars) {
            if (car.passedBeforeNine()) {
                numberOfCars++;
            }
        }
        System.out.print("Exercise 3" + "\n");
        System.out.print("cars passed before 9: " + numberOfCars + "\n");
        return numberOfCars;
    }

    public int numberOfCarsPassedByInputMinute() {
        int numberOfCars = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter Time HH:MM");
        String time = input.nextLine();
        int minutes = Integer.valueOf(time.split(":")[1]);

        for (Car car : cars) {
            if (car.carsPassedByInputMinute(minutes)) {
                numberOfCars++;
            }
        }
        System.out.print("Exercise 4a" + "\n");
        System.out.printf("The number of vehicle that passed the entry point recorder: " + numberOfCars + "\n");

        return 0;
    }

    public int trafficIntensityByMinute() {
        int numberOfCars = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter Time HH:MM");
        String time = input.nextLine();
        int minutes = Integer.valueOf(time.split(":")[1]);

        for (Car car : cars) {
            if (car.trafficIntensity(minutes)) {
                numberOfCars++;
            }
        }
        float trafficIntensity = numberOfCars / 10;
        System.out.print("Exercise 4b" + "\n");
        System.out.printf("The traffic intensity: " + trafficIntensity + "\n");
        return 0;
    }


    public void averageSpeed() {
        Float carsSpeeding = 0.0f;
        // initialized because of “variable might not have been initialized” error even after null check
        Car carWithTopAverageSpeed = new Car();
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).averageSpeed > 90) {
                carsSpeeding++;
            }

            if (i == 0) {
                carWithTopAverageSpeed = cars.get(i);
                continue;
            }

            if (carWithTopAverageSpeed.averageSpeed < cars.get(i).averageSpeed) {
                carWithTopAverageSpeed = cars.get(i);
            }
        }
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.print("Exercise 5" + "\n");
        System.out.print("licence plate: " + carWithTopAverageSpeed.licensePlate + "\n" + "average speed: " + carWithTopAverageSpeed.averageSpeed + " km/h" + "\n");
        System.out.print("Exercise 6" + "\n");
        System.out.print(df.format(carsSpeeding / cars.size() * 100) + "%" + " percent of the vehicles were speeding." + "\n");
    }

}
