package hsp.chapter12.exception;

public class Homework01 {
    public static void main(String[] args) {

        try {
            if (args.length != 2) {
                throw new ArrayIndexOutOfBoundsException("参数个数不对");
            }
            int n1 = Integer.parseInt(args[0]);
            int n2 = Integer.parseInt(args[1]);
            cal(n1, n2);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("参数格式不正确，需要输入数字 " + e.getMessage());
        } catch (ArithmeticException e){
            System.out.println("算数格式异常 " + e.getMessage());
        }


    }

    public static void cal(int n1, int n2) {
        System.out.println("result = " + n1/n2);
    }
}
