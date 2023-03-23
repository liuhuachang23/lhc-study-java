public class DataTypeTest01
{
	public static void main(String[] args){
	
		char c = 'a';
		System.out.println(c);

		//下面 \n 表示一个字符 不属于 字符串，这是一个 “换行符”，属于char类型的数据
		//反斜杠在java语言当中具有转义功能
		char x = '\n';

		//在控制台输出一个“反斜杠字符”
		//第一个反斜杠具有转义功能，将后面的反斜杠转义为普通的反斜杠字符。
		//结论：在java语言当中两反斜杠代表一个普通的反斜杠字符。
		char k = '\\';
		System.out.println(k);
	
		//在控制台上输出一个单引号字符
		//反斜杠具有转义功能，将第二个单引号转义成普通单引号，不会与第一个单引号配对
		//第一个单引号与最后一个单引号配对
		char a = '\'';
		System.out.println(a);

		//同理 在控制台上输出一个"HelloWorld!"
		System.out.println("\"HelloWorld\"");

	}	
}