package lesson3.houseAtTree;

public class HouseAtTree<T extends Animal & Flyable> {
    private T master;

    public HouseAtTree(T master) {
        this.master = master;
    }

    public T getMaster() {
        return master;
    }

    public void setMaster(T master) {
        this.master = master;
    }

    public static void main(String[] args) {
        //HouseAtTree<Cat> catHouseAtTree = new HouseAtTree<>(new Cat());
        //HouseAtTree<Plane>
        HouseAtTree<Bird> birdHouseAtTree = new HouseAtTree<>(new Bird());
    }
}
