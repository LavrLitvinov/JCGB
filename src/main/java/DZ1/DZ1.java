package DZ1;

public class DZ1 {
    public static void main(String[] args) {

        CanAll[] canalls = {new Cat(1, 1, true),
                new Human(2,3,true),
                new Robot(1, 25, true)};

        Overskiprunable[] overskiprunables = {  new Treadmill(5),new Barrier(12)};

        for (CanAll canable : canalls) {
            for (Overskiprunable overrun : overskiprunables){
                overrun.overskiprun(canable);

            }
        }


    }
}
