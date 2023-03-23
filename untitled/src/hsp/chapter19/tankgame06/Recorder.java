package hsp.chapter19.tankgame06;


import java.io.*;
import java.util.Vector;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/6 20:38
 * @Description: 记录相关信息, 和文件交换
 */
public class Recorder {

    //定义变量,记录我方击毁敌方坦克数
    private static int allEnemyTankNum = 0;

    //定义IO对象,用于写数据到文件中
    private static BufferedWriter bw = null;
    private static BufferedReader br = null;
    private static ObjectOutputStream oos = null;
    private static String recordFile = "d:\\myRecord.txt";

    //定义Vector ,指向 MyPanel 对象的 敌人坦克Vector
    private static Vector<EnemyTank> enemyTanks = new Vector<>();
    public static void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        Recorder.enemyTanks = enemyTanks;
    }

    //定义一个Vector 用于保存 Node 对象
    private static Vector<Node> nodes = new Vector<>();

    //增加一个方法用于读取recordFile文件, 恢复相关信息
    //该方法在继续上局继续的时候调用,在MyPanel 中调用
    public static Vector<Node> getNodesAndEnemyTankRec() {
        try {
            br = new BufferedReader(new FileReader(recordFile));
            allEnemyTankNum = Integer.parseInt(br.readLine());
            //循环读取,敌人坦克的(x,y,d), 生成node集合
            String line;
            while ((line = br.readLine()) != null) {
                String[] xyd = line.split(" ");
                Node node = new Node(Integer.parseInt(xyd[0]), Integer.parseInt(xyd[1]),
                        Integer.parseInt(xyd[2]));
                nodes.add(node);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return nodes;
    }

    //增加一个方法,记录当游戏退出时,记录allEnemyTankNum 到文件 recordFile
    //增加功能,记保存敌人坦克的坐标和方向
    public static void keepRecord() {
        try {
            bw = new BufferedWriter(new FileWriter(recordFile));
            bw.write(allEnemyTankNum + "\r\n");
            for (int i = 0; i < enemyTanks.size(); i++) {
                EnemyTank enemyTank = enemyTanks.get(i);
                if (enemyTank.isLive()) {
                    String record = enemyTank.getX() + " " + enemyTank.getY() + " " + enemyTank.getD();
                    bw.write(record + "\r\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static int getAllEnemyTankNum() {
        return allEnemyTankNum;
    }

    public static void setAllEnemyTankNum(int allEnemyTankNum) {
        Recorder.allEnemyTankNum = allEnemyTankNum;
    }

    //当我方坦克击毁一辆敌方坦克时,allEnemyTankNum就加1
    public static void addAllEnemyTankNum() {
        Recorder.allEnemyTankNum++;
    }
}
