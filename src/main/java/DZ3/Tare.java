package DZ3;

import java.util.ArrayList;

public class Tare<T extends Fruit> {
    private ArrayList fruitList = new ArrayList();
    private Tare<?> tareForCompare;

    public Tare() {
    }

    @Override
    public String toString() {
        return "Tare{" +
                "fruitList=" + fruitList +
                '}';
    }

    public ArrayList getFruitList() {
        return fruitList;
    }

    public void setFruitList(ArrayList fruitList) {
        this.fruitList = fruitList;
    }

    public void increazeFruit(T fruit) {
        fruitList.add(fruit);
    }

    public float getWeights() {

        float i;
        i = fruitList.size() * fruitList.get(0).getWeight();
        return i;
    }

    public boolean compare(Tare<?> tareForCompare) {
        double delta = 0.0001;
        return Math.abs(getWeights()) - tareForCompare.getWeights()) <= delta;
    }

    public void relaseTare(Tare<T> bigTare) {
        if (fruitList.size() == 0){
            System.out.println("Пересыпать нечего, коробка пуста.");

        } else {
            bigTare.getFruitList().addAll(fruitList);
            fruitList.clear();
        }

    }

}

