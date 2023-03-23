package hsp.chapter11.homework;

public class Homework05 {
    public static void main(String[] args) {
        Car car = new Car(20);
        car.getAir().flow();

    }
}

class Car{
    private double temperature;

    public Car(double temperature) {
        this.temperature = temperature;
    }

    class Air{
        public void flow(){
            if (temperature >= 40){
                System.out.println("空调吹冷气");
            } else if (temperature < 0){
                System.out.println("空调吹暖气");
            } else {
                System.out.println("关闭空调");
            }
        }
    }

    public Air getAir(){
        return new Air();
    }
}
