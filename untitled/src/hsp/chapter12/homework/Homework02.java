package hsp.chapter12.homework;
/**
 * 输入用户名、密码、邮箱，如果信息录入正确，则提示注册成功，否则生成异常对象
 * 要求：
 * (1) 用户名长度为2或3或4
 * (2) 密码的长度为6，要求全是数字  isDigital
 * (3) 邮箱中包含@和.   并且@在.的前面
 * <p>
 * 思路分析
 * (1) 先编写方法 userRegister(String name, String pwd, String email) {}
 * (2) 针对 输入的内容进行校核，如果发现有问题，就抛出异常，给出提示
 * (3) 单独的写一个方法，判断 密码是否全部是数字字符 boolean
 */
public class Homework02 {
    public static void main(String[] args) {
        try {
            userRegister("jack", "532256", "123@.1122");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("注册成功！");

    }

    public static void userRegister(String name, String password, String post) {

        //添加一道关卡
        if (!(name != null && password != null && post != null)) {
            throw new RuntimeException("信息不能为空");
        }

        //第一关
        if (!(name.length() >= 2 && name.length() <= 4)) {
            throw new RuntimeException("用户名长度必须为2~4");
        }

        //第二关
        if (!(password.length() == 6 && isDigital(password))) {
            throw new RuntimeException("用户密码必须为6位数,且必须为数字");
        }

        //第三关
        if (!(post.indexOf("@") > -1 && post.indexOf("@") < post.indexOf("."))) {
            throw new RuntimeException("邮箱中包含@和. 且@在.的前面 ");
        }
    }

    //判断密码是否为数字
    public static boolean isDigital(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] < '0' && chars[i] > '9') {
                return false;
            }
        }
        return true;
    }


}
