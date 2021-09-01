package lesson9.lambda;

public class CheckIsJumper implements CheckAble  {
    @Override
    public boolean test(Animal animal) {
        return animal.isCanJump();
    }
}
