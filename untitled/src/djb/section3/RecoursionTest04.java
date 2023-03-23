/*
public class RecoursionTest04
{
	public static void main(String[] args){
		
		int n = 5;
		int retValue = method(n);
		System.out.println(retValue);
	}

	public static int method(int n){
		int result = 1;
		for(int i = 1;i <= n;i++){
			result *= i;
		}
		return result;
	}
}
*/

public class RecoursionTest04
{
	public static void main(String[] args){
		
		int n = 5;
		int retValue = method(n);
		System.out.println(retValue);
	}

	public static int method(int n){
		if( n == 1){
			return 1;
		}
		return n * method(n - 1);
	}
}