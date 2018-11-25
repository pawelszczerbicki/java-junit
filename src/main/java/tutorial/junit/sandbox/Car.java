package tutorial.junit.sandbox;

public class Car {

    private int speed;
    private String make;
    private String model;
    private boolean fast;


    public static void main(String[] args) {
    }

    Car createCar() {
        Car c = new Car();
        c.setSpeed(1);
        c.setFast(true);
        return c;
    }

    Car createCar2() {
        return new Car().setSpeed(10).setFast(true);
    }


    public boolean isFast() {
        return fast;
    }

    public Car setFast(boolean fast) {
        this.fast = fast;
        return this;
    }

    public int getSpeed() {
        return speed;
    }

    public Car setSpeed(int speed) {
        this.speed = speed;
        return this;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
