package lesson3;

public class Box {
    private Object object;

    public Box(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "Box{" +
                "object=" + object +
                '}';
    }

    public static void main(String[] args) {
        Box box1 = new Box(5);
        Box box2 = new Box(10);

        System.out.println(box1.getObject().getClass());

        int sum = (Integer) box1.getObject() + (Integer) box2.getObject();
        System.out.println(sum);

        Box box3 = new Box("Test");

        if (box1.getObject() instanceof Integer && box3.getObject() instanceof Integer) {
            int sum2 = (Integer) box1.getObject() + (Integer) box3.getObject();
        }
    }
}
