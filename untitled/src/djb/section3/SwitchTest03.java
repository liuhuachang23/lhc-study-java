/*自己写的
public class SwitchTest03
{
	public static void main(String[] args){
	
		java.util.Scanner s = new java.util.Scanner(System.in);
		System.out.println("欢迎使用简单计算机系统:");

		System.out.print("请输入第一个数字:");
		int num1 = s.nextInt();

		System.out.print("请输入运算符:");
		String operator = s.next();

		System.out.print("请输入第二个数字:");
		int num2 = s.nextInt();


		switch(operator){

			case "+" :
				System.out.println(num1 + operator + num2 + "=" + (num1 + num2));
				break;
			
			case "-" :
				System.out.println(num1 + operator + num2 + "=" + (num1 - num2));
				break;

			case "*" :
				System.out.println(num1 + operator + num2 + "=" + (num1 * num2));
				break;
				
			case "/" :
				System.out.println(num1 + operator + num2 + "=" + (num1 / num2));
				break;
				
			case "%" :
				System.out.println(num1 + operator + num2 + "=" + (num1 % num2));
				break;
			default :
				System.out.println("对不起,计算机不支持这种计算");
		}

	}
}
*/

//老师写的
public class SwitchTest03
{
	public static void main(String[] args){
	
		java.util.Scanner s = new java.util.Scanner(System.in);
		System.out.println("欢迎使用简单计算机系统:");

		System.out.print("请输入第一个数字:");
		int num1 = s.nextInt();

		System.out.print("请输入运算符:");
		String operator = s.next();

		System.out.print("请输入第二个数字:");
		int num2 = s.nextInt();

		int result = 0;

		switch(operator){

			case "+" :
				result = num1 + num2;
				break;
				
			case "-" :
				result = num1 - num2;
				break;

			case "*" :
				result = num1 * num2;
				break;
					
			case "/" :
				result = num1 / num2;
				break;
					
			case "%" :
				result = num1 % num2;
				break;
		}

		System.out.println("运算结果为:" + num1 + operator + num2 + "=" + result);

	}
}
