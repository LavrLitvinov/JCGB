package lesson9.lambda;

public class Animal {
    private String name;
    private boolean canJump;
    private boolean canRun;

    public Animal(String name, boolean canJump, boolean canRun) {
        this.name = name;
        this.canJump = canJump;
        this.canRun = canRun;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCanJump() {
        return canJump;
    }

    public void setCanJump(boolean canJump) {
        this.canJump = canJump;
    }

    public boolean isCanRun() {
        return canRun;
    }

    public void setCanRun(boolean canRun) {
        this.canRun = canRun;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", canJump=" + canJump +
                ", canRun=" + canRun +
                '}';
    }
}
