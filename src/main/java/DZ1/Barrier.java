package DZ1;

public class Barrier implements Overskiprunable {
    private int height;
    private boolean abiliti;

    public Barrier(boolean abiliti) {
        this.abiliti = abiliti;
    }

    public Barrier(int height) {
        this.height = height;
    }

    public void overskiprun(CanAll canalls) {
        canalls.jump(height, abiliti);
    }
}
