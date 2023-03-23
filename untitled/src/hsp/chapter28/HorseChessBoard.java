package hsp.chapter28;

import java.awt.*;
import java.util.ArrayList;

/**
 * @Author: 刘华昌
 * @DATE: 2022/5/17 20:31 星期二
 * @Operating:
 * @Description: 骑士周游问题
 * 思路分析：
 * 1. 创建棋盘一个棋盘 chessBoard （二维数组）
 * 2. 将当前位置设置为已经访问，然后根据当前位置，计算马儿还能走哪些位置，
 * 并放入到一个ArrayList集合中，最多为8个可走位置，每走一步 使用step+1 记录当前位置的步号
 * 3. 遍历 ArrayList 中存放的所有位置，看一看那个位置可以走，如果可以走就继续，走不通就回溯
 * 重新选择 ArrayList中存放的其他位置  （第三步使用递归回溯，直到走完 或者到死路 ）
 * 4. 判断马儿是否完成了任务，使用 step 和 应该走的步数 去比较，如果没有达到数量，则表示任务失败，将整个棋盘置0
 */
public class HorseChessBoard {

    //定义属性
    private static int Y = 6; //表示row 行
    private static int X = 6; //表示col 列
    private static int[][] chessBoard = new int[Y][X]; //表示 棋盘
    private static boolean[] visited = new boolean[Y * X]; // 记录某个位置是否走过
    private static boolean finished = false; //判断马儿是否遍历完棋盘

    public static void main(String[] args) {
        //设置起始点
        int row = 5;
        int col = 5;
        //测试一把
        traversalChessBoard(chessBoard, row - 1, col - 1, 1);

        //输出当前棋盘的情况
        //说明：第一个for 遍历Y，第二个for 遍历X , 这样就输出了整个棋盘
        for (int[] rows : chessBoard) {
            for (int step : rows) { //step 表示该位置是马儿应该走的第几个位置
                System.out.print(step + "\t");
            }
            System.out.println();
        }

    }

    /**
     * 周游棋盘 把马儿走的每一步step，记录到 chessBoard
     * 如果周游成功，就把finished 设置为true
     *
     * @param chessBoard 棋盘
     * @param rows       行 (Y)
     * @param col        列 (X)
     * @param step       步号(第几步，起始位置步号为1)
     */
    public static void traversalChessBoard(int[][] chessBoard, int rows, int col, int step) {

        //1) 把step 记录到 chessBoard
        //说明：就是将当前位置 的棋盘位置编号 记录为step
        //    （每走一步记录一个step，step走一步自增1，即：起始位置为1，下一步为2，...）
        chessBoard[rows][col] = step;

        //2) 把这个位置设置为已经访问
        //说明：二维数组chessBoard[rows][col] 的位置 就是对应 一维数组visited[rows * 6 + col] 的这个位置
        visited[rows * X + col] = true;

        //3) 获取当前位置 下一个可以走的位置
        //说明:创建的Point对象 构造器为： point(int x, int y){}
        //    所以 第一个参数为col 第二个为rows
        ArrayList<Point> points = next(new Point(col, rows));
        //遍历
        while (!points.isEmpty()) {
            //取出一个位置(点)
            //说明：points.remove(0) 删除一个点 并返回该点
            Point p = points.remove(0);
            //判断该位置是否走过，如果没有走 , 就继续让他走(递归遍历)
            if (visited[p.y * X + p.x]) {
                //如果没有走过，就递归遍历
                traversalChessBoard(chessBoard, p.y, p.x, step + 1);
            }
        }
        //出了while循环，就去判断，这个棋盘的step是否已经到达了 32(Y*X)步
        // 如果没有成功就重置棋盘上相应的值(step = 0),进行回溯
        if (step < X * Y && !finished) {
            //重置
            chessBoard[rows][col] = 0;
            //将
            visited[rows * X + col] = false;
        } else { //如果 到达了 32(Y*X)步 ,finished设置为true
            finished = true;
        }

    }


    /**
     * 编写方法，获取当前位置，下一步可以走的所有位置, 并存放在集合中
     *
     * @param curPoint 当前位置
     * @return ArrayList集合 存放下一步可以走的位置
     */
    public static ArrayList<Point> next(Point curPoint) {

        //创建一个集合
        ArrayList<Point> points = new ArrayList<>();
        //创建一个Point对象(点/位置)
        Point p = new Point();

        //判断当前位置(curPoint) 是否可以走如下位置，如果可以就将该点(p) 放入集合(points) 中
        //思路：在棋盘上马走日，即最多有8个位置可以选，我们可以根据当前位置，获取这8个点，并判断这8个点是否可以走

        //判断是否可以走1
        if ((p.x = curPoint.x - 2) >= 0 && (p.y = curPoint.y - 1) >= 0) {
            points.add(new Point(p)); //这里要根据p坐标 创建一个新的点，添加进去，不要直接添加p
        }
        //判断是否可以走2
        if ((p.x = curPoint.x - 1) >= 0 && (p.y = curPoint.y - 2) >= 0) {
            points.add(new Point(p)); //这里要根据p坐标 创建一个新的点，添加进去，不要直接添加p
        }
        //判断是否可以走3
        if ((p.x = curPoint.x + 1) < X && (p.y = curPoint.y - 1) >= 0) {
            points.add(new Point(p)); //这里要根据p坐标 创建一个新的点，添加进去，不要直接添加p
        }
        //判断是否可以走4
        if ((p.x = curPoint.x + 2) < X && (p.y = curPoint.y - 1) >= 0) {
            points.add(new Point(p)); //这里要根据p坐标 创建一个新的点，添加进去，不要直接添加p
        }
        //判断是否可以走5
        if ((p.x = curPoint.x + 2) < X && (p.y = curPoint.y + 1) < Y) {
            points.add(new Point(p)); //这里要根据p坐标 创建一个新的点，添加进去，不要直接添加p
        }
        //判断是否可以走6
        if ((p.x = curPoint.x + 1) < X && (p.y = curPoint.y + 2) < Y) {
            points.add(new Point(p)); //这里要根据p坐标 创建一个新的点，添加进去，不要直接添加p
        }
        //判断是否可以走7
        if ((p.x = curPoint.x - 1) >= 0 && (p.y = curPoint.y + 2) < Y) {
            points.add(new Point(p)); //这里要根据p坐标 创建一个新的点，添加进去，不要直接添加p
        }
        //判断是否可以走8
        if ((p.x = curPoint.x - 2) >= 0 && (p.y = curPoint.y + 1) < Y) {
            points.add(new Point(p)); //这里要根据p坐标 创建一个新的点，添加进去，不要直接添加p
        }
        //返回这个集合
        return points;
    }

}
