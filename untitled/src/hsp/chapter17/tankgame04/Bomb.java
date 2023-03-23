package hsp.chapter17.tankgame04;
/*
* 击中坦克后的爆炸
* */
public class Bomb {
    int x;
    int y;
    int life = 9; //炸弹的生命周期
    boolean isLive = true;

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //减少生命值
    public void lifeDown(){ //配合出现爆炸效果
        if (life > 0){
            life--;
        } else {
            isLive = false;
        }
    }
}
