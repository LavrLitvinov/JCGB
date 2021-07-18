package DZ1;

public class DZ1 {
    public static void main(String[] args) {

        CanAll[] canalls = {new Cat(26, 19, true),
                new Human(8, 19, true),
                new Robot(16, 17, true)};

        Overskiprunable[] overskiprunables = {new Treadmill(5), new Barrier(12), new Treadmill(17),
                new Barrier(16), new Barrier(9), new Treadmill(15), new Barrier(29)};

        for (CanAll canable : canalls) {
            for (Overskiprunable overrun : overskiprunables) {
                overrun.overskiprun(canable);

            }
        }


    }
}
