package game;


public class Entity {
    public String avatar;
    public int hp,dmg;

    public Entity(String avatar, int hp, int dmg) {
        this.avatar = avatar;
        this.hp = hp;
        this.dmg = dmg;
    }

    public Entity() {
        this.avatar = " ";
        this.dmg=0;
        this.hp = 0;
    }
    
    public boolean isAlive(){
        return hp>0;
    }
    public String toString() {
        return "[ "+avatar+" ]";
    }
}
