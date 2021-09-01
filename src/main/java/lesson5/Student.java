package lesson5;


import java.io.Serializable;

public class Student implements Serializable {
    private String nameOfStudent;
    private String surname;
    private Integer age;
    private transient String bankCard = "1233 1234 1244 2355";
    private String girlFriendName;

    public Student(String nameOfStudent, String surname, Integer age, String bankCard, String girlFriendName) {
        this.nameOfStudent = nameOfStudent;
        this.surname = surname;
        this.age = age;
        this.bankCard = bankCard;
        this.girlFriendName = girlFriendName;
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public String getGirlFriendName() {
        return girlFriendName;
    }

    public void setGirlFriendName(String girlFriendName) {
        this.girlFriendName = girlFriendName;
    }

    public Student(String nameOfStudent, String surname, Integer age) {
        this.nameOfStudent = nameOfStudent;
        this.surname = surname;
        this.age = age;
    }

    public String getNameOfStudent() {
        return nameOfStudent;
    }

    public void setNameOfStudent(String nameOfStudent) {
        this.nameOfStudent = nameOfStudent;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return nameOfStudent + " " + surname + " " + age + " " + bankCard;
    }
}