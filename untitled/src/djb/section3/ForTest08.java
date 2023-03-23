/*
使用for循环输出九九乘法表

1*1=1
2*1=2 2*2=4
3*1=3 3*2=6 3*3=9
...................
9*1=9 .................... 9*9=81
*/

public class ForTest08
{
	public static void main(String[] args){
		for(int i = 1;i <= 9;i++){
			for(int j = 1;j <= i;j++){
			
				System.out.print(i + "*" + j + "=" + (i * j) + " ");
			
			}
			
			System.out.print("\n");
			
		}
	}
}