import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        CarDataTransformation carDataTransformation = new CarDataTransformation();

        carDataTransformation.printCarLength();

        carDataTransformation.numberOfCarsPassedBeforeNine();

        carDataTransformation.numberOfCarsPassedByInputMinute();

        carDataTransformation.trafficIntensityByMinute();

        carDataTransformation.averageSpeed();
    }

}