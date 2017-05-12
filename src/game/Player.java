package game;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author huseyin
 */
public class Player extends Entity{
    public int goldCnt = 0, killCnt=0, level=1;
    public Player(){
        avatar = "\u263A";
        hp = 100;
        dmg = 25;
    }
    public void levelUp(){
        level +=1;
        hp = 100+(level*10);
        dmg += 2;
    }
}
