package lesson4.garage;
import java.util.Comparator;

public class CarComparatorByValue implements Comparator<Car>  {
    @Override
    public int compare(Car o1, Car o2) {
        return o2.getValue() - o1.getValue();
    }
}
