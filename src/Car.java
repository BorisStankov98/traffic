import java.util.ArrayList;

public class Car {
    String licensePlate;
    ArrayList<Float> entryPoint;
    ArrayList<Float> leavingPoint;

    Integer averageSpeed;

    public Car(){}
    public Car(String licensePlate, ArrayList<Float> entryPoint, ArrayList<Float> leavingPoint) {
        this.licensePlate = licensePlate;
        this.entryPoint = entryPoint;
        this.leavingPoint = leavingPoint;
        this.averageSpeed = calculateAverageSpeed();
    }

    @Override
    public String toString() {
        return "Car{" +
                "licensePlate='" + licensePlate + '\'' +
                ", entryPoint='" + entryPoint + '\'' +
                ", leavingPoint='" + leavingPoint + '\'' +
                '}';
    }

    public boolean passedBeforeNine() {

        if (leavingPoint.get(0) < 9) {
            return true;
        }
        return false;
    }

    public boolean carsPassedByInputMinute(int input) {

        if (entryPoint.get(1) == input) {
            return true;
        }
        return false;
    }

    public boolean trafficIntensity(int input) {

        if (entryPoint.get(1) >= input && leavingPoint.get(1) <= input) {
            return true;
        }

        return false;
    }

    public Integer calculateAverageSpeed() {
        Float timeElapsed = convertToHour(leavingPoint) - convertToHour(entryPoint);
        Integer averageSpeed = Math.round(10 / timeElapsed);
        return averageSpeed;
    }

    private Float convertToHour(ArrayList<Float> input) {
        return input.get(0) + (input.get(1) / 60) + (input.get(2) / 3600);
    }

}
