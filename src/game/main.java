package game;

import java.util.Scanner;

/**
 *
 * @author huseyin
 */
public class main {
    public static int gameSize=8;
    public static Entity[][] map = new Entity[gameSize][gameSize];
    public static int monsterCount=gameSize-1;
    public static Player player = new Player();
    public static int pY = 0;
    public static int pX = 0;
    public static Scanner sc= new Scanner(System.in);
    public static void initGame(){
    //Haritadaki tüm alanları boş entity instance ile doldur.
        for (int i = 0; i < gameSize; i++) {
            for (int j = 0; j < gameSize; j++) {
                map[i][j]=new Entity();
            }
        }
        //0x0'a player yerleştirilir.
        map[0][0]= player;
        for (int i = 1; i < gameSize; i++) {
            int r = (int) (Math.random() * 2);
            int rx= (int) (Math.random() * gameSize);
            Entity monster = (r == 0)?new Goblin():new Mamoot();
            map[i][rx]= monster;
        }
    }
    public static void printMap(){
        System.out.println("\n\n");
        for (int i = 0; i < gameSize; i++) {
            for (int j = 0; j < gameSize; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println("");
        }
        System.out.println("\n\n");
    }
    public static void playyerInfo(){
        System.out.println("..::Player::.. ");
        System.out.println("Level : "+player.level
                + "\nHp : "+player.hp
                + "\nDmg : "+player.dmg
                + "\nGold : "+player.goldCnt
                + "\nKill : "+player.killCnt);
    }
    public static void main(String[] args) {
        initGame();
        
        while (monsterCount > 0) {
            printMap();
            playyerInfo();
            System.out.println("Yon : w,a,s,d : ");
            char yon = sc.next().toLowerCase().charAt(0);
            int tempx = pX;
            int tempy = pY;
            switch(yon){
                case 'w': tempx--; break;
                case 's': tempx++; break;
                case 'a': tempy--; break;
                case 'd': tempy++; break;
            }
            if (tempx<0 || tempy <0 || tempx>=gameSize||tempy>=gameSize) {
                continue;
            }
            Entity nextMove = map[tempx][tempy];
            if (nextMove.avatar.equals(" ")) {
                map[pX][pY] = new Entity();
                map[tempx][tempy]= player;
                pX = tempx;
                pY = tempy;
                
            }else {
                System.out.println("Gitmek istediğiniz noktadaBir canavar var Yinede Gitmek istiyormusunuz.(1-Evet, 2-Hayır)");
                int sec = sc.nextInt();
                
                if (sec == 2) {
                    continue;
                } else if(sec ==1) {
                    System.out.println("Savaş Başlıyor...");
                    Entity canavar = map[tempx][tempy];
                    System.out.println("Bir "+ canavar.getClass().getName()+" İle Karşılaştın.");
                    while (true) {                        
                        if (player.hp > 0 && canavar.hp >0 ) {
                            int dmg = (player.dmg/2)*(1+(int)Math.random()*2);
                            canavar.hp-=dmg;
                            if (canavar.hp >0) {
                                int cnvdmg = (canavar.dmg/2)*(1+(int)Math.random()*2);
                                player.hp-=cnvdmg;
                            }
                        } else {
                            if (player.hp < 0) {
                                System.out.println("Öldünüz....");
                                monsterCount = 0;
                                break;
                            }
                            break;
                        }
                    }
                    int altin = 0;
                    if (canavar instanceof Goblin)
                        altin = ((Goblin) canavar).goldDrop;
                    if(canavar instanceof Mamoot)
                        altin = ((Mamoot) canavar).goldDrop;
                    player.goldCnt += altin;
                    player.killCnt += 1;
                    System.out.println("Canavarı Öldürdün, "+altin+" Altın Kazandın");
                    map[pX][pY] = new Entity();
                    map[tempx][tempy]= player;
                    pX = tempx;
                    pY = tempy;
                    monsterCount--;
                    if (player.killCnt%3 < 1) {
                        player.levelUp();
                    }
                }
            }
        }
        if (monsterCount == 0 && player.killCnt >0) {
            System.out.println("Tebrikler");
        }
        else{
            System.out.println("");
        }
    }
}
