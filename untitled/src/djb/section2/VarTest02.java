public class VarTest02
{
	public static void main(String[] args){
		
		//声明赋值
		int i = 10;

		//输出
		System.out.println(i);
		
		//修改变量值
		i = 20;
		
		//输出
		System.out.println(i);

		//这种写法是错误的，变量名不能重复使用，也不会被当作是修改变量值，编译器报错
		//int i = 30;
		System.out.println(i);
	}
}