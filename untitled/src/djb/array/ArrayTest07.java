package djb.array;
/*
* 一维数组的深入：数组中存储的类型为引用数据类型
*
* 对于数组来说，实际上只能存储java对象的"内存地址"，数组中存储的每个元素是"引用"
* */
public class ArrayTest07 {
    public static void main(String[] args) {
        //创建一个Animal类型的数组
        Animal a1 = new Animal();
        Animal a2 = new Animal();
        Animal[] animals = {a1,a2};

        //对Animal数组进行遍历
        for (int i = 0; i <animals.length ; i++) {
            //Animal a = animals[i];
            //a.move();
            //代码合并
            animals[i].move();
        }

        //动态初始化一个长度为2的Animal类型的数组
        Animal[] ans = new Animal[2];
        //创建一个Animal对象，放到数组的第一个盒子中
        ans[0] = new Animal();

        //Animal数组中可以存放Cat类型的数组，因为Cat是一个Animal，Cat是Animal的子类。
        ans[1] = new Cat();

        //创建一个Animal类型的数组，数组中存储Cat和Bird
        Animal[] anis = {new Cat(),new Bird()};     //该数组中存储了两个对象的内存地址。
        for (int i = 0; i <anis.length ; i++) {
            //取出来的ansi[i]可能是一个Cat也可能是个Bird，但一定是一个Animal
            //如果调用的方法在父类型中存在，则不需要向下转型，直接使用父类型引用调用即可
            Animal an = anis[i];
            an.move();

            //如果想要调用子类型中特有的方法，则需要向下转型
            if (anis[i] instanceof Cat){
                Cat cat = (Cat)anis[i];
                cat.catchMouse();
            }else if (anis[i] instanceof Bird){
                Bird bird = (Bird)anis[i];
                bird.sing();
            }
        }

    }
}

class Animal{
    public void move(){
        System.out.println("Animal move...");
    }
}

class Cat extends Animal{
    public void move(){
        System.out.println("猫在走猫步");
    }
    //猫类特有的方法
    public void catchMouse(){
        System.out.println("猫抓老鼠");
    }
}

class Bird extends Animal{
    public void move(){
        System.out.println("鸟儿在飞翔");
    }
    //鸟类特有方法
    public void sing(){
        System.out.println("鸟儿在唱歌");
    }
}