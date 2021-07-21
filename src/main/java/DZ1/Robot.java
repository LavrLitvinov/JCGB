package DZ1;

public class Robot implements CanAll {
    private int jumpHight;
    private int runLength;
    private boolean abilityToCompleteTask;

    public Robot(int jumpHight, int runLength, boolean abilityToCompleteTask) {
        this.jumpHight = jumpHight;
        this.runLength = runLength;
        this.abilityToCompleteTask = abilityToCompleteTask;
    }

    @Override
    public void jump(int height, boolean ability) {
        if(abilityToCompleteTask == false){
            System.out.println("Я робот, я уже сошел с дистанции");

        } else {
            if(height > jumpHight ) {
                System.out.println("Я робот, стена высоковата, пружина лопнула");
                abilityToCompleteTask = false;
            } else {
                System.out.println("Я робот, я перепрыгнул стену!");
            }
        }



    }

    @Override
    public void run(int lenght, boolean ability) {
        if(abilityToCompleteTask == false){
            System.out.println("Я робот, я уже сошел с дистанции");

        } else {
            if(lenght > runLength ) {
                System.out.println("Я робот, дорожка длиновата, шарнир заело");
                abilityToCompleteTask = false;
            } else {
                System.out.println("Я робот, я все пробежал!!");
            }
        }

    }

    }

