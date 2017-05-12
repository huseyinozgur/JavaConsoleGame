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
public class Goblin extends Entity {
    public int goldDrop=0;
    public Goblin(){
        hp=60;
        dmg=15;
        avatar = "\u2666";
        goldDrop= (int) (30 + (31 * Math.random()));
    }
}
