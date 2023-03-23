package hsp.chapter13.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"all"})
public class Homework01 {
    public static void main(String[] args) {

        List list = new ArrayList();
        list.add(new News("新冠确诊病历超千万,数百万印度教信徒赴恒河 “圣浴” 引起民众担忧"));
        list.add(new News("男子突然想起2月前钓的鱼还在网兜里，捞起一看赶紧放生"));
        list.add(new News("湖人总冠军"));
        Collections.reverse(list);
        for (Object o : list){
            News o1 = (News) o;
            if (o1.getTitle().length()>15){
                System.out.println("title: " + o1.getTitle().substring(0,15) + "...");
            } else {
                System.out.println(o1);
            }
        }
    }
}

class News{
    private String title;
    private String content;

    public News(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "title: " + title;
    }
}
