package lesson9;

import java.util.List;

public class Organization {
    private int id;
    private String name;
    private List<Worker> workerList;

    public Organization(int id, String name, List<Worker> workerList) {
        this.id = id;
        this.name = name;
        this.workerList = workerList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Worker> getWorkerList() {
        return workerList;
    }

    public void setWorkerList(List<Worker> workerList) {
        this.workerList = workerList;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", workerList=" + workerList +
                '}';
    }
}
