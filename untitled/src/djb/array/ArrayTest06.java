package djb.array;
/*
* 模拟一个系统，假设这个系统要使用，必须输入用户名和密码。
*
*   注意：这个程序是要在控制台上向String[] args 传入参数的
*        使用IDEA工具时这个传参可以在软件内完成：
*           Run -----> Edit Configurations ----->Program arguments ------>输入参数
* */
public class ArrayTest06 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("请输入参数，参数包括用户名和密码，如 zhangsan 123");
            return;
        }
        //用户可以执行到这里说明已经输入了用户名和密码
        //先取出用户名
        String username = args[0];
        String password = args[1];
        //接下就要判断用户名和密码是否正确

        //这里有一个编程经验:
        // 可以将下面if（）里面的代码换成：admin.equals("username") && 123.equals("password")
        //这样反过来写，即使username和password都是null，可以避免空指针异常
        if (username.equals("admin") && password.equals("123")){
            System.out.println("登录成功，欢迎 " + username + " 回来");
        }else {
            System.out.println("验证失败，用户名不存在或密码错误");
        }
    }
}
