package entity;

public class Student {

    private String name;
    private String npm;
    private String address;

    public Student(String name) {
        this.name = name;
        this.npm = "0";
        this.address = "No address";
    }

    public Student() {
        this(null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
