package lesson4.garage;

public class Car extends Vehicle  {
    private int value;

    public Car(String model, int power) {
        super(model, power);
    }

    public Car(String model, int power, int value) {
        super(model, power);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Car{" +
                "value=" + value +
                ", model='" + model + '\'' +
                ", power=" + power +
                '}';
    }
}
