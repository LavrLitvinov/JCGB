package DZ1;

public class Human implements CanAll {
    private int jumpHight;
    private int runLength;
    private boolean abilityToCompleteTask;

    public Human(int jumpHight, int runLength, boolean abilityToCompleteTask) {
        this.jumpHight = jumpHight;
        this.runLength = runLength;
        this.abilityToCompleteTask = abilityToCompleteTask;
    }

    @Override
    public void jump(int height, boolean ability) {

        if (abilityToCompleteTask == false) {
            System.out.println("Я человек, я уже сошел с дистанции");

        } else {
            if (height > jumpHight) {
                System.out.println("Я человек, стена высоковата, пусть робот лезет");
                abilityToCompleteTask = false;
            } else {
                System.out.println("Я человек, я перепрыгнул стену!");
            }
        }


    }

    @Override
    public void run(int lenght, boolean ability) {
        if (abilityToCompleteTask == false) {
            System.out.println("Я человек, я уже сошел с дистанции");

        } else {
            if (lenght > runLength) {
                System.out.println("Я человек, дорожка длиновата, пусть кот пробежит");
                abilityToCompleteTask = false;
            } else {
                System.out.println("Я человек, я все пробежал!!");
            }
        }

    }

}

