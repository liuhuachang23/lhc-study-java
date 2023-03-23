public class DataTypeTest04

{
	public static void main(String[] args){

		int a = 10;
		int b = 010;
		int c = 0x10;

		System.out.println(a); //10
		System.out.println(b); //8
		System.out.println(c); //16
		System.out.println(a + b + c); //34

		//123这个整数型字面值是int类型
		//i变量声明的时候也是int类型
		//int类型的123赋值给int类型的变量i，不存在类型转换
		int i = 123;
		System.out.println(i);

		//456整数型字面值是int类型，占用4个字节
		//x变量在声明的时候是long类型，占用8个字节
		//int类型的字面值456赋值给long类型的变量x，存在类型转换
		//int类型转换为long类型，是小容量转换为大容量
		//小容量转换为大容量可以自动转换，称为自动转换机制。
		long x = 456;
		System.out.println(x);

		//2147483647字面值是int类型，占用4个字节
		//y是long类型，占用8个字节，自动类型转换
		long y = 2147483647;
		System.out.println(y);
	
		//编译错误：过大的整数：2147483648
		//2147483648被当作int类型4个字节处理，但是这个字面值超出int类型范围
		//long z = 2147483648;

		//解决错误
		//2147483648字面值一上来就当做long类型来处理，在字面值后添加L
		//2147483648L是8个字节的long类型
		//z是long类型变量，以下程序不存在类型转换
		long z = 2147483648L;
		System.out.println(z);
	}
}

