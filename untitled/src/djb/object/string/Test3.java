package djb.object.string;

/*
* 需求：当用户的姓名及家庭住址一样时，表示同一个用户。
*
* */

public class Test3 {
    public static void main(String[] args) {

        //创建用户对象
        User u1 = new User("张三",new Address("北京","大兴区","11111"));
        User u2 = new User("张三",new Address("北京","大兴区","11111"));

        System.out.println(u1.equals(u2));
    }
}

class User{
    String name;
    Address addr;

    public User() {
    }

    public User(String name, Address addr) {
        this.name = name;
        this.addr = addr;
    }

    //重写equals方法
    public boolean equals(Object obj){
        if (obj == null || !(obj instanceof User)){
            return false;
        }
        if (this == obj){
            return true;
        }
        User u = (User)obj;
        if (this.name.equals(u.name) && this.addr.equals(u.addr)){
            return true;
        }
        return false;
    }

}

class Address{
    String city;
    String street;
    String zipcode;

    public Address() {
    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    //重写equals方法

    public boolean equals(Object obj){

        if (obj == null || !(obj instanceof Address)) return false;
        if (this == obj) return true;
        Address a = (Address) obj;
        if (this.city.equals(a.city) && this.street.equals(a.street) && this.zipcode.equals(zipcode)) return true;
        return false;
    }
}

