package DZ1;

public class Cat implements CanAll {
    private int jumpHight;
    private int runLength;
    private  boolean abilityToCompleteTask;

    public Cat(int jumpHight, int runLength, boolean abilityToCompleteTask) {
        this.jumpHight = jumpHight;
        this.runLength = runLength;
        this.abilityToCompleteTask = abilityToCompleteTask;
    }

    @Override
    public void jump(int height, boolean abiliti) {
        if(abilityToCompleteTask == false){
            System.out.println("Я кот, я уже сошел с дистанции");

        } else {
            if(height > jumpHight ) {
                System.out.println("Я кот, стена высоковата, не смог перепрррррр");
                abilityToCompleteTask = false;
            } else {
                System.out.println("Я кот, я перепрыгнул стену!");
            }
        }


    }

    @Override
    public void run(int lenght, boolean abiliti ) {
        if(abilityToCompleteTask == false){
            System.out.println("Я кот, я уже сошел с дистанции");

        } else {
            if(lenght > runLength ) {
                System.out.println("Я кот, дорожка длиновата, надоело");
                abilityToCompleteTask = false;
            } else {
                System.out.println("Я кот, я все пробежал!!");
            }
        }

    }
}
