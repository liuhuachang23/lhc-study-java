/*
public class IfTest01
{
	public static void main(String[] args){
	 
		int grade = 90;

		if (grade >= 90){
			System.out.println('A');
		}else if (grade >= 80){
			System.out.println('B');
		}else if (grade >= 70){
			System.out.println('C');
		}else if (grade >= 60){
			System.out.println('D');
		}else{
			System.out.println('E');
		}
	}
}
*/
public class IfTest01
{
	public static void main(String[] args){
		
		int soore = 30;

		String grade = "该考生的考试成绩等级是：E等级";

		if (soore <0 || soore >100){
			grade = "该考生的考试成绩等级是：E等级";
		}else if (soore >= 90){
			grade = "该考生的考试成绩等级是：A等级";
		}else if (soore >= 80){
			grade = "该考生的考试成绩等级是：B等级";;
		}else if (soore >= 70){
			grade = "该考生的考试成绩等级是：C等级";
		}else if (soore >= 60){
			grade = "该考生的考试成绩等级是：D等级";
		}
		System.out.println(grade);
	}
}
