package djb.section2;

public class VarTest01
{
	public static void main (String[] args){

		//声明一个int类型的变量，起名i
		int i;

		//给i变量赋值，i变量在这里完成初始化，内存开辟
		i = 100;
		System.out.println(i);

		//i再次重新赋值
		i = 1000;
		System.out.println(i);

		//一行上可以同时声明多个变量
		int a,b,c;
		a = 10;
		b = 20;
		c = 30;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
}