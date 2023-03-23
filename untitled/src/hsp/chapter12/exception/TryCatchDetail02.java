package hsp.chapter12.exception;
//可以有多个catch语句，捕获不同的异常（进行不同的业务处理），要求父类异常在后面
//子类异常在前面。如果发生异常，只会匹配一个catch
public class TryCatchDetail02 {
    public static void main(String[] args) {

        try {
            Person person = new Person();
            //person = null;
            System.out.println(person.getName()); //NullPointerException
            int n1 = 10;
            int n2 = 0;
            int res = n1 / n2; //ArithmeticException
        } catch (NullPointerException e) {
            System.out.println("空指针异常" + e.getMessage());
        } catch (ArithmeticException e){
            System.out.println("算数异常" + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
        }

    }
}

class Person{
    private String name = "jack";

    public String getName(){
        return name;
    }
}