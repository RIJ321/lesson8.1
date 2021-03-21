package kg.geektech.les8.players;

public class Tank extends Hero {
    public Tank(int health, int damage) {
        super(health, damage, SuperAbility.SMALL_DAMAGE);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        int smallHit = boss.getDamage() / 5;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() != 0)
                heroes[i].setHealth(heroes[i].getHealth() + smallHit);
            else
                heroes[i].setHealth(0);
        }
        this.setHealth(this.getHealth() - (smallHit * (heroes.length - 1)));
        System.out.println("Tank take: " + (smallHit * (heroes.length - 1)));
    }
}
