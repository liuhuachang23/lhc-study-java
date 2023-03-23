package djb.section2;

public class VarTest04
{
	//成员变量
	int k =20;

	//主方法: 入口	
	public static void main(String[] args){
		
		//局部变量
		int i = 10;
		
		//java遵循"就近原则" 输出的i为10
		System.out.println(i);
	}

	//成员变量(不同类体里面 变量名可以相同)
	int i =100;
}