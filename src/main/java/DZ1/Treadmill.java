package DZ1;

public class Treadmill implements Overskiprunable {
    private int length;
    private boolean abiliti;

    public Treadmill(boolean abiliti) {
        this.abiliti = abiliti;
    }

    public Treadmill(int length) {
        this.length = length;
    }

    public void overskiprun(CanAll canalls) {
        canalls.run(length, abiliti);
    }
}
