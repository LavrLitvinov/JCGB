package lesson9.lambda;
@FunctionalInterface
public interface CheckAble {
    boolean test(Animal animal);

    default void test1() {
        System.out.println("default");
    }

    @Override
    String toString();
}
