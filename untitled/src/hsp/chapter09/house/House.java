package hsp.chapter09.house;

import java.util.Objects;

public class House{

    //房屋基本信息
    private int id;
    private String name;
    private String tel;
    private String address;
    private double monthly;
    private String state;

    public House(int id, String name, String tel, String address, double monthly, String state) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.address = address;
        this.monthly = monthly;
        this.state = state;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getMonthly() {
        return monthly;
    }

    public void setMonthly(double monthly) {
        this.monthly = monthly;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return id == house.id &&
                Double.compare(house.monthly, monthly) == 0 &&
                Objects.equals(name, house.name) &&
                Objects.equals(tel, house.tel) &&
                Objects.equals(address, house.address) &&
                Objects.equals(state, house.state);
    }

    @Override
    public String toString() {
        return
                id +
                "\t\t" + name +
                "\t\t" + tel +
                "\t\t" + address +
                "\t\t" + monthly +
                "\t\t" + state ;
    }
}
