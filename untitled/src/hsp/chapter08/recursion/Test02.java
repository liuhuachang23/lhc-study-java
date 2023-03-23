package hsp.chapter08.recursion;
/*
使用递归方法：迷宫问题

    在一个由若干个单位正方形组成的矩形框中，8排7列
    矩形四边的正方形都为障碍物，其中第4排（从上面数）前3个矩形也是障碍物
    起始位置：2排2列的方块上
    出口位置：7排6列方块上

    求出走出迷宫的最短路经

    //意外问题：为什么way1、way2同时用时，迷宫都是走way1路线

 */
public class Test02 {
    public static void main(String[] args) {
        //先创建一个二维数组表示迷宫 int[][] map = new int[8][7]
        int[][] map = new int[8][7];

        //规定map数组的元素值，0 表示可以走，1 表示障碍物
        //开始创建迷宫：
        //将数组第一排和最后一排都改为1
        for (int i = 0; i <7 ; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //将第一列和最后一列也改为1
        for (int i = 0; i <8 ; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //在将4排2列和4排3列的两个正方形改为1
        map[3][1] = 1;
        map[3][2] = 1;
        //在增加1个障碍物
        map[2][2] = 1;

        //输出迷宫
        System.out.println("======地图情况======");
        for (int i = 0; i <map.length ; i++) {
            for (int j = 0; j <map[i].length ; j++) {
                System.out.print(map[i][j] + "  ");
            }
            System.out.println();
        }
        //创建对象
        Run run = new Run();
        //走法一(几种方法不要同时进行,仔细分析,理解递归回溯问题)
        run.way1(map, 1, 1,0);
        //第二种走法（仔细分析这个才能完全理解这个递归执行顺序）
        //run.way2(map,1,1,0);
        //遍历
        System.out.println("======出宫情况1======");
        for (int i = 0; i <map.length ; i++) {
            for (int j = 0; j <map[i].length ; j++) {
                System.out.print(map[i][j] + "  ");
            }
            System.out.println();
        }
    }
}

class Run {
    //用递归回溯的方法解决老鼠出宫
    //如果找到就返回 true，没有就false
    //map[][]就表示迷宫
    //int i, int j 表示当前老鼠的位置（1，1）
    //如果老鼠可以到达map[6][5]，这个位置，则表示已经找到出宫通路了
    //规定：map数组各个值表示的含义：0表示该点没有被走过，1表示障碍物，2表示通路可以走，3表示走过，但是走不通
    //故map[6][5] == 2 的时候表示找到通路了，就可以结束了，否则继续找
    //探路策略：下-->右-->上-->左，如果走不通，在回溯（坐席思考回溯问题）

    /**
     * 用递归回溯找出宫的路
     * @param map 表示地图
     * @param i 从哪个位置开始查找
     * @param j 从哪个位置开始查找
     * @param k 表示走过的路径
     * @return 如果找到通路,返回true,否则返回false
     */
    public boolean  way1(int[][] map,int i, int j,int k){
        if (map[6][5] == 2){ //当（6，5）这个位置被赋值为2之后 说明老鼠已经来过 故已经找到出路
            System.out.println(k);
            return true;

        } else {
            if (map[i][j] == 0){//表示可以走，但是没有走过
                //假设可以走通
                map[i][j] = 2;

                //制定策略，来确定是否可以走通
                // 下-->右-->上-->左
                //使用递归
                if (way1(map, i + 1, j, k + 1)){ //先向下试
                    return true;
                } else if (way1(map, i, j + 1,k+1)){ //向右
                    return true;
                }else if (way1(map, i - 1, j,k+1)){ //向上
                    return true;
                }else if (way1(map, i, j - 1,k+1)){ //向左
                    return true;
                } else {
                    //不通，返回false
                    map[i][j] = 3;
                    return false;
                }
            } else { //map[6][5] == 1、2、3  尝试的路遇到没有到达（6，5）
                return false;
            }
        }
    }

    //第二种走发：上-->右-->下-->左
    public boolean  way2(int[][] map,int i, int j, int k){
        if (map[6][5] == 2){ //当（6，5）这个位置被赋值为2之后 说明老鼠已经来过 故已经找到出路
            return true;
        } else {
            if (map[i][j] == 0){//表示可以走，但是没有走过
                //假设可以走通
                map[i][j] = 2;
                //制定策略，来确定是否可以走通
                // 上-->右-->下-->左
                //使用递归
                if (way2(map, i - 1, j, k + 1)){ //先向上试
                    return true;
                } else if (way2(map, i, j + 1, k + 1)){ //向右
                    return true;
                }else if (way2(map, i + 1, j, k + 1)){ //向下
                    return true;
                }else if (way2(map, i, j - 1, k + 1)){ //向左
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else { //map[6][5] == 1、2、3  尝试的路遇到没有到达（6，5）
                return false;
            }
        }
    }
}