package djb.object.string;

public class Test2 {
    public static void main(String[] args) {

        //创建学生对象
        Student s1 = new Student(111,"动力节点");
        Student s2 = new Student(111,"动力节点");

        System.out.println(s1.equals(s2));

    }
}

class Student{

    int no;         //用"=="比较
    String school;  //用equals比较

    public Student(){}

    public Student(int no , String school){
        this.no = no;
        this.school = school;
    }

    //重写toString方法
    public String toString(){
        return "学号" + no + "学校名称" + school;
    }

    //重写equals方法
    //需求：当一个学生学号相等，并且学校相同，表示同一个学生。
    public boolean equals(Object obj){
        if (obj == null || !(obj instanceof Student) ){
            return false;
        }
        if (this == obj){
            return true;
        }
        Student s = (Student)obj;
        if (s.no == this.no && this.school.equals(s.school)) {
            return true;
        }
        return false;
    }
}
