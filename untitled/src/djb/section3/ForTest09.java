/*
public class ForTest09
{
	public static void main(String[] args){

		int i,j;
		
		for(i = 2;i <= 100;i++){

			for(j = 2;j < i;j++){

				if(i % j == 0)
					break;
			}

			if(j >= i)
				System.out.print(i + " ");
		}
	}
}
*/
public class ForTest09
{
	public static void main(String[] args){

		int i,j,k;
		k = 0;
		
		for(i = 2;i <= 100;i++){

			for(j = 2;j < i;j++){

				if(i % j == 0)
					break;
			}

			if(j >= i){
				System.out.print(i + " ");
				k++;
				if(k % 8 == 0){
					System.out.print("\n");
				}
				

			}
		}
	}
}