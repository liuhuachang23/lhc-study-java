package djb.section4;

public class OOTest06 {
	public static void main(String[] args){
		
		// 创建学生对象
		Student xiaoMing = new Student();

		xiaoMing.name = "小明";

		//创建笔记本对象
		Computer biJiBen = new Computer();

		biJiBen.pinpai = "惠普";
		
		//链接学生与笔记本
		xiaoMing.c = biJiBen;
		
		//想知道小明笔记本的品牌
		System.out.println(xiaoMing + "使用的笔记本是" + xiaoMing.c.pinpai);

		//修改笔记本的品牌
		xiaoMing.c.pinpai = "苹果";
		
		//想知道小明笔记本的品牌
		System.out.println(xiaoMing + "使用的笔记本是" + xiaoMing.c.pinpai);

		
	}	
}