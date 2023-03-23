package hsp.chapter11.homework;

class Homework06 {
    public static void main(String[] args) {
        Color green = Color.GREEN;
        green.show();

        switch (green){
            case GREEN:
                System.out.println("匹配到绿色");
                break;
            case RED:
                System.out.println("匹配到红色");
                break;
            case BLUE:
                System.out.println("匹配到蓝色");
                break;
            case BLACK:
                System.out.println("匹配到绿黑色");
                break;
            case YELLOW:
                System.out.println("匹配到黄色");
                break;
        }
    }
}

enum Color implements IA{
    RED(255,0,0),BLUE(0,0,255),
    BLACK(0,0,0),YELLOW(255,255,0),
    GREEN(0,255,0);

    private int redValue;
    private int greenValue;
    private int blueValue;

    Color(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    @Override
    public void show() {
        System.out.println("属性的值为" + redValue + "," + greenValue + "," + blueValue);
    }
}

interface IA{
    void show();
}
