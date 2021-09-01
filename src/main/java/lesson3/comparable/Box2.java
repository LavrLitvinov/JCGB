package lesson3.comparable;
import java.util.Arrays;
public class Box2  implements  Comparable<Box2> {
    public int size;

    public Box2(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Box{" +
                "size=" + size +
                '}';
    }

    public static void main(String[] args) {
        Box2 box1 = new Box2(50);
        Box2 box2 = new Box2(10);
        System.out.println(box1.compareTo(box2));

        Box2[] boxes = {new Box2(4), new Box2(2), new Box2(10), new Box2(1)};

        Arrays.sort(boxes);

        System.out.println(Arrays.toString(boxes));
    }

    @Override
    public int compareTo(Box2 o) {
        return size - o.size;
    }

}
