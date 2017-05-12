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
public class Mamoot extends Entity{
    public int goldDrop=0;
    public Mamoot(){
        hp=60;
        dmg=15;
        avatar = "\u2660";
        goldDrop= (int) (20 + (21 * Math.random()));
    }
}
