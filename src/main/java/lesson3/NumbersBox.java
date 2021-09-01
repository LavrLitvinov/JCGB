package lesson3;

import java.util.Arrays;

public class NumbersBox<T extends Number> {
    private T[] array;

    public NumbersBox(T... array) {
        this.array = array;
    }

    public double calcAverage() {
        double sum = 0.0;
        for (T num : array) {
            sum = sum + num.doubleValue();
        }
        return sum / array.length;
    }

    public T[] getArray() {
        return array;
    }

    public boolean isSameAvg(NumbersBox<?> boxToCompare) {
        return Math.abs(calcAverage() - boxToCompare.calcAverage()) < 0.0001;
    }

    public void setArray(T[] array) {
        this.array = array;
    }

    public static <U extends Number> U getFirstElement(NumbersBox<U> numbersBox) {
        return numbersBox.getArray()[0];
    }

    @Override
    public String toString() {
        return "NumbersBox{" +
                "array=" + Arrays.toString(array) +
                '}';
    }

    public static void main(String[] args) {
        NumbersBox<Integer> integerNumbersBox1 = new NumbersBox<>(1, 3, 4, 5, 6, 7, 7);
        System.out.println(integerNumbersBox1.calcAverage());

        NumbersBox<Integer> integerNumbersBox2 = new NumbersBox<>(1, 3, 4, 5, 6, 7, 7);

        NumbersBox<Double> doubleNumbersBox1 = new NumbersBox<>(1.0, 4.0, 2.6, 8.9);

        System.out.println(integerNumbersBox1.isSameAvg(doubleNumbersBox1));

        integerNumbersBox1.isSameAvg(integerNumbersBox2);

        System.out.println(getFirstElement(doubleNumbersBox1));
    }
}
